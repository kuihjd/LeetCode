package leetcode.editor.cn;
import java.util.*;
public class ZhanDeYaRuDanChuXuLieLcof{
    public static void main(String[] args) {
        Solution solution = new ZhanDeYaRuDanChuXuLieLcof().new Solution();
        solution.validateStackSequences(new int[]{100,200,300,400,500}, new int[]{400,500,300,200,100});
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> stack = new LinkedList<>();
        int p = 0;
        for (int j : pushed) {
            stack.offerLast(j);
            if(stack.peekLast() == popped[p]) {
                p++;
                stack.pollLast();
            }
        }
        while(p < popped.length && stack.peekLast() == popped[p]){
            stack.pollLast();
            p++;
        }
        return p == popped.length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}