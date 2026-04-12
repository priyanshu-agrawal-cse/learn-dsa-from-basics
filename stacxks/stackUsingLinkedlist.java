import java.util.ArrayList;

public class stackUsingLinkedlist {
    static class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    
        
    }
      static class stack{
        static Node head = null;
        //empty
        public boolean isEmpty(){
            return head==null;
        }
        //push 
        public void push(int data){
            if(isEmpty()){
                head=new Node(data);
            }else{
              Node newnode = new Node(data);
              newnode.next = head;
              head = newnode;

            }
        
        }
        //pop
          public int pop(){
            if(isEmpty()){
                return -1;
            }else{
             int data = head.data;
             head = head.next;
             return data;

            }
        
        }
        //peek
          public int peek(){
            if(isEmpty()){
                return -1;
            }else{
             int data = head.data;
             return data;

            }
        
        }


        

    }


    public static void main(String[] args) {
        stack s = new stack();
        System.out.println(s.isEmpty());
       s.push(5);
       s.push(4);
       s.push(3);
       while (!s.isEmpty()) {
        System.out.println(s.pop());
        
       }
        
    }
}
