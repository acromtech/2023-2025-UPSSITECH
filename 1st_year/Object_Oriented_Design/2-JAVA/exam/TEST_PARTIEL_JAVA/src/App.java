public class App {
    public static void main(String[] args) throws Exception {

        //Thread TERMINATED
        /*
        Thread myThread = new Thread("MyTread");                                            //Instancie un nouveau thread
        myThread.start();                                                                        //Lance le thread
        for(int i=0;i<2;i++){
            System.out.println(myThread.getName()+" : "+myThread.getState());                    //Affiche l'état du thread
        }
        */


        //Thread TIMED_WAITING
        /*
        MyThread myThread = new MyThread("MyTread");                                            //Instancie un nouveau thread
        myThread.start();                                                                               //Lance le thread
        System.out.println(myThread.getName()+" : "+myThread.getState()); 
        */


        //THREAD PRINCIPAL = LE MAIN
        /*
        System.out.println(Thread.currentThread().getName()+" : "+Thread.currentThread().getState());   //Informe sur l'état du Thread pincipal (le main)
        */


        //THREAD EN CONCURENCE
        /*
        MyThread myThread = new MyThread("MyTread");                                            //Instancie un nouveau thread
        myThread.start(); 
        for(int i=0;i<3;i++){
            System.out.println(Thread.currentThread().getName());
        }
        */


        //BOUCLAGE D'UN THREAD AVEC UN TEMPS
        MyThread myThread = new MyThread("MyTread");                                            //Instancie un nouveau thread
        myThread.start(); 
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThread.arret();
        

    }
}
