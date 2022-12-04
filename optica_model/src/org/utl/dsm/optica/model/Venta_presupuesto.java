/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optica.model;

/**
 *
 * @author ivan
 */
public class Venta_presupuesto {
   private int idVenta;
   private int idPresupuesto;
   private int cantidad;
   private double precioUnitario;
   private double descuento;
   private Venta venta;
   private Presupuesto presupuesto;

    public Venta_presupuesto() {
    }

    public Venta_presupuesto(int idPresupuesto, int cantidad, double precioUnitario, double descuento, Venta venta, Presupuesto presupuesto) {
        this.idPresupuesto = idPresupuesto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.descuento = descuento;
        this.venta = venta;
        this.presupuesto = presupuesto;
    }

    public Venta_presupuesto(int idVenta, int idPresupuesto, int cantidad, double precioUnitario, double descuento, Venta venta, Presupuesto presupuesto) {
        this.idVenta = idVenta;
        this.idPresupuesto = idPresupuesto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.descuento = descuento;
        this.venta = venta;
        this.presupuesto = presupuesto;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public int getIdPresupuesto() {
        return idPresupuesto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public double getDescuento() {
        return descuento;
    }

    public Venta getVenta() {
        return venta;
    }

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public void setIdPresupuesto(int idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public void setPresupuesto(Presupuesto presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return "Venta_presupuesto{" + "idVenta=" + idVenta + ", idPresupuesto=" + idPresupuesto + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", descuento=" + descuento + ", venta=" + venta.toString() + ", presupuesto=" + presupuesto.toString() + '}';
    }
   
   
}
