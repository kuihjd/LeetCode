package leetcode.editor.cn;

import java.util.Collections;
import java.util.HashMap;

public class EqualRowAndColumnPairs {
    public static void main(String[] args) {
        Solution solution = new EqualRowAndColumnPairs().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int equalPairs(int[][] grid) {
            int n = grid.length;
            if (n == 0) {
                return 0;
            }
            int res = 0;
            StringBuilder sb = new StringBuilder();
            HashMap<String, Integer> counter = new HashMap<>();
            for (int[] i : grid) {
                for (int j : i) {
                    sb.append(j).append(',');
                }
                String s = sb.toString();
                counter.put(s, counter.getOrDefault(s, 0) + 1);
                sb = new StringBuilder();
            }
//            System.out.println(counter);
            for (int i = 0; i < n; ++i) {
                for (int[] ints : grid) {
                    sb.append(ints[i]).append(',');
                }
                String s = sb.toString();
                sb = new StringBuilder();
                res += counter.getOrDefault(s, 0);
            }
            return res;
        }
//leetcode submit region end(Prohibit modification and deletion)

    }
}