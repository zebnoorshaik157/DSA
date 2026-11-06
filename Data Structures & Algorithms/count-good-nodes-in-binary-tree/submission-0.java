/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int cnt=0;
    private void dfs(TreeNode node,int maxVal) {
        if(node==null) return;
      
        if(node.val >= maxVal) {
            cnt++;
        }
        maxVal=Math.max(maxVal,node.val);
        dfs(node.left,maxVal);
        dfs(node.right,maxVal);
    }
    public int goodNodes(TreeNode root) {
        
        dfs(root,Integer.MIN_VALUE);

        return cnt;
    }
}
