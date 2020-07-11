package LeetCode;
import LeetCode._445;

import java.util.Scanner;

public class _21 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode ansTemp = ans;
        while (l1 != null && l2 != null) {
            ListNode temp = new ListNode(0);
            if (l1.val > l2.val) {
                temp.val = l2.val;
                l2 = l2.next;
            }
            else {
                temp.val = l1.val;
                l1 = l1.next;
            }
            ansTemp.next = temp;
            ansTemp = ansTemp.next;
        }
        while (l1 != null) {
            ListNode temp = new ListNode(l1.val);
            l1 = l1.next;
            ansTemp.next = temp;
            ansTemp = ansTemp.next;
        }
        while (l2 != null) {
            ListNode temp = new ListNode(l2.val);
            l2 = l2.next;
            ansTemp.next = temp;
            ansTemp = ansTemp.next;
        }
        return ans.next;
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            ListNode N = new ListNode(0);
            ListNode M = new ListNode(0);
            ListNode temp = N;
            N.val = in.nextInt();
            for (int i = 1; i < n; i++) {
                temp.next = new ListNode(in.nextInt());
                temp = temp.next;
            }
            temp = M;
            M.val = in.nextInt();
            for (int i = 1; i < m; i++) {
                temp.next = new ListNode(in.nextInt());
                temp = temp.next;
            }
            temp = mergeTwoLists(N, M);
            while (temp != null) {
                System.out.print(temp.val + "->");
                temp = temp.next;
            }
        }
    }
}
