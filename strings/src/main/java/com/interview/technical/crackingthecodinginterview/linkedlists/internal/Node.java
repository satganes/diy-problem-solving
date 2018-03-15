package com.interview.technical.crackingthecodinginterview.linkedlists.internal;

/**
 * @author Sathish Ganesan
 *
 */
public class Node
{

    public int  data;
    public Node next;

    public Node(int data)
    {
        this.data = data;
        this.next = null;
    }

    public Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
    

}
