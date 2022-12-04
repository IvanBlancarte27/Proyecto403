/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optica.model;

import java.util.Date;

/**
 *
 * @author ivan
 */
public class Examen_vista {
    private int idExamenVista;
    private String clave;
    private int idEmpleado;
    private int idCliente;
    private int idGraduacion;
    private Date fecha;
    private Empleado empleado;
    private Cliente cliente;
    private Graduacion graduacion;

    public Examen_vista() {
    }

    public Examen_vista(String clave, int idEmpleado, int idCliente, int idGraduacion, Date fecha, Empleado empleado, Cliente cliente, Graduacion graduacion) {
        this.clave = clave;
        this.idEmpleado = idEmpleado;
        this.idCliente = idCliente;
        this.idGraduacion = idGraduacion;
        this.fecha = fecha;
        this.empleado = empleado;
        this.cliente = cliente;
        this.graduacion = graduacion;
    }

    public Examen_vista(int idExamenVista, String clave, int idEmpleado, int idCliente, int idGraduacion, Date fecha, Empleado empleado, Cliente cliente, Graduacion graduacion) {
        this.idExamenVista = idExamenVista;
        this.clave = clave;
        this.idEmpleado = idEmpleado;
        this.idCliente = idCliente;
        this.idGraduacion = idGraduacion;
        this.fecha = fecha;
        this.empleado = empleado;
        this.cliente = cliente;
        this.graduacion = graduacion;
    }

    public int getIdExamenVista() {
        return idExamenVista;
    }

    public String getClave() {
        return clave;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdGraduacion() {
        return idGraduacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Graduacion getGraduacion() {
        return graduacion;
    }

    public void setIdExamenVista(int idExamenVista) {
        this.idExamenVista = idExamenVista;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdGraduacion(int idGraduacion) {
        this.idGraduacion = idGraduacion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setGraduacion(Graduacion graduacion) {
        this.graduacion = graduacion;
    }

    @Override
    public String toString() {
        return "Examen_vista{" + "idExamenVista=" + idExamenVista + ", clave=" + clave + ", idEmpleado=" + idEmpleado + ", idCliente=" + idCliente + ", idGraduacion=" + idGraduacion + ", fecha=" + fecha + ", empleado=" + empleado.toString() + ", cliente=" + cliente.toString() + ", graduacion=" + graduacion.toString() + '}';
    }
    
    
    
}   
