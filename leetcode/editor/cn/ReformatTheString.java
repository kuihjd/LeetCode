package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class ReformatTheString {
    public static void main(String[] args) {
        Solution solution = new ReformatTheString().new Solution();
        solution.reformat("a0b1c23");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reformat(String s) {
            int[] cnt = new int[128];
            int c1 = 0, c2 = 0;
            StringBuilder sb = new StringBuilder(s.length());
            for (char i : s.toCharArray()) {
                if (i < 'a') {
                    c1++;
                } else {
                    c2++;
                }
                cnt[i]++;
            }
            if (Math.abs(c1 - c2) > 1) {
                return "";
            }
            int p1 = '0', p2 = 'a';
            if (c1 > c2) {
                while (cnt[p1] == 0) {
                    p1++;
                }
                sb.append((char) p1);
                cnt[p1]--;
                while (c1 + c2 > 2) {
                    c1 -= 2;
                    while (cnt[p2] == 0) {
                        p2++;
                    }
                    sb.append((char) p2);
                    cnt[p2]--;
                    while (cnt[p1] == 0) {
                        p1++;
                    }
                    sb.append((char) p1);
                    cnt[p1]--;
                }
            } else {
                while (cnt[p2] == 0) {
                    p2++;
                }
                sb.append((char) p2);
                cnt[p2]--;
                while (c1 + c2 > 2) {
                    c1 -= 2;
                    while (cnt[p1] == 0) {
                        p1++;
                    }
                    sb.append((char) p1);
                    cnt[p1]--;
                    while (cnt[p2] == 0) {
                        p2++;
                    }
                    sb.append((char) p2);
                    cnt[p2]--;
                }
            }
            while (p1 <= '9') {
                if (cnt[p1] > 0) {
                    sb.append((char) p1);
                }
                p1++;
            }
            while (p2 <= 'z') {
                if (cnt[p2] > 0) {
                    sb.append((char) p2);
                }
                p2++;
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}