package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class SolveTheEquation {
    public static void main(String[] args) {
        Solution solution = new SolveTheEquation().new Solution();
        solution.solveEquation("x+5-3+x=6+x-2");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String solveEquation(String equation) {
            if (equation.equals("0x=0")) {
                return "Infinite solutions";
            }
            boolean rf = false, sf = true;
            int cur = 0, x = 0, n = 0;
            for (char i : equation.toCharArray()) {
                if (i == '+') {
                    int v = cur * (sf == rf ? -1 : 1);
                    System.out.println(v);
                    n += v;
                    cur = 0;
                    sf = true;
                } else if (i == '-') {
                    int v = cur * (sf == rf ? -1 : 1);
                    System.out.println(v);
                    n += v;
                    cur = 0;
                    sf = false;
                } else if (i == '=') {
                    int v = cur * (sf == rf ? -1 : 1);
                    sf = true;
                    System.out.println(v);
                    n += v;
                    cur = 0;
                    rf = true;
                } else if (i == 'x') {
                    int v = cur == 0 ? 1 : cur;
                    v *= (sf == rf ? -1 : 1);
//                    System.out.println(v + "x");
                    x += v;
                    cur = 0;
                } else {
                    cur *= 10;
                    cur += i - '0';
                }
            }
            n += cur * (sf == rf ? -1 : 1);
            if (x == 0) {
                if (n == 0) {
                    return "Infinite solutions";
                }
                return "No solution";
            }
            return String.format("x=%d", - n / x);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}