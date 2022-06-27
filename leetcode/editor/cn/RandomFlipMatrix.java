package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomFlipMatrix{
    public static void main(String[] args) {
        Solution solution = new RandomFlipMatrix().new Solution(3,4);
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<Integer,Integer> map=new HashMap<>();
    int m,n;
    int use;
    static Random random=new Random();
    public Solution(int m, int n) {
        use=m*n;
        this.m=m;
        this.n=n;
    }

    public int[] flip() {
        int i=random.nextInt(use--);
        int res=map.getOrDefault(i,i);
        map.put(res,use);
        return new int[]{res/m,res%m};
    }

    public void reset() {
        map.clear();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */
//leetcode submit region end(Prohibit modification and deletion)

}