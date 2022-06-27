package leetcode.editor.cn;
public class ZuiXiaoTiaoYueCiShu{
    public static void main(String[] args) {
        Solution solution = new ZuiXiaoTiaoYueCiShu().new Solution();
        solution.minJump(new int[]{3,7,6,1,4,3,7,8,1,2,8,5,9,8,3,2,7,5,1,1});
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minJump(int[] jump) {
        int res=0;
        int len=jump.length;
        int[] target=new int[len];
        target[0]=jump[0];
        for(int i=1;i<len;++i){
            target[i]=Math.max(target[i-1],jump[i]+i);
        }
        int i=0;
        while(i<len){
            res++;
            if(jump[i]+i>=len)return res;
            if(jump[i]+i<target[i])res++;
            i=target[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}