package leetcode.editor.cn;

import java.util.HashSet;

public class PowerOfThree{
    public static void main(String[] args) {
        Solution solution = new PowerOfThree().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    static HashSet<Integer> nums=new HashSet<Integer>();
    static{
        int n=3;
        while(n<Integer.MAX_VALUE&&n>0){
            nums.add(n);
            n*=3;
        }
    }
    public boolean isPowerOfThree(int n) {
        return nums.contains(n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}