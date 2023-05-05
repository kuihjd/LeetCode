package leetcode.editor.cn;
import leetcode.editor.cn.datastruct.ListNode;

import java.util.*;
public class MergeKSortedLists{
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        
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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(), p = res;
        res.next = null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for(ListNode i:lists)  if(i != null) pq.add(i);
        while(!pq.isEmpty()){
            ListNode t = pq.poll();
            if(t == null) continue;
            p.next = t;
            p = t;
            if(t.next != null)pq.add(t.next);

        }
        p.next = null;
        return res.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    }