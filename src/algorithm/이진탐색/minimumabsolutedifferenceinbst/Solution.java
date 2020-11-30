package algorithm.이진탐색.minimumabsolutedifferenceinbst;

/*
 * 출처: leetcode
 * 문제 이름: Minimum Absolute Difference in BST
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

    private int min = Integer.MAX_VALUE;

/* 최초 풀이
  //prarm1: 현재 노드 값, param2: 피연산 노드
    public void processLeft(int rootVal, TreeNode current) {
        if(current != null) {
            min = Math.min(min, rootVal - current.val);
            processLeft(rootVal, current.left);
            processLeft(rootVal, current.right);
        }
        else {
            return;
        }
    }

    //prarm1: 현재 노드 값, param2: 피연산 노드
    public void processRight(int rootVal, TreeNode current) {
        if(current != null) {
            min = Math.min(min, current.val - rootVal);
            processRight(rootVal, current.left);
            processRight(rootVal, current.right);
        }
        else {
            return;
        }
    }

    public int getMinimumDifference(TreeNode root) {
        //현재 노드의 자식노드들과의 차들을 구하면서 최소값을 구한다.
        int rootVal = root.val;

        processLeft(rootVal, root.left);
        processRight(rootVal, root.right);

        //루트 노드를 자식 노드로 설정해서 재귀 호출
        //왼쪽 자식 노드가 존재하는 경우
        if(root.left != null) {
            getMinimumDifference(root.left);
        }
        //오른쪽 자식 노드가 존재하는 경우
        if(root.right != null) {
            getMinimumDifference(root.right);
        }
        return min;
    }*/

    /*
    * 전위 순회를 이용한 풀이
    * */
    //전위 순회를 할 때 최초에는 피연산 노드(현재 노드 기준으로 이전 노드)가 하나이기 때문에 그 때 연산을 막기 위한 flag
    private boolean init = false;
    private int prev;//이전 노드 값
    //전위 순회를 하면 노드를 오름차순으로 탐색하게 되기 때문에 한 번의 탐색으로 바로 최소값을 구할 수 있다.
    public void inorder(TreeNode root) {
        if(root == null) return;
        //left
        inorder(root.left);
        //self
        if(!init) {
            init = true;
        }
        else {
            min = Math.min(min, root.val - prev);
        }
        //현재 노드 값을 prev값으로 설정
        prev = root.val;
        //right
        inorder(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }
}
