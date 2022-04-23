package com.ricardohui.javaCodingInterview.reversalLinkedList;

import com.ricardohui.javaCodingInterview.reversalLinkedList.ListNode;

class ReverseSubList {

    public static ListNode reverse(ListNode head, int p, int q) {
        int i = 1;
        ListNode lastNodeOfFirstPart = null;
        ListNode current = head;
        while(i < p ) {
            lastNodeOfFirstPart = current;
            current = current.next;
            i++;
        }
        // now head = p - 1;
        // headBeforeChanges.next = reversedHead
        ListNode originalNext;
        ListNode reversedHead = current;
        ListNode lastNodeOfSubList = current;
        while (current != null && i < q + 1) {
            originalNext = current.next;
            current.next = reversedHead;
            reversedHead.next = current;
            current = originalNext;
            i++;
        }

        lastNodeOfFirstPart.next = reversedHead;

        lastNodeOfSubList.next = current;


        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubList.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}