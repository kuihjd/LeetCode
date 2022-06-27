package leetcode.editor.cn;

import java.util.*;

public class ShunShiZhenDaYinJuZhenLcof {
    public static void main(String[] args) {
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int[] res;
        int x = 0, y = 0;
        int p = 0;
        boolean[][] v;
        public int[] spiralOrder(int[][] matrix) {
            int lenX = matrix.length;
            if (lenX == 0) return new int[0];
            int lenY = matrix[0].length;
            v = new boolean[lenX][lenY];
            res = new int[lenX * lenY];
            while(true){
                boolean t = false;
                for(int i = 0; i < 4; ++i){
                    t = dfs(lenX, lenY, matrix, i) || t;
                }
                if(!t) return res;
            }
        }

        boolean dfs(int w, int h, int[][] matrix, int m){
            if(x < 0 || x == w || y < 0 || y == h || v[x][y]) {
                x -= dx[m];
                y -= dy[m];
                return false;
            }
            System.out.println(x + " " + y);
            v[x][y] = true;
            res[p++] = matrix[x][y];
            x += dx[m];
            y += dy[m];
            dfs(w, h, matrix, m);
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}