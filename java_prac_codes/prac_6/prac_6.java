import java.util.*;
class Generic_class<T extends Number >{
    T[] arr;
    public Generic_class(T[] arr){
        this.arr = arr;
    }
    double addArray(){
        double sum=0;
        for(T i:arr){
            sum+=i.doubleValue();
        }
        return sum;
    }
}
class UnmatchedSum extends Exception{
    UnmatchedSum(String msg){
        super(msg);
    }
}
class test{
    boolean isEqual(Generic_class t1,Generic_class t2)throws UnmatchedSum{
        if(t1.addArray()==t2.addArray()){
            System.out.println("Sum is same!!");
            return true;
        }
        throw new UnmatchedSum("Sum is Different");
    }
}
public class prac_6 {
    public static void main(String[] args) {
        try{
            Double ar1[]={4.0,6.0,3.0,4.0,5.0};
            Double ar2[]={4.0,6.0,3.0,5.0};

            Generic_class<Double> ob1 = new Generic_class<>(ar1);
            Generic_class<Double> ob2 = new Generic_class<>(ar2);
            System.out.println( "Sum of 1st array : "+ob1.addArray());
            System.out.println( "Sum of 2nd array : "+ob2.addArray());
            test t1= new test();
            t1.isEqual(ob1, ob2);
        }
        catch(UnmatchedSum e){
           System.out.println(e);
        }
    }
    
}
