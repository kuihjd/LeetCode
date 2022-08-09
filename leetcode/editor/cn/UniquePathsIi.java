package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class UniquePathsIi {
    public static void main(String[] args) {
        Solution solution = new UniquePathsIi().new Solution();
        solution.uniquePathsWithObstacles(LeetCodeDataStruct.parserTwoIntArray("[[0,0]]"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length, n = obstacleGrid[0].length;
            if (obstacleGrid[m - 1][n - 1] == 1) return 0;
            if (obstacleGrid[0][0] == 1) return 0;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; j++) {
                    obstacleGrid[i][j] *= -1;
                }
            }
            obstacleGrid[0][0] = 1;
            HashSet<Integer> cur = new HashSet<>();
            cur.add(0);
            while (!cur.isEmpty()) {
                HashSet<Integer> next = new HashSet<>();
                for (int i : cur) {
                    int x = i / 100, y = i % 100;
                    int x1 = x + 1, y1 = y + 1;
                    if (x1 < m && obstacleGrid[x1][y] != -1) {
                        next.add(x1 * 100 + y);
                        obstacleGrid[x1][y] += obstacleGrid[x][y];
                    }
                    if (y1 < n && obstacleGrid[x][y1] != -1) {
                        next.add(x * 100 + y1);
                        obstacleGrid[x][y1] += obstacleGrid[x][y];
                    }
                }
                cur = next;
            }
            return obstacleGrid[m - 1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}