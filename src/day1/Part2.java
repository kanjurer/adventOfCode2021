package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("./src/day1/data.txt"));
        ArrayList<Integer> groups = new ArrayList<>();
        int increased = 0;
        int decreased = 0;
        int equal = 0;

        int integer1 = file.nextInt();
        int integer2 = file.nextInt();
        int integer3;

        while (file.hasNextInt()) {
            integer3 = file.nextInt();
            groups.add(integer1 + integer2 + integer3);
            integer1 = integer2;
            integer2 = integer3;
        }

        for (int i = 1; i < groups.size(); i++) {
            if (groups.get(i) - groups.get(i - 1) > 0) {
                increased++;
            } else if (groups.get(i) - groups.get(i - 1) < 0) {
                decreased++;
            } else {
                equal++;
            }
        }

        System.out.println("Increased: " + increased);
        System.out.println("Decreased: " + decreased);
        System.out.println("Equal: " + equal);
    }
}
