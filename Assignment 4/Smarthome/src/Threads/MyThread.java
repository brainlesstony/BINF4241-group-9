package Threads;

public class MyThread implements Runnable {
    private boolean running;
    private int time;

    public MyThread(int timeMiliseconds){
        time = timeMiliseconds;
        running = false;
    }

    public boolean isRunning() {
        return running;
    }

    @Override
    public void run() {
        try{
            running = true;
            Thread.sleep((time));
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
