package com.ricardohui.javaCodingInterview.miscellanous;

import com.ricardohui.javaCodingInterview.reversalLinkedList.ListNode;

class PalindromicLinkedList {

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reverseHead = reverse(slow);
        fast = reverseHead;
        slow = head;
        while ( fast != null) {
            if (fast.value != slow.value) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }

           reverse(reverseHead);
        if (slow == null || reverseHead == null) {
            return true;
        }

        return false;
    }

    private static ListNode reverse(ListNode head) {
        ListNode reveredHead = null;

        while (head != null) {
            ListNode remainingHead = head.next;
            head.next = reveredHead;
            reveredHead = head;
            head = remainingHead;
        }
        return reveredHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }
}
