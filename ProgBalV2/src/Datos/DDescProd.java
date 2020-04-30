/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gates
 */
public class DDescProd {
    
    int IdDescProd;
    String DescProd;
    String Opcion;

    public DDescProd() {
    }

    public DDescProd(int IdDescProd, String DescProd, String Opcion) {
        this.IdDescProd = IdDescProd;
        this.DescProd = DescProd;
        this.Opcion = Opcion;
    }

    public int getIdDescProd() {
        return IdDescProd;
    }

    public void setIdDescProd(int IdDescProd) {
        this.IdDescProd = IdDescProd;
    }

    public String getDescProd() {
        return DescProd;
    }

    public void setDescProd(String DescProd) {
        this.DescProd = DescProd;
    }

    public String getOpcion() {
        return Opcion;
    }

    public void setOpcion(String Opcion) {
        this.Opcion = Opcion;
    }
    
     
    
    
    
    public DefaultTableModel DGetDescProd(DDescProd Campo) {
        Conexion Cn = new Conexion();
        Connection Con = Cn.Conexion();
       DefaultTableModel modelo = null ;
String[] titulos = {"ID","Producto"};
        String[] registro = new String[2];

        modelo = new DefaultTableModel(null, titulos);

        try {
            String SQL="";
            if(Campo.getOpcion().equals("TODO")){
SQL="select IdDescProd, DescProd from DescProd where Estado=1  order by IdDescProd desc";
            }
            
             if(Campo.getOpcion().equals("DESC")){
SQL="select IdDescProd, DescProd from DescProd where DescProd like concat('%','"+Campo.getDescProd()+"','%') and Estado=1 order by IdDescProd desc;";
            }
             
             if(Campo.getOpcion().equals("IDDE")){
SQL="select IdDescProd, DescProd from DescProd where IdDescProd='"+Campo.getDescProd()+"' and Estado=1 order by IdDescProd desc;";
            }
            
            
            
            
            CallableStatement Proc = Con.prepareCall(SQL);
//Proc.setInt(1, Campo.getIdDescProd());
//Proc.setString(2, Campo.getDescProd());
//Proc.setString(3, Campo.getOpcion());
Proc.execute();
            ResultSet rs = Proc.executeQuery();
            while (rs.next()) {
registro[0] = rs.getString(1);
registro[1] = rs.getString(2);
modelo.addRow(registro);
            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "error aqui");
            return null;

        }
}
    
    
    
}
