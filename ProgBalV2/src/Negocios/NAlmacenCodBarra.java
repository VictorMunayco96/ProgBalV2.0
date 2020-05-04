/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Datos.DAlmacenCodBarra;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gates
 */
public class NAlmacenCodBarra {
    
    
            public DefaultTableModel NGetAlmacenCodBarra( String DescProd){
DAlmacenCodBarra Obj = new DAlmacenCodBarra();

Obj.setDescProd(DescProd);


 return Obj.DGetAlmacenCodBarra(Obj);
}
    
}
