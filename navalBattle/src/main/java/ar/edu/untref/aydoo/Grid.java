package ar.edu.untref.aydoo;

public class Grid {

    private Position[][] positions;

    public Grid () {
        this.positions = new Position[2][2];
        for (int i = 0; i < this.positions.length; i++) {
            for (int j = 0; j < this.positions.length; j++) {
                this.positions[i][j] = new Position(i, j);
            }
        }
    }

    public void putEmbarkation(Ship aShip, Position position, Boolean isVertical) {
        for (int i = 0; i < aShip.getLength(); i++) {
            if (isVertical) {
                this.positions[position.getHorizontalPosition()][position.getVerticalPosition()+i].setWater(Boolean.FALSE);
            } else {
                this.positions[position.getHorizontalPosition()+i][position.getVerticalPosition()].setWater(Boolean.FALSE);
            }
        }

    }

    public boolean hasAnEmbarkation(Position position) {
        return !(this.positions[position.getHorizontalPosition()][position.getVerticalPosition()].isWater());
    }

    public String shoot(Position position) {
        return "sunken";
    }
}