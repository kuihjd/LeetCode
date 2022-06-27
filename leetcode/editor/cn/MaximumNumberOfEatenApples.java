package leetcode.editor.cn;
public class MaximumNumberOfEatenApples{
    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfEatenApples().new Solution();
        solution.eatenApples(new int[]{1,2,3,5,2},new int[]{3,2,1,4,2});
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int eatenApples(int[] apples, int[] days) {
        boolean[] dp=new boolean[apples.length+20000];
        int surplusApp=0,surplusDay=0;
        for(int i=0;i<apples.length;++i){
            surplusDay=days[i];
            surplusApp=apples[i];
            while(i+surplusDay>=0&&surplusDay>=0&&surplusApp>0){
                if(!dp[i])
                    surplusApp--;
                dp[i+surplusDay]=true;
                surplusDay--;
            }

        }
        int res=0;
        for(boolean i:dp)if(i)res++;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}