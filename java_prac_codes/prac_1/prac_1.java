import java.util.Scanner;

class Complex{
    Scanner sc= new Scanner(System.in);
    double real,img,sumI,sumR;
    double mult_r=0,mult_i=0;
    Complex(){
        System.out.print("Real Part : ");
        real=sc.nextDouble();
        System.out.print("img part : ");
        img=sc.nextDouble();  
    }
    public void add(Complex a , Complex b){
        this.sumR=a.real+b.real;
        this.sumI=a.img+b.img;
        
    }
    public void mul(Complex a,Complex b){
        this.mult_r= (a.real*b.real)-(a.img*b.img);
        this.mult_i= (a.real*b.img + b.real*a.img);
        
    }
    Complex(double real,double img){   
    }
}
public class prac_1 {
    public static void main(String[] args) {
        System.out.println("Enter for number 1 ");
        Complex a1=new Complex();
        System.out.println("Enter for number 2 ");
        Complex a2=new Complex();
        if(a1.real>100000 || a1.real<-100000 || a1.img>100000 || a1.img<-100000
            || a2.real>100000 || a2.real<-100000 || a2.img>100000 || a2.img<-100000){
                System.out.println("Invalid Input");
            }
        else{
            Complex a3= new Complex(0,0);
            a3.add(a1, a2);
            System.out.println("The sum of complex number : "+a3.sumR+" + "+a3.sumI+"i");
            a3.mul(a1, a2);
            System.out.print("multiplication is : "+a3.mult_r+" + "+a3.mult_i+"i");
        }
    }
}




