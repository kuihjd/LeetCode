package leetcode.editor.cn;
import java.util.*;
public class MaximumNumberOfAchievableTransferRequests{
    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfAchievableTransferRequests().new Solution();
        solution.maximumRequests(5, new int[][]{{0,1},{1,0},{0,1},{1,2},{2,0},{3,4}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int[] now = new int[n];
        int len = requests.length;
        final int tar = 1 << len;
        int res = 0;
        for(int i = 0; i < tar; ++i){
            Arrays.fill(now , 0);
            for(int j = 0; j < len; ++j){
                if((i & (1 << j)) > 0){
                    now[requests[j][0]]--;
                    now[requests[j][1]]++;
                }
            }
            if(check(now))
                res = Math.max(res, bitCount(i));
        }
        return res;
    }

    boolean check(int[] arr){
        for(int i: arr) if(i != 0) return false;
        return true;
    }

    int bitCount(int v){
        int res = 0;
        while(v > 0){
            res++;
            v = v & (v - 1);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    }