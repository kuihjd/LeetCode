package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class GasStation {
    public static void main(String[] args) {
        Solution solution = new GasStation().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int len = gas.length;
            int s1 = 0, s2 = 0;
            for (int i : gas) s1 += i;
            for (int i : cost) s2 += i;
            if (s2 > s1) return -1;
            int cur = 0;
            for (int i = 0; i < len; ++i) {
                cur = 0;
                for (int j = i; j < len; ++j) {
                    cur += gas[j];
                    cur -= cost[j];
                    if (cur < 0) {
                        i = j;
                        break;
                    }
                }
                if (cur >= 0) return i;
            }
            return len - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}