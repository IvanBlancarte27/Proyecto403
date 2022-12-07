/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.utl.dsm.optica.controller;

import org.utl.dsm.optica.db.ConexionMySQL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.plaf.metal.MetalIconFactory;
import org.utl.dsm.optica.model.Accesorio;
import org.utl.dsm.optica.model.Cliente;
import org.utl.dsm.optica.model.Empleado;
import org.utl.dsm.optica.model.Lente_contacto;
import org.utl.dsm.optica.model.Persona;
import org.utl.dsm.optica.model.Producto;
import org.utl.dsm.optica.model.Usuario;

/**
 *
 * @author ivanb
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        probarConexion();
        //probarInsert();
        //probarGetAll();
        //probarActualizar();
        //probarCambiarEstatus();
        //probarInsertarAccesorios();
        //probarActualizarAccesorio();
        //probarEliminarAccesorio();
        //probarInsertarLentes();
        //probarActualizarLentes();
        //probarInsertarCliente();
    }

    public static void probarConexion() {
        try {
            //Creamos un objeto de la clase creada
            ConexionMySQL objConexion = new ConexionMySQL();
            Connection conexion = objConexion.open();
            System.out.println(conexion.toString());
            conexion.close();

        } catch (SQLException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void probarInsert() {
        //1. Crear un objeto de persona y cargarlo
        Persona persona = new Persona("Ivan", "Blancarte", "Aguayo", "H", "09/04/2022", "Hermenegildo Bustos", "921",
                "Jardines de la Pradera", "37680", "Leon", "Guanajuato", "4771189966", "4771253695",
                "iblancarte583@gmail.com");
        //Se puede crear el objeto y cargarlo en el constructor o parametro

        //2. Crear el objeto de usuario y cargarlo
        Usuario usuario = new Usuario();
        usuario.setNombre("Ivan23");
        usuario.setContrasenia("admin");
        usuario.setRol("Empleado");

        //3. Creamos el objeto de Empleado 
        Empleado empleado = new Empleado();
        empleado.setPersona(persona);
        empleado.setUsuario(usuario);

        //System.out.println(empleado.toString());
        //4. Invocar el metodo de insercion del Empleado
        ControllerEmpleado objCE = new ControllerEmpleado();
        try {
            objCE.insertEmpleado(empleado);
            //Una Exeption es un posible error
        } catch (SQLException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(empleado.toString());
    }

    public static void probarGetAll() {
        try {
            ControllerEmpleado cmEmpleado = new ControllerEmpleado();
            List<Empleado> empleados = cmEmpleado.getAll("1");
            for (int i = 0; i < empleados.size(); i++) {
                System.out.println(empleados.get(i).toString());
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public static void probarActualizar() {
        Persona p = new Persona(1, "Ivaan", "Blancarte", "Ramos", "H", "2003-10-10", "Independendia", "312", "Loza", "37680", "Leon", "Guadalajara", "4771189966", "47789635", "jaime23@gmail.com");
        Usuario u = new Usuario(1, 0, "Ivannn", "123456", "Cliente", "", "");

        Empleado e = new Empleado();
        e.setIdEmpleado(1);
        try {
            e.setPersona(p);
            e.setUsuario(u);

            ControllerEmpleado ce = new ControllerEmpleado();
            ce.actualizarEmpleado(e);
        } catch (SQLException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(e.toString());

    }

    public static void probarCambiarEstatus() {
        Usuario us = new Usuario();
        Persona p = new Persona();

        Empleado em = new Empleado(6, "", 0, us, p);

        ControllerEmpleado con = new ControllerEmpleado();
        try {
            con.Eliminar(em);
        } catch (SQLException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(em.toString());
    }

    public static void probarInsertarAccesorios() {

        Producto producto = new Producto("", "Estuche", "Fendi", 1000, 1500, 8, 1);
        Accesorio accesorio = new Accesorio();
        accesorio.setProducto(producto);
        ControllerAccesorios ctrAccesorios = new ControllerAccesorios();

        try {
            ctrAccesorios.insertAccesorios(accesorio);
        } catch (SQLException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(accesorio.toString());
    }

    public static void probarActualizarAccesorio() throws SQLException {
        Producto producto = new Producto(2, "", "Gomas Ats", "Versace", 1200, 1700, 40, 1);
        Accesorio accesorio = new Accesorio(2, producto);

        ControllerAccesorios ca = new ControllerAccesorios();
        ca.actualizarAccesorio(accesorio);

        System.out.println(accesorio.toString());
    }

    public static void probarEliminarAccesorio() {
        Producto p = new Producto(5, "", "", "", 0, 0, 0, 0);
        Accesorio a = new Accesorio();

        a.setProducto(p);
        ControllerAccesorios ca = new ControllerAccesorios();

        try {
            ca.Eliminar(a);
        } catch (SQLException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(a.toString());
    }

    public static void probarInsertarLentes() {
        Producto p = new Producto("", "CooperVision", "OptiFlow", 1500, 2300, 47, 1);
        Lente_contacto l = new Lente_contacto(5, "https://drive.google.com/file/d/1hvMUjAJkigmjN3JR8PGdPrtYILH_2n4R/view?usp=share_link", p);
        ControllerLentesDeContacto cldc = new ControllerLentesDeContacto();

        try {
            cldc.insertarLenteContacto(l);
        } catch (SQLException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(l.toString());
    }

    public static void probarActualizarLentes() {
        Producto p = new Producto(7, "", "OptiFlow", "Gucci", 1500, 1580, 47, 1);
        Lente_contacto l = new Lente_contacto(1, 5, "https://drive.google.com/file/d/1d2NOrYFvoUrQEXPKZvYwzEiVISq1drDk/view?usp=share_link", p);

        ControllerLentesDeContacto cldc = new ControllerLentesDeContacto();
        try {
            cldc.actualizarLentesDeContacto(l);
        } catch (SQLException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(l.toString());
    }

    public static void probarInsertarCliente() {
       
        Persona persona = new Persona("Alexi", "Aguayo", "Ramos", "H", "27/02/2003", "Independendia", "312", "Loza", "37680", "Leon", "Guadalajara", "4771189966", "47789635", "jaime23@gmail.com");
        Cliente c = new Cliente("", 0, persona);
        
        ControllerClientes cc = new ControllerClientes();
        
        try {
            cc.insertCliente(c);
        } catch (SQLException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(c.toString());
    }

}
