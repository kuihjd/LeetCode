package leetcode.editor.cn;
import java.util.*;
public class NgeTouZiDeDianShuLcof{
    public static void main(String[] args) {
        Solution solution = new NgeTouZiDeDianShuLcof().new Solution();
        solution.dicesProbability(2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double[] dicesProbability(int n) {
            int[][] map = new int[70][70];
            for(int i = 1; i <= 6; ++i) map[1][i] = 1;
            for(int i = 2; i <= n; ++i){
                for(int j = i - 1; j <= (i - 1) * 6; ++j){
                    for(int k = 1; k <= 6; ++k){
                        map[i][j + k] += map[i - 1][j];
                    }
                }
            }
            int start = n, end = n * 6;
            double[] res = new double[end - start + 1];
            long cnt = 0;
            for(int i = start; i <= end; ++i){
                cnt += map[n][i];
            }

            for(int i = start; i <= end; ++i){
                res[i - start] = (double)map[n][i] / cnt;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    }