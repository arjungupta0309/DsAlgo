import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by arjun on 01/04/19.
 */
//Given a value N, find the number of ways to make change for N cents, if we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins. The order of coins doesn’t matter. For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
public class CoinChange {

    final static int MAX = 100;
    final static int NIL = -1;

    static int lookup[] = new int[MAX];

    /* Function to initialize NIL values in lookup table */
    static void _initialize()
    {
        for (int i = 0; i < MAX; i++)
            lookup[i] = NIL;
    }

    static int findCoinchange(int[] s, int sum, int n){
        if (n<0 || sum <0) return 0;
        if (sum==0) return 1;
        else return findCoinchange(s,sum-s[n], n) + findCoinchange(s, sum, n-1);
    }

    static int findCoinchangeDp(int[] s, int m, int n){
       int[] table = new int[n+1];
        Arrays.fill(table, 0);
        table[0]=1;
        for (int i=0;i<m;i++){
            for (int j=1;j<=n;j++){
                if (s[i] <=j){
                    table[j] += table[j-s[i]];
                }
            }
        }
        return table[n];
    }



    public static void main(String[] a){
       /* int[] s = {2,5,3,6};
        System.out.println("ans="+findCoinchange(s, 10, s.length-1));*/

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        List<Integer> output = new ArrayList<>();
        List<Integer> output1 = new ArrayList<>();

        for (int i=0;i<T;i++){
            int N = s.nextInt();
            int[] input = new int[N];
            for (int j=0;j<N;j++){
                input[j] = s.nextInt();
            }
            int sum = s.nextInt();



            //output.add(findCoinchange(input, sum, N-1));

            output.add(findCoinchangeDp(input, N,sum ));
        }
        for (int i=0;i<output.size();i++){
            System.out.println(output.get(i));
        }
    }
}
