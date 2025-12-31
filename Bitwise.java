public class Bitwise {
    public static int getIthBit(int n, int bit) {
        return (1 << bit) & n;
    }

    public static int setIthBit(int n, int bit) {
        return (1 << bit) | n;
    }

    public static int clearIthBit(int n, int bit) {
        return ~(1 << bit) & n;
    }

    public static int cleariBit(int n, int bit) {
        return (~(0) << bit) & n;
    }

    public static int cleariBiRange(int n, int i, int j) {
        int clearBack = ((~0) << i + 1);
        int clearFront = ~((~0) << j);
        // or int clearFront = (1<<j)-1 ;
        return (clearBack | clearFront) & n;
    }

    public static int countSetBitNumber(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n>>1;
        }
        return count;

    }
    public static int fastExponential(int n,int pow) {
        int re = 1;
        while (pow != 0) {
            if ((pow & 1) == 1) {
                re *=n;
              

            }
              n = n*n;
            pow = pow>>1;
        }
        return re;

    }

    public static void main(String[] args) {
        // System.out.println(5 << 90);
        // System.out.println(5 ^ 6 ^5);
        // int a=4;
        // if((a & 1)==1){
        // System.out.println("odd");
        // }
        // System.out.println(setIthBit(5, 1));
        // System.out.println(cleariBit(10, 2));
        // System.out.println(cleariBiRange(15, 2, 1));
        // System.out.println(countSetBitNumber(15)); 
        System.out.println(fastExponential(10,3)); 
    }
}
