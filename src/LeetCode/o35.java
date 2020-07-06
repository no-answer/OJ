package LeetCode;

import java.util.ArrayList;

public class o35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node tHead = head;
        ArrayList<Node> array = new ArrayList<>();
        while (tHead != null) {
            Node tempNode = new Node(tHead.val);
            array.add(tempNode);
            tHead = tHead.next;
        }
        tHead = head;
        for (int i = 0; i < array.size(); i++) {
            if (i > 1)
                array.get(i-1).next = array.get(i);
            array.get(i).random = array.get(array.size()-index(tHead));
        }

        return array.get(0);
    }

    private int index(Node node) {
        int index = 0;
        while (node != null) {
            node = node.next;
            index++;
        }
        return index;
    }
}
