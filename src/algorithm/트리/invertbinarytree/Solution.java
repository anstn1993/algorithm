package algorithm.트리.invertbinarytree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 출처: leetcode
 * 문제 이름: Invert Binary Tree
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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) q.offer(current.left);
            if (current.right != null) q.offer(current.right);

        }
        return root;
    }
}
