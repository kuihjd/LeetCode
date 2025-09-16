package leetcode.editor.cn;
public class FindTheWinnerOfAnArrayGame{
    public static void main(String[] args) {
    	
        Solution solution = new FindTheWinnerOfAnArrayGame().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getWinner(int[] arr, int k) {
        int win = arr[0];
        int winCount = 0;
        for (int i = 1; i < arr.length; ++i) {
            if (win > arr[i]) {
                ++winCount;
            } else {
                win = arr[i];
                winCount = 1;
            }
            if (winCount == k) {
                return win;
            }
        }
        return win;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}