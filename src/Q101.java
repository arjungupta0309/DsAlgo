import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by arjun on 22/12/18.
 * Given a set of m distinct positive integers and a value ‘N’. The problem is to count the total number of ways we can form ‘N’ by doing sum of the array elements. Repetitions and different arrangements are allowed.

 Examples :

 Input : arr = {1, 5, 6}, N = 7
 Output : 6

 Explanation:- The different ways are:
 1+1+1+1+1+1+1
 1+1+5
 1+5+1
 5+1+1
 1+6
 6+1

 Input : arr = {12, 3, 1, 9}, N = 14
 Output : 150
 */
public class Q101 {

    /*
    Given a set of m distinct positive integers and a value ‘N’. The problem is to count the total number of ways we can form ‘N’ by doing sum of the array elements. Repetitions and different arrangements are allowed.

 Examples :

 Input : arr = {1, 5, 6}, N = 7
 Output : 6

 Explanation:- The different ways are:
 1+1+1+1+1+1+1
 1+1+5
 1+5+1
 5+1+1
 1+6
 6+1

 */
    public static int findWays(int[] ar, int m, int N){
        int[] count = new int[N+1];
        count[0]=1;

        for (int i=1; i<=N; i++){
            for (int j=0;j<m;j++){
                if (i>= ar[j]) {
                    count[i] += count[i - ar[j]];
                }
            }
        }

        return count[N];
    }


    /*
    Given an input string and a dictionary of words, find out if the input string can be segmented into a space-separated sequence of dictionary words. See following examples for more details.
This is a famous Google interview question, also being asked by many other companies now a days.

Consider the following dictionary
{ i, like, sam, sung, samsung, mobile, ice,
  cream, icecream, man, go, mango}

Input:  ilike
Output: Yes
The string can be segmented as "i like".

Input:  ilikesamsung
Output: Yes
The string can be segmented as "i like samsung"
or "i like sam sung".
     */
    public static boolean wordBreak(List<String> dic, String str){
        int N = str.length();
        if (N==0) return true;

        for (int i=0;i<N;i++) {
            String prefix = str.substring(0, i + 1);
            if (dic.contains(prefix)) {
                String suffix = str.substring(i + 1, N);
                boolean result = wordBreak(dic, suffix);
                if (result) {
                    return true;
                }
            }
        }

        return false;
    }

    /*
    frequency of an element in sorted array having duplicate elements
     */
    public static int findFrequency(int[] ar, int N){
        int high = -1;
        int low = -1;
        int l = 0;
        int h = ar.length;

        while(l<=h){
            int m = (l+h)/2;
            if (ar[m]==N && (m==h || ar[m+1]>N)) {
                high = m;
                break;
            }
            else if (ar[m]<=N){
                l = m+1;
            }
            else if (ar[m] > N){
                h=m-1;
            }
        }

        l = 0;
        h = ar.length;

        while(l<=h){
            int m = (l+h)/2;
            if (ar[m]==N && (m==l || ar[m-1]<N)){
                low=m;
                break;
            }
            else if (ar[m]>=N){
                h=m-1;
            }
            else if (ar[m] < N){
                l = m+1;
            }
        }

        int frequency = high-low+1;
        return frequency;
    }

    /*
    Write a function to search in an array which is sorted in
ascending order till an index and sorted in descending 
order after that 
     {4,6,8,20,15,12}*/
    public static int find(int[] ar, int N){
        int l=0;
        int h = ar.length-1;
        int index = -1;

        while (l<=h){
            int m = (l+h)/2;
            if ((m==0 || ar[m-1]<ar[m]) && (m==h || ar[m]> ar[m+1])){
                index=m;
                break;
            }
            else if (m==0 || ar[m-1]<ar[m]){
                l=m+1;
            }
            else h=m-1;
        }

        l=0;
        h=index;
        while (l<=h){
            int m = (l+h)/2;
            if (ar[m] == N){
                return m;
            }
            else if (ar[m] < N){
                l=m+1;
            }
            else h=m-1;
        }

        l=index+1;
        h=ar.length;
        while (l<=h){
            int m = (l+h)/2;
            if (ar[m] == N){
                return m;
            }
            else if (ar[m] < N){
                h=m-1;
            }
            else l=m+1;
        }

        return -1;
    }

