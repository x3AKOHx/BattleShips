package ru.sasuh.BattleShips;

public class Ships {

    private final int[] aircraftCoordinates = new int[4];
    private final int[] battleshipCoordinates = new int[4];
    private final int[] submarineCoordinates = new int[4];
    private final int[] cruiserCoordinates = new int[4];
    private final int[] destroyerCoordinates = new int[4];

    private boolean aCheck = false;
    private boolean bCheck = false;
    private boolean sCheck = false;
    private boolean cCheck = false;
    private boolean dCheck = false;

    public void placeAircraft(Field field) {
        Coordinates coordinates = new Coordinates(field.getField(), 5);
        
        aircraftCoordinates[0] = coordinates.getFirst()[0];
        aircraftCoordinates[1] = coordinates.getFirst()[1];
        aircraftCoordinates[2] = coordinates.getSecond()[0];
        aircraftCoordinates[3] = coordinates.getSecond()[1];
        
        if (coordinates.getFirst()[0] == coordinates.getSecond()[0]) {
            for (int i = coordinates.getFirst()[1]; i <= coordinates.getSecond()[1]; i++) {
                field.getField()[coordinates.getFirst()[0]][i] = "O";
            }
        } else {
            for (int i = coordinates.getFirst()[0]; i <= coordinates.getSecond()[0]; i++) {
                field.getField()[i][coordinates.getFirst()[1]] = "O";
            }
        }
    }

    public void placeBattleship(Field field) {
        Coordinates coordinates = new Coordinates(field.getField(), 4);

        battleshipCoordinates[0] = coordinates.getFirst()[0];
        battleshipCoordinates[1] = coordinates.getFirst()[1];
        battleshipCoordinates[2] = coordinates.getSecond()[0];
        battleshipCoordinates[3] = coordinates.getSecond()[1];
        
        if (coordinates.getFirst()[0] == coordinates.getSecond()[0]) {
            for (int i = coordinates.getFirst()[1]; i <= coordinates.getSecond()[1]; i++) {
                field.getField()[coordinates.getFirst()[0]][i] = "O";
            }
        } else {
            for (int i = coordinates.getFirst()[0]; i <= coordinates.getSecond()[0]; i++) {
                field.getField()[i][coordinates.getFirst()[1]] = "O";
            }
        }
    }

    public void placeSubmarine(Field field) {
        Coordinates coordinates = new Coordinates(field.getField(), 3);

        submarineCoordinates[0] = coordinates.getFirst()[0];
        submarineCoordinates[1] = coordinates.getFirst()[1];
        submarineCoordinates[2] = coordinates.getSecond()[0];
        submarineCoordinates[3] = coordinates.getSecond()[1];
        
        if (coordinates.getFirst()[0] == coordinates.getSecond()[0]) {
            for (int i = coordinates.getFirst()[1]; i <= coordinates.getSecond()[1]; i++) {
                field.getField()[coordinates.getFirst()[0]][i] = "O";
            }
        } else {
            for (int i = coordinates.getFirst()[0]; i <= coordinates.getSecond()[0]; i++) {
                field.getField()[i][coordinates.getFirst()[1]] = "O";
            }
        }
    }

    public void placeCruiser(Field field) {
        Coordinates coordinates = new Coordinates(field.getField(), 3);

        cruiserCoordinates[0] = coordinates.getFirst()[0];
        cruiserCoordinates[1] = coordinates.getFirst()[1];
        cruiserCoordinates[2] = coordinates.getSecond()[0];
        cruiserCoordinates[3] = coordinates.getSecond()[1];
        
        if (coordinates.getFirst()[0] == coordinates.getSecond()[0]) {
            for (int i = coordinates.getFirst()[1]; i <= coordinates.getSecond()[1]; i++) {
                field.getField()[coordinates.getFirst()[0]][i] = "O";
            }
        } else {
            for (int i = coordinates.getFirst()[0]; i <= coordinates.getSecond()[0]; i++) {
                field.getField()[i][coordinates.getFirst()[1]] = "O";
            }
        }
    }

