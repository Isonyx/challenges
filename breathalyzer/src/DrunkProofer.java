import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Isonyx
 * @date 11/28/2012
 *
 * A class created for the Facebook Puzzle Breathalyzer Challenge
 * Takes advantage of the edit distance algorithm.
 */

public class DrunkProofer {
	private String myFile;
	
	public DrunkProofer(String drunkFile) {
		this.myFile = drunkFile;
	}
	
	public int minimumChanges() {
		File drunkenFile = new File(myFile);
		String[] drunkenText = new String[0];
		try {
			Scanner theInput = new Scanner(drunkenFile);
			String drunkPhrase = "";
			while (theInput.hasNextLine()) {
				drunkPhrase += (theInput.nextLine()).replaceAll("\\r\\n|\\r|\\n", " ");
			}
			drunkenText = drunkPhrase.split(" ");
			theInput.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return (drunkenText.length > 0 ?  findChanges(drunkenText) : -1);		
	}
	
	public int findChanges(String[] drunkenText)  {
		String nextWord = ""; 
		int finalCount = 0;
		Scanner theInput = null;
		for (String drunkenWord: drunkenText) {
			int wordCount = 0;
			int shortest = -1;
			try {
				File dictionaryList = new File("twl06.txt");
				 theInput = new Scanner(dictionaryList);
				 while (theInput.hasNext()) {
					 nextWord = theInput.next().toLowerCase();
					 if (shortest == 0) { break; }
					 if (editDistance(drunkenWord, nextWord) < shortest || shortest == -1) { 
						 shortest = editDistance(drunkenWord, nextWord);
					 }
				 }
				 wordCount =+ shortest;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}	
			finalCount += wordCount;
			theInput.close();
		}
		return finalCount;
	}
	
	public void changeFile(String newFile) {
		this.myFile = newFile;
	}
	
	private int editDistance(String s, String t){
	    int m = s.length();
	    int n = t.length();
	    int[][] d = new int[m + 1][n + 1];
	    for (int i = 0; i <= m; i++) { d[i][0] = i; }
	    for (int j = 0; j <= n; j++) { d[0][j] = j; }
	    for (int j = 1; j <= n; j++) {
	      for (int i = 1; i <= m; i++) {
	        if (s.charAt(i - 1) == t.charAt(j - 1)) { d[i][j] = d[i - 1][j - 1]; }
	        else { d[i][j] = minimum((d[i - 1][j] + 1),(d[i][j - 1] + 1),(d[i - 1][j - 1] + 1)); }
	      }
	    }
	    return (d[m][n]);
	}
	
	private int minimum(int a, int b, int c) {
	    return (Math.min(Math.min(a,  b), c));
	}
}
