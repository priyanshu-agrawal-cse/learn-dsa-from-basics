import java.util.LinkedList;
import java.util.Queue;

public class implementingUsing2Queue {
    static class stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }
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
