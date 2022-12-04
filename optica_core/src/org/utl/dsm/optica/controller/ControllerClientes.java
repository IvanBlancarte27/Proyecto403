/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optica.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import org.utl.dsm.optica.db.ConexionMySQL;
import org.utl.dsm.optica.model.Persona;
import org.utl.dsm.optica.model.Cliente;


/**
 *
 * @author ivanb
 */
public class ControllerClientes {
    public int insertCliente(Cliente cliente) throws SQLException {
        //1. Generar la consulta que vamos a enviar a la base de datos
        String query = "{call insertarCliente(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

        //2. Preparamos las variables para recibir los valores de retorno
        int idPersonaG = 0;
        int idClienteG = 0;
        String numUnicoG = "";
        
        //3. Conectarse a la base de Datos
        ConexionMySQL objConexionMySQL = new ConexionMySQL();
        Connection conn = objConexionMySQL.open();

        //4. Generar el objeto que va a invocar el Store Procedure
        CallableStatement cstmt = conn.prepareCall(query);

        //5.Asignar cada uno de los valores que se requiere
        cstmt.setString(1, cliente.getPersona().getNombre());
        cstmt.setString(2, cliente.getPersona().getApellidoPaterno());
        cstmt.setString(3, cliente.getPersona().getApellidoMaterno());
        cstmt.setString(4, cliente.getPersona().getGenero());
        cstmt.setString(5, cliente.getPersona().getFechaNacimiento());
        cstmt.setString(6, cliente.getPersona().getCalle());
        cstmt.setString(7, cliente.getPersona().getNumero());
        cstmt.setString(8, cliente.getPersona().getColonia());
        cstmt.setString(9, cliente.getPersona().getCp());
        cstmt.setString(10, cliente.getPersona().getCiudad());
        cstmt.setString(11, cliente.getPersona().getEstado());
        cstmt.setString(12, cliente.getPersona().getTelCasa());
        cstmt.setString(13, cliente.getPersona().getTelMovil());
        cstmt.setString(14, cliente.getPersona().getEmail());

        cstmt.registerOutParameter(15, Types.INTEGER);
        cstmt.registerOutParameter(16, Types.INTEGER);
        cstmt.registerOutParameter(17, Types.VARCHAR);

        //6. Ejecutar la sentencia
        cstmt.executeUpdate();

        //7.Recuperar los parametros de rotorno
        idPersonaG = cstmt.getInt(15);
        idClienteG = cstmt.getInt(16);
        numUnicoG = cstmt.getString(17);

        //8. Colocar los valores recuperados dentro del objeto
        cliente.getPersona().setIdPersona(idPersonaG);
        cliente.setIdCliente(idClienteG);
        cliente.setNumeroUnico(numUnicoG);
      
        //9. Cerrar los objetos de uso de BD
        cstmt.close();
        conn.close();
        objConexionMySQL.close();

        //10. Devolver el id que se genero
        return idClienteG;

    }

    public List<Cliente> getAll(String filtro) throws SQLException {
        //La consulta SQL a ejecutar
        String sql = "SELECT * FROM v_cliente WHERE estatus=" + filtro + ";";
        //Con este objeto nos vamos a conectar a la Base de Datos:
        ConexionMySQL connMySQL = new ConexionMySQL();
        //Abrimos la conexion con la Base de Datos:
        Connection conn = connMySQL.open();
        //Con este objeto ejecutaremos la consulta:
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //Aqui Guardaremos los resultados de la consulta:
        ResultSet rs = pstmt.executeQuery();
        List<Cliente> empleado = new ArrayList<>();

        //Cuando una condicion no lleva llavez 
        while (rs.next()) {
            empleado.add(fill(rs));
        }
        rs.close();
        pstmt.close();
        connMySQL.close();
        return empleado;
    }
//
//    Saca todos los valores y los Asigana a cada uno de los objetos de persona,Usuario y Empleado
    private Cliente fill(ResultSet rs) throws SQLException {
        //Creamos un Objeto de Tipo empleado
        Cliente cliente = new Cliente();
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
        cliente.setPersona(persona);

        cliente.setNumeroUnico(rs.getString("numeroUnico"));
        cliente.setIdCliente(rs.getInt("idCliente"));
        cliente.setEstatus(rs.getInt("estatus"));

        

        return cliente;
    }

    public void actualizarEmpleado(Cliente cliente) throws SQLException {
        //1. Generar la consulta que vamos a enviar a la base de datos
        String query = "{call updateCliente(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

        //3. Conectarse a la base de Datos
        ConexionMySQL objConexionMySQL = new ConexionMySQL();
        Connection conn = objConexionMySQL.open();

        //4. Generar el objeto que va a invocar el Store Procedure
        CallableStatement cstmt = conn.prepareCall(query);

        //5.Asignar cada uno de los valores que se requiere
        cstmt.setString(1, cliente.getPersona().getNombre());
        cstmt.setString(2, cliente.getPersona().getApellidoPaterno());
        cstmt.setString(3, cliente.getPersona().getApellidoMaterno());
        cstmt.setString(4, cliente.getPersona().getGenero());
        cstmt.setString(5, cliente.getPersona().getFechaNacimiento());
        cstmt.setString(6, cliente.getPersona().getCalle());
        cstmt.setString(7, cliente.getPersona().getNumero());
        cstmt.setString(8, cliente.getPersona().getColonia());
        cstmt.setString(9, cliente.getPersona().getCp());
        cstmt.setString(10, cliente.getPersona().getCiudad());
        cstmt.setString(11, cliente.getPersona().getEstado());
        cstmt.setString(12, cliente.getPersona().getTelCasa());
        cstmt.setString(13, cliente.getPersona().getTelMovil());
        cstmt.setString(14, cliente.getPersona().getEmail());

        cstmt.setInt(15, cliente.getPersona().getIdPersona());
        cstmt.setInt(16, cliente.getIdCliente());

        cstmt.executeUpdate();

        //9. Cerrar los objetos de uso de BD
        cstmt.close();
        conn.close();
        objConexionMySQL.close();

    }
//
    public void Eliminar(Cliente cliente) throws SQLException {
        //1. Generar la consulta que vamos a enviar a la base de datos
        String sql = "{call eliminarCliente(?,?)}";

        //3. Conectarse a la base de Datos
        ConexionMySQL objConexionMySQL = new ConexionMySQL();
        Connection conn = objConexionMySQL.open();

        //4. Generar el objeto que va a invocar el Store Procedure
        CallableStatement cstmt = conn.prepareCall(sql);

        //5.Asignar cada uno de los valores que se requiere
        cstmt.setInt(1, cliente.getEstatus());
        cstmt.setInt(2, cliente.getIdCliente());

        cstmt.executeUpdate();

        //9. Cerrar los objetos de uso de BD
        cstmt.close();
        conn.close();
        objConexionMySQL.close();

    }
//
    public List<Cliente> search(String busqueda) throws SQLException {
        String query = "SELECT * FROM v_cliente WHERE nombre LIKE '%" + busqueda + "%' OR apellidoPaterno LIKE '%" + busqueda + "%' OR apellidoMaterno LIKE '%" + busqueda + ""
                + "%' OR email LIKE '%" + busqueda + "%'";

        ConexionMySQL objConexionMySQL = new ConexionMySQL();
        Connection conn = objConexionMySQL.open();

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        List<Cliente> empleados = new ArrayList<>();

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
