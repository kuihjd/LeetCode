package leetcode.editor.cn;
public class MaximumNestingDepthOfTheParentheses{
    public static void main(String[] args) {
        Solution solution = new MaximumNestingDepthOfTheParentheses().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDepth(String s) {
        int res=0,t=0;
        for(char i:s.toCharArray()){
            if(i=='('){
                res=Math.max(res,++t);
            }
            else if(i==')'){
                t--;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}