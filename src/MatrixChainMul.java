import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by arjun on 13/04/19.
 */
public class MatrixChainMul {


    /*Matrix Chain Multiplication | DP-8
    Given a sequence of matrices, find the most efficient way to multiply these matrices together. The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications.

    We have many options to multiply a chain of matrices because matrix multiplication is associative. In other words, no matter how we parenthesize the product, the result will be the same. For example, if we had four matrices A, B, C, and D, we would have:

            (ABC)D = (AB)(CD) = A(BCD) = ....
    However, the order in which we parenthesize the product affects the number of simple arithmetic operations needed to compute the product, or the efficiency. For example, suppose A is a 10 × 30 matrix, B is a 30 × 5 matrix, and C is a 5 × 60 matrix. Then,

            (AB)C = (10×30×5) + (10×5×60) = 1500 + 3000 = 4500 operations
    A(BC) = (30×5×60) + (10×30×60) = 9000 + 18000 = 27000 operations.
    Clearly the first parenthesization requires less number of operations.

    Given an array p[] which represents the chain of matrices such that the ith matrix Ai is of dimension p[i-1] x p[i].
    We need to write a function MatrixChainOrder() that should return the minimum number of multiplications needed to multiply the chain.
    Input: p[] = {40, 20, 30, 10, 30}
  Output: 26000
  There are 4 matrices of dimensions 40x20, 20x30, 30x10 and 10x30.
  Let the input 4 matrices be A, B, C and D.  The minimum number of
  multiplications are obtained by putting parenthesis in following way
  (A(BC))D --> 20*30*10 + 40*20*10 + 40*10*30
  */
    int findMatrixOperations(int[] p, int i, int j, int[][] dp){
        if (i==j) return 0;
        if (dp[i][j] > 0) return dp[i][j];
        dp[i][j] = Integer.MAX_VALUE;

        for (int k=i;k<j;k++){
            dp[i][k] = findMatrixOperations(p,i,k, dp);
            dp[k+1][j] = findMatrixOperations(p, k+1, j, dp);
            int count = dp[i][k] + dp[k+1][j] + p[i-1] * p[k] * p[j];
            if (dp[i][j] > count) dp[i][j] = count;

        }
        return dp[i][j];
    }

    public static void main(String[] a){
        MatrixChainMul obj  = new MatrixChainMul();
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        List<Integer> output = new ArrayList<>();
        for (int i=0;i<T;i++){
            int N = s.nextInt();
            int[] array = new int[N];
            for (int j=0;j<N;j++){
                array[j] = s.nextInt();
            }
            int[][] dp = new int[N][N];
            for (int m=0;m<N;m++){
                for (int n=0;n<N;n++){
                    if (m==0 || n==0) dp[m][n]=0;
                    else if (m==n) dp[m][n]=0;
                }
            }
            output.add(obj.findMatrixOperations(array, 1, N-1, dp));
        }

        for (int i=0;i<T;i++){
            System.out.println(output.get(i));
        }
    }
}
