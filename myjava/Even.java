import java.util.Scanner;
class  IsEven{
    void isEven(int a){
        if (a%2==0){
            System.out.println("Even");
        }
        else{
            System.out.println("Odd");
        }
    }
}
public class Even {
    public static void main(String[] args) {
        int a,ch=1;
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("Enter number : ");
            a=sc.nextInt();
            IsEven a1= new IsEven();
            a1.isEven(a);
            System.out.println("Enter 1 to continue !");
            ch=sc.nextInt();
        }while(ch==1);
        sc.close();
       
    }
}


