package leetcode.editor.cn;
public class NumberOfSegmentsInAString{
    public static void main(String[] args) {
        Solution solution = new NumberOfSegmentsInAString().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSegments(String s) {
        int res=0;
        for(char c:s.toCharArray()){
            if(c==' ')res++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}