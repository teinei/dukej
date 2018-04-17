

import edu.duke.*;

public class MarkovRunner {
    public void runModel(IMarkovModel markov, String text, int size){ 
        markov.setTraining(text); 
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    } 

    public void runModel(IMarkovModel markov, String text, int size, int seed){ 
        markov.setTraining(text); 
        markov.setRandom(seed);
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    } 

    public void q7runMarkov() { 
        FileResource fr = new FileResource("data/romeo.txt"); 
        String st = fr.asString(); 
        st = st.replace('\n', ' '); 
        MarkovWord markov = new MarkovWord(7); //7
        runModel(markov, st, 200, 953); 
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
    
    public void q9runEffMarkov() { 
        FileResource fr = new FileResource(); 
        String st = fr.asString(); 
        //String st = "this is a test yes this is really a test";
        st = st.replace('\n', ' '); 
    	
        EfficientMarkovWord markov = new EfficientMarkovWord(4);//order
        //runModel(markov, st, 50, 65);
        runModel(markov, st, 50, 792);//size,seed
        markov.printHashMapInfo();
    } 

}
