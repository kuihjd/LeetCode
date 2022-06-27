package leetcode.editor.cn;

import java.util.*;

public class ReverseWordsInAStringIii {
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAStringIii().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            LinkedList<Character> list = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            for (char i : s.toCharArray()) {
                if (i == ' ') {
                    while (!list.isEmpty()) sb.append(list.pollLast());
                    sb.append(' ');
                } else {
                    list.offerLast(i);
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}