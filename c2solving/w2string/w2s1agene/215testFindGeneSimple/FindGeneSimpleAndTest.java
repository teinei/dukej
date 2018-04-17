// video 215 Translating into Code - Duke University _ Coursera
// duke university java c2
//https://www.youtube.com/watch?v=tCXGJQYZ9JA
public class FindGeneSimpleAndTest {
    public String findGeneSimple(String dna){
        String result = "";
        int startIndex = dna.indexOf("ATG");
        if(startIndex==-1){
            return "!!no start ATG";//return empty string
        }//no atg
        int stopIndex=dna.indexOf("TAA",startIndex+3);
        if(stopIndex==-1){//check if there is stop condon
            return "!!no stop TAA";
        }
        result=dna.substring(startIndex,stopIndex+3);
        //include start index, plus 3
        return result;
    }
    public void testFindGeneSimple(){
        //q1
        String dna="";
        String gene="";
        dna="AAATGCCCTAACTAGATTAAGAAACC";//q1
        System.out.println("DNA strand is "+dna);
        gene=findGeneSimple(dna);
        System.out.println("Gene is "+gene);
        
        /*
        String dna="AATGCGTAATATGGT";
        System.out.println("DNA strand is "+dna);
        String gene=findGeneSimple(dna);
        System.out.println("Gene is "+gene);
        
        //dna2
        dna="AATGCTAGGGTAATATGGT";
        System.out.println("DNA strand is "+dna);
        gene=findGeneSimple(dna);
        System.out.println("Gene is "+gene);
        
        //dna3
        dna="ATCCTATGCTTCGGCTGCTCTAATATGGT";
        System.out.println("DNA strand is "+dna);
        gene=findGeneSimple(dna);
        System.out.println("Gene is "+gene);
        
        //DNA4
        dna="ATGTAA";
        System.out.println("DNA strand is "+dna);
        gene=findGeneSimple(dna);
        System.out.println("Gene is "+gene);
        
        //dna-blank
        dna="";
        System.out.println("DNA strand is "+dna);
        gene=findGeneSimple(dna);
        System.out.println("Gene is "+gene);
        
        //string have no atg, start index
        //got an error
        dna="TTATAA";
        System.out.println("DNA strand is "+dna);
        gene=findGeneSimple(dna);
        System.out.println("Gene is "+gene);
        
        //have no stop codon
        dna="CTATGGTTTG";
        System.out.println("DNA strand is "+dna);
        gene=findGeneSimple(dna);
        System.out.println("Gene is "+gene);
        */
    }

}
