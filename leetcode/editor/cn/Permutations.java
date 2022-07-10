package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class Permutations {
    public static void main(String[] args) {
        Byte v = Byte.parseByte("10000000", 2);
        System.out.println(v);
        System.out.println(68 >>> 3);
        Solution solution = new Permutations().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] cur;
        boolean[] flag;
        int len;
        int[] nums;
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            this.nums = nums;
            len = nums.length;
            cur = new int[len];
            flag = new boolean[len];
            dfs(0);
            return res;
        }

        void dfs(int idx) {
            if (idx == len) {
                List<Integer> t = new ArrayList<>();
                for (int i : cur) t.add(i);
                res.add(t);
                return;
            }
            for (int i = 0; i < len; ++i) {
                if (flag[i] == false) {
                    cur[idx] = nums[i];
                    flag[i] = true;
                    dfs(idx + 1);
                    flag[i] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}