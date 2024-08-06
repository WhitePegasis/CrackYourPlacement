//https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
package graph;

import java.util.*;

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean visited[]=new boolean[v];
        for(int i=0;i<v;i++){
            if(visited[i]) continue;
            Deque<Integer>dq=new LinkedList<>();
            int parent=Integer.MAX_VALUE;
            dq.addLast(Integer.MAX_VALUE);
            dq.addLast(i);
            while(!dq.isEmpty()){
                int a=dq.pop();  
                if(a>=10000000){
                    parent=a-10000000;
                    continue;
                }
                if(visited[a]) return true;
                visited[a]=true;
                dq.addLast(10000000+a);
                for(int arr:adj.get(a)){
                    if(arr==parent) continue;
                    dq.addLast(arr);
                }
            }
        }
        return false;
    }
}
