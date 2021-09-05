package ru.sasuh.BattleShips;

import java.util.Scanner;

public class GameMenu {
    public static void gameStart(Field field1, Field field2) {
        Ships ships1 = new Ships();
        Ships ships2 = new Ships();
        System.out.println("Player 1, place your ships on the game field");
        System.out.println();
        field1.showField();
        placeShips(field1, ships1);
        System.out.println();
        System.out.println("Press Enter and pass the move to another player");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        System.out.println("Player 2, place your ships to the game field");
        System.out.println();
        field2.showField();
        placeShips(field2, ships2);
        System.out.println();
        System.out.println("Press Enter and pass the move to another player");
        sc.nextLine();

        while (true) {
            field2.showFog();
            System.out.println("---------------------");
            field1.showField();
            System.out.println();
            System.out.println("Player 1, it's your turn:");
            System.out.println();
            makeShot(field2, ships2);
            if (gameEnd(field2)) {
                System.out.println("You sank the last ship. You won. Congratulations!");
                break;
            }
            System.out.println("Press Enter and pass the move to another player");
            sc.nextLine();
            field1.showFog();
            System.out.println("---------------------");
            field2.showField();
            System.out.println();
            System.out.println("Player 2, it's your turn:");
            System.out.println();
            makeShot(field1, ships1);
            if (gameEnd(field1)) {
                System.out.println("You sank the last ship. You won. Congratulations!");
                break;
            }
            System.out.println("Press Enter and pass the move to another player");
            sc.nextLine();
        }
    }

    private static void placeShips(Field field, Ships ships) {
        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
        ships.placeAircraft(field);
        field.showField();
        System.out.println();
        System.out.println("Enter the coordinates of the Battleship (4 cells):");
        ships.placeBattleship(field);
        field.showField();
        System.out.println();
        System.out.println("Enter the coordinates of the Submarine (3 cells):");
        ships.placeSubmarine(field);
        field.showField();
        System.out.println();
        System.out.println("Enter the coordinates of the Cruiser (3 cells):");
        ships.placeCruiser(field);
        field.showField();
        System.out.println();
        System.out.println("Enter the coordinates of the Destroyer (2 cells)");
        ships.placeDestroyer(field);
        field.showField();
        System.out.println();
    }

    public static void makeShot(Field field, Ships ships) {
        Coordinates coordinates = new Coordinates(field.getField());
        int x = coordinates.getFirst()[0];
        int y = coordinates.getFirst()[1];
        if (field.getField()[x][y].equals("O")) {
            field.setField(x, y, "X");
            field.setFogOfWar(x, y, "X");
            if (ships.ifShipSanked(field)) {
                System.out.println("You sank a ship!");
            } else {
                System.out.println("You hit a ship!");
            }
            System.out.println();
        } else if (field.getField()[x][y].equals("~")) {
            field.setField(x, y, "M");
            field.setFogOfWar(x, y, "M");
            System.out.println("You missed.");
            System.out.println();
        } else {
            System.out.println("Wrong cell. Try again:");
            System.out.println();
        }
    }

    private static boolean gameEnd(Field field) {
        for (int x = 1; x < field.getFieldSize(); x++) {
            for (int y = 1; y < field.getFieldSize(); y++) {
                if (field.getField()[x][y].equals("O")) {
                    return false;
                }
            }
        }
        return true;
    }
}
