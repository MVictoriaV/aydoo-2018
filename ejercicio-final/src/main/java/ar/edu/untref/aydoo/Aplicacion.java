package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Aplicacion {

    private static final String FORMATO_SIN_DECIMAL = "%.0f";

    public static final void main(final String[] args) {
        try {
            if (args == null || args.length == 0) {
                throw new Exception("Crear excepcion de sin argumentos");
            }
            String inversor = args[0];
            if (!(inversor.matches("ind|emp"))) {
                throw new Exception("Crear excepcion de una inversion");
            }
            List<Inversion> inversiones = new ArrayList();
            for (int i = 1; i < args.length; i++) {
                crearInversion(args[i], inversiones);
            }
            TipoInversor tipoInversor = inversor.matches("emp") ? TipoInversor.EMPRESA : TipoInversor.INDIVIDUO;
            SimuladorFinanciero simulador = crearSimuladorFinanciero();

            Double ganancias = simulador.obtenerGanancia(inversiones);
            Double impuesto = simulador.aplicarImpuesto(tipoInversor, ganancias);

            System.out.println("ganancia: " + aplicarFormatoSinDecimal(ganancias) + ", impuesto: " + aplicarFormatoSinDecimal(impuesto));

        } catch (Exception excepcion) {
            System.out.println(excepcion.getMessage());
        }
    }

    private static void crearInversion(String arg, List<Inversion> inversiones) throws CantidadArgumentosInvalidaExcepcion, CampoIncorrectoExcepcion, ValorInversionIncorrectoExcepcion, InversionInexistenExcepcion {
        String[] datosDeUnaInversion = arg.split(",");
        CreadorInversion creadorInversion = new CreadorInversion(datosDeUnaInversion);
        inversiones.add(creadorInversion.crear());
    }

    private static String aplicarFormatoSinDecimal(Double valor){
        return String.format(FORMATO_SIN_DECIMAL, valor);
    }

    private static SimuladorFinanciero crearSimuladorFinanciero() {
        Map<TipoInversor, TreeMap<Double, Integer>> tablaImpuesto = new TreeMap();
        TreeMap<Double, Integer> tablaMontos = cargarMontosIndividuo();
        tablaImpuesto.put(TipoInversor.INDIVIDUO, tablaMontos);
        tablaMontos = cargarMontosEmpresa();
        tablaImpuesto.put(TipoInversor.EMPRESA, tablaMontos);
        return new SimuladorFinanciero(tablaImpuesto);
    }

    private static TreeMap<Double, Integer> cargarMontosIndividuo() {
        TreeMap<Double, Integer> mapaMontos = new TreeMap();
        mapaMontos.put(50000d, 0);
        mapaMontos.put(100000d, 5);
        mapaMontos.put(500000d, 8);
        mapaMontos.put(-1d, 10);
        return mapaMontos;
    }

    private static TreeMap<Double, Integer> cargarMontosEmpresa() {
        TreeMap<Double, Integer> mapaMontos = new TreeMap();
        mapaMontos.put(20000d, 0);
        mapaMontos.put(50000d, 5);
        mapaMontos.put(100000d, 10);
        mapaMontos.put(500000d, 15);
        mapaMontos.put(-1d, 20);
        return mapaMontos;
    }
}