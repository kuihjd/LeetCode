package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        Solution solution = new PacificAtlanticWaterFlow().new Solution();
        solution.Solution();
        solution.pacificAtlantic(LeetCodeDataStruct.parserTwoIntArray(
                "[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]"
        ));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void Solution() {
            System.out.println("方法");
        }
        static int[] d = new int[]{0, -1, 0, 1, 0};
        int[][] map;

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            int m = heights.length;
            int n = heights[0].length;
            map = new int[m][n];
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < m; ++i) {
                bfs(heights, 1, i, 0);
                bfs(heights, 2, i, n - 1);
            }
            for (int i = 0; i < n; ++i) {
                bfs(heights, 1, 0, i);
                bfs(heights, 2, m - 1, i);
            }
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (map[i][j] == 3) res.add(List.of(i, j));
                }
            }
//            Collections.sort(res, (v1, v2) -> v1.get());
            return res;
        }

        void bfs(int[][] heights, int v, int x, int y) {
            if ((map[x][y] | v) == map[x][y]) return;
            LinkedList<int[]> arr = new LinkedList<>();
            arr.add(new int[]{x, y});
            while (!arr.isEmpty()) {
                LinkedList<int[]> next = new LinkedList<>();
                while (!arr.isEmpty()) {
                    int[] t = arr.pollFirst();
                    x = t[0];
                    y = t[1];
                    map[x][y] |= v;
                    for (int i = 0; i < 4; ++i) {
                        int nx = x + d[i];
                        int ny = y + d[i + 1];
                        if (!check(nx, ny, heights)) continue;
                        if ((map[nx][ny] | v) == map[nx][ny]) continue;
                        if (heights[nx][ny] < heights[x][y]) continue;
                        System.out.printf("%d %d\n", nx, ny);
                        next.add(new int[]{nx, ny});
                    }
                }
                arr = next;
            }
        }

        boolean check(int x, int y, int[][] heights) {
            if (x < 0 || x >= heights.length) return false;
            if (y < 0 || y >= heights[0].length) return false;
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}