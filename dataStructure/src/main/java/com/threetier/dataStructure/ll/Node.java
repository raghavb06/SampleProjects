package com.threetier.dataStructure.ll;

public class Node {

    Node next;
    Object data;

    public Node(Object dataValue) {
        this.next = null;
        this.data = dataValue;
    }

    public Node(int dataValue, Node nextValue) {
        this.next = nextValue;
        this.data = dataValue;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
