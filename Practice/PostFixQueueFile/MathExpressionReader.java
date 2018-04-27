package design.practice.designEx.PostFixQueueFile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MathExpressionReader {

	public static List<String> readFile(String filePath){
		List<String> lines = new ArrayList<String>();
		Scanner scanner;
		try {
			scanner = new Scanner(new FileReader(filePath));
			while(scanner.hasNext()){
				lines.add(scanner.nextLine());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e.getMessage());
		}
		
		return lines;
	}
}
