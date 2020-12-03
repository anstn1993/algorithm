package algorithm.트리.binarysearchtreeiterator;

import java.util.Stack;

/*
 * 출처: leetcode
 * 문제 이름: Binary Search Tree Iterator
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

public class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        //현재 노드에 대해서 왼쪽 자식 노드들을 쭉 넣어준다.
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        //들어간 왼쪽 자식 노드의 오른쪽 자식 노드가 존재하면 그 자식 노드를 기준으로
        //왼쪽 자식 노드들을 쭉 넣어준다.
        if(node.right != null) {
            TreeNode root = node.right;
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
        }
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
