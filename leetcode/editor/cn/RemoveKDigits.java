package leetcode.editor.cn;

import java.util.*;

public class RemoveKDigits {
    public static void main(String[] args) {
        Solution solution = new RemoveKDigits().new Solution();
        ListNode[] t = new ListNode[8];
        ArrayList<ListNode> ta = new ArrayList<>(Arrays.asList(t));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeKdigits(String num, int k) {
            if (k == num.length()) return "0";
            LinkedList<Character> que = new LinkedList<>();
            que.add('0');
            for (char i : num.toCharArray()) {
                while (k > 0 && i < que.peekLast()) {
                    k--;
                    que.pollLast();
                }
                que.addLast(i);
            }
            while (!que.isEmpty() && que.peekFirst() == '0') que.pollFirst();
            while (k-- > 0) que.pollLast();
            if (que.isEmpty()) return "0";
            StringBuilder sb = new StringBuilder();
            for (char i : que) sb.append(i);
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}