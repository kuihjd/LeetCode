package leetcode.editor.cn;

import java.util.*;

public class TheTimeWhenTheNetworkBecomesIdle {
    public static void main(String[] args) {
        Solution solution = new TheTimeWhenTheNetworkBecomesIdle().new Solution();
        solution.networkBecomesIdle(new int[][]{{0, 1}, {1, 2}}, new int[]{0, 2, 1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] routeLen;
        HashMap<Integer, ArrayList<Integer>> routes = new HashMap<>();

        public int networkBecomesIdle(int[][] edges, int[] patience) {
            for (int i = 0; i < patience.length; ++i) {
                routes.put(i, new ArrayList<>());
            }
            for (int[] i : edges) {
                routes.get(i[0]).add(i[1]);
                routes.get(i[1]).add(i[0]);
            }
            int len = patience.length;
            routeLen = new int[len];
            Arrays.fill(routeLen, Integer.MAX_VALUE);
            bfs();
            int res = 0;
            for (int i = 1; i < len; ++i) {
                int consume = routeLen[i] * 2;
                int last = (consume - 1) / patience[i] * patience[i];
                res = Math.max(res, last + consume);
            }
            return res + 1;
        }

        void bfs() {
            HashSet<Integer> cur = new HashSet<>();
            cur.add(0);
            int timer = 0;
            while (!cur.isEmpty()) {
                HashSet<Integer> t = new HashSet<>();
                for (int i : cur) {
                    if (routeLen[i] <= timer) continue;
                    routeLen[i] = timer;
                    t.addAll(routes.get(i));
                }
                timer++;
                cur = t;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}