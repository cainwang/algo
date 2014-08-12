/**
 *
 */
package algo;

/**
 * @author cainwang
 *
 */
public class BestTimeToBuyAndSellStock {

    /**
     * @param args
     */
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int lowIndex = 0, maxProfit = 0;

        for (int i = 1; i < prices.length; i ++) {
            int price = prices[i];
            int previous = prices[i - 1];

            // regional low
            if (price > previous && previous <= prices[lowIndex]) {
                lowIndex = i - 1;
            }
            // regional high
            if (price < previous || i == prices.length - 1) {
                int profit = previous - prices[lowIndex];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

}
