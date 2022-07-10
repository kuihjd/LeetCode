package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class MinimumNumberOfRefuelingStops {
    public static void main(String[] args) {
        Solution solution = new MinimumNumberOfRefuelingStops().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minRefuelStops(int target, int startFuel, int[][] stations) {
            if (target <= startFuel) return 0;
            if (stations.length == 0) return -1;
            int len = stations.length;
            int[][] dp = new int[len + 1][len + 1];

            // i, j: i步到达j, 最多剩余多少
            for (int i = 1; i < len; ++i) Arrays.fill(stations[i], -99999999);
            for (int i = 1; i < len; ++i) if (stations[i][0] <= startFuel) dp[0][i] = startFuel - stations[i][0];
            for (int i = 1; i < len; ++i) {
                for (int j = 0; j < len; ++j) {

                }
            }

            return -1;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}