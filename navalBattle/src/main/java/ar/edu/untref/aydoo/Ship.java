package ar.edu.untref.aydoo;

public class Ship {

    private Integer length;

    public Ship (Integer length) {
        this.length = length;
    }

    public Integer getLength() {
        return length;
    }

    public String shoot(Position position) {
        return "sunken";
    }
}
