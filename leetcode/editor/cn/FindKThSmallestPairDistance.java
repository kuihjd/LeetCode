package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class FindKThSmallestPairDistance {
    public static void main(String[] args) {
        Solution solution = new FindKThSmallestPairDistance().new Solution();
        solution.smallestDistancePair(new int[]{9,10,7,10,6,1,5,4,9,8}, 18);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int smallestDistancePair(int[] nums, int k) {
            Arrays.sort(nums);
            int l = 0, r = (int) 1e6;
            while (l < r) {
                //[l,m - 1],[m,r]
                // 给的够, 可以缩小
                // 给的不够, 必须变大
                int m = l + r >> 1;
                if (check(nums, m) >= k) r = m;
                else l = m + 1;
            }
            return r;
        }

        int check(int[] nums, int n) {
            // <=n的数对数量
            int res = 0;
            int l = 0, r = 0;
            int len = nums.length;
            while (r <= len) {
                while (r < len && nums[l] + n >= nums[r]) r++;
                int rn = r != len ? nums[r] : 999999999;
                while (l < r && nums[l] + n < rn) {
                    res += r - l - 1;
                    l++;
                }
                r++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}