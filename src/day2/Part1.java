package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("./src/day2/data.txt"));
        int depth = 0;
        int horizontal = 0;
        String command;
        int value;

        while (file.hasNext()) {
            command = file.next();
            value = file.nextInt();

            switch (command) {
                case "forward" -> horizontal += value;
                case "down" -> depth += value;
                case "up" -> depth -= value;
            }
        }

        System.out.println("Horizontal: " + horizontal);
        System.out.println("Depth: " + depth);
        System.out.println("Answer: " + horizontal * depth);
    }
}
