/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optica.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import org.utl.dsm.optica.db.ConexionMySQL;
import org.utl.dsm.optica.model.Accesorio;
import org.utl.dsm.optica.model.Producto;

/**
 *
 * @author ivanb
 */
public class ControllerAccesorios {

    public int insertAccesorios(Accesorio accesorio) throws SQLException {
        //1. Generar la consulta que vamos a enviar a la base de datos
        String query = "{call insertarAccesorio(?,?,?,?,?,?,?,?)}";

        //2. Preparamos las variables para recibir los valores de retorno
        int idProductoG = 0;
        int idAccesoriG = 0;
        String codigoBarrasG = "";

        //3. Conectarse a la base de Datos
        ConexionMySQL objConexionMySQL = new ConexionMySQL();
        Connection conn = objConexionMySQL.open();

        //4. Generar el objeto que va a invocar el Store Procedure
        CallableStatement cstmt = conn.prepareCall(query);

        //5.Asignar cada uno de los valores que se requiere
        cstmt.setString(1, accesorio.getProducto().getNombre());
        cstmt.setString(2, accesorio.getProducto().getMarca());
        cstmt.setDouble(3, accesorio.getProducto().getPrecioCompra());
        cstmt.setDouble(4, accesorio.getProducto().getPrecioVenta());
        cstmt.setInt(5, accesorio.getProducto().getExistencias());

        cstmt.registerOutParameter(6, Types.INTEGER);
        cstmt.registerOutParameter(7, Types.INTEGER);
        cstmt.registerOutParameter(8, Types.VARCHAR);

        //6. Ejecutar la sentencia
        cstmt.executeUpdate();

        //7.Recuperar los parametros de rotorno
        idProductoG = cstmt.getInt(6);
        idAccesoriG = cstmt.getInt(7);
        codigoBarrasG = cstmt.getString(8);

        //8. Colocar los valores recuperados dentro del objeto
        accesorio.setIdProducto(idProductoG);
        accesorio.setIdAccesorio(idAccesoriG);
        accesorio.getProducto().setCodigoBarras(codigoBarrasG);

        //9. Cerrar los objetos de uso de BD
        cstmt.close();
        conn.close();
        objConexionMySQL.close();

        //10. Devolver el id que se genero
        return idAccesoriG;

    }

    public List<Accesorio> getAllAc(String filtro) throws SQLException {

        String sql = "SELECT * FROM v_accesorios WHERE estatus=" + filtro + ";";
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        List<Accesorio> accesorios = new ArrayList<>();

        while (rs.next()) {
            accesorios.add(fill(rs));
        }
        rs.close();
        statement.close();
        connMySQL.close();

        return accesorios;
    }

    private Accesorio fill(ResultSet rs) throws SQLException {
        Producto producto = new Producto();
        Accesorio accesorio = new Accesorio();

        producto.setIdProducto(rs.getInt("idProducto"));
        producto.setNombre(rs.getString("nombre"));
        producto.setMarca(rs.getString("marca"));
        producto.setPrecioCompra(rs.getDouble("precioCompra"));
        producto.setPrecioVenta(rs.getDouble("precioVenta"));
        producto.setExistencias(rs.getInt("existencias"));
        producto.setEstatus(rs.getInt("estatus"));
        accesorio.setProducto(producto);
        accesorio.setIdAccesorio(rs.getInt("idAccesorio"));

        return accesorio;
    }

    public void actualizarAccesorio(Accesorio accesorio) throws SQLException {
        String query = "{call updateAccesorio(?,?,?,?,?,?,?)}";

        ConexionMySQL objConexionMySQL = new ConexionMySQL();
        Connection conn = objConexionMySQL.open();

        CallableStatement cstmt = conn.prepareCall(query);

        cstmt.setString(1, accesorio.getProducto().getNombre());
        cstmt.setString(2, accesorio.getProducto().getMarca());
        cstmt.setDouble(3, accesorio.getProducto().getPrecioCompra());
        cstmt.setDouble(4, accesorio.getProducto().getPrecioVenta());
        cstmt.setInt(5, accesorio.getProducto().getExistencias());
        cstmt.setInt(6, accesorio.getIdAccesorio());
        cstmt.setInt(7, accesorio.getProducto().getIdProducto());

        cstmt.executeUpdate();

        cstmt.close();
        conn.close();
        objConexionMySQL.close();

    }

    public void Eliminar(Accesorio accesorio) throws SQLException {
        //1. Generar la consulta que vamos a enviar a la base de datos
        String sql = "{call eliminarAccesorio(?,?,?)}";

        //3. Conectarse a la base de Datos
        ConexionMySQL objConexionMySQL = new ConexionMySQL();
        Connection conn = objConexionMySQL.open();

        //4. Generar el objeto que va a invocar el Store Procedure
        CallableStatement cstmt = conn.prepareCall(sql);

        //5.Asignar cada uno de los valores que se requiere
        cstmt.setInt(1, accesorio.getProducto().getIdProducto());
        cstmt.setInt(2, accesorio.getProducto().getEstatus());
        cstmt.setInt(3, accesorio.getIdAccesorio());

        cstmt.executeUpdate();

        //9. Cerrar los objetos de uso de BD
        cstmt.close();
        conn.close();
        objConexionMySQL.close();

    }

    public List<Accesorio> searchAccesorio(String busqueda) throws SQLException {
        String query="SELECT * FROM v_accesorios WHERE nombre LIKE '%"+busqueda+"%' OR marca LIKE '%"+busqueda+"%'";
        
        ConexionMySQL objConexionMySQL = new ConexionMySQL();
        Connection conn = objConexionMySQL.open();
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        List<Accesorio> accesorios= new ArrayList<>();
        
        while (rs.next()) {
            accesorios.add(fill(rs));
        }
        stmt.close();
        conn.close();
        objConexionMySQL.close();
        
        return accesorios;
    }

}
