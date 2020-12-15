package algorithm.트리.maximumdepthofbinarytree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 출처: leetcode
 * 문제 이름: Maximum Depth of Binary Tree
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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                if(current.left != null) q.offer(current.left);
                if(current.right != null) q.offer(current.right);
            }
            depth ++;
        }
        return depth;
    }
}
