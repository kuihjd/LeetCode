package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class MapOfHighestPeak{
    public static void main(String[] args) {
        Solution solution = new MapOfHighestPeak().new Solution();
        solution.highestPeak(new int[][]{{0,1},{0,0}});
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int[] rx = {0, 0, 1, -1};
        int[] ry = {1, -1, 0, 0};
        Queue<int[]> queue = new LinkedList<>();
        int m = isWater.length, n = isWater[0].length;
        int[][] res = new int[m][n];
        for(int i = 0; i < m; ++i){
            res[i] = new int[n];
            for(int j = 0; j < n; ++j){
                res[i][j] = Integer.MAX_VALUE;
                if(isWater[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int now = 0;
        while(!queue.isEmpty()){
            int s = queue.size();
            while(s > 0){
                s--;
                int[] t = queue.poll();
                if(t == null) continue;
                if(t[0] < 0 || t[1] < 0) continue;
                if(t[0] >= m || t[1] >= n) continue;
                if(res[t[0]][t[1]] <= now) continue;
                res[t[0]][t[1]] = now;
                for(int i = 0;i < 4; ++i){
                    queue.add(new int[]{t[0] + rx[i], t[1] + ry[i]});
                }
            }
            now++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}