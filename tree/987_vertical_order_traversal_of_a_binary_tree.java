//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
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

class Tuple{
    TreeNode node;
    int x;
    int y;

    public Tuple(TreeNode node, int x, int y){
        this.node = node;
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();

        Queue<Tuple> q = new LinkedList<>();

        q.offer(new Tuple(root, 0, 0));

        while(!q.isEmpty()){
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.x;
            int y = tuple.y;

            //when we are visiting this x-axis for the first time
            if(!mp.containsKey(x)){
                mp.put(x, new TreeMap<>());
            }

            //if in current x-axis we are visiting this depth for the first time
            if(!mp.get(x).containsKey(y)){
                mp.get(x).put(y, new PriorityQueue<>());
            }

            mp.get(x).get(y).offer(node.val);

            if(node.left != null){
                q.offer(new Tuple(node.left, x-1, y+1));
            }

            if(node.right != null){
                q.offer(new Tuple(node.right, x+1, y+1));
            }
        }

        List<List<Integer>> list = new ArrayList<>();

        for(TreeMap<Integer, PriorityQueue<Integer>> yMap : mp.values()){
            list.add(new ArrayList<>());

            for(PriorityQueue<Integer> nodes: yMap.values()){
                while(!nodes.isEmpty()){
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }

        return list;
    }
}
