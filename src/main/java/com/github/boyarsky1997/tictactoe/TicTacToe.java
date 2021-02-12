package com.github.boyarsky1997.tictactoe;


import java.io.Serializable;
import java.util.Random;

public class TicTacToe implements Serializable {
    final char SIGN_X = 'x';
    final char SIGN_O = 'o';
    final char SIGN_EMPTY = '.';
    public char[][] table;
    Random random;

    public TicTacToe() {
        random = new Random();
        table = new char[3][3];
    }

    public char[][] getTable() {
        return table;
    }

    public void game() {
        initTable();
        while (true) {
            turnHuman(1, 2);
            String[] strings1 = checkWin(SIGN_X);
            if (strings1 != null) {
                System.out.println("Nagibator WIN!");
                break;
            }
            if (isTableFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
            turnAI();
            printTable();
            String[] strings = checkWin(SIGN_O);
            if (strings != null) {
                System.out.println("Термінатор WIN!");
                break;
            }
            if (isTableFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
        }
        System.out.println("GAME OVER.");
        printTable();
    }

    public void initTable() {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                table[row][col] = SIGN_EMPTY;
    }

    public void printTable() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++)
                System.out.print(table[row][col] + " ");
            System.out.println();
        }
    }

    public void turnHuman(int x, int y) {
        table[y][x] = SIGN_X;
    }

    public boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= 3 || y >= 3)
            return false;
        return table[y][x] == SIGN_EMPTY;
    }

    public void turnAI() {
        int x, y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!isCellValid(x, y));
        table[y][x] = SIGN_O;
    }

    public boolean checkWinHuman() {
        return checkWin(SIGN_X) != null;
    }

    public boolean checkWinAI() {
        return checkWin(SIGN_O) != null;
    }

    public String[] checkWin(char dot) {
        String[] mas = new String[3];
        for (int i = 0; i < 3; i++) {
            if (table[i][0] == dot && table[i][1] == dot &&
                    table[i][2] == dot) {
                mas[0] = i + ",0";
                mas[1] = i + ",1";
                mas[2] = i + ",2";
                return mas;
            }
            if (table[0][i] == dot && table[1][i] == dot &&
                    table[2][i] == dot) {
                mas[0] = "0," + i;
                mas[1] = "1," + i;
                mas[2] = "2," + i;
                return mas;
            }
        }
        if (table[0][0] == dot && table[1][1] == dot &&
                table[2][2] == dot) {
            mas[0] = "0,0";
            mas[1] = "1,1";
            mas[2] = "2,2";
            return mas;
        }
        if ((table[2][0] == dot && table[1][1] == dot &&
                table[0][2] == dot)) {
            mas[0] = "2,0";
            mas[1] = "1,1";
            mas[2] = "0,2";
            return mas;
        }
        return null;
    }

    public boolean isTableFull() {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                if (table[row][col] == SIGN_EMPTY)
                    return false;
        return true;
    }

    public void turnHuma1(int x, int y) {
        table[y][x] = 5;
    }
}