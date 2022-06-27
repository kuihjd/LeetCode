package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class YongLiangGeZhanShiXianDuiLieLcof{
    public static void main(String[] args) {
        CQueue solution = new YongLiangGeZhanShiXianDuiLieLcof().new CQueue();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class CQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    public CQueue() {

    }
    
    public void appendTail(int value) {
        s1.add(value);
    }
    
    public int deleteHead() {
        if(!s2.isEmpty()) return s2.pop();
        while(!s1.isEmpty()){
            s2.add(s1.pop());
        }
        if(s2.isEmpty()) return -1;
        return s2.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

}