import java.util.ArrayList;

import edu.duke.FileResource;

public class Tester {
	
	private String getText() {
		FileResource fr = new FileResource("data/confucius.txt");
		String st = fr.asString();
		st = st.replace('\n', ' ');
		return st;
	}
	@SuppressWarnings("unused")
	public void testGetFollows() {
		
		MarkovOne markov = new MarkovOne();
		System.out.printf("Markov model order: %d\n", 1);
		String st = "this is a test yes this is a test.";
		System.out.println(st);
		markov.setRandom(150);
		markov.setTraining(st);
		
		for (int i=0; i<st.length()-1; i++) {
			
			String key = st.substring(i, i+1);
			ArrayList<String> follows = markov.getFollows(key);
			System.out.printf("%s\t%s\n", key, follows);
			
		}
		
	}
	
	  public void q3q4testGetFollowsWithFile() {
		
		MarkovModel markov = new MarkovModel(2);
		
		String st = getText();
		
		System.out.println(st);
		markov.setRandom(150);
		markov.setTraining(st);
		int tcnt = markov.getFollows("o").size();
		//tcnt = markov.getFollows("he").size();
		System.out.println("Size: " + tcnt);

	}
}