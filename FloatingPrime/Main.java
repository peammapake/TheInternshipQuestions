/**
 * A simple program that continually ask user for
 * a number value between 1.0 - 10.0 and say whether that
 * value is prime number or not by disregarding the decimal
 * and look only on the first to forth place of the given number
 *
 * By Bhimapaka Thapanangkun
 */
public class Main {

    /**
     * Main method first asks the user to
     * give the input and check whether it is
     * a bad input or not. Then it will tell if the number
     * is prime or not
     */
    public static void main(String[] args) {
        boolean bOk = true;
        String stringInput = "";
        int length = 0;
        while(bOk){
            stringInput = IOUtil.getString("Enter your number: ");
            try {
                float f = Float.parseFloat(stringInput);
            } catch (NumberFormatException nfe) {
                System.out.println("Bad number input: Not a correct numerical form\n");
                continue;
            }
            if(stringInput.matches("0.0")){
                bOk = false;
            }
            else if((Float.parseFloat(stringInput) < 1) || (Float.parseFloat(stringInput) > 10)){
                System.out.println("Bad number input: Must be between 1 to 10");
            }
            else if(stringInput.length() > 12){
                System.out.println("Bad number input: Overall input length cannot be over 12 characters long\n");
            }
            else{
                //float floatInput = Float.parseFloat(stringInput);
                length = stringInput.length();
                if(!FloatPrimer.primeFinder(stringInput,length)){
                    System.out.println("FALSE\n");
                }
                else System.out.println("TRUE\n");
            }
        }
        System.out.println("Program terminated");
        System.exit(0);
    }
}
