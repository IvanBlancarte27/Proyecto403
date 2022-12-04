/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optica.controller;

import java.sql.PreparedStatement;
import org.utl.dsm.optica.db.ConexionMySQL;
import org.utl.dsm.optica.model.Empleado;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.utl.dsm.optica.model.Persona;
import org.utl.dsm.optica.model.Usuario;
import java.sql.Statement;

/**
 *
 * @author ivanb
 */
public class ControllerEmpleado {

    public int insertEmpleado(Empleado empleado) throws SQLException {
        //1. Generar la consulta que vamos a enviar a la base de datos
        String query = "{call insertarEmpleado(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

        //2. Preparamos las variables para recibir los valores de retorno
        int idPersonaG = 0;
        int idUsuarioG = 0;
        int idEmpleadoG = 0;
        String numUnicoG = "";
        String lastTokenG = "";

        //3. Conectarse a la base de Datos
        ConexionMySQL objConexionMySQL = new ConexionMySQL();
        Connection conn = objConexionMySQL.open();

        //4. Generar el objeto que va a invocar el Store Procedure
        CallableStatement cstmt = conn.prepareCall(query);

        //5.Asignar cada uno de los valores que se requiere
        cstmt.setString(1, empleado.getPersona().getNombre());
        cstmt.setString(2, empleado.getPersona().getApellidoPaterno());
        cstmt.setString(3, empleado.getPersona().getApellidoMaterno());
        cstmt.setString(4, empleado.getPersona().getGenero());
        cstmt.setString(5, empleado.getPersona().getFechaNacimiento());
        cstmt.setString(6, empleado.getPersona().getCalle());
        cstmt.setString(7, empleado.getPersona().getNumero());
        cstmt.setString(8, empleado.getPersona().getColonia());
        cstmt.setString(9, empleado.getPersona().getCp());
        cstmt.setString(10, empleado.getPersona().getCiudad());
        cstmt.setString(11, empleado.getPersona().getEstado());
        cstmt.setString(12, empleado.getPersona().getTelCasa());
        cstmt.setString(13, empleado.getPersona().getTelMovil());
        cstmt.setString(14, empleado.getPersona().getEmail());

        cstmt.setString(15, empleado.getUsuario().getNombre());
        cstmt.setString(16, empleado.getUsuario().getContrasenia());
        cstmt.setString(17, empleado.getUsuario().getRol());

        cstmt.registerOutParameter(18, Types.INTEGER);
        cstmt.registerOutParameter(19, Types.INTEGER);
        cstmt.registerOutParameter(20, Types.INTEGER);
        cstmt.registerOutParameter(21, Types.VARCHAR);
        cstmt.registerOutParameter(22, Types.VARCHAR);

        //6. Ejecutar la sentencia
        cstmt.executeUpdate();

        //7.Recuperar los parametros de rotorno
        idPersonaG = cstmt.getInt(18);
        idUsuarioG = cstmt.getInt(19);
        idEmpleadoG = cstmt.getInt(20);
        numUnicoG = cstmt.getString(21);
        lastTokenG = cstmt.getString(22);

        //8. Colocar los valores recuperados dentro del objeto
        empleado.getPersona().setIdPersona(idPersonaG);
        empleado.getUsuario().setIdUsiario(idUsuarioG);
        empleado.setIdEmpleado(idEmpleadoG);
        empleado.setNumeroUnico(numUnicoG);
        empleado.getUsuario().setLastToken(lastTokenG);

        //9. Cerrar los objetos de uso de BD
        cstmt.close();
        conn.close();
        objConexionMySQL.close();

        //10. Devolver el id que se genero
        return idEmpleadoG;

    }

    public List<Empleado> getAll(String filtro) throws SQLException {
        //La consulta SQL a ejecutar
        String sql = "SELECT * FROM v_empleados WHERE estatus=" + filtro + ";";
        //Con este objeto nos vamos a conectar a la Base de Datos:
        ConexionMySQL connMySQL = new ConexionMySQL();
        //Abrimos la conexion con la Base de Datos:
        Connection conn = connMySQL.open();
        //Con este objeto ejecutaremos la consulta:
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //Aqui Guardaremos los resultados de la consulta:
        ResultSet rs = pstmt.executeQuery();
        List<Empleado> empleado = new ArrayList<>();

        //Cuando una condicion no lleva llavez 
        while (rs.next()) {
            empleado.add(fill(rs));
        }
        rs.close();
        pstmt.close();
        connMySQL.close();
        return empleado;
    }

