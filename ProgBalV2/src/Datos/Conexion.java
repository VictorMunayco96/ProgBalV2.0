/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


/**
 *
 * @author Victor
 */
public class Conexion {
      static String servidor="";
    static String puerto="";
    static String user="";
    static String password="";
    static String baseDatos="";    
   
    public void leerTexto(String direccion){
        try {
          
            
             BufferedReader Bf = new BufferedReader(new FileReader(direccion));
            String bfRead;
            int cont = 0;
            while((bfRead = Bf.readLine()) != null){
                cont = cont + 1;
                if (cont ==1){
                    servidor = "" + bfRead + "";
                }
                if (cont ==2){
                    puerto = "" + bfRead + "";
                }
                if (cont ==3){
                    user = "" + bfRead + "";
                }
                if (cont ==4){
                    password = "" + bfRead + "";
                }
                if (cont ==5){
                    baseDatos = "" + bfRead + "";
                }
            }
        } catch (Exception e) {
            System.out.println("No se encontró el archivo");
        }
    }
    
    
      
       
//  public Conexion() {
//    }
      
    
      public Connection Conexion() 
             {
                 leerTexto("C:\\SOFT\\conexion2.txt");
          Connection cn = null;
          
                 try {
                     Class.forName("com.mysql.jdbc.Driver");
       
        cn = DriverManager.getConnection("jdbc:mysql://"+servidor+":"+puerto+"/"+baseDatos+"",user,password);
        
     
                 } catch (Exception e) {
                     
                     
                     JOptionPane.showMessageDialog(null, e+" No se ha podido conectar");
                     
                 }
                    return cn;
             }
    
}
