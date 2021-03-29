package com.bridgelabz;

public class MyLinkedList {

    public INode head;
    public INode tail;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(INode newNode) {
        if (this.tail == null) {
            this.tail = newNode;
        }
        if (this.head == null) {
            this.head = newNode;
        } else {
            INode tempNode = this.head;
            this.head = newNode;
            this.head.setNext(tempNode);
        }
    }

    public void append(INode myNode) {
        if (this.head == null) {
            this.head = myNode;
        }
        if (this.tail != null) {
            this.tail.setNext(myNode);
        }
        this.tail = myNode;

    }

    public void printMyNodes() {
        StringBuffer myNodes = new StringBuffer("My Nodes are: ");
        System.out.println("Print statement");
        INode tempNode = head;
        while (tempNode.getNext() != null) {
            myNodes.append(tempNode.getKey());
            if (!tempNode.equals(tail)) myNodes.append("->");
            tempNode = tempNode.getNext();
        }

        myNodes.append((tempNode.getKey()));
        System.out.println(myNodes);
    }

    public void insert(INode myNode, INode newNode) {
        INode tempNode = myNode.getNext();
        myNode.setNext(newNode);
        newNode.setNext((tempNode));
    }

    public INode pop() {
        INode tempNode = this.head;
        this.head = head.getNext();
        return tempNode;
    }

    public INode popLast() {
        INode tempNode = head;
        while (!tempNode.getNext().equals(tail)) {
            tempNode = tempNode.getNext();
        }
        this.tail = tempNode;
        tempNode = tempNode.getNext();
        return tempNode;
    }

    public  INode searchNode(INode searchKey) {
        INode tempNode = this.head;
        while (tempNode != null) {
            if (tempNode == searchKey) {
                return tempNode;
            }
            tempNode = tempNode.getNext();
        }
        return null;
    }

    public INode insertBetweenNodes(INode head, INode newNode, int position) {
        INode lastNode = head;
        int count = 1;
        while (count < position - 1) {
            lastNode = lastNode.getNext();
            count++;
        }
        INode currentNode = lastNode.getNext();
        newNode.setNext(currentNode);
        lastNode.setNext(newNode);
        return head;
    }

    public INode deleteFromSequence(INode head, int position) {
        INode previous = head;
        int count = 1;
        while (count < position - 1) {
            previous = previous.getNext();
            count++;
        }
        INode current = previous.getNext();
        previous.setNext(current.getNext());
        current = null;
        lengthOfNode(head);
        return current;
    }

    public int lengthOfNode(INode head) {
        INode tempNode = head;
        int setNum = 0;
        while (tempNode!=null) {
            tempNode=tempNode.getNext();
            setNum++;
        }
        return  setNum;
    }

    public <K> void sortAscendingOrder (INode<K> newNode ) {
        if (head == null || ((Comparable<K>) head.getKey()).compareTo(newNode.getKey()) > 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            INode<K> tempNode = head;
            while (tempNode.getNext() != null && ((Comparable<K>) tempNode.getNext().getKey()).compareTo(newNode.getKey()) < 0) {
                tempNode = tempNode.getNext();
            }
            newNode.setNext(tempNode.getNext());
            tempNode.setNext(newNode);
        }
    }
}
