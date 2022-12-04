/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optica.model;

/**
 *
 * @author ivan
 */
public class Accesorio {
    private int idAccesorio;
    private int idProducto;
    private Producto producto;

    public Accesorio() {
    }

    public Accesorio(int idProducto, Producto producto) {
        this.idProducto = idProducto;
        this.producto = producto;
    }

    public Accesorio(int idAccesorio, int idProducto, Producto producto) {
        this.idAccesorio = idAccesorio;
        this.idProducto = idProducto;
        this.producto = producto;
    }

    public int getIdAccesorio() {
        return idAccesorio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setIdAccesorio(int idAccesorio) {
        this.idAccesorio = idAccesorio;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Accesorio{" + "idAccesorio=" + idAccesorio + ", idProducto=" + idProducto + ", producto=" + producto.toString() + '}';
    }
    
    
}
