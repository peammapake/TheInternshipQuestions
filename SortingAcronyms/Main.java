/**
 * By Bhimapaka Thapanangkun
 * Simple program to make acronym out of the first letter of each word
 * depending on its capitalization. The program then sort the output by
 * its acronym length then alphabetical order
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Main {

    /**
     * Main method first ask user for the number of input then continue
     * on receiving words that user wants to turn into an acronym
     */
    public static void main(String[] args) {

        String input;
        int nameCount = 0;
        ArrayList<String> acronymList = new ArrayList<String>();
        nameCount = IOUtil.getInteger("Please declare the number of input: ");
        for(int i = 0; i<nameCount; i++) {
            input = IOUtil.getString("Input " + (i+1) + ": ");
            Abbreviator latestAcronym = new Abbreviator(input);
            acronymList.add(latestAcronym.getAcronym());
        }
        Collections.sort(acronymList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()>o2.length()){
                    return 1;
                }
                else if(o1.length()<o2.length()){
                    return 0;
                }
                else{
                    String s1 = String.valueOf(o1.charAt(0));
                    String s2 = String.valueOf(o2.charAt(0));
                    return s1.compareTo(s2);
                }
            }
        });
        System.out.println("Output: ");
        for(String counter: acronymList){
            System.out.println(counter);
        }
    }
}
