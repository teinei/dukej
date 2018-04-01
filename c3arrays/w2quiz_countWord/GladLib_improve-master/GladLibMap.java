import edu.duke.*;
import java.util.*;

public class GladLibMap {
    // private ArrayList<String> adjectiveList;
    // private ArrayList<String> nounList;
    // private ArrayList<String> colorList;
    // private ArrayList<String> countryList;
    // private ArrayList<String> nameList;
    // private ArrayList<String> animalList;
    // private ArrayList<String> timeList;
    // private ArrayList<String> verbList;
    // private ArrayList<String> fruitList;
    private HashMap<String, ArrayList<String>> myMap;

    private Random myRandom;
    private ArrayList<String> usedWord;
    private int replaceCount;
    private ArrayList<String> usedCat;

    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";

    public GladLibMap(){
    myMap = new HashMap<String, ArrayList<String>>();
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }

    public GladLibMap(String source){
    myMap = new HashMap<String, ArrayList<String>>();
        initializeFromSource(source);
        myRandom = new Random();
    }

    private void initializeFromSource(String source) {
    String[] categories =  new String[] {"adjective","noun","color","country","name","animal","timeframe","verb","fruit"};
    for (String type : categories) {
      ArrayList<String> list = readIt(source+"/"+type+".txt");
      myMap.put(type,list);
    }
    }

    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }

    private String getSubstitute(String label) {
    if (!usedCat.contains(label)) {
      usedCat.add(label);
    }
    if (myMap.containsKey(label)) {
      return randomFrom(myMap.get(label));
    } else if (label.equals("number")) {
      return ""+myRandom.nextInt(50)+5;
    } else {
      return "**UNKNOWN**";
    }
    }

    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
        while (usedWord.contains(sub)) {
            sub = getSubstitute(w.substring(first+1,last));
        }
        usedWord.add(sub);
        replaceCount++;
        return prefix+sub+suffix;
    }

    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        usedWord = new ArrayList<String>();
        usedCat = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        usedWord.clear();
        return story;
    }

    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }

    private int totalWordsInMap(){
        int numWords = 0;
        for (String type : myMap.keySet()) {
            numWords += myMap.get(type).size();
        }
        return numWords;
    }

    private int totalWordsConsidered(){
        int numWords = 0;
        for (String type : usedCat) {
            if (myMap.containsKey(type)) {
                numWords += myMap.get(type).size();
            }
        }
        return numWords;
    }

    public void makeStory(){
        System.out.println("\n");
        String story = fromTemplate("data/madtemplate2.txt");
        printOut(story, 60);
        System.out.println("\n\n" + replaceCount + " words have been replaced!");
        replaceCount = 0;
        System.out.println("total words in map: " + totalWordsInMap());
        System.out.println("total words considere: " + totalWordsConsidered());
    }

}
