package ru.sasuh.BattleShips;

public class Main {
    public static void main(String[] args) {
        //Set field size here
        Field field1 = new Field(10);
        Field field2 = new Field(10);

        GameMenu.gameStart(field1, field2);
    }
}
