/**
 * Created by arjun on 31/03/19.
 */
/*https://www.geeksforgeeks.org/assembly-line-scheduling-dp-34/*/
/* it is done for 2 lines only*/
public class Assembly {
    static int carAssembly(int[][] a, int[][] t, int[] e, int[] x ){
        int N = a[0].length;
        int[] s1 = new int[N];
        int[] s2 = new int[N];


        for (int i=0;i<N;i++){
            if (i==0) {
                s1[i] = e[0] + a[0][i];
                s2[i] = e[1] + a[1][i];
            }
            else {
                s1[i] = min(s1[i-1]+a[0][i], s2[i-1]+t[1][i]+a[0][i]);
                s2[i] = min(s2[i-1]+a[1][i], s1[i-1]+t[0][i]+a[1][i]);
            }
        }
        s1[N-1] += x[0];
        s2[N-1] += x[1];
        return min(s1[N-1],s2[N-1]);
    }

    static int min(int a,int b){
        return a<b? a : b;
    }

    public static void main (String[] args)
    {
        int a[][] = {{4, 5, 3, 2},
                {2, 10, 1, 4}};
        int t[][] = {{0, 7, 4, 5},
                {0, 9, 2, 8}};
        int e[] = {10, 12}, x[] = {18, 7};

        System.out.println(carAssembly(a, t, e, x));

    }
}
