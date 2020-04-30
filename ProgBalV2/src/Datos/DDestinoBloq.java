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
public class DDestinoBloq {
    
    int IdDestinoBloq;
    String DestinoDes;
    String CodDestinoBloq;
    String Opcion;

    public DDestinoBloq() {
    }

    public DDestinoBloq(int IdDestinoBloq, String DestinoDes, String CodDestinoBloq, String Opcion) {
        this.IdDestinoBloq = IdDestinoBloq;
        this.DestinoDes = DestinoDes;
        this.CodDestinoBloq = CodDestinoBloq;
        this.Opcion = Opcion;
    }

   

    public int getIdDestinoBloq() {
        return IdDestinoBloq;
    }

    public void setIdDestinoBloq(int IdDestinoBloq) {
        this.IdDestinoBloq = IdDestinoBloq;
    }

    public String getDestinoDes() {
        return DestinoDes;
    }

    public void setDestinoDes(String DestinoDes) {
        this.DestinoDes = DestinoDes;
    }

    

    public String getCodDestinoBloq() {
        return CodDestinoBloq;
    }

    public void setCodDestinoBloq(String CodDestinoBloq) {
        this.CodDestinoBloq = CodDestinoBloq;
    }

    public String getOpcion() {
        return Opcion;
    }

    public void setOpcion(String Opcion) {
        this.Opcion = Opcion;
    }
    
    
     public DefaultTableModel DGetDestinoBloq(DDestinoBloq Campo) {
        Conexion Cn = new Conexion();
        Connection Con = Cn.Conexion();
       DefaultTableModel modelo = null ;
String[] titulos = {"ID","DESTINO"};
        String[] registro = new String[3];

        modelo = new DefaultTableModel(null, titulos);

        try {
        String SQL="";
        
            if(Campo.getOpcion().equals("TODO")){
SQL="   select DB.IdDestinoBloq, DB.DestinoBloq, DD.DestinoDes, D.Destino from Destino D \n" +
"    inner join (DestinoDesc DD \n" +
"    inner join DestinoBloq DB \n" +
"    on DD.IdDestinoDesc=DB.IdDestinoDesc) \n" +
"    on D.IdDestino=DD.IdDestino \n" +
"    where DB.Estado=1\n" +
"    order by DB.IdDestinoBloq desc;\n" +
"     ";
            }
            
             if(Campo.getOpcion().equals("DEST")){
SQL=" select DB.IdDestinoBloq, DB.DestinoBloq, DD.DestinoDes, D.Destino from Destino D \n" +
"    inner join (DestinoDesc DD inner join DestinoBloq DB on DD.IdDestinoDesc=DB.IdDestinoDesc)\n" +
"    on D.IdDestino=DD.IdDestino \n" +
"    where DD.DestinoDes like concat('%','"+Campo.getDestinoDes()+"','%')\n" +
"     and DB.Estado=1\n" +
"    order by DB.IdDestinoBloq desc";
            }
             
             if(Campo.getOpcion().equals("IDDE")){
SQL="select DB.IdDestinoBloq, DB.DestinoBloq, DD.DestinoDes, D.Destino from Destino D \n" +
"    inner join (DestinoDesc DD inner join DestinoBloq DB on DD.IdDestinoDesc=DB.IdDestinoDesc)\n" +
"    on D.IdDestino=DD.IdDestino \n" +
"    where DB.IdDestinoBloq='"+String.valueOf(Campo.getIdDestinoBloq())+"' \n" +
"     and DB.Estado=1\n" +
"    order by DB.IdDestinoBloq desc;";
            }
            
            CallableStatement Proc = Con.prepareCall(SQL);
//Proc.setInt(1, Campo.getIdDestinoBloq());
//Proc.setString(2, Campo.getDestinoDes());
//Proc.setString(3, Campo.getCodDestinoBloq());
//Proc.setString(4, Campo.getOpcion());
Proc.execute();
            ResultSet rs = Proc.executeQuery();
            while (rs.next()) {
registro[0] = rs.getString(1);
registro[1] = rs.getString(4)+"/ "+rs.getString(3)+"/ "+rs.getString(2);

modelo.addRow(registro);
            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "error aqui");
            return null;

        }
}
    
    
    
    
    
}
