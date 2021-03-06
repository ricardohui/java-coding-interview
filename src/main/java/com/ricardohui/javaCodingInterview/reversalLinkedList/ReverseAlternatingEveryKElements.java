package com.ricardohui.javaCodingInterview.reversalLinkedList;

import com.ricardohui.javaCodingInterview.reversalLinkedList.ListNode;

class ReverseAlternatingEveryKElements {

    public static ListNode reverse(ListNode head, int k) {
        if (k <= 1 || head == null) return head;

        ListNode current = head, previous = null;
        while (true) {
            ListNode lastNodeOfPreviousPart = previous;
            ListNode lastNodeOfSubList = current;


                for (int i = 0; i < k && current!=null; i++) {
                    ListNode next = current.next;
                    current.next = previous;
                    previous = current;
                    current = next;
                }


            if (lastNodeOfPreviousPart != null) {
                lastNodeOfPreviousPart.next = previous;
            }else{
                head = previous;
            }

            lastNodeOfSubList.next = current;

            for (int i = 0; i < k && current != null; i++) {
                previous = current;
                current = current.next;
            }

            if (current == null) {
                break;
            }

        }
        
        
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = ReverseAlternatingEveryKElements.reverse(head, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}