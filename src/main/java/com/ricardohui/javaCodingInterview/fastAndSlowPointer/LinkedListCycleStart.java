package com.ricardohui.javaCodingInterview.fastAndSlowPointer;

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class LinkedListCycleStart {

    public static ListNode findCycleStart(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int cycleLength = 0;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                cycleLength = calculateCycleLength(fast);
                break;
            }
        }
        //cycle found



        fast = head;
        slow = head;
        while (cycleLength!=0){
            fast = fast.next;
            cycleLength--;
        }

        while(fast!=slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    private static int calculateCycleLength(ListNode head){
        int count = 1;
        ListNode target = head;
        head = head.next;
        while(head!=null && head!=target){
            head = head.next;
            count++;
        }


        return count;
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
    }
}