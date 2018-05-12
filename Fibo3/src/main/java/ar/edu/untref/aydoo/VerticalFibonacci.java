package ar.edu.untref.aydoo;

import java.util.List;

public class VerticalFibonacci implements ShapeToFibonacci{

    @Override
    public String giveShape(List<Integer> succession) {
        StringBuffer out = new StringBuffer();
        for (Integer eachNumber : succession) {
            out.append("\n");
            out.append(eachNumber);
        }
        return out.toString();
    }
}
