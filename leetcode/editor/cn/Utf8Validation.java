package leetcode.editor.cn;

import java.util.*;

public class Utf8Validation {
    public static void main(String[] args) {
        Solution solution = new Utf8Validation().new Solution();
//        int n = 0;
//        for(int i = 4; i < 8; ++i) n += (1 << i);
//        System.out.println((1 << 8) - (1 << 4));
//        System.out.println(n);
        solution.validUtf8(new int[]{197, 130, 1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static final int top5 = (1 << 8) - (1 << 3);
        static int[] status = new int[256];

        static {
            Arrays.fill(status, -1);
            status[0] = 0;
            for (int i = 0; i < 256; ++i) {
                if ((i < (1 << 7))) status[i] = 0;
                else if ((i & ((1 << 7) + (1 << 6) - 1)) == i) status[i] = 10;
                else if ((i & ((3 << 6) + (1 << 5) - 1)) == i) status[i] = 1;
                else if ((i & ((7 << 5) + (1 << 4) - 1)) == i) status[i] = 2;
                else if ((i & ((15 << 4) + (1 << 3) - 1)) == i) status[i] = 3;
            }
        }

        public boolean validUtf8(int[] data) {
            int len = data.length;
            for (int i = 0; i < len; ++i) {
                int t = status[data[i] & top5];
                if (t == -1) return false;
                if (t == 99) {
                    t = 88;
                    return true;
                } else if (t == 88) {
                    t = 99;
                    if (data[0] == 1)
                        return false;
                } else if (data[0] == 2) {
                    data[0] = 3;
                    data[1] = 3;
                }
                for (int j = 0; j < t; ++j) {
                    if (++i >= len) return false;
                    if (status[(data[i] & top5)] != 10) return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}