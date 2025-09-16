package leetcode.editor.cn;

import java.util.Arrays;

public class CheckIfAStringCanBreakAnotherString{
    public static void main(String[] args) {
    	
        Solution solution = new CheckIfAStringCanBreakAnotherString().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        int n = c1.length;
        if (compare(c1, c2)) {
            return true;
        }
        if (compare(c2, c1)) {
            return true;
        }
        return false;
    }

    boolean compare(char[] c1, char[] c2) {
        int n = c1.length;
        for (int i = 0; i < n; ++i) {
            if (c1[i] < c2[i]) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}