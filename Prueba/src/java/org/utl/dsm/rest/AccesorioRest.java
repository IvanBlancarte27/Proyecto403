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
import org.utl.dsm.optica.controller.ControllerAccesorios;
import org.utl.dsm.optica.model.Accesorio;

@Path("Accesorios")
public class AccesorioRest extends Application {

    @Path("insertar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertarAccesorio(@FormParam("datos") @DefaultValue("") String datos) {
        Gson gson = new Gson();
        Accesorio accesorio = new Accesorio();

        accesorio = gson.fromJson(datos, Accesorio.class);
        String out = "";
        ControllerAccesorios coAccesorios = new ControllerAccesorios();

        try {
            coAccesorios.insertAccesorios(accesorio);
            out = gson.toJson(accesorio);
        } catch (JsonParseException jpe) {
            out = """
                   {"error": "Error de formato"}
                   """;
        } catch (SQLException ex) {
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }

        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("getAllAc")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@FormParam("estatus") @DefaultValue("1") String estatus) {
        String out = "";
        try {
            ControllerAccesorios controllerAccesorios = new ControllerAccesorios();
            List<Accesorio> accesorios = controllerAccesorios.getAllAc(estatus);
            Gson gs = new Gson();
            out = gs.toJson(accesorios);
        } catch (Exception e) {
            System.out.println(e.toString());
            out = "{\"error\":\"" + e.toString() + "\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("getAllInactivos")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllInactivos(@FormParam("estatus") @DefaultValue("0") String estatus) {
        String out = "";
        try {
            ControllerAccesorios controllerAccesorios = new ControllerAccesorios();
            List<Accesorio> accesorios = controllerAccesorios.getAllAc(estatus);
            Gson gs = new Gson();
            out = gs.toJson(accesorios);
        } catch (Exception e) {
            System.out.println(e.toString());
            out = "{\"error\":\"" + e.toString() + "\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("Actualizar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(@FormParam("datos") @DefaultValue("") String datos) {
        Gson gson = new Gson();
        Accesorio accesorio = new Accesorio();
        accesorio = gson.fromJson(datos, Accesorio.class);
        String out = "";
        ControllerAccesorios objConAcc = new ControllerAccesorios();

        try {
            objConAcc.actualizarAccesorio(accesorio);
            out = gson.toJson(accesorio);
        } catch (SQLException ex) {
            out = "{\"error\":\"" + ex.toString() + "\"}";
        } catch (JsonParseException jpe) {
            out = """
                   {"error": "Error de formato"}
                   """;
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("eliminar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@FormParam("datos") @DefaultValue("") String datos) {
        Gson gson = new Gson();
        Accesorio accesorio = new Accesorio();
        //El punto class es la especificacion que contiene la clase
        accesorio = gson.fromJson(datos, Accesorio.class);
        String out = "";
        ControllerAccesorios contAcc = new ControllerAccesorios();
        try {
            contAcc.Eliminar(accesorio);
            out = gson.toJson(accesorio);
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
            ControllerAccesorios coAccesorios = new ControllerAccesorios();
            List<Accesorio> accesorios = coAccesorios.searchAccesorio(busqueda);
            Gson gson = new Gson();
            out = gson.toJson(accesorios);
        } catch (Exception ex) {
            System.out.println(ex.toString());

            out = "{\"error\":\"" + ex.toString() + "\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

}
