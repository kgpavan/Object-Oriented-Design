package design.practice.designEx.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TicTacToeReader {

    public static List<String> getLinesFromFile(String filePath) {
        List<String> lines = new ArrayList<String>();

        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath));
            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                lines.add(oneLine);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();

        }

        return lines;
    }
}
