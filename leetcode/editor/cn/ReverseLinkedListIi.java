package leetcode.editor.cn;

import leetcode.editor.cn.datastruct.ListNode;

public class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        solution.reverseBetween(new ListNode(new int[]{1, 2, 3, 4, 5}), 2, 4);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode h = new ListNode(-1, head), pre = h;
            while (head.val != left) {
                head = head.next;
                pre = pre.next;
            }
            pre.next = reversed(head, right);
            return h.next;
        }

        ListNode reversed(ListNode start, int end) {
            ListNode pre = start, cur = start.next;
            while (cur.val != end) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            ListNode next = cur.next;
            cur.next = pre;
            start.next = next;
            return cur;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}