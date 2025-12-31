import java.util.*;

public class hashing {

    public static void getFrequency(int arr[]) {
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (h.containsKey(arr[i])) {
                h.put(arr[i], h.get(arr[i]) + 1);
            } else {
                h.put(arr[i], 1);
            }
        }
        System.out.println(h);

    }

    public static boolean isAnagram(String s1, String s2) { // anagram means contain same no. of letters and same
                                                            // letters maybe different arrangment
        HashMap<Character, Integer> tm1 = new HashMap<>();
        HashMap<Character, Integer> tm2 = new HashMap<>();
        if (s1.length() != s2.length()) {
            System.out.println("length not equal");
            return false;
        }
        int v = 0;
        for (int i = 0; i < s1.length(); i++) {
            v = tm1.getOrDefault(s1.charAt(i), 0);
            tm1.put(s1.charAt(i), v + 1);

            v = tm2.getOrDefault(s2.charAt(i), 0);
            tm2.put(s2.charAt(i), v + 1);
        }

        // for(Character key : tm1.keySet()){
        // if(!tm2.containsKey(key)||tm1.get(key)!=tm2.get(key)){
        // System.out.println("value not equal or not present");

        // return false;
        // }
        // tm1.remove(key);// worng
        // tm2.remove(key);//wrong we cannot romve at time of iteration

        // }
        // if(!tm1.isEmpty()||!tm2.isEmpty()){
        // System.out.println("anyone contain some extra");

        // return false;
        // }
        if (tm1.equals(tm2)) {
            return true;
        }

        return false;

    }

   
    // longest subarray with sum =0
    public static int LongestSubarrayWithSum0(int arr[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int len = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (!hm.containsKey(sum)) {
                hm.put(sum, i);

            } else {
                len = Math.max(len, i - hm.get(sum));
            }

        }
        return len;
    }








     public static void CountOfSubarryWhoseSumIsK(int arr[], int k) {
        int sum = 0;
        int res = 0;

        HashMap<Integer,Integer> hm = new HashMap<>();
        //add default value
        hm.put(0, 1);


        for(int i=0;i<arr.length;i++){
            sum +=arr[i];
            if(hm.containsKey(sum-k)){
                res+=hm.get(sum-k);

            }
            hm.put(sum, hm.getOrDefault(sum,0)+1);
        }
        System.out.println(res);

    }


    public static void main(String[] args) {
        // HashMap<String,Integer> hm = new HashMap<>();
        // hm.put("india", 4);
        // hm.put("dia", 7);
        // hm.put("di", 7);
        // System.out.println(hm.containsKey("india"));
        // System.out.println(hm.get("dia"));
        // System.out.println(hm);

        // hm.remove("di");

        // System.out.println(hm);

        // Set<String> keys = hm.keySet();
        // System.out.println(keys);
        // for (String k : keys) {
        // System.out.println("keys "+k+" value "+hm.get(k));
        // }

        // linked hashmap mentain the order of insertion
        // LinkedHashMap<Integer,Integer> lhm = new LinkedHashMap<>();
        // lhm.put(1,2 );
        // lhm.put(2,3 );
        // lhm.put(3,4 );
        // lhm.put(4,5 );
        // System.out.println(lhm);

        // TreeMap<Integer,Integer> thm = new TreeMap<>();
        // thm.put(1,2 );
        // thm.put(2,3 );
        // thm.put(5,4 );
        // thm.put(4,5 );
        // System.out.println(thm);

        // int arr[] = {1,3,2,5,1,3,1,5,1};
        // System.out.println(arr);
        // getFrequency(arr);

        // String s1 = "abc";
        // String s2 = "cba";
        // System.out.println(isAnagram(s1, s2));

        // hashset
        // HashSet<Integer> hs = new HashSet<>();
        // hs.add(1);
        // hs.add(9);
        // hs.add(10);

        // hs.add(2);
        // hs.add(3);
        // hs.add(4);
        // hs.add(4);
        // hs.add(6);
        // System.out.println(hs);

        // using iterartor
        // Iterator it = hs.iterator();
        // while (it.hasNext()) {
        // System.out.println(it.next());

        // }

        // using advance forloop
        // for (Integer i : hs) {
        // System.out.println(i);
        // }

        // linked hashset
        // LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        // lhs.add(1);
        // lhs.add(9);
        // lhs.add(10);

        // lhs.add(2);
        // lhs.add(3);
        // lhs.add(4);
        // lhs.add(4);
        // lhs.add(6);
        // System.out.println(lhs);

        // treeset
        // TreeSet<Integer> ts = new TreeSet<>();
        // ts.add(1);
        // ts.add(9);
        // ts.add(10);

        // ts.add(2);
        // ts.add(3);
        // ts.add(4);
        // ts.add(4);
        // ts.add(6);
        // System.out.println(ts);

        // count distint elements
        // HashSet<Integer> hs = new HashSet<>();
        // int arr[] = {1,2,3,4,2,6,4,2};
        // for(int i=0;i<arr.length;i++){
        // hs.add(arr[i]);
        // }
        // System.out.println(hs.size());

        // union
        // int arr1[] = {1,2,5,6,7,8};
        // int arr2[] = {1,2,2,3,4,8};
        // HashSet<Integer> hs = new HashSet<>();
        // for(int i=0;i<arr1.length;i++){
        // hs.add(arr1[i]);
        // }
        // for(int i=0;i<arr2.length;i++){
        // hs.add(arr2[i]);
        // }
        // System.out.println(hs);

        // intersection
        // int arr1[] = {1,2,5,6,7,8};
        // int arr2[] = {1,2,2,3,4,8};
        // HashSet<Integer> hs = new HashSet<>();
        // int count =0;
        // for(int i=0;i<arr1.length;i++){
        // hs.add(arr1[i]);
        // }
        // for(int i=0;i<arr2.length;i++){
        // if(hs.contains(arr2[i])){
        // count++;
        // hs.remove(arr2[i]);

        // }
        // }
        // System.out.println(hs +""+ count);

        // int arr[] = {15,-2,2,-8,1,7,10};
        // System.out.println(LongestSubarrayWithSum0(arr));

        int arr[] = { 10, 2, -2, -20, 10 };
        CountOfSubarryWhoseSumIsK(arr, -10);

    }
}
