package leetcode.editor.cn;

import java.util.*;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        solution.largestRectangleArea(new int[]{2,1,5,6,2,3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            LinkedList<int[]> list = new LinkedList<>();
            int res = 0;
            int len = heights.length;
            for (int i = 0; i < len; ++i) {
                while (!list.isEmpty() && list.peekLast()[1] > heights[i]) {
                    int[] t = list.pollLast();
                    int[] t2 = list.peekLast();
                    int l = -1;
                    if(t2 != null) l = t2[0];
                    res = Math.max(res, (i - l - 1) * t[1]);
                }
                list.offerLast(new int[]{i, heights[i]});
            }
            int[] cur = list.pollLast(), pre;
            while (!list.isEmpty()) {
                pre = list.pollLast();
                res = Math.max(res, (len - pre[0] - 1) * cur[1]);
                cur = pre;
            }
            res = Math.max(res, cur[1] * len);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}