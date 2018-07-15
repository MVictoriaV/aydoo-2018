package ar.edu.untref.aydoo;

import java.util.HashMap;
import java.util.List;

public class SimuladorFinanciero {

    private final HashMap<TipoInversor, HashMap<Double, Integer>> tablaImpuesto;

    public SimuladorFinanciero(HashMap<TipoInversor, HashMap<Double, Integer>> tablaImpuesto) {
        this.tablaImpuesto = tablaImpuesto;
    }

    public Double obtenerGanancia(List<Inversion> inversiones) {
        return 0d;
    }
}
