import java.util.Calendar;

public class ThreadViderCommandeJour extends Thread{

    private boolean condition = true;
    private int jourReference;

    public ThreadViderCommandeJour(){
        Calendar calendar = Calendar.getInstance();
        jourReference=calendar.get(Calendar.DAY_OF_MONTH);
    }

    public void arret(){
        condition=false;
    }

    public void run(){
        do{
            try{
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //En réel
            Calendar calendar = Calendar.getInstance();
            int jour = calendar.get(Calendar.DAY_OF_MONTH);
            if(jour!=jourReference){
                jourReference=jour;
                System.out.println("Vider Commande");
            }

            //Pour le test
            Calendar calendar = Calendar.getInstance();
            int minute = calendar.get(Calendar.MINUTE);
            if(minute==54){
                System.out.print("Vider Commande");
            }
        }while(condition);
    }
}