package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementIi{
    public static void main(String[] args) {
        Solution solution = new MajorityElementIi().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int max=2;
        int[] k=new int[max];//数字
        int[] v=new int[max];//出现次
        b:for(int i:nums){
            for(int j=0;j<max;++j){
                if(k[j]==i) {
                    v[j]++;
                    continue b;
                }
            }
            for(int j=0;j<max;++j){
                if(v[j]==0) {
                    v[j]++;
                    k[j]=i;
                    continue b;
                }
            }
            for(int j=0;j<max;++j){
                v[j]--;
            }
        }
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<max;++i)v[i]=0;
        for(int i:nums){
            for(int j=0;j<max;++j){
                if(k[j]==i) {
                    v[j]++;
                    break;
                }
            }
        }
        for(int i=0;i<max;++i){
            if(v[i]>nums.length/3) res.add(k[i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}