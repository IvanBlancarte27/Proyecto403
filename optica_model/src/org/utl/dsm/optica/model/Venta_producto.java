/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optica.model;

/**
 *
 * @author ivan
 */
public class Venta_producto {
    private int idVenta;
    private int idProducto;
    private int cantidad;
    private double precioUnitario;
    private double descuento;
    private Venta venta;
    private Producto producto;

    public Venta_producto() {
    }

    public Venta_producto(int idProducto, int cantidad, double precioUnitario, double descuento, Venta venta, Producto producto) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.descuento = descuento;
        this.venta = venta;
        this.producto = producto;
    }

    public Venta_producto(int idVenta, int idProducto, int cantidad, double precioUnitario, double descuento, Venta venta, Producto producto) {
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.descuento = descuento;
        this.venta = venta;
        this.producto = producto;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public double getDescuento() {
        return descuento;
    }

    public Venta getVenta() {
        return venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Venta_producto{" + "idVenta=" + idVenta + ", idProducto=" + idProducto + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", descuento=" + descuento + ", venta=" + venta.toString() + ", producto=" + producto.toString() + '}';
    }
    
    
    
}
