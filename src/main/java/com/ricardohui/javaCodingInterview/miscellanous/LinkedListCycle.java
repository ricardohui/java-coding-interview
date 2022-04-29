import com.ricardohui.javaCodingInterview.reversalLinkedList.ListNode;

class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
         ListNode fastPointer = head.next;
         ListNode slowPointer = head;
        while (fastPointer!=null) {

            if (fastPointer==slowPointer){
                return true;
            }


            if (fastPointer.next!=null && fastPointer.next.next!=null){
                fastPointer = fastPointer.next.next;
            }else{
                fastPointer = null;
            }

            if (slowPointer.next != null) {
                slowPointer = slowPointer.next;
            }else {
                slowPointer = null;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));
    }
}