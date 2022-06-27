package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class MinimumHeightTrees {
    public static void main(String[] args) {
        Solution solution = new MinimumHeightTrees().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] cache;

        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            cache = new int[n];
            List<Integer> res = new ArrayList<>();
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < n; ++i){
                int r = 1;
                if(r < min) {
                    min = r;
                    res.clear();
                }
                if(r == min) res.add(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}