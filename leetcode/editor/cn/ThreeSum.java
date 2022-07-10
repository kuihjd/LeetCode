package leetcode.editor.cn;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i : nums) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            if (map.getOrDefault(0, 0) >= 3) res.add(createAns(0, 0, 0));
            int len = map.size();
            int[][] cnt = new int[len][2];

            int t = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                cnt[t][0] = entry.getKey();
                cnt[t][1] = entry.getValue();
                t++;
            }

            for (int i = 0; i < len; i++) {
                int k1 = cnt[i][0];
                int v1 = cnt[i][1];
                if (k1 < 0) {
                    // 1个k1和2个-k1/2
                    if (k1 % 2 == 0 && map.getOrDefault(-k1 / 2, 0) >= 2) res.add(createAns(k1, -k1 / 2, -k1 / 2));
                    // 2个k1和-2*k1
                    if (v1 >= 2 && map.getOrDefault(-2 * k1, 0) >= 1) res.add(createAns(k1, k1, -2 * k1));
                    for (int j = i + 1; j < len; j++) {
                        int k2 = cnt[j][0];
                        int k3 = -k1 - k2;
                        if (k3 > k2 && map.containsKey(k3)) res.add(createAns(k1, k2, k3));
                    }
                } else break;
            }

            return res;
        }

        List<Integer> createAns(int n1, int n2, int n3) {
            List<Integer> res = new ArrayList<>();
            res.add(n1);
            res.add(n2);
            res.add(n3);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}