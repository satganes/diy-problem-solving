package com.interview.technical.crackingthecodinginterview.linkedlists;

import com.interview.technical.crackingthecodinginterview.linkedlists.internal.MyLinkedList;
import com.interview.technical.crackingthecodinginterview.linkedlists.internal.Node;

/**
 * Loop Detection: Given a circular linked list, implement an algorithm that
 * returns the node at the beginning of the loop.
 * 
 * <pre>
 * 
 * DEFINITION Circular linked
 * list: A (corrupt) linked list in which a node's next pointer points to an
 * earlier node, so as to make a loop in the linked list. 
 * EXAMPLE 
 * Input: A -> B -> C - > D -> E -> C [the same C as earlier] 
 * Output: C
 * 
 * </pre>
 * 
 * @author Sathish Ganesan
 *
 */
public class LoopDetectionLinkedList
{
    public static Node getTheCulprit(MyLinkedList input)
    {
        Node slowPtr = input.head;
        Node fastPtr = input.head;
        while (slowPtr != null && fastPtr != null)
        {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr)
            {
                // loop
                break;
            }
        }
        if (fastPtr == null || fastPtr.next == null)
        {
            // no duplicates
            return null;
        }
        slowPtr = input.head;
        while (slowPtr != fastPtr)
        {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }
        return fastPtr;
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
        input.createLoop();
        Node result = LoopDetectionLinkedList.getTheCulprit(input);
        if (result == null)
        {
            System.out.println("No loop");
        }
        else
        {
            System.out.println(result.data + " is the culprit");
        }
    }

}
