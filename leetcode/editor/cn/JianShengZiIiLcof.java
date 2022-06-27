package leetcode.editor.cn;

import java.util.*;

public class JianShengZiIiLcof {
    public static void main(String[] args) {
        Solution solution = new JianShengZiIiLcof().new Solution();
        solution.cuttingRope(12);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static final int MOD = (int) 1e9 + 7;
        public int cuttingRope(int n) {
            int p = n / 3;
            if(n % 3 == 2) return pow(p - 1) * 2 * 2;
            return pow(p);
        }

        int pow(int p){
            if(p == 0) return 1;
            return (3 * pow(p - 1)) % MOD;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}