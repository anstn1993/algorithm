package algorithm.트리.maximumdepthofnarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 출처: leetcode
 * 문제 이름: Maximum Depth of N-ary Tree
 * */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class Solution {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;
        while (!q.isEmpty()) {
            depth += 1;
            //현재 level을 순회하면서 각 노드의 child들을 큐에 삽입
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node current = q.poll();
                for(Node child : current.children) {
                    q.offer(child);
                }
            }
        }
        return depth;
    }
}
