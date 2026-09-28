class ThreadExt extends Thread {

    ThreadExt(String nome) {
        super(nome);
    }

    @Override
    public void run() {
        System.out.println("Rodando: " + getName());

        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + getName() + ", " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException error) {
            System.out.println("Thread " + getName() + " interrompida.");
        }

        System.out.println("Thread " + getName() + " finalizada.");
    }
}


public class Main {

    public static void main(String[] args) {
        ThreadExt thread1 = new ThreadExt("Thread");

        thread1.start();
    }
}
