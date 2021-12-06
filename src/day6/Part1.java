package day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("./src/day6/data.txt"));
        ArrayList<Integer> numbers = new ArrayList<>();
        while (file.hasNextLine()) {
            String[] tmp = file.nextLine().split(",");
            for (String s : tmp) {
                numbers.add(Integer.parseInt(s));
            }
        }

        HashMap<Integer, Long> optimizedNums = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            optimizedNums.put(i, 0L);
        }
        for (int number : numbers) {
            optimizedNums.put(number, optimizedNums.get(number) + 1);
        }
        for (int i = 0; i < 256; i++) {
            long n = optimizedNums.get(0);
            for (int j = 0; j < 9; j++) {
                optimizedNums.put(j, optimizedNums.get(j + 1));
            }
            optimizedNums.put(8, n);
            optimizedNums.put(6, optimizedNums.get(6) + n);
        }
        long count = 0;
        for (int i = 0; i < 9; i++) {
            count += optimizedNums.get(i);
        }
        System.out.println(count);
    }
}

