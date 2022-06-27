package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class TagValidator {
    public static void main(String[] args) {
        Solution solution = new TagValidator().new Solution();
        solution.isValid("123");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String code) {
            char[] c = code.toCharArray();
            int i = 0;
            int len = c.length;
            Stack<String> stack = new Stack<>();
            while (i < len) {
                while (i < len && c[i] != '<') i++;
                String s;
                if (i < len) {
                    if (start(c, i).length() != 0){
                        s = start(c, i);
                        stack.add(s);
                    }
                    else if(end(c, i).length() != 0){
                        s = end(c, i);
                        if(!s.equals(stack.pop())) return false;
                    }
                    else{
                        s = cdata(c, i);
                        if(s.length() == 0) return false;
                    }
                    i += s.length();
                }
            }
            return true;
        }
        String start(char[] c, int i) {
            StringBuilder sb = new StringBuilder();
            while (c[i] != '>') {
                if (!isHighWord(c[i])) return "";
                sb.append(c[i]);
                if (sb.length() > 9) return "";
            }
            return sb.toString();
        }

        String end(char[] c, int i) {
            if (c[i++] != '!') return "";
            return start(c, i);
        }

        String cdata(char[] c, int i) {
            if (c.length - i < 9) return "";
            StringBuilder sb = new StringBuilder();
            while (sb.length() < 9) sb.append(c[i]++);
            if (!sb.toString().equals("<![CDATA[")) return "";
            while(!cdataCanEnd(sb)){
                sb.append(c[i]);
                i++;
                if(i == c.length) return "";
            }
            return sb.toString();
        }

        boolean cdataCanEnd(StringBuilder sb) {
            int len = sb.length();
            return sb.charAt(len - 3) == ']' &&
                    sb.charAt(len - 2) == ']' &&
                    sb.charAt(len - 1) == '>';
        }

        boolean isHighWord(char c) {
            if (c > 'Z') return false;
            if (c < 'A') return false;
            return true;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}