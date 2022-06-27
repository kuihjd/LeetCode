package leetcode.editor.cn;

import java.util.*;

public class ChouShuLcof {
    public static void main(String[] args) {
        Solution solution = new ChouShuLcof().new Solution();
        solution.nthUglyNumber(10);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static int[] cache = new int[1700];
        static {
            HashSet<Integer> set = new HashSet<>();
            cache[1] = 1;
            int n2 = 1, n3 = 1, n5 = 1;
            for (int i = 2; i < 1700; ++i) {
                int v2 = cache[n2] * 2, v3 = cache[n3] * 3, v5 = cache[n5] * 5;
                cache[i] = Math.min(Math.min(v2, v3), v5);
                if(cache[i] == v2) n2++;
                if(cache[i] == v3) n3++;
                if(cache[i] == v5) n5++;
            }
        }

        public int nthUglyNumber(int n) {
            return cache[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}