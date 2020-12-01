package algorithm.트리.binarytreeinordertraversal;

import java.util.ArrayList;
import java.util.List;

/*
 * 출처: leetcode
 * 문제 이름: Binary Tree Inorder Traversal
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
    private void inorder(TreeNode root, List<Integer> result) {
        //left child
        if (root.left != null) inorder(root.left, result);
        //self
        result.add(root.val);
        //right child
        if (root.right != null) inorder(root.right, result);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        inorder(root, result);
        return result;
    }
}
