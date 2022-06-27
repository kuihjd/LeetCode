package leetcode.editor.cn;
import java.util.*;
public class HeWeiSdeLianXuZhengShuXuLieLcof{
    public static void main(String[] args) {
        Solution solution = new HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
        solution.findContinuousSequence(10);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> ans = new ArrayList<>();
        for(int i = 2; i < target / 2; ++i){
            if(check(i, target)) ans.add(struct(i, target));
        }
//        int[][] res = new int[ans.size()][];
//        for(int i = 0; i < ans.size(); ++i) res[i] = ans.get(i);
        return ans.toArray(new int[0][0]);
    }
    int[] struct(int n, int tar){
        //result an array of int
        int[] arr = new int[n];
        int start = tar / n - n / 2 + (n % 2 == 0? 0 : 1);
        for(int i = 0; i < n; ++i) arr[i] = start + i;
        return arr;
    }
    boolean check(int n, int tar){
        // n is length
        int v = tar / n;
        // v is average
        if(n % 2 == 1 && tar % v == 0) {
            return tar / n - n / 2 + 1 > 0;
        }
        if(n % 2 == 0 && tar % v == n / 2) {
            return tar / n - n / 2 > 0;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}