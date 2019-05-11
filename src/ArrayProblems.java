import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by arjun on 26/03/19.
 */
public class ArrayProblems {


    /*Q1. Maximum sum such that no two elements are adjacent
    Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers in the sequence should be adjacent in the array. So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).Answer the question in most efficient way.

            Examples :

    Input : arr[] = {5, 1, 10, 100, 10, 5}
    Output : 110*/
    int findMaxSum(int[] ar){
        int N = ar.length;
        if (N==0) return 0;
        int prevInclusive = ar[0];
        int prevExclusive = 0;
        int inclusive=0;
        int exclusive=0;

        for (int i=1;i<N;i++){
            inclusive = prevExclusive + ar[i];
            exclusive = (prevExclusive >prevInclusive) ? prevExclusive:prevInclusive ;
            prevInclusive = inclusive;
            prevExclusive = exclusive;
        }

        return (prevExclusive >prevInclusive) ? prevExclusive:prevInclusive;
    }


    public static void main(String[] a){
        ArrayProblems obj = new ArrayProblems();
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        List<Integer> output = new ArrayList<>();
        for (int i=0;i<T;i++){
            int N = s.nextInt();
            int[] array = new int[N];
            for (int j=0;j<N;j++){
                array[j] = s.nextInt();
            }
            output.add(obj.findMaxSum(array));
        }

        for (int i=0;i<T;i++){
            System.out.println(output.get(i));
        }

    }
}
