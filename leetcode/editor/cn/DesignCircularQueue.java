package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class DesignCircularQueue {
    public static void main(String[] args) {
//        Solution solution = new DesignCircularQueue().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCircularQueue {
        int[] data;
        int k;
        int l = 0, r = 0;
        // 重合表示没数据, l = r + 1表示满数据
        public MyCircularQueue(int k) {
            this.k = k + 1;
            data = new int[k + 1];
        }

        public boolean enQueue(int value) {
            if (isFull()) return false;
            data[l--] = value;
            if (l < 0) l = k - 1;
            return true;
        }

        public boolean deQueue() {
            if (isFull()) return false;
            r--;
            if (r < 0) r = k - 1;
            return true;
        }

        public int Front() {
            if (isEmpty()) return -1;
            return data[r];
        }

        public int Rear() {
            if (isEmpty()) return -1;
            return data[(l + 1) % k];
        }

        public boolean isEmpty() {
            return l == r;
        }

        public boolean isFull() {
            return l == (r + 1) % k;
        }

        void output() {
            for (int i = 0; i < k; ++i) {
                System.out.printf("%d ", data[i]);
            }
            System.out.printf("%d %d\n", l, r);
        }
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)

}