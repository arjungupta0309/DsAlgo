/**
 * Created by arjun on 10/09/18.
 */
public class Print2 implements Runnable{
    Print obj;
    Thread t;

    Print2(Print obj){
        t = new Thread(this);
        this.obj = obj;
        t.start();
    }

    public void run() {
        try {
            while(true){
                obj.printTwo();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
