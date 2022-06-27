package leetcode.editor.cn;

import java.util.*;

public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        Codec solution = new SerializeAndDeserializeBinaryTree().new Codec();

    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
//            if(root == null) return "";
            StringBuilder sb = new StringBuilder();
            enDfs(root, sb);
            sb.deleteCharAt(0);
            return sb.toString();
        }

        void enDfs(TreeNode root, StringBuilder sb){
            sb.append(',');
            if(root == null){
                sb.append("null");
                return;
            }
            sb.append(root.val);
            enDfs(root.left, sb);
            enDfs(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            LinkedList<String> list = new LinkedList<>(List.of(data.split(",")));
            return struct(list);
        }

        TreeNode struct(LinkedList<String> list){
            if(list.isEmpty()) return null;
            String t = list.pollFirst();
            if(t.equals("'null'")) return null;
            TreeNode res = new TreeNode(Integer.parseInt(t));
            res.left = struct(list);
            res.right = struct(list);
            return res;
        }
    }
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}
