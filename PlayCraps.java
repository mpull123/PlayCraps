/******************************
   Mallory Pulliam
   Mini Project #2 - PlayCraps
 ******************************/

 import java.util.Scanner;

 public class PlayCraps {
 
     public static void main(String[] args) {
         playCrapsGame();
     }
 
     private static void playCrapsGame() {
         Scanner scanner = new Scanner(System.in);
         char playAgain;
 
         do {
             System.out.println("Let's play Craps!");
 
             int point = rollDice();
 
             if (point == 7 || point == 11) {
                 System.out.println("Congratulations! You rolled " + point + ". You win!");
             } else if (point == 2 || point == 3 || point == 12) {
                 System.out.println("Sorry, you rolled " + point + ". You lose!");
             } else {
                 System.out.println("Your point is " + point + ". Keep rolling...");
 
                 int result = continueRolling(point, scanner);
 
                 if (result == 1) {
                     System.out.println("Congratulations! You rolled your point. You win!");
                 } else {
                     System.out.println("Sorry, you rolled a 7. You lose!");
                 }
             }
 
             System.out.print("Do you want to play again? (y/n): ");
             playAgain = scanner.next().charAt(0);
 
         } while (playAgain == 'y' || playAgain == 'Y');
 
         System.out.println("Thanks for playing Craps! Come Again!");
     }
 
     private static int rollDice() {
         System.out.print("Press enter to roll the dice...");
         waitForEnter();
 
         int die1 = (int) (Math.random() * 6) + 1;
         int die2 = (int) (Math.random() * 6) + 1;
         int sum = die1 + die2;
 
         System.out.println("You rolled " + die1 + " + " + die2 + " = " + sum);
 
         return sum;
     }
 
     private static int continueRolling(int point, Scanner scanner) {
         int result;
         do {
             System.out.print("Press enter to roll the dice again...");
             waitForEnter();
 
             result = rollDice();
 
             if (result == point) {
                 return 1; // User wins
             } else if (result == 7) {
                 return 0; // User loses
             }
         } while (true);
     }
 
     private static void waitForEnter() {
         Scanner scanner = new Scanner(System.in);
         scanner.nextLine(); // Wait for the player to press enter
     }
 }
 

