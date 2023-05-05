package leetcode.editor.cn.mytest;

// 输入一个字符串 包括 字母、英文字符
// 输出里面包含左右括号 有几对
// (() 1
// (123)(123(123) 2


// 框最大50个包子 厨师一秒一次生产5个 客人一秒2个 厨师需要在<=10补充到满

import java.util.LinkedList;
import java.util.Scanner;

public class Test23032201 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] c = s.toCharArray();
        int cnt = 0;
        LinkedList<Character> stack = new LinkedList<>();
        for (char i : c) {
            if (i == '(') {
                stack.addLast('(');
            } else if (i == ')' && !stack.isEmpty()) {
                stack.pollLast();
                cnt++;
            }
        }
        System.out.println(cnt);

    }




}
