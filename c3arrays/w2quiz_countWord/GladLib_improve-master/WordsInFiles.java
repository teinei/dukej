
/**
 * Write a description of WordsInFiles here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;
import edu.duke.*;
import java.util.*;
public class WordsInFiles {
  private HashMap<String, ArrayList<String>> wordMap;

  public WordsInFiles(){
    wordMap = new HashMap<String, ArrayList<String>>();
  }

  private void addWordsFromFile(File f){
    FileResource fr = new FileResource(f);
    for (String word : fr.words()) {
      if (!wordMap.containsKey(word)) {
        ArrayList<String> fnameList = new ArrayList<String>();
        fnameList.add(f.getName());
        wordMap.put(word, fnameList);
      } else if(!wordMap.get(word).contains(f.getName())){
        String fname = f.getName();
        ArrayList<String> newList = wordMap.get(word);
        newList.add(fname);
        wordMap.put(word, newList);
      }
    }
  }

  private void buildWordFileMap(){
    wordMap.clear();
    DirectoryResource dr = new DirectoryResource();
    for (File f : dr.selectedFiles()) {
      addWordsFromFile(f);
    }
  }

  private int maxNumber(){
    int maxNumber = 0;
    for (String word : wordMap.keySet()) {
      if (wordMap.get(word).size() > maxNumber) {
        maxNumber = wordMap.get(word).size();
      }
    }
    return maxNumber;
  }

  private ArrayList<String> wordsInNumFiles(int number){
    ArrayList<String> words = new ArrayList<String>();
    for (String word : wordMap.keySet()) {
      if (wordMap.get(word).size() == number) {
        words.add(word);
      }
    }
    return words;
  }

  private void printFilesIn(String word){
    for (String fname : wordMap.get(word)) {
      System.out.println("\t" + fname);
    }
  }

  public void tester(){
    buildWordFileMap();
    int maxNumber = maxNumber();
    System.out.println("7x are " + wordsInNumFiles(7).size());
    System.out.println("4x are " + wordsInNumFiles(4).size());
    // System.out.println("The greatest number of files a word appears in is " + maxNumber + " and the words and the files they are in are: ");
    // ArrayList<String> words = wordsInNumFiles(maxNumber);
    // for (String word : words) {
    //   System.out.println(word.size() + word);
    //   printFilesIn(word);
    // }
    System.out.println("laid");
    printFilesIn("laid");
    System.out.println("tree");
    printFilesIn("tree");
    System.out.println("sea");
    printFilesIn("sea");
    
  }

}
