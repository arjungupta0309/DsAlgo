import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by arjun on 31/03/19.
 */
/*Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1′ into ‘str2′.

        Insert
        Remove
        Replace
        All of the above operations are of cost=1.
        Both the strings are of lowercase.

        Input:
        The First line of the input contains an integer T denoting the number of test cases. Then T test cases follow. Each tese case consists of two lines. The first line of each test case consists of two space separated integers P and Q denoting the length of the strings str1 and str2 respectively. The second line of each test case coantains two space separated strings str1 and str2 in order.


        Output:
        Corresponding to each test case, pirnt in a new line, the minimum number of operations required.

        Constraints:
        1<=T<=50
        1<= Length(str1) <= 100
        1<= Length(str2) <= 100


        Example:
        Input:
        1
        4 5
        geek gesek

        Output:
        1*/
public class Editdistance {

    static int minOperationsDp(String s1, String s2, int m, int n){
        int[][] dp = new int[m+1][n+1];
        for (int i=0;i<=m;i++){
            for (int j=0;j<=n;j++){
                if (i==0)
                    dp[i][j] = j;
                else if (j==0){
                    dp[i][j] =i;

                }
                else if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = 1+min(dp[i-1][j-1],//replace
                            dp[i-1][j], //remove
                            dp[i][j-1]);//insert
                }
            }
        }
        return dp[m][n];
    }//complexity: O(MN)

    static int minOperations1(String s1, String s2, int m, int n) {
        if (m==0) return n;
        if (n==0) return m;

        if (s1.charAt(m-1) == s2.charAt(n-1)){
            return minOperations1(s1, s2,m-1,n-1);
        }
        else {
            return 1+min(minOperations1(s1,s2,m,n-1), //insert
                    minOperations1(s1,s2,m-1,n),//remove
                    minOperations1(s1,s2,m-1,n-1));//replace
        }

    }//complexity:O(3^M)


    static int min(int a, int b,int c){
        int min = a;
        if (min > b)
            min = b;
        if (min > c)
            min = c;

        return min;
    }


    public static void main(String[] a){
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        List<Integer> output = new ArrayList<>();

        for (int i=0;i<T;i++){
            int M = s.nextInt();
            int N = s.nextInt();

            String s1 = s.next();
            String s2 = s.next();
            int[][] refer = new int[M][N];

            for (int m=0;m<M;m++){
                for (int n=0;n<N;n++){
                    refer[m][n] = -1;
                }
            }
            output.add(minOperations1(s1, s2, M,N));

        }
        for (int i=0;i<output.size();i++){
            System.out.println(output.get(i));
        }
    }
}