    public void placeDestroyer(Field field) {
        Coordinates coordinates = new Coordinates(field.getField(), 2);

        destroyerCoordinates[0] = coordinates.getFirst()[0];
        destroyerCoordinates[1] = coordinates.getFirst()[1];
        destroyerCoordinates[2] = coordinates.getSecond()[0];
        destroyerCoordinates[3] = coordinates.getSecond()[1];
        
        if (coordinates.getFirst()[0] == coordinates.getSecond()[0]) {
            for (int i = coordinates.getFirst()[1]; i <= coordinates.getSecond()[1]; i++) {
                field.getField()[coordinates.getFirst()[0]][i] = "O";
            }
        } else {
            for (int i = coordinates.getFirst()[0]; i <= coordinates.getSecond()[0]; i++) {
                field.getField()[i][coordinates.getFirst()[1]] = "O";
            }
        }
    }
    
    public boolean ifShipSanked(Field field) {
        int count = 0;
        if (aircraftCoordinates[0] == aircraftCoordinates[2]) {
            for (int i = aircraftCoordinates[1]; i <= aircraftCoordinates[3]; i++) {
                if (field.getField()[aircraftCoordinates[0]][i].equals("X")) {
                    count++;
                }
            }
        } else {
            for (int i = aircraftCoordinates[0]; i <= aircraftCoordinates[2]; i++) {
                if (field.getField()[i][aircraftCoordinates[1]].equals("X")) {
                    count++;
                }
            }
        }
        if (count == 5 && !aCheck) {
            aCheck = true;
            return true;
        }
        count = 0;
        if (battleshipCoordinates[0] == battleshipCoordinates[2]) {
            for (int i = battleshipCoordinates[1]; i <= battleshipCoordinates[3]; i++) {
                if (field.getField()[battleshipCoordinates[0]][i].equals("X")) {
                    count++;
                }
            }
        } else {
            for (int i = battleshipCoordinates[0]; i <= battleshipCoordinates[2]; i++) {
                if (field.getField()[i][battleshipCoordinates[1]].equals("X")) {
                    count++;
                }
            }
        }
        if (count == 4 && !bCheck) {
            bCheck = true;
            return true;
        }
        count = 0;
        if (submarineCoordinates[0] == submarineCoordinates[2]) {
            for (int i = submarineCoordinates[1]; i <= submarineCoordinates[3]; i++) {
                if (field.getField()[submarineCoordinates[0]][i].equals("X")) {
                    count++;
                }
            }
        } else {
            for (int i = submarineCoordinates[0]; i <= submarineCoordinates[2]; i++) {
                if (field.getField()[i][submarineCoordinates[1]].equals("X")) {
                    count++;
                }
            }
        }
        if (count == 3 && !sCheck) {
            sCheck = true;
            return true;
        }
        count = 0;
        if (cruiserCoordinates[0] == cruiserCoordinates[2]) {
            for (int i = cruiserCoordinates[1]; i <= cruiserCoordinates[3]; i++) {
                if (field.getField()[cruiserCoordinates[0]][i].equals("X")) {
                    count++;
                }
            }
        } else {
            for (int i = cruiserCoordinates[0]; i <= cruiserCoordinates[2]; i++) {
                if (field.getField()[i][cruiserCoordinates[1]].equals("X")) {
                    count++;
                }
            }
        }
        if (count == 3 && !cCheck) {
            cCheck = true;
            return true;
        }
        count = 0;
        if (destroyerCoordinates[0] == destroyerCoordinates[2]) {
            for (int i = destroyerCoordinates[1]; i <= destroyerCoordinates[3]; i++) {
                if (field.getField()[destroyerCoordinates[0]][i].equals("X")) {
                    count++;
                }
            }
        } else {
            for (int i = destroyerCoordinates[0]; i <= destroyerCoordinates[2]; i++) {
                if (field.getField()[i][destroyerCoordinates[1]].equals("X")) {
                    count++;
                }
            }
        }
        if (count == 2 && !dCheck) {
            dCheck = true;
            return true;
        }
        return false;
    }
}
