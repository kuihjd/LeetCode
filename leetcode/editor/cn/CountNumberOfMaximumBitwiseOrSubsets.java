package leetcode.editor.cn;
import java.util.*;
public class CountNumberOfMaximumBitwiseOrSubsets{
    public static void main(String[] args) {
        Solution solution = new CountNumberOfMaximumBitwiseOrSubsets().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int max = 0, res = 0;
    public int countMaxOrSubsets(int[] nums) {
        for(int i : nums) max |= i;
        dfs(nums, 0, true, 0);
        dfs(nums, 0, false, 0);
        return res;
    }

    void dfs(int[] nums, int l, boolean m, int cur){
        if(l >= nums.length) return;
        if(m){
            cur |= nums[l];
            if(cur == max) res++;
        }
        dfs(nums, l + 1, true, cur);
        dfs(nums, l + 1, false, cur);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    }