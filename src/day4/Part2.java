package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Part2 {
    public static boolean match(Item[][] board) {
        for (int i = 0; i < 5; i++) {
            if (board[i][0].isFlagged() && board[i][1].isFlagged() && board[i][2].isFlagged()
                    && board[i][3].isFlagged() && board[i][4].isFlagged()) {
                return true;
            }
            if (board[0][i].isFlagged() && board[1][i].isFlagged() && board[2][i].isFlagged()
                    && board[3][i].isFlagged() && board[4][i].isFlagged()) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("./src/day4/data.txt"));

        Item[][] myBoard = new Item[5][5];
        ArrayList<Item[][]> boards = new ArrayList<>();

        while (file.hasNextInt()) {
            Item[][] board = new Item[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    board[i][j] = new Item(file.nextInt());
                }
            }
            boards.add(board);
        }

        Scanner randomNumbers = new Scanner("1 76 38 96 62 41 27 33 4 2 94 15 89 25 66 14 30 0 71 21 48 44 87 73 60 50 77 45 29 18 5 99 65 16 93 95 37 3 52 32 46 80 98 63 92 24 35 55 12 81 51 17 70 78 61 91 54 8 72 40 74 68 75 67 39 64 10 53 9 31 6 7 47 42 90 20 19 36 22 43 58 28 79 86 57 49 83 84 97 11 85 26 69 23 59 82 88 34 56 13");
        // randomNumbers = new Scanner("7 4 9 5 11 17 23 2 0 14 21 24 10 16 13 6 15 25 12 22 18 20 8 19 3 26 1");
        int num = 0;
        boolean found = false;
        while (randomNumbers.hasNextInt() && !found) {
            num = randomNumbers.nextInt();
            for (int k = 0; k < boards.size(); k++) {
                Item[][] b = boards.get(k);
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (b[i][j].getData() == num) {
                            b[i][j].setFlagged(true);
                        }
                    }
                }

                if (match(b)) {
                    if (boards.size() == 1) {
                        if (match(boards.get(0))) {
                            found = true;
                            myBoard = boards.get(0);
                            break;
                        }

                    } else {
                        k = boards.indexOf(b) - 1;
                        boards.remove(b);
                    }


                }

            }
        }

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!myBoard[i][j].isFlagged()) {
                    sum += myBoard[i][j].getData();
                }
            }
        }
        System.out.println(sum * num);
    }
}
