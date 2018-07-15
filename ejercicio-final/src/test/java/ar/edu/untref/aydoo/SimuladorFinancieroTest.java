package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SimuladorFinancieroTest {

    private HashMap<TipoInversor, HashMap<Double, Integer>> tablaImpuesto;

    @Before
    public void precargarTablaImpuesto(){
        this.tablaImpuesto = new HashMap();
        HashMap<Double, Integer> tablaMontos = new HashMap();
        tablaImpuesto.put(TipoInversor.INDIVIDUO, tablaMontos);
    }

    @Test
    public void seObtieneLaGananciaDeUnPFTDebeRetornarCero() throws CampoIncorrectoExcepcion {

        SimuladorFinanciero simulador = new SimuladorFinanciero(tablaImpuesto);
        List<Inversion> inversiones = new ArrayList();
        Double monto = 10000d;
        Integer interes = 10;
        Integer plazoAcordado = 90;
        Inversion pft = new PlazoFijoTradicional(monto, interes, plazoAcordado);
        inversiones.add(pft);

        Double gananciaReal = simulador.obtenerGanancia(inversiones);
        Double gananciaEsperada = 0d;

        Assert.assertEquals(gananciaEsperada, gananciaReal, 0.1);
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
}
