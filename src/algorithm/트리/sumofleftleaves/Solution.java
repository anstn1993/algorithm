package algorithm.트리.sumofleftleaves;

/*
 * 출처: leetcode
 * 문제 이름: Sum of Left Leaves
 * */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    private int result = 0;

    private boolean traverse(TreeNode root) {
        //left
        if (root.left != null) {
            boolean isLeaf = traverse(root.left);
            if(isLeaf) result += root.left.val;
        }
        //right
        if (root.right != null) {
            traverse(root.right);
        }
        return root.left == null && root.right == null;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root != null) traverse(root);
        return result;
    }
}
