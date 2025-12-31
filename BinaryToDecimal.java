public class BinaryToDecimal {
    public static int BtoD(int b){
int d=0,i=0;
        while(b!=0){
            int c=b%10;
            b=b/10;
            d+=c*Math.pow(2,i);
            i++;


        }
        return d;
    }

    public static int DtoB(int d){
int b=0,i=0;
        while(d!=0){
           int c= d%2;
           int add =c*(int)Math.pow(10,i);
           b+=add;
           i++;
           d=d/2;


        }
        return b;
    }
    public static void main(String[] args) {
        
        

        System.out.println(BtoD(10010));
        System.out.println(DtoB(18));
    }
}
