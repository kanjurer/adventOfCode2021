package day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("./src/day7/data.txt"));
        ArrayList<Integer> numbers = new ArrayList<>();
        while (file.hasNextLine()) {
            String[] tmp = file.nextLine().split(",");
            for (String s : tmp) {
                numbers.add(Integer.parseInt(s));
            }
        }
        Collections.sort(numbers);
        int minDistance = 1000000000;
        int numberWeNeed = 0;
        for (int i = 0; i < numbers.get(numbers.size() - 1); i++) {
            int sum = 0;
            for (int num : numbers) {
                sum += Math.abs(i - num);
                if (sum > minDistance) {
                    break;
                }
            }
            if (sum < minDistance) {
                minDistance = sum;
                numberWeNeed = i;
            }
        }
        System.out.println(numberWeNeed);
        System.out.println(minDistance);
    }
}

/*

x a
x^2 + a^2 - 2ax = d^2


 */