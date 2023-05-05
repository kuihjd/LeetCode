package leetcode.editor.cn;
import java.util.*;
import java.io.*;
public class GenerateAStringWithCharactersThatHaveOddCounts {
    public static void main(String[] args) {
        Solution solution = new GenerateAStringWithCharactersThatHaveOddCounts().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String generateTheString(int n) {
        if (n % 2 == 1) return "a".repeat(n);
        return "a".repeat(n - 1) + "b";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}