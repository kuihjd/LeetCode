package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;

public class ThirdMaximumNumber{
    public static void main(String[] args) {
        Solution solution = new ThirdMaximumNumber().new Solution();
        solution.thirdMax(new int[]{5,2,4,1,3,6,0});
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int thirdMax(int[] nums) {
        int[] arr=new int[]{Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
        int p=1;
        arr[0]=nums[0];
        int i=1;
        for(;i< nums.length;++i){
            if (nums[i]!=arr[0]) {
                arr[p++]=nums[i];
                ++i;
                break;
            }
        }
        for(;i< nums.length;++i){
            if (nums[i]!=arr[0]&&nums[i]!=arr[1]) {
                arr[p++]=nums[i];
                ++i;
                break;
            }
        }
        Arrays.sort(arr);
        for(;i< nums.length;++i){
            if(nums[i]==arr[2]||nums[i]==arr[1])continue;
            if(nums[i]<=arr[0])continue;
            arr[0]=nums[i];
            if(nums[i]<=arr[1])continue;
            arr[0]=arr[1];
            arr[1]=nums[i];
            if(nums[i]<=arr[2])continue;
            arr[1]=arr[2];
            arr[2]=nums[i];
        }
        if(p<3) return arr[2];
        return arr[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}