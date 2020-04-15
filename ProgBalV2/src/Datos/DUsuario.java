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
public class DUsuario {
    
    
    
int IdUsuario;
String Usuario;
String Contrasena;
String Opcion;

public DUsuario(){}

    public DUsuario(int IdUsuario, String Usuario, String Contrasena, String Opcion) {
        this.IdUsuario = IdUsuario;
        this.Usuario = Usuario;
        this.Contrasena = Contrasena;
        this.Opcion = Opcion;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public String getOpcion() {
        return Opcion;
    }

    public void setOpcion(String Opcion) {
        this.Opcion = Opcion;
    }

   



public DefaultTableModel DGetUsuario(DUsuario Campo) {
        Conexion Cn = new Conexion();
        Connection Con = Cn.Conexion();
       DefaultTableModel modelo = null ;
String[] titulos = {"ID USUARIO","USUARIO","CONTRASEÑA"};
        String[] registro = new String[3];

        modelo = new DefaultTableModel(null, titulos);

        try {

            CallableStatement Proc = Con.prepareCall("CALL PAGetUsuario(?,?,?)");



        Proc.setString(1, Campo.getUsuario());
        Proc.setString(2, Campo.getContrasena());
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
