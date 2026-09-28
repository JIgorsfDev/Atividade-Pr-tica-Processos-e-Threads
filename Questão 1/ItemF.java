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

        for (int i = 1; i <= 10; i++) {
            RacerRunnable racer = new RacerRunnable(i);
            Thread thread = new Thread(racer);

            thread.setPriority(i);

            thread.start();
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Race race = new Race();
        race.iniciarCorrida();
    }
}
