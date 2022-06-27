package leetcode.editor.cn;

import java.util.*;
import java.io.*;

public class ImplementQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue solution = new ImplementQueueUsingStacks().new MyQueue();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyQueue {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            if(stack2.isEmpty()){
                while (!stack1.isEmpty()) stack2.push(stack1.pop());
            }
            return stack2.pop();
        }

        public int peek() {
            if(stack2.isEmpty()){
                while (!stack1.isEmpty()) stack2.push(stack1.pop());
            }
            return stack2.peek();
        }

        public boolean empty() {
            return stack2.isEmpty() && stack1.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}