package datastructure.binarytree;

public class Tree {
    class Node {
        int data;
        Node left;
        Node right;
    }

    public Node root;

    public void setRoot(Node node) {
        this.root = node;
    }
    public Node getRoot() {
        return root;
    }

    public Node makeNode(Node left, int data, Node right) {
        Node node = new Node();
        node.data = data;
        node.left = left;
        node.right = right;
        return node;
    }
    //왼쪽 자식, 자신, 오른쪽 자식 순으로 순회
    public void inorder(Node node) {
        if(node != null) {
            inorder(node.left);
            System.out.println(node.data);
            inorder(node.right);
        }
    }
    //왼쪽 자식, 오른쪽 자식, 자신 순으로 순회
    public void postorder(Node node) {
        if(node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.data);
        }
    }

    //자신, 왼쪽 자식, 오른쪽 자식 순으로 순회
    public void preorder(Node node) {
        if(node != null) {
            System.out.println(node.data);
            preorder(node.left);
            preorder(node.right);
        }
    }
}
