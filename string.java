public class string {
    public static boolean palidrom(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
    public static double shortestpath(String s){
        int north=0,east=0;
        double r=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='N'){
                north++;
            }
            if(s.charAt(i)=='E'){
                east++;
            }
            if(s.charAt(i)=='S'){
                north--;
            }
            if(s.charAt(i)=='W'){
                east--;
            }
        }

        r= Math.sqrt(Math.pow(north,2)+Math.pow(east, 2));
return r;
    }

    public static String stringCompression(String s){
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<s.length();i++){
            int count=1;
            sb.append(s.charAt(i));
            while (i<s.length()-1 &&s.charAt(i)==s.charAt(i+1)) {
                count++;
                i++;
                
            }
            if(count>1){
            sb.append(count);

            }
        }




        return sb.toString();
    }
        
    public static void main(String[] args) {
    //     String s="abbaa";
    //    System.out.println(palidrom(s));

    String s = "aaabbc";
    // System.out.println(shortestpath(s));
    System.out.println(stringCompression(s));
        
    }
}
