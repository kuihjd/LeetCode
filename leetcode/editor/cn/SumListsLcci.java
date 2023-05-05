package leetcode.editor.cn;

import leetcode.editor.cn.datastruct.ListNode;

public class SumListsLcci {
    public static void main(String[] args) {
        Solution solution = new SumListsLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode res = new ListNode();
            res.next = new ListNode(0);
            ListNode cur = res;
            int m = 0;
            while (l1 != null && l2 != null) {
                int t = m + l1.val + l2.val;
                m = t / 10;
                cur.next = new ListNode(t % 10);
                l1 = l1.next;
                l2 = l2.next;
                cur = cur.next;
            }
            while (l1 != null) {
                int t = m + l1.val;
                m = t / 10;
                cur.next = new ListNode(t % 10);
                l1 = l1.next;
                cur = cur.next;
            }
            while (l2 != null) {
                int t = m + l2.val;
                m = t / 10;
                cur.next = new ListNode(t % 10);
                l2 = l2.next;
                cur = cur.next;
            }
            if (m != 0)  cur.next = new ListNode(m);
            return res.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}