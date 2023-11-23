import java.util.Scanner;
class Box{
    float h,w,d,area;  
    static int count;
    static float Area(float h,float w,float d){
        return h*w*d;
        
    }
    void Display(){
        System.out.println("Area is : "+Area(h, w, d));
        System.out.println("Count is "+count);
        System.out.println("------------------------------------------------");
    }
    Box(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter height : ");
        this.h=sc.nextFloat();
        System.out.print("Enter width : ");
        this.w=sc.nextFloat();
        System.out.print("Enter depth : ");
        this.d=sc.nextFloat();
        count++;
    }
}

public class Extra {
    public static void main(String[] args) {
        Box b1=new Box();
        b1.Display();
        Box b2=new Box();
        b2.Display();
    }
}
