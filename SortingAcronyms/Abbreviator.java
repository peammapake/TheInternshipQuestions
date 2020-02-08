public class Abbreviator {

    /** String that held the acronym of the word after the abbreviation*/
    public String acronym = "";

    /**
     * Constructor that turn the input string into an acronym
     * @param nameInput String input that user wants to turn into an acronym
     */
    public Abbreviator(String nameInput) {
        boolean isUpper = false;
        String[] words = nameInput.split(" ");
        char firstLetter;
        for (int i = 0; i < words.length; i++) {
            firstLetter = words[i].charAt(0);
            if(Character.isUpperCase(firstLetter)){
                acronym += firstLetter;
            }
        }
    }

    /**
     * Method to return the processed acronym back to the caller
     * @return Return string of an acronym
     */
    public String getAcronym(){
        return acronym;
    }
}
