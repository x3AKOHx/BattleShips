package ru.sasuh.BattleShips;

import java.util.Scanner;

public class Coordinates {

    private final int[] first = new int[2];
    private final int[] second= new int[2];

    public Coordinates(String[][] field) {
        //shot coordinates
        boolean isTrue = true;
        while (isTrue) {
            Scanner sc = new Scanner(System.in);
            String coordinates = sc.nextLine();
            char[] ch = coordinates.toCharArray();

            this.first[0] = ch[0] - 64;
            if (ch.length > 2) {
                this.first[1] = Integer.parseInt(String.valueOf(ch[1]) + ch[2]);
            } else {
                this.first[1] = ch[1] - '0';
            }
            isTrue = !isValidFirst(field);
        }
    }

    public Coordinates(String[][] field, int length) {
        //ship coordinates
        boolean isTrue = true;
        while (isTrue) {
            Scanner sc = new Scanner(System.in);
            String coordinates = sc.nextLine();

            String[] str = coordinates.split(" ");
            char[] ch = str[0].toCharArray();
            char[] ch2 = str[1].toCharArray();

            int a1, b1, a2, b2;

            a1 = ch[0] - 64;
            a2 = ch2[0] - 64;

            if (ch.length > 2) {
                b1 = Integer.parseInt(String.valueOf(ch[1]) + ch[2]);
            } else {
                b1 = ch[1] - '0';
            }

            if (ch2.length > 2) {
                b2 = Integer.parseInt(String.valueOf(ch2[1] + ch2[2]));
            } else {
                b2 = ch2[1] - '0';
            }

            if (a1 == a2) {
                if (b1 < b2) {
                    this.first[1] = b1;
                    this.second[1] = b2;
                } else {
                    this.first[1] = b2;
                    this.second[1] = b1;
                }
                this.first[0] = a1;
                this.second[0] = a2;
            } else {
                if (a1 < a2) {
                    this.first[0] = a1;
                    this.second[0] = a2;
                } else {
                    this.first[0] = a2;
                    this.second[0] = a1;
                }
                this.first[1] = b1;
                this.second[1] = b2;
            }
            isTrue = !isValid(field, length);
        }
    }

    public boolean isValid(String[][] field, int length) {
        if ((second[0] - first[0] != length - 1) && (second[1] - first[1] != length - 1)) {
            System.out.println("Error! Wrong length of the ship! Try again:");
            return false;
        }
        if (first[0] != second[0] && first[1] != second[1]) {
            System.out.println("Error! Wrong ship location! Try again:");
            return false;
        }
        if (first[0] == second[0]) {
            for (int i = first[0] - 1; i <= first[0] + 1; i++) {
                for (int j = first[1] - 1; j <= first[1] + length; j++) {
                    if ((i != 0 && j != 0) && (i < field.length && j < field.length)) {
                        if (field[i][j].equals("O")) {
                            System.out.println("Error! You placed it too close to another one. Try again:");
                            return false;
                        }
                    }
                }
            }
        } else {
            for (int i = first[0] - 1; i <= first[0] + length; i++) {
                for (int j = first[1] - 1; j <= first[1] + 1; j++) {
                    if ((i != 0 && j != 0) && (i < field.length && j < field.length)) {
                        if (field[i][j].equals("O")) {
                            System.out.println("Error! You placed it too close to another one. Try again:");
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidFirst(String[][] field) {
        if ((first[0] < 1 || first[0] >= field.length) || (first[1] < 1 || first[1] >= field.length)) {
            System.out.println("Error! You entered the wrong coordinates! Try again:");
            return false;
        }
        return true;
    }

    public int[] getFirst() {
        return first;
    }

    public int[] getSecond() {
        return second;
    }
}
