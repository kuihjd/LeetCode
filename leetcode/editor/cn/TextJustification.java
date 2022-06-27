package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class TextJustification{
    public static void main(String[] args) {
        Solution solution = new TextJustification().new Solution();
        solution.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."},16);
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res=new ArrayList<String>();
        int nowcnt=0;
        int i=0;
        int len=words.length;

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}