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

    public Double obtenerMontoComprasRealizadas(Integer anio) {

        Double montoDelAnio = 0d;
        for (Compra cadaCompra : ctaCte.getCompras()) {
            int anioDeLaCompra = Utils.obtenerAnio(cadaCompra.getFecha());
            if (anio == anioDeLaCompra) {
                Producto producto = cadaCompra.getProducto();
                if (contieneSuscripcion(producto)) {
                    montoDelAnio += (producto.getPrecioDeVenta() / Utils.SUSCRIPCION);
                } else {
                    montoDelAnio += producto.getPrecioDeVenta();
                }
            }
        }
        return montoDelAnio;
    }

    public boolean tieneSuscripcion() {
        return this.suscripciones.size() > 0;
    }

    public Double obtenerMontoComprasRealizadas(Integer mes, Integer anio) {
        Double montoDelMes = 0d;
        for (Compra cadaCompra : ctaCte.getCompras()) {
            int mesDeLaCompra = Utils.obtenerMes(cadaCompra.getFecha());
            int anioDeLaCompra = Utils.obtenerAnio(cadaCompra.getFecha());
            if (mes == mesDeLaCompra && anio == anioDeLaCompra) {
                Producto producto = cadaCompra.getProducto();
                if (contieneSuscripcion(producto)) {
                    montoDelMes += (producto.getPrecioDeVenta() / Utils.SUSCRIPCION);
                } else {
                    montoDelMes += producto.getPrecioDeVenta();
                }
            }
        }
        return montoDelMes;
    }
}
