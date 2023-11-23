import java.time.LocalDate;
import java.util.Scanner;
public class hello{
    public static void main(String[] args) {
        int y,m,d;
        LocalDate dob;
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Year :");
        y=sc.nextInt();
        System.out.println("Enter Month :");
        m=sc.nextInt();
        System.out.println("Enter Date :");
        d=sc.nextInt();
        dob=LocalDate.of(y, m, d);
        System.out.println("Your DOB is : "+dob);
        System.out.println(dob.isBefore(LocalDate.now()));

    }
}