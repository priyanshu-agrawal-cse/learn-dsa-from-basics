package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class questions {


    public static void fristNonRepeatingInStreamOfChar(String s){
        int[] arr = new int[26];
        Queue<Character> q = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            q.add(c);
            arr[c-'a']++;
            while (!q.isEmpty()&&arr[q.peek()-'a']>1) {
                q.remove();
            }
            if(q.isEmpty()){
                System.out.println(-1);
            }else{
                System.out.println(q.peek());
            }
        }
    }

    public static void interLeave(Queue<Integer> q){
        Queue<Integer> frist = new LinkedList<>();
        int size = q.size();
        for(int i=0;i<size/2;i++){
            frist.add(q.remove());
        }
        while (!frist.isEmpty()) {
            q.add(frist.remove());
            q.add(q.remove());
        }
    }

    public static void reverseQueue(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();

        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }


    public static void main(String[] args) {
        // String s = "aabccxb";
        // fristNonRepeatingInStreamOfChar(s);
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        System.out.println(q);

        // interLeave(q);
        reverseQueue(q);
        System.out.println(q);
    }


}
