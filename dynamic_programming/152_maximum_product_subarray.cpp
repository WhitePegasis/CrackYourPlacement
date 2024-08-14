//https://leetcode.com/problems/maximum-product-subarray/
#include<iostream>
#include <vector>
using namespace std;

class Solution {
    public:
        int maxProduct(vector<int>& nums) {
            int n = nums.size(), mod = INT_MAX;
            long long prefix = 1, suffix=1, ans = INT_MIN;
    
            for(int i=0;i<n;i++){ // -3 0 1 -2
                if(prefix==0) prefix = 1;
                if(suffix==0) suffix = 1;
                prefix = (prefix* nums[i]) % mod;
                suffix = (suffix*nums[n-i-1]) % mod;
                ans = max(ans, max(prefix, suffix));
            }
            
            return ans;
        }
    
    };