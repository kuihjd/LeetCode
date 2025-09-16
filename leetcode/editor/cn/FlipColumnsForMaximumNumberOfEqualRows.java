package leetcode.editor.cn;

import java.util.HashMap;

public class FlipColumnsForMaximumNumberOfEqualRows {
    public static void main(String[] args) {
        Solution solution = new FlipColumnsForMaximumNumberOfEqualRows().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEqualRowsAfterFlips(int[][] matrix) {
            HashMap<String, Integer> map = new HashMap<>();
            StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
            for (int[] i : matrix) {
                for (int j : i) {
                    sb1.append(j);
                    sb2.append(j ^ 1);
                }
                String s1 = sb1.toString(), s2 = sb2.toString();
                map.put(s1, map.getOrDefault(s1, 0) + 1);
                map.put(s2, map.getOrDefault(s2, 0) + 1);
                sb1 = new StringBuilder();
                sb2 = new StringBuilder();
            }
            int r = 1;
            for (int i : map.values()) {
                r = Math.max(r, i);
            }
            return r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}