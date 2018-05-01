package ar.edu.untref.aydoo;

import java.util.List;

public class HorizontalFibonacci implements ShapeToFibonacci {

    @Override
    public String giveShape(List<Integer> succession) {
        StringBuffer out = new StringBuffer();
        for (Integer eachNumber : succession) {
            out.append(" ").append(eachNumber);
        }
        return out.toString();
    }
}
