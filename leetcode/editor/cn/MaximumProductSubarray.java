package leetcode.editor.cn;
import java.util.*;
public class MaximumProductSubarray{
    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        int l = 0;
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] == 0) {
                res = Math.max(res, getSubArrMaxVal(nums, l, i - 1));
                l = i + 1;
            }
        }
        return res;
    }

    int getSubArrMaxVal(int[] nums, int l, int r){
        if(l > r) return nums[l];
        if(l == r) return nums[l];
        int total = 1;
        for(int i = l; i <= r; ++i){
            total *= nums[i];
        }
        if(total % 2 == 0) return total;
        int v1 = total, v2 = total;
        while(v1 < 0) v1 /= nums[l++];
        while(v2 < 0) v2 /= nums[r--];
        return Math.max(v1, v2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    }