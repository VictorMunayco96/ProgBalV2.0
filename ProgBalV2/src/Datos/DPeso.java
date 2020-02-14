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
 * @author Victor
 */
public class DPeso {
    
int IdPeso;
String TipoMovimiento;
long NumGuia;
String FechaHoraSal;
String FechaHoraEnt;
int PesoCE;
int PesoCS;
int NetoC;
String ObservE;
String ObservS;
String Estado;
int DNI;
int IdProveClien;
int Precinto;      
int IdDestinoBloq;
int IdDescProd;
int IdConductorVehiculo;
String Opcion;
String Placa;


public DPeso(){}

    public DPeso(int IdPeso, String TipoMovimiento, long NumGuia, String FechaHoraSal, String FechaHoraEnt, int PesoCE, int PesoCS, int NetoC, String ObservE, String ObservS, String Estado, int DNI, int IdProveClien, int Precinto, int IdDestinoBloq, int IdDescProd, int IdConductorVehiculo, String Opcion, String Placa) {
        this.IdPeso = IdPeso;
        this.TipoMovimiento = TipoMovimiento;
        this.NumGuia = NumGuia;
        this.FechaHoraSal = FechaHoraSal;
        this.FechaHoraEnt = FechaHoraEnt;
        this.PesoCE = PesoCE;
        this.PesoCS = PesoCS;
        this.NetoC = NetoC;
        this.ObservE = ObservE;
        this.ObservS = ObservS;
        this.Estado = Estado;
        this.DNI = DNI;
        this.IdProveClien = IdProveClien;
        this.Precinto = Precinto;
        this.IdDestinoBloq = IdDestinoBloq;
        this.IdDescProd = IdDescProd;
        this.IdConductorVehiculo = IdConductorVehiculo;
        this.Opcion = Opcion;
        this.Placa = Placa;
    }


   
   


    public String getOpcion() {
        return Opcion;
    }

