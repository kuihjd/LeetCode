//给你一个 m x n 的矩阵 mat 和一个整数 k ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 ma
//t[r][c] 的和： 
//
// 
// i - k <= r <= i + k, 
// j - k <= c <= j + k 且 
// (r, c) 在矩阵内。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
//输出：[[12,21,16],[27,45,33],[24,39,28]]
// 
//
// 示例 2： 
//
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
//输出：[[45,45,45],[45,45,45],[45,45,45]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n, k <= 100 
// 1 <= mat[i][j] <= 100 
// 
// Related Topics 数组 矩阵 前缀和 
// 👍 90 👎 0

package leetcode.editor.cn;
//Java：矩阵区域和
public class MatrixBlockSum{
    public static void main(String[] args) {
        Solution solution = new MatrixBlockSum().new Solution();
        // TO TEST
        solution.matrixBlockSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}},1);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] matrixBlockSum(int[][] mat, int k) {
            int m=mat.length;
            int n=mat[0].length;
            int[][] dp=new int [m][n];
            int[][] res=new int [m][n];
            int l=0,t=0,lt=0,rb=0;
            for(int i=0;i<m;++i){
                dp[i]=mat[i].clone();
            }
            for(int i=1;i<n;++i){
                dp[0][i]+=dp[0][i-1];
            }
            for(int i=1;i<m;++i){
                dp[i][0]+=dp[i-1][0];
                for(int j=1;j<n;++j){
                    dp[i][j]+=dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1];
                }
            }
            for(int i=0;i<m;++i){
                for(int j=0;j<n;++j){
                    rb=dp[Math.min(i+k,m-1)][Math.min(j+k,n-1)];//没错
                    t=i-k>0?dp[i-k-1][Math.min(n-1,j+k)]:0;
                    l=j-k>0?dp[Math.min(m-1,i+k)][j-k-1]:0;
                    lt=j-k>0&&i-k>0?dp[i-k-1][j-k-1]:0;
                    res[i][j]=rb-l-t+lt;
                }
            }//[[12,21,16],[27,45,33],[24,39,28]]
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}