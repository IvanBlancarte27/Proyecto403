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
import org.utl.dsm.optica.controller.ControllerClientes;
import org.utl.dsm.optica.controller.ControllerEmpleado;
import org.utl.dsm.optica.model.Cliente;


@Path("cliente")

public class ClienteRest extends Application {

    @Path("insertar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertar(@FormParam("datos") @DefaultValue("") String datos) {
        Gson gson = new Gson();
        Cliente cliente = new Cliente();
        //El punto class es la especificacion que contiene la clase
        cliente = gson.fromJson(datos, Cliente.class);
        String out = "";
        ControllerClientes objCE = new ControllerClientes();
        try {
            objCE.insertCliente(cliente);
            out = gson.toJson(cliente);
        } catch (JsonParseException jpe) {
            out = """
                   {"error": "Error de formato"}
                   """;
        } catch (SQLException ex) {

            out = "{\"error\":\"" + ex.toString() + "\"}";

        }

        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("getAll")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@FormParam("estatus") @DefaultValue("1") String estatus) {
        String out = "";
        try {
            ControllerClientes cmClientes = new ControllerClientes();
            List<Cliente> empleados = cmClientes.getAll(estatus);
            Gson gs = new Gson();
            out = gs.toJson(empleados);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            //Poner diagonal inversa Alt+92
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("getAllInacticvos")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllInac(@FormParam("estatus") @DefaultValue("0") String estatus) {
        String out = "";
        try {
            ControllerClientes cmClientes = new ControllerClientes();
            List<Cliente> empleados = cmClientes.getAll(estatus);
            Gson gs = new Gson();
            out = gs.toJson(empleados);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            //Poner diagonal inversa Alt+92
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("Actualizar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizar(@FormParam("datos") @DefaultValue("") String datos) {
        Gson gson = new Gson();
        Cliente cliente = new Cliente();
        //El punto class es la especificacion que contiene la clase
        cliente = gson.fromJson(datos, Cliente.class);
        String out = "";
        ControllerClientes obClientes = new ControllerClientes();
        try {
            obClientes.actualizarEmpleado(cliente);
            out = gson.toJson(cliente);
        } catch (JsonParseException jpe) {
            out = """
                   {"error": "Error de formato"}
                   """;
        } catch (SQLException ex) {

            out = "{\"error\":\"" + ex.toString() + "\"}";

        }

        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("Eliminar")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@FormParam("datos") @DefaultValue("") String datos) {
        Gson gson = new Gson();
        Cliente cliente = new Cliente();
        //El punto class es la especificacion que contiene la clase
        cliente = gson.fromJson(datos, Cliente.class);
        String out = "";
        ControllerClientes objCE = new ControllerClientes();
        try {
            objCE.Eliminar(cliente);
            out = gson.toJson(cliente);
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
    public Response buscar(@QueryParam("busqueda") @DefaultValue("ivan") String busqueda) {
        String out = "";
        try {
            ControllerClientes cc = new ControllerClientes();
            List<Cliente> clientes = cc.search(busqueda);
            Gson gs = new Gson();
            out = gs.toJson(clientes);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            //Poner diagonal inversa Alt+92
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
}
