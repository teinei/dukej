import java.util.*;
/**
 * Uses four characters to predict the next character.
 * 
 * @author Brienna Herold
 * @version Jan. 7, 2017
 */
public class MarkovFour extends AbstractMarkovModel {
    public MarkovFour() {
        myRandom = new Random();
        order = 4;
    }
    
    public void setTraining(String s){
        myText = s.trim();
    }
    
    /**
     * Predicts the next character by finding all the characters that follow a substring of 4
     * characters in the training text, and then randomly picking one of them as the next character.
     */
    public String getRandomText(int numChars){
        if (myText == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        // Generate a random index from valid indexes, which are all those indexes that have 
        // following characters. The fourth to last index has no following character due to the key 
        // being 4 characters in length, therefore myText.length() - 4 is used
        int index = myRandom.nextInt(myText.length() - 4);
        // Assign to key the four-character string at the random index
        String key = myText.substring(index, index + 4);
        sb.append(key);
        // NOTE: Generate numChars minus four cuz they are set before the loop
        for(int k=0; k < numChars - 4; k++){
            // Find all characters that follow the current 4-character string
            ArrayList<String> follows = getFollows(key);
            // Break if no characters were found
            if (follows.size() == 0) {
                break;
            }
            // Randomly pick one of them as the successor
            index = myRandom.nextInt(follows.size());
            String successor = follows.get(index);
            sb.append(successor);
            // Use the last 3 characters of the old key plus the successor as the next key
            key = key.substring(key.length() - 3) + successor;
        }
        return sb.toString();
    }
}
