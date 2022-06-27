package leetcode.editor.cn;

import java.util.*;

public class LruCache {
    public static void main(String[] args) {
        LRUCache solution = new LruCache().new LRUCache(3);
        solution.put(1, 1);
        solution.put(2, 3);
        solution.put(3, 3);
        solution.put(4, 4);
        solution.get(4);
        solution.get(3);
        solution.get(2);
        solution.get(1);
        solution.put(5, 5);
        solution.get(1);
        solution.get(2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        HashMap<Integer, Helper> map = new HashMap<>();
        Helper head, tail;
        int capacity;
        int size = 0;

        public LRUCache(int capacity) {
            head = new Helper(null, null, -1, -1);
            tail = new Helper(null, null, -1, -1);
            head.next = tail;
            tail.pre = head;
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            Helper t = map.get(key), pre = t.pre, next = t.next;
            pre.next = next;
            next.pre = pre;
//            Helper now = new Helper(tail.pre, tail, key, t.val);
            t.pre = tail.pre;
            t.next = tail;
            tail.pre.next = t;
            tail.pre = t;


            return map.get(key).val;
        }

        public void put(int key, int value) {

            if (map.containsKey(key)) {
                size--;
                Helper t = map.get(key), pre = t.pre, next = t.next;
                pre.next = next;
                next.pre = pre;
            }

            Helper now = new Helper(tail.pre, tail, key, value);
            size++;
            map.put(key, now);
            tail.pre.next = now;
            tail.pre = now;


            if (size > capacity) {
                Helper t = head.next;
                head.next = t.next;
                t.next.pre = head;
                size--;
                map.remove(t.key);
            }
        }

        class Helper {
            Helper pre, next;
            int key, val;

            Helper(Helper pre, Helper next, int key, int val) {
                this.pre = pre;
                this.next = next;
                this.key = key;
                this.val = val;
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}