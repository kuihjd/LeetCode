package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz{
    public static void main(String[] args) {
        Solution solution = new FizzBuzz().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    static List<String> res;
    static{
        res=new ArrayList<>();
        while(res.size()<10000){
            res.add(check(res.size()+1));
        }
    }
    public List<String> fizzBuzz(int n) {
        return res.subList(0,n);
    }
    void init(){
        if(res!=null) return;
        res=new ArrayList<>();
        while(res.size()<10000){
            res.add(check(res.size()));
        }
    }
    static String check(int n){
        if(n%15==0) return"FizzBuzz";
        if(n%3==0) return"Fizz";
        if(n%5==0) return"Buzz";
        return String.valueOf(n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}