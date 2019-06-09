import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by arjun on 03/05/19.
 */

/*  Q1. Given pair list like this [{2,3},{3,2},{1,1}, {2,5},{5,2}] and k=5 find 2 pair such that
pair1_left + pair2_left == pair1_right + pair1_left == k             */
public class PairCheck {

    void findPair(Pair[] pairs, int k){
        for (int i=0;i<pairs.length;i++){
            if (pairs[i].sum==k){
                for (int j=0;j<pairs.length; j++){
                    if (j==i) continue;
                    if (pairs[i].r == pairs[j].l && !(pairs[i].visited && pairs[j].visited)){
                        pairs[i].visited = true;
                        pairs[j].visited = true;
                        System.out.println(pairs[i]+","+pairs[j]);
                    }
                }
            }
        }
    }

    /* Q2. given a string of braces { and }, you need to remove minimum number of parenthesis from the string such that it contains balanced
    parenthesis. E,g, {{{}{}{}}}. in this we can remove the last 2 to make it balanced parenthesis.
   * */
    void balancedParenthesis(String input){
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<input.length();i++){
            char c = input.charAt(i);
            if (stack.isEmpty())
                stack.push(c);
            else {
                char x = stack.peek();
                if (c==x)
                    stack.push(c);
                else if (!(x=='{' || x=='}'))
                    throw new IllegalArgumentException("character is invalid in String");
                else
                    stack.pop();
            }
        }

        System.out.println("minimum number of parenthesis to be removed to make string balanced="+stack.size());
    }

    public static void main(String[] a){
        PairCheck obj = new PairCheck();
        Pair[] pairs = new Pair[5];
        pairs[0] = new Pair(2,3);
        pairs[1] = new Pair(3,2);
        pairs[2] = new Pair(1,1);
        pairs[3] = new Pair(2,5);
        pairs[4] = new Pair(5,2);

        obj.findPair(pairs, 5);
        obj.balancedParenthesis("{}{}{}{{");
        obj.balancedParenthesis("{{{{}{}}}{}");

    }

    static class Pair{
        int l;
        int r;
        int sum;
        boolean visited;

        Pair(int l, int r){
            this.l = l;
            this.r = r;
            this.sum=this.l+this.r;
            this.visited = false;
        }

        @Override
        public String toString() {
            return "Pair{" + l + "," + r + "}";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (l != pair.l) return false;
            return r == pair.r;
        }

        @Override
        public int hashCode() {
            int result = l;
            result = 31 * result + r;
            return result;
        }
    }





}
