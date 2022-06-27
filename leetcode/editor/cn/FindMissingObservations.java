package leetcode.editor.cn;
public class FindMissingObservations{
    public static void main(String[] args) {
        Solution solution = new FindMissingObservations().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum=0;
        for(int i:rolls)sum+=i;
        double t=(mean*(rolls.length+n)-(double)sum);
        if(t/n>6||t/n<1) return new int[0];
        int[] res=new int[n];
        int num= (int) (t/n);
        int l= (int) (t%n);
        for(int i=0;i< rolls.length;++i){
            if(i<l) res[i]=num+1;
            else res[i]=num;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}