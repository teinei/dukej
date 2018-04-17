import edu.duke.*;

public class HelloWorld {
	public void runHello () {
		FileResource res = new FileResource("hello_unicode.txt");
		//open a txt file
		for (String line : res.lines()) {//read each line in it
			System.out.println(line);//print the line out
		}
	}
}
