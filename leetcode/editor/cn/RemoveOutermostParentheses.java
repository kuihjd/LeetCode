package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        Solution solution = new RemoveOutermostParentheses().new Solution();
        solution.removeOuterParentheses("(()())(())(()(()))");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeOuterParentheses(String s) {
            StringBuilder sb = new StringBuilder();
            int c = 0;
            for (char i : s.toCharArray()) {
                if (i == '(')
                    if (c++ != 0) sb.append(i);
                else
                    if (--c != 0) sb.append(i);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}