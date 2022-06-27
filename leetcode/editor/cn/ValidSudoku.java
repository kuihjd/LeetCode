package leetcode.editor.cn;

public class ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new ValidSudoku().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            boolean[][] row = new boolean[9][9];
            boolean[][] col = new boolean[9][9];
            boolean[][] block = new boolean[9][9];
            char now=0;
            for (int i = 0; i < 9; ++i) {
                row[i] = new boolean[9];
                col[i] = new boolean[9];
                block[i] = new boolean[9];
            }
            //0:横 1:竖 2:块
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    now=board[i][j];
                    if (now == '.') continue;
                    now-='1';
                    if(row[i][now]) return false;
                    if(col[j][now]) return false;
                    boolean[] k = block[i / 3 + (j / 3) * 3];
                    if(k[now]) return false;
                    row[i][now]=true;
                    col[j][now]=true;
                    k[now]=true;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}