package queue;
public class implementation {
    static class queue{
        static int[] arr;
        static int size;
        static int rear;
        queue(int n){
            arr = new int[n];
            size = n;
            rear=-1;
        }
        public  boolean isEmpty(){
            return rear==-1;
        }
        public  boolean isFull(){
            return rear==size-1;
        }
        public  void add(int data){
            if(isFull()){
                return;

            }
            arr[++rear]=data;
        }
        public  int remove(){
            if(isEmpty()){
                return -1;

            }
            int front = arr[0];
            for(int i=0;i<rear;i++){
                arr[i]=arr[i+1];
            }
            rear--;
            return front;
        }
    }
    public static void main(String[] args) {
        queue q = new queue(5);
        q.add(5);
        q.add(4);
        q.add(6);
        q.add(7);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
