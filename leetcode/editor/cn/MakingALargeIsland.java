package leetcode.editor.cn;

import java.util.*;

public class MakingALargeIsland {
    public static void main(String[] args) {
        Solution solution = new MakingALargeIsland().new Solution();
        solution.largestIsland(LeetCodeDataStruct.parserTwoIntArray("[[1,1],[1,1]]"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] grid;
        int len;
        int[][][] grouped; // 第i行第j列, 存放了一个序列为[i][j][0], 数量为[i][j][1]的岛
        int[] d = {0, -1, 0, 1, 0};
        int sequence = 1;
        public int largestIsland(int[][] grid) {
            this.grid = grid;
            len = grid.length;
            grouped = new int[len][len][2];
            int ans = 0;
            for (int i = 0; i < len; ++i) {
                for (int j = 0; j < len; ++j) {
                    if (grid[i][j] == 1) cal(i, j);
                }
            }
            for (int i = 0; i < len; ++i) {
                for (int j = 0; j < len; ++j) {
                    ans = Math.max(ans, convert(i, j));
                }
            }
            return ans;
        }

        void cal(int x, int y) {
            int cnt = 0;
            LinkedList<int[]> store = new LinkedList<>();
            LinkedList<int[]> query = new LinkedList<>();
            query.add(new int[]{x, y});
            grid[x][y] = 0;
            while (!query.isEmpty()) {
                int[] read = query.poll();
                cnt++;
                store.add(read);
                for (int i = 0; i < 4; ++i) {
                    int tx = read[0] + d[i];
                    int ty = read[1] + d[i + 1];
                    if (check(tx, ty) && grid[tx][ty] == 1) {
                        grid[tx][ty] = 0;
                        query.add(new int[]{tx, ty});
                    }
                }
            }
            for (int[] i : store) {
                grouped[i[0]][i[1]][0] = sequence;
                grouped[i[0]][i[1]][1] = cnt;
            }
            sequence++;
        }

        boolean check(int x, int y) {
            if (x < 0 || x >= len) return false;
            if (y < 0 || y >= len) return false;
            return true;
        }

        int convert (int x, int y) {
            if (grouped[x][y][0] != 0) return grouped[x][y][1];
            int res = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < 4; ++i) {
                int tx = x + d[i];
                int ty = y + d[i + 1];
                if (check(tx, ty)) {
                    map.put(grouped[tx][ty][0], grouped[tx][ty][1]);
                }
            }
            for (Integer value : map.values()) {
                res += value;
            }
            return res + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}