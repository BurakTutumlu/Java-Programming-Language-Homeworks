
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;
public class FileIO {
	/*
	 * Read a file and return it's context as a string array line by line.
	 * @param: fileName , name of the file
	 * @return: lines of string as a reader object
	 */
	public static BufferedReader ReadFile(String fileName) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			
			return reader;
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		return null;
	}
}
