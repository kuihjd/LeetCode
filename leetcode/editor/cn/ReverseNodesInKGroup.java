package leetcode.editor.cn;

import leetcode.editor.cn.datastruct.ListNode;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
        solution.reverseKGroup(new ListNode(new int[]{1, 2, 3, 4, 5}), 3);
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
        public ListNode reverseKGroup(ListNode head, int k) {
            if(k == 1) return head;
            ListNode res = new ListNode(), t = res;
            res.next = head;
            while (t != null) {
                t = f(t.next, k, t);
            }
            return res.next;
        }

        ListNode f(ListNode start, int k, ListNode add) {

            ListNode t = start;
            int len = k;
            ListNode pre = null;
            ListNode cur = t;
            while (len > 0 && cur != null) {
                len--;
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            if (len != 0) {
                cur = pre;
                pre = null;
                while (cur != null) {
                    ListNode next = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = next;
                }
                return null;
            } else {
                start.next = cur;
                add.next = pre;
                return start;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}