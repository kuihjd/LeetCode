package leetcode.editor.cn;

import java.util.*;

public class PathWithMaximumProbability {
    public static void main(String[] args) {

        Solution solution = new PathWithMaximumProbability().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
            double[] rcu = new double[n];
            Map<Integer, List<Pair>> pairMap = new HashMap<>();
            for (int i = 0; i < edges.length; ++i) {
                if (!pairMap.containsKey(edges[i][0])) {
                    pairMap.put(edges[i][0], new ArrayList<>());
                }
                if (!pairMap.containsKey(edges[i][1])) {
                    pairMap.put(edges[i][1], new ArrayList<>());
                }
                pairMap.get(edges[i][0]).add(new Pair(succProb[i], edges[i][0], edges[i][1]));
                pairMap.get(edges[i][1]).add(new Pair(succProb[i], edges[i][1], edges[i][0]));
            }
            if (!pairMap.containsKey(start_node) || !pairMap.containsKey(end_node)) {
                return 0;
            }
            Set<Integer> cur = new HashSet<>();
            cur.add(start_node);
            rcu[start_node] = 1;
            while (!cur.isEmpty()) {
                Set<Integer> next = new HashSet<>();
                for (int i : cur) {
                    for (Pair j : pairMap.get(i)) {
                        System.out.printf("i = %d, j.end = %d\n", i, j.end);
                        double nc = rcu[i] * j.prob;
                        if (nc > rcu[j.end]) {
                            next.add(j.end);
                            rcu[j.end] = nc;
                        }
                    }
                }
                cur = next;
            }
            return rcu[end_node];
        }

        static class Pair {
            double prob;
            int start;
            int end;

            public Pair(double prob, int start, int end) {
                this.prob = prob;
                this.start = start;
                this.end = end;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}