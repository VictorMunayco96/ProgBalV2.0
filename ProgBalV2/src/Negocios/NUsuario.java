/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;
import Datos.DUsuario;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Victor
 */
public class NUsuario {
    
    


public DefaultTableModel NGetUsuario(String Usuario,String Contrasena,String Opcion){
DUsuario Obj = new DUsuario();


Obj.setUsuario(Usuario);
Obj.setContrasena(Contrasena);
Obj.setOpcion(Opcion);

 return Obj.DGetUsuario(Obj);
}
    
}
