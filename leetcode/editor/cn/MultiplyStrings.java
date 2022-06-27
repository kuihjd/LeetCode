package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new MultiplyStrings().new Solution();
        solution.multiply("2", "3");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[][] cache = new int[11][0];

        public String multiply(String num1, String num2) {
            if(num1.equals("0") || num2.equals("0")) return "0";
            char[] c1 = num1.toCharArray(), c2 = num2.toCharArray();
            for (int i = 0; i < c1.length; i++) {
                c1[i] -= '0';
            }
            for (int i = 0; i < c2.length; i++) {
                c2[i] -= '0';
            }
            int[] ans = new int[Math.max(c1.length, c2.length) * 2 + 10];
            int up = 0;
            for (int i = 0; i < c2.length; ++i) {
                int[] cur = multiply(c1, c2[c2.length - 1 - i]);
                int w = ans.length - 1 - i, r = cur.length - 1;
                while(r >= 0){
                    int t = ans[w] + cur[r] + up;
                    ans[w] = t % 10;
                    up = t / 10;
                    w--;
                    r--;
                }
                while(up > 0){
                    int t = ans[w] + up;
                    ans[w] = t % 10;
                    up = t / 10;
                    w--;
                }
            }
            int l = 0;
            while(ans[l] == 0) l++;
            char[] res = new char[ans.length - l];
            for(int i = 0; i < res.length; ++i){
                res[i] = (char)(ans[l + i] + '0');
            }
            return String.valueOf(res);
        }

        int[] multiply(char[] n1, int n2) {
            if (cache[n2].length != 0) return cache[n2];
            int[] res = new int[n1.length + 1];
            int up = 0, r = n1.length - 1, w = res.length - 1;
            while (r >= 0){
                int t = n1[r] * n2 + up;
                res[w] = t % 10;
                up = t / 10;
                r--;
                w--;
            }
            res[w] = up;
            cache[n2] = res;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}