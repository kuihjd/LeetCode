package leetcode.editor.cn;
public class MaximumSwap{
    public static void main(String[] args) {
    	
        Solution solution = new MaximumSwap().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumSwap(int num) {
        char[] sn = String.valueOf(num).toCharArray();
        int n = sn.length;
        for (int i = 0; i < n; ++i) {
            int mx = i;
            for (int j = n - 1; j > i; --j) {
                if (sn[j] > sn[mx]) {
                    mx = j;
                }
            }
            if (mx != i) {
                char t = sn[mx];
                sn[mx] = sn[i];
                sn[i] = t;
                return Integer.parseInt(String.valueOf(sn));
            }
        }
        return Integer.parseInt(String.valueOf(sn));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}