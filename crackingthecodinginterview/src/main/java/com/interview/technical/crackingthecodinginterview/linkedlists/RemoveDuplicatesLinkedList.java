package com.interview.technical.crackingthecodinginterview.linkedlists;

import java.util.HashSet;
import java.util.Set;

import com.interview.technical.crackingthecodinginterview.linkedlists.internal.MyLinkedList;
import com.interview.technical.crackingthecodinginterview.linkedlists.internal.Node;

/**
 * Write code to remove duplicates from an unsorted linked list. FOLLOW UP How
 * would you solve this problem if a temporary buffer is not allowed?
 * 
 * @author Sathish Ganesan
 *
 */
public class RemoveDuplicatesLinkedList
{

    public static void cleanse(Node input)
    {
        Set<Integer> uniqueSet = new HashSet<>();
        Node current = input;
        Node previous = null;
        while (current != null)
        {
            if (uniqueSet.contains(current.data))
            {
                previous.next = current.next;
            }
            else
            {
                uniqueSet.add(current.data);
                previous = current;
            }
            current = current.next;
        }

    }

    static void printList(Node head)
    {
        while (head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args)
    {
        MyLinkedList input = new MyLinkedList();
        input.push(1);
        input.push(2);
        input.push(2);
        input.push(3);
        input.push(3);
        input.push(1);
        input.push(1);
        input.push(1);
        System.out.println("Before the linked list was: " + input.print());
        RemoveDuplicatesLinkedList.cleanse(input.head);
        System.out.println("After cleansing : " + input.print());

    }
}
