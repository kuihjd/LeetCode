package leetcode.editor.cn.mytest;

public class Test23033001 {

    public static void main(String[] args) {
        LinkedNode head = new LinkedNode();
        LinkedNode t = head;
        int[] vals = new int[]{5, 9, 2, 4, 0, 7};
        for (int i : vals) {
            t.next = new LinkedNode();
            t = t.next;
            t.val = i;
        }
        head = head.next;
        fun(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

    static void fun(LinkedNode head) {
        if ( head.next == null) {
            return;
        }
        LinkedNode l1 = new LinkedNode(), l2 = new LinkedNode();
        int val = head.val;
        LinkedNode t = head, t1 = l1, t2 = l2;
        while (t != null) {
            if (t.val > val) {
                t1.next = t;
                t1 = t1.next;
            } else {
                t2.next = t;
                t2 = t2.next;
            }
            t = t.next;
        }
        l1 = l1.next;
        l2 = l2.next;
        fun(l1);
        fun(l2);
        t1.next = l2;
    }


    static class LinkedNode {
        LinkedNode next;
        int val;
    }
}
