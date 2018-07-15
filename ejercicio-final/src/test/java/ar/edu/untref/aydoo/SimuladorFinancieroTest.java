package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
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
    public void seObtieneLaGananciaDeUnPFTDebeRetornarCero() {

        SimuladorFinanciero simulador = new SimuladorFinanciero(tablaImpuesto);
        List<Inversion> inversiones = new ArrayList();
        Double monto = 10000d;
        Inversion pft = new PlazoFijoTradicional(monto);
        inversiones.add(pft);

        Double gananciaReal = simulador.obtenerGanancia(inversiones);
        Double gananciaEsperada = 0d;

        Assert.assertEquals(gananciaEsperada, gananciaReal, 0.1);
    }
}
