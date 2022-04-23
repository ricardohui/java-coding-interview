package com.ricardohui.javaCodingInterview.reversalLinkedList;



class ReverseEveryKElements {


    public static ListNode reverse(ListNode head, int k) {
        // TODO: Write your code here

        ListNode current = head;
        ListNode previous = null;


        while (true){
            ListNode lastNodeOfPreviousPart = previous;
            ListNode lastNodeOfSublist = current;
 int i = 0;
            while (current != null && i < k){
                ListNode next = current.next;

                current.next = previous;
                previous = current;

                current = next;
                i++;
            }

            if (lastNodeOfPreviousPart == null)
            {
                head = previous;
            }else{
                lastNodeOfPreviousPart.next = previous;
            }

                  lastNodeOfSublist.next = current;
            if(current== null){
                break;
            }



            previous = lastNodeOfSublist;

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

        ListNode result = ReverseEveryKElements.reverse(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}