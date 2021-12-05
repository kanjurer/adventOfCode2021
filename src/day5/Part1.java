package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("./src/day5/data.txt"));
        int[][] vents = new int[1000][1000];

        while (file.hasNext()) {
            String[] arr = file.next().split(",");
            int x1 = Integer.parseInt(arr[0]);
            int y1 = Integer.parseInt(arr[1]);

            file.next();

            arr = file.next().split(",");
            int x2 = Integer.parseInt(arr[0]);
            int y2 = Integer.parseInt(arr[1]);

            if (x1 != x2 && y1 != y2) {
                continue;
            }
            if (x1 > x2) {
                int tmp = x2;
                x2 = x1;
                x1 = tmp;
            }

            if (y1 > y2) {
                int tmp = y2;
                y2 = y1;
                y1 = tmp;
            }

            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    vents[i][j] += 1;
                }
            }
        }

        int count = 0;

        for (int i = 0; i < vents.length; i++) {
            for (int j = 0; j < vents.length; j++) {
                if (vents[i][j] >= 2) count++;
            }
        }
        System.out.println(count);

    }
}
