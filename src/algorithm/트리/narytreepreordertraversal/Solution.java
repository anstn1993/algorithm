package algorithm.트리.narytreepreordertraversal;

import java.util.ArrayList;
import java.util.List;


/*
 * 출처: leetcode
 * 문제 이름: N-ary Tree Preorder Traversal
 * */
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class Solution {
    private List<Integer> result = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root != null) {
            result.add(root.val);//self 를 먼저 삽입
            for (Node child : root.children) {
                preorder(child);//자식 노드를 재귀적으로 호출
            }
        }
        return result;
    }
}
