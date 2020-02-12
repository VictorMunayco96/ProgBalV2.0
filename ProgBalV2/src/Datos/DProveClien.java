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
public class DProveClien {
 
    
    int IdProveClien;
    String RazonSocial;
    String Opcion;

    public DProveClien() {
    }

    public DProveClien(int IdProveClien, String RazonSocial, String Opcion) {
        this.IdProveClien = IdProveClien;
        this.RazonSocial = RazonSocial;
        this.Opcion = Opcion;
    }

    public int getIdProveClien() {
        return IdProveClien;
    }

    public void setIdProveClien(int IdProveClien) {
        this.IdProveClien = IdProveClien;
    }

    public String getRazonSocial() {
        return RazonSocial;
    }

    public void setRazonSocial(String RazonSocial) {
        this.RazonSocial = RazonSocial;
    }

    public String getOpcion() {
        return Opcion;
    }

    public void setOpcion(String Opcion) {
        this.Opcion = Opcion;
    }
    
    
    
    
     
    public DefaultTableModel DGetProveClien(DProveClien Campo) {
        Conexion Cn = new Conexion();
        Connection Con = Cn.Conexion();
       DefaultTableModel modelo = null ;
String[] titulos = {"ID","PROVEEDOR/CLIENTE","RUC"};
        String[] registro = new String[3];

        modelo = new DefaultTableModel(null, titulos);

        try {

            CallableStatement Proc = Con.prepareCall(" CALL PAGetProveClien(?,?,?)");
Proc.setInt(1, Campo.getIdProveClien());
Proc.setString(2, Campo.getRazonSocial());
Proc.setString(3, Campo.getOpcion());
Proc.execute();
            ResultSet rs = Proc.executeQuery();
            while (rs.next()) {
registro[0] = rs.getString(1);
registro[1] = rs.getString(2);
registro[2] = rs.getString(3);
modelo.addRow(registro);
            }
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "error aqui");
            return null;

        }
}
    
    
    
    
}
