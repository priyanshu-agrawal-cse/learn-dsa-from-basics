import java.util.Scanner;

public class q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        while (a%10!=0) {
             a = sc.nextInt();
        }
sc.close();
    }
}