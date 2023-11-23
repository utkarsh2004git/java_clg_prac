import java.util.Scanner;

class Time {
    int hours, minutes, day = 0;

    Time() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter hours : ");
        this.hours = sc.nextInt();
        System.out.println("Enter minutes : ");
        this.minutes = sc.nextInt();
    }

    Time(int x) {

    }

    public void add(Time t1, Time t2) {
        this.hours = t1.hours + t2.hours;
        this.minutes = t1.minutes + t2.minutes;
        if (this.hours >= 24) {
            this.hours -= 24;
            day++;
        }
        if (this.minutes >= 60) {
            this.minutes -= 60;
            this.hours += 1;
        }

    }

    public void subtract(Time t1, Time t2) {
        this.day = 0;
        this.hours = t1.hours - t2.hours;
        this.minutes = t1.minutes - t2.minutes;
        if (this.minutes < 0) {
            this.minutes = 60 + (this.minutes);
            this.hours -= 1;
        }
        if (this.hours < 0) {
            this.hours = -this.hours;
        }

    }

    public void display(Time t1, Time t2) {
        add(t1, t2);
        System.out.println("After Addition");
        System.out.printf("%d days %d hours %d minutes\n", day, hours, minutes);
        subtract(t1, t2);
        System.out.println("After Subtract");
        System.out.printf("%d days %d hours %d minutes", day, hours, minutes);
    }
}


public class prac_3a {
    public static void main(String[] args) {
        System.out.println("Enter for Time 1 : ");
        Time t1=new Time();
        System.out.println("Enter for Time 2 : ");
        Time t2=new Time();
        Time t3=new Time(0);
        t3.display(t1, t2);


    }
}