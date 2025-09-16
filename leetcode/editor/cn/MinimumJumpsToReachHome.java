package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class MinimumJumpsToReachHome {
    public static void main(String[] args) {

        Solution solution = new MinimumJumpsToReachHome().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumJumps(int[] forbidden, int a, int b, int x) {
            if (x == 0) {
                return 0;
            }
            int r = 0;
            int mx = 6000;
            Set<int[]> cur = new HashSet<>();
            boolean[] bad = new boolean[mx];



            cur.add(new int[]{0, 1});
            for (int i : forbidden) {
                bad[i] = true;
            }
            bad[0] = true;
            while (!cur.isEmpty() && r < mx) {
                Set<int[]> next = new HashSet<>();
//                System.out.println(cur);
                for (int[] i : cur) {
                    if (i[0] == x) {
                        return r;
                    }
//                    System.out.print(i[0] + " " );
                    int an = i[0] + a;
                    if (an >= 0 && an < mx && (next.contains(new int[]{an, 0}) || !bad[an])) {
                        bad[an] = true;
                        next.add(new int[]{an, 1});
                    }
                    if (i[1] == 1) {
                        int pn = i[0] - b;
                        if (pn >= 0 && pn < mx && !bad[pn]) {
//                            bad[pn] = true;
                            next.add(new int[]{pn, 0});
                        }
                    }
                }
//                System.out.println();
                r++;
                cur = next;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}