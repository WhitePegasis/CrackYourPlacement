//https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
package graph;

import java.util.*;

class Solution {
    //PRIMS
    static class Node{
        int u;
        int v;
        int weight;
        public Node(int u,int v,int weight){
            this.u=u;
            this.v=v;
            this.weight=weight;
        }
    }
    static int spanningTree(int v, int e, List<List<int[]>> adj) {
        boolean visited[]=new boolean[v];
        
        PriorityQueue<Node>q=new PriorityQueue<>((a,b)->a.weight>b.weight?1:-1);
        
        q.add(new Node(0,0,-1));
        
        int sum=1;
        
        while(!q.isEmpty()){
            Node temp=q.poll();
            
            if(visited[temp.v]) continue;
            visited[temp.v]=true;
            
            sum+=temp.weight;
            
            for(int a[]:adj.get(temp.v)){
                if(!visited[a[0]])
                    q.offer(new Node(temp.v,a[0],a[1]));
            }
            
        }
        
        return sum;
    }
}

