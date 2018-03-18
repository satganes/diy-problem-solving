package com.interview.technical.crackingthecodinginterview.linkedlists;

import com.interview.technical.crackingthecodinginterview.linkedlists.internal.MyLinkedList;
import com.interview.technical.crackingthecodinginterview.linkedlists.internal.Node;

/**
 * 
 * Implement an algorithm to delete a node in the middle (i.e., any node but the
 * first and last node, not necessarily the exact middle) of a singly linked
 * list, given only access to that node.
 * 
 * <pre>
 * EXAMPLE 
 * 
 * lnput:the node c from the linked list
 * a->b->c->d->e->f 
 * Result: nothing is returned, but the new linked list looks like 
 * a->b->d->e- >f
 * </pre>
 * 
 * @author Sathish Ganesan
 *
 */
public class RemoveMiddleElement
{
    public static void delete(MyLinkedList input)
    {
        Node slow = input.head;
        Node fast = input.head;
        Node slowMinusOne = null;
        while (fast != null && fast.next != null)
        {
            slowMinusOne = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        slowMinusOne.next = slow.next;
    }

    public static void main(String[] args)
    {
        MyLinkedList input = new MyLinkedList();
        input.push(1);
        input.push(2);
        input.push(3);
        input.push(4);
        input.push(5);
        input.push(6);
        input.push(7);
        input.push(8);
        System.out.println("Before : " + input.print());
        RemoveMiddleElement.delete(input);
        System.out.println("After : " + input.print());
    }

}
