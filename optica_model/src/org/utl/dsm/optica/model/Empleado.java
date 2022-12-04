/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optica.model;

/**
 *
 * @author ivan
 */
public class Empleado{
    private int idEmpleado;
    private String numeroUnico;
    private int estatus;
    private Usuario usuario;
    private Persona persona;

    public Empleado() {
    }

    public Empleado(String numeroUnico, int estatus, Usuario usuario, Persona persona) {
        this.numeroUnico = numeroUnico;
        this.estatus = estatus;
        this.usuario=usuario;
        this.persona = persona;
    }

    public Empleado(int idEmpleado, String numeroUnico, int estatus, Usuario usuario, Persona persona) {
        this.idEmpleado = idEmpleado;
        this.numeroUnico = numeroUnico;
        this.estatus = estatus;
        this.usuario=usuario;
        this.persona = persona;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getNumeroUnico() {
        return numeroUnico;
    }

    public int getEstatus() {
        return estatus;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setNumeroUnico(String numeroUnico) {
        this.numeroUnico = numeroUnico;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }


    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", numeroUnico=" + numeroUnico + ", estatus=" + estatus + ", usuario=" + usuario.toString() + ", persona=" + persona.toString() + '}';
    }

    
    
    
    
    
}
