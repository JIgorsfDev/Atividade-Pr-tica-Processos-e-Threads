class ThreadRunnable implements Runnable {

    private String nome;

    ThreadRunnable(String nome) {
        this.nome = nome;
    }

    @Override
    public void run() {
        System.out.println("Rodando: " + nome);

        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + nome + ", " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException error) {
            System.out.println("Thread " + nome + " interrompida.");
        }

        System.out.println("Thread " + nome + " finalizada.");
    }
}

public class Main {

    public static void main(String[] args) {

        ThreadRunnable runnable = new ThreadRunnable("Runnable");
        Thread thread1 = new Thread(runnable);

        thread1.start();
    }
}
