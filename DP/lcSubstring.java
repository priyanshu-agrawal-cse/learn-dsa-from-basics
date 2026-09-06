import java.util.Arrays;

public class lcSubstring {
    
    public static int lcsTab(String s1,String s2,int n,int m){

          int dp[][] = new int[s1.length()+1][s2.length()+1];
      int max=0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                     dp[i][j] = dp[i-1][j-1]+1;
                }else{
                     dp[i][j] = 0;
                }
                max= Math.max(max,dp[i][j]);
               
            }
        }
        return max;


    }



    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abgce";




        System.out.println(lcsTab(s1, s2, s1.length(), s2.length()));

    }
}
