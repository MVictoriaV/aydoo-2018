package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

    public Double obtenerMontoComprasRealizadas(Integer mes) {

        Double montoDelMes = 0d;
        for (Compra cadaCompra : ctaCte.getCompras()) {
            int mesDeLaCompra = obtenerMes(cadaCompra.getFecha());
            if (mes == mesDeLaCompra) {
                Producto producto = cadaCompra.getProducto();
                if (suscripciones.contains(producto)) {
                    montoDelMes += (producto.getPrecioDeVenta() / Utils.SUSCRIPCION);
                } else {
                    montoDelMes += producto.getPrecioDeVenta();
                }
            }
        }
        return montoDelMes;
    }

    private static int obtenerMes(Date fecha){
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        return cal.get(Calendar.MONTH) + 1;
    }
}
