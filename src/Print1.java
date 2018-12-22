/**
 * Created by arjun on 10/09/18.
 */
public class Print1 implements Runnable {

    Print obj;
    Thread t;

    Print1(Print obj){
        t = new Thread(this);
        this.obj = obj;
        t.start();
    }

    public void run() {
        try {
            while(true){
                obj.printOne();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}
