package LeetCode;

public class o59 {
    class node {
        int val;
        node next;
        node (int v) {
            val = v;
            next = null;
        }
    }

    class MaxQueue {
        private node head;
        private node end;
        private node maxNode;
        private int size;

        public MaxQueue() {
            head = null;
            end = null;
            maxNode = null;
            size = 0;
        }

        public int max_value() {
            if (size == 0)
                return -1;
            return maxNode.val;
        }

        public void push_back(int value) {
            if (size == 0) {
                head = new node(value);
                end = head;
                maxNode = head;
            }
            else {
                end.next = new node(value);
                end = end.next;
                if (end.val > maxNode.val)
                    maxNode = end;
            }
            size++;
        }

        public int pop_front() {
            if (size == 0)
                return -1;
            int temp = head.val;
            if (head.val == maxNode.val) {
                node t = head.next;
                maxNode = t;
                while (t != null) {
                    if (t.val > maxNode.val)
                        maxNode = t;
                    t = t.next;
                }
            }
            if (size == 1) {
                head = null;
                end = null;
                maxNode = null;
                size--;
                return temp;
            }
            head = head.next;
            size--;
            return temp;
        }
    }
}
