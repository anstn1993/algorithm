package algorithm.트리.binarytreelevelordertraversal2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 출처: leetcode
 * 문제 이름: Binary Tree Level Order Traversal 2
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
    //bfs랑 동일한 문제
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        //루트 노드를 먼저 삽입
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            result.add(0, new ArrayList<>());//현재 depth의 노드 값을 담을 리스트 추가
            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                //현재 노드 값을 결과 리스트에 추가
                result.get(0).add(current.val);
                //left child, right child가 존재하는 경우 큐에 삽입
                if (current.left != null) q.offer(current.left);
                if (current.right != null) q.offer(current.right);
            }
        }
        return result;
    }
}
