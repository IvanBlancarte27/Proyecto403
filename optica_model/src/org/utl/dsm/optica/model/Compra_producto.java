/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optica.model;

/**
 *
 * @author ivan
 */
public class Compra_producto {
    private int idCompra;
    private int idProducto;
    private double precioUnitario;
    private int cantidad;
    private Compra compra;
    private Producto producto;

    public Compra_producto() {
    }

    public Compra_producto(int idProducto, double precioUnitario, int cantidad, Compra compra, Producto producto) {
        this.idProducto = idProducto;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.compra = compra;
        this.producto = producto;
    }

    public Compra_producto(int idCompra, int idProducto, double precioUnitario, int cantidad, Compra compra, Producto producto) {
        this.idCompra = idCompra;
        this.idProducto = idProducto;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.compra = compra;
        this.producto = producto;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Compra getCompra() {
        return compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Compra_producto{" + "idCompra=" + idCompra + ", idProducto=" + idProducto + ", precioUnitario=" + precioUnitario + ", cantidad=" + cantidad + ", compra=" + compra.toString() + ", producto=" + producto.toString() + '}';
    }
    
    
}
