package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class FindOriginalArrayFromDoubledArray{
    public static void main(String[] args) {
        Solution solution = new FindOriginalArrayFromDoubledArray().new Solution();
        solution.findOriginalArray(new int[]{1,2,3,2,4,6,2,4,6,4,8,12});
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findOriginalArray(int[] changed) {
        int len=changed.length;
        if((len&1)==1)return new int[0];
        int[] res=new int[len/2];
        int index=0;
        Arrays.sort(changed);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:changed)map.put(i,map.getOrDefault(i,0)+1);
        int n=0;
        boolean zeroFlag=false;
        for(int i:changed){
            if(zeroFlag){
                if(i==0){
                    zeroFlag=false;
                    continue;
                }
                return new int[0];
            }
            if(map.get(i)!=0){
                n=map.getOrDefault(i*2,0);
                if(n!=0){
                    if(i==0){
                        map.put(0,n-2);
                        zeroFlag=true;
                    }
                    else{
                        map.put(i*2,n-1);
                    }
                    res[index++]=i;
                    if(index==len/2) return res;
                }
                else{
                    return new int[0];
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}