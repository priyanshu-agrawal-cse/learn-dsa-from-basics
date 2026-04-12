import java.util.Stack;

public class stackUsingJavaCollection {
    public static void pushAtBottom(Stack<Integer> s, int n) {
        if (s.isEmpty()) {
            s.push(n);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, n);
        s.push(top);
    }

    public static String revreseString(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            st.push(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            sb.append(st.pop());
        }
        return sb.toString();
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        s.push(0); // pushing indexof 1st that is 0
        span[0] = 1; // always true
        for (int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];
            while (!s.isEmpty() && currPrice >= stocks[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                int preHigh = s.peek();
                // System.out.println(preHigh);
                span[i] = i - preHigh;
            }
            s.push(i);
        }

    }

    public static void nextGreater(int arr[], int nextGreaterElement[]) {
        Stack<Integer> s = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            while (!s.isEmpty() && arr[i] > arr[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                 nextGreaterElement[i] = -1;
            } else {
                nextGreaterElement[i] = arr[s.peek()];
            }
            s.push(i);
        }

    }


    public static boolean isVaildParanthese(String s){
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                st.push(s.charAt(i));
            }else{
                if((s.charAt(i)==')'&&st.peek()!='(')||(s.charAt(i)=='}'&&st.peek()!='{')||(s.charAt(i)==']'&&st.peek()!='[')){
                    
                    return false;
                }else{
                    st.pop();
                }
            }
        }
        if(st.isEmpty()){
            return true;
        }
        return false;
    }


    public static boolean isDublicateParanthese(String s){
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||(s.charAt(i)<='z'&&s.charAt(i)>='a')||s.charAt(i)=='+'){
                st.push(s.charAt(i));
            }else{
                int count=0;
                while (st.pop()!='(') {
                    count++;
                    
                }
                if(count==0){
                    return true;
                }
            }
        }
        
        return false;
    }


    public static int MaxHistogramArea(int h[]){

        int nsr[] = new int[h.length];
        int nsl[] = new int[h.length];
        //next smaller right
             Stack<Integer> s = new Stack<>();

        for (int i = h.length - 1; i >= 0; i--) {

            while (!s.isEmpty() && h[i] <= h[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                 nsr[i] = h.length;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }

    

        //next smaller left
                    Stack<Integer> s1 = new Stack<>();

        for (int i =0 ; i <h.length ; i++) {

            while (!s1.isEmpty() && h[i] <= h[s1.peek()]) {
                s1.pop();
            }
            if (s1.isEmpty()) {
                 nsl[i] = -1;
            } else {
                nsl[i] = s1.peek();
            }
            s1.push(i);
        }

    

        //current area
        int max =0;
        for(int i=0;i<h.length;i++){
            max = Math.max(max, (nsr[i]-nsl[i]-1)*h[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // System.out.println(s);
        // pushAtBottom(s,4);
        // System.out.println(s);

        // String s= "hello world";
        // System.out.println(s);
        // s= revreseString(s);
        // System.out.println(s);

        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // System.out.println(s);
        // reverseStack(s);
        // System.out.println(s);

        // int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
        // int span[] = new int[stocks.length];
        // System.out.println(stocks);
        // stockSpan(stocks, span);
        // for (int i = 0; i < span.length; i++) {
        //     System.out.println(span[i]);
        // }


        //         int arr[] = { 6,8,0,1,3 };
        // int nextGreaterElement[] = new int[arr.length];
        // nextGreater(arr, nextGreaterElement);
        // for (int i = 0; i < nextGreaterElement.length; i++) {
        //     System.out.println(nextGreaterElement[i]);
        // }



        // String s= "({[]})";
        // System.out.println(isVaildParanthese(s));


        //         String s= "(a+((b)))";
        // System.out.println(isDublicateParanthese(s));



        int arr[] = { 2,1,5,6,2,3 };
        System.out.println(MaxHistogramArea(arr));

    }
}
