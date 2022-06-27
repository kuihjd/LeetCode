package leetcode.editor.cn;
public class MaximumProductOfWordLengths{
    public static void main(String[] args) {
        Solution solution = new MaximumProductOfWordLengths().new Solution();
        solution.maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"});
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(String[] words) {
        int[] f=new int[words.length];
        int res=0;
        for(int i=0;i<words.length;++i){
            for(int j=0;j<words[i].length();++j){
                f[i]|=1<<words[i].charAt(j)-'a';
            }
        }
        for(int i=0;i<words.length;++i){
            for(int j=i+1;j<words.length;++j){
                if((f[i]&f[j])==0)
                    res=Math.max(res,words[i].length()*words[j].length());
            }

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}