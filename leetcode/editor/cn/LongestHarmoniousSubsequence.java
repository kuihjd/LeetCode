package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence{
    public static void main(String[] args) {
        Solution solution = new LongestHarmoniousSubsequence().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLHS(int[] nums) {
        int res=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums)
            map.put(i,map.getOrDefault(i,0)+1);
        int n0,n1,n2;
        for(int i:map.keySet()){
            n1=map.get(i);
            n2=map.getOrDefault(i+1,0);
            if(n2>0) res=Math.max(res,n2+n1);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}