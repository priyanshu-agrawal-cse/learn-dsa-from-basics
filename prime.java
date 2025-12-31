public class prime {
    public static boolean checkprime(int a){
        
        for(int i=2;i*i<=a;i++){
            if(a%i==0){
                return false;
            }
        }
         return true;
    }

    public static void main(String[] args) {
        int s= 1;
        int en = 200;
        for(int i=s;i<=en;i++){
            if(checkprime(i)){
                System.out.println(i);
            }
        }
    }
}
