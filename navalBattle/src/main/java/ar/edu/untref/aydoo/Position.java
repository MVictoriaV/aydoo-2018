package ar.edu.untref.aydoo;

public class Position {

    private Integer verticalPosition;
    private Integer horizontalPosition;
    private boolean isWater = Boolean.TRUE;

    public Position(int horizontalPosition, int verticalPosition) {
        this.horizontalPosition = horizontalPosition;
        this.verticalPosition = verticalPosition;
    }

    public Integer getHorizontalPosition() {
        return horizontalPosition;
    }

    public Integer getVerticalPosition() {
        return verticalPosition;
    }

    public void setWater(boolean water) {
        this.isWater = water;
    }

    public boolean isWater() {
        return this.isWater;
    }
}
