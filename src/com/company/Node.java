package com.company;

public class Node {
    Node next = null;
    String data;

    public Node(String d) {
        data = d;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
