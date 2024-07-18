// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum =0, rightSum=0;
        int n = cardPoints.length;

        for(int idx=0; idx<k ;idx++ ){
            leftSum += cardPoints[idx];
        }

        int ans = leftSum;
        int rightIndex = n-1;
        for(int j=k-1; j>=0 ;j--){
            leftSum = leftSum - cardPoints[j];
            rightSum += cardPoints[rightIndex--];

            ans = Math.max(leftSum + rightSum , ans);
        }

        return ans;
    }
}