public class LinkedList {


    public static class Node {
        int data;
        Node next ;
        public Node (int data){
            this.data = data;
            next = null;
        }
    
        
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFrist(int data){
        // create new node 
        Node newNode = new Node(data);
        size++;

        //if no element is present 
        if(head == null ){
            head = tail = newNode;
            return;

        }

        //point new node to head 
        newNode.next = head;

        //move head to newnode 
        head = newNode;

    }


    public void addLast(int data){
        // create new node 
        Node newNode = new Node(data);
        size++;


        //if no element is present 
        if(tail == null ){
            head = tail = newNode;
            return;

        }

        //point new node to head 
        tail.next = newNode;

        //move head to newnode 
        tail = newNode;

    }


    public void printData(){
        if(head ==null){
            System.out.println("linked list is empty");
            return;
        }
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data +"->");
            temp = temp.next;
            
        }
        System.out.println("null");
    }


    public void add (int idx, int data){
        if(idx==0){
            addFrist(data);
            return;
        }
        Node newNode = new Node(data);
        size++;

        Node temp = head;
        int i=0;
        while (i<idx-1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }


    public int removeFrist(){
        if(size==0){
            System.out.println("only one node is present");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val = head.data;
            size--;
            head= tail=null;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }


    public int removeLast(){
        if(size==0){
            System.out.println("only one node is present");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val = head.data;
            size--;
            head= tail=null;
            return val;
        }

        Node pre = head;

        for(int i =0;i<size-2;i++){
            pre = pre.next;

        }

        int val = pre.next.data;
        pre.next = null;
        tail = pre;
        size--;
        return val;
    }

    public int itrSearch(int key){
        Node temp = head ;
        int idx = 0; 
        while(temp != null){
            if(temp.data == key){
                System.out.println("key found at idx "+ idx);
                return idx;
            }
            temp= temp.next;
            idx++;
        }
        return -1;
    }


public int helper(Node head, int key){
    if(head==null){
        return -1;

    }
    if(head.data==key){
        return 0;
    }
    int idx = helper(head.next, key);
    if(idx==-1){
        return -1;
    }
    return idx+1;
}


    public int recSearch( int key){
        return helper(head,key);
    }





    public void reverseLinkedList(){
        Node prev =null, curr =tail= head , next;

        while (curr!=null) {
            next = curr.next;
            curr.next=prev;
            prev= curr;
            curr=next;
            
        }
        // head.next=null;
        head= prev;
    }
    
public static void main(String[] args) {
    LinkedList ll = new LinkedList();
     ll.addFrist(2);
    ll.addFrist(1);
   
    ll.addLast(3);
    ll.addLast(4);
    ll.add(2, 10);
    // System.out.println(head.data);
    // System.out.println(tail.data);
    ll.printData();
    ll.reverseLinkedList();
//    ll.removeLast();
   ll.printData();
//    ll.itrSearch(10);
//    System.out.println(ll.recSearch(10));

    // System.out.println(size);
}
    
}