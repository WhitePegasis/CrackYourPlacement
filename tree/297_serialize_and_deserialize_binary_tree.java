//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
package tree;

import java.util.*;

class TreeNode {
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
}


class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";

        StringBuilder res = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(node == null){
                res.append("n ");
                continue;
            }

            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }

        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;

        String[] values = data.split(" ");

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);

        for(int i=1; i<values.length; i++){
            TreeNode parent = q.poll();

            if(!values[i].equals("n")){
                TreeNode leftNode = new TreeNode(Integer.parseInt(values[i]));
                parent.left = leftNode;
                q.add(leftNode);
            }

            i++;//move to right node
            if(!values[i].equals("n")){
                TreeNode rightNode = new TreeNode(Integer.parseInt(values[i]));
                parent.right = rightNode;
                q.add(rightNode);
            }
        }

        return root;
    }

}
