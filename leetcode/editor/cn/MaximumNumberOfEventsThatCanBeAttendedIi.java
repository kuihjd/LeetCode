package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class MaximumNumberOfEventsThatCanBeAttendedIi {
    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfEventsThatCanBeAttendedIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxValue(int[][] events, int k) {
            Arrays.sort(events, (v1, v2) -> v1[0] - v2[0]);
            int len = events.length;
            int[][] dp = new int[len + 1][ k + 1];
            for (int i = 0; i < len; ++i) {
                for (int j = 0; j < k; ++j) {
//                    dp[i][j] = Math.max()
                }
            }
            return dp[len][k];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}