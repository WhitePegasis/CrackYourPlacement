//https://www.geeksforgeeks.org/problems/circular-tour-1587115620/1
package stack_and_queues;

class Solution
{
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[])
    {
        int n=petrol.length;
        
		int start = 0;
		int reqFuel = 0;
		
		int extraFuel = 0;
		
		for(int i=0; i<n; i++){
		    extraFuel += (petrol[i] - distance[i]);
		    
		    if(extraFuel < 0){
		        start = i+1;
		        reqFuel += extraFuel;
		        extraFuel = 0;
		    }
		}
		
		if(reqFuel + extraFuel >= 0) return start;
		
		return -1;
    }
}
