public class Solution {
    /**
     * @param prices: the prices
     * @param n: the length of rod
     * @return: the max value
     */
    public int cutting(int[] prices, int n) {
      int[] dp = new int[n+1];
      for (int i=0; i<n+1; i++) 
        dp[i] = 0;

      for (int index = 0; index < prices.length; index++ ) {
          for (int i=0; i < prices.length; i++ ) {
            for (int j = 1; index + (i+1)*j <=n; j++) {
                dp[index + (i+1)*j] = Math.max(dp[index + (i+1)*j], dp[index] + prices[i]*j); 
            }
          }
      }      
      int ret = 0;
      for (int i=0; i<n+1; i++) {
        ret = Math.max(ret, dp[i]);
      }
      return ret;

    }
}
