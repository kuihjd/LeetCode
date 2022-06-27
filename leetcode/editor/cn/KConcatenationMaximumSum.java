package leetcode.editor.cn;

/**
 * @author daijiyong * @date    2021-09-04 00:55:36
 */
public class KConcatenationMaximumSum {
    public static void main(String[] args) {
        Solution solution = new KConcatenationMaximumSum().new Solution();
        System.out.println(solution.kConcatenationMaxSum(new int[]{1,-2,1}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kConcatenationMaxSum(int[] arr, int k) {
            int mod = 1000000007;
            int dp = 0;
            int cnt = 0;
            int maxSubArrSum = 0;
            int minLeftSubArrSum = 0;
            int maxLeftSubArrSum = 0;
            int maxRightSubArrSum = 0;
            for (int i : arr) {
                dp = Math.max(dp + i, i);
                maxSubArrSum = Math.max(maxSubArrSum, dp);
                cnt += i;
                minLeftSubArrSum = Math.min(minLeftSubArrSum, cnt);
                maxLeftSubArrSum = Math.max(maxLeftSubArrSum, cnt);
            }
            maxRightSubArrSum=cnt-minLeftSubArrSum;
            if (k == 1) return maxSubArrSum % mod;
            if (cnt <= 0) return (Math.max(maxLeftSubArrSum + maxRightSubArrSum, maxSubArrSum)) % mod;
            return (int)((maxLeftSubArrSum + maxRightSubArrSum + (double)cnt * (k - 2)) % mod);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}