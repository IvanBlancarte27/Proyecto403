/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.rest;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import org.utl.dsm.optica.controller.ControllerEmpleado;
import org.utl.dsm.optica.model.Empleado;

@Path("empleado")
public class EmpleadoRest extends Application {

    @Path("insertar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertar(@FormParam("datos") @DefaultValue("") String datos){
        Gson gson = new Gson();
        Empleado empleado = new Empleado();
        //El punto class es la especificacion que contiene la clase
        empleado = gson.fromJson(datos, Empleado.class);
        String out = "";
        ControllerEmpleado objCE = new ControllerEmpleado();
        try {
            objCE.insertEmpleado(empleado);
            out = gson.toJson(empleado);
        } 
        catch(JsonParseException jpe){
            out = """
                   {"error": "Error de formato"}
                   """;
        }
        catch (SQLException ex) {
             
             out = "{\"error\":\""+ex.toString()+"\"}";
           
        }

        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAll")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@FormParam("estatus") @DefaultValue("1") String estatus){
        String out="";
        try {
            ControllerEmpleado cmEmpleado = new ControllerEmpleado();
            List<Empleado> empleados = cmEmpleado.getAll(estatus);
            Gson gs = new Gson();
            out = gs.toJson(empleados);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            //Poner diagonal inversa Alt+92
            out="{\"error\":\""+ex.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAllInactivos")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllInactivos(@FormParam("estatus") @DefaultValue("0") String estatus){
        String out="";
        try {
            ControllerEmpleado cmEmpleado = new ControllerEmpleado();
            List<Empleado> empleados = cmEmpleado.getAll(estatus);
            Gson gs = new Gson();
            out = gs.toJson(empleados);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            //Poner diagonal inversa Alt+92
            out="{\"error\":\""+ex.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    
    @Path("Actualizar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(@FormParam("datos") @DefaultValue("") String datos){
        Gson gson = new Gson();
        Empleado empleado = new Empleado();
        //El punto class es la especificacion que contiene la clase
        empleado = gson.fromJson(datos, Empleado.class);
        String out = "";
        ControllerEmpleado objCE = new ControllerEmpleado();
        try {
            objCE.actualizarEmpleado(empleado);
            out = gson.toJson(empleado);
        } 
        catch(JsonParseException jpe){
            out = """
                   {"error": "Error de formato"}
                   """;
        }
        catch (SQLException ex) {
             
             out = "{\"error\":\""+ex.toString()+"\"}";
           
        }

        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("Eliminar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@FormParam("datos") @DefaultValue("") String datos){
        Gson gson = new Gson();
        Empleado empleado = new Empleado();
        //El punto class es la especificacion que contiene la clase
        empleado = gson.fromJson(datos, Empleado.class);
        String out = "";
        ControllerEmpleado objCE = new ControllerEmpleado();
        try {
            objCE.Eliminar(empleado);
            out = gson.toJson(empleado);
        } 
        catch(JsonParseException jpe){
            out = """
                   {"error": "Error de formato"}
                   """;
        }
        catch (SQLException ex) {
             
             out = "{\"error\":\""+ex.toString()+"\"}";
           
        }

        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("buscar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscar(@QueryParam("busqueda") @DefaultValue("ivan") String busqueda){
        String out="";
        try {
            ControllerEmpleado cmEmpleado = new ControllerEmpleado();
            List<Empleado> empleados = cmEmpleado.search(busqueda);
            Gson gs = new Gson();
            out = gs.toJson(empleados);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            //Poner diagonal inversa Alt+92
            out="{\"error\":\""+ex.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    
}

