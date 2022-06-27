package leetcode.editor.cn;

import java.util.*;

public class IslandPerimeter {
    public static void main(String[] args) {
        Solution solution = new IslandPerimeter().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static int[] d = new int[]{0, -1, 0, 1, 0};

        public int islandPerimeter(int[][] grid) {
            int res = 0;
            for(int i = 0; i < grid.length; ++i){
                for(int j = 0; j < grid[0].length; ++j){
                    if(grid[i][j] == 1){
                        res += 4;
                        for(int k = 0; k < 4; ++k){
                            if(check(i + d[k], j + d[k + 1], grid)) res--;
                        }
                    }
                }
            }
            return res;
        }

        boolean check(int x, int y, int[][] grid) {
            if (x < 0 || y < 0) return false;
            if (x >= grid.length || y >= grid[0].length) return false;
            return grid[x][y] != 0;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}