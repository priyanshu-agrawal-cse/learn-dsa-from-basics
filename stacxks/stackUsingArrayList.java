import java.util.ArrayList;
public class stackUsingArrayList {
  public static class stack{
        static ArrayList<Integer> list = new ArrayList<>();
        public boolean isEmpty(){
            return list.size()==0;
        }
        public void push(int data){
            list.add(data);
        }
        public int pop(){
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
        public int peek(){
            int top = list.get(list.size()-1);
            
            return top;
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
