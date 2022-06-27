package leetcode.editor.cn;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int[] val) {
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
