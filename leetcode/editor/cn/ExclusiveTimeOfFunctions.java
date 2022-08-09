package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class ExclusiveTimeOfFunctions {
    public static void main(String[] args) {
        Solution solution = new ExclusiveTimeOfFunctions().new Solution();
        solution.exclusiveTime(2, List.of(new String[]{"0:start:0", "0:start:1", "0:start:2", "0:end:3", "0:end:4", "0:end:5"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static int[] stack = new int[500];
        int sp = 0;
        static int[] ne = new int[500];
        int nep = 0;

        public int[] exclusiveTime(int n, List<String> logs) {
            int[] ans = new int[n];
//            LinkedList<int[]> stack = new LinkedList<>();

            for (String i : logs) {
                String[] t = i.split(":");
                int idx = Integer.parseInt(t[0]);
                boolean in = t[1].charAt(0) == 's';
                int time = Integer.parseInt(t[2]);
                if (in) {
                    stack[sp++] = time;
                    nep++;
                } else {
                    int v = stack[--sp];
                    ans[idx] += time - v + 1 - ne[nep];
                    if (nep > 0) {
//                        ne[nep - 1] += ne[nep];
                        ne[nep - 1] += time - v + 1;
                    }
                    ne[nep--] = 0;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}