package datastructure;

import datastructure.linkedlist.LinkedList;

public class main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.retrieve();
        linkedList.delete(1);
        linkedList.retrieve();
        linkedList.delete(3);
        linkedList.retrieve();
    }
}
