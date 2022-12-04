/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optica.model;

/**
 *
 * @author ivan
 */
public class Cliente {
    private int idCliente;
    private String numeroUnico;
    private int estatus;
    private Persona persona;

    public Cliente() {
    }

    public Cliente(String numeroUnico, int estatus, Persona persona) {
        this.numeroUnico = numeroUnico;
        this.estatus = estatus;
        this.persona = persona;
    }

    public Cliente(int idCliente, String numeroUnico, int estatus, Persona persona) {
        this.idCliente = idCliente;
        this.numeroUnico = numeroUnico;
        this.estatus = estatus;
        this.persona = persona;
    }

    public int getIdCliente() {
        return idCliente;
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

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", numeroUnico=" + numeroUnico + ", estatus=" + estatus + ", persona=" + persona.toString() + '}';
    }
    
    
    
}
