import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        // Object Instantiation
        Random rnd = new Random(); // Random generator
        Scanner in = new Scanner(System.in); // Scanner

        // Variable Declaration and Initialization

        int die1 = 0;
        int die2 = 0;
        int crapsRoll = 0;
        int point = 0;
        String playAgain = "";
        String keepLooping = "";

        // Play game
        do
        {
            // get random dice roll
            die1 = rnd.nextInt(6) + 1;
            die2 = rnd.nextInt(6) + 1;
            crapsRoll = die1 + die2;

            // print results of dice roll
            System.out.println("Die 1: " + die1);
            System.out.println("Die 2: " + die2);
            System.out.println("Your Roll: " + crapsRoll + "\n");

            if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) // crapped out
            {
                System.out.println("You crapped out.");
            }
            else if (crapsRoll == 7 || crapsRoll == 11) // rolled a natural
            {
                System.out.println("You won with a natural.");
            }
            else // rolled something else
            {
                point = crapsRoll;
                System.out.println(crapsRoll + " is the point\n");

                // start rolling for point
                do
                {
                    System.out.println("Trying for point");
                    keepLooping = in.nextLine(); // pause after each dice roll till user presses enter

                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    crapsRoll = die1 + die2;


                    if (crapsRoll == point)
                    {
                        System.out.println("Made point and won.\n");
                    }
                    else if (crapsRoll == 7)
                    {
                        System.out.println("Got a 7 and lost.\n");
                    }

                }
                while (crapsRoll != point && crapsRoll != 7);
            }
            // Ask if player wants to play again
            do
            {
                System.out.println("Would you like to play again(Y/N)?");
                playAgain = in.nextLine();
            }
            while (playAgain.equalsIgnoreCase("Y") == false && playAgain.equalsIgnoreCase("N") == false);
        }
        while (playAgain.equalsIgnoreCase("Y"));

    }
}