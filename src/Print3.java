/**
 * Created by arjun on 10/09/18.
 */
public class Print3 implements Runnable {

    Print obj;
    Thread t;

    Print3(Print obj){
        t = new Thread(this);
        this.obj = obj;
        t.start();
    }

    public void run() {
        try {
            while(true){
                obj.printThree();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
