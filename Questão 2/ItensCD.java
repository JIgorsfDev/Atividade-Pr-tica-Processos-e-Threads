class Deposito{
    
    private int itens = 0;
    
    public void registrar(){
        itens++;
        System.out.println("Itens no deposito: " + itens);
    }
    
    public void retirar(){
        if(itens > 0){
            itens--;
            System.out.println("Itens no deposito: " + itens);
        }else{
            System.out.println("Deposito vazio.");
        }
    }
}

class Produtor implements Runnable{
    
    private Deposito deposito;
    private int t; //p medir tempo
    
    Produtor(Deposito deposito, int t){
        this.deposito = deposito;
        this.t = t;
    }
    
    @Override
    public void run(){
        for(int i = 0; i < 100; i++){
            deposito.registrar();
            
            try{
                Thread.sleep(t);
            }catch(InterruptedException error){
                System.out.println("Erro.");
            }
        }
        System.out.println("Sucesso!");
    }
}

class Consumidor implements Runnable{
    private Deposito deposito;
    private int t;

    public Consumidor(Deposito deposito, int t) {
        this.deposito = deposito;
        this.t = t;
    }
    
    @Override
    public void run(){
    for(int i = 0; i < 20; i++){
        deposito.retirar();
    
    try{
        Thread.sleep(t);
    }catch(InterruptedException error){
        System.out.println("Error");
    }
   }
    System.out.println("Sucesso");
   }
}

public class Main {

    public static void main(String[] args) {

        Deposito deposito = new Deposito();

        Thread p = new Thread(new Produtor(deposito, 100));
        Thread c = new Thread(new Consumidor(deposito, 200));

        p.start();
        c.start();
    }
}
