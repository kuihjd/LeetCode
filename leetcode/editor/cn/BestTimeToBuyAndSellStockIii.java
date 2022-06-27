package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class BestTimeToBuyAndSellStockIii {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIii().new Solution();
        solution.maxProfit(LeetCodeDataStruct.parserIntArray("[6,1,3,2,4,7]"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int len = prices.length;
            int[][] dp = new int[len][4];
            dp[0][0] = -prices[0];
            dp[0][2] = -prices[0];
            for (int i = 1; i < len; ++i) {
                dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
                dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
            }
            return max(0, dp[len - 1][1], dp[len - 1][3]);
        }

        int max(int... nums) {
            int res = nums[0];
            for (int i : nums) {
                res = Math.max(i, res);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}