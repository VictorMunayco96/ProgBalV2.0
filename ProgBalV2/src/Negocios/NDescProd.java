/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Datos.DDescProd;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gates
 */
public class NDescProd {
    
    public DefaultTableModel NGetDescProd(int IdDescProd,String DescProd,String Opcion){
DDescProd Obj = new DDescProd();

Obj.setIdDescProd(IdDescProd);
Obj.setDescProd(DescProd);
Obj.setOpcion(Opcion);

 return Obj.DGetDescProd(Obj);
}
    
    
}
