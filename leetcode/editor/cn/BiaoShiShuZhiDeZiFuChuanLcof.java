package leetcode.editor.cn;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BiaoShiShuZhiDeZiFuChuanLcof{
    public static void main(String[] args) {
        Solution solution = new BiaoShiShuZhiDeZiFuChuanLcof().new Solution();
        solution.isNumber(".1.");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isNumber(String s) {
        if(countPoint(s) > 1) return false;
        char[] c = s.toCharArray();
        int l = 0, r = c.length - 1;
        while(l <= r && c[l] == ' ') l++;
        while(l <= r && c[r] == ' ') r--;
        if(l > r) return false;
        if(c[l] == '-' || c[l] == '+') l++;//吸收符号位
        int cnt = 0;
        while(l <= r && isNum(c[l])) {
            l++;
            cnt++;
        }
        if(cnt == 0){//没有数字
            if(c[l] == '.'){//还能抢救一下
                l++;
                while(l <= r && isNum(c[l])) {
                    l++;
                    cnt++;
                }
                if(cnt == 0) return false;//没法救了
            }
            else{
                return false;
            }
        }
        if(l == r + 1) return true;//完成了,合法
        if(c[l] == '.') l++;//处理?.?
        while(l <= r && isNum(c[l])) {
            l++;
            cnt++;
        }
        if(l == r + 1) return true;//完成了,合法
        //到这表明前方是合法的整数小数
        //只能往E...扩展
        if(l < r && c[l] != 'E' && c[l] != 'e') return false;//后面还有非e的东西
        l++;
        if(l <= r && (c[l] == '-' || c[l] == '+')) l++;//吸收符号位

        cnt = 0;
        while(l <= r && isNum(c[l])) {
            l++;
            cnt++;
        }
        if(cnt == 0) return false;//e后无数字
        if(l != r + 1) return false;//l走不到r后,中间有奇怪的东西
        return true;
    }

    int countPoint(String s){
        int res = 0;
        for(char i:s.toCharArray()) if(i == '.') res++;
        return res;
    }

    boolean isNum(char c){
        return c >= '0' && c <= '9';
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}