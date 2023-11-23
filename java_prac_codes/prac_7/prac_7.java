import java.util.*;
import java.io.*;

class Product{
    private String product_name,manufacturer;
    private double cost,max_discount;
    public Product(String pn,String man,double cost , double max_dis){
        this.product_name=pn;
        this.manufacturer=man;
        this.cost=cost;
        this.max_discount=max_dis;
    }
    //getter setter start

    public String getProduct_name() {
        return product_name;
    }
    public double getCost() {
        return cost;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public double getMax_discount() {
        return max_discount;
    }
    //getter setter end

    public Product(){}
    public String toString(){
        System.out.println("\nProduct Name: "+product_name);
        System.out.println("Manufacturer  : "+manufacturer);
        System.out.println("Cost  : "+cost);
        System.out.print("Max_discount  : "+max_discount);
        return "";
    }
}
public class prac_7{
    public static void main(String[] args) throws IOException{
        ArrayList<Product> list1=new ArrayList<Product>(10);
        BufferedReader br= new BufferedReader(new FileReader("Hello.txt"));
        String str=br.readLine();
        while(str!=null){
            String str2[]=str.split(",");
            list1.add(new Product(str2[0], str2[1],Double.parseDouble(str2[2]),Double.parseDouble(str2[3])));
            str=br.readLine();
        }
        // Comparator<Product> cmp= (Product i,Product j)-> i.getCost()>j.getCost()?1:-1;
        Comparator<Product> cmp = new Comparator<Product>(){

            public int compare(Product i,Product j) {
                if(i.getCost()>j.getCost()){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        };
        int choice ;
        System.out.print("Enter condition : ");
        Scanner sc= new Scanner(System.in); 
        choice =sc.nextInt();
        switch (choice) {
            case 1:
                condition1(list1);
                break;
            case 2:
                condition2(list1);
                break;
            case 3:
                Collections.sort(list1,cmp);
                condition1(list1);
                break;
                case 4:
                    Collections.sort(list1,Comparator.comparing(Product::getManufacturer));
                    condition1(list1);
                break;

            default:
                System.out.println("Invalid Condition!!!!!");
                break;
        }
    }

    public static void condition1(ArrayList<Product> list1){
        
        Iterator<Product> itr = list1.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
    public static void condition2(ArrayList<Product> list1){
        int flag=0;
        for (Product product : list1) {
            if(product.getMax_discount()==50){
                flag=1;
                System.out.println(product);
                System.out.println("Price after discount : "+(product.getCost()-(product.getCost()*0.5)));
                System.out.println("+------------+---------+----------+------------+\n");
            }
        }       
        if(flag==0){
            System.out.println("No such product");
        }
    }
}


