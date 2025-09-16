package leetcode.editor.cn;
public class CheckIfNumberIsASumOfPowersOfThree{
    public static void main(String[] args) {
    	
        Solution solution = new CheckIfNumberIsASumOfPowersOfThree().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        static int[] arr = new int[100];
        static int cnt = -1;
        static {
            int i = 1;
            while (i < 1e7+5) {
                arr[++cnt] = i;
                i *= 3;
            }
        }
    public boolean checkPowersOfThree(int n) {
        for (int i = cnt; i >=0; --i) {
            if(arr[i] <= n) {
                n -= arr[i];
            }
        }
        return n == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}