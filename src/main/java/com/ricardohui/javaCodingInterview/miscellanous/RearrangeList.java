
class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class RearrangeList {

    public static void reorder(ListNode head) {
        // find midpoint
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse
        ListNode headSecondHalf = reverse(slow);
        ListNode headFirstHalf = head;


        // two linkedList
        while (headFirstHalf != null && headSecondHalf != null) {
            ListNode remainingHead = headFirstHalf.next;
            headFirstHalf.next = headSecondHalf;
            headFirstHalf = remainingHead;

            remainingHead = headSecondHalf.next;
            headSecondHalf.next = headFirstHalf;
            headSecondHalf = remainingHead;
        }

        if (headFirstHalf != null) {
            headFirstHalf.next = null;
        }
    }

    private static ListNode reverse(ListNode head) {
        ListNode reversedHead = null;

        while (head != null) {
            ListNode remainingHead = head.next;
            head.next = reversedHead;
            reversedHead = head;
            head = remainingHead;

        }
        return reversedHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        RearrangeList.reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
