package leetcode.editor.cn;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum0(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<>();
            int n = nums.length;
            HashMap<Long, Integer> vm = new HashMap<>();
            for (int i = 0; i < n; ++i) {
                vm.put((long) nums[i], i);
            }
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    for (int k = j + 1; k < n; ++k) {
                        long t = (long) target - nums[i] - nums[j] - nums[k];
                        // System.out.println(t + " = " + vm.get(t));
                        Integer l = vm.get(t);
                        if (vm.get(t) != null && l > k) {
                            Integer[] arr = {nums[i], nums[j], nums[k], nums[l]};
                            Arrays.sort(arr);
                            res.add(List.of(arr));
                        }
                    }
                }
            }

            HashSet<List<Integer>> set = new HashSet<>(res);
            return set.stream().toList();
        }

        int count(int target, int v1, int v2, int v3, int v4) {
            int r = 0;
            if (v1 == target) r++;
            if (v2 == target) r++;
            if (v3 == target) r++;
            if (v4 == target) r++;
            return r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}