package leetcode.editor.cn;
public class NonNegativeIntegersWithoutConsecutiveOnes{
    public static void main(String[] args) {
        Solution solution = new NonNegativeIntegersWithoutConsecutiveOnes().new Solution();
        System.out.printf(String.valueOf(solution.findIntegers(777)));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    static int[] map=null;
    public int findIntegers(int n) {
        init();
        return map[n];
    }
    void init(){
        if(map!=null) return;
        map=new int[100000001];
        map[0]=1;
        for(int i=1;i<100000001;++i){
            map[i]=map[i-1]+((i&i>>1)>1?0:1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}