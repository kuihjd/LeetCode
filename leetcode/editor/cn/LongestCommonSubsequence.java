//给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。 
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
//
// 
// 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。 
// 
//
// 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace" ，它的长度为 3 。
// 
//
// 示例 2： 
//
// 
//输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc" ，它的长度为 3 。
// 
//
// 示例 3： 
//
// 
//输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text1.length, text2.length <= 1000 
// text1 和 text2 仅由小写英文字符组成。 
// 
// Related Topics 字符串 动态规划 
// 👍 624 👎 0

package leetcode.editor.cn;
//Java：最长公共子序列
public class LongestCommonSubsequence{
    public static void main(String[] args) {
        Solution solution = new LongestCommonSubsequence().new Solution();
        solution.longestCommonSubsequence("bsbininm","jmjkbkjkv");
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            char[] c1=text1.toCharArray();
            char[] c2=text2.toCharArray();
            int m=c1.length;
            int n=c2.length;
            int[][] dp=new int[m+1][n+1];
            for(int i=0;i<m;++i){
                for(int j=0;j<n;++j){
                    int tmp=Math.max(dp[i][j],dp[i+1][j]);
                    dp[i+1][j+1]=tmp+(c1[i]==c2[j]?1:0);
                }
            }
            return dp[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}