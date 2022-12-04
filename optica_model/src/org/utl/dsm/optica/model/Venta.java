/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optica.model;

/**
 *
 * @author ivan
 */
public class Venta {
    private int idVenta;
    private int idEmpleado;
    private String clave;
    private Empleado empleado;

    public Venta() {
    }

    public Venta(int idEmpleado, String clave, Empleado empleado) {
        this.idEmpleado = idEmpleado;
        this.clave = clave;
        this.empleado = empleado;
    }

    public Venta(int idVenta, int idEmpleado, String clave, Empleado empleado) {
        this.idVenta = idVenta;
        this.idEmpleado = idEmpleado;
        this.clave = clave;
        this.empleado = empleado;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getClave() {
        return clave;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", idEmpleado=" + idEmpleado + ", clave=" + clave + ", empleado=" + empleado.toString() + '}';
    }
    
    
}
