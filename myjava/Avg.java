class Employee{
    double sal;
    Employee(double sal){
        this.sal=sal;
    }
    Employee(Employee e1,Employee e2){
        this.sal=(e1.sal+e2.sal)/2;
        System.out.println("Avg Sal : "+sal);
    }
}


public class Avg {
    public static void main(String[] args) {
        Employee e1 = new Employee(1000);
        Employee e2 = new Employee(2000);
        Employee e3 = new Employee(e1,e2);

    }
}
