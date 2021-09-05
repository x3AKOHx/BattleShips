package ru.sasuh.BattleShips;

public class Field {
    private static final String[] ALPHABET = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    private int fieldSize;
    private String[][] field;
    private String[][] fogOfWar;

    public Field(int fieldSize)  {
        if (fieldSize > 26 || fieldSize < 8) {
            System.out.println("Battle field size should be more then 8 and less then 26!");
        } else {
            this.fieldSize = fieldSize + 1;
            this.field = new String[this.fieldSize][this.fieldSize];
            this.fogOfWar = new String[this.fieldSize][this.fieldSize];

            field[0][0] = "";
            fogOfWar[0][0] = "";
            for (int x = 1; x < this.fieldSize; x++) {
                field[0][x] = String.valueOf(x);
                field[x][0] = ALPHABET[x - 1];
                fogOfWar[0][x] = String.valueOf(x);
                fogOfWar[x][0] = ALPHABET[x - 1];
            }
            for (int x = 1; x < this.fieldSize; x++) {
                for (int y = 1; y < this.fieldSize; y++) {
                    field[x][y] = "~";
                    fogOfWar[x][y] = "~";
                }
            }
        }
    }

    public void showField() {
        for (int x = 0; x < fieldSize; x++) {
            for (int y = 0; y < fieldSize - 1; y++) {
                System.out.print(field[x][y] + " ");
            }
            System.out.println(field[x][fieldSize - 1]);
        }
    }

    public void showFog() {
        for (int x = 0; x < fieldSize; x++) {
            for (int y = 0; y < fieldSize - 1; y++) {
                System.out.print(fogOfWar[x][y] + " ");
            }
            System.out.println(fogOfWar[x][fieldSize - 1]);
        }
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public String[][] getField() {
        return field;
    }

    public String[][] getFogOfWar() {
        return fogOfWar;
    }

    public void setField(int x, int y, String amount) {
        field[x][y] = amount;
    }

    public void setFogOfWar(int x, int y, String amount) {
        fogOfWar[x][y] = amount;
    }

}
