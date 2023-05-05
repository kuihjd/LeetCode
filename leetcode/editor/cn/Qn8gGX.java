package leetcode.editor.cn;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
// 剑指 Offer II 061
//给定两个以升序排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。 
//
// 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。 
//
// 请找到和最小的 k 个数对 (u1,v1), (u2,v2) ... (uk,vk) 。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//输出: [1,2],[1,4],[1,6]
//解释: 返回序列中的前 3 对数：
//    [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// 
//
// 示例 2: 
//
// 
//输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//输出: [1,1],[1,1]
//解释: 返回序列中的前 2 对数：
//     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// 
//
// 示例 3: 
//
// 
//输入: nums1 = [1,2], nums2 = [3], k = 3 
//输出: [1,3],[2,3]
//解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums1.length, nums2.length <= 10⁴ 
// -10⁹ <= nums1[i], nums2[i] <= 10⁹ 
// nums1, nums2 均为升序排列 
// 1 <= k <= 1000 
// 
//
// 
//
// 注意：本题与主站 373 题相同：https://leetcode-cn.com/problems/find-k-pairs-with-smallest-
//sums/ 
// Related Topics 数组 堆（优先队列） 👍 45 👎 0


// 2022-08-31 11:17:40
public class Qn8gGX {
    public static void main(String[] args) {
        Solution solution = new Qn8gGX().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<List<Integer>> ans = new ArrayList<>();

            int m = nums1.length, n = nums2.length;
            if (k >= m * n) {
                for (int i : nums1) {
                    for (int j : nums2) {
                        ans.add(List.of(i, j));
                    }
                }
                return ans;
            }
            int l = (int) -1e10, r = (int) 1e10, t = l + r / 2;
            for (int i = 0; i < n; ++i) {
                map.put(nums1[i], i);
            }
            // [l, m) [m, r]
            ans.sort((v1, v2) -> v1.get(0) + v1.get(1) - v2.get(0) - v2.get(1));
            return ans;
        }

        private int check(int[] nums, TreeMap<Integer, Integer> map, int v) {
            int res = 0;

            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}