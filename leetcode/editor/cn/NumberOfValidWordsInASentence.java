package leetcode.editor.cn;
public class NumberOfValidWordsInASentence{
    public static void main(String[] args) {
        Solution solution = new NumberOfValidWordsInASentence().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countValidWords(String sentence) {
        String regex = "([a-z]+(-[a-z]+)?)?[!.,]?";
        int ans = 0;
        for(String i:sentence.split(" ")){
            if(i.matches(regex) && i.length() > 0) ans++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}