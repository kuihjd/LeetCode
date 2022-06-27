package leetcode.editor.cn;
public class ConvertANumberToHexadecimal{
    public static void main(String[] args) {
        Solution solution = new ConvertANumberToHexadecimal().new Solution();
        solution.toHex(-1);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    static char[] mapping=new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    public String toHex(int num) {
        StringBuilder res= new StringBuilder();
        for(int i=0;i<8;++i){
            res.insert(0, mapping[(num>>i*4)&15]);
        }
        while(res.charAt(0)=='0')res.deleteCharAt(0);
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}