import java.util.*;
import edu.duke.*;
/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tester {
    public void testGetFollows() {
        // MarkovOne markov = new MarkovOne();
        MarkovFour markov = new MarkovFour();
        markov.setTraining("this is a test yes this is a test.");
        ArrayList<String> follows = markov.getFollows(" is ");
        System.out.println(follows);
    }
    
    public void q3testGetFollowsWithFile() {
        // Create a MarkovOne object
        MarkovOne markov = new MarkovOne();
        // Set training text to user-chosen file
        FileResource fr = new FileResource("data/confucius.txt");
        String frStr = fr.asString().replace('\n', ' ');
        markov.setTraining(frStr);
        // Call getFollows
        ArrayList<String> follows = markov.getFollows("o");
        System.out.println(follows.size());
    }
}
