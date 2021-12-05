package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part2 {
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

            if (x1 > x2) {
                while (x1 >= x2) {
                    vents[x1][y1] += 1;
                    x1--;
                    if (y1 > y2) {
                        y1--;
                    } else if (y1 < y2) {
                        y1++;
                    }
                }
            } else if (x1 < x2) {
                while (x1 <= x2) {
                    vents[x1][y1] += 1;
                    x1++;
                    if (y1 > y2) {
                        y1--;
                    } else if (y1 < y2) {
                        y1++;
                    }
                }
            } else {
                if (y1 > y2) {
                    while (y1 >= y2) {
                        vents[x1][y1] += 1;
                        y1--;
                    }
                } else if (y1 < y2) {
                    while (y1 <= y2) {
                        vents[x1][y1] += 1;
                        y1++;
                    }
                } else {
                    vents[x1][y1] += 1;
                }
            }
        }

        int count = 0;

        for (
                int i = 0;
                i < vents.length; i++) {
            for (int j = 0; j < vents.length; j++) {
                if (vents[i][j] >= 2) count++;
            }
        }
        System.out.println(count);

    }
}
