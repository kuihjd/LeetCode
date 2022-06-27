package leetcode.editor.cn;

import java.util.*;

public class CountNodesWithTheHighestScore {
    public static void main(String[] args) {
        Solution solution = new CountNodesWithTheHighestScore().new Solution();
        solution.countHighestScoreNodes(new int[]{-1, 3, 3, 5, 7, 6, 0, 0});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        long[] val;
        int[] sub1, sub2;

        public int countHighestScoreNodes(int[] parents) {
            int len = parents.length;
            sub1 = new int[len];
            sub2 = new int[len];
            val = new long[len];
            Arrays.fill(sub1, -1);
            Arrays.fill(sub2, -1);
            HashSet<Integer> leaf = new HashSet<>();
            for (int i = 0; i < len; ++i) leaf.add(i);
            for (int i = 0; i < len; ++i) {
                int n = parents[i];
                if (n == -1) continue;
                leaf.remove(n);
                if (sub1[n] == -1) sub1[n] = i;
                else sub2[n] = i;
            }
            HashSet<Integer> set = new HashSet<>();
            for (int i : leaf) {
                int parent = parents[i];
                val[parent]++;
                set.add(parent);
            }
            /*废案 tle
            while (!set.isEmpty()) {
                HashSet<Integer> tset = new HashSet<>();
                for (int i : set) {
                    if(i == -1) continue;//0 的爹就算了
                    long v1 = sub1[i] == -1 ? 0 : val[sub1[i]] + 1;
                    long v2 = sub2[i] == -1 ? 0 : val[sub2[i]] + 1;
                    val[i] = v1 + v2;
                    tset.add(parents[i]);
                    //修改自己的值并且通知父节点修改值
                }
                set = tset;
            }*/
            val[0] = dfs(0);
            long max = (sub1[0] == -1 ? 1 : val[sub1[0]] + 1) * (sub2[0] == -1 ? 1 : val[sub2[0]] + 1);
            HashMap<Long, Integer> map = new HashMap<>();

            map.put(max, 1);
            for (int i = 1; i < len; ++i) {
                long v1 = sub1[i] == -1 ? 1 : val[sub1[i]] + 1;
                long v2 = sub2[i] == -1 ? 1 : val[sub2[i]] + 1;
                long v3 = val[0] - val[i];
                long now = v1 * v2 * v3;
                if (max < now) max = now;
                map.put(now, map.getOrDefault(now, 0) + 1);
            }
            return map.get(max);
        }

        int dfs(int parent) {
            if (sub1[parent] == -1 && sub2[parent] == -1) return 0;
            int val1 = sub1[parent] == -1 ? 0 : dfs(sub1[parent]) + 1;
            int val2 = sub2[parent] == -1 ? 0 : dfs(sub2[parent]) + 1;
            val[parent] = val1 + val2;
            return val1 + val2;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}