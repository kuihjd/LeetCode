package leetcode.editor.cn;

import java.util.*;

public class LruCacheLcci {
    public static void main(String[] args) {
        LRUCache solution = new LruCacheLcci().new LRUCache(2);
        solution.put(2, 1);
//        System.out.println(solution.get(1));
        solution.put(1, 1);
        solution.put(2, 3);
        solution.put(4, 1);
        System.out.println(solution.get(1));
        System.out.println(solution.get(2));
        solution.put(3, 3);
        System.out.println(solution.get(2));
        solution.put(4, 4);
        System.out.println(solution.get(1));
        System.out.println(solution.get(3));
        System.out.println(solution.get(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        private final HashMap<Integer, DoublyList> map = new HashMap<>();
        private final DoublyList head = new DoublyList(-1, -1);
        private final DoublyList tail = new DoublyList(-1, -1);
        int size = 0;
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if(!map.containsKey(key)) return -1;
            DoublyList cur = map.get(key);
            del(cur);
            addToTail(cur);
            return cur.val;
        }

        public void put(int key, int value) {
            if(map.containsKey(key)) {
                DoublyList cur = map.get(key);
                del(cur);
                addToTail(cur);
                cur.val = value;
            }
            else{
                DoublyList cur = new DoublyList(key, value);
                addToTail(cur);
                if(size > capacity) del(head.next);
            }
        }

        private void del(DoublyList tar) {
            map.remove(tar.key);
            size--;
            DoublyList pre = tar.pre;
            DoublyList next = tar.next;
            pre.next = next;
            next.pre = pre;
        }

        private void addToHead(DoublyList tar) {
            size++;
            map.put(tar.key, tar);
            DoublyList pre = head;
            DoublyList next = head.next;
            pre.next = tar;
            next.pre = tar;
            tar.next = next;
            tar.pre = pre;
        }

        private void addToTail(DoublyList tar) {
            size++;
            map.put(tar.key, tar);
            DoublyList pre = tail.pre;
            DoublyList next = tail;
            pre.next = tar;
            next.pre = tar;
            tar.next = next;
            tar.pre = pre;
        }

        class DoublyList {
            DoublyList pre;
            DoublyList next;
            int key;
            int val;
            DoublyList(int key, int val) {
                this.pre = null;
                this.next = null;
                this.val = val;
                this.key = key;
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