    //Saca todos los valores y los Asigana a cada uno de los objetos de persona,Usuario y Empleado
    private Empleado fill(ResultSet rs) throws SQLException {
        //Creamos un Objeto de Tipo empleado
        Empleado empleado = new Empleado();
        Persona persona = new Persona();

        persona.setApellidoMaterno(rs.getString("apellidoMaterno"));
        persona.setApellidoPaterno(rs.getString("apellidoPaterno"));
        persona.setCalle(rs.getString("calle"));
        persona.setCiudad(rs.getString("ciudad"));
        persona.setColonia(rs.getString("colonia"));
        persona.setCp(rs.getString("cp"));
        persona.setEmail(rs.getString("email"));
        persona.setEstado(rs.getString("estado"));
        persona.setFechaNacimiento(rs.getString("fechaNacimiento"));
        persona.setGenero(rs.getString("genero"));
        persona.setIdPersona(rs.getInt("idPersona"));
        persona.setNombre(rs.getString("nombre"));
        persona.setNumero(rs.getString("numero"));
        persona.setTelCasa(rs.getString("telcasa"));
        persona.setTelMovil(rs.getString("telmovil"));
        empleado.setPersona(persona);

        empleado.setNumeroUnico(rs.getString("numeroUnico"));
        empleado.setIdEmpleado(rs.getInt("idEmpleado"));
        empleado.setEstatus(rs.getInt("estatus"));

        //Forma de meter datos declarando el objeto dentro del empleado
        empleado.setUsuario(new Usuario());
        empleado.getUsuario().setContrasenia(rs.getString("contrasenia"));
        empleado.getUsuario().setIdUsiario(rs.getInt("idUsuario"));
        empleado.getUsuario().setNombre(rs.getString("nombre"));
        empleado.getUsuario().setRol(rs.getString("rol"));
        empleado.getUsuario().setLastToken(rs.getString("lastToken"));
        empleado.getUsuario().setDateLasToken(rs.getString("dateLastToken"));

        return empleado;
    }

    public void actualizarEmpleado(Empleado empleado) throws SQLException {
        //1. Generar la consulta que vamos a enviar a la base de datos
        String query = "{call updateEmpleado(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

        //3. Conectarse a la base de Datos
        ConexionMySQL objConexionMySQL = new ConexionMySQL();
        Connection conn = objConexionMySQL.open();

        //4. Generar el objeto que va a invocar el Store Procedure
        CallableStatement cstmt = conn.prepareCall(query);

        //5.Asignar cada uno de los valores que se requiere
        cstmt.setString(1, empleado.getPersona().getNombre());
        cstmt.setString(2, empleado.getPersona().getApellidoPaterno());
        cstmt.setString(3, empleado.getPersona().getApellidoMaterno());
        cstmt.setString(4, empleado.getPersona().getGenero());
        cstmt.setString(5, empleado.getPersona().getFechaNacimiento());
        cstmt.setString(6, empleado.getPersona().getCalle());
        cstmt.setString(7, empleado.getPersona().getNumero());
        cstmt.setString(8, empleado.getPersona().getColonia());
        cstmt.setString(9, empleado.getPersona().getCp());
        cstmt.setString(10, empleado.getPersona().getCiudad());
        cstmt.setString(11, empleado.getPersona().getEstado());
        cstmt.setString(12, empleado.getPersona().getTelCasa());
        cstmt.setString(13, empleado.getPersona().getTelMovil());
        cstmt.setString(14, empleado.getPersona().getEmail());

        cstmt.setString(15, empleado.getUsuario().getNombre());
        cstmt.setString(16, empleado.getUsuario().getContrasenia());
        cstmt.setString(17, empleado.getUsuario().getRol());

        cstmt.setInt(18, empleado.getPersona().getIdPersona());
        cstmt.setInt(19, empleado.getUsuario().getIdUsiario());
        cstmt.setInt(20, empleado.getIdEmpleado());

        cstmt.executeUpdate();

        //9. Cerrar los objetos de uso de BD
        cstmt.close();
        conn.close();
        objConexionMySQL.close();

    }

    public void Eliminar(Empleado empleado) throws SQLException {
        //1. Generar la consulta que vamos a enviar a la base de datos
        String sql = "{call cambiarestatusin(?,?)}";

        //3. Conectarse a la base de Datos
        ConexionMySQL objConexionMySQL = new ConexionMySQL();
        Connection conn = objConexionMySQL.open();

        //4. Generar el objeto que va a invocar el Store Procedure
        CallableStatement cstmt = conn.prepareCall(sql);

        //5.Asignar cada uno de los valores que se requiere
        cstmt.setInt(1, empleado.getEstatus());
        cstmt.setInt(2, empleado.getIdEmpleado());

        cstmt.executeUpdate();

        //9. Cerrar los objetos de uso de BD
        cstmt.close();
        conn.close();
        objConexionMySQL.close();

    }

    public List<Empleado> search(String busqueda) throws SQLException {
        String query = "SELECT * FROM v_empleados WHERE nombre LIKE '%" + busqueda + "%' OR apellidoPaterno LIKE '%" + busqueda + "%' OR apellidoMaterno LIKE '%" + busqueda + ""
                + "%' OR email LIKE '%" + busqueda + "%'";

        ConexionMySQL objConexionMySQL = new ConexionMySQL();
        Connection conn = objConexionMySQL.open();

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        List<Empleado> empleados = new ArrayList<>();

        //Recorre el renglon y saca los valores que hay en ella, despues los asigna a los objetos correspondientes
        while (rs.next()) {
            empleados.add(fill(rs));
        }
        stmt.close();
        conn.close();
        objConexionMySQL.close();
        
        return empleados;
    }

}
