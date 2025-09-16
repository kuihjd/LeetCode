package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;

public class IIQa4I{
    public static void main(String[] args) {
    	
        Solution solution = new IIQa4I().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        LinkedList<int[]> stack = new LinkedList<>();
        int n = temperatures.length;
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            System.out.println("cur: " + temperatures[i] + " stack: " + stackToString(stack));
            while (!stack.isEmpty() && stack.peekFirst()[1] < temperatures[i]) {
                int[] t = stack.pollFirst();
                res[t[0]] = i - t[0];
            }
            stack.addFirst(new int[]{i, temperatures[i]});
        }
        return res;
    }

    String stackToString (LinkedList<int[]> stack) {
        StringBuilder sb = new StringBuilder();
        for (int[] i : stack) {
            sb.append(Arrays.toString(i));
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}