package leetcode.editor.cn;
import java.util.*;
public class ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        solution.isValid("()");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        int[] map = new int[128];
        map['('] = 1;
        map[')'] = -1;
        map['['] = 1;
        map[']'] = -1;
        map['{'] = 1;
        map['}'] = -1;
        LinkedList<Integer> stack = new LinkedList<>();
        for(char i : s.toCharArray()){
            if(map[i] > 0) stack.offerLast(map[i]);
            else if(stack.isEmpty() || stack.pollLast() != -map[i]) return false;
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    }