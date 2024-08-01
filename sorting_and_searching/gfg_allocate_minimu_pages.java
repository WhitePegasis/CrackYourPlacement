//https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1

package sorting_and_searching;

class Solution {
    
    private static int getStudentCount(int[] pages, int maxPagesPerStudent){
        
        int studentCount = 1;
        long currPagesSum = 0;
        
        for(int i=0; i<pages.length; i++){
            
            if(currPagesSum + pages[i] <= maxPagesPerStudent){
                currPagesSum += pages[i];
            }
            else{
                //switching students
                studentCount++;
                currPagesSum = pages[i];
            }
        }
        
        return studentCount;
        
    } 
    
    
    // Function to find minimum number of pages.
    public static long findPages(int n, int[] arr, int m) {
        
        if(m>arr.length) return -1;
        
        int minPagesRequiredPerStudent = 0;
        
        int pagesSum = 0;
        
        for(int pages: arr){
            minPagesRequiredPerStudent = Math.max(pages, minPagesRequiredPerStudent);
            pagesSum += pages;
        }
        
        int low = minPagesRequiredPerStudent, high = pagesSum;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            int numStudents = getStudentCount(arr, mid);
            
            if(numStudents > m){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        
        return low;
    }
};
