package leetcode.editor.cn;

public class MaximumAbsoluteSumOfAnySubarray{
    public static void main(String[] args) {
    	
        Solution solution = new MaximumAbsoluteSumOfAnySubarray().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int[] pn = new int[n];
        int[] nn = new int[n];
        int res = 0;
        pn[0] = nums[0];
        nn[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            pn[i] = Math.max(pn[i - 1] + nums[i], nums[i]);
            nn[i] = Math.min(nn[i - 1] + nums[i], nums[i]);
            res = Math.max(res, Math.max(pn[i], Math.abs(nn[i])));
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}