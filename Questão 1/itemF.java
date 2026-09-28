class RacerRunnable implements Runnable {

    private int i;

    RacerRunnable(int i) {
        this.i = i;
    }

    @Override
    public void run() {
    while (true) {
        System.out.println("Racer " + i + " - imprimindo");

        try {
            Thread.sleep(50);
        } catch (InterruptedException error) {
            System.out.println("Thread interrompida.");
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
        System.out.println("Racer " + i + " - imprimindo");

        try {
            Thread.sleep(50);
        } catch (InterruptedException error) {
            System.out.println("Thread interrompida.");
        }
    }
}

class Race {

    public void iniciarCorrida() {

        Thread[] im = new Thread[5];
        Thread[] par = new Thread[5];

        for (int i = 1; i <= 9; i += 2) {
            RacerRunnable racer = new RacerRunnable(i);
            im[i / 2] = new Thread(racer);
            im[i / 2].start();
        }

        for (Thread thread : im) {
            try {
                thread.join();
            } catch (InterruptedException error) {
                System.out.println("Corrida interrompida.");
            }
        }

        for (int i = 2; i <= 10; i += 2) {
            RacerRunnable racer = new RacerRunnable(i);
            par[i / 2 - 1] = new Thread(racer);
            par[i / 2 - 1].start();
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Race race = new Race();
        race.iniciarCorrida();
    }
}
