package LeetCode;

import java.util.Scanner;
import java.util.Stack;

public class _445 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<ListNode>();
        Stack<ListNode> s2 = new Stack<ListNode>();
        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }
        ListNode ans = null;
        int mark = 0;
        while (!s1.empty() || !s2.empty() || mark != 0) {
            ListNode temp = new ListNode(0);
            int tempAns = 0;
            if (!s1.empty()) {
                tempAns += s1.peek().val;
                s1.pop();
            }
            if (!s2.empty()) {
                tempAns += s2.peek().val;
                s2.pop();
            }
            tempAns += mark;
            mark = tempAns > 9 ? 1 : 0;
            temp.val = tempAns%10;
            temp.next = ans;
            ans = temp;
        }
        return ans;
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
            temp = addTwoNumbers(N, M);
            while (temp != null) {
                System.out.print(temp.val + "->");
                temp = temp.next;
            }
        }
    }
}

