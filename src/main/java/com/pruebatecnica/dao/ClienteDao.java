
package com.pruebatecnica.dao;

import java.util.List;
import com.pruebatecnica.conexion.Conexion;
import com.pruebatecnica.entity.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClienteDao{
    
    Conexion cn = new Conexion();
    
    private Connection conection;
    
    PreparedStatement ps;
    ResultSet rs;
    
    Cliente c = new Cliente();
    
    public List Listar(){
        ArrayList<Cliente>list= new ArrayList<>();
        String sql = "select * from iteria_test.cliente";
        
        try{
         conection = getConnection();
         ps=conection.prepareStatement(sql);
         rs=ps.executeQuery();
         
         while(rs.next()){
             Cliente cli= new Cliente();
             cli.setId(rs.getInt("idcliente"));
             cli.setPrimer_nombre(rs.getString("pri_nom"));
             cli.setSegundo_nombre(rs.getString("seg_nom"));
             cli.setPrimer_apellido(rs.getString("pri_ape"));
             cli.setSegundo_apellido(rs.getString("seg_ape"));
             cli.setNum_contact(rs.getString("num_cont"));
             list.add(cli);
                      
         }
         
         ps.close();
          conection.close();
        } catch(SQLException e){
               Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return list;
    }
    
    public boolean guardar(Cliente cliente){
        String sql;
        boolean operacion = false;
        try {
            conection = getConnection();
            
            sql= "INSERT INTO cliente (pri_nom,seg_nom,pri_ape,seg_ape,num_cont)VALUES(?,?,?,?,?)";
            ps = conection.prepareStatement(sql);
            
            ps.setString(1, cliente.getPrimer_nombre());
            ps.setString(2, cliente.getSegundo_nombre());
            ps.setString(3, cliente.getPrimer_apellido());
            ps.setString(4, cliente.getSegundo_apellido());
            ps.setString(5, cliente.getNum_contact());
            
            ps.execute();
            operacion = true;
            ps.close();
            conection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return operacion;
    }
    
    private Connection getConnection() throws SQLException{
        return Conexion.getConnection();
    }

    public boolean eliminar(Cliente cliente) {
        String sql;
        boolean operacion = false;
        try {
            conection = getConnection();
            
            sql= "DELETE FROM cliente WHERE idcliente = ?";
            ps = conection.prepareStatement(sql);
            
            ps.setInt(1, cliente.getId());
            
            ps.execute();
            operacion = true;
            ps.close();
            conection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return operacion;
    }
    
}
