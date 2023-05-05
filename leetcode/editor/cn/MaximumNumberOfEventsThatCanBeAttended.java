package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class MaximumNumberOfEventsThatCanBeAttended {
    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfEventsThatCanBeAttended().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEvents(int[][] events) {
            Arrays.sort(events, (v1, v2) -> {
                if (v1[1] != v2[1]) return v1[1] - v2[1];
                return v1[0] - v2[0];
            });
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 1; i <= 1e5; ++i) set.add(i);
            int ans = 0;
            for (int[] i : events) {
                Integer d = set.ceiling(i[0]);
                if (d == null || d > i[1]) continue;
                ans++;
                set.remove(d);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}