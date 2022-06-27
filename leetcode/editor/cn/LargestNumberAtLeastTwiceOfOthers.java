package leetcode.editor.cn;
public class LargestNumberAtLeastTwiceOfOthers{
    public static void main(String[] args) {
        Solution solution = new LargestNumberAtLeastTwiceOfOthers().new Solution();
        solution.dominantIndex(new int[]{3,6,1,0});
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int dominantIndex(int[] nums) {
        int a=nums[0];
        int al=0;
        int i=1;
        while(i<nums.length&&nums[i]==a){
            i++;
        }
        if(i>=nums.length) return -1;
        int b=nums[i];
        int bl=i;
        if(a<b){
            int t=a;
            al=i;
            a=b;
            b=t;
        }

        while(i<nums.length){
            if(nums[i]>a){
                bl=al;
                al=i;
                b=a;
                a=nums[i];

            }
            else if(nums[i]>b){
                bl=i;
                b=nums[i];
            }
            i++;
        }
        return b*2<=a?al:-1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)



}