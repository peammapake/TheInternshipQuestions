/**
 * A simple Hangman game where user must define 12 places of number
 * value between 0 - 9 then the user will have five chances to answer
 * it correctly
 *
 * By Bhimapaka Thapanangkun
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean bOk = false;
        int answer = -1;
        Hanger inHanger = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Digit Hangman. Please enter twelve number answer: ");
        checkLoop: while (!bOk){
            String input = sc.nextLine();
            String[] splitString = input.split("\\s+");

            if (splitString.length != 12) {
                System.out.println("Bad input: Need to contain twelve numbers\n");
                continue;
            }
            int[] hangNumber = new int[splitString.length];
            for(int i = 0; i < splitString.length; i++){
                try{
                    hangNumber[i] = Integer.parseInt(splitString[i]);
                }
                catch (NumberFormatException nfe){
                    System.out.println("Bad input: Contain non-numeric value\n");
                    continue checkLoop;
                }
                if(hangNumber[i] < 0 || hangNumber[i] > 9){
                    System.out.println("Bad input: Number must be between 0 - 9\n");
                    continue checkLoop;
                }
            }
            bOk = true;
            inHanger = new Hanger(hangNumber);
        }
        System.out.println("Please provide your answer: ");
        for(int i = 0; i < 5; i++){
            bOk = false;
            while(!bOk) {
                try {
                    answer = sc.nextInt();
                } catch (InputMismatchException e) {
                    answer = -1;
                    System.out.println("Bad input: Must be numeric\n");
                    sc.nextLine();
                    continue;
                }
                bOk = true;
            }
            inHanger.checkAnswer(answer);
        }
        System.out.println("Game ended");
        System.out.println("Your score: " + inHanger.getScore());
    }
}
