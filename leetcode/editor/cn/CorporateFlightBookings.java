package leetcode.editor.cn;
import java.util.*;
import java.io.*;
public class CorporateFlightBookings {
    public static void main(String[] args) {
        Solution solution = new CorporateFlightBookings().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        int[] dif = new int[n + 1];
        for(int[] i : bookings){
            dif[i[0]] += i[2];
            dif[i[1] + 1] -= i[2];
        }
        int cur = 0;
        for(int i = 0; i < n; ++i){
            cur += dif[i + 1];
            res[i] = cur;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}