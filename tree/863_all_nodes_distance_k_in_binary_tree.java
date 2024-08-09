//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
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

class Solution {
    private void mapParents(TreeNode root, Map<TreeNode, TreeNode> mp) {
        if (root.left != null) {
            mp.put(root.left, root);
            mapParents(root.left, mp);
        }

        if (root.right != null) {
            mp.put(root.right, root);
            mapParents(root.right, mp);
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        mapParents(root, parentMap);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.add(target);
        visited.add(target);

        int currentDistance = 0;

        while (!queue.isEmpty()) {
            if (currentDistance == k) break;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();

                if (currNode.left != null && !visited.contains(currNode.left)) {
                    queue.add(currNode.left);
                    visited.add(currNode.left);
                }

                if (currNode.right != null && !visited.contains(currNode.right)) {
                    queue.add(currNode.right);
                    visited.add(currNode.right);
                }

                if (parentMap.containsKey(currNode) && !visited.contains(parentMap.get(currNode))) {
                    queue.add(parentMap.get(currNode));
                    visited.add(parentMap.get(currNode));
                }
            }
            currentDistance++;
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }

        return result;
    }
}
