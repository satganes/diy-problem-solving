package com.interview.technical.crackingthecodinginterview.linkedlists.internal;

public class MyLinkedList
{
    public Node head ;

    public void push(int data)
    {
        Node temp = new Node(data, head);
        head = temp;
    }

}
