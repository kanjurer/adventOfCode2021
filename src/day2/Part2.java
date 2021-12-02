package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("./src/day2/data.txt"));
        int depth = 0;
        int horizontal = 0;
        int aim = 0;
        String command;
        int value;

        while (file.hasNext()) {
            command = file.next();
            value = file.nextInt();

            switch (command) {
                case "forward" -> {
                    horizontal += value;
                    depth += aim * value;
                }
                case "down" -> {
                    aim += value;
                }
                case "up" -> {
                    aim -= value;
                }
            }
        }

        System.out.println("Horizontal: " + horizontal);
        System.out.println("Depth: " + depth);
        System.out.println("Aim: " + aim);
        System.out.println("Answer: " + horizontal * depth);
    }
}
