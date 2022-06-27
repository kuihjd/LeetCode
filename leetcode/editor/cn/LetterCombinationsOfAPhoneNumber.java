package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    static String[] mapping=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        return construct(0,digits.toCharArray(),Arrays.asList(""));
    }
    List<String> construct(int index,char[] digits,List<String> cur){
        if(index==digits.length)return cur;
        List<String> res=new ArrayList<>();
        for(String s:cur){
            for(char c:mapping[digits[index]-'0'].toCharArray()){
                res.add(s+c);
            }
        }
        return construct(index+1,digits,res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}