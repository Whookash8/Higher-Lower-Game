package HigherLower;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Łukasz on 2017-06-11.
 */
public class HigherLowerGame {
    private static Random random;
    private int number;
    private int tries;
    private Scanner load;

    public static void main(String[] args) {
        HigherLowerGame.begin();
    }

    private HigherLowerGame(){
        random = new Random();
        load = new Scanner(System.in);
        number = random.nextInt(100);
        tries = 0;
    }

    public static void begin(){

        HigherLowerGame newGame = new HigherLowerGame();

        newGame.printStartMessage();

        int guess = newGame.load.nextInt();

        while(!newGame.guess(guess)){
            guess = newGame.load.nextInt();
        }

        newGame.printEndingMessage();
    }

    private void printStartMessage(){
        System.out.println("--------------------------------------------");
        System.out.println("-- Guess the number that I'm thinking of. --");
        System.out.println("------------ Number of tries: 0 ------------");
        System.out.println("--------------------------------------------");
        System.out.println("------------ Insert your guess: ------------");
    }

    private void printEndingMessage(){
        System.out.println("--------------------------------------------");
        System.out.println("---- Congratulations!!! Correct number. ----");
        System.out.println("------------ Number of tries: " + tries + " ------------");
        System.out.println("----- Do you want to play again? (y/n) -----");
        String select = load.next();
        if(select.equals("y")){
            HigherLowerGame.begin();
        }
        else{
            return;
        }
    }

    public boolean guess(int numberGuessed){
        tries++;
        if(numberGuessed == number){
            return true;
        }
        else {
            printGuessMessage(numberGuessed);
            return false;
        }
    }

    private void printGuessMessage(int givenNumber){
        System.out.println("--------------------------------------------");
        if(givenNumber > number){
            System.out.println("--- Given number is too high, try again. ---");
        }
        else{
            System.out.println("--- Given number is too low, try again. ----");
        }


        System.out.println("------------ Number of tries: " + tries + " ------------");
        System.out.println("--------------------------------------------");
    }
}
