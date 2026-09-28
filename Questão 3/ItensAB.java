class Deposito{
    
    private int itens = 0;
    
    public void registrar(){
        itens++;
        System.out.println("Itens no deposito: " + itens);
    }
    
    public boolean retirar(){
        if(itens > 0){
            itens--;
            System.out.println("Itens no deposito: " + itens);
            return true;
        }else{
            System.out.println("Deposito vazio.");
            return false;
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
        
        int consumidos = 0;
        
        while(consumidos < 20){
            
            if(deposito.retirar()){
                consumidos++;
                
                try{
                    Thread.sleep(t);
                }catch(InterruptedException error){
                    System.out.println("Error");
                }
                
            }else{
                
                try{
                    Thread.sleep(200);
                }catch(InterruptedException error){
                    System.out.println("Error");
                }
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
