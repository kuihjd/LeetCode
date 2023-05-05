package leetcode.editor.cn.datastruct;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int[] val) {
        this.val = val[0];
        ListNode t = this;
        for (int i = 1; i < val.length; ++i) {
            t.next = new ListNode(val[i]);
            t = t.next;
        }
    }

    ListNode get(int interval) {
        ListNode t = this;
        while (interval >= 0) {
            t = t.next;
            interval--;
        }
        return t;
    }
}
