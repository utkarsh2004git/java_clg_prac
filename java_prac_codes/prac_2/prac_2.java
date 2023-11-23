import java.util.Scanner;

class OnlineShoppingPortal{
    double amt,discount;
    String promocode;
    void checkout(double amt){
        this.amt=amt;
        if(amt>1000){
            discount= 0.3*amt;
        }
        else{
            discount= 0.2*amt;
        }
        amt-=discount;
        System.out.println("Total Amount : "+amt);
    }
    void checkout(double amt,String promo){
        this.amt=amt;
        this.promocode=promo;
        if(amt<500){
            discount= 10;
        }
        else if (amt>=500 && (promocode.equals("GET10"))){
            discount= 0.1*amt;
            
        }
        else{
            discount=10;
        }
        amt-=discount;
        System.out.println("Total Amount : "+amt);
    }
}
public class prac_2 {
    public static void main(String[] args){
        int choice;
        double amt;
        String promo;
        Scanner s1=new Scanner(System.in);
        Scanner s2=new Scanner(System.in);
        System.out.println("Enter 1 for prime customer\nEnter 2 for regular customer :");
        choice= s1.nextInt();
        if(choice==1){
            OnlineShoppingPortal prime = new OnlineShoppingPortal();
            System.out.print("Enter amount : ");
            amt= s1.nextInt();
            prime.checkout(amt);
        }
        else if(choice==2){
            OnlineShoppingPortal reg = new OnlineShoppingPortal();
            System.out.print("Enter amount : ");
            amt= s1.nextInt();
            System.out.print("Enter promocode : ");
            promo= s2.nextLine();
            reg.checkout(amt,promo);
        }
        else{
            System.out.println("Please select valid option .");
        }
        s1.close();
        s2.close();
    }
}







