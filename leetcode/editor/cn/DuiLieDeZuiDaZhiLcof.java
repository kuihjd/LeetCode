package leetcode.editor.cn;

import java.util.*;

public class DuiLieDeZuiDaZhiLcof {
    public static void main(String[] args) {
        MaxQueue solution = new DuiLieDeZuiDaZhiLcof().new MaxQueue();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MaxQueue {
        LinkedList<Integer> valQue = new LinkedList<>();
        PriorityQueue<Integer> maxQue = new PriorityQueue<>((v1, v2) -> v2.compareTo(v1));
        PriorityQueue<Integer> delQue = new PriorityQueue<>((v1, v2) -> v2.compareTo(v1));
        public MaxQueue() {

        }

        public int max_value() {
            if(maxQue.isEmpty()) return -1;
            return maxQue.peek();
        }

        public void push_back(int value) {
            valQue.offerLast(value);
            maxQue.offer(value);
        }

        public int pop_front() {
            if(valQue.isEmpty()) return -1;
            int t = valQue.pollFirst();
            delQue.offer(t);
            while (!delQue.isEmpty() && delQue.peek().equals(maxQue.peek())){
                delQue.poll();
                maxQue.poll();
            }
            return t;
        }
    }

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
//leetcode submit region end(Prohibit modification and deletion)

}