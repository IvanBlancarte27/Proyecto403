/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optica.model;

/**
 *
 * @author ivan
 */
public class Compra {
    private int idCompra;
    private int idEmpleado;
    private Empleado empleado;

    public Compra() {
    }

    public Compra(int idEmpleado, Empleado empleado) {
        this.idEmpleado = idEmpleado;
        this.empleado = empleado;
    }

    public Compra(int idCompra, int idEmpleado, Empleado empleado) {
        this.idCompra = idCompra;
        this.idEmpleado = idEmpleado;
        this.empleado = empleado;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Compra{" + "idCompra=" + idCompra + ", idEmpleado=" + idEmpleado + ", empleado=" + empleado.toString() + '}';
    }
    
    
}
