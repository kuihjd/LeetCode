package leetcode.editor.cn;

import java.util.*;

public class ComplexNumberMultiplication {
    public static void main(String[] args) {
        Solution solution = new ComplexNumberMultiplication().new Solution();
        solution.complexNumberMultiply("78+-76i", "-86+72i");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String complexNumberMultiply(String num1, String num2) {
            String[] sa1 = num1.split("\\+");
            String[] sa2 = num1.split("\\+");
            int an1 = Integer.parseInt(sa1[0]), vn1 = Integer.parseInt(sa1[1].substring(0, sa1[1].length() - 1));
            int an2 = Integer.parseInt(sa2[0]), vn2 = Integer.parseInt(sa2[1].substring(0, sa2[1].length() - 1));
            int ra = 0, rv = 0;
            ra += an1 * an2;
            ra -= vn1 * vn2;
            rv = an1 * vn2 + an2 * vn1;
            return String.format("%d+%di", ra, rv);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}