    public void setOpcion(String Opcion) {
        this.Opcion = Opcion;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

 

    


public int getIdPeso(){
return IdPeso;
}

public String getTipoMovimiento(){
return TipoMovimiento;
}

public long getNumGuia(){
return NumGuia;
}

public String getFechaHoraSal(){
return FechaHoraSal;
}

public String getFechaHoraEnt(){
return FechaHoraEnt;
}

public int getPesoCE(){
return PesoCE;
}

public int getPesoCS(){
return PesoCS;
}

public int getNetoC(){
return NetoC;
}

public String getObservE(){
return ObservE;
}

public String getObservS(){
return ObservS;
}

public String getEstado(){
return Estado;
}

public int getDNI(){
return DNI;
}

public int getIdProveClien(){
return IdProveClien;
}



public int getIdConductorVehiculo(){
return IdConductorVehiculo;
}


public void setIdPeso(int IdPeso) {
this.IdPeso=IdPeso;
}
public void setTipoMovimiento(String TipoMovimiento) {
this.TipoMovimiento=TipoMovimiento;
}
public void setNumGuia(long NumGuia) {
this.NumGuia=NumGuia;
}
public void setFechaHoraSal(String FechaHoraSal) {
this.FechaHoraSal=FechaHoraSal;
}
public void setFechaHoraEnt(String FechaHoraEnt) {
this.FechaHoraEnt=FechaHoraEnt;
}
public void setPesoCE(int PesoCE) {
this.PesoCE=PesoCE;
}
public void setPesoCS(int PesoCS) {
this.PesoCS=PesoCS;
}
public void setNetoC(int NetoC) {
this.NetoC=NetoC;
}
public void setObservE(String ObservE) {
this.ObservE=ObservE;
}
public void setObservS(String ObservS) {
this.ObservS=ObservS;
}
public void setEstado(String Estado) {
this.Estado=Estado;
}
public void setDNI(int DNI) {
this.DNI=DNI;
}
public void setIdProveClien(int IdProveClien) {
this.IdProveClien=IdProveClien;
}

    public int getPrecinto() {
        return Precinto;
    }

    public void setPrecinto(int Precinto) {
        this.Precinto = Precinto;
    }

    public int getIdDestinoBloq() {
        return IdDestinoBloq;
    }

    public void setIdDestinoBloq(int IdDestinoBloq) {
        this.IdDestinoBloq = IdDestinoBloq;
    }

    public int getIdDescProd() {
        return IdDescProd;
    }

    public void setIdDescProd(int IdDescProd) {
        this.IdDescProd = IdDescProd;
    }






public void setIdConductorVehiculo(int IdConductorVehiculo) {
this.IdConductorVehiculo=IdConductorVehiculo;
}



public String DSetPeso(DPeso Campo) {
        Conexion Cn = new Conexion();
        Connection Con = Cn.Conexion();
        String rpta = "";
 try {
            CallableStatement Proc = Con.prepareCall(" CALL PASetPeso(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
Proc.setInt(1, Campo.getIdPeso());
Proc.setString(2, Campo.getTipoMovimiento());
Proc.setLong(3, Campo.getNumGuia());
Proc.setString(4, Campo.getFechaHoraSal());
Proc.setString(5, Campo.getFechaHoraEnt());
Proc.setInt(6, Campo.getPesoCE());
Proc.setInt(7, Campo.getPesoCS());
Proc.setInt(8, Campo.getNetoC());
Proc.setString(9, Campo.getObservE());
Proc.setString(10, Campo.getObservS());
Proc.setString(11, Campo.getEstado());
Proc.setInt(12, Campo.getDNI());
Proc.setInt(13, Campo.getIdProveClien());
Proc.setInt(14, Campo.getPrecinto());
Proc.setInt(15, Campo.getIdConductorVehiculo());
Proc.setInt(16, Campo.getIdDestinoBloq());
Proc.setInt(17, Campo.getIdDescProd());
Proc.setString(18, Campo.getOpcion());

 Proc.execute();
            rpta = "Ingreso correctamente";

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

            rpta = String.valueOf(e);
        }

        return rpta;

    }

  
public DefaultTableModel DGetPeso(DPeso Campo) {
        Conexion Cn = new Conexion();
        Connection Con = Cn.Conexion();
          
      
       DefaultTableModel modelo = null ;
String[] titulos = {"IdPeso", "TipoMovimiento", "NumGuia", "FechaHoraSal", "FechaHoraEnt", "PesoCE", "PesoCS", "NetoC", "ObservE", "ObservS", "Estado", "DNI", "IdProveClien", "RazonSocial", "Precinto", "IdConductorVehiculo", "Placa", "Nombre", "IdDestino", "Destino", "IdDescProd", "DescProd"};
        String[] registro = new String[22];

        modelo = new DefaultTableModel(null, titulos);

        try {

            CallableStatement Proc = Con.prepareCall(" CALL PAGetPeso(?,?,?)");
Proc.setInt(1, Campo.getIdPeso());
Proc.setString(2, Campo.getPlaca());
Proc.setString(3, Campo.getOpcion());
  
Proc.execute();
            ResultSet rs = Proc.executeQuery();
            while (rs.next()) {
registro[0] = rs.getString(1);
registro[1] = rs.getString(2);
registro[2] = rs.getString(3);
registro[3] = rs.getString(4);
registro[4] = rs.getString(5);
registro[5] = rs.getString(6);
registro[6] = rs.getString(7);
registro[7] = rs.getString(8);
registro[8] = rs.getString(9);
registro[9] = rs.getString(10);
registro[10] = rs.getString(11);
registro[11] = rs.getString(12);
registro[12] = rs.getString(13);
registro[13] = rs.getString(14);
registro[14] = rs.getString(15);
registro[15] = rs.getString(16);
registro[16] = rs.getString(17);
registro[17] = rs.getString(18);
registro[18] = rs.getString(19);
registro[19] = rs.getString(20);
registro[20] = rs.getString(21);
registro[21] = rs.getString(22);


modelo.addRow(registro);

            }
            
            return modelo;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "error aqui");
            return null;

        }}
   
    
    

    
    
    
}