    /*
    The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such that
     all elements of the subsequence are sorted in increasing order. For example, the length of LIS for
     {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
     */
    /*public static int LIS(int[] ar){
        int N = ar.length;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> max = new ArrayList<>();
        List<Integer> list1 = null;

        for (int i=0;i<N;i++){
            if (max.isEmpty()){
                max.add(ar[i]);
                list1 = new ArrayList<>();
                list1.add(1);
                list.add(list1);
            }
            else {
                if (list.size()==i ){
                    list.add(i, list.get(i-1));
                }
                boolean flag = false;
                for (int j=0;j<max.size();j++){
                    if (ar[i] > max.get(j)){
                        max.remove(j);
                        max.add(j, ar[i]);
                        int val = list.get(i).get(j);
                        val++;
                        list.get(i).remove(j);
                        list.get(i).add(j, val);

                    }
                    else {
                        if (!flag){
                            max.add(ar[i]);
                            list.get(i).add(1);
                            flag = true;
                        }

                    }
                }
            }
        }

        int maxCount = Collections.max(list.get(N-1));
        return maxCount;
    }*/
    public static int LIS(int[] ar){
        int N = ar.length;
        int[] count = new int[N];

        for (int i=0;i<N;i++){
            count[i] = 1;
        }

        for (int i=1;i<N;i++){
            for (int j=0;j<i;j++){
                if (ar[j] < ar[i] && count[i] <= count[j]){
                    count[i] = count[j]+1;
                }
            }
        }

        return count[N-1];
    }

    /*
    maximum summation of i*arr[i] for an array over every rotation of the array by 1 element
    e.g. {1,20,2,18}   2,0,3,1      0*2+1*0+2*3+3*1=9     1203   0*1+1*2+2*0+3*3=11
    it can be found by observing the following
    R0 = 0*a[0] + 1*a[1[ + 2* a[2] + 3*a[3]
    R1 = 0*a[3] + 1*a[0] + 2* a[1] + 3*a[2]
    R1-R0 = a[0]+a[1]+a[2]-3a[3] = a[0]+a[1]+a[2]+a[3]-4a[3] = sum - n*a[4-1]
    in general, Rj = Rj-1 + sum  - n*a[n-j]
     */
    public static int maxSummation(int[] a){
        int N = a.length;
        int sum=0;
        int r0=0;
        int count[] = new int[N];
        for (int i=0;i<N ;i++){
            r0 += i*a[i];
            sum+=a[i];
        }

        count[0] = r0;
        int max = count[0];
        for (int i=1;i<N;i++){
            count[i] = count[i-1] + sum - N*a[N-i];
            if (max < count[i]) max = count[i];
        }

        return max;
    }




    public static void main(String[] a){
        int[] arr = {12, 3, 1, 9};
        System.out.println(findWays(arr, 4,14));
        String[] dic = { "i", "like", "sam", "sung", "samsung", "mobile", "ice",
                "cream", "icecream", "man", "go", "mango"};
        List<String> list = Arrays.asList(dic);
        System.out.println(wordBreak(list, "ilike"));
        System.out.println(wordBreak(list, "ilikesamsung"));
        int[] arr1 = {1,1,1,1,1,2,2,2,3,3,3,3};
        System.out.println(findFrequency(arr1, 2));
        int arr2[] = {50, 3, 10, 7, 40, 80};
        System.out.println(find(arr2, 3));
        int arr3[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println(LIS(arr3));
        int arr4[] = {1,20,2,18};
        System.out.println("max summation="+maxSummation(arr4));
        Integer a1 = new Integer(1);
        Integer a2 = new Integer(1);
        System.out.println("a1==a2 : "+(a1==a2));
        System.out.println("a1.equals(a2) : "+a1.equals(a2));






    }
}
