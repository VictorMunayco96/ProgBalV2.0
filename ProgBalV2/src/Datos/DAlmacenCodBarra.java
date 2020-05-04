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
 * @author Gates
 */
public class DAlmacenCodBarra {
    
       String DescProd;
   
    public DAlmacenCodBarra() {
    }

    public DAlmacenCodBarra(String DescProd) {
        this.DescProd = DescProd;
    }

    public String getDescProd() {
        return DescProd;
    }

    public void setDescProd(String DescProd) {
        this.DescProd = DescProd;
    }

 


   

    
    
     public DefaultTableModel DGetAlmacenCodBarra(DAlmacenCodBarra Campo) {
        Conexion Cn = new Conexion();
        Connection Con = Cn.Conexion();
       DefaultTableModel modelo = null ;
String[] titulos = {"IdAlmacenEntrada", "DescProd", "Presentacion", "Lote", "Cantidad", "Fecha", "Placa", "Salida", "Usuario"};
        String[] registro = new String[9];

        modelo = new DefaultTableModel(null, titulos);

        try {
        String SQL="";
        
           
SQL="  select AE.IdAlmacenEntrada, DP.DescProd, DPE.Presentacion, AE.Lote, AE.Cantidad, AE.Fecha, AE.Placa,  \n" +
"            ifnull((select sum(SA.Cantidad) from SalidaAlmacen SA \n" +
"            where SA.IdAlmacenEntrada=AE.IdAlmacenEntrada and SA.Estado=1 ),0) as Salida,\n" +
"            \n" +
"            U.Usuario,AE.EstadoL, AE.Estado  from AlmacenEntrada AE\n" +
"                        inner join DescProdEmpaque DPE on DPE.IdDescProdEmpaque=AE.IdDescProdEmpaque\n" +
"                        inner join DescProd DP on DP.IdDescProd=DPE.IdDescProd\n" +
"                        inner join Usuario U on U.IdUsuario=AE.IdUsuario where AE.EstadoL=1 and DP.DescProd like concat('%','"+Campo.getDescProd()+"','%');";
         
            
            
             
             
            
            CallableStatement Proc = Con.prepareCall(SQL);

Proc.execute();
            ResultSet rs = Proc.executeQuery();
            while (rs.next()) {
registro[0] = rs.getString(1);
registro[1] = rs.getString(2);
registro[2] = rs.getString(3);
registro[3] = rs.getString(4);
registro[4] = rs.getString(5);
registro[5] = rs.getString(6);
registro[6] = rs.getString(7);
registro[7] = rs.getString(8);
registro[8] = rs.getString(9);


modelo.addRow(registro);
            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "error aqui");
            return null;

        }
}
    
    
    
    
    
    
    
}
