import java.util.Stack;

/**
 * Created by arjun on 22/03/19.
 */
public class SpecialStack {

    Stack<Integer> auxiliary = null;
    int capacity;
    Stack<Integer> specialStack = null;

    SpecialStack(int capacity){
        this.capacity = capacity;
        specialStack = new Stack<>();
        auxiliary = new Stack<>();
    }

    void push(Integer data){
        if (isFull(specialStack)) {
            return;
        }
        specialStack.push(data);

        if (isEmpty(auxiliary)){
            auxiliary.push(data);
        }else if (data < auxiliary.peek()){
            auxiliary.push(data);
        }
    }

    Integer pop(){
        if (isEmpty(specialStack)) {
            return null;
        }
        int data = specialStack.pop();
        if (data == auxiliary.peek()){
            auxiliary.pop();
        }

        return data;
    }

    Integer getMin(){
        if (isEmpty(auxiliary)){
            return null;
        }
        return auxiliary.peek();
    }

    boolean isEmpty(Stack<Integer> stack){
        if (stack.size()==0) return true;
        else return false;
    }

    boolean isFull(Stack<Integer> stack){
        if (stack.size()==capacity) return true;
        else return false;
    }

    public static void main(String[] ar){
        SpecialStack specialStack = new SpecialStack(5);
        specialStack.push(18);
        specialStack.push(19);
        specialStack.push(29);
        specialStack.push(15);
        specialStack.push(16);

        System.out.println("current min="+specialStack.getMin());
        System.out.println("pop = "+specialStack.pop());
        System.out.println("current min="+specialStack.getMin());
        System.out.println("pop = "+specialStack.pop());
        System.out.println("current min="+specialStack.getMin());

    }
}
