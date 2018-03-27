

import edu.duke.*;

public class MarkovRunner {
    public void q1runMarkovZero() {
		FileResource fr = new FileResource("data/confucius.txt");
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovZero markov = new MarkovZero();
		markov.setRandom(1024);
		markov.setTraining(st);
		for (int k = 0; k < 3; k++) {
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}
	
	public void q5runMarkovOne() {
		FileResource fr = new FileResource("data/romeo.txt");
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovOne markov = new MarkovOne();
		markov.setRandom(365);
		markov.setTraining(st);
		for (int k = 0; k < 3; k++) {
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}
	
	public void q6runMarkovFour() {
		FileResource fr = new FileResource("data/romeo.txt");
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovFour markov = new MarkovFour();
		markov.setRandom(715);
		markov.setTraining(st);
		for (int k = 0; k < 3; k++) {
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}
	
	private void printOut(String s){
		String[] words = s.split("\\s+");
		int psize = 0;
		System.out.println("----------------------------------");
		for(int k=0; k < words.length; k++){
			System.out.print(words[k]+ " ");
			psize += words[k].length() + 1;
			if (psize > 60) {
				System.out.println();
				psize = 0;
			}
		}
		System.out.println("\n----------------------------------");
	}
	
	 public void q7runMarkovModel() {
		FileResource fr = new FileResource("data/romeo.txt");
		String st = fr.asString();
		st = st.replace('\n', ' ');
		//MarkovModel markov = new MarkovModel(6);
		//markov.setRandom(38);
		MarkovModel markov = new MarkovModel(7);
		markov.setRandom(953);
		markov.setTraining(st);
		for(int k=0; k < 3; k++){
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}
}
