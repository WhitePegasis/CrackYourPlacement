//https://www.geeksforgeeks.org/problems/count-bst-nodes-that-lie-in-a-given-range/1
package tree;

class Solution
{
    int solve(Node root, int l, int h)
    {
        if (root==null)
            return 0;
            
        int count = solve(root.left, l, h);
        
        if (root.data >= l && root.data <= h)
        {
            count++;
        }
        
        count += solve(root.right, l, h);
        
        return count;
    }
    //Function to count number of nodes in BST that lie in the given range.
    int getCount(Node root,int l, int h)
    {
        return solve(root, l, h);
    }
}
