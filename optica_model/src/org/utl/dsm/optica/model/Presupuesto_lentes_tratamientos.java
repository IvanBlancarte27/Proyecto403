/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optica.model;

/**
 *
 * @author ivan
 */
public class Presupuesto_lentes_tratamientos {
    private int idPresupuestoLentes;
    private int idTratamiento;
    private Presupuesto_lentes presupuesto_lentes;
    private Tratamiento tratamiento;

    public Presupuesto_lentes_tratamientos() {
    }

    public Presupuesto_lentes_tratamientos(int idTratamiento, Presupuesto_lentes presupuesto_lentes, Tratamiento tratamiento) {
        this.idTratamiento = idTratamiento;
        this.presupuesto_lentes = presupuesto_lentes;
        this.tratamiento = tratamiento;
    }

    public Presupuesto_lentes_tratamientos(int idPresupuestoLentes, int idTratamiento, Presupuesto_lentes presupuesto_lentes, Tratamiento tratamiento) {
        this.idPresupuestoLentes = idPresupuestoLentes;
        this.idTratamiento = idTratamiento;
        this.presupuesto_lentes = presupuesto_lentes;
        this.tratamiento = tratamiento;
    }

    public int getIdPresupuestoLentes() {
        return idPresupuestoLentes;
    }

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public Presupuesto_lentes getPresupuesto_lentes() {
        return presupuesto_lentes;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setIdPresupuestoLentes(int idPresupuestoLentes) {
        this.idPresupuestoLentes = idPresupuestoLentes;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public void setPresupuesto_lentes(Presupuesto_lentes presupuesto_lentes) {
        this.presupuesto_lentes = presupuesto_lentes;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    @Override
    public String toString() {
        return "Presupuesto_lentes_tratamientos{" + "idPresupuestoLentes=" + idPresupuestoLentes + ", idTratamiento=" + idTratamiento + ", presupuesto_lentes=" + presupuesto_lentes.toString() + ", tratamiento=" + tratamiento.toString() + '}';
    }
    
    
}
