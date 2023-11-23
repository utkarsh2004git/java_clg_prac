import java.util.Random;
import java.util.Scanner;
class Game{
    private int num,a, count=0;

    public Game(){
        Random r=new Random();
        a = r.nextInt(50);
        System.out.println(a);
    }
    public void takeUserInput(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number : ");
        num=sc.nextInt();
    }
    int isCorrectNumber(){
        if(num>a){
            System.out.println("Enter small number : ");
            return 0;
        }
        else if(num<a){
            System.out.println("Enter large number");
            return 0;
        }
        else{
            System.out.println("Correct !!!");
            return 1;
        }       
    }
    void setnoOfGuesses(int ct){
        count = ct;
        count+=1;
    }
    int getnoOfGuesses(){
        return count;
    }
}

public class Gamez {
    public static void main(String[] args) {
        Game g1=new Game();
        while(true){
            g1.takeUserInput();
            if(g1.isCorrectNumber()==1){
                break;
            }
            g1.setnoOfGuesses(g1.getnoOfGuesses());
        }
        System.out.println("No of guesses : "+ g1.getnoOfGuesses());
    }
}
