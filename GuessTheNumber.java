import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Random;

class GuessTheNumber{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int min = 1;
        int max = 100;
        int attempts = 0;
        int rounds = 0;

        while(true){
            rounds ++;
            System.out.println("Round: "+rounds);
            int randomNum = random.nextInt(max);

            System.out.println("guess a random number between 1 & 100:");

           while (true){
               int guess = scanner.nextInt();
               attempts ++;
               if(guess==randomNum){
                   System.out.println("you guessed the correct number, you win!!");
                   System.out.println("attemps taken: "+attempts);
                   attempts=0;
                   break;
               }
               else if(guess<randomNum){
                   System.out.println("too low, try again:");
               } else {
                   System.out.println("too high, try again:");
               }

               }

            System.out.println("wanna play again?(yes/no):");
            String answer = scanner.next();

            if (!answer.equalsIgnoreCase("yes")){
                break;
           }
        }
        System.out.println("rounds played: "+rounds);
    }
}
