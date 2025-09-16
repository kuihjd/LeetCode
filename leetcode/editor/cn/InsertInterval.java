package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {

        Solution solution = new InsertInterval().new Solution();
//        solution.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
        solution.insert(new int[][]{{1, 5}}, new int[]{2, 7});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int start = newInterval[0], end = newInterval[1];
            int n = intervals.length;
            if (n == 0) {
                return new int[][]{{start, end}};
            }
            List<int[]> res = new ArrayList<>();
            int i = 0;
            int rs = start, re = end;
            if (start < intervals[0][0]) {
                rs = start;
            } else {
                for (; i < n; ++i) {
                    if (intervals[i][0] <= start && start <= intervals[i][1]) {
                        rs = intervals[i][0];
                        break;
                    } else if (start > intervals[i][1]) {
                        res.add(intervals[i]);
                    } else {
                        rs = start;
                        break;
                    }
                }
            }
            if (end > intervals[n - 1][1]) {
                re = end;
                i = n;
            } else {
                for (; i < n; ++i) {
                    if (intervals[i][0] <= end && end <= intervals[i][1]) {
                        re = intervals[i][1];
                        ++i;
                        break;
                    } else if(intervals[i][0] > end){
                        re = end;
                        break;
                    }
                }
            }
            res.add(new int[]{rs, re});
            for (; i < n; ++i) {
                res.add(intervals[i]);
            }
            return res.toArray(new int[0][0]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}