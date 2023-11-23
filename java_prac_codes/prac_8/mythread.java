class Sharedata{
    boolean writable=false;
    int data;
    public synchronized void produce(int a){
        this.data=a;
        System.out.println("produced : "+data);
        if(writable==false){
            try {
                wait();
            } catch (Exception e) {
            }
        }
        writable=false;
        notify();
    }
    public synchronized int consume(){
        if(writable==true){
            try {
                wait();
            } catch (Exception e) {
            }
        }
        writable=true;
        notify();
        return data;
    }
}
class Producer extends Thread{
    Sharedata d;
    Producer(Sharedata d){
        this.d=d;
    }
   public void run(){
     for (int i=1;i<10;i++){
        d.produce(i);
    }
   }
}
class Consumer extends Thread{
    Sharedata d;
    Consumer(Sharedata d){
        this.d=d;
    }
   public void run(){
     for (int i=1;i<10;i++){
        System.out.println("Consumed data : "+d.consume());
    }
   }
}
public class mythread{
    public static void main(String[] args) {
        Sharedata d=new Sharedata();
        Producer p1= new Producer(d);
        Consumer c1= new Consumer(d);
        p1.start();
        c1.start();
    }
}