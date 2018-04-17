import java.util.*;
/**
 * Write a description of MarkovOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MarkovOne extends AbstractMarkovModel {	
	public MarkovOne() {
		myRandom = new Random();
		order = 1;
	}
	
	public void setTraining(String s){
		myText = s.trim();
	}
	
	/**
	 * Predicts the next character, by finding all the characters that follow the current 
	 * character in the training text, and then randomly picking one of them as the next character.
	 */
	public String getRandomText(int numChars){
		if (myText == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		// Generate a random index from valid indexes, which are all those indexes that have 
		// following characters. The last index has no following character, therefore
		// myText.length() - 1 is used
		int index = myRandom.nextInt(myText.length() - 1);
		// Assign to key the one-character string at the random index
		String key = myText.substring(index, index + 1);
		sb.append(key);
		// NOTE: Generate numChars minus one cuz that one is set before the loop
		for(int k=0; k < numChars - 1; k++){
		    // Find all characters that follow the current character
		    ArrayList<String> follows = getFollows(key);
		    // Break if no characters were found
		    if (follows.size() == 0) {
		        break;
		    }
		    // Randomly pick one of them as the successor
		    index = myRandom.nextInt(follows.size());
		    String successor = follows.get(index);
			sb.append(successor);
			// Update key to successor 
			key = successor;
		}
		return sb.toString();
	}
}
