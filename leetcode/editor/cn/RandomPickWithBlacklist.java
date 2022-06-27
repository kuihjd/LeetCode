package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class RandomPickWithBlacklist {
    public static void main(String[] args) {
        Solution solution = new RandomPickWithBlacklist().new Solution(1, new int[]{});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        HashMap<Integer, Integer> map = new HashMap<>();
        Random random = new Random();
        int n;

        public Solution(int n, int[] blacklist) {
            Arrays.sort(blacklist);
            int len = blacklist.length;
            this.n = n - len;

        }

        public int pick() {
            int t = random.nextInt(0, n);
            return t;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
//leetcode submit region end(Prohibit modification and deletion)

}