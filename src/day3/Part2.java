package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("./src/day3/data.txt"));
        ArrayList<String> nums = new ArrayList<>();

        while (file.hasNextLong()) {
            nums.add(file.next());
        }

        ArrayList<String> o2Array = nums;
        ArrayList<String> co2Array = nums;
        ArrayList<String> onesArray;
        ArrayList<String> zeroesArray;

        String co2ScrubberRating = "";
        String o2ScrubberRating = "";

        for (int i = 0; i <= nums.get(0).length(); i++) {
            onesArray = new ArrayList<>();
            zeroesArray = new ArrayList<>();
            int ones = 0;
            int zeroes = 0;
            if (o2Array.size() == 1) {
                o2ScrubberRating = o2Array.get(0);
                break;
            } else if (o2Array.size() == 0) {
                break;
            }
            for (int j = 0; j < o2Array.size(); j++) {
                char bit = o2Array.get(j).charAt(i);
                if (bit == '0') {
                    zeroesArray.add(o2Array.get(j));
                    zeroes++;
                } else if (bit == '1') {
                    onesArray.add(o2Array.get(j));
                    ones++;
                }
            }
            if (zeroes > ones) {
                o2Array = zeroesArray;
            } else {
                o2Array = onesArray;
            }
        }

        for (int i = 0; i <= nums.get(0).length(); i++) {
            onesArray = new ArrayList<>();
            zeroesArray = new ArrayList<>();
            int ones = 0;
            int zeroes = 0;
            if (co2Array.size() == 1) {
                co2ScrubberRating = co2Array.get(0);
                break;
            } else if (co2Array.size() == 0) {
                break;
            }
            for (int j = 0; j < co2Array.size(); j++) {
                char bit = co2Array.get(j).charAt(i);
                if (bit == '0') {
                    zeroesArray.add(co2Array.get(j));
                    zeroes++;
                } else if (bit == '1') {
                    onesArray.add(co2Array.get(j));
                    ones++;
                }
            }
            if (zeroes > ones) {
                co2Array = onesArray;
            } else {
                co2Array = zeroesArray;
            }
        }


        System.out.println("O2 scrubber rating binary: " + o2ScrubberRating);
        System.out.println("CO2 scrubber rating binary: " + co2ScrubberRating);
        System.out.println("O2 scrubber rating: " + Integer.parseInt(o2ScrubberRating, 2));
        System.out.println("CO2 scrubber rating: " + Integer.parseInt(co2ScrubberRating, 2));
        System.out.println("life support rating: " +
                Integer.parseInt(o2ScrubberRating, 2) * Integer.parseInt(co2ScrubberRating, 2));

    }
}
