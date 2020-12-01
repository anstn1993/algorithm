package algorithm.트리.kthsmallestelementinabst;

/*
 * 출처: leetcode
 * 문제 이름: Kth Smallest Element in a BST
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
    int index;
    int result;
    public void inorder(TreeNode root, int k) {
        //left
        if (root.left != null) inorder(root.left, k);
        //self
        index ++;
        if(index == k) {
            result = root.val;
            return;
        }
        //right
        if (root.right != null) inorder(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        index = 0;
        inorder(root, k);
        return result;
    }
}
