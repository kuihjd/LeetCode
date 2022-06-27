package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class FallingSquares {
    public static void main(String[] args) {
        Solution solution = new FallingSquares().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        public List<Integer> fallingSquares(int[][] positions) {
            List<Integer> res = new ArrayList<>();
            for (int[] i : positions) res.add(put(i[0], i[1]));
            return res;
        }

        int put(int l, int r) {
            int size = r - l;
            map.put(l, map.getOrDefault(l, 0) + size);
            map.put(r, map.getOrDefault(r, 0) - size);
            int cur = 0, max = 0;
            for (int i : map.values()) max = Math.max(max, cur += i);
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}