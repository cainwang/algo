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
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();
        int profit = solution.maxProfit(new int[] {5, 10, 1, 8, 2});
        System.out.println(profit);
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
            int high = -1;
            if (price < previous) {
                high = previous;
            }
            if (price > previous && i == prices.length - 1) {
                high = price;
            }

            if (high > 0) {
                int profit = high - prices[lowIndex];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

}
