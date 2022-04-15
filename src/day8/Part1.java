package day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("./src/day8/data.txt"));
        String yo = "9997656789876543234567989101298998743219853135678978901239999876543422349134989891012932398767323567";

        int width = yo.length();
       int height =100;
        ArrayList<ArrayList<Integer>> numbers = new ArrayList<>();
        for (int i = 0; i <yo.length() ; i++) {
            numbers.add(new ArrayList<>());
        }
        int rows = 0;
        while (file.hasNextLine()) {
            String tmp = file.nextLine();
            for (int i = 0; i < tmp.length() ; i++) {
                numbers.get(rows).add(Integer.parseInt(Character.toString(tmp.charAt(i))));
            }
            rows++;
        }
        int sum = 0;

        for (int i = 0; i < height; i++) {
            ArrayList<Integer> row = numbers.get(i);
            for (int j = 0; j < width; j++) {
                boolean isLow = true;
                int up = -1, down = -1, left = -1, right = -1;
                int el = row.get(j);
                if (i - 1 >= 0) up = numbers.get(i - 1).get(j);
                if (i + 1 < height) down = numbers.get(i + 1).get(j);
                if (j - 1 >= 0) left = numbers.get(i).get(j - 1);
                if (j + 1 < width) right = numbers.get(i).get(j + 1);

                if (up != -1 && (up <= el)) continue;
                if (down != -1 && (down <= el)) continue;
                if (left != -1 && (left <= el)) continue;
                if (right != -1 && (right <= el)) continue;
                sum += el + 1;
            }
        }
        System.out.println(sum);
    }
}

