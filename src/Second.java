import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by arjun on 08/09/18.
 */
/*There is a street by the name of colorful street in the Pretty Town. The residents of the house have decided that they will paint their houses in either Pink, Orange or Yellow color and not other. They have also decided that no two adjacent houses will have the same color. For house i,  and  are the neighbors and note that the first and the last house are not neighbors.

        The cost of painting a house in a particular color is different. The cost of painting the first house in color yellow maybe different than what its for painting the second house in the same color.

        You have to find the minimum of cost of painting the houses which satisfy the given condition.

        Input Constraints - Number of houses will contain between 1 and  elements, inclusive. - Each line of input for houses will have three values for cost of coloring in each color. Each value will be between 1 and .

        Input Format - The first line will contain the number of test cases - T. - The second line will contain an integer N that will specify how many houses are there. - Each of the following N lines will contain 3 numbers separated by space that represents the cost of painting that house in either pink, orange or yellow color.

        Output Format Print T lines showing the cost of painting the houses for each test case.

        SAMPLE INPUT
        1
        2
        11 12 13
        14 15 16*/
public class Second {

    static int calculate(List<List<Integer>> list, int index, int exclude, int nc, List<List<Integer>> lookup){
        if (index >= list.size()) return 0;

        int c[] = new int[nc];

        for (int i=0;i<nc;i++){
            if (i==exclude) continue;

            List<Integer> l = null;
            if (lookup.isEmpty()){
                l = new ArrayList<>();
                lookup.add(index, l);
            }

            l=lookup.get(index);

            if (l.isEmpty() || l.get(i) == null){
                c[i] = list.get(index).get(i) + calculate(list, (index+1), i, nc, lookup);
                l.add(i, c[i]);
            }
            else {
                c[i] = l.get(i);
            }
        }

        int min = 0;
        for (int i=0;i<c.length;i++){
            if (c[i] ==0) continue;
            if (min==0) min=c[i];
            else if (min > c[i]) min = c[i];

        }

        return min;

    }

    public static void main(String a[]){

        Scanner s = new Scanner(new InputStreamReader(System.in));
        int t = s.nextInt();
        Map<Integer, List<List<Integer>>> map = new HashMap<>(t);

        for (int i=0;i<t;i++){
            int N = s.nextInt();
            List<List<Integer>> list = new ArrayList<>(N);
            for (int j=0;j<N;j++){
                List<Integer> c = new ArrayList<>(3);
                c.add(s.nextInt());
                c.add(s.nextInt());
                c.add(s.nextInt());
                list.add(c);
            }
            map.put(i, list);
        }

        for (int i=0;i<t;i++){
            List<List<Integer>> lookup = new ArrayList<>();
            System.out.println(calculate(map.get(i), 0, -1, 3, lookup));
        }
    }


}
