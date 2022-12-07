package org.utl.dsm.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import org.utl.dsm.optica.controller.ControllerTratamiento;
import org.utl.dsm.optica.model.Tratamiento;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author yahir
 */
@Path("tratamiento")
public class TratamientoREST {

    @Path("insertarTratamiento")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertarTratamiento(@FormParam("datos") @DefaultValue("") String datos) {
        Gson gson = new Gson();
        Tratamiento tratamiento = new Tratamiento();
        //El punto class es la especificacion que contiene la clase
        tratamiento = gson.fromJson(datos, Tratamiento.class);
        String out = "";
        ControllerTratamiento objCT = new ControllerTratamiento();
        try {
            objCT.insertarTratamiento(tratamiento);
            out = gson.toJson(tratamiento);
        } catch (SQLException ex) {

            out = "{\"error\":\"" + ex.toString() + "\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("getAllTratamiento")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTratamiento(@FormParam("estatus") @DefaultValue("1") String estatus) {
        String out = "";
        try {
            ControllerTratamiento cmTratamiento = new ControllerTratamiento();
            List<Tratamiento> tratamientos = cmTratamiento.getAllTratamientol(estatus);
            Gson gs = new Gson();
            out = gs.toJson(tratamientos);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            //Poner diagonal inversa Alt+92
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("getAllInactivosTratamientos")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllInactivosTratamientos(@FormParam("estatus") @DefaultValue("0") String estatus) {
        String out = "";
        try {
            ControllerTratamiento cmTratamientos = new ControllerTratamiento();
            List<Tratamiento> tratamientos = cmTratamientos.getAllTratamientol(estatus);
            Gson gs = new Gson();
            out = gs.toJson(tratamientos);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            //Poner diagonal inversa Alt+92
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("BorrarTratamiento")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response BorrarTratamiento(@FormParam("datos") @DefaultValue("1") String datos) {
        Gson gson = new Gson();
        Tratamiento tratamiento = new Tratamiento();
        //El punto class es la especificacion que contiene la clase
        tratamiento = gson.fromJson(datos, Tratamiento.class);
        String out = "";
        ControllerTratamiento objCT = new ControllerTratamiento();
        try {
            objCT.borrarTratamiento(tratamiento);
            out = gson.toJson(tratamiento);
        } catch (SQLException ex) {

            out = "{\"error\":\"" + ex.toString() + "\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("modificarTratamiento")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response modificarTratamiento(@FormParam("datos") @DefaultValue("") String datos) {
        Gson gson = new Gson();
        Tratamiento tratamiento = new Tratamiento();
        //El punto class es la especificacion que contiene la clase
        tratamiento = gson.fromJson(datos, Tratamiento.class);
        String out = "";
        ControllerTratamiento objCT = new ControllerTratamiento();
        try {
            objCT.modificarTratamiento(tratamiento);
            out = gson.toJson(tratamiento);
        } catch (SQLException ex) {

            out = "{\"error\":\"" + ex.toString() + "\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("BuscarTratamiento")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response BuscarTratamiento(@QueryParam("buscar") @DefaultValue("a") String buscar) {
        String out = "";
        try {
            ControllerTratamiento cmTratamiento = new ControllerTratamiento();
            List<Tratamiento> tratamientos = cmTratamiento.BuscarTratamiento(buscar);
            Gson gs = new Gson();
            out = gs.toJson(tratamientos);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            //Poner diagonal inversa Alt+92
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
}
