import java.util.ArrayList;

public class opration_on_heap {
    public static class Heap {
    ArrayList<Integer> ar = new ArrayList<>();

    public void add(int data){
        ar.add(data);
        int x = ar.size()-1;//child node the node we added just now
        int par = (x-1)/2; //parent node
        while (ar.get(x)<ar.get(par)) {
            
            int temp = ar.get(x);
            ar.set(x, ar.get(par));
            ar.set(par, temp);
            x=par;
            par = (x-1)/2;
        }
    }

    public int peek(){
        return ar.get(0);
    }

    public void heapify(int i){
        int left = 2*i+1;
        int rigth = 2*i+2;
        int minIndex =i;

        if(left<ar.size()&&ar.get(minIndex)>ar.get(left)){
            minIndex = left;
        }
        if(rigth<ar.size()&&ar.get(minIndex)>ar.get(rigth)){
            minIndex = rigth;
        }

        if(minIndex!=i){
            int temp = ar.get(i);
            ar.set(i, ar.get(minIndex));
            ar.set(minIndex, temp);

            heapify(minIndex);
        }

    }

    public int remove(){
        int data = ar.get(0);

        //swap top and leaf
        int temp = ar.get(0);
        ar.set(0, ar.get(ar.size()-1));
        ar.set(ar.size()-1, temp);

        //remove last node
        ar.remove(ar.size()-1);

        //heapify
        heapify(0);

        return data;
    }
    public boolean isEmpty(){
        if(ar.size()==0){
            return true;
        }else{
            return false;
        }
    }
        
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);
        while (!h.isEmpty()) {
            System.out.println(h.remove());
            
        }
        
    }
}
