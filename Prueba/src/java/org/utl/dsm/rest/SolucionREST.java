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
import org.utl.dsm.optica.controller.ControllerSoluciones;
import java.sql.SQLException;
import java.util.List;
import org.utl.dsm.optica.model.Solucion;
/**
 *
 * @author daian
 */
@Path("solucion")

public class SolucionREST extends Application{
    @Path("insertarsolucion")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertarsolucion(@FormParam("datos")@DefaultValue("")  String datos){
        Gson gson=new Gson();
        Solucion s=new Solucion();
        s=gson.fromJson(datos, Solucion.class);
        String out="";
        ControllerSoluciones objCE=new ControllerSoluciones();
        try {
            objCE.insertasoluciones(s);
            out=gson.toJson(s);
        } catch (SQLException ex) {
           out="{\"result\":\""+ex.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
         
    }
    @Path("getAll")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll (@FormParam("estatus") @DefaultValue("1") String estatus){
        String out="";
        try {
            
            ControllerSoluciones CE=new ControllerSoluciones();
            List<Solucion> soluciones=CE.getAll(estatus);
            Gson gs=new Gson();
            out=gs.toJson(soluciones);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            out="{\"error\":\""+ex.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    @Path("getAll2")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll2 (@FormParam("estatus") @DefaultValue("0") String estatus){
        String out="";
        try {
            
            ControllerSoluciones CE=new ControllerSoluciones();
            List<Solucion> soluciones=CE.getAll(estatus);
            Gson gs=new Gson();
            out=gs.toJson(soluciones);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            out="{\"error\":\""+ex.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
     @Path("eliminarsolucion")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response eli(@FormParam("datos") @DefaultValue("") String datos){
        Gson gson = new Gson();
        Solucion solucion = new Solucion();
        //El punto class es la especificacion que contiene la clase
        solucion = gson.fromJson(datos, Solucion.class);
        String out = "";
        ControllerSoluciones objCE = new ControllerSoluciones();
        try {
            objCE.eliminarSoluciones(solucion);
            out = gson.toJson(solucion);
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
    
    @Path("modificarsoluciones")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response modificar(@FormParam("datos")  @DefaultValue("") String datos){
        Gson gson= new Gson();
        Solucion solucion=new Solucion();
        solucion= gson.fromJson(datos, Solucion.class);
        String out="";
        ControllerSoluciones objCE=new ControllerSoluciones();
        try {
            
            objCE.modificar(solucion);
            out=gson.toJson(solucion);
        }
        catch(JsonParseException jpe){
            out="""
                {\"result\":\"se cambio\"}
                  """;  
        }
         catch (Exception ex) {
            
         
            out="{\"result\":\""+ex.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
        
    }
     @Path("Buscar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscar(@QueryParam("buscar") @DefaultValue("ma") String buscar){
        String out="";
        try {
            ControllerSoluciones cliente = new ControllerSoluciones();
            List<Solucion>soluciones= cliente.Buscar(buscar);
            Gson gs = new Gson();
            out = gs.toJson(soluciones);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            //Poner diagonal inversa Alt+92
            out="{\"error\":\""+ex.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    
}
