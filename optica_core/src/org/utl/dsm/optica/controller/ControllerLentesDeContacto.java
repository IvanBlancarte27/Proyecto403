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
import org.utl.dsm.optica.model.Lente_contacto;
import org.utl.dsm.optica.model.Producto;

public class ControllerLentesDeContacto {

    public int insertarLenteContacto(Lente_contacto lente_contacto) throws SQLException {
        //1. Generar la consulta que vamos a enviar a la base de datos
        String sql = "{call insertarLenteContacto(?,?,?,?,?,?,?,?,?,?)}";

        //2. Preparamos las variables para recibir los valores de retorno
        int idProductoR = 0;
        int idLentesContactoR = 0;
        String codigoBarrasR = "";

        //3. Conectarse a la base de Datos
        ConexionMySQL objConexionMySQL = new ConexionMySQL();
        Connection conn = objConexionMySQL.open();

        //4. Generar el objeto que va a invocar el Stare Procedure
        CallableStatement cstmt = conn.prepareCall(sql);

        //5.Asignar cada uno de los valores que se requiere
        cstmt.setString(1, lente_contacto.getProducto().getNombre());
        cstmt.setString(2, lente_contacto.getProducto().getMarca());
        cstmt.setDouble(3, lente_contacto.getProducto().getPrecioCompra());
        cstmt.setDouble(4, lente_contacto.getProducto().getPrecioVenta());
        cstmt.setInt(5, lente_contacto.getProducto().getExistencias());
        cstmt.setDouble(6, lente_contacto.getKeratometria());
        cstmt.setString(7, lente_contacto.getFotografia());

        cstmt.registerOutParameter(8, Types.INTEGER);
        cstmt.registerOutParameter(9, Types.INTEGER);
        cstmt.registerOutParameter(10, Types.VARCHAR);

        //6. Ejecutar la sentencia
        cstmt.executeUpdate();

        //7.Recuperar los parametros de rotorno
        idProductoR = cstmt.getInt(8);
        idLentesContactoR = cstmt.getInt(9);
        codigoBarrasR = cstmt.getString(10);

        //8. Colocar los valores recuperados dentro del objeto
        lente_contacto.getProducto().setIdProducto(idProductoR);
        lente_contacto.setIdLenteContacto(idLentesContactoR);
        lente_contacto.getProducto().setCodigoBarras(codigoBarrasR);

        //9. Cerrar los objetos de uso de BD
        
        cstmt.close();
        conn.close();
        objConexionMySQL.close();
        
        //10. Devolver el id que se genero
        return idLentesContactoR;
    }
    
    public List<Lente_contacto> getAllAcLentes(String filtro) throws SQLException{
        String sql ="SELECT * FROM v_lentes_contacto WHERE estatus="+filtro+";";
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        List<Lente_contacto> lente_contactos= new ArrayList<>();
        
        while (rs.next()) {            
            lente_contactos.add(fill(rs));
        }
        rs.close();
        statement.close();
        connMySQL.close();
        
        return lente_contactos;
    }
    
    public Lente_contacto fill(ResultSet rs) throws SQLException{
        Producto producto= new Producto();
        Lente_contacto lente_contacto= new Lente_contacto();
        
        producto.setIdProducto(rs.getInt("idProducto"));
        producto.setCodigoBarras(rs.getString("codigoBarras"));
        producto.setNombre(rs.getString("nombre"));
        producto.setMarca(rs.getString("marca"));
        producto.setPrecioCompra(rs.getDouble("precioCompra"));
        producto.setPrecioVenta(rs.getDouble("precioVenta"));
        producto.setExistencias(rs.getInt("existencias"));
        producto.setEstatus(rs.getInt("estatus"));
        
        lente_contacto.setProducto(producto);
        lente_contacto.setIdLenteContacto(rs.getInt("idLenteContacto"));
        lente_contacto.setFotografia(rs.getString("fotografia"));
        lente_contacto.setKeratometria(rs.getInt("keratometria"));
        

        return lente_contacto;
    }
    
    public void actualizarLentesDeContacto(Lente_contacto lente_contacto) throws SQLException{
        
        String sql="{call updateLentescontacto(?,?,?,?,?,?,?,?,?)}";
        
        ConexionMySQL objConexionMySQL= new ConexionMySQL();
        Connection conn = objConexionMySQL.open();
        
        CallableStatement cstmt = conn.prepareCall(sql);
        
        cstmt.setString(1,lente_contacto.getProducto().getNombre());
        cstmt.setString(2, lente_contacto.getProducto().getMarca());
        cstmt.setDouble(3, lente_contacto.getProducto().getPrecioCompra());
        cstmt.setDouble(4, lente_contacto.getProducto().getPrecioVenta());
        cstmt.setInt(5, lente_contacto.getProducto().getExistencias());
        cstmt.setInt(6, lente_contacto.getKeratometria());
        cstmt.setString(7, lente_contacto.getFotografia());
        cstmt.setInt(8,lente_contacto.getIdLenteContacto());
        cstmt.setInt(9,lente_contacto.getProducto().getIdProducto());
        
        cstmt.executeUpdate();
        
        cstmt.close();
        conn.close();
        objConexionMySQL.close();
    }
    
    public void eliminarLentes(Lente_contacto lente_contacto) throws SQLException{
        String sql = "{call eliminarLentes(?,?,?)}";
        
        ConexionMySQL objConexionMySQL = new ConexionMySQL();
        Connection conn = objConexionMySQL.open();
                
        CallableStatement cstmt = conn.prepareCall(sql);
        cstmt.setInt(1,lente_contacto.getProducto().getEstatus());
        cstmt.setInt(2,lente_contacto.getProducto().getIdProducto());
        cstmt.setInt(3,lente_contacto.getIdLenteContacto());
        
        cstmt.executeUpdate();
        
        cstmt.close();
        conn.close();
        objConexionMySQL.close();
    }
    
    public List<Lente_contacto> searchLentesCon(String busqueda) throws SQLException{
        String query="SELECT * FROM v_lentes_contacto WHERE nombre LIKE '%"+busqueda+"%' OR marca LIKE '%"+busqueda+"%'";
        
        ConexionMySQL objConexionMySQL = new ConexionMySQL();
        Connection conn = objConexionMySQL.open();
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        List<Lente_contacto> lente_contactos = new ArrayList<>();
        
        while (rs.next()) {            
            lente_contactos.add(fill(rs));
        }
        stmt.close();
        conn.close();
        objConexionMySQL.close();
        
        return lente_contactos;
    }
    
}