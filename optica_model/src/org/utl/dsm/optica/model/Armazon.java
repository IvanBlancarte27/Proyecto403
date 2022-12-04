/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optica.model;

import javax.swing.Icon;

/**
 *
 * @author ivan
 */
public class Armazon {
    private int idArmazon;
    private int idProducto;
    private String modelo;
    private String color;
    private String dimensiones;
    private String descripcion;
    private Icon fotografia;
    private Producto producto;

    public Armazon() {
    }

    public Armazon(int idProducto, String modelo, String color, String dimensiones, String descripcion, Icon fotografia, Producto producto) {
        this.idProducto = idProducto;
        this.modelo = modelo;
        this.color = color;
        this.dimensiones = dimensiones;
        this.descripcion = descripcion;
        this.fotografia = fotografia;
        this.producto = producto;
    }

    public Armazon(int idArmazon, int idProducto, String modelo, String color, String dimensiones, String descripcion, Icon fotografia, Producto producto) {
        this.idArmazon = idArmazon;
        this.idProducto = idProducto;
        this.modelo = modelo;
        this.color = color;
        this.dimensiones = dimensiones;
        this.descripcion = descripcion;
        this.fotografia = fotografia;
        this.producto = producto;
    }

    public int getIdArmazon() {
        return idArmazon;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Icon getFotografia() {
        return fotografia;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setIdArmazon(int idArmazon) {
        this.idArmazon = idArmazon;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFotografia(Icon fotografia) {
        this.fotografia = fotografia;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Armazon{" + "idArmazon=" + idArmazon + ", idProducto=" + idProducto + ", modelo=" + modelo + ", color=" + color + ", dimensiones=" + dimensiones + ", descripcion=" + descripcion + ", fotografia=" + fotografia + ", producto=" + producto.toString() + '}';
    }

    
    
    
    
    
}
