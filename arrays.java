public class arrays {
    public static void printArr(int m[]){
        for(int i=0;i<m.length;i++){
            System.out.println(m[i]);
        }
    }
    public static void reverse(int m[]){
          for(int i=0;i<m.length/2;i++){
            int a = m[i];
            m[i] = m[m.length -i-1];
            m[m.length -i-1] =a ;
        }
    }

    public static void subarray(int n[]){
        for(int i=0;i<n.length;i++){
            for(int j=i+1;j<n.length;j++){
                for(int k= i;k<=j;k++){
                    System.out.print(n[k]+",");
                }
                System.out.print("      ");
            }
            System.out.println();
        }
    }


    public static int Maxsubarray(int n[]){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n.length;i++){

            for(int j=i+1;j<n.length;j++){
                int m=0;
                for(int k= i;k<=j;k++){
                    m+=n[k];
                    // System.out.print(n[k]+",");
                }
                if(m>max){
                    max=m;
                }
                // System.out.print("      ");
            }
            // System.out.println();
        }
        return max;
    }

    public static int kadane(int n[]){
        int max = Integer.MIN_VALUE;
        int curesum=0;
        for(int i=0;i<n.length;i++){
            if(curesum+n[i]<0){
                curesum=0;
            }else{
                curesum+=n[i];
            }

            if(curesum>max){
                max=curesum;
            }

            
        }
        return max;
    }

    public static int trapRain(int n[]){
        int r=0;
        int maxleft=0;
        int maxright=0;
        for(int i=1;i<n.length-1;i++){
           for(int j=0;j<i;j++){
            maxleft = Math.max(maxleft, n[j]);
        }
           for(int j=i+1;j<n.length;j++){
            maxright = Math.max(maxright, n[j]);
        }

        r+=Math.min(maxright, maxleft) -n[i];
    }

        return r ;
    }


    public static int buySellStock(int n[]){
        int maxP=0;
        int minBuy=n[0];
        for(int i=0;i<n.length;i++){
            minBuy = Math.min(n[i], minBuy);
            maxP = Math.max(maxP, n[i]-minBuy);
        }


        return maxP;

    }

    public static void Triplet(int n[]){
        for(int i=0;i<n.length;i++){
            for(int j=i+1;j<n.length;j++){
                for(int k=0;k<n.length;k++){
                    if(i!=j &&j!=k &&i!=k && n[i]+n[j]+n[k]==0){
                        System.out.println(n[i] +" " + n[j] +" " + n[k]);
                    }
                }
            }
        }
    }
    public static void Spiralmatrix(int m[][]){
        int startRow =0, startCol=0,endRow = m.length -1, endCol = m[0].length -1;
        while (startCol<=endCol && startRow<=endRow) {
            for(int j=startCol;j<endCol;j++){
                System.out.print(m[startRow][j]+" ");
            }
            for(int j=startCol+1;j<endCol;j++){
                System.out.print(m[j][endCol]+" ");
            }
            for(int j=endCol-1;j>=startCol;j--){
                System.out.print(m[endRow][j]+" ");
            }
            for(int j=endRow-1;j>=startRow+1;j--){
                System.out.print(m[j][startCol]+" ");
            }
            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
    }
    public static void main(String[] args) {
        // int n[] ={-2,-3,4,-1,-2,1,5,-3};
        // int n[] ={4,2,0,6,3,2,5};
        int n[] ={-1, 0,  1, 2, -1, -4};
        int m[][] ={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        // int n[] ={7,1,5,3,6,4};
        // for(int i=0;i<3;i++){
        //     n[i]=i;
        // }

        // printArr(n);
        // reverse(n);
        // printArr(n);

        // subarray(n);
    //    int a= Maxsubarray(n);
    //    int a= kadane(n);
    //    int a= trapRain(n);
    //    Triplet(n);
    Spiralmatrix(m);
    //    int a= buySellStock(n);
    //    System.out.println(a);
    }
}
