package leetcode.editor.cn;

import java.util.*;

public class OneNzhengShuZhong1chuXianDeCiShuLcof {
    public static void main(String[] args) {
        Solution solution = new OneNzhengShuZhong1chuXianDeCiShuLcof().new Solution();
        solution.countDigitOne(12);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countDigitOne(int n) {
            int ans = 0;
            int high = n / 10, low = 0, cur = n % 10, dig = 1;
            while(high > 0 || cur != 0){
                if(cur == 0) ans += high * dig;
                else if(cur == 1) ans += high * dig + low + 1;
                else ans += (high + 1) * dig;
                low = cur * dig + low;
                dig *= 10;
                cur = high % 10;
                high /= 10;
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}