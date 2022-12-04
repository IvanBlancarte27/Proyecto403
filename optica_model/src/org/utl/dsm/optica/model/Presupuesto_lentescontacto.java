/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optica.model;

/**
 *
 * @author ivan
 */
public class Presupuesto_lentescontacto {
    private int idPresupuestoLentesContacto;
    private int idExamenVista;
    private int idLenteContacto;
    private String clave;
    private Examen_vista examen_vista;
    private Lente_contacto lente_contacto;

    public Presupuesto_lentescontacto() {
    }

    public Presupuesto_lentescontacto(int idExamenVista, int idLenteContacto, String clave, Examen_vista examen_vista, Lente_contacto lente_contacto) {
        this.idExamenVista = idExamenVista;
        this.idLenteContacto = idLenteContacto;
        this.clave = clave;
        this.examen_vista = examen_vista;
        this.lente_contacto = lente_contacto;
    }

    public Presupuesto_lentescontacto(int idPresupuestoLentesContacto, int idExamenVista, int idLenteContacto, String clave, Examen_vista examen_vista, Lente_contacto lente_contacto) {
        this.idPresupuestoLentesContacto = idPresupuestoLentesContacto;
        this.idExamenVista = idExamenVista;
        this.idLenteContacto = idLenteContacto;
        this.clave = clave;
        this.examen_vista = examen_vista;
        this.lente_contacto = lente_contacto;
    }

    public int getIdPresupuestoLentesContacto() {
        return idPresupuestoLentesContacto;
    }

    public int getIdExamenVista() {
        return idExamenVista;
    }

    public int getIdLenteContacto() {
        return idLenteContacto;
    }

    public String getClave() {
        return clave;
    }

    public Examen_vista getExamen_vista() {
        return examen_vista;
    }

    public Lente_contacto getLente_contacto() {
        return lente_contacto;
    }

    public void setIdPresupuestoLentesContacto(int idPresupuestoLentesContacto) {
        this.idPresupuestoLentesContacto = idPresupuestoLentesContacto;
    }

    public void setIdExamenVista(int idExamenVista) {
        this.idExamenVista = idExamenVista;
    }

    public void setIdLenteContacto(int idLenteContacto) {
        this.idLenteContacto = idLenteContacto;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setExamen_vista(Examen_vista examen_vista) {
        this.examen_vista = examen_vista;
    }

    public void setLente_contacto(Lente_contacto lente_contacto) {
        this.lente_contacto = lente_contacto;
    }

    @Override
    public String toString() {
        return "Presupuesto_lentescontacto{" + "idPresupuestoLentesContacto=" + idPresupuestoLentesContacto + ", idExamenVista=" + idExamenVista + ", idLenteContacto=" + idLenteContacto + ", clave=" + clave + ", examen_vista=" + examen_vista.toString() + ", lente_contacto=" + lente_contacto.toString() + '}';
    }
    
    
}
