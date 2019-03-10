import java.util.*;

/**
 * Created by arjun on 10/03/19.
 */
public class Q102 {

    /*Given an array of N positive integers, print k largest elements from the array.  The output elements should be printed in decreasing order.*/
    Stack<Integer> kLargestElements(List<Integer> input, int k){
        Queue<Integer> queue = new PriorityQueue<>(k);
        int count=0;
        for (int i=0;i<input.size();i++){
            if (queue.size() < k)
                queue.add(input.get(i));
            else if (input.get(i) > queue.peek()){
                queue.poll();
                queue.add(input.get(i));
            }
        }

        Stack<Integer> s = new Stack<>();
        while (queue.size() > 0){
            s.push(queue.poll());
        }

        return s;
    }

    void display(List<Stack<Integer>> results) {
        for (int i=0;i<results.size();i++){
            Stack<Integer> s = results.get(i);
            while (!s.empty()){
                System.out.print(s.pop()+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] a){
        Q102 obj = new Q102();
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        List<Stack<Integer>> results = new ArrayList<>(T);
        for (int i=0;i<T;i++){
            int N = s.nextInt();
            int k = s.nextInt();
            List<Integer> input = new ArrayList<>(N);
            for (int j=0;j<N;j++){
                input.add(s.nextInt());
            }
            results.add(obj.kLargestElements(input, k));
        }
        obj.display(results);

    }
}
