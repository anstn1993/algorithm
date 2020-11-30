package datastructure.binarysearchtree;

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
    public TreeNode searchBST(TreeNode root, int val) {
        //현재 노드값이 찾는 값인 경우
        if(root.val == val) {
            return root;
        }
        //찾는 값이 현재 노드보다 작고 왼쪽 자식 노드가 존재하는 경우 왼쪽 자식 노드를 root로 설정 후 재귀 호출
        if(root.val > val && root.left != null) {
            return searchBST(root.left, val);
        }
        //찾는 값이 현재 노드보다 큰고 오른쪽 자식 노드가 존재하는 경우 오른쪽 자식 노드를 root로 설정 후 재귀 호출
        else if(root.val < val && root.right != null) {
            return searchBST(root.right, val);
        }
        else {
            return null;
        }
    }
}
