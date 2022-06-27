package leetcode.editor.cn;

import java.util.*;

public class DecodeString {
    public static void main(String[] args) {
        Solution solution = new DecodeString().new Solution();
        System.out.println(solution.decodeString("3[a]2[b2[c2[e]]]"));
        ;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeString(String s) {
            char[] c = s.toCharArray();
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < c.length; i++) {
                if (c[i] >= 'a' && c[i] <= 'z') {
                    ans.append(c[i]);
                } else {
                    int n = 0;
                    while (c[i] >= '0' && c[i] <= '9') {
                        n = n * 10 + c[i++] - '0';
                    }
                    i++;
                    Helper content = getSubString(c, i);
                    i += content.len;
                    ans.append(String.valueOf(content.sb).repeat(Math.max(0, n)));
                }
            }
            return ans.toString();
        }

        Helper getSubString(char[] c, int start) {
            Helper cur = new Helper();
            for (int i = start; i < c.length; ++i) {
                if (c[i] >= 'a' && c[i] <= 'z') {
                    cur.sb.append(c[i]);
                    cur.len++;
                } else if (c[i] >= '0' && c[i] <= '9') {
                    int n = 0;
                    while (c[i] >= '0' && c[i] <= '9') {
                        n = n * 10 + c[i++] - '0';
                        cur.len++;
                    }
                    i++;
                    Helper content = getSubString(c, i);
                    i += content.len;
                    cur.len += content.len + 2;
                    cur.sb.append(String.valueOf(content.sb).repeat(Math.max(0, n)));
                } else if (c[i] == ']') {

                    break;
                }
            }
            return cur;
        }

        class Helper {
            int len = 0;
            StringBuilder sb = new StringBuilder();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}