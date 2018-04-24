package ar.edu.untref.aydoo;

import java.util.List;

public class Kiosco {

    private List<Producto> productos;
    private List<Cliente> clientes;

    public Kiosco (List<Producto> listadoDeProductos, List<Cliente> listadoDeClientes) {
        this.productos = listadoDeProductos;
        this.clientes = listadoDeClientes;
    }

    public boolean hayProductos(){
        return (productos.size() > 0);
    }

    public boolean agregarCliente(Cliente unCliente) {
        if (clientes.contains(unCliente)) {
            return false;
        }
        return clientes.add(unCliente);
    }

    public boolean hayClientes() {
        return (clientes.size() > 0);
    }
}
