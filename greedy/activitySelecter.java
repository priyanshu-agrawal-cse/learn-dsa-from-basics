import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class activitySelecter {
    public static void main(String[] args) {
        // int[] start = {1,3,0,5,8,5};
        // int[] end = {2,4,6,7,9,9};
//if end time is sorted
        // int maxActivity =0;
        // ArrayList<Integer> indexOfActivity = new ArrayList<>();
        // //initialise
        // maxActivity =1;
        // indexOfActivity.add(0);
        // int endTime = end[0];
        // for(int i=1;i<start.length;i++){
        //     if(start[i]>=endTime){
        //         maxActivity++;
        //         indexOfActivity.add(i);
        //         endTime=end[i];
        //     }
        // }
        // System.out.println(maxActivity);
        // System.out.println(indexOfActivity);



        //if end time is not sorted
            int[] start = {3,1,0,5,8,5};
        int[] end = {4,2,6,7,9,9};
         int maxActivity =0;
        ArrayList<Integer> indexOfActivity = new ArrayList<>();
        int activitys[][] = new int[start.length][3];
        for(int i=0;i<start.length;i++){
            activitys[i][0]=i;
            activitys[i][1]=start[i];
            activitys[i][2]=end[i];
        }

        //sorting 2d with col==3
        Arrays.sort(activitys,Comparator.comparingDouble(o->o[2]));
        //initialise
        maxActivity =1;
        indexOfActivity.add(activitys[0][0]);
        int endTime = activitys[0][2];
        for(int i=1;i<start.length;i++){
            if(activitys[i][1]>=endTime){
                maxActivity++;
                indexOfActivity.add(activitys[i][0]);
                endTime=activitys[i][2];
            }
        }
        System.out.println(maxActivity);
        System.out.println(indexOfActivity);
    }
}
