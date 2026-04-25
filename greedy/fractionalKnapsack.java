import java.util.Arrays;
import java.util.Comparator;

public class fractionalKnapsack {
    public static void main(String[] args) {
        int value[]= {60,100,120};
        int wieght[] = {10,20,30};

        double ratio[][] = new double[value.length][2];
        for(int i=0;i<value.length;i++){
            ratio[i][0]= i;
            ratio[i][1]= value[i]/(double) wieght[i];
        }

        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));

        int capacity =50;
        int val=0;
        for(int i=ratio.length-1;i>=0;i--){
            if(capacity>=wieght[(int) ratio[i][0]]){
                val+=value[(int) ratio[i][0]];
                capacity-=wieght[(int) ratio[i][0]];

            }else{
                val+=ratio[i][1]*capacity;
                break;

            }
        }
        System.out.println(val);
       
    }
}
