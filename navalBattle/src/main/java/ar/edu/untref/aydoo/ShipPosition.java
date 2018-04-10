package ar.edu.untref.aydoo;

public class ShipPosition {

    private Position position;
    private boolean hasShot = Boolean.FALSE;


    public ShipPosition (Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public boolean hasShot() {
        return hasShot;
    }

    public void setHasShot(boolean hasShot) {
        this.hasShot = hasShot;
    }
}
