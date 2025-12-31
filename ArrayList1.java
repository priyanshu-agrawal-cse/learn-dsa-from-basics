import java.util.*;

public class ArrayList1 {

    public static int ContainerWithMostWater(ArrayList<Integer> m){
        int lp = 0;
        int rp= m.size()-1;
        int Gwater = 0;
        while(lp<rp){
            int hieght = Math.min(m.get(lp), m.get(rp));
            int width = rp-lp;
            int water = hieght*width;
            Gwater = Math.max(Gwater, water);
            if(m.get(lp)<m.get(rp)){
                lp++;
            }else{
                rp--;
            }

        }
        return Gwater;
    }
    public static boolean target(ArrayList<Integer> m,int target){
        Collections.sort(m);
        int lp = 0;
        int rp= m.size()-1;
        // int Gwater = 0;
        while(lp<rp){

           if((m.get(lp)+m.get(rp))==target){
            return true;
           }else if(m.get(lp)<m.get(rp)){
                lp++;
            }else{
                rp--;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        //  ArrayList<ArrayList<Integer>> mm = new ArrayList<>();
        
        
        //  mm.add(n);
        //  System.out.println(mm);
        //  for(int i=1;i<=4;i++){
        //      ArrayList<Integer> n = new ArrayList<>();
        //     for(int j=0;j<5;j++){
        //         n.add(i*j);

        //     }
        //     mm.add(n);
        //  }
        //  System.out.println(mm);

        ArrayList<Integer> n = new ArrayList<>();
        n.add(1);
        n.add(8);
        n.add(6);
        n.add(2);
        n.add(5);
        n.add(4);
        n.add(8);
        n.add(3);
        n.add(7);
        // System.out.println(ContainerWithMostWater(n));
        System.out.println(target(n, 9));

    }
}