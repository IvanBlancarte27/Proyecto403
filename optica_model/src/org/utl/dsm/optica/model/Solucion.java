/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optica.model;

/**
 *
 * @author ivan
 */
public class Solucion {
    private int idSolucion;
    private int idProducto;
    private Producto producto;

    public Solucion() {
    }

    public Solucion(int idProducto, Producto producto) {
        this.idProducto = idProducto;
        this.producto = producto;
    }

    public Solucion(int idSolucion, int idProducto, Producto producto) {
        this.idSolucion = idSolucion;
        this.idProducto = idProducto;
        this.producto = producto;
    }

    public int getIdSolucion() {
        return idSolucion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setIdSolucion(int idSolucion) {
        this.idSolucion = idSolucion;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Solucion{" + "idSolucion=" + idSolucion + ", idProducto=" + idProducto + ", producto=" + producto.toString() + '}';
    }
    
    
}
