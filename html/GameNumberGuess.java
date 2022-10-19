import java.util.Scanner;
import java.io.*;
class Game extends  Thread{
    String name;
    byte noOfDigits,displayInSe ;
    int number,displayedNumber;
    BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
    public  void run() {
        char c='y';
        int count=0;
        try{
                System.out.print("Enter player name: ");
                name = reader.readLine();
                System.out.print("Enter number of digits: ");
                noOfDigits = Byte.parseByte(reader.readLine());
                while(noOfDigits<=0||noOfDigits>=11){
                     System.out.print("Incompatible digit size Re-Enter: ");
                     noOfDigits=Byte.parseByte(reader.readLine());
                }
                System.out.print("Enter waiting time in seconds: ");
                displayInSe = Byte.parseByte(reader.readLine());
            }catch(Exception e){
                System.out.println("You entered something wrong. Try again");
                run();
            }
        do{
            try {
                displayedNumber=(int)(Math.random() *Math.pow(10,noOfDigits));
                System.out.println("The number is:"+displayedNumber);
                Thread.sleep(displayInSe * 1000);
                clrscr();
                System.out.println("\t\t\t"+name.toUpperCase());
                System.out.print("Enter The shown Number: ");
                number = Integer.parseInt(reader.readLine());
                if(number==displayedNumber){
                    System.out.print(name.toUpperCase()+" You guessed it right.\n");
                    count++;
                    if(count==3){
                        noOfDigits++;
                        count=0;
                    }
                }
                else{
                 System.out.println(name.toUpperCase()+" You guessed The number wrong. The number was=>\n "+displayedNumber);
                 count=0;

             }
                System.out.print("\t\t\tWanna play Again press \"y\"...:");
                c=reader.readLine().charAt(0);
                clrscr();
            
            }catch (Exception e){
            System.out.println("something went wrong.. Try again");
            }
        }while(c=='y'||c=='Y');

    }
    public static void clrscr(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
            System.out.println("OOps something went wrong..");
        }
    }
}
   

public class GameNumberGuess {

    public static void main(String[] args) {
        Game game=new Game();
        game.start();
    }
}
