package leetcode.editor.cn;
import java.util.*;
public class AllOoneDataStructure{
    public static void main(String[] args) {
        AllOne solution = new AllOoneDataStructure().new AllOne();
        solution.inc("a");
        solution.inc("b");
        solution.inc("b");
        solution.inc("c");
        solution.inc("c");
        solution.inc("c");
        solution.dec("b");
        solution.dec("b");
        solution.dec("a");
        solution.getMinKey();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class AllOne {
        private final Helper head = new Helper(), tail = new Helper();
        private final HashMap<String, Helper> strToVal = new HashMap<>();
        public AllOne() {
            tail.pre = head;
            head.next = tail;
            head.num = Integer.MAX_VALUE;
            tail.num = 0;
        }

        public void inc(String key) {
            Helper curHelper = tail;
            if(strToVal.containsKey(key)) {
                curHelper = strToVal.get(key);
            }
            Helper upHelper = up(curHelper, key);
            strToVal.put(key, upHelper);
        }

        public void dec(String key) {
            Helper curHelper = strToVal.get(key);
            Helper downHelper = down(curHelper, key);
            strToVal.put(key, downHelper);
        }

        public String getMaxKey() {
            Helper max = head.next;
            if(max == tail) return "";
            return max.strs.iterator().next();
        }

        public String getMinKey() {
            Helper min = tail.pre;
            if(min == head) return "";
            return min.strs.iterator().next();
        }

        private Helper up(Helper cur, String key){
            if(cur.pre.num != cur.num + 1){
                Helper insert = new Helper();
                insert.num = cur.num + 1;
                insert.next = cur;
                insert.pre = cur.pre;
                insert.next.pre = insert;
                insert.pre.next = insert;
            }
            cur.strs.remove(key);
            cur.pre.strs.add(key);
            if(cur.strs.isEmpty() && cur != tail){
                Helper next = cur.next, pre = cur.pre;
                next.pre = pre;
                pre.next = next;
            }
            return cur.pre;
        }

        private Helper down(Helper cur, String key){
            if(cur.next.num != cur.num - 1){
                Helper insert = new Helper();
                insert.num = cur.num - 1;
                insert.pre = cur;
                insert.next = cur.next;
                insert.next.pre = insert;
                insert.pre.next = insert;
            }
            cur.strs.remove(key);
            cur.next.strs.add(key);
            if(cur.strs.isEmpty()){
                Helper next = cur.next, pre = cur.pre;
                next.pre = pre;
                pre.next = next;
            }
            return cur.next;
        }
    }

    class Helper{
        Helper next, pre;
        int num = 0;
        HashSet<String> strs = new HashSet<>();
    }

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
//leetcode submit region end(Prohibit modification and deletion)

    }