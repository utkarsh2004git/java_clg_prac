import java.util.Scanner;
class Time {
    int hours, minutes, day = 0;
    Time() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter hours : ");
        this.hours = sc.nextInt();
        System.out.print("Enter minutes : ");
        this.minutes = sc.nextInt();
    }
    Time(int x) { }
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
    }
    public void display(Time t1, Time t2) {
        add(t1, t2);
        System.out.println("After Addition");
        System.out.printf("%d days %d hours %d minutes\n", day, hours, minutes);
        subtract(t1, t2);
        System.out.println("After Subtract");
        if(this.hours<0){
            System.out.println("Can not subtract time!");
        }
        else{
            System.out.printf("%d days %d hours %d minutes", day, hours, minutes);}
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
            this.ms -= 1000; }
        if (this.s > 60) {
            this.minutes += 1;
            this.s -= 60;}
    }
    public void subtract(GreatClock g1, GreatClock g2) {
        super.subtract(g1, g2);
        this.s = g1.s - g2.s;
        this.ms = g1.ms - g2.ms;
        if (this.s < 0) {
            this.s = -this.s;
        }

    }
    public void display(GreatClock g1, GreatClock g2) {
        add(g1, g2);
        System.out.println("\nAfter Addition");
        System.out.printf("%d days %d hours %d minutes %d seconds %d milliseconds\n", day, hours, minutes, s, ms);
        subtract(g1, g2);
        System.out.println("\nAfter Subtract");
                if (this.ms < 0) {
                  System.out.println("Cant subtract ");
        }
        else{System.out.printf("%d days %d hours %d minutes %d seconds %d milliseconds\n", day, hours, minutes, s, ms);}}
}
class TimeZone extends Time {
    public TimeZone() { }
    public TimeZone(int x) {
        super(0);}
    public void addz(TimeZone tz1, TimeZone tz2) {
        Time t1 = tz1;
        Time t2 = tz2;
        super.add(t1, t2);
        this.hours += 5;
        this.minutes += 30;
        if (this.minutes >= 60) {
            this.minutes -= 60;
            this.hours += 1;}
        if (this.hours >= 24) {
            this.hours -= 24;
            day++;}
        System.out.printf("%d days %d hours %d minutes ", this.day, this.hours, this.minutes);}
    public void subz(TimeZone tz1, TimeZone tz2) {
        Time t1 = tz1;
        Time t2 = tz2;
        super.subtract(t1, t2);
        this.hours -= 5;
        this.minutes -= 30;
        if (this.minutes < 0) {
            this.minutes = 60 + this.minutes;
            this.hours -= 1;
        }
        super.display(t1, t2);
    }}
public class prac_3c {
    public static void main(String[] args) {
        // //part a ---------------------------------
        // System.out.println("Enter for Time 1 : ");
        // Time t1=new Time();
        // System.out.println("Enter for Time 2 : ");
        // Time t2=new Time();
        // Time t3=new Time(0);
        // t3.display(t1, t2);
    //     //part b --------------------
        //  System.out.println("Enter for Time 1 : ");
        // GreatClock g1= new GreatClock();
        // System.out.println("Enter for Time 2 : ");
        // GreatClock g2= new GreatClock();
        // GreatClock g3 = new GreatClock(0, 0);
        // g3.display(g1, g2);
    //  //part c -----------------------
        TimeZone tz1 = new TimeZone();
        TimeZone tz2 = new TimeZone();
        TimeZone tz3 = new TimeZone(0);
        TimeZone tzsub = new TimeZone(0);
        System.out.println("After add : ");
        tz3.addz(tz1, tz2);
        System.out.println("\n\nAfter SUb : ");
        tz3.subz(tz1, tz2);
    }
}

