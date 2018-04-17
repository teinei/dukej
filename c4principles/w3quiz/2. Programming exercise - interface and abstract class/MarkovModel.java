import java.util.*;
/**
 * Write a description of MarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MarkovModel extends AbstractMarkovModel {
    private int keyLength;
    
    /**
     * Takes integer specifying the number of characters to use to predict the next character.
     */
    public MarkovModel(int num) {
        keyLength = num;
        myRandom = new Random();
        order = num;
    }
    
    public void setTraining(String s){
        myText = s.trim();
    }
    
    /**
     * Predicts the next character by finding all the characters that follow a substring of keyLength
     * characters in the training text, and then randomly picking one of them as the next character.
     */
    public String getRandomText(int numChars){
        if (myText == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        // Generate a random index from valid indexes (those that have following characters)
        int index = myRandom.nextInt(myText.length() - keyLength);
        // Assign to key the character string at the random index that is keyLength long
        String key = myText.substring(index, index + keyLength);
        sb.append(key);
        // NOTE: Generate numChars minus four cuz they are set before the loop
        for(int k=0; k < numChars - keyLength; k++){
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
            // Combine old key (except first character) with successor to make next key
            key = key.substring(key.length() - (keyLength - 1)) + successor;
        }
        return sb.toString();
    }
}
