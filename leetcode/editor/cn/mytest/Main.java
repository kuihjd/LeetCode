package leetcode.editor.cn.mytest;

import java.util.Scanner;

public class Main {
    static class Tree{
        int val;
        Test230425.Tree left, right;
    }
    static int idx = 1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sa = scanner.next().split(",+");
        int[] arr = new int[1 + sa.length];
        for (int i = 0; i < sa.length; ++i) {
            arr[i + 1] = Integer.parseInt(sa[i]);
        }
        Test230425.Tree root = new Test230425.Tree();
        int max = (int) (Math.log(sa.length + 1) / Math.log(2)) ;
        dfsStruct(root, arr, max, 1);
        StringBuilder sb = new StringBuilder();
//        LinkedList<Integer> ans = new LinkedList<>();
        dfsAns(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb.toString());
    }

    static void dfsStruct(Test230425.Tree tree, int[] arr, int max, int cur) {
        if (tree == null) {
            return;
        }
        if (cur < max) {
            tree.left = new Test230425.Tree();
            tree.right = new Test230425.Tree();
        }
        tree.val = arr[idx++];
        dfsStruct(tree.left, arr, max, cur + 1);
        dfsStruct(tree.right, arr, max, cur + 1);

    }

    static void dfsAns(Test230425.Tree tree, StringBuilder sb) {
        if (tree == null) {
            return;
        }
        dfsAns(tree.left, sb);
        sb.append(tree.val);
        sb.append(',');
        dfsAns(tree.right, sb);
    }
}
