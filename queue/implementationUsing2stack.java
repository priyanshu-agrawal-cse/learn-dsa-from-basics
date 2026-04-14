package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class implementationUsing2stack {
    static class queue {
       static Stack<Integer> s1 = new Stack<>();
       static Stack<Integer> s2 = new Stack<>();

        public  void add(int data){
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
                
            }
            s1.push(data);
             while (!s2.isEmpty()) {
                s1.push(s2.pop());
                
            }
        }

        public  int remove(){
            return s1.pop();
        }
    }

    public static void main(String[] args) {
        queue q = new queue();
        q.add(5);
        q.add(4);
        q.add(6);
        q.add(7);
        System.out.println(q.remove());
    }
}
