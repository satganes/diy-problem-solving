package com.interview.technical.crackingthecodinginterview.linkedlists;

import com.interview.technical.crackingthecodinginterview.linkedlists.internal.MyLinkedList;
import com.interview.technical.crackingthecodinginterview.linkedlists.internal.Node;

/**
 * Implement an algorithm to find the kth to last element of a singly linked
 * list.
 * 
 * @author Sathish Ganesan
 *
 */
public class KthLastElementInLinkedList
{

    public static void getElementFromLast(MyLinkedList list, int k)
    {
        Node slowPtr = list.head;
        Node fastPtr = list.head;
        int count = 0;
        if (list.head != null)
        {
            while (count < k)
            {
                if (fastPtr == null)
                {
                    System.out.println("The length is shorter than the K");
                    System.exit(0);
                }
                fastPtr = fastPtr.next;
                count++;
            }
            while (fastPtr != null)
            {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
            }
            System.out.println("The Kth element from the last is : " + slowPtr.data);
        }
    }

    public static void main(String[] args)
    {
        MyLinkedList input = new MyLinkedList();
        input.push(1);
        input.push(2);
        input.push(3);
        input.push(4);
        input.push(5);

        KthLastElementInLinkedList.getElementFromLast(input, 3);
    }
}
