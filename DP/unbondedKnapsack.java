import java.util.Arrays;

public class unbondedKnapsack {
    
    public static int knapsackTab(int wt[],int val[],int W){
        int dp[][] = new int[wt.length+1][W+1];

        for(int i=1;i<wt.length+1;i++){
            for(int j=1;j<W+1;j++){
                //check
                if(wt[i-1]<=j){
                    //include
                    int ans1 = val[i-1]+dp[i][j-wt[i-1]];
                    //exclude
                    int ans2 = dp[i-1][j];
                    dp[i][j]=Math.max(ans1, ans2);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        print(dp);
        return dp[wt.length][W];
    }


     public static void print(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+"  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;
        
       
        System.out.println(knapsackTab(wt, val, W));
    }
}
