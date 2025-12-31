public class pattern {

    public static void hollow_rectangle(int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                    System.out.print("x");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void half_pyramid(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i + 1; k++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }

    public static void half_pyramid_withNumber(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(j);
            }

            System.out.println();

        }
    }

    public static void flyod_triangle(int n) {
        int count = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(count + " ");
                count++;
            }

            System.out.println();

        }
    }

    public static void tringle_0_1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("1");

                } else {
                    System.out.print("0");

                }
            }

            System.out.println();

        }
    }

    public static void rombus(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n-1; j++) {
             System.out.print(" ");
            }
            for (int j = 0; j < n; j++) {
             System.out.print("*");
            }

            System.out.println();

        }
    }

    public static void ButerFlyPattern(int n) {
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");

            }
            for (int j = 1; j <= n-2*i; j++) {
                System.out.print(" ");

            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");

            }

            System.out.println();

        }
        
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j <n/2- i; j++) {
                System.out.print("*");

            }
            for (int j = 0; j < 2*i; j++) {
                System.out.print(" ");

            }
            for (int j = 0; j <n/2-i; j++) {
                System.out.print("*");

            }

            System.out.println();

        }
    }

    public static void main(String[] args) {
        // hollow_rectangle(4,5 );
        // half_pyramid(4);
        // half_pyramid_withNumber(5);
        // flyod_triangle(5);
        // tringle_0_1(6);
        // ButerFlyPattern(10);
        rombus(5);

    }
}
