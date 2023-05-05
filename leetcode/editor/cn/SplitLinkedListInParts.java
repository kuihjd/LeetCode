package leetcode.editor.cn;

import leetcode.editor.cn.datastruct.ListNode;

public class SplitLinkedListInParts{
    public static void main(String[] args) {
        Solution solution = new SplitLinkedListInParts().new Solution();
        
    }


class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode t=head,cur=null;
        ListNode[] res=new ListNode[k];
        res[0]=head;
        int len=0;
        while(t!=null){
            len++;
            t=t.next;
        }
        int num=len/k;
        int other=len-num*k;
        int index=1;
        for(int i=1;i<k;++i){
            for(int j=0;j<num+(i-1<other?1:0);++j){
                cur=head;
                head=head.next;
            }
            cur.next=null;
            res[i]=head;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}