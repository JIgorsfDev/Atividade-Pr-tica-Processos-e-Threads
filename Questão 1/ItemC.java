class RacerRunnable implements Runnable {

    private int i;

    RacerRunnable(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Racer " + i + " - imprimindo");
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
        }
    }
}

class Race {

    public void iniciarCorrida() {

        for (int i = 1; i <= 10; i++) {
            RacerRunnable racer = new RacerRunnable(i);
            Thread thread = new Thread(racer);
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
