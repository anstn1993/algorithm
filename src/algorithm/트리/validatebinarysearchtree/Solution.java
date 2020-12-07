package algorithm.트리.validatebinarysearchtree;

import java.util.ArrayList;
import java.util.List;

/*
 * 출처: leetcode
 * 문제 이름: Validate Binary Search Tree
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
    //중위 순회
    private void inorder(TreeNode root, List<Integer> list) {
        if(root == null) return;

        inorder(root.left, list);//left

        //self
        list.add(root.val);//현재 값 리스트에 삽입

        inorder(root.right, list);//right
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        for(int i = 0; i < list.size() - 1; i++) {
            if(list.get(i) >= list.get(i + 1)) return false;
        }
        return true;
    }
}
