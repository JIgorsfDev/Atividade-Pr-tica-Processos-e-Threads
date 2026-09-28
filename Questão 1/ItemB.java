class RacerRunnable implements Runnable {

    private int i;

    RacerRunnable(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Corredor " + i + " - imprimindo");

            try {
                Thread.sleep(50);
            } catch (InterruptedException error) {
                System.out.println("Thread interrompida.");
            }
        }
    }
}

class RacerExt extends Thread {

    private int i;

    RacerExt(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Corredor " + i + " - imprimindo");

            try {
                Thread.sleep(50);
            } catch (InterruptedException error) {
                System.out.println("Thread interrompida.");
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {

        RacerRunnable r1 = new RacerRunnable(1);
        Thread thread1 = new Thread(r1);

        RacerExt thread2 = new RacerExt(2);

        thread1.start();
        thread2.start();
    }
}

