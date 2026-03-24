import java.util.*;

public class GuessingGame {

    public static void main(String[] args)
    
    {
        startGame();
    }

    
        
    public static void startGame() 
    	{

        	Scanner s = new Scanner(System.in);

        	System.out.println("========================================");
        	System.out.println("      WELCOME TO THE GUESSING GAME      ");
        	System.out.println("========================================");
        	System.out.println();

        	System.out.print("Enter your Name: ");
        	String namee = s.nextLine();

        	char again;

        	do {

            displayWelcome(namee);

            int secretNumber = generateSecretNumber();

            int attemptsUsed = playGame(secretNumber, namee, s);

            displayStats(namee, secretNumber, attemptsUsed);

            again = askPlayAgain(namee, s);

        } while (again == 'Y' || again == 'y');
        
        

        System.out.println();
        System.out.println("========================================");
        System.out.println("Thanks for playing, " + namee + "!");
        System.out.println("========================================");
    		}




    		public static void displayWelcome(String name)
    		{
    			System.out.println();
    			System.out.println("Hello " + name + "!");
    			System.out.println("I'm thinking of a number between 1 and 100.");
    			System.out.println("You have 10 attempts to guess it.");
    			System.out.println("I'll give you a hint after each guess.");
    			System.out.println("\nLet's begin!");
    			System.out.println("========================================");
    		}


    		public static int generateSecretNumber() 
    		{
    			Random rand = new Random();
    			return rand.nextInt(100) + 1;
    		}



    		public static int getUserGuess(Scanner s) {

    			int guess;

    			while (true) 
    			{
    				System.out.print("Enter your guess (1-100): ");
    				guess = s.nextInt();

    				if (guess >= 1 && guess <= 100)
    				{
    					return guess;
    				} else 
    				{
    					System.out.println("Invalid! Please enter a number between 1 and 100.");
            }
        }
    }


          public static void giveHint(int guess, int secretNumber) {

             if (guess < secretNumber) {
                System.out.println("Too low! Try a higher number.");
            } else if (guess > secretNumber) {
               System.out.println("Too high! Try a lower number.");
        }
    }


         public static int playGame(int secretNumber, String namee, Scanner s) {

            int maxAttempts = 10;
             int attempt = 1;

             while (attempt <= maxAttempts) {

                 System.out.println("\n--- Attempt #" + attempt + " ---");

                  int guess = getUserGuess(s);

                 if (guess == secretNumber) {

                System.out.println();
                System.out.println("Congratulations " + namee + "!");
                System.out.println("You guessed the number " + secretNumber + " in " + attempt + " attempts!");
                return attempt;

            } else {
                giveHint(guess, secretNumber);
            }

            attempt++;
        }

        System.out.println();
        System.out.println("GAME OVER!");
        System.out.println("You've used all 10 attempts.");
        System.out.println("The secret number was " + secretNumber + ".");
        System.out.println("Better luck next time, " + namee + "!");

        return attempt;
    }


         public static void displayStats(String namee, int secretNumber, int attempts) {

            String rating;

             if (attempts == 1) {
                rating = "Perfect!";
             } else if (attempts <= 3) {
                 rating = "Excellent!";
            } else if (attempts <= 6) {
                  rating = "Good job!";
             } else if (attempts <= 10) {
                 rating = "Nice try!";
             } else {
                rating = "Better luck next time!";
        }

        System.out.println();
        System.out.println("========================================");
        System.out.println("            GAME STATISTICS             ");
        System.out.println("========================================");
        System.out.println("Player: " + namee);
        System.out.println("Secret Number: " + secretNumber);
        System.out.println("Attempts Used: " + attempts);
        System.out.println("Rating: " + rating);
        System.out.println("========================================");
    }


          public static char askPlayAgain(String namee, Scanner s) {

             System.out.print("\nWould you like to play again, " + namee + "? (Y/N): ");
              return s.next().charAt(0);
    }
}