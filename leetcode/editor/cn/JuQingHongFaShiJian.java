package leetcode.editor.cn;

import java.util.*;

public class JuQingHongFaShiJian {
    public static void main(String[] args) {
        Solution solution = new JuQingHongFaShiJian().new Solution();
        solution.getTriggerTime(new int[][]{{1,7,5},{10,5,2},{5,3,7},{5,5,9},{8,9,0}},
                new int[][]{{19,18,15},{12,20,11}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getTriggerTime(int[][] increase, int[][] requirements) {
            int len = requirements.length;
            TreeMap<Integer,Integer>[] map = new TreeMap[3];
            int[] res = new int[len];
            for(int j=0;j<3;++j) {
                map[j]=new TreeMap<>();
                map[j].put(0,0);
                if(increase[0][j]==0) continue;
                map[j].put(increase[0][j],1);
            }
            for (int i = 1; i < increase.length; ++i) {
                for(int j=0;j<3;++j) {
                    increase[i][j]+=increase[i-1][j];
                    if(increase[i][j]==increase[i-1][j]) continue;
                    map[j].put(increase[i][j],i+1);
                }
            }
            int max=0;
            for(int i=0;i <len;++i){
                max=0;
                for(int j=0;j<3;++j) {
                    Map.Entry<Integer, Integer> t=map[j].ceilingEntry(requirements[i][j]);
                    if(t!=null) {
                        max=Math.max(max,t.getValue());
                    }
                    else{
                        max=-1;
                        break;
                    }
                }
                res[i]=max;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}