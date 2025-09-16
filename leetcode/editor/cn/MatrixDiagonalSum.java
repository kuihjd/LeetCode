package leetcode.editor.cn;

public class MatrixDiagonalSum {
    public static void main(String[] args) {

        Solution solution = new MatrixDiagonalSum().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int diagonalSum(int[][] mat) {
            int n = mat.length;
            int res = 0;
            for (int i = 0; i < n; ++i) {
                res += mat[i][i];
                res += mat[i][n - i - 1];
            }
            if (n % 2 == 1) {
                res -= mat[n / 2][n / 2];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}