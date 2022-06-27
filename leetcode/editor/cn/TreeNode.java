package leetcode.editor.cn;


import java.util.LinkedList;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    static public String serialize(TreeNode root) {
        if (root == null) return "";
        LinkedList<Helper> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int now = 1;
        list.add(new Helper(root, 1));
        while (!list.isEmpty()) {
            int len = list.size();
            while (len > 0) {
                len--;
                Helper helper = list.pollFirst();
                while (now < helper.idx) {
                    sb.append(',').append("null");
                    now++;
                }
                if (helper.root.left != null) list.offerLast(new Helper(helper.root.left, now * 2));
                if (helper.root.right != null) list.offerLast(new Helper(helper.root.right, now * 2 + 1));
                sb.append(',').append(helper.root.val);
                now++;
            }
        }
        sb.deleteCharAt(0);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    static public TreeNode deserialize(String data) {
        String[] sa = data.split(",");
        return struct(sa, 1);
    }

    static TreeNode struct(String[] sa, int idx) {
        if (idx > sa.length) return null;
        if (sa[idx - 1].equals("null")) return null;
        TreeNode res = new TreeNode(Integer.parseInt(sa[idx - 1]));
        res.left = struct(sa, idx * 2);
        res.right = struct(sa, idx * 2 + 1);
        return res;
    }

    static class Helper {
        TreeNode root;
        int idx;

        public Helper(TreeNode root, int idx) {
            this.root = root;
            this.idx = idx;
        }
    }
}



