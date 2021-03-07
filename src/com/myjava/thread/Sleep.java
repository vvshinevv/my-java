package com.myjava.thread;

public class Sleep extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("somebody stopped me T T");
        }
    }

    public static void main(String[] args) {
        Sleep sleep = new Sleep();
        sleep.start();

        try {
            int cnt = 0;
            while(cnt < 5) {
                sleep.join(1000);
                cnt++;
                System.out.format("%d second waited\n", cnt);
            }

            if (sleep.isAlive()) {
                sleep.interrupt();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
