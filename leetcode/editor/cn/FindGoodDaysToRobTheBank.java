package leetcode.editor.cn;

import java.util.*;

public class FindGoodDaysToRobTheBank {
    public static void main(String[] args) {
        Solution solution = new FindGoodDaysToRobTheBank().new Solution();
        solution.goodDaysToRobBank(new int[]{5,3,3,3,5,6,2},2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> goodDaysToRobBank(int[] security, int time) {
            List<Integer> res = new ArrayList<>();
            int len = security.length;
            int[] l = new int[len];
            int[] r = new int[len];
            l[0] = 1;
            r[len - 1] = 1;
            for (int i = 1; i < len; ++i) {
                l[i] = security[i] <= security[i - 1] ? l[i - 1] + 1 : 1;
            }
            for (int i = len - 2; i >= 0; --i) {
                r[i] = security[i] <= security[i + 1] ? r[i + 1] + 1 : 1;
            }
            for(int i = time; i < len - time; ++i){
                if(l[i] > time && r[i] > time) res.add(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}