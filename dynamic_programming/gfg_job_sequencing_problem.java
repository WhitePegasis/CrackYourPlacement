//https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
package dynamic_programming;

import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr,(x,y)->y.profit-x.profit);
        int maxDeadline=0;
        
        for(Job j:arr) maxDeadline=Math.max(maxDeadline,j.deadline);
        
        int deadlines[]=new int[maxDeadline+1];
        Arrays.fill(deadlines,-1);
        
        int maxProfit=0,totalJobs=0;
        
        for(Job j:arr){
            for(int i=j.deadline;i>0;i--){
                if(deadlines[i]==-1){
                    deadlines[i]=j.profit;
                    maxProfit+=j.profit;
                    totalJobs++;
                    break;
                }
            }
        }
        
        return new int[]{totalJobs,maxProfit};
    }
}
