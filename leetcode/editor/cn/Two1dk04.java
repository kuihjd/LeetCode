package leetcode.editor.cn;
public class Two1dk04{
    public static void main(String[] args) {
    	
        Solution solution = new Two1dk04().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) return 0;

        int[][] dp = new int[m + 1][n + 1];

        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}