package leetcode.editor.cn;

import java.util.Stack;

public class BaoHanMinhanShuDeZhanLcof{
    public static void main(String[] args) {
        MinStack solution = new BaoHanMinhanShuDeZhanLcof().new MinStack();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    Stack<int[]> stack = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {

    }
    
    public void push(int x) {
        stack.add(new int[]{x, stack.isEmpty()?x:Math.min(stack.peek()[1], x)});
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int min() {
        return stack.pop()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)

}