package leetcode.editor.cn;
public class RangeSumQuery2dImmutable{
    public static void main(String[] args) {

        NumMatrix solution = new RangeSumQuery2dImmutable().new NumMatrix(null);
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class NumMatrix {
    int[][] ms;
    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length ;
        ms = new int[n + 1][m + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                ms[i + 1][j + 1] = ms[i][j + 1] + ms[i + 1][j] - ms[i][j] + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return ms[row2 + 1][col2 + 1] - ms[row1][col2 + 1] - ms[row2 + 1][col1] + ms[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)

}