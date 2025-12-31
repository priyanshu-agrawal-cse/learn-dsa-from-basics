public class backtrack {
  public static  void changeArr(int arr[] , int i, int val){
    if(i==5||i<0){
        return ;

    }
    arr[i]=val;
    printArr(arr);
    changeArr(arr, i+1, val+1);

    arr[i]=val-2; 
   printArr(arr);
    // changeArr(arr, i-1, val-2);
    }

    public static void printArr(int m[]){
        for(int i=0;i<m.length;i++){
            System.out.print(m[i]+" ");
        }
        System.out.println("");
    }




    //all subset of the string 
    public static void stringSunset(String s,int v){
        if (v>2) {
             System.out.println(s + "    ");
            return ;
        }
    
        stringSunset(s + (char)('a' + v), v+1);

        // s = s.substring(0, s.length() - 1);
        // System.out.println(s + "    ");
        stringSunset(s, v+1);

            // s += (char)('a' + v);
       
    }


    public static void allPermutationOfStringABC(String chooseFromThis , String Choosen ){
        if(chooseFromThis.length() == 0){
             System.out.println(Choosen + "    ");

            return ;

        }

        for(int i=0;i<chooseFromThis.length();i++){
           char ans = chooseFromThis.charAt(i) ;
           String NewchooseFromThis = chooseFromThis.substring(0, i) + chooseFromThis.substring(i+1);

            allPermutationOfStringABC(NewchooseFromThis, Choosen+ans);
        }


    }






    //nqueen

    public static void printBoard(char chess[][]){
        for(int i=0;i<chess.length;i++){
            for(int j=0;j<chess.length;j++){
            System.out.print(chess[i][j] +" ");
        }
        System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();


    }




    public static boolean isSafe(char chess[][],int row,int col){
        //check vertical uper

        for(int i=row;i>=0;i--){
            if(chess[i][col]=='Q'){
                return false;
            }
        }

        //check left diagonal
        for(int i=row , j=col;i>=0 &&j>=0;i--,j--){
            if(chess[i][j]=='Q'){
                return false;
            }
        }


        //check right diagonal 
          for(int i=row , j=col;i>=0 &&j<chess.length;i--,j++){
            if(chess[i][j]=='Q'){
                return false;
            }
        }

        return true;

    }


    public static void nqueen(char chess[][],int row){
        if(chess.length == row){
            printBoard(chess);
            return ;
        }

        for(int i=0;i<chess.length;i++){
            if(isSafe(chess, row,i)){
                  chess[row][i]='Q';
            nqueen(chess, row+1);
            chess[row][i]='.';
            }
          
        }
    }





    //no. of grid ways source to destination
    public static int gridWays(int i,int j, int n , int m){
        //base case
        if(i==n-1 &&j==m-1){
            return 1;
        }else if (i==n || j==m) {
            return 0;
        }
        int gridDown = gridWays(i+1, j, n, m);
        int gridRight = gridWays(i, j+1, n, m);

        return gridDown+gridRight;



    }





    //sudoko



   public static boolean sudokoIsSafe(int sudoko[][] ,int row,int col ,int digit){
     //row
    for(int i=0;i<=8;i++){
        if(sudoko[row][i]==digit){
            return false;
        }
    }

   //colum
     for(int i=0;i<=8;i++){
        if(sudoko[i][col]==digit){
            return false;
        }
    }

    //grid
   int sr = (row/3)*3;
   int sc = (col/3)*3;
    for(int i=sr;i<sr+3;i++ ){
        for(int j=sc;j<sc+3;j++){
            if(sudoko[i][j]==digit){
                return false;
            }
        }

    }

    return true;

   }






    public static boolean sovleSudoko(int sudoko [][] , int row , int col){
        //base case
        if (row == 9) {
    return true;
}




        //recursion

        int nextRow = row ; int nextCol = col+1;
        if(col+1==9){
            nextRow++;
            nextCol=0;
        }


if(sudoko[row][col]!=0){
    return sovleSudoko(sudoko, nextRow, nextCol);
}else{

        for(int i=1;i<=9;i++){
            if(sudokoIsSafe(sudoko , row, col , i)){
                sudoko[row][col]=i;
                if(sovleSudoko(sudoko, nextRow, nextCol)){
                    return true;
                }
                sudoko[row][col]=0;
            }
        }

}
        return false;
    }



   public static void printSudoko(int sudoku[][]){
    for(int i=0;i<9;i++){
        for(int j=0;j<9;j++){
            System.out.print(sudoku[i][j] +" ");
        }
        System.out.println();
    }
}







    public static void main(String[] args) {
        // int m[] = new int[5];
        // changeArr(m, 0, 1);
        // printArr(m);
// String s ="";
//         stringSunset(s, 0);

// String s ="abc";
// String s1 ="";
//        allPermutationOfStringABC(s, s1);

// int n=30;

// char chess[][] = new char[n][n];

//   for(int i=0;i<chess.length;i++){
//             for(int j=0;j<chess.length;j++){
//                 chess[i][j] = '.';
//             // System.out.print(chess[i][j] +" ");
//         }
//         // System.out.println();
//         }

//         nqueen(chess, 0);

// int grWay = gridWays(0, 0, 3, 4);
// System.out.println(grWay);









//  int sudoku[][] = {
//             {0, 0, 8, 0, 0, 0, 0, 0, 0},
//             {4, 9, 0, 1, 5, 7, 0, 0, 2},
//             {0, 0, 3, 0, 8, 4, 1, 0, 0},
//             {1, 8, 5, 0, 6, 0, 0, 2, 0},
//             {0, 0, 0, 0, 2, 8, 5, 6, 0},
//             {9, 6, 0, 4, 1, 5, 0, 0, 8},
//             {0, 3, 0, 6, 7, 0, 0, 0, 4},
//             {0, 4, 9, 0, 3, 0, 2, 0, 0},
//             {8, 2, 7, 5, 4, 9, 6, 0, 0}   // ✔ FINAL CORRECT LAST ROW
//         };
int sudoku[][] = new int[9][9];


    if(sovleSudoko(sudoku, 0, 0)){
        System.out.println("sudoko can be sovled ");
        printSudoko(sudoku);
    }else{
         System.out.println("sudoko can not be sovled ");
    }


    }
}
