package org.utl.dsm.rest;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.SQLException;
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
}

