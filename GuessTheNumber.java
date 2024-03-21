import java.util.Scanner;
import java.util.Random;

class GuessTheNumber{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int min = 1;
        int max = 100;
        int rounds = 0;
        int wins = 0;
        int max_attempts = 5;

        while(true){
            int attempts = 0;
            rounds ++;
            System.out.println("Round: "+rounds);
            int randomNum = random.nextInt(max)+min;

            System.out.println("guess a random number between 1 & 100:");

           while (attempts < max_attempts){
               int guess = scanner.nextInt();
               attempts ++;
               if(guess==randomNum){
                   System.out.println("you guessed it! the number is "+guess+", you win!!");
                   wins++;
                   System.out.println("attempts taken: "+attempts);

                   break;
               }
               else if(guess<randomNum){
                   System.out.println("too low, try again:");
               } else {
                   System.out.println("too high, try again:");
               }

               }
            if (attempts >= max_attempts) {
                System.out.println("Oops! you have no more lives!. The number was " + randomNum + ".");
            }

            System.out.println("wanna play again?(type 'yes' to continue):");
            String answer = scanner.next();
            System.out.println(" ");

            if (!answer.equalsIgnoreCase("yes")){
                break;
           }
        }
        System.out.println("rounds played: "+rounds);
        System.out.println("rounds won: "+wins);
    }
}
