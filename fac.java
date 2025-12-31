public class fac {

    public static int factorial(int n){
        if(n==1 ||n==0){
            return 1;
        }else{
            return n*factorial(n-1);
        }
    }
    public static int binomialCof(int n,int r){
        int factN = factorial(n);
        int factR = factorial(r);
        int factNR = factorial(n-r);
        return factN/(factR*factNR);
    }
    public static void main(String[] args) {
        System.out.println(binomialCof(4,1));
    }
}