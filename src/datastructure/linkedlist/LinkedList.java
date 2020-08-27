package datastructure.linkedlist;

public class LinkedList {
    Node header;

    public LinkedList() {
        this.header = new Node();
    }

    class Node {
        int data;
        Node next = null;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }


    public void append(int d) {
        Node end = new Node(d);
        Node n = header;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public void delete(int d) {
        Node n = header;
        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    public void retrieve() {
        Node n = header.next;
        while (n.next != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println(n.data);
    }

    //중복되는 요소 제거
    public void removeDups() {
        Node n = header;
        while (n != null && n.next != null) {
            //runner
            Node r = n;
            while (r.next != null) {
                if(n.data == r.next.data) {
                    r.next = r.next.next;
                }
                else {
                    r = r.next;
                }
            }
            n = n.next;
        }
    }
}


