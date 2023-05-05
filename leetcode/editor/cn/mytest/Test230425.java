package leetcode.editor.cn.mytest;

import java.util.Dictionary;
import java.util.Scanner;

public class Test230425 {
    static class Tree{
        int val;
        Tree left, right;
    }
    static int idx = 1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sa = scanner.next().split(",+");
        int[] arr = new int[1 + sa.length];
        for (int i = 0; i < sa.length; ++i) {
            arr[i + 1] = Integer.parseInt(sa[i]);
        }
        Tree root = new Tree();
        int max = (int) (Math.log(sa.length + 1) / Math.log(2)) ;
        dfsStruct(root, arr, max, 1);
        StringBuilder sb = new StringBuilder();
//        LinkedList<Integer> ans = new LinkedList<>();
        dfsAns(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb.toString());
    }

    static void dfsStruct(Tree tree,  int[] arr, int max, int cur) {
        if (tree == null) {
            return;
        }
        if (cur < max) {
            tree.left = new Tree();
            tree.right = new Tree();
        }
        tree.val = arr[idx++];
        dfsStruct(tree.left, arr, max, cur + 1);
        dfsStruct(tree.right, arr, max, cur + 1);

    }

    static void dfsAns(Tree tree, StringBuilder sb) {
//        new Dictionary<Integer, Integer>();
        if (tree == null) {
            return;
        }
        dfsAns(tree.left, sb);
        sb.append(tree.val);
        sb.append(',');
        dfsAns(tree.right, sb);
    }
}
