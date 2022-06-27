package leetcode.editor.cn;
public class IncreasingTripletSubsequence{
    public static void main(String[] args) {
        Solution solution = new IncreasingTripletSubsequence().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int a=nums[0];
        int b=a;
        int maxValue = Integer.MAX_VALUE;
        for(int i:nums){
            if(i<=a) a=i;
            else if(i<=b) b=i;
            else return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}