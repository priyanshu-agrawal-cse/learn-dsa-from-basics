public class climbingStair {
    //recursion
    public static int countWays(int n){
        if(n==0){
            return 1;
        }
        if(n<0) return 0;
        return countWays(n-1)+countWays(n-2);
    }

    //memorisation
   public static int countWaysMemo(int n,int f[]){
        if(n==0){
            return 1;
        }
        if(n<0) return 0;
        if(f[n]!=0){
            return f[n];
        }
        f[n]= countWaysMemo(n-1,f)+countWaysMemo(n-2,f);
        return f[n];
    }

    //tabulation
       public static int countWaysTab(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n=5;//answer is 8
        // System.out.println(countWays(n));
        // int f[] = new int[n+1];
        // System.out.println(countWaysMemo(n, f));
        System.out.println(countWaysTab(n));
    }
}
