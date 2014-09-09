/**
 *
 */
package algo.leetcode;


/**
 * @author cainwang
 *
 */
public class BestTimeToBuyAndSellStockIII {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] inputs = {1, 2, 3, 2, 1, 4};

        BestTimeToBuyAndSellStockIII solution = new BestTimeToBuyAndSellStockIII();
        int result = solution.maxProfit(inputs);

        System.out.println(result);
    }

    public int maxProfit(int[] prices) {
        int[] bestRun = maxOneTimeProfit(prices, 0, prices.length);
        int[] secondBestRun = maxOneTimeShortProfit(prices, bestRun[0], bestRun[1]);

        int[] trialRun = maxOneTimeProfit(prices, 0, bestRun[0]);
        if (trialRun[2] > secondBestRun[2]) {
            secondBestRun = trialRun;
        }
        trialRun = maxOneTimeProfit(prices, bestRun[1] + 1, prices.length);
        if (trialRun[2] > secondBestRun[2]) {
            secondBestRun = trialRun;
        }

        return bestRun[2] + secondBestRun[2];
    }

    private int[] maxOneTimeProfit(int[] prices, int start, int end) {
        int bestBuy = -1, bestSell = -1, bestProfit = 0;
        int currentLow = start;

        for (int i = start; i < end; i++) {
            int price = prices[i];

            if (i < end - 1 && price < prices[i + 1]) {
                if (price <= prices[currentLow]) {
                    currentLow = i;
                }
            }

            if (i == end - 1 || price > prices[i + 1]) {
                int profit = price - prices[currentLow];

                if (profit > bestProfit) {
                    bestBuy = currentLow;
                    bestSell = i;
                    bestProfit = profit;
                }
            }
        }

        return new int[] {bestBuy, bestSell, bestProfit};
    }

    private int[] maxOneTimeShortProfit(int[] prices, int start, int end) {
        int bestBuy = -1, bestSell = -1, bestProfit = 0;
        int currentHigh = start;

        for (int i = start; i < end; i++) {
            int price = prices[i];

            if (i < end - 1 && price > prices[i + 1]) {
                if (price >= prices[currentHigh]) {
                    currentHigh = i;
                }
            }

            if (i == end - 1 || price < prices[i + 1]) {
                int profit = prices[currentHigh] - price;

                if (profit > bestProfit) {
                    bestBuy = i;
                    bestSell = currentHigh;
                    bestProfit = profit;
                }
            }
        }

        return new int[] {bestBuy, bestSell, bestProfit};
    }
}
