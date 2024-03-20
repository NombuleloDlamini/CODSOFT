import java.util.*;
import java.io.*;
//import java.Random;

public class GuessTheNumber
{
   public static void main(String[] args)
   {
      Scanner scanner = new Scanner(System.in);
      Random random = new Random();
      int min = 1;
      int max = 100;
      int round = 0;
      int attempt = 0;
      
      while(true)
      {
         round++;
         System.out.println("Round: "+round);
         int random_number = random.nextInt(max);
         System.out.println("Guess a random number between "+min+" and "+max);
         
         while(true)
         {
         int guess = scanner.nextInt();
         attempt++;
         if(guess == random_number){
            break;
                     }
         else if(guess < random_number){
         System.out.println("too low, try again:");
         }
         else {
         System.out.println("too high, try again:");
         }
         }
         
         System.out.println("Yaay, you guessed correct!!");
         System.out.println("attempts: "+attempt);
         System.out.println("wanna play again?");
         String ans = scanner.next();
         
         if(!ans.equalsIgnoreCase("yes")){
         break;
         } 
      }
   }
}