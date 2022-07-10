package leetcode.editor.cn;

import java.util.*;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        solution.isValid("()");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            LinkedList<Character> stack = new LinkedList<>();
            for (char i : s.toCharArray()) {
                if (i == '(' || i == '{' || i == '[') stack.addLast(i);
                else {
                    if (stack.isEmpty()) return false;
                    if (i == ')' && stack.pollLast() != '(') return false;
                    if (i == ']' && stack.pollLast() != '[') return false;
                    if (i == '}' && stack.pollLast() != '{') return false;
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}