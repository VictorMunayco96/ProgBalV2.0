/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Datos.DDestinoBloq;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gates
 */
public class NDestinoBloq {
    
    
        public DefaultTableModel NGetDestinoBloq(int IdDestinoBloq,String DestinoDes, String CodDestinoBloq,String Opcion){
DDestinoBloq Obj = new DDestinoBloq();

Obj.setIdDestinoBloq(IdDestinoBloq);
Obj.setDestinoDes(DestinoDes);
Obj.setCodDestinoBloq(CodDestinoBloq);
Obj.setOpcion(Opcion);

 return Obj.DGetDestinoBloq(Obj);
}
    
    
    
}
