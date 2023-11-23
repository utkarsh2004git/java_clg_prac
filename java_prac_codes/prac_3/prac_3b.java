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

class GreatClock extends Time {
    int s, ms;

    public GreatClock() {
        super();
        Scanner s1 = new Scanner(System.in);
        System.out.print("Enter  Seconds : ");
        this.s = s1.nextInt();
        System.out.print("Enter  Milliseconds : ");
        this.ms = s1.nextInt();
    }

    public GreatClock(int s, int ms) {
        super(0);
        this.s = 0;
        this.ms = 0;
    }

    public void add(GreatClock g1, GreatClock g2) {
        super.add(g1, g2);
        this.s = g1.s + g2.s;
        this.ms = g1.ms + g2.ms;
        if (this.ms > 1000) {
            this.s += 1;
            this.ms -= 1000;
        }
        if (this.s > 60) {
            this.minutes += 1;
            this.s -= 60;
        }
    }

    public void subtract(GreatClock g1, GreatClock g2) {
        super.subtract(g1, g2);
        this.s = g1.s - g2.s;
        this.ms = g1.ms - g2.ms;
        if (this.s < 0) {
            this.s = -this.s;
        }
        if (this.ms < 0) {
            this.ms = -this.ms;
        }
    }

    public void display(GreatClock g1, GreatClock g2) {
        add(g1, g2);
        System.out.println("\n\n\n\nAfter Addition");
        System.out.printf("%d days %d hours %d minutes %d seconds %d milliseconds\n", day, hours, minutes, s, ms);
        subtract(g1, g2);
        System.out.println("\n\nAfter Subtract");
        System.out.printf("%d days %d hours %d minutes %d seconds %d milliseconds\n\n", day, hours, minutes, s, ms);
    }
}

public class prac_3b {
    public static void main(String[] args) {
        System.out.println("Enter for Time 1 : ");
        GreatClock g1= new GreatClock();
        System.out.println("Enter for Time 2 : ");
        GreatClock g2= new GreatClock();
        GreatClock g3 = new GreatClock(0, 0);
        g3.display(g1, g2);
    }
}