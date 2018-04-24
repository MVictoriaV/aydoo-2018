package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class CuentaCorriente {

    private List<Compra> compras = new ArrayList<>();

    public List<Compra> getCompras() {
        return compras;
    }

    public void agregarCompra(Compra compra) {
        compras.add(compra);
    }
}
