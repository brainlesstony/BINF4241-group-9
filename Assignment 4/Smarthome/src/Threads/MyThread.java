package Threads;

public class MyThread implements Runnable {
    private boolean running;
    private int time;

    public MyThread(int timeMiliseconds){
        time = timeMiliseconds;
        running = false;
    }

    public MyThread(){
        this(10000);
    }

    public boolean isRunning() {
        return running;
    }

    @Override
    public void run() {
        try{
            running = true;
            Thread.sleep(time);
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
