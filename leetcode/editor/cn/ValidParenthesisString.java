package leetcode.editor.cn;
public class ValidParenthesisString{
    public static void main(String[] args) {
        Solution solution = new ValidParenthesisString().new Solution();
        solution.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkValidString(String s) {
        int l=0,w=0,r=0,t=0;
        char[] ca=s.toCharArray();
        for(char c:ca){
            if(c=='(') {
                l++;
            }
            else if(c=='*'){
                w++;
            }
            else {
                if(l>0){
                    l--;
                }
                else if(w>0){
                    w--;
                }
                else{
                    return false;
                }
            }
            t=100;
        }
        if(w<l) return false;
        w=0;
        for(int i=ca.length-1;i>=0;--i){
            if(ca[i]==')'){
                r++;
            }
            else if(ca[i]=='*'){
                w++;
            }
            else {
                if(r>0){
                    r--;
                }
                else if(w>0){
                    w--;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}