package com.ricardohui.javaCodingInterview.miscellanous;

import com.ricardohui.javaCodingInterview.reversalLinkedList.ListNode;

class MiddleOfLinkedList {

    public static ListNode findMiddle(ListNode head) {

        int totalNodes = 1;
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            totalNodes++;
        }
        int midPoint = totalNodes / 2 + 1;


        int count = 1;
        node = head;
        do {
            count++;
            node = node.next;
            if (count == midPoint) {
                return node;
            }
        } while (node.next!=null);

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);

        head.next.next.next.next.next = new ListNode(6);
        System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);

        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);
    }
}