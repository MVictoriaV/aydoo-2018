package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private DatosPersonales datosPersonales;
    private List<Producto> suscripciones;
    private CuentaCorriente ctaCte;

    public Cliente(DatosPersonales datosPersonales) {
        this.datosPersonales = datosPersonales;
        this.suscripciones = new ArrayList<>();
        this.ctaCte = new CuentaCorriente();
    }

    public Boolean asignarSuscripcion(Producto producto) {
        return this.suscripciones.add(producto);
    }

    public Boolean contieneSuscripcion(Producto producto) {
        return this.suscripciones.contains(producto);
    }

    public CuentaCorriente getCtaCte() {
        return ctaCte;
    }

    public void setCtaCte(CuentaCorriente ctaCte) {
        this.ctaCte = ctaCte;
    }
}
