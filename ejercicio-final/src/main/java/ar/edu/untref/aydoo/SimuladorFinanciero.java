package ar.edu.untref.aydoo;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class SimuladorFinanciero {

    private final Map<TipoInversor, TreeMap<Double, Integer>> tablaImpuesto;
    private static final Double CLAVE_DEFECTO_GANANCIA_MAX = -1d;

    public SimuladorFinanciero(Map<TipoInversor, TreeMap<Double, Integer>> tablaImpuesto) {
        this.tablaImpuesto = tablaImpuesto;
    }

    public Double obtenerGanancia(List<Inversion> inversiones) {
        Double gananciaTotal = 0d;
        for (Inversion inversion : inversiones) {
            gananciaTotal += inversion.calcularGanancia();
        }
        return gananciaTotal;
    }

    public Double aplicarImpuesto(TipoInversor tipoInversor, Double ganancia) {

        if (tablaImpuesto.containsKey(tipoInversor)) {
            Integer impuesto = this.obtenerImpuestoACobrar(tipoInversor, ganancia);

        }
        return 0d;
    }


    private Integer obtenerImpuestoACobrar(TipoInversor tipoInversor, Double ganancia) {
        Optional<Double> optional = tablaImpuesto.get(tipoInversor).keySet().stream().filter(montoLambda ->
                (ganancia < montoLambda)).findFirst();
        if (!optional.isPresent()) {
            return this.tablaImpuesto.get(tipoInversor).get(CLAVE_DEFECTO_GANANCIA_MAX);
        }
        return this.tablaImpuesto.get(tipoInversor).get(optional.get());
    }
}
