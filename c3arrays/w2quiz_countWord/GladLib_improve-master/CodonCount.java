
/**
 * Write a description of CodonCount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class CodonCount {
  private HashMap<String, Integer> codonCount;

  public CodonCount(){
    codonCount = new HashMap<String, Integer>();
  }

  private void buildCodonMap(int start, String dna){
    codonCount.clear();
    int i = start;
    while (i + 3 <= dna.length()) {
      String codon = dna.substring(i, i + 3);
      if (!codonCount.containsKey(codon)) {
        codonCount.put(codon,1);
      } else {
        codonCount.put(codon, codonCount.get(codon)+1);
      }
      i = i + 3;
    }
  }

  private String getMostCommonCodon(){
    int occur = 0;
    String codonMax = "";
    for (String codon: codonCount.keySet()) {
      if (codonCount.get(codon) > occur) {
        occur = codonCount.get(codon);
        codonMax = codon;
      }
    }
    return codonMax;
  }

  public void printCodonCounts(int start, int end){
    for (String codon : codonCount.keySet()) {
      if (start <= codonCount.get(codon) && codonCount.get(codon) <= end) {
        System.out.println(codon + "\t" + codonCount.get(codon));
      }
    }
  }

  public void tester(){
    FileResource fr = new FileResource();
    String dna = fr.asString().trim();
    //int start = 0;
    for (int start = 0; start < 3; start++) {
      buildCodonMap(start,dna);
      System.out.println("Reading frame starting from " + start + " result in " + codonCount.size() + " unique codons, and the most common codon is " + getMostCommonCodon() + " with count " + codonCount.get(getMostCommonCodon()));
      int min = 7; int max = 7;
      System.out.println("Counts of codons between " + min + " and " + max + " inclusive are: ");
      printCodonCounts(min, max);
    }
  }

}
