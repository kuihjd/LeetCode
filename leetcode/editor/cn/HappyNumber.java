package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class HappyNumber {
    public static void main(String[] args) {
        Solution solution = new HappyNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isHappy(int n) {
            HashSet<Integer> set = new HashSet<>();
            while (true) {
                if (n == 1) return true;
                if (set.contains(n)) return false;
                set.add(n);
                n = cal(n);
            }
        }

        int cal(int n) {
            if (n == 0) return 0;
            return (n % 10) * (n % 10) + cal(n / 10);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}