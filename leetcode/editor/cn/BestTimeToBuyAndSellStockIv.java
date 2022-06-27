package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class BestTimeToBuyAndSellStockIv {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIv().new Solution();
        solution.maxProfit(2, LeetCodeDataStruct.parserIntArray("[3,2,6,5,0,3]"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int k, int[] prices) {
            int len = prices.length;
            int[][] dp = new int[len][k * 2];
            for (int i = 0; i < k * 2; i += 2) {
                dp[0][i] = -prices[0];
            }
            for (int i = 1; i < len; ++i) {
                dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
                for (int j = 1; j < k * 2; ++j) {
                    if (j % 2 == 0) dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 2] - prices[i]);
                    else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                }
            }
            return dp[len - 1][k * 2 - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}