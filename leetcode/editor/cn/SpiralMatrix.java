package leetcode.editor.cn;

import java.util.*;

public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> res = new ArrayList<>();
        int x = 0, y = 0;
        int[][] matrix;
        public List<Integer> spiralOrder(int[][] matrix) {
            this.matrix = matrix;
            f1();
            return res;
        }

        void f1(){
            if(x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length ) return;
            if(matrix[x][y] == 400) return;
            while(y < matrix[0].length && matrix[x][y] != 400){
                res.add(matrix[x][y]);
                matrix[x][y] = 400;
                y++;
            }
            y--;
            x++;
            f2();
        }

        void f2(){
            if(x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length ) return;
            if(matrix[x][y] == 400) return;
            while(x < matrix.length && matrix[x][y] != 400){
                res.add(matrix[x][y]);
                matrix[x][y] = 400;
                x++;
            }
            x--;
            y--;
            f3();
        }

        void f3(){
            if(x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length ) return;
            if(matrix[x][y] == 400) return;
            while(y >= 0 && matrix[x][y] != 400){
                res.add(matrix[x][y]);
                matrix[x][y] = 400;
                y--;
            }
            y++;
            x--;
            f4();
        }

        void f4(){
            if(x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length ) return;
            if(matrix[x][y] == 400) return;
            while(x >= 0 && matrix[x][y] != 400){
                res.add(matrix[x][y]);
                matrix[x][y] = 400;
                x--;
            }
            y++;
            x++;
            f1();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}