package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class FindTheLosersOfTheCircularGame{
    public static void main(String[] args) {
    	
        Solution solution = new FindTheLosersOfTheCircularGame().new Solution();
        solution.circularGameLosers(4, 4);
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] circularGameLosers(int n, int k) {
        boolean[] winner = new boolean[n];
        int cur = 0;
        int i = 1;
        while (!winner[cur]) {
            winner[cur] = true;
            cur = (cur + k * i++) % n;
//            System.out.println(cur);
        }
        int[] res = new int[n - i + 1];
        int p = 0;
        for (int j = 0; j < n; ++j) {
            if (!winner[j]) {
                res[p++] = j + 1;
            }
        }
//        int[] ans = new int[res.size()];
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}