package leetcode.editor.cn;
import java.util.*;
import java.io.*;
public class Candy {
    public static void main(String[] args) {
        Solution solution = new Candy().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] l = new int[len];
        int[] r = new int[len];
        Arrays.fill(l, 1);
        Arrays.fill(r, 1);
        for(int i = 1; i < len; ++i){
            if(ratings[i] > r[i - 1]) l[i] = l[i - 1] + 1;
        }
        for(int i = len - 2; i >= 0; --i){
            if(ratings[i] > r[i + 1]) r[i] = r[i + 1] + 1;
        }
        int res = 0;
        for(int i = 0; i < len; ++i){
            res += Math.max(l[i], r[i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}