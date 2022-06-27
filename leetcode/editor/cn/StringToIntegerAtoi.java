package leetcode.editor.cn;

import java.util.*;

public class StringToIntegerAtoi {
    public static void main(String[] args) {
        Solution solution = new StringToIntegerAtoi().new Solution();
        System.out.print(solution.myAtoi("-6147483648"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int myAtoi(String s) {
            char[] c = s.toCharArray();
            int p = 0;
            while (c[p] == ' ') p++;
            int sign = 1;
            if (c[p] == '-') sign = -1;
            if (c[p] == '-' || c[p] == '+') p++;
            int res = 0;
            while (p < s.length() && c[p] >= '0' && c[p] <= '9') {
                if (sign == 1 && check1(res, c[p] - '0')) return Integer.MAX_VALUE;
                if (sign == -1 && check1(res, c[p] - '0')) return Integer.MIN_VALUE;
                res = res * 10 + c[p] - '0';
                p++;
            }
            return sign * res;
        }

        boolean check1(int v1, int v2){
            int pre = Integer.MAX_VALUE / 10;
            if(v1 < pre ) return false;
            if(v1 > pre ) return true;
            return v2 > Integer.MAX_VALUE % 10;
        }

        boolean check2(int v1, int v2){
            int pre = Integer.MAX_VALUE / 10;
            if(v1 < pre ) return false;
            if(v1 > pre ) return true;
            return v2 - 1 > Integer.MAX_VALUE % 10;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}