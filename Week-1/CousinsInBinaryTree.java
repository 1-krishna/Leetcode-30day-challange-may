/*
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:



Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Note:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.
 */

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

    public int findLevel(TreeNode root, int data, int level) {
        if (root == null)
            return 0;
        if (root.val == data)
            return level;
        int lev1 = findLevel(root.left, data, level + 1);
        int lev2 = findLevel(root.right, data, level + 1);
        return Math.max(lev1, lev2);

    }

    public boolean areTheyBhaiBehen(TreeNode root, int x, int y) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null) {
            return false;
        }
        if (root.left == null && (root.right.val == x || root.right.val == y)) {
            return false;
        }
        if (root.right == null && (root.left.val == x || root.left.val == y)) {
            return false;
        }
        if ((root.left != null && root.right != null)
                && ((root.left.val == x && root.right.val == y) || (root.left.val == y && root.right.val == x)))
            return true;
        if ((root.left != null && root.right != null) && (root.left.val == x || root.right.val == x))
            return false;
        if ((root.left != null && root.right != null) && (root.left.val == y || root.right.val == y))
            return false;

        boolean lev1 = false, lev2 = false;
        lev1 = areTheyBhaiBehen(root.left, x, y);
        lev2 = areTheyBhaiBehen(root.right, x, y);
        return lev1 || lev2;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        int levelX = findLevel(root, x, 0);
        int levelY = findLevel(root, y, 0);

        // System.out.println(levelX + " " +levelY);
        boolean bhaiBehen = areTheyBhaiBehen(root, x, y);

        return levelX == levelY && !bhaiBehen;

    }
}