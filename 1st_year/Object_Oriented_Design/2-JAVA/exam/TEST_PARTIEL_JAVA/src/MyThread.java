public class MyThread extends Thread{

    //BOUCLAGE D'UN THREAD
    boolean condition = true;

    public MyThread(String newName){
        super(newName);
    }
    public void run(){
        //Thread TIMED_WAITING
        /*
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */

        //THREAD EN CONCURENCE
        /*
        for(int i=0;i<3;i++){
            System.out.println(this.getName());
        }
        */

        //BOUCLAGE D'UN THREAD
        int i=0;
        do{
            System.out.println(this.getName()+ " : Dans la boucle "+i);
            i++;
            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while(condition);
        System.out.println(this.getName()+ " : Sortie de la boucle");
    }

    //BOUCLAGE D'UN THREAD
    public void arret() {
        this.condition = false;
    }
}
