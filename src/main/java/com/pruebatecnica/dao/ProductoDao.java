
package com.pruebatecnica.dao;

import com.pruebatecnica.conexion.Conexion;
import com.pruebatecnica.entity.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lejohurtado
 */
public class ProductoDao {
    
    Conexion cn = new Conexion();
    
    private Connection conection;
    
    PreparedStatement ps;
    ResultSet rs;
    
    Producto c = new Producto();
    
    public List Listar(){
        ArrayList<Producto>list= new ArrayList<>();
        String sql = "select * from iteria_test.producto";
        
        try{
         conection = getConnection();
         ps=conection.prepareStatement(sql);
         rs=ps.executeQuery();
         
         while(rs.next()){
             Producto prod= new Producto();
             prod.setId(rs.getInt("idproducto"));
             prod.setNom_prod(rs.getString("nom_prod"));
             prod.setDes_prod(rs.getString("des_prod"));
             prod.setValor_prod(rs.getString("valor_prod"));
             list.add(prod);
                      
         }
         
         ps.close();
          conection.close();
        } catch(SQLException e){
               Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return list;
    }
    
    public boolean guardar(Producto producto){
        String sql;
        boolean operacion = false;
        try {
            conection = getConnection();
            
            sql= "INSERT INTO producto (nom_prod,des_prod,valor_prod)VALUES(?,?,?)";
            ps = conection.prepareStatement(sql);
            
            ps.setString(1, producto.getNom_prod());
            ps.setString(2, producto.getDes_prod());
            ps.setString(3, producto.getValor_prod());
                       
            ps.execute();
            operacion = true;
            ps.close();
            conection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return operacion;
    }
    
    private Connection getConnection() throws SQLException{
        return Conexion.getConnection();
    }

    public boolean eliminar(Producto producto) {
        String sql;
        boolean operacion = false;
        try {
            conection = getConnection();
            
            sql= "DELETE FROM producto WHERE idproducto = ?";
            ps = conection.prepareStatement(sql);
            
            ps.setInt(1, producto.getId());
            
            ps.execute();
            operacion = true;
            ps.close();
            conection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return operacion;
    }
}
