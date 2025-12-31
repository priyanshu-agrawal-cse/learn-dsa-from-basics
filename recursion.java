public class recursion {
    public static void reverseNo(int n) {
        if (n <= 0) {
            return;
        }
        System.out.println(n);
        reverseNo(n - 1);
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        // System.out.println(n);
        // reverseNo(n-1);
        return n * factorial(n - 1);
    }

    public static int fibonachi(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        // System.out.println(n);
        // reverseNo(n-1);
        return fibonachi(n - 1) + fibonachi(n - 2);
    }

    public static int checkSorted(int[] n, int l) {
        if (l == 0 || l == 1) {
            return 1;
        }
        if (n[l - 1] > n[l - 2]) {
            int i = checkSorted(n, l - 1);
            if (i == 0) {
                return 0;
            }
        } else {
            return 0;
        }
        // return 0;
        return 1;
    }

    public static int fristOccurence(int[] n, int k, int i) {
        if (i == n.length) {
            return 0;
        }
        if (n[i] == k) {
            return i;
        }
        return fristOccurence(n, k, i + 1);
    }

    public static int lastOccurence(int[] n, int k, int i) {
        if (i < 0) {
            return -1;
        }
        if (n[i] == k) {
            return i;
        }
        return fristOccurence(n, k, i - 1);
    }

    public static int power( int n, int i) {
        if(i==0){
            return 1;
        }
        if(i%2==0){
            return power(n, i/2)*power(n,i/2);
        }else{
            return n*power(n, i/2)*power(n,i/2);
        }
    }
    public static int possibleTitle( int n) {
       if(n<4){
        return n;
       }
       int ver = possibleTitle(n-1);
       int hori = possibleTitle(n-2);
       return ver + hori;
    }


    public static int friendParing( int n) {
        if(n<=2){
            return n;
        }
        int sing = friendParing(n-1);
        int pair = friendParing(n-2);
        return sing+(n-1)*pair;

       
    }
    public static int binaryString( int n) {
        if(n<=2){
            return n+1;
        }
        int zero = binaryString(n-1);
        int one = binaryString(n-2);
        // System.out.println(zero+""+one);
        return zero+one;

       
    }

    public static void main(String[] args) {
        // reverseNo(6);
        // System.out.println(factorial(5));
        // System.out.println(fibonachi(6));
        // int[] n = { 1, 2, 5, 6, 5 };
        // System.out.println(checkSorted(n, 5));
        // System.out.println(lastOccurence(n, 5, n.length - 1));
        // System.out.println(power(2,10));
        // System.out.println(possibleTitle(5));
        System.out.println(binaryString(4));

    }
}