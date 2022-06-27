package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class PrimeNumberOfSetBitsInBinaryRepresentation {
    public static void main(String[] args) {
        Solution solution = new PrimeNumberOfSetBitsInBinaryRepresentation().new Solution();
        solution.countPrimeSetBits(6, 10);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static boolean[] v = new boolean[32];

        static {
            v[1] = true;
            for (int i = 2; i < 32; ++i) {
                boolean f = true;
                for (int j = 2; j <= i / j; ++j) f = f && i % j != 0;
                v[i] = f;
            }
        }

        public int countPrimeSetBits(int left, int right) {
            int res = 0;
            for (int i = left; i <= right; ++i) {
                if (v[Integer.bitCount(i)])
                    res++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}