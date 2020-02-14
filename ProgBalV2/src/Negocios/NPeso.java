/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Datos.DPeso;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Victor
 */
public class NPeso {
    

public String NSetPeso(int IdPeso,String TipoMovimiento,long NumGuia,String FechaHoraSal,String FechaHoraEnt,int PesoCE,int PesoCS,int NetoC,String ObservE,String ObservS,String Estado,int DNI,int IdProveClien,int Precinto,int IdConductorVehiculo,int IdDestinoBloq,int IdDescProd,String Opcion){

DPeso Obj = new DPeso();
Obj.setIdPeso(IdPeso);
Obj.setTipoMovimiento(TipoMovimiento);
Obj.setNumGuia(NumGuia);
Obj.setFechaHoraSal(FechaHoraSal);
Obj.setFechaHoraEnt(FechaHoraEnt);
Obj.setPesoCE(PesoCE);
Obj.setPesoCS(PesoCS);
Obj.setNetoC(NetoC);
Obj.setObservE(ObservE);
Obj.setObservS(ObservS);
Obj.setEstado(Estado);
Obj.setDNI(DNI);
Obj.setIdProveClien(IdProveClien);

Obj.setPrecinto(Precinto);
Obj.setIdConductorVehiculo(IdConductorVehiculo);
Obj.setIdDestinoBloq(IdDestinoBloq);
Obj.setIdDescProd(IdDescProd);

Obj.setOpcion(Opcion);
return Obj.DSetPeso(Obj);
}


public DefaultTableModel NGetPeso(int IdPeso, String Placa, String Opcion){
DPeso Obj = new DPeso();

Obj.setIdPeso(IdPeso);
Obj.setPlaca(Placa);


Obj.setOpcion(Opcion);


 return Obj.DGetPeso(Obj);
}
}
