import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Day06_01 {
    

    // Advent of Code 2022 Day 5   Part 1
    //  Read about the problem here  https://adventofcode.com/2022/day/5

    public static void main(String[] args) throws IOException, FileNotFoundException {
        Path current = Paths.get(".");
        String s = current.toAbsolutePath().toString();
        System.out.println("Path" + s);

        File inputTxt = new File("src/2022/day01/input.txt");
        BufferedReader input = new BufferedReader(new FileReader(inputTxt));
        String sections;

        char pos1, pos2, pos3, pos4;
        String dataLine = input.readLine();

        // Initial reading of the first 4 characters
        pos1=dataLine.charAt(0);
        pos2=dataLine.charAt(1);
        pos3=dataLine.charAt(2);
        pos4=dataLine.charAt(3);
        int position = 3;

        boolean allDifferent = AllDifferent(pos1, pos2, pos3, pos4);
        System.out.println("First Characters:" + pos1 + pos2 + pos3 + pos4);
        if (allDifferent)
            System.out.println("    They are different");
        else
            System.out.println("    Some are the same!");

        while (!allDifferent) {
            // what's the next character?
            position++;
            pos1 = pos2;
            pos2 = pos3;
            pos3 = pos4;
            pos4 = dataLine.charAt(position);

            allDifferent = AllDifferent(pos1, pos2, pos3, pos4);

        }
        position++;
        System.out.println("   At location " + position );
    }

    private static boolean AllDifferent(char pos1, char pos2, char pos3, char pos4) {
        System.out.println("Comparing:" + pos1 + pos2 + pos3 +pos4);
        if (pos1 == pos2 || pos1 == pos3 || pos1 == pos4  ||
        pos2 == pos3 || pos2 == pos4 || pos3 == pos4){
            System.out.println( "      NOT  All different");
            return false;
        }
        else {
            System.out.println( "      All different");
            return true;
        }

    }


}