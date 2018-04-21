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

    public void receiveAShot() {
        this.hasShot = Boolean.TRUE;
    }

    public boolean hasShot () {
        return this.hasShot;
    }

    public Boolean samePosition(ShipPosition otherShipPosition) {
        Integer verticalPosition = otherShipPosition.getPosition().getVerticalPosition();
        Integer horizontalPosition = otherShipPosition.getPosition().getHorizontalPosition();
        return this.position.getVerticalPosition() == verticalPosition && this.position.getHorizontalPosition() == horizontalPosition;
    }
}
