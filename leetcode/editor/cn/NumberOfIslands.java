package leetcode.editor.cn;

import java.util.*;

public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static int[] d = new int[]{0, 1, 0, -1, 0};


        public int numIslands(char[][] grid) {
            int res = 0;
            for(int i = 0; i < grid.length; ++i){
                for(int j = 0; j < grid[0].length; ++j){
                    if(grid[i][j] == '1') {
                        res ++;
                        del(i, j, grid);
                    }
                }
            }
            return res;
        }

        void del(int x, int y, char[][] grid) {
            if(x < 0 || y < 0) return;
            if(x >= grid.length || y >= grid[0].length) return;
            if(grid[x][y] == '0') return;
            grid[x][y] = '0';
            for(int i =0; i < 4; ++i){
                del(x + d[i], y + d[i + 1], grid);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}