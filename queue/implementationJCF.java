package queue;

import java.util.LinkedList;
import java.util.Queue;

public class implementationJCF {
        public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(5);
        q.add(4);
        q.add(6);
        q.add(7);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
