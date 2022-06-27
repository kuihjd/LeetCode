package leetcode.editor.cn;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        solution.threeSum(new int[]{-1,0,1,2,-1,-4});

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if(nums.length<3) return null;
            List<List<Integer>> res= new ArrayList<>();
            int[] cnt = new int[200002];
            TreeSet<Integer> numsSet= new TreeSet<>();
            for(int i:nums) {
                if(cnt[i+100000]++==0) numsSet.add(i);
            }

            Integer[] numsArr = numsSet.toArray(new Integer[0]);
            int len=numsArr.length;
            int n1=0,n2=0,n3=0;
            for(int i=0;i<len;++i){
                n1=numsArr[i];
                for(int j=i+(cnt[numsArr[i]+100000]>1?0:1);j<len;++j){
                    n2=numsArr[j];
                    n3=-(n1+n2);
                    if(n3<n2) continue;
                    if(cnt[n3+100000]>0){
                        if(n3==n2&&cnt[n2+100000]==1)continue;
                        if(n1==0&&n2==0&&cnt[100000]==2)continue;
                        res.add(Arrays.asList(n1,n2,n3));
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}