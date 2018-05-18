/**
 * @author Isonyx
 * @date 11/28/2012
 *
 * A class created for the Facebook Puzzle Breathalyzer Challenge
 */

public class Main {
	public static void main(String[] args) {
		DrunkProofer drunk = new DrunkProofer("sentence.txt");
		
		long start = System.nanoTime();
		
		int minimumChanges = drunk.minimumChanges();
		
		long end = System.nanoTime();
		
		double seconds = (double)(end - start) / 1000000000.0;
		System.out.println("Elapsed Time: " + seconds);
		System.out.println("Changes: " + minimumChanges);
	}
}