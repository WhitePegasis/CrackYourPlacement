//https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
package graph;

import java.util.*;

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        ArrayList<Integer> bfsResult = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        // Start BFS from the first node (assuming node 0)
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) 
        {
            int node = queue.poll();
            bfsResult.add(node);

            // Get all adjacent vertices of the dequeued node
            for (int neighbor : adj.get(node)) 
            {
                if (!visited[neighbor]) 
                {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        return bfsResult;
    }
}