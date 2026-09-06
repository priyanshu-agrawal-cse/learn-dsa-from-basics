public class targetSumSubset {
   
    public static boolean targetsum(int arr[],int sum ){
        int n= arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];

        //initialization
        for(int i=0;i<dp.length;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                //inculde
                int val = arr[i-1];
                if(val<=j&&dp[i-1][j-val]){
                    dp[i][j] = true;
                }else{
                    //exclude
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        print(dp);
        return dp[n][sum];
    }
    

     public static void print(boolean dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+"  ");
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {
        int arr[] ={4,2,1,3};
        int sum = 10;
        System.out.println(targetsum(arr, sum));
    }
}
