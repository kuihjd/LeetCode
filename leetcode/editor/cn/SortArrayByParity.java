package leetcode.editor.cn;
import java.util.*;
import java.io.*;
public class SortArrayByParity {
    public static void main(String[] args) {
        Solution solution = new SortArrayByParity().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            while (l < r && nums[l] % 2 == 0) {
                l++;
            }
            while (l < r && nums[r] % 2 == 1) {
                r--;
            }
            System.out.println(nums[l] + " " + nums[r]);
            nums[l] += nums[r];
            nums[r] = nums[l] - nums[r];
            nums[l] -= nums[r];
            l++;
            r--;
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}