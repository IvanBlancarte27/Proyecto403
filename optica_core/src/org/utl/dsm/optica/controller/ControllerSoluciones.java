/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.optica.controller;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Connection;
import org.utl.dsm.optica.db.ConexionMySQL;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import org.utl.dsm.optica.model.Producto;
import org.utl.dsm.optica.model.Solucion;


/**
 *
 * @author daian
 */
public class ControllerSoluciones {
      public int insertasoluciones(Solucion s) throws SQLException{
        
        //Generar la consulta que vamos a avnviar a la base de datos
        String query ="call insertarSolucioness(?,?,?,?,?,?,?,?)";
        //Preparar las variables para recibir los valore sde retorno
        
        int idProductoG=0;
        int idSolucionG=0;
        String codigoStringBarrasG="";
        
       
        //Conectarse a la base de datos 
        
        ConexionMySQL objConMySQL= new ConexionMySQL();
        java.sql.Connection conn = objConMySQL.open();
        
        //Generar el ojbjeto que va a invocar el store Procedure
        
        CallableStatement cstmt = conn.prepareCall (query);
        
        //Asignar cada uno de los valores que se requieren 
        cstmt.setDouble(1, s.getProducto().getPrecioVenta());
        cstmt.setDouble(2, s.getProducto().getPrecioCompra());
        cstmt.setString(3, s.getProducto().getNombre());
        cstmt.setString(4, s.getProducto().getMarca());
        cstmt.setInt(5, s.getProducto().getExistencias());
        
        
        cstmt.registerOutParameter(6,Types.VARCHAR);
        cstmt.registerOutParameter(7, Types.INTEGER);
        cstmt.registerOutParameter(8, Types.INTEGER);
       
       
        //Ejeutar la instruccion
        cstmt.executeUpdate();
        //recuperar los parametros de retorno
        
        codigoStringBarrasG=cstmt.getString(6);
        idProductoG= cstmt.getInt(7);
        idSolucionG= cstmt.getInt(8);
       
        
        //colocar los valores recuperados dentro del objeto 
        s.getProducto().setCodigoBarras(codigoStringBarrasG);
        s.getProducto().setIdProducto(idProductoG);
        s.setIdSolucion( idSolucionG);
        
        
        cstmt.close();
        conn.close();
        objConMySQL.close();
        return  idSolucionG;
    }
      
      public List<Solucion> getAll(String filtro) throws Exception{
        String  sql = "SELECT * FROM v_solucioness WHERE estatus="+filtro+";";
        ConexionMySQL connMySQL= new ConexionMySQL();
        java.sql.Connection conn = connMySQL.open();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Solucion> solucion = new ArrayList<>();
        while(rs.next()){
            solucion.add(fill(rs));
        }
        rs.close();
        pstmt.close();
        connMySQL.close();
        return solucion;
    }
     private Solucion fill(ResultSet rs) throws Exception{
        Solucion s = new Solucion();
         Producto p = new Producto();
        p.setNombre(rs.getString("nombre"));
        p.setMarca(rs.getString("marca"));
        p.setCodigoBarras(rs.getString("codigoBarras"));
        
        p.setIdProducto(rs.getInt("idProducto"));
        p.setPrecioCompra(rs.getDouble("precioCompra"));
        p.setPrecioVenta(rs.getDouble("precioVenta"));
        p.setExistencias(rs.getInt("existencias"));
        p.setEstatus(rs.getInt("estatus"));
        
        s.setIdSolucion(rs.getInt("idSolucion"));
       
       
        
        s.setProducto(p);
        
        return s;
    }
     public void eliminarSoluciones(Solucion soluciones) throws SQLException{
        //1. Generar la consulta que vamos a enviar a la base de datos
        String sql="{call estatusSoluciones(?,?,?)}";
         
        //3. Conectarse a la base de Datos
        ConexionMySQL objConexionMySQL = new ConexionMySQL();
        Connection conn= objConexionMySQL.open();
        
        //4. Generar el objeto que va a invocar el Store Procedure
        CallableStatement cstmt = conn.prepareCall(sql);
        
        //5.Asignar cada uno de los valores que se requiere
        cstmt.setInt(1,soluciones.getProducto().getEstatus());
        cstmt.setInt(2,soluciones.getIdSolucion());
        cstmt.setInt(3,soluciones.getProducto().getIdProducto());
        cstmt.executeUpdate();
        
        
        //9. Cerrar los objetos de uso de BD
        cstmt.close();
        conn.close();
        objConexionMySQL.close();
        
                
    }
      public void modificar(Solucion s)throws Exception{
        String query="call updateSolucio(?,?,?,?,?,?,?)";
        ConexionMySQL objConMySQL= new ConexionMySQL();
        
        Connection conn =  objConMySQL.open();
        
        CallableStatement cstmt = conn.prepareCall (query);
       
        cstmt.setDouble(1, s.getProducto().getPrecioVenta());
        cstmt.setDouble(2, s.getProducto().getPrecioCompra());
        cstmt.setString(3, s.getProducto().getNombre());
        cstmt.setString(4, s.getProducto().getMarca());
        cstmt.setInt(5, s.getProducto().getExistencias());
        cstmt.setInt(6,s.getProducto().getIdProducto());
       
        cstmt.setInt(7,s.getIdSolucion());
        
        
        
        cstmt.executeUpdate();
       
        
        cstmt.close();
        conn.close();
        objConMySQL.close();
        
    }
      
      public List<Solucion> Buscar(String buscar) throws SQLException, Exception {
        String sql = "SELECT * FROM  v_solucioness WHERE nombre LIKE '%" + buscar + "%' OR codigoBarras LIKE '%" + buscar + "%' OR marca LIKE '%"
                + buscar + "%' OR  precioCompra LIKE '%" + buscar + "%' OR  precioVenta LIKE '%" + buscar + "%' OR existencias LIKE '%" + buscar+ "%'";

        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        List<Solucion> soluciones = new ArrayList<>();
        
        while (rs.next()) {
            soluciones.add(fill(rs));
        }
        rs.close();
        stmt.close();
        connMySQL.close();
        return soluciones;
        
    }  
// 
}
