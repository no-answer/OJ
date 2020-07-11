package LeetCode;

public class o52 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode HeadA = headA;
        ListNode HeadB = headB;
        while (HeadA != HeadB) {
            HeadA = HeadA == null ? headB : HeadA.next;
            HeadB = HeadB == null ? headA : HeadB.next;
        }
        return HeadA;
    }
}
