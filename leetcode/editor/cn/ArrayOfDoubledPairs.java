package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class ArrayOfDoubledPairs {
    public static void main(String[] args) {
        Solution solution = new ArrayOfDoubledPairs().new Solution();
        solution.canReorderDoubled(new int[]{0,0 ,1, 2, 4, 8});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static int[] cnt = new int[(int) (2 * 1e5 + 5)];
        static int offset = (int) 1e5;
        static int base = (int) 1e5;
        public boolean canReorderDoubled(int[] arr) {
            Arrays.fill(cnt, 0);
            for(int i : arr) cnt[i +offset]++;
            int cal = cnt[base];
            for(int i = 1; i < 1e5 / 2; ++i){
                int origin = base + i - offset;
                cnt[origin * 2 + offset] -= cnt[origin + offset];
                cal += cnt[origin + offset] * 2;
                if(cnt[origin * 2 + offset] < 0) return false;
                origin = base - i - offset;
                cnt[origin * 2 + offset] -= cnt[origin + offset];
                if(cnt[origin * 2 + offset] < 0) return false;
                cal += cnt[origin + offset] * 2;
            }
            return cal == arr.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}