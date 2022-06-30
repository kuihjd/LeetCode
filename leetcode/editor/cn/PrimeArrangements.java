package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class PrimeArrangements {
    public static void main(String[] args) {
        Solution solution = new PrimeArrangements().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static final int MOD = (int) (1e9 + 7);

        public int numPrimeArrangements(int n) {
            int l = 0, r = n;
            for (int i = 2; i < n; ++i) {
                if (check(i)) {
                    l++;
                    r--;
                }
            }
            // System.out.printf("%d %d %d\n", n, l, r);
            return (int) (getGroupNum(l) * getGroupNum(r) % MOD);
        }

        long getGroupNum(int n) {
            long r = 1;
            for (int i = 1; i <= n; ++i) {
                r *= i;
                r %= MOD;
            }
            return r;
        }

        boolean check(int n) {

            for (int i = 2; i <= n / 2; ++i) if (n % i == 0) return false;
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}