package queue;

public class implementationLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    static class queue {
        static Node head;
        static Node tail;

        queue() {
            head = null;
            tail = null;
        }

        public boolean isEmpty() {
            return head == null && tail == null;
        }

        public void add(int data) {
            Node newn = new Node(data);

            if (head == null) {
                head = tail = newn;
            } else {
                tail.next = newn;
                tail = newn;
            }

        }

        public int remove() {
            if (isEmpty()) {
                return -1;

            }
            int re = head.data;
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;

            }
            return re;
        }
    }

    public static void main(String[] args) {
        queue q = new queue();
        q.add(5);
        q.add(4);
        q.add(6);
        q.add(7);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }

}
