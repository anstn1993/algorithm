package algorithm.트리.findlargestvalueineachtreerow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 출처: leetcode
 * 문제 이름: Find Largest Value in Each Tree Row
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
    //bfs로 처리
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            //현재 level에서 최대값을 구하고 자식 노드를 큐에 추가
            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                max = Math.max(max, current.val);//최대값 구하기
                //큐에 자식 노드 삽입
                if(current.left != null) q.offer(current.left);
                if(current.right != null) q.offer(current.right);
            }
            result.add(max);//최대값 삽입
        }
        return result;
    }
}
