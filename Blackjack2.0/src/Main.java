import java.util.Scanner;
import java.util.*;

public class Main {
    public static int nextCard, card1, card2, dCard1, dCard2;
    public static int cardTotal = 0, dTotal = 0;
    public static Random random = new Random();
    public static Scanner keyboard = new Scanner(System.in);
    public static int i = 0;

    public static void main(String[] args) {
        getCards();
        while (i == 0) {
            System.out.println("Another card? (y/n): ");
            if ("y".equalsIgnoreCase(keyboard.nextLine())) {
                nextCard = random.nextInt(10) + 1;
                cardTotal += nextCard;
                System.out.println("You draw a " + nextCard);
                System.out.println("Your new total is " + cardTotal);
                if (cardTotal > 21) {
                    System.out.println("You bust, dealer wins");
                    playAgain();
                } else if (cardTotal == 21) {
                    System.out.println("Blackjack! You win!");
                    playAgain();
                }
            } else {
                System.out.println("Dealer total: " + dTotal);
                System.out.println("You have: " + cardTotal);
                if (cardTotal > dTotal) {
                    System.out.println("You win!");
                } else {System.out.println("You lose");}
                playAgain();
            }
        }
    }

    private static void getCards() {
        dCard1 = random.nextInt(10) + 1;
        dCard2 = random.nextInt(10) + 1;
        dTotal = dCard1 + dCard2;

        card1 = random.nextInt(10) + 1;
        card2 = random.nextInt(10) + 1;
        cardTotal = card1 + card2;

        System.out.println("Dealer shows: " + dCard1);
        System.out.println("First Cards: " + card1 + ", " + card2);
        System.out.println("Total: " + cardTotal);
    }

    private static void playAgain() {
        System.out.println("Would you like to play again? (y/n): ");
        if ("y".equalsIgnoreCase(keyboard.nextLine())) {
            getCards();
        } else {
            System.out.println("Thanks for playing!");
            i = 1;
        }
    }
}
