package day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("./src/day8/data.txt"));
        String yo = "9997656789876543234567989101298998743219853135678978901239999876543422349134989891012932398767323567";
        yo = "9899965678";
        int width = yo.length();
        int height = 100;
        height = 5;
        ArrayList<ArrayList<Integer>> numbers = new ArrayList<>();
        for (int i = 0; i < yo.length(); i++) {
            numbers.add(new ArrayList<>());
        }
        int rows = 0;
        while (file.hasNextLine()) {
            String tmp = file.nextLine();
            for (int i = 0; i < tmp.length(); i++) {
                numbers.get(rows).add(Integer.parseInt(Character.toString(tmp.charAt(i))));
            }
            rows++;
        }
        int topLeft = 0;
        int topRight = 0;
        int bottomLeft = 0;
        int bottomRight = 0;
        int middle = 0;

        for (int i = 0; i < height; i++) {
            ArrayList<Integer> row = numbers.get(i);
            boolean isOver = false;
            for (int j = 0; j < width; j++) {
                int el = row.get(j);
                if (el == 9) {
                    isOver = true;
                    break;
                }
                if (row.get(j + 1) == 9) break;
                topLeft++;
            }
            if (isOver) break;

        }
        for (int i = 0; i < height / 2 + 1; i++) {
            ArrayList<Integer> row = numbers.get(i);
            boolean isOver = false;
            for (int j = width / 2 + 1; j < width; j++) {
                int el = row.get(j);
                if (el == 9) {
                    isOver = true;
                    break;
                }
                if (j!= 9 && row.get(j + 1) == 9) break;
                topRight++;
            }
            if (isOver) break;

        }
        for (int i = height / 2; i < height; i++) {
            ArrayList<Integer> row = numbers.get(i);
            boolean isOver = false;
            for (int j = 0; j < width; j++) {
                int el = row.get(j);
                if (el == 9) {
                    isOver = true;
                    break;
                }
                if (row.get(j + 1) == 9) break;
                bottomLeft++;
            }
            if (isOver) break;

        }
        for (int i = height / 2; i < height; i++) {
            ArrayList<Integer> row = numbers.get(i);
            boolean isOver = false;
            for (int j = width / 2; j < width; j++) {
                int el = row.get(j);
                if (el == 9) {
                    isOver = true;
                    break;
                }
                if (row.get(j + 1) == 9) break;
                bottomRight++;
            }
            if (isOver) break;

        }
        for (int i = 3; i < height; i++) {
            ArrayList<Integer> row = numbers.get(i);
            boolean isOver = false;
            for (int j = 3; j < width; j++) {
                int el = row.get(j);
                if (el == 9) {
                    isOver = true;
                    break;
                }
                if (row.get(j + 1) == 9) break;
                middle++;
            }
            if (isOver) break;

        }

        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(topLeft, topRight, bottomLeft, bottomRight, middle));

        Collections.sort(nums);
        System.out.println(nums.get(2) * nums.get(3) * nums.get(4));

    }
}

