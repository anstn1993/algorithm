package algorithm.트리.binarytreepaths;

import java.util.ArrayList;
import java.util.List;

/*
 * 출처: leetcode
 * 문제 이름: Binary Tree Paths
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
    public void traverse(TreeNode root, String path, List<String> result) {
        //리프노드인 경우에만 결과리스트에 추가하고 재귀 호출 종료
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        if (root.left != null) traverse(root.left, path + "->" + root.left.val, result);
        if (root.right != null) traverse(root.right, path + "->" + root.right.val, result);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        traverse(root, Integer.toString(root.val), result);
        return result;
    }
}
