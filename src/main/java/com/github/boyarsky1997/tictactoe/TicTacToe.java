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

    public char getSIGN_X() {
        return SIGN_X;
    }

    public char getSIGN_O() {
        return SIGN_O;
    }

    public char getSIGN_EMPTY() {
        return SIGN_EMPTY;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public char[][] getTable() {
        return table;
    }

    public void setTable(char[][] table) {
        this.table = table;
    }

    public void game() {
        initTable();
        while (true) {
            turnHuman(1, 2);
            if (checkWin(SIGN_X)) {
                System.out.println("Nagibator WIN!");
                break;
            }
            if (isTableFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
            turnAI();
            printTable();
            if (checkWin(SIGN_O)) {
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

  public   void printTable() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++)
                System.out.print(table[row][col] + " ");
            System.out.println();
        }
    }

    public void turnHuman(int x, int y) {
        do {
            System.out.println("Заповни X і Y (1..3):");
        } while (!isCellValid(x, y));
        table[y][x] = SIGN_X;
    }

    boolean isCellValid(int x, int y) {
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

    public boolean checkWin(char dot) {
        for (int i = 0; i < 3; i++)
            if ((table[i][0] == dot && table[i][1] == dot &&
                    table[i][2] == dot) ||
                    (table[0][i] == dot && table[1][i] == dot &&
                            table[2][i] == dot))
                return true;
        if ((table[0][0] == dot && table[1][1] == dot &&
                table[2][2] == dot) ||
                (table[2][0] == dot && table[1][1] == dot &&
                        table[0][2] == dot))
            return true;
        return false;
    }

    public boolean isTableFull() {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                if (table[row][col] == SIGN_EMPTY)
                    return false;
        return true;
    }
}