package leetcode.editor.cn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class work224 {
    static char[] mod = new char[]{'+', '-', '*', '/'};

    public String compute(String v) {
        try {
            for (int i = 0; i < 4; ++i) {
                if (v.indexOf(mod[i]) > -1) {
                    double l = Double.parseDouble(v.split(String.valueOf(mod[i]))[0]);
                    double r = Double.parseDouble(v.split(String.valueOf(mod[i]))[1]);
                    switch (i) {
                        case 0:
                            return String.valueOf(l + r);
                        case 1:
                            return String.valueOf(l - r);
                        case 2:
                            return String.valueOf(l * r);
                        case 3:
                            return String.valueOf(l / r);
                    }
                }
            }
            throw new Exception("异常算术表达式");
        } catch (Exception ignored) {
            return ignored.toString();
        }
    }
}


//class Solution {
//    static char[] op = new char[]{'+', '-', '*', '/'};
//    public String calculate(String s) {
//        try{
//            String[] sa = s.split("[\\+\\-\\*/]");
//            double l = Double.parseDouble(sa[0]);
//            double r = Double.parseDouble(sa[1]);
//            switch (find(s)){
//                case 1:
//                    return String.valueOf(l + r);
//                case 2:
//                    return String.valueOf(l - r);
//                case 3:
//                    return String.valueOf(l * r);
//                case 4:
//                    return String.valueOf(l / r);
//            }
//            throw new Exception("Error");
//        }
//        catch (Exception e){
//            return e.toString();
//        }
//
//    }
//
//    int find(String s){
//        for (int i = 0; i < op.length; i++) {
//            if(s.indexOf(op[i]) > 0) return i + 1;
//        }
//        return -1;
//    }
//}


class Calculate {
    public int calculate(String s) {
        char sign = '+';
        Stack<Integer> numStack = new Stack<>();
        int num = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur >= '0') {
                num = num * 10 - '0' + cur;
            }
            if ((cur < '0' && cur != ' ') || i == s.length() - 1) {
                switch (sign) {
                    case '+' -> numStack.push(num);
                    case '-' -> numStack.push(-num);
                    case '*' -> numStack.push(numStack.pop() * num);
                    case '/' -> numStack.push(numStack.pop() / num);
                }
                sign = cur;
                num = 0;
            }
        }
        while (!numStack.isEmpty()) {
            result += numStack.pop();
        }
        return result;
    }
}

class Calculator {
    static HashMap<Character, Integer> priority = new HashMap<>();
    static String priorityChar = "()+-*/";
    static int[] priorityInt = new int[]{0, 0, 4, 4, 3, 3};
    static {
        int len = priorityChar.length();
        for(int i = 0; i < len; ++i){
            priority.put(priorityChar.charAt(i), priorityInt[i]);
        }
    }
    int calculate(String s){
        if(s.charAt(0) == '-') s = "0" + s;
        s = "0+" + s;
        Deque<Integer> numStack = new LinkedList<>();
        Deque<Character> signStack = new LinkedList<>();
        char[] c = s.toCharArray();
        int len = c.length;
        for (int i = 0; i < c.length; i++) {
            char ch = c[i];
            if(ch == ' ') continue;
            if(isNum(ch)){
                int num = 0;
                while(i < len && isNum(c[i])) num = num * 10 + c[i++] - '0';
                i--;
                numStack.addLast(num);
                if(!signStack.isEmpty() && signStack.peekLast() == '-'){
                    signStack.pollLast();
                    signStack.addLast('+');
                    numStack.addLast(numStack.pollLast() * -1);
                }
            }
            else{
                if(ch =='(') signStack.addLast(ch);
                else if(ch == ')'){
                    while(signStack.peekLast() != '('){
                        int t = eval(numStack.pollLast(), numStack.pollLast(), signStack.pollLast());
                        numStack.addLast(t);
                    }
                    signStack.pollLast();
                }
                else{
                    while(!signStack.isEmpty() && signStack.peekLast() != '(' && priority.get(signStack.peekLast()) <= priority.get(ch) ){
                        int t = eval(numStack.pollLast(), numStack.pollLast(), signStack.pollLast());
                        numStack.addLast(t);
                    }
                    signStack.addLast(ch);
                }
            }
        }
        while(!signStack.isEmpty()){
            numStack.addLast(eval(numStack.pollLast(), numStack.pollLast(), signStack.pollLast()));
        }
        return numStack.pollLast();
    }

    Integer eval(int num1, int num2, char mod){
        return switch (mod){
            case '+' -> num1 + num2;
            case '-' -> num2 - num1;
            case '*' -> num1 * num2;
            case '/' -> num2 / num1;
            default -> throw new IllegalStateException("Unexpected value: " + mod);
        };
    }

    boolean isNum(char c){
        return c >= '0' && c <='9';
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(new Calculate().calculate((new BufferedReader(new InputStreamReader(System.in))).readLine()));
    }
}
