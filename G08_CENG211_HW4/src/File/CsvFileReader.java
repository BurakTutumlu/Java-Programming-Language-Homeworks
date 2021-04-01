package File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;


// 	Actually we have preferred "FileReader" name for this class,
// 	but there was a conflict with java.util.FileReader.
// 	Therefore we changed the class name as CsvFileReader
public class CsvFileReader {

	/**
	 * Returns a LinkedList for a given file path. 
	 * Each item in LinkedList is actually a line of file.  
	 * If file not found, IOException will be thrown. 
	 *
	 * @param  filePath  an absolute path for file to be opened
	 * @return lines of file as a Linked List
	 */
	public static Queue<String> readFile(String filePath) throws IOException {
		Queue<String> lines = new LinkedList<String>(); 
		BufferedReader reader;
		reader = new BufferedReader(new FileReader(filePath));
		String line = reader.readLine();
		while (line != null) {
			lines.add(line);
			// read next line
			line = reader.readLine();
		}
		reader.close();
		return lines;	
	}
}
