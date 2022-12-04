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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.utl.dsm.optica.controller.ControllerLentesDeContacto;
import org.utl.dsm.optica.model.Lente_contacto;

@Path("lentesC")
public class LentesContactoRest extends Application {

    @Path("insertarLente")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response InsertarLenteDeContacto(@FormParam("datos") @DefaultValue("") String datos) {
        Gson gson = new Gson();
        Lente_contacto lente_contacto = new Lente_contacto();

        lente_contacto = gson.fromJson(datos, Lente_contacto.class);
        String out = "";
        ControllerLentesDeContacto ctLentes = new ControllerLentesDeContacto();

        try {
            ctLentes.insertarLenteContacto(lente_contacto);
            out = gson.toJson(lente_contacto);
        } catch (JsonParseException jex) {
            out = """
                   {"error": "Error de formato"}
                   """;
        } catch (SQLException ex) {
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("getAllActivos")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@FormParam("estatus") @DefaultValue("1") String estatus) {
        String out = "";
        try {

            ControllerLentesDeContacto cldc = new ControllerLentesDeContacto();
            List<Lente_contacto> lente_contactos = cldc.getAllAcLentes(estatus);
            Gson gson = new Gson();
            out = gson.toJson(lente_contactos);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("getAllInactivos")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllInactivos(@FormParam("estatus") @DefaultValue("0") String estatus) {
        String out = "";
        try {

            ControllerLentesDeContacto cldc = new ControllerLentesDeContacto();
            List<Lente_contacto> lente_contactos = cldc.getAllAcLentes(estatus);
            Gson gson = new Gson();
            out = gson.toJson(lente_contactos);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    
    @Path("actualizarLentes")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarLenteDeContacto(@FormParam("datos") @DefaultValue("") String datos) {
        Gson gson = new Gson();
        Lente_contacto lente_contacto = new Lente_contacto();

        lente_contacto = gson.fromJson(datos, Lente_contacto.class);
        String out = "";
        ControllerLentesDeContacto ctLentes = new ControllerLentesDeContacto();

        try {
            ctLentes.actualizarLentesDeContacto(lente_contacto);
            out = gson.toJson(lente_contacto);
        } catch (JsonParseException jex) {
            out = """
                   {"error": "Error de formato"}
                   """;
        } catch (SQLException ex) {
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("eliminar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
       public Response eliminar(@FormParam("datos") @DefaultValue("") String datos){
        Gson gson = new Gson();
        Lente_contacto lente_contacto = new Lente_contacto();
        //El punto class es la especificacion que contiene la clase
        lente_contacto = gson.fromJson(datos, Lente_contacto.class);
        String out = "";
        ControllerLentesDeContacto controllerLentesDeContacto = new ControllerLentesDeContacto();
        try {
            controllerLentesDeContacto.eliminarLentes(lente_contacto);
            out = gson.toJson(lente_contacto);
        } catch (JsonParseException jpe) {
            out = """
                   {"error": "Error de formato"}
                   """;
        } catch (SQLException ex) {

            out = "{\"error\":\"" + ex.toString() + "\"}";

        }

        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("buscar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarAccesorio(@QueryParam("busqueda") @DefaultValue("estuche") String busqueda) {
        String out = "";
        try {
            ControllerLentesDeContacto cldc = new ControllerLentesDeContacto();
            List<Lente_contacto> lente_contactos = cldc.searchLentesCon(busqueda);
            Gson gson = new Gson();
            out = gson.toJson(lente_contactos);
        } catch (Exception ex) {
            System.out.println(ex.toString());

            out = "{\"error\":\"" + ex.toString() + "\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
}
