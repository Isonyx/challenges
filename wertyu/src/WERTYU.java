/**
 * @author Isonyx
 * @date 4/22/2012
 *
 * A class create to take advantage of the WERTYU algorithm. 
 * The algorithm is a simple substitution algorithm that takes
 * a cipher of keyboard characters and shifts the character one position to the left.
 */
public class WERTYU {
	private final char[] ALPHA = {'`', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '=', 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', '[', ']', '\\', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', ';', '\'', 'Z', 'X', 'C', 'V', 'B', 'N', 'M', ',', '.', '/'};
	private String myMessage;
	private String myPlainText;
	private String myCipherText;
	
	/**
	 * Constructor
	 * @param myMessage
	 * Creates the class.
	 * Assigns values to myMessage, myPlaintext, and myCipherText
	 */
	public WERTYU(String myMessage) {
		this.myMessage = myMessage.toUpperCase();
		myPlainText = "";
		myCipherText = "";
	}
	
	/**
	 * A public method to return a string encrypted with WERTYU.
	 * @return myPlaintext
	 */
	public String Encrypt() {
		for (int i = 0; i < myMessage.length(); i++) {
			if (myMessage.charAt(i) <= 32) {
				myPlainText += " ";
			} else {
				if ((findIndex(ALPHA, myMessage.charAt(i)) + 1) < 0) {
					myPlainText += ALPHA[(findIndex(ALPHA, myMessage.charAt(i)) + 1) + 47];
				} else if ((findIndex(ALPHA, myMessage.charAt(i)) + 1) > 46) {
					myPlainText += ALPHA[(findIndex(ALPHA, myMessage.charAt(i)) + 1) - 47];
				} else {
					myPlainText += ALPHA[(findIndex(ALPHA, myMessage.charAt(i)) + 1)];
				}
			}
		}
		return myPlainText;
	}
	
	/**
	 * A public method used to return a string decrypted from WERTYU.
	 * @return myCipherText
	 */
	public String Decrypt() {
		for (int i = 0; i < myMessage.length(); i++) {
			if (myMessage.charAt(i) <= 32) {
				myCipherText += " ";
			} else {
				if ((findIndex(ALPHA, myMessage.charAt(i)) - 1) < 0) {
					myCipherText += ALPHA[(findIndex(ALPHA, myMessage.charAt(i)) - 1) + 47];
				} else if ((findIndex(ALPHA, myMessage.charAt(i)) - 1) > 46) {
					myCipherText += ALPHA[(findIndex(ALPHA, myMessage.charAt(i)) - 1) - 47];
				} else {
					myCipherText += ALPHA[(findIndex(ALPHA, myMessage.charAt(i)) - 1)];
				}
			}
		}
		return myCipherText;
	}
	
	/**
	 * An internal method for searching an array of characters and returning
	 * the index of the specified character.
	 * @param theArray
	 * @param theChar
	 * @return -1 if not found or index of the character if found
	 */
	private int findIndex(char[] theArray, char theChar) {
		for (int x = 0; x < theArray.length; x++) {
			if (theChar == (theArray[x])) { return x; }
		}
		return -1;
	}
}
