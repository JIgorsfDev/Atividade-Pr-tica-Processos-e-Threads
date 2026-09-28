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

        RacerRunnable r1 = new RacerRunnable(1);
        Thread thread1 = new Thread(r1);

        RacerExt thread2 = new RacerExt(2);

        thread1.start();
        thread2.start();
    }
}

public class Main {

    public static void main(String[] args) {

        Race race = new Race();
        race.iniciarCorrida();
    }
}
