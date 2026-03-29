public class LinkedList {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }

    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFrist(int data) {
        // create new node
        Node newNode = new Node(data);
        size++;

        // if no element is present
        if (head == null) {
            head = tail = newNode;
            return;

        }

        // point new node to head
        newNode.next = head;

        // move head to newnode
        head = newNode;

    }

    public void addLast(int data) {
        // create new node
        Node newNode = new Node(data);
        size++;

        // if no element is present
        if (tail == null) {
            head = tail = newNode;
            return;

        }

        // point new node to head
        tail.next = newNode;

        // move head to newnode
        tail = newNode;

    }

    public void printData() {
        if (head == null) {
            System.out.println("linked list is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;

        }
        System.out.println("null");
    }

    public void add(int idx, int data) {
        if (idx == 0) {
            addFrist(data);
            return;
        }
        Node newNode = new Node(data);
        size++;

        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFrist() {
        if (size == 0) {
            System.out.println("only one node is present");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            size--;
            head = tail = null;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("only one node is present");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            size--;
            head = tail = null;
            return val;
        }

        Node pre = head;

        for (int i = 0; i < size - 2; i++) {
            pre = pre.next;

        }

        int val = pre.next.data;
        pre.next = null;
        tail = pre;
        size--;
        return val;
    }

    public int itrSearch(int key) {
        Node temp = head;
        int idx = 0;
        while (temp != null) {
            if (temp.data == key) {
                System.out.println("key found at idx " + idx);
                return idx;
            }
            temp = temp.next;
            idx++;
        }
        return -1;
    }

    public int helper(Node head, int key) {
        if (head == null) {
            return -1;

        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public int recSearch(int key) {
        return helper(head, key);
    }

    public void reverseLinkedList() {
        Node prev = null, curr = tail = head, next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        // head.next=null;
        head = prev;
    }

    public void removeNthFromTheEnd(int idx) {
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            sz++;
            temp = temp.next;

        }
        if (idx == sz) {
            removeFrist();
            return;
        }

        Node pre = head;
        for (int i = 0; i < sz - idx - 1; i++) {
            pre = pre.next;

        }
        pre.next = pre.next.next;
    }

    // slow-fast approch

    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow;

    }

    public boolean checkPallindrom() {
        if (head == null || head.next == null) {
            return true;
        }
        // step 1 find mid
        Node mid = findMid(head);

        // reverse the second half

        Node pre = null;
        Node curr = mid;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;

        }

        Node right = pre; // right head
        Node left = head;

        // step 3 check pallindrome
        while (right != null) {
            if (left.data != right.data) {
                return false;

            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public boolean isCyclePresent() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }

        }
        return false;
    }

    public void removeCycle() {
        // detect cycle
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }

        }

        // find last node (pre)
        Node pre = null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            pre = fast;
            fast = fast.next;

        }

        // break the cycle
        pre.next = null;
    }




    public Node merge(Node h1, Node h2) {
        Node mergell = new Node(-1);
        Node temp = mergell;

        while (h1 != null && h2 != null) {
            if (h1.data < h2.data) {
                temp.next = h1;
                h1 = h1.next;
                temp = temp.next;
            } else {
                temp.next = h2;
                h2 = h2.next;
                temp = temp.next;
            }

        }

        while (h1!=null) {
             temp.next = h1;
                h1 = h1.next;
                temp = temp.next;
        }
        while (h2!=null) {
             temp.next = h2;
                h2 = h2.next;
                temp = temp.next;
        }

        return mergell.next;
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // find mid

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }
        Node mid = slow;

        // apply mergesort on left and right ll
        Node right = mid.next;
        mid.next = null;
        Node newleft = mergeSort(head);
        Node newright = mergeSort(right);

        // merge
        return merge(newleft, newright);
    }






    public void zigzag(){
        //find mid
        Node slow = head;
        Node fast = head.next;
        while (fast!=null &&fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            
        }

        Node mid = slow;
        Node rihtLLHead = mid.next;
        mid.next = null;


        //reverse 2nd linkedlist 
        Node pre = null;
        Node curr = rihtLLHead;
        Node next ;
        while (curr!=null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr= next;
            
        }
        



        // merge
        Node leftHead = head;
        rihtLLHead = pre;
        Node leftNext= leftHead.next , rightNext = rihtLLHead.next ;

        while (leftNext!= null && rightNext != null) {
            leftNext= leftHead.next;
            rightNext = rihtLLHead.next ;
            leftHead.next = rihtLLHead;
            rihtLLHead.next = leftNext;


            leftHead = leftNext;
            rihtLLHead = rightNext;

            
        }


    }












    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // ll.addFrist(2);
        // ll.addFrist(1);

        // ll.addLast(3);
        // ll.addLast(4);
        // ll.add(2, 10);
        // System.out.println(head.data);
        // System.out.println(tail.data);
        // ll.printData();
        // ll.reverseLinkedList();
        // ll.removeLast();
        // ll.printData();
        // ll.itrSearch(10);
        // System.out.println(ll.recSearch(10));

        // System.out.println(size);

        // ll.printData();
        // ll.removeNthFromTheEnd(2);
        // ll.printData();

        // ll.addLast(1);
        // ll.addLast(2);
        // // ll.addLast(1);
        // ll.addLast(3);
        // ll.addLast(4);
        // head.next.next.next.next = head.next;
        // // ll.printData();

        // System.out.println(ll.isCyclePresent());
        // ll.removeCycle();
        // System.out.println(ll.isCyclePresent());
        ll.addFrist(1);
        ll.addFrist(2);
        ll.addFrist(3);
        ll.addFrist(4);
        ll.addFrist(5);
        ll.printData();
        // head = ll.mergeSort(head);
        ll.zigzag();
        ll.printData();

    }

}