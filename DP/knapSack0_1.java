import java.util.Arrays;

public class knapSack0_1 {
    public static int knapsackRec(int wt[],int val[],int W,int n){
        if(W==0||n<0){
            return 0;
        }

       if(W-wt[n]>=0){//valid
        //include
        int ans1 = val[n]+knapsackRec(wt, val, W-wt[n], n-1);

        //exclude
        int ans2 = knapsackRec(wt, val, W, n-1);

        return Math.max(ans1,ans2);
       } else{
        //exclude
        return knapsackRec(wt, val, W, n-1);
       }


    }

    //memorisation
    public static int knapsackMemo(int wt[],int val[],int W,int n,int dp[][]){
        if(W==0||n==0){
            return 0;
        }
        if(dp[n][W]!=-1){
            return dp[n][W];
        }

       if(W-wt[n-1]>=0){//valid
        //include
        int ans1 = val[n-1]+knapsackMemo(wt, val, W-wt[n-1], n-1,dp);

        //exclude
        int ans2 = knapsackMemo(wt, val, W, n-1,dp);

        return dp[n][W]= Math.max(ans1,ans2);
       } else{
        //exclude
        return dp[n][W]= knapsackMemo(wt, val, W, n-1,dp);
       }


    }


    public static void print(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+"  ");
            }
            System.out.println();
        }
    }






    public static int knapsackTab(int wt[],int val[],int W){
        int dp[][] = new int[wt.length+1][W+1];

        for(int i=1;i<wt.length+1;i++){
            for(int j=1;j<W+1;j++){
                //check
                if(wt[i-1]<=j){
                    //include
                    int ans1 = val[i-1]+dp[i-1][j-wt[i-1]];
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

    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;
        int dp[][] = new int[wt.length+1][W+1];
        // Arrays.fill(dp, -1);
        for(int i=0;i<dp.length;i++){
        Arrays.fill(dp[i], -1);

        }
        // System.out.println(knapsackRec(wt, val, W, wt.length-1));
        // System.out.println(knapsackMemo(wt, val, W, wt.length, dp));
        System.out.println(knapsackTab(wt, val, W));
    }
}
