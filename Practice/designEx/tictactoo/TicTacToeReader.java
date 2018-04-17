package design.practice.designEx.tictactoo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TicTacToeReader {

    public static List<String> getLines(String filePath){
        List<String> lines = new ArrayList<String>();
        Scanner scanner = null;
        try {
            
            scanner = new Scanner(new BufferedReader(new FileReader(filePath)));
            while(scanner.hasNext()){
                lines.add(scanner.nextLine());
            }
            
            scanner.close();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }finally{
            scanner.close();
        }
        
        return lines;
    }
}
