/**
 * Created by arjun on 10/09/18.
 */
public class Print {

    int flag = 1;

    public synchronized void printOne() throws InterruptedException{
        while(flag !=1){
            wait();
        }
        System.out.println(flag);
        flag++;
        notifyAll();
    }

    public synchronized void printThree() throws InterruptedException{
        while(flag !=3){
            wait();
        }
        System.out.println(flag);
        flag=1;
        notifyAll();
    }

    public synchronized void printTwo() throws InterruptedException{
        while(flag !=2){
            wait();
        }
        System.out.println(flag);
        flag++;
        notifyAll();
    }

    public static void main(String a[]){
        Print obj = new Print();
        new Print1(obj);
        new Print2(obj);
        new Print3(obj);
    }


}
