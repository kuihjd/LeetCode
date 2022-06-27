package leetcode.editor.cn;
public class ChuanDiXinXi{
    public static void main(String[] args) {
        Solution solution = new ChuanDiXinXi().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int res=0;
    int k=0;
    public int numWays(int n, int[][] relation, int k) {
        this.k=k;
        int max=0;
        boolean[][] vis=new boolean[10][10];
        for(int i=0;i<10;++i) vis[i]=new boolean[10];
        for(int[] i:relation){
            for(int[] j:relation){
                vis[j[0]][j[1]]=true;
                max=Math.max(Math.max(j[0],j[1]),max);
            }
        }
        dfs(0,vis,0,max);
        return res;
    }
    void dfs(int n,boolean[][] vis,int step,int target){
        if(step==k) {
            if(n==target) res++;
            return;
        }
        for(int i=0;i<=target;++i){
            if(vis[n][i]) dfs(i,vis,step+1,target);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}