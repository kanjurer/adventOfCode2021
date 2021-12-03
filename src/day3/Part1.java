package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("./src/day3/data.txt"));

        String gammaRate = "";
        String epsilonRate = "";
        ArrayList<String> nums = new ArrayList<>();

        while (file.hasNextLong()) {
            nums.add(file.next());
        }

        for (int i = 0; i < nums.get(0).length(); i++) {
            int ones = 0;
            int zeroes = 0;
            for (int j = 0; j < nums.size(); j++) {
                char bit = nums.get(j).charAt(i);
                if (bit == '0') {
                    zeroes++;
                } else if (bit == '1') {
                    ones++;
                }
            }
            if (zeroes > ones) {
                gammaRate += "0";
                epsilonRate += "1";
            } else if (zeroes < ones) {
                gammaRate += "1";
                epsilonRate += "0";
            }
        }

        long gammaRateInDecimal = Integer.parseInt(gammaRate, 2);
        long epsilonRateInDecimal = Integer.parseInt(epsilonRate, 2);

        System.out.println("Gamma string: " + gammaRate);
        System.out.println("Epsilon string: " + epsilonRate);
        System.out.println("Gamma Rate: " + gammaRateInDecimal);
        System.out.println("Epsilon Rate: " + epsilonRateInDecimal);
        System.out.println("Power Consumption Rate: " + gammaRateInDecimal * epsilonRateInDecimal);
    }
}
