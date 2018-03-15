package com.interview.technical.crackingthecodinginterview.linkedlists.internal;

public class MyLinkedList
{
    public Node head;

    public void push(int data)
    {
        Node temp = new Node(data, head);
        head = temp;
    }

    public void createLoop()
    {
        Node slowPtr = head;
        Node fastPtr = head;
        while (slowPtr != null && fastPtr != null && fastPtr.next != null)
        {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
            if (fastPtr.next != null)
            {
                fastPtr = fastPtr.next;
            }

        }
        fastPtr.next = slowPtr;
    }

}
