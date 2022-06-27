package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int l = 0, r = 0;
            PriorityQueue<Integer> que = new PriorityQueue<>((v1, v2) -> v2.compareTo(v1));
            PriorityQueue<Integer> del = new PriorityQueue<>((v1, v2) -> v2.compareTo(v1));
            int len = nums.length;
            int[] res = new int[len - k];
            for (int i = 0; i < k; ++i) {
                que.add(nums[i]);
            }
            res[0] = que.peek();
            while (r < len) {
                del.add(nums[l++]);
                que.add(nums[r++]);
                while (!del.isEmpty() && del.peek().equals(que.peek())) {
                    del.poll();
                    que.poll();
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}