
package org.utl.dsm.optica.controller;

import org.utl.dsm.optica.db.ConexionMySQL;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import org.utl.dsm.optica.model.Tratamiento;


/**
 *
 * @author yahir
 */
public class ControllerTratamiento {
    public int insertarTratamiento(Tratamiento tratamiento) throws SQLException{

        //Generar la consulta que vamos a avnviar a la base de datos
        String query = "call insertarTratamiento(?,?,?,?)";
        //Preparar las variables para recibir los valore sde retorno
        int idTratamientoG = 0;
        
        //Conectarse a la base de datos 

        ConexionMySQL objConMySQL = new ConexionMySQL();
        Connection conn = objConMySQL.open();

        //Generar el ojbjeto que va a invocar el store Procedure
        CallableStatement cstmt = conn.prepareCall(query);

        //Asignar cada uno de los valores que se requieren 
        cstmt.setString(1, tratamiento.getNombre());
        cstmt.setDouble(2, tratamiento.getPrecioCompra());
        cstmt.setDouble(3, tratamiento.getPrecioVenta());

        cstmt.registerOutParameter(4, Types.INTEGER);
        
        //Ejeutar la instruccion
        cstmt.executeUpdate();
        //recuperar los parametros de retorno

        idTratamientoG = cstmt.getInt(4);

        //colocar los valores recuperados dentro del objeto 
        tratamiento.setIdTratamiento(idTratamientoG);

        cstmt.close();
        conn.close();
        objConMySQL.close();
        return idTratamientoG;
    }
    
    public List<Tratamiento> getAllTratamientol(String filtro) throws Exception {
        String sql = "SELECT * FROM v_tratamientos WHERE estatus=" + filtro + ";";
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Tratamiento> tratamientos = new ArrayList<>();
        while (rs.next()) {
            tratamientos.add(fillTratamiento(rs));
        }
        rs.close();
        pstmt.close();
        connMySQL.close();
        return tratamientos;
    }

    private Tratamiento fillTratamiento(ResultSet rs) throws Exception {
         Tratamiento t = new Tratamiento();
         
        t.setNombre(rs.getString("nombre"));
        t.setPrecioCompra(rs.getDouble("precioCompra"));
        t.setPrecioVenta(rs.getDouble("precioVenta"));
       
        t.setIdTratamiento(rs.getInt("idTratamiento"));
        t.setEstatus(rs.getInt("estatus"));

        return t;
    }
    
    public void borrarTratamiento(Tratamiento t) throws SQLException {
        //1. Generar la consulta que vamos a enviar a la base de datos
        String sql = "{call eliminaeTratamiento(?,?)}";

        //3. Conectarse a la base de Datos
        ConexionMySQL objConexionMySQL = new ConexionMySQL();
        Connection conn = objConexionMySQL.open();

        //4. Generar el objeto que va a invocar el Store Procedure
        CallableStatement cstmt = conn.prepareCall(sql);

        //5.Asignar cada uno de los valores que se requiere
        cstmt.setInt(1, t.getEstatus());
        cstmt.setInt(2, t.getIdTratamiento());

        cstmt.executeUpdate();

        //9. Cerrar los objetos de uso de BD
        cstmt.close();
        conn.close();
        objConexionMySQL.close();

    }
    
    public void modificarTratamiento(Tratamiento t) throws SQLException {

        //Generar la consulta que vamos a avnviar a la base de datos
        String query = "call modificarTratamiento(?,?,?,?)";

        //Preparar las variables para recibir los valore sde retorno
        //Conectarse a la base de datos 
        ConexionMySQL objConMySQL = new ConexionMySQL();
        Connection conn = objConMySQL.open();

        //Generar el ojbjeto que va a invocar el store Procedure
        CallableStatement cstmt = conn.prepareCall(query);

        //Asignar cada uno de los valores que se requieren 
        cstmt.setString(1, t.getNombre());
        cstmt.setDouble(2, t.getPrecioCompra());
        cstmt.setDouble(3, t.getPrecioVenta());

        cstmt.setInt(4, t.getIdTratamiento());

        //Ejecutar la instruccion 
        cstmt.executeUpdate();

        cstmt.close();
        conn.close();
        objConMySQL.close();

    }

    
    public List<Tratamiento> BuscarTratamiento(String buscar) throws SQLException, Exception {
        String sql = "SELECT * FROM v_tratamientos WHERE nombre LIKE '%" + buscar + "%' OR precioCompra LIKE '%"
                + buscar + "%' OR precioVenta LIKE '%"+ buscar + "%'";

        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        List<Tratamiento> tratamientos = new ArrayList<>();
        
        while (rs.next()) {
            tratamientos.add(fillTratamiento(rs));
        }
        rs.close();
        stmt.close();
        connMySQL.close();
        return tratamientos;
        
    }

}
