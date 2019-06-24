package com.company;

public class LinkedList {
    public Node head;
    public int listCount;


    public LinkedList() {
        head = new Node("Head");
        listCount = 0;
    }

    public int size(){
        Node current = head;
        int size = 0;
        while(current.next!= null){
            size++;
            current = current.next;
        }

        return size;
    }

    public void show() {
        Node current = head;
        while (current.next != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println(current.data);
    }

    public boolean add(String d) {
        Node end = new Node(d);
        Node current = head;

        while (current.next != null) {
            current = current.next;
        }
        current.next = end;
        listCount++;
        return true;
    }

    public boolean add(String d, int index) {
        Node end = new Node(d);
        Node current = head;
        int jump;

        if (index > listCount || index < 1) {
            return false;
        } else {
            jump = 0;
            while (jump < index - 1) {
                current = current.next;
                jump++;
            }
            end.next = current.next;
            current.next = end;
            listCount++;
            return true;
        }
    }

    public boolean deleteNodeWithData(String d) {
        Node current = head;
        while (current.next != null) {
            if (current.next.data == d) {
                current.next = current.next.next;
                listCount--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean deleteNodeAtIndex(int index) {
        Node current = head;
        int jump;
        if (index > listCount || index < 1) {
            return false;
        } else {
            jump = 0;
            while (jump < index - 1) {
                current = current.next;
                jump++;
            }
            current.next = current.next.next;
            listCount--;
            return true;
        }
    }
    public Node get(int index)
    // returns the element at the specified position in this list.
    {
        // index must be 1 or higher
        if (index < 0)
            return null;
        Node currenNode = null;
        if (head != null) {
            currenNode = head.getNext();
            for (int i = 0; i < index; i++) {
                if (currenNode.getNext() == null)
                    return null;

                currenNode = currenNode.getNext();
            }
            return currenNode;
        }
        return currenNode;

    }
    public void print(){
        Node current = head;
        if(size()==0){
           // System.out.println("This key is empty!");
            return;
        }
        while(current.next!= null){
            System.out.printf("\t");
            current = current.next;
            System.out.println(current.data);

        }
    }


}