package algorithm.트리.symmetrictree;

import java.util.*;

/*
 * 출처: leetcode
 * 문제 이름: Symmetric Tree
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
    private boolean compare(TreeNode a, TreeNode b) {
        if(a == null && b == null) return true;
        if(a == null || b == null) return false;
        if(a.val != b.val) return false;
        return compare(a.left, b.right) && compare(a.right, b.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return compare(root.left, root.right);
    }
}
