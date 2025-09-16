package leetcode.editor.cn;

import java.util.PriorityQueue;

public class TotalCostToHireKWorkers {
    public static void main(String[] args) {

        Solution solution = new TotalCostToHireKWorkers().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long totalCost(int[] costs, int k, int candidates) {
            int n = costs.length;
            // l, r 下一个
            int l = candidates, r = n - 1 - candidates;

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            });
            long res = 0;
            for (int i = 0; i < Math.min(n / 2, candidates); ++i) {
                pq.offer(new int[]{costs[i], i});
                pq.offer(new int[]{costs[n - i - 1], n - i - 1});
            }
            if (n / 2 < candidates && n % 2 == 1) {
                pq.offer(new int[]{costs[n / 2], n / 2});
            }
            for (int i = 0; i < k; ++i) {
                int[] cur = pq.poll();
                if (cur == null) {
                    return res;
                }
                res += cur[0];
                if (l > r) {
                    continue;
                }
                if (cur[1] < l) {
                    pq.offer(new int[]{costs[l], l});
                    ++l;
                } else {
                    pq.offer(new int[]{costs[r], r});
                    --r;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}