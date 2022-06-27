package leetcode.editor.cn;

import java.util.ArrayList;

public class LeetCodeDataStruct {

    static TreeNode parserTreeNode(String str){
        return TreeNode.deserialize(removeLRBrackets(str));
    }

    static int[] parserIntArray(String str){
        str = removeLRBrackets(str);
        String[] strs = str.split(",");
        int[] res = new int[strs.length];
        for(int i = 0; i < strs.length; ++i){
            res[i] = Integer.parseInt(strs[i]);
        }
        return res;
    }

    static int[][] parserTwoIntArray(String str){
        String[] strs = removeLRBrackets(str).split("],\\[");
        int[][] res = new int[strs.length][0];
        for(int i = 0; i < strs.length; ++i){
            res[i] = parserIntArray(strs[i]);
        }
        return res;
    }

    static ListNode parserListNode(String str){
        int[] data = parserIntArray(str);
        return new ListNode(data);
    }

    static int[][][] parserThreeIntArray(String str){
        String[] strs = removeLRBrackets(str).split("]],\\[\\[");
        int[][][] res = new int[strs.length][0][0];
        for(int i = 0; i < strs.length; ++i){
            res[i] = parserTwoIntArray(strs[i]);
        }
        return res;
    }

    static String removeLRBrackets(String str){
        StringBuilder res = new StringBuilder(str);
        if(res.charAt(0) == '[') res.deleteCharAt(0);
        if (res.charAt(res.length() - 1) == ']') res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}
