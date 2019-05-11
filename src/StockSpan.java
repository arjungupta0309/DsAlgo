import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by arjun on 23/03/19.
 */
public class StockSpan {

    /*Q1. The Stock Span Problem
    The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate span of stock’s price for all n days.
    The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
    For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}*/
    List<Integer> findSpan(int[] arr){
        List<Integer> list = new ArrayList<>(arr.length);
        Stack<Integer> s = new Stack<>();
        s.push(0);
        list.add(1);
        for (int i=1;i<arr.length;i++){
            while (!s.isEmpty()){
                if (arr[i] < arr[s.peek()]){
                    list.add(i-s.peek());
                    s.push(i);
                    break;
                }
                else {
                    s.pop();
                }
            }

            if (s.isEmpty()){
                list.add(i+1);
                s.push(i);
            }
        }


        return list;
    }

    /*Q2. Next Greater Element
    Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element on the right side of x in array. Elements for which no greater element exist, consider next greater element as -1.

    Examples:
    a) For any array, rightmost element always has next greater element as -1.
    b) For an array which is sorted in decreasing order, all elements have next greater element as -1.
    c) For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.

        Element       NGE
        4      -->   5
        5      -->   25
        2      -->   25
        25     -->   -1

    it will also be done by using a stack*/





    public static void main(String[] a){
        StockSpan obj = new StockSpan();
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        List<List<Integer>> output = new ArrayList<>(T);
        //List<Integer> output = new ArrayList<>();
        for (int i=0;i<T;i++){
            int N = s.nextInt();
            int[] array = new int[N];
            for (int j=0;j<N;j++){
                array[j] = s.nextInt();
            }
            output.add(obj.findSpan(array));
            //output.add(obj.findMaxSum(array));
        }

        for (int i=0;i<T;i++){
            System.out.println(output.get(i));
        }

    }
}
