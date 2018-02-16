import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String hexNum = "";
        System.out.print("Enter a hexadecimal number: " + hexNum);
        hexNum = scnr.next();
        hexNum = hexNum.toUpperCase();
        // removes 0X from input if first two characters
        // hexNum(input).substring(part of input)(0-position inclusive , 2-exclusive so 2-1)
        // if position 0-1 equals 0x , delete
       if(hexNum.substring(0 , 2).equals("0X") ) {
           hexNum = hexNum.substring(2);
           // input is now devoid of 0X
       }


        int numLength;
       //amount of characters in input
        int index = 0;
        //position of the character starting at 0 going from left to right 0,1,2,3,4....
        long answer = 0;
        //+2billion so long needed over double for max output
        numLength = hexNum.length();

        while(index < numLength) {
            //index will always be one less than number length
            char char1 = hexNum.charAt(index);
            /* char is made so this variable can be evaluated as either a letter or number,
             * char1 is the character at the index in question */
            long numOne;
            // numOne is the first multiplier for any given index number
            if (Character.isLetter(char1)) {
                //if the character at index position is a letter this commences
                numOne = (char1 - 65) + 10;
                /* because the input was changed to uppercase, char A-F have corresponding decimal
                   values 65-70
                 * ex. if char1 is E (stored in memory as 69), 69-65=4+10=14 (the corresponding
                   hexidecimal value
                 * 10 is added because the hexidecimal range for letters A-E is 10-14*/
            }
            else {
                /* if the character is a number then the multiplier will be the given character
                   -48
                 * characters 0-9 are stored in memory as 48-57
                 * for a value of 3 entered as char1, the ASCII value will be used to determine
                 * the distance the char is from the min char 0 (ASCII value 48)
                 * ex. char1 = 3 (51) ---> 51-48 = 3 so char1 = 3 and not 51 */
                numOne = (char1 - 48);
            }

            double power = numLength - index - 1;
            /* numOne is multiplied by base 16 to a power corresponding with it's character position
             * the right-most character is multiplied by 16^0 and the power increases by one
             *  as the characters proceed to the left */
            /* becasue numLenth starts counting at one and index starts counting at zero, the
               character at position zero (to the far left) reduced by it's index value and one more
             * ex. if user inputs 6 characters numLength = 6, evaluating the first digit (index = 0)
               is 6-0= 6, 6-1=5
             * the first number has 16 raised to the highest power
             */

            //int firstSet = (int) (numOne * Math.pow(16, power));
            long firstSet = (long)(numOne * Math.pow(16, power));
            answer = answer + firstSet;

            //firstSet is the group of number being multiplied at one character position
            //of a hexidecimal input
            //answer is the sum of all the positions after operations are performed
            //answer primarily zero
            index++;
            //index variable is increased by one before while loop commences again
            //the next time the while loop commences it will evaluate the character in the 1 position
            //if for the second time
        }

        System.out.print("Your number is " + answer + " in decimal");
        System.out.print("This is the change to my code");








        


    }
}
