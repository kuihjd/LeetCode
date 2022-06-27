package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class MinimumObstacleRemovalToReachCorner {
    public static void main(String[] args) {
        Solution solution = new MinimumObstacleRemovalToReachCorner().new Solution();
        solution.minimumObstacles(LeetCodeDataStruct.parserTwoIntArray("[[0,1,1],[1,1,0],[1,1,0]]"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumObstacles(int[][] grid) {
            int[] d = new int[]{0, -1, 0, 1, 0};
            int m = grid.length, n = grid[0].length;
            int[][] mar = new int[m][n];
            for (int i = 0; i < m; ++i) Arrays.fill(mar[i], 99999999);
            // [消费, 到目的地总消费, 目的地x, 目的地y]
            PriorityQueue<int[]> pq = new PriorityQueue<>((v1, v2) -> v1[0] - v2[0]);
            LinkedList<int[]> linkedList = new LinkedList<>();
            pq.add(new int[]{0, 0, 0, 0});
            linkedList.add(new int[]{0, 0, 0, 0});
            while (!linkedList.isEmpty()) {
                int[] cur = linkedList.pollFirst();
                int c = cur[0], tc = cur[1], x = cur[2], y = cur[3];
                if (x == m - 1 && y == n - 1) return tc;
                if (mar[x][y] > tc) {
                    mar[x][y] = tc;
                    for (int i = 0; i < 4; i++) {
                        int dx = d[i] + x, dy = d[i + 1] + y;
                        if (check(dx, dy, m, n)) {
                            int[] tar = new int[]{grid[dx][dy], tc + grid[dx][dy], dx, dy};
                            if (grid[dx][dy] == 0) linkedList.addFirst(tar);
                            else linkedList.addLast(tar);
                        }
                    }
                }
            }
            return -1;
        }

        private boolean check(int x, int y, int m, int n) {
            if (x < 0 || x >= m) return false;
            if (y < 0 || y >= n) return false;
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}