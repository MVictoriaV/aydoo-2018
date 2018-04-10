package ar.edu.untref.aydoo;

public class ShipPosition {

    private Position position;
    private boolean hasShot;

    public ShipPosition (Position position) {
        this.position = position;
        this.hasShot = Boolean.FALSE;
    }

    public Position getPosition() {
        return position;
    }

    public void shoot() {
        this.hasShot = Boolean.TRUE;
    }

    public boolean hasShot () {
        return this.hasShot;
    }
}
