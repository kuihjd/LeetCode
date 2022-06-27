package leetcode.editor.cn;

import java.util.*;

public class KHighestRankedItemsWithinAPriceRange{
    public static void main(String[] args) {
        Solution solution = new KHighestRankedItemsWithinAPriceRange().new Solution();
        solution.highestRankedKItems(new int[][]{{1,2,0,1},{1,3,0,1},{0,2,5,1}},new int[]{2,5},new int[]{0,0},3);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        //0=距离,1=价格,2=x,3=y
        int[] rx={0,0,1,-1};
        int[] ry={1,-1,0,0};
        Set<Integer> set=new HashSet<>();
        PriorityQueue<Integer[]> que=new PriorityQueue<Integer[]>((v1, v2)->{
            for(int i=1;i<4;++i){
                if(!Objects.equals(v1[i], v2[i])) return v1[i]-v2[i];
            }
            return 0;
        });
        List<List<Integer>> ans=new ArrayList<>();
        Queue<Integer[]> bque= new LinkedList<>();
        bque.add(new Integer[]{start[0],start[1],grid[start[0]][start[1]]});
        int len=1;
        int r=0;
        while(!bque.isEmpty()){
            while(len>0){
                len--;
                Integer[] now=bque.poll();
                if(now==null) continue;
                for(int i=0;i<4;++i){
                    if(now[0]+rx[i]<0||now[0]+rx[i]>=grid.length)continue;
                    if(now[1]+ry[i]<0||now[1]+ry[i]>=grid[0].length)continue;
                    if(grid[now[0]+rx[i]][now[1]+ry[i]]==0) continue;
                    bque.add(new Integer[]{now[0]+rx[i],now[1]+ry[i],grid[now[0]+rx[i]][now[1]+ry[i]]});
                    grid[now[0]+rx[i]][now[1]+ry[i]]=0;
                }
                que.add(new Integer[]{r,now[2],now[0],now[1]});
            }
            r++;
            len=bque.size();
        }
        len=Math.min(que.size(),k);
        while(len>0){
            len--;
            Integer[] now=que.poll();
            List<Integer> t=new ArrayList<Integer>();
            t.add(now[2]);
            t.add(now[3]);
            ans.add(t);
        }
        return ans;
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}