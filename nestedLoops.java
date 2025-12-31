// import java.util.Scanner;

// public class nestedLoops {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int a = sc.nextInt();
//         for(int i=0;i<a;i++){
//             for(int j=0;j<=i;j++){
//                 System.err.print("*");
//             }
//             System.err.println("");
//         }


//         sc.close();
//     }
// }
// import java.util.Scanner;

// public class nestedLoops {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int a = sc.nextInt();
//         for(int i=0;i<a;i++){
//             for(int j=i;j<=a-1;j++){
//                 System.err.print("*");
//             }
//             System.err.println("");
//         }


//         sc.close();
//     }
// }
import java.util.Scanner;

public class nestedLoops {
    public static void main(String[] args) {
        char ch ='A';
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for(int i=0;i<a;i++){
            for(int j=1;j<=i+1;j++){
              
                System.err.print(ch);
                  ch++;
            }
            System.err.println("");
        }


        sc.close();
    }
}
