package leetcode.editor.cn;

import java.util.Arrays;

public class ShuffleAnArray{
    public static void main(String[] args) {
        Solution solution = new ShuffleAnArray().new Solution(new int[]{});
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] souce;
    public Solution(int[] nums) {
        souce=nums;
    }

    public int[] reset() {
        return souce;
    }

    public int[] shuffle() {
        int[] res= souce.clone();
        int t=0,r=0;
        for(int i=res.length-1;i>0;--i){
            r=(int)(Math.random()*res.length);
            t=res[i];
            res[i]=res[r];
            res[r]=t;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
//leetcode submit region end(Prohibit modification and deletion)

}