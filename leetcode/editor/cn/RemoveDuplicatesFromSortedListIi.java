package leetcode.editor.cn;

import leetcode.editor.cn.datastruct.ListNode;

public class RemoveDuplicatesFromSortedListIi{
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
        
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        head=new ListNode(-1,head);
        ListNode cur=head;
        ListNode p=head.next;
        while(p!=null){
            while(p.next!=null&&p.val==p.next.val)p=p.next;
            if(p!=cur.next){
                cur.next=p.next;
            }
            else{
                cur=p;
            }
            p=p.next;
        }
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}