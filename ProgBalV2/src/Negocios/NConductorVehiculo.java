/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Datos.DConductorVehiculo;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gates
 */
public class NConductorVehiculo {
    
        
        public DefaultTableModel NGetConductorVehiculo( String Placa, String Opcion){
DConductorVehiculo Obj = new DConductorVehiculo();

Obj.setPlaca(Placa);
Obj.setOpcion(Opcion);

 return Obj.DGetConductorVehiculo(Obj);
}
    
    
    
}
