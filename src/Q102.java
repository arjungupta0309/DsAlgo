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

    /*Pythagorean Triplet in an array
    Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2.*/
    boolean findPythagoreanTriplet(int[] a){
        for (int i=0;i<a.length-1;i++){
            for (int j=0;j<a.length-i-1;j++){
                if (a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1]=temp;
                }
            }
        }

        for (int i=0;i<a.length;i++){
            a[i] = a[i]*a[i];
        }
        for (int k=a.length-1;k>1;k--){
            int i=0,j=a.length-2;
            while (i<a.length-2 && j>0){
                int sum = a[i]+a[j];
                if (sum==a[k]) return true;
                else if (sum<a[k]) i++;
                else j--;
            }
        }


        return false;
    }

    /*convert BT into DLL*/
    /*
    Node convert(TreeNode root){
        if(root==null) return null;
        Node q = new Node(root.data);
        Node p = convert(root.left);

        if(p!= null){
            p.next = q;
            q.prev = p;

        }
        Node r = convert(root.right);
        if(r!= null){
            q.next = r;
            r.prev = q;
        }

        return (p != null) ? p : q;

    }

     */

    /*Given a binary tree (not a binary search tree) and two values say n1 and n2, write a program to find the least common ancestor.*/
    /*
    Node findLCA(Node root, int n1, int n2){
        if(root==null) return null;
          Node t = root;
          int a1[] = new int[100];
          int a2[] = new int[100];
          while(t !=null || )




    }


      */



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
        /*Scanner s = new Scanner(System.in);
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
        obj.display(results);*/
        int ar[] = {3,1,4,6,50};
        System.out.println("pythagorean triplet="+obj.findPythagoreanTriplet(ar));

    }
}
