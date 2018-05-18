import java.util.*;
public class Tester {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String theMessage = "";
		int theOption = 0;
		
		while (theMessage != "q") {
			System.out.print("[Options Menu]\n[1] Encrypt\n[2] Decrypt\n\n");
			System.out.print("Please choose an option (1-2). Enter # > 2 to quit.: ");
			theOption = input.nextInt();
			if (theOption < 1 || theOption > 2) { break; }
			theMessage = input.nextLine();
			System.out.print("Please choose a message to encrypt/decrypt: ");
			theMessage = input.nextLine();
			WERTYU theWERT = new WERTYU(theMessage);
			if (theOption == 1) {
				System.out.println("Cipher Text: " + theWERT.Encrypt());
			} else {
				System.out.println("Plain Text: " + theWERT.Decrypt());
			}	
		}
		
		input.close();
		System.out.println("Thanks for using this WERTYU app dog.");
	}
}
