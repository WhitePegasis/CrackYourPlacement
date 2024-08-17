//https://leetcode.com/problems/find-eventual-safe-states/
package tree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int nodes = graph.length; // Number of nodes in the graph

        // Create a reversed graph adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int node = 0; node < nodes; node++) {
            adj.add(new ArrayList<>()); // Initialize the adjacency list
        }

        // Reverse the graph: for each edge from node to nbr, add an edge from nbr to
        // node in the reversed graph
        for (int node = 0; node < nodes; node++) {
            for (int nbr : graph[node]) {
                adj.get(nbr).add(node); // Add the reversed edge
            }
        }

        // Initialize an array to track in-degrees (number of incoming edges)
        int[] inDegree = new int[nodes];
        for (int node = 0; node < nodes; node++) {
            for (int nbr : adj.get(node)) {
                inDegree[nbr]++; // Increment in-degree of each node
            }
        }

        // Initialize a queue to perform BFS, starting with nodes having in-degree 0
        // (terminal nodes)
        Queue<Integer> q = new LinkedList<>();
        for (int node = 0; node < inDegree.length; node++) {
            if (inDegree[node] == 0) {
                q.offer(node); // Add terminal nodes to the queue
            }
        }

        // Perform BFS to find all safe nodes
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll(); // Dequeue a node
            // Explore all predecessors of the current node
            for (int nbr : adj.get(node)) {
                inDegree[nbr]--; // Reduce in-degree of the predecessor
                if (inDegree[nbr] == 0) {
                    q.offer(nbr); // If in-degree becomes 0, it's also safe, so add it to the queue
                }
            }
        }

        // Collect all nodes that have in-degree 0 (safe nodes)
        for (int node = 0; node < inDegree.length; node++) {
            if (inDegree[node] == 0) {
                ans.add(node); // Safe node found, add it to the result list
            }
        }

        // Return the list of safe nodes
        return ans;
    }
}
