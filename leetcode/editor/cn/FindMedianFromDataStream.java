package leetcode.editor.cn;

import java.util.*;
import java.io.*;
// 295
//中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例： 
//
// addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2 
//
// 进阶: 
//
// 
// 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 👍 740 👎 0


// 2022-08-30 14:19:02
public class FindMedianFromDataStream {
    public static void main(String[] args) {
        MedianFinder medianFinder = new FindMedianFromDataStream().new MedianFinder();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {
        PriorityQueue<Integer> q1 = new PriorityQueue<>();
        PriorityQueue<Integer> q2 = new PriorityQueue<>((a, b) -> b - a);
        int n = 0;
        public MedianFinder() {

        }

        public void addNum(int num) {
            if (q1.isEmpty()) {
                q1.add(num);
            } else {
                if (q1.peek() >= num) {
                    q1.add(num);
                } else {
                    q2.add(num);
                }
            }
            while (q1.size() > q2.size() + 1) {
                q2.add(q1.poll());
            }
            while (q1.size() <= q2.size()) {
                q1.add(q2.poll());
            }
            ++n;
        }

        public double findMedian() {
            if ((n & 1) == 0) {
                return ((double) q1.peek() + q2.peek()) / 2;
            } else {
                return (double) q1.peek();
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}