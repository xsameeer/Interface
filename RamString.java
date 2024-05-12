/*************
 *Class name: RamString
 *Class Description: This class implements the WackyStringInterface and holds the method definitions.
 --------------------------------------------------------------------------------------------
 *Name: Sameer Ali
 *Version date: 02/13/2024
 *CMSC 256 901
 ***************/
package cmsc256;
public class RamString implements WackyStringInterface {

    private String wackyString;

    //Default constructor for RamString
    public RamString() {
        wackyString = "CS@VCU!";
    }

    //Constructs a new RamString object with the specified string.
    public RamString(String str1) {
        // Check if the provided string is null
        if (str1 == null) {
            throw new IllegalArgumentException("No null strings");
        }
        // Assign the provided string to the wackyString field of the RamString object
        this.wackyString = str1;
    }

    /**
     * @return wackyString
     */
    public String getWackyString() {
        return wackyString;
    }

    /**
     * @param str1 The value to be set
     */
    public void setWackyString(String str1) {
        // Check if the provided string is null
        if (str1 == null) {
            throw new IllegalArgumentException();
        }
        this.wackyString = str1;
    }

    /**
     * Retrieves every fourth character from the wackyString.
     * @return A string containing every fourth character from the wackyString.
     */
    public String getEveryFourthCharacter() {
        // Initialize an empty string to store the characters
        String str = "";
        // Iterate over the characters of the wackyString, starting from the fourth character (index 3)
        for (int i = 3; i < wackyString.length(); i += 4) {
            str += String.valueOf(wackyString.charAt(i));
        }
        return str;
    }

    /**
     * Retrieves characters from even or odd positions in the wackyString, based on the length of the string.
     * @return A string containing characters from even or odd positions in the wackyString.
     */
    public String getEvenOrOddCharacters(String evenOrOdd) {
        // Check if the position parameter is valid
        if (!evenOrOdd.equals("odd") && !evenOrOdd.equals("even")) {
            throw new IllegalArgumentException("Position parameter must be either 'odd' or 'even'");
        }

        String str = "";
        // Check the starting position based on whether we're extracting odd or even positions
        int startPos = evenOrOdd.equals("odd") ? 1 : 2;

        // Iterate over the characters of the wackyString
        for (int i = startPos - 1; i < wackyString.length(); i += 2) {
            str += wackyString.charAt(i);
        }
        return str;
    }

    /**
     * Counts the number of digits in the wackyString.
     * @return The number of digits found in the wackyString.
     */
    public int countDigits() {
        int count = 0;
        // Iterate over each character in the wackyString
        for (int i = 0; i < wackyString.length(); i++) {
            // Check if the character at the current index is a digit
            if (Character.isDigit(wackyString.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    /**
     * Checks if the wackyString represents a valid VCU email address.
     * @return true if the wackyString is a valid VCU email address, false otherwise.
     */
    public boolean isValidVCUEmail() {
        // Find the index of the '@vcu.edu' substring
        int index = wackyString.indexOf("@vcu.edu");
        // Check if the '@vcu.edu' substring is found
        if (index != -1) {
            // Extract the substring before '@vcu.edu'
            String str = wackyString.substring(0, index);
            /* Check if the wackyString ends with '@vcu.edu' and if the substring before '@vcu.edu'
            has a length greater than or equal to 1 */
            if (wackyString.endsWith("@vcu.edu") && str.length() >= 1) {
                // If both conditions are met, the wackyString represents a valid VCU email address
                return true;
            }
        }
        return false;
    }

    /**
     * Standardizes the wackyString as a phone number.
     * @return A standardized phone number string in the format (XXX) XXX-XXXX.
     * @throws IllegalArgumentException if the wackyString is not a valid phone number.
     */
    public String standardizePhoneNumber() {
        String number = "";
        // Iterate over each character in the wackyString
        for (int i = 0; i < wackyString.length(); i++) {
            char character = wackyString.charAt(i);
            // Check if the character is a digit
            if (Character.isDigit(character)) {
                number += character;
            }
        }
        // Check if the resulting string length is 10 digits
        if (number.length() != 10) {
            throw new IllegalArgumentException("This WackyString is not a phone number.");
        }
        return "(" + number.substring(0, 3) + ") " + number.substring(3, 6) + "-" + number.substring(6, 10);
    }


    /**
     * Replaces occurrences of single zero (0) with "Go Rams" and double zero (00) with "CS@VCU"
     * in the wackyString, while ensuring that "CS@VCUGo Rams" is replaced with "000".
     */
    public void ramifyString() {
        // Replace occurrences of "00" with "CS@VCU"
        wackyString = wackyString.replace("00", "CS@VCU");
        // Replace occurrences of "0" with "Go Rams"
        wackyString = wackyString.replace("0", "Go Rams");
        // Replace occurrences of "CS@VCUGo Rams" with "000"
        wackyString = wackyString.replace("CS@VCUGo Rams", "000");
    }

    /**
     * Replaces a substring of the current string
     * with the corresponding Roman numeral symbols.
     * The first character in the string is considered to be in Position 1.
     */
    public void convertDigitsToRomanNumeralsInSubstring(int startPosition,
                                                        int endPosition)
            throws IllegalArgumentException, IndexOutOfBoundsException {
        // Check if the specified positions are valid
        if (startPosition < 1 && endPosition > wackyString.length()) {
            // If not, throw an IndexOutOfBoundsException
            throw new IndexOutOfBoundsException();
        }
        // Check if startPosition is greater than endPosition and they are within valid range
        if (startPosition > endPosition && (startPosition > 1 && endPosition < wackyString.length())) {
            // If so, throw an IllegalArgumentException
            throw new IllegalArgumentException();
        }
        // Convert the wackyString to a character array
        char[] wackyArray = wackyString.toCharArray();
        // Iterate over the specified substring
        for (int i = startPosition - 1; i < endPosition; i++) {
            // Get the character at the current position
            char number = wackyArray[i];
            // Check if the character is a digit and not '0'
            if (number != '0' && Character.isDigit(number)) {
                // Replace the digit with its corresponding Roman numeral using a switch case
                switch (number) {
                    case '1':
                        wackyString = wackyString.replace("1", "I");
                        break;
                    case '2':
                        wackyString = wackyString.replace("2", "II");
                        break;
                    case '3':
                        wackyString = wackyString.replace("3", "III");
                        break;
                    case '4':
                        wackyString = wackyString.replace("4", "IV");
                        break;
                    case '5':
                        wackyString = wackyString.replace("5", "V");
                        break;
                    case '6':
                        wackyString = wackyString.replace("6", "VI");
                        break;
                    case '7':
                        wackyString = wackyString.replace("7", "VII");
                        break;
                    case '8':
                        wackyString = wackyString.replace("8", "VIII");
                        break;
                    case '9':
                        wackyString = wackyString.replace("9", "IX");
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
