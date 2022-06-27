package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class JEj789 {
    public static void main(String[] args) {
        Solution solution = new JEj789().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCost(int[][] costs) {
            int len = costs.length;
            for (int i = 1; i < len; ++i) {
                costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
                costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
                costs[i][2] += Math.min(costs[i - 1][1], costs[i - 1][0]);
            }
            return Math.min(costs[len - 1][0], Math.min(costs[len - 1][1], costs[len - 1][2]));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}