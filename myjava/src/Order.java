import java.util.Scanner;
public class Order{
    public static void main(String[] args) {
        Product a1= new Product();
        a1.getdata();
        a1.calculategts();
        a1.display();

    }
}
class Product{
    int prod;
    float cost,gst;
    void getdata(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter product id : ");
        prod=sc.nextInt();
        System.out.println("Enter cost : ");
        cost=sc.nextFloat();
        sc.close();
    }
    void calculategts(){
        gst=cost*0.1f;
    }
    void display(){
        System.out.printf("total gst %.3f ",gst);
    }
}
