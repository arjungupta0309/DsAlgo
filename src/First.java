import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by arjun on 08/09/18.
 */
/*1. Find the largest binary gap
        2. Right shift by K
        3. Find the unique number if array contains all  elements which are repeated once except 1 e.g. {1,3,3,1,2} = 2 */
public class First {

    static void rightShiftByK(int[] arr, int K){
        //the approach is to first take mod by N. then right shift 1 each time to K times
        int N = arr.length;
        if (N==1) return;
        K = K%N;
        int c = 0;
        while (c< K){
            int current = arr[0];

            for (int i=0;i<arr.length;i++){
                if (i<arr.length-1){
                    int next = arr[i+1];
                    arr[i+1] = current;
                    current = next;
                }
                else {
                    arr[0] = current;
                }
            }
            c++;
        }

        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        //order of complexity=O(arr.length * K%arr.length ) = O( arr.length)
    }

    static void findUnique(int[] arr ){
        //Find the unique number if array contains all  elements which are repeated once except 1 e.g. {1,3,3,1,2} = 2
        //take zor of the array. it will give the result. if it is 0 then no unique element else it will return the unique element
        int x = 0;
        for (int i=0;i<arr.length;i++){
            x = x^arr[i];
        }

        System.out.println(x);
    }

    static void findLargestBinaryGap(int N){
        List<Integer> list = new ArrayList<>();
        int m = N;
        while (m !=0){

            list.add(m%2);
            m = m/2;
        }

        int max = 0;
        int current = 0;
        boolean start =false;

        for(int i=0;i<list.size();i++) {
            int bit = list.get(i);

            if (i == 0 && bit == 0) continue;

            if (bit == 1 && !start) {
                start = true;
            } else if (bit == 0 && start) {
                current++;
            } else if (bit == 1 && start) {
                max = (current > max) ? current : max;
                current = 0;
            }
        }

        System.out.println(max);

    }



    public static void main(String[] a){
        int arr[] = {1,2,3,4,5};
        //First.rightShiftByK(arr, 1000001);
        //First.findUnique(new int[]{1,3,2,1,2});
        First.findLargestBinaryGap(5139);
    }

}
