package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class LengthOfLongestFibonacciSubsequence {
    public static void main(String[] args) {
        Solution solution = new LengthOfLongestFibonacciSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lenLongestFibSubseq(int[] arr) {
            HashSet<Integer> set = new HashSet<>();
            int len = arr.length;
            int res = 0;
            for (int i : arr) set.add(i);
            for (int i = 0; i < len; ++i) {
                for (int j = i + 1; j < len; ++j) {
                    int next = arr[i] + arr[j];
                    int pre = arr[i];
                    int cnt = 2;
                    while (set.contains(next)) {
                        int t = next;
                        next -= pre;
                        pre = next;
                        next += t;
                        cnt++;
                    }
                    if (cnt >= 3) res = Math.max(res, cnt);

                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}