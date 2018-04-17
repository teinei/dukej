
/**
 * Write a description of q3c here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class q3c {
    void q(){
        int n=5;
        int x=-n*n;
        System.out.println("n=5 ");
        System.out.println(x);
        for(int i=1;i<3*n;i++){
            x=x+2*i-1;
            System.out.println(x);
        }
        n=6;
        x=-n*n;
        System.out.println("n=6 ");
        System.out.print(x+" ");
        for(int i=1;i<3*n;i++){
            x=x+2*i-1;
            System.out.print(x+" ");
        }
    }
    

}
