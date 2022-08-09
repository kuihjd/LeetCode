package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class SortList {
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
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
        public ListNode sortList(ListNode head) {
            head = new ListNode(-1, head);
            int size = 0;
            ListNode t = head.next;
            while (t != null) {
                t = t.next;
                size++;
            }
            int len = 2;
            while (len < size) ;
            return null;
        }

        ListNode merge(ListNode l, ListNode r, int len, ListNode end) {
            ListNode res = null;
            res.next = end;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}