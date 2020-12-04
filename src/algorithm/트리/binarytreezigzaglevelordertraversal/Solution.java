package algorithm.트리.binarytreezigzaglevelordertraversal;

import java.util.*;

/*
 * 출처: leetcode
 * 문제 이름: Binary Tree Zigzag Level Order Traversal
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        //왼쪽 순회 여부를 판단하는 flag(false-오른쪽 순회, true-왼쪽 순회)
        boolean isFromLeft = true;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            result.add(new ArrayList<>());
            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                if (isFromLeft) result.get(result.size() - 1).add(current.val);
                if (!isFromLeft) result.get(result.size() - 1).add(0, current.val);
                if (current.left != null) q.offer(current.left);
                if (current.right != null) q.offer(current.right);
            }
            isFromLeft = !isFromLeft;
        }
        return result;
    }
}
