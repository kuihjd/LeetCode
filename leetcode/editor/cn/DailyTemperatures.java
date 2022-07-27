package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new DailyTemperatures().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int len = temperatures.length;
            int[] res = new int[len];
            // [0]为气温, [1]为所在天
//            PriorityQueue<int[]> pq = new PriorityQueue<>((v1, v2) -> v1[0] - v2[0]);
            LinkedList<int[]> list = new LinkedList<>();
            for (int i = 0; i < len; ++i) {
                int t = temperatures[i];
                while (!list.isEmpty() && list.peekLast()[0] < t) {
                    int d = list.pollLast()[1];
                    res[d] = i - d;
                }
                list.addLast(new int[]{t, i});
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}