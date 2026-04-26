import java.util.ArrayList;
import java.util.Collections;

public class jobSeqencing {
    static class Job {
    int profit,deadline,index;
    public Job(int i,int d , int p){
        profit=p;
        deadline=d;
        index=i;
    }
        
    }
    public static void main(String[] args) {
        int jobSeq[][]={{4,20},{1,10},{1,40},{1,30}};

        ArrayList<Job> job = new ArrayList<>();
        for(int i=0;i<jobSeq.length;i++){
            job.add(new Job(i, jobSeq[i][0],jobSeq[i][1]));
        }

        Collections.sort(job,(obj1,obj2)->obj2.profit-obj1.profit);
        
        ArrayList<Integer> ans = new ArrayList<>();
        int time =0;
        for(int i=0;i<job.size();i++){
            if(job.get(i).deadline>time){
                time++;
                ans.add(job.get(i).index);
            }
        }
        System.out.println(time);
        System.out.println(ans);
    }
}
