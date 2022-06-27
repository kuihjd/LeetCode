package leetcode.editor.cn;
public class AdditiveNumber{
    public static void main(String[] args) {
        Solution solution = new AdditiveNumber().new Solution();
        solution.isAdditiveNumber("111122335588143");
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAdditiveNumber(String num) {
        int len=num.length();
        for(int i=0;i<len/2;++i){
            long tn1=toNum(num,0,i+1);
            if(tn1==-1) continue;
            for(int j=0;j<len/2&&i+j+2<len;++j){
                long n1=tn1;
                long n2=toNum(num,i+1,i+j+2);
                if(n2==-1) continue;
                int nowlen=i+j+2;
                while(findNum(num,nowlen,n1+n2)){
                    nowlen+=String.valueOf(n1+n2).length();
                    n2=n1+n2;
                    n1=n2-n1;
                }
                if(nowlen==num.length()) return true;
            }
        }
        return false;
    }

    long toNum(String num,int start,int end){
        if(num.charAt(start)=='0'&&end>start+1) return -1;
        return Long.parseLong(num.substring(start,end));
    }

    boolean findNum(String num,int start,long tar){
        return num.startsWith(String.valueOf(tar),start);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}