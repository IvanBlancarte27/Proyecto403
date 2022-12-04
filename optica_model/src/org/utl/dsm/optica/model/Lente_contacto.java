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
public class Lente_contacto {
    private int idLenteContacto;
    private int keratometria;
    private String fotografia;
    private Producto producto;

    public Lente_contacto() {
    }

    public Lente_contacto(int keratometria, String fotografia, Producto producto) {
        this.keratometria = keratometria;
        this.fotografia = fotografia;
        this.producto = producto;
    }

    public Lente_contacto(int idLenteContacto, int keratometria, String fotografia, Producto producto) {
        this.idLenteContacto = idLenteContacto;
        this.keratometria = keratometria;
        this.fotografia = fotografia;
        this.producto = producto;
    }

    public int getIdLenteContacto() {
        return idLenteContacto;
    }

    public int getKeratometria() {
        return keratometria;
    }

    public String getFotografia() {
        return fotografia;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setIdLenteContacto(int idLenteContacto) {
        this.idLenteContacto = idLenteContacto;
    }

    public void setKeratometria(int keratometria) {
        this.keratometria = keratometria;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Lente_contacto{" + "idLenteContacto=" + idLenteContacto+" " + ", keratometria=" + keratometria + ", fotografia=" + fotografia + ", producto=" + producto.toString() + '}';
    }
    
    
}
