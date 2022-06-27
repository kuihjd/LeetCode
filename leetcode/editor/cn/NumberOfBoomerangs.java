package leetcode.editor.cn;

import java.util.HashMap;

public class NumberOfBoomerangs {
    public static void main(String[] args) {
        Solution solution = new NumberOfBoomerangs().new Solution();
        solution.numberOfBoomerangs(new int[][]{{0,0},{1,0},{2,0}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfBoomerangs(int[][] points) {
            int len = points.length;
            int distance = 0;
            int num = 0;
            HashMap<Integer, Integer>[] bigMap = new HashMap[len];
            for (int i = 0; i < len; ++i) {
                bigMap[i] = new HashMap<Integer, Integer>();
                for (int j = 0; j < len; ++j) {
                    distance = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                    num = bigMap[i].getOrDefault(distance, 0);
                    bigMap[i].put(distance, num + 1);
                }
            }
            int res = 0;
            for (int i = 0; i < len; ++i) {
                for(int j:bigMap[i].values()){
                    res+=(j*(j-1));
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}