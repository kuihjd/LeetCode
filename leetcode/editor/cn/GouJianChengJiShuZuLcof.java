package leetcode.editor.cn;
import java.util.*;
public class GouJianChengJiShuZuLcof{
    public static void main(String[] args) {
        Solution solution = new GouJianChengJiShuZuLcof().new Solution();
        solution.constructArr(new int[]{1, 2, 3, 4, 5});
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] constructArr(int[] a) {
        int len = a.length;
        if(len <= 1) return a;
        int[] l = new int[len];
        int[] r = new int[len];
        int[] res = new int[len];
        l[0] = a[0];
        r[len - 1] = a[len - 1];
        for(int i = 1; i < len; ++i) l[i] = l[i - 1] * a[i];
        for(int i = len - 2; i >= 0; --i) r[i] = r[i + 1] * a[i];
        res[0] = r[1];
        res[len - 1] = l[len - 2];
        for(int i = 1; i < len - 1; ++i) res[i] = l[i - 1] * r[i + 1];
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}