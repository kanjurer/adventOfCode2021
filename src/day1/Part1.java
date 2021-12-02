package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("./src/day1/data.txt"));

        int increased = 0;
        int decreased = 0;
        int equal = 0;

        int integer1 = file.nextInt();
        int integer2;
        while (file.hasNextInt()) {
            integer2 = file.nextInt();
            if (integer2 - integer1 > 0) {
                increased++;
            } else if (integer2 - integer1 < 0) {
                decreased++;
            } else {
                equal++;
            }
            integer1 = integer2;
        }

        System.out.println("Increased: " + increased);
        System.out.println("Decreased: " + decreased);
        System.out.println("Equal: " + equal);
    }
}
