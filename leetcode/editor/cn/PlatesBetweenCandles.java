package leetcode.editor.cn;

import java.util.TreeMap;
import java.util.TreeSet;

public class PlatesBetweenCandles {
    public static void main(String[] args) {
        Solution solution = new PlatesBetweenCandles().new Solution();
        solution.platesBetweenCandles(
                "***|**|*****|**||**|*", new int[][]{{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] platesBetweenCandles(String s, int[][] queries) {
            int[] res = new int[queries.length];
            int[] cnt = new int[s.length()];
            TreeSet<Integer> set = new TreeSet<>();
            if(s.charAt(0) == '*')cnt[0] = 1;
            else set.add(0);
            for (int i = 1; i < s.length(); ++i) {
                cnt[i] = cnt[i - 1];
                if(s.charAt(i) == '*')cnt[i]++;
                else set.add(i);
            }
            for (int i = 0; i < queries.length; ++i) {
                int l = queries[i][0], r = queries[i][1];
                Integer tl = set.ceiling(l), tr = set.floor(r);
                if(tl == null || tr == null) continue;
                res[i] = cnt[tr] - (tl != 0 ? cnt[tl - 1] : 0);
                if(res[i] < 0) res[i] = 0;
//                while (l <= r && s.charAt(l) == '*') {
//                    l++;
//                    res[i]--;
//                }
//                while (l <= r && s.charAt(r) == '*') {
//                    r--;
//                    res[i]--;
//                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}