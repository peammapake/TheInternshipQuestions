import java.util.ArrayList;
import java.util.Arrays;

/**
 * Hanger class is responsible in dealing with the calculation of Hangman game
 * through given answer and print return value respective to the user score
 * By Bhimapaka Thapanangkun
 */
public class Hanger {
    /** The list of the number that user guest correctly*/
    private static String[] answerTable = {"_","_","_","_","_","_","_","_","_","_","_","_"};
    /** Contains the list of the 12 places solution to the game*/
    private static int[] hangSet;
    /** List of the answer that user's guest wrongly*/
    private static ArrayList<Integer> wrongList = new ArrayList<Integer>();
    /** The static score that count throughout the game*/
    public static int score = 0;

    /**
     * Constructor responsible for storing the input number
     * from the user
     * @param hangNumber integer array of the solution to the hangman game
     */
    public Hanger(int[] hangNumber){
        hangSet = hangNumber;
    }

    /**
     * Method to check the value that user insert with the
     * integer array of hangman's solution
     * @param answer User's answer to the question
     */
    public void checkAnswer(int answer){
        boolean correct = false;
        /*Loop through twelve solution places to find any matching number*/
        for(int i = 0; i < 12; i++){
            if(hangSet[i] == answer){
                answerTable[i] = String.valueOf(answer);
                correct = true;
                score++;
            }
        }
        if(!correct){
            wrongList.add(answer);
        }
        System.out.println(Arrays.toString(answerTable) + " " + wrongList);
    }

    /**
     * Method to return the game's score back to the caller
     * @return static score that was collect through the whole game
     */
    public int getScore(){
        return score;
    }
}
