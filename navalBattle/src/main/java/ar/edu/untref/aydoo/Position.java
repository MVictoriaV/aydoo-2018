package ar.edu.untref.aydoo;

public class Position {

    private Integer verticalPosition;
    private Integer horizontalPosition;

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

    public boolean isEquals(Position aPosition) {
        return verticalPosition == aPosition.getVerticalPosition() && horizontalPosition == aPosition.getHorizontalPosition();
    }
}