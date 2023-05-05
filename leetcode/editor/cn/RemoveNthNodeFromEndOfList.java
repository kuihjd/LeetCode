package leetcode.editor.cn;

import leetcode.editor.cn.datastruct.ListNode;

public class RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode cur=null;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        del(head,n);
        if(cur==null) head=head.next;
        cur.next=cur.next.next;
        return head;
    }
    int  del(ListNode head, int n){
        if(head==null) return 0;
        int t=del(head.next,n);
        if(t==n) cur=head;
        return t+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}