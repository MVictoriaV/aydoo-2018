package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SimuladorFinancieroTest {

    private Map<TipoInversor, TreeMap<Double, Integer>> tablaImpuesto;

    @Before
    public void precargarTablaImpuesto(){
        this.tablaImpuesto = new TreeMap();
        TreeMap<Double, Integer> tablaMontos = cargarMontosIndividuo();
        tablaImpuesto.put(TipoInversor.INDIVIDUO, tablaMontos);
    }

    @Test
    public void seObtieneLaGananciaDeUnPFTDebeRetornarCero() throws CampoIncorrectoExcepcion {

        SimuladorFinanciero simulador = new SimuladorFinanciero(tablaImpuesto);
        List<Inversion> inversiones = new ArrayList();
        Double monto = 1000d;
        Integer interes = 2;
        Integer plazoAcordado = 10;
        Inversion pft = new PlazoFijoTradicional(monto, interes, plazoAcordado);
        inversiones.add(pft);

        Double gananciaReal = simulador.obtenerGanancia(inversiones);
        Double gananciaEsperada = 0d;

        Assert.assertEquals(gananciaEsperada, gananciaReal, 1);
    }

    @Test
    public void seHaceUnaInversionPFTYSeObtieneUnaGananciaDe50000() throws CampoIncorrectoExcepcion {

        SimuladorFinanciero simulador = new SimuladorFinanciero(tablaImpuesto);
        List<Inversion> inversiones = new ArrayList();
        Double monto = 500000d;
        Integer interes = 10;
        Integer plazoAcordado = 365;
        Inversion pft = new PlazoFijoTradicional(monto, interes, plazoAcordado);
        inversiones.add(pft);

        Double gananciaReal = simulador.obtenerGanancia(inversiones);
        Double gananciaEsperada = 50000d;

        Assert.assertEquals(gananciaEsperada, gananciaReal, 0.1);
    }

    @Test
    public void noSeAplicaImpuestoAIndividuoCuandoSuGananciaEs5000() throws CampoIncorrectoExcepcion {

        SimuladorFinanciero simulador = new SimuladorFinanciero(tablaImpuesto);
        List<Inversion> inversiones = new ArrayList();
        Double monto = 50000d;
        Integer interes = 10;
        Integer plazoAcordado = 365;
        Inversion pft = new PlazoFijoTradicional(monto, interes, plazoAcordado);
        inversiones.add(pft);

        Double gananciaReal = simulador.obtenerGanancia(inversiones);
        Double gananciaEsperada = 5000d;

        Double impuestoReal = simulador.aplicarImpuesto(TipoInversor.INDIVIDUO, gananciaReal);
        Double impuestoEsperado = 0d;

        Assert.assertEquals(gananciaEsperada, gananciaReal, 0.1);
        Assert.assertEquals(impuestoEsperado, impuestoReal, 0.1);
    }

    @Test
    public void seAplicaImpuestoDel5PorcAIndividuoCuandoSuGananciaEs50000() throws CampoIncorrectoExcepcion {

        SimuladorFinanciero simulador = new SimuladorFinanciero(tablaImpuesto);
        List<Inversion> inversiones = new ArrayList();
        Double monto = 500000d;
        Integer interes = 10;
        Integer plazoAcordado = 365;
        Inversion pft = new PlazoFijoTradicional(monto, interes, plazoAcordado);
        inversiones.add(pft);

        Double gananciaReal = simulador.obtenerGanancia(inversiones);
        Double gananciaEsperada = 50000d;

        Double impuestoReal = simulador.aplicarImpuesto(TipoInversor.INDIVIDUO, gananciaReal);
        Double impuestoEsperado = 2500d;

        Assert.assertEquals(gananciaEsperada, gananciaReal, 0.1);
        Assert.assertEquals(impuestoEsperado, impuestoReal, 0.1);
    }

    private TreeMap<Double, Integer> cargarMontosIndividuo() {
        TreeMap<Double, Integer> mapaMontos = new TreeMap();
        mapaMontos.put(50000d, 0);
        mapaMontos.put(1000000d, 5);
        mapaMontos.put(5000000d, 8);
        mapaMontos.put(-1d, 10);
        return mapaMontos;
    }
}
