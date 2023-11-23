import java.util.Scanner;
abstract class BankAccount{
    Scanner sc=new Scanner(System.in);
    static int count1=0,count2=0;
    int acc_no;
    long aadhar_no;
    String owner_n;
    double roi,bal;
    abstract void openAccount();
    abstract void deposit();
    abstract void closeAccount();
    abstract void updateInterest();
    void printDetails(){
        System.out.println("============================");
        System.out.println("Account No. : "+this.acc_no);
        System.out.println("Name : "+this.owner_n);
        System.out.println("Aadhar : "+this.aadhar_no);
        System.out.println("ROI : "+this.roi);
        System.out.println("Balance : "+this.bal);
        System.out.println("============================");
    }
}
interface Debitable{
    void withdraw();
}

class SavingAccount extends BankAccount implements Debitable{
    public void openAccount(){
        System.out.print("Enter your name : ");
        this.owner_n=sc.nextLine();
        System.out.print("Enter aadhar number : ");
        this.aadhar_no=sc.nextLong();
        this.bal=0;
        this.roi=4.0;
        this.acc_no=55000+count1;
        BankAccount.count1++;
    }
    public void deposit(){
        System.out.print("Enter the amount you want to deposit : ");
        double amt=sc.nextDouble();
        this.bal+=amt;
        System.out.printf("%.2f credited succesfully.\nTotal balance : %.2f\n",amt,this.bal);
    }
    public void withdraw(){
        System.out.print("Enter amount you want to withdraw : ");
        double amt1=sc.nextDouble();
        if(this.bal-amt1<0){
            System.out.println("Insufficient balance !!");
        }
        else{
            this.bal-=amt1;
            System.out.printf("Amount withdrawed succesfully..\nTotal balance remaining : %.2f\n",this.bal);
        }
    }
    public void closeAccount(){
        System.out.println("Account closed");
        
    }
    public void updateInterest(){
        this.bal+=(this.bal*1*this.roi)/100;
        System.out.println("balance after adding interest : "+this.bal);
    }
}
class FixedDepositAccount extends BankAccount{
    float lockInPeriod;

    public void openAccount(){
        System.out.print("Enter your Name : ");
        this.owner_n=sc.nextLine();
        System.out.print("Enter your aadhar number : ");
        this.aadhar_no=sc.nextLong();
        System.out.print("Enter Total balance : ");
        this.bal=sc.nextDouble();
        this.acc_no=11000+count2;
        BankAccount.count2++;
    }
   public void updateInterest(){
        System.out.print("Enter LockinPeriod (in Years) : ");
        this.lockInPeriod=sc.nextInt();
        if(this.lockInPeriod<=0){
            this.roi=0;
        }
        else if(1<=this.lockInPeriod && this.lockInPeriod<=2){
            this.roi=6.0;
        }
        else if(2<this.lockInPeriod && this.lockInPeriod<=5){
            this.roi=6.5;
        }
        else{
            this.roi=7;
        }
    }
   public void  closeAccount(){
        String choice;
        System.out.print("Is your lockinPeriod completed ?(y/n) : ");
        choice=sc.next();
        if(choice.equalsIgnoreCase("Y")){
            System.out.println("Account closure : After Lockin period");
            this.bal=this.bal+(this.bal*this.roi)/100;
        }
        else if(choice.equalsIgnoreCase("N")){
            System.out.println("Account closure : Before Lockin period");
            System.out.println("Penalty is "+this.bal*0.05);
            this.bal-=(this.bal*0.05);
        }
        System.out.println("Amount refunded : "+this.bal);
    }
    public void deposit(){
        System.out.println("Can not deposit ");
    }
}
public class prac_5{
    public static void main(String[] args) {
        SavingAccount s1=new SavingAccount();
        s1.openAccount();
        s1.deposit ();
        s1.updateInterest();
        s1.withdraw();
        s1.printDetails();
        s1.closeAccount();
        SavingAccount s2=new SavingAccount();
        s2.openAccount();
        s2.deposit ();
        s2.updateInterest();
        s2.withdraw();
        s2.printDetails();
        s2.closeAccount();
        FixedDepositAccount f1=new FixedDepositAccount();
        f1.openAccount();
        f1.updateInterest();
        f1.closeAccount();
        f1.printDetails();
        FixedDepositAccount f2=new FixedDepositAccount();
        f2.openAccount();
        f2.updateInterest();
        f2.closeAccount();
        f2.printDetails();
    }
}

