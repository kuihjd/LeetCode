package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumFallingPathSumIi {
    public static void main(String[] args) {

        Solution solution = new MinimumFallingPathSumIi().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minFallingPathSum(int[][] grid) {
            int n = grid.length;
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; ++i) {
                dp[0][i] = grid[0][i];
            }
            for (int i = 1; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = 0; k < n; ++k) {
                        if (k != j) {
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + grid[i][j]);
                        }
                    }
                }
            }
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < n; ++i) {
                res = Math.min(res, dp[n - 1][i]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}