/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optica.model;

/**
 *
 * @author ivan
 */
public class Presupuesto_lentes {
    private int idPresupuestoLentes;
    private int idPresupuesto;
    private int alturaOblea;
    private int idTipoMica;
    private int idMaterial;
    private int idArmazon;
    private Presupuesto presupuesto;
    private TipoMica tipoMica;
    private Material material;
    private Armazon armazon;

    public Presupuesto_lentes() {
    }

    public Presupuesto_lentes(int idPresupuesto, int alturaOblea, int idTipoMica, int idMaterial, int idArmazon, Presupuesto presupuesto, TipoMica tipoMica, Material material, Armazon armazon) {
        this.idPresupuesto = idPresupuesto;
        this.alturaOblea = alturaOblea;
        this.idTipoMica = idTipoMica;
        this.idMaterial = idMaterial;
        this.idArmazon = idArmazon;
        this.presupuesto = presupuesto;
        this.tipoMica = tipoMica;
        this.material = material;
        this.armazon = armazon;
    }

    public Presupuesto_lentes(int idPresupuestoLentes, int idPresupuesto, int alturaOblea, int idTipoMica, int idMaterial, int idArmazon, Presupuesto presupuesto, TipoMica tipoMica, Material material, Armazon armazon) {
        this.idPresupuestoLentes = idPresupuestoLentes;
        this.idPresupuesto = idPresupuesto;
        this.alturaOblea = alturaOblea;
        this.idTipoMica = idTipoMica;
        this.idMaterial = idMaterial;
        this.idArmazon = idArmazon;
        this.presupuesto = presupuesto;
        this.tipoMica = tipoMica;
        this.material = material;
        this.armazon = armazon;
    }

    public int getIdPresupuestoLentes() {
        return idPresupuestoLentes;
    }

    public int getIdPresupuesto() {
        return idPresupuesto;
    }

    public int getAlturaOblea() {
        return alturaOblea;
    }

    public int getIdTipoMica() {
        return idTipoMica;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public int getIdArmazon() {
        return idArmazon;
    }

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }

    public TipoMica getTipoMica() {
        return tipoMica;
    }

    public Material getMaterial() {
        return material;
    }

    public Armazon getArmazon() {
        return armazon;
    }

    public void setIdPresupuestoLentes(int idPresupuestoLentes) {
        this.idPresupuestoLentes = idPresupuestoLentes;
    }

    public void setIdPresupuesto(int idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public void setAlturaOblea(int alturaOblea) {
        this.alturaOblea = alturaOblea;
    }

    public void setIdTipoMica(int idTipoMica) {
        this.idTipoMica = idTipoMica;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public void setIdArmazon(int idArmazon) {
        this.idArmazon = idArmazon;
    }

    public void setPresupuesto(Presupuesto presupuesto) {
        this.presupuesto = presupuesto;
    }

    public void setTipoMica(TipoMica tipoMica) {
        this.tipoMica = tipoMica;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setArmazon(Armazon armazon) {
        this.armazon = armazon;
    }

    @Override
    public String toString() {
        return "Presupuesto_lentes{" + "idPresupuestoLentes=" + idPresupuestoLentes + ", idPresupuesto=" + idPresupuesto + ", alturaOblea=" + alturaOblea + ", idTipoMica=" + idTipoMica + ", idMaterial=" + idMaterial + ", idArmazon=" + idArmazon + ", presupuesto=" + presupuesto.toString() + ", tipoMica=" + tipoMica.toString() + ", material=" + material.toString() + ", armazon=" + armazon.toString() + '}';
    }
    
    
    
}
