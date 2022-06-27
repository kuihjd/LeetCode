package leetcode.editor.cn;
import java.util.*;
public class HuaDongChuangKouDeZuiDaZhiLcof{
    public static void main(String[] args) {
        Solution solution = new HuaDongChuangKouDeZuiDaZhiLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>((v1, v2) -> v2.compareTo(v1));
        PriorityQueue<Integer> del = new PriorityQueue<>((v1, v2) -> v2.compareTo(v1));
        int len = nums.length;
        int[] res = new int[len - k + 1];
        for(int i = 0; i < k ; ++i){
            que.offer(nums[i]);
        }
        res[0] = que.peek();
        for(int i = k; i < len ; ++i){
            que.offer(nums[i]);
            del.offer(nums[i - k]);
            while(!del.isEmpty() && que.peek().equals(del.peek())) {
                que.poll();
                del.poll();
            }
            res[i - k + 1] = que.peek();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}