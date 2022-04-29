package com.ricardohui.javaCodingInterview.miscellanous;

import com.ricardohui.javaCodingInterview.reversalLinkedList.ListNode;

class RotateList {

    public static ListNode rotate(ListNode head, int rotations) {
        int count = 0;
        ListNode list = head;
        ListNode lastNode = null;
        while (list != null) {
            count++;
            if (list.next == null) {
                lastNode = list;
            }
            list = list.next;
        }

        lastNode.next = head;

        list = head;
        int i = 0;
        while (i < rotations) {
            list = list.next;
            i++;
        }
        head = list;
        ListNode tail = head;
        i = 0;
        while (i < count - 1) {
            tail = tail.next;
            i++;
        }
        tail.next = null;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode result = RotateList.rotate(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}