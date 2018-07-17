package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
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
        tablaMontos = cargarMontosEmpresa();
        tablaImpuesto.put(TipoInversor.EMPRESA, tablaMontos);
    }

    @Test
    public void seObtieneLaGananciaDeUnPFTDebeRetornarCero() throws CampoIncorrectoExcepcion, InversionInexistenExcepcion {

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
    public void seHaceUnaInversionPFTYSeObtieneUnaGananciaDe50000() throws CampoIncorrectoExcepcion, InversionInexistenExcepcion {

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
    public void noSeAplicaImpuestoAIndividuoCuandoSuGananciaEs5000() throws CampoIncorrectoExcepcion, InversionInexistenExcepcion, GananciaNegativaExcepcion {

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
    public void seAplicaImpuestoDel5PorcAIndividuoCuandoSuGananciaEs50000() throws CampoIncorrectoExcepcion, InversionInexistenExcepcion, GananciaNegativaExcepcion {

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

    @Test
    public void seAplicaImpuestoDel10PorcAEmpresaCuandoSuGananciaEs50000() throws CampoIncorrectoExcepcion, InversionInexistenExcepcion, GananciaNegativaExcepcion {

        SimuladorFinanciero simulador = new SimuladorFinanciero(tablaImpuesto);
        List<Inversion> inversiones = new ArrayList();
        Double monto = 500000d;
        Integer interes = 10;
        Integer plazoAcordado = 365;
        Inversion pft = new PlazoFijoTradicional(monto, interes, plazoAcordado);
        inversiones.add(pft);

        Double gananciaReal = simulador.obtenerGanancia(inversiones);
        Double gananciaEsperada = 50000d;

        Double impuestoReal = simulador.aplicarImpuesto(TipoInversor.EMPRESA, gananciaReal);
        Double impuestoEsperado = 5000d;

        Assert.assertEquals(gananciaEsperada, gananciaReal, 0.1);
        Assert.assertEquals(impuestoEsperado, impuestoReal, 0.1);
    }

    @Test
    public void cuandoGananciaEsCeroElImpuestoAplicadoTambienDebeSerlo() throws CampoIncorrectoExcepcion, GananciaNegativaExcepcion {

        SimuladorFinanciero simulador = new SimuladorFinanciero(tablaImpuesto);

        Double gananciaCero = 0d;

        Double impuestoReal = simulador.aplicarImpuesto(TipoInversor.EMPRESA, gananciaCero);
        Double impuestoEsperado = 0d;

        Assert.assertEquals(impuestoEsperado, impuestoReal, 0.1);
    }

    @Test(expected = InversionInexistenExcepcion.class)
    public void alQuererObtenerLaGananciaConInversionNulaDeberiaLanzarExcepcion() throws CampoIncorrectoExcepcion, InversionInexistenExcepcion {

        SimuladorFinanciero simulador = new SimuladorFinanciero(tablaImpuesto);
        List<Inversion> inversiones = null;

        simulador.obtenerGanancia(inversiones);
    }

    @Test(expected = GananciaNegativaExcepcion.class)
    public void alQuererObtenerElImpuestoConUnaGananciaMenos1DeberiaLanzarExcepcion() throws CampoIncorrectoExcepcion, InversionInexistenExcepcion, GananciaNegativaExcepcion {

        SimuladorFinanciero simulador = new SimuladorFinanciero(tablaImpuesto);

        Double gananciaNegativa = -1d;

        simulador.aplicarImpuesto(TipoInversor.EMPRESA, gananciaNegativa);
    }

    @Test
    public void seObtieneLaGananciaDeInversionDolarCeroCuandoLasCotizacionesSonIguales() throws CampoIncorrectoExcepcion, InversionInexistenExcepcion {

        SimuladorFinanciero simulador = new SimuladorFinanciero(tablaImpuesto);
        List<Inversion> inversiones = new ArrayList();
        Double monto = 1000d;
        Double cotizacionInicial = 20d;
        Double cotizacionFinal = 20d;

        Inversion inversionDolar = new Dolar(monto, cotizacionInicial, cotizacionFinal);
        inversiones.add(inversionDolar);

        Double gananciaReal = simulador.obtenerGanancia(inversiones);
        Double gananciaEsperada = 0d;

        Assert.assertEquals(gananciaEsperada, gananciaReal, 1);
    }

    @Test
    public void seInvierteEnDolaresDeberiaRetornarUnaGananciaDe400() throws CampoIncorrectoExcepcion, InversionInexistenExcepcion {

        SimuladorFinanciero simulador = new SimuladorFinanciero(tablaImpuesto);
        List<Inversion> inversiones = new ArrayList();
        Double monto = 1000d;
        Double cotizacionInicial = 20d;
        Double cotizacionFinal = 28d;

        Inversion inversionDolar = new Dolar(monto, cotizacionInicial, cotizacionFinal);
        inversiones.add(inversionDolar);

        Double gananciaReal = simulador.obtenerGanancia(inversiones);
        Double gananciaEsperada = 400d;

        Assert.assertEquals(gananciaEsperada, gananciaReal, 1);
    }

    @Test
    public void seObtieneLaGananciaDeUnPFPDebeRetornarCero() throws CampoIncorrectoExcepcion, InversionInexistenExcepcion {

        SimuladorFinanciero simulador = new SimuladorFinanciero(tablaImpuesto);
        List<Inversion> inversiones = new ArrayList();
        Double monto = 100d;
        Integer interes = 1;
        Integer plazoAcordado = 90;
        Integer plazoReal = 30;
        PlazoFijoTradicional pfp = new PlazoFijoPrecancelable(monto, interes, plazoAcordado, plazoReal);
        inversiones.add(pfp);

        Double gananciaReal = simulador.obtenerGanancia(inversiones);
        Double gananciaEsperada = 0d;

        Assert.assertEquals(gananciaEsperada, gananciaReal, 1);
    }

    @Test
    public void seObtieneLaSumatoriaDeLasGananciasDeLas3Inversiones() throws CampoIncorrectoExcepcion, InversionInexistenExcepcion {

        SimuladorFinanciero simulador = new SimuladorFinanciero(tablaImpuesto);
        List<Inversion> inversiones = new ArrayList();
        inversiones.add(crearInversionDolar(1000d));
        inversiones.add(crearInversionPlazoFijoTradicional(1000d));
        inversiones.add(crearInversionPlazoFijoPrecancelable(1000d));

        Double gananciaReal = simulador.obtenerGanancia(inversiones);
        Double gananciaEsperada = 350d;

        Assert.assertEquals(gananciaEsperada, gananciaReal, 0.1);
    }

    @Test
    public void seObtieneImpuesto0DeUnaGananciaInferiorSegunTablaImpuesto() throws CampoIncorrectoExcepcion, InversionInexistenExcepcion, GananciaNegativaExcepcion {

        SimuladorFinanciero simulador = new SimuladorFinanciero(tablaImpuesto);
        List<Inversion> inversiones = new ArrayList();
        inversiones.add(crearInversionDolar(1000d));
        inversiones.add(crearInversionPlazoFijoTradicional(1000d));
        inversiones.add(crearInversionPlazoFijoPrecancelable(1000d));

        Double gananciaReal = simulador.obtenerGanancia(inversiones);
        Double gananciaEsperada = 350d;

        Double impuestoReal = simulador.aplicarImpuesto(TipoInversor.INDIVIDUO, gananciaReal);
        Double impuestoEsperado = 0d;

        Assert.assertEquals(gananciaEsperada, gananciaReal, 0.1);
        Assert.assertEquals(impuestoEsperado, impuestoReal, 0.1);
    }

    @Test
    public void aplicaImpuestoDel5PorcAEmpresaCuandoSuGananciaEstaEntre20MilY50Mil() throws CampoIncorrectoExcepcion, InversionInexistenExcepcion, GananciaNegativaExcepcion {

        SimuladorFinanciero simulador = new SimuladorFinanciero(tablaImpuesto);
        List<Inversion> inversiones = new ArrayList();
        inversiones.add(crearInversionDolar(100000d));
        inversiones.add(crearInversionPlazoFijoTradicional(100000d));
        inversiones.add(crearInversionPlazoFijoPrecancelable(20000d));

        Double gananciaReal = simulador.obtenerGanancia(inversiones);
        Double gananciaEsperada = 31000d;

        Double impuestoReal = simulador.aplicarImpuesto(TipoInversor.EMPRESA, gananciaReal);
        Double impuestoEsperado = 1550d;

        Assert.assertEquals(gananciaEsperada, gananciaReal, 0.1);
        Assert.assertEquals(impuestoEsperado, impuestoReal, 0.1);
    }

    private TreeMap<Double, Integer> cargarMontosIndividuo() {
        TreeMap<Double, Integer> mapaMontos = new TreeMap();
        mapaMontos.put(50000d, 0);
        mapaMontos.put(100000d, 5);
        mapaMontos.put(500000d, 8);
        mapaMontos.put(-1d, 10);
        return mapaMontos;
    }

    private TreeMap<Double, Integer> cargarMontosEmpresa() {
        TreeMap<Double, Integer> mapaMontos = new TreeMap();
        mapaMontos.put(20000d, 0);
        mapaMontos.put(50000d, 5);
        mapaMontos.put(100000d, 10);
        mapaMontos.put(500000d, 15);
        mapaMontos.put(-1d, 20);
        return mapaMontos;
    }

    private Dolar crearInversionDolar(Double monto) throws CampoIncorrectoExcepcion {
        return new Dolar(monto, 20d, 24d);
    }

    private PlazoFijoTradicional crearInversionPlazoFijoTradicional(Double monto) throws CampoIncorrectoExcepcion {
        return new PlazoFijoTradicional(monto, 10, 365);
    }

    private PlazoFijoPrecancelable crearInversionPlazoFijoPrecancelable(Double monto) throws CampoIncorrectoExcepcion {
        return new PlazoFijoPrecancelable(monto, 10, 365, 300);
    }
}
