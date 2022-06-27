//有 n 个网络节点，标记为 1 到 n。 
//
// 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， w
//i 是一个信号从源节点传递到目标节点的时间。 
//
// 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 1
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 2
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 100 
// 1 <= times.length <= 6000 
// times[i].length == 3 
// 1 <= ui, vi <= n 
// ui != vi 
// 0 <= wi <= 100 
// 所有 (ui, vi) 对都 互不相同（即，不含重复边） 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 最短路 堆（优先队列） 
// 👍 357 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//Java：网络延迟时间
public class NetworkDelayTime{
    public static void main(String[] args) {
        Solution solution = new NetworkDelayTime().new Solution();
        solution.networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}},4,2);
        // TO TEST
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        HashMap<Integer, List<helper>> map;
        int[] max;
        public int networkDelayTime(int[][] times, int n, int k) {
            map=new HashMap();
            max=new int[n+1];
            Arrays.fill(max,Integer.MAX_VALUE);
            max[0]=0;
            List<helper> list=null;
            for(int[] i:times){
                if(map.containsKey(i[0])){
                    list=map.get(i[0]);
                }
                else{
                    list=new ArrayList<helper>();
                    map.put(i[0],list);
                }
                list.add(new helper(i[1],i[2]));
            }
            dfs(k,0);
            int res=0;
            for(int i:max){
                if(i==Integer.MAX_VALUE) return -1;
                res=Math.max(res,i);
            }
            return res;
        }
        void dfs(int idx,int time){
            if(max[idx]>time){
                max[idx]=time;
            }
            else{
                return;
            }
            List<helper> list=map.getOrDefault(idx,null);
            if(list!=null){
                for(helper i:list){
                    dfs(i.v,i.w+time);
                }
            }
        }
    }
    class helper{
        int v,w;
        helper(int v,int w){
            this.v=v;
            this.w=w;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}