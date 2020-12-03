package algorithm.트리.insertintoabinarysearchtree;

/*
 * 출처: leetcode
 * 문제 이름: Insert into a Binary Search Tree
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
    //recursive
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    //iteration
//    public TreeNode insertIntoBST(TreeNode root, int val) {
//        TreeNode temp = root;
//        while (temp != null) {
//            if (val < temp.val) {//현재 노드 값보다 작은 경우
//                if (temp.left != null) temp = temp.left;//왼쪽 자식 노드를 root로 설정
//                else {
//                    temp.left = new TreeNode(val);
//                    break;
//                }
//            } else {//현재 노드 값보다 큰 경우
//                if (temp.right != null) temp = temp.right;//오른쪽 자식 노드를 root로 설정
//                else {
//                    temp.right = new TreeNode(val);
//                    break;
//                }
//            }
//        }
//        return root;
//    }
}
