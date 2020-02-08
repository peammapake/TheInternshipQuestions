/**
 * Class that contains method on looking through
 * the given number input and check if it is a prime
 * number or not
 */
public class FloatPrimer {

    /**
     * Static method for receiving the value as a string before
     * convert it into integer for further prime number check
     * @param input String input of the number to be check
     * @param length the size of the given input
     * @return
     */
    public static boolean primeFinder(String input, int length){
        boolean prime = false;
        String checker = null;
        String bareNumber = dotTerminator(input);
        /*If the input total length is below 4 characters long insert zero behind to avoid bug*/
        if((length -1) < 4){
            bareNumber += "000000";
        }
        for(int i = 2; i <= 4; i++){
            checker = bareNumber.replace(bareNumber.substring(i,bareNumber.length()),"");
            int n = Integer.parseInt(checker);
            if(isPrime(n)){
                prime = true;
                break;
            }
            else prime = false;
        }
        return prime;
    }

    /**
     * Static method to remove decimal place from the given input
     * @param input String input that needs to terminate dot from
     * @return bareNumber which is a string without dot
     */
    private static String dotTerminator(String input){
        String bareNumber;
        bareNumber = input.replace(".","");
        return bareNumber;
    }

    /**
     * Static method to check if the input is a prime number or not
     * @param n the integer input that needs checking
     * @return boolean result of the prime number check
     */
    private static boolean isPrime(int n){
        // Corner cases
        if (n == 1)
            return false;
        if (n <= 3)
            return true;

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }
}
