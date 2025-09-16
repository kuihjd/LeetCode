package leetcode.editor.cn;
public class WaterBottles{
    public static void main(String[] args) {
    	
        Solution solution = new WaterBottles().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        while (numBottles >= numExchange) {
            int newBottles = numBottles / numExchange;
            res += newBottles;
            numBottles = newBottles + numBottles % numExchange;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}