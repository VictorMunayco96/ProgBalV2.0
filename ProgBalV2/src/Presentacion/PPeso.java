/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.Conexion;
import Library.DefaultValue;
import Negocios.NConductorVehiculo;
import Negocios.NDescProd;
import Negocios.NDestinoBloq;
import Negocios.NPeso;
import Negocios.NProveClien;
//import Library.DefaultValue;
//import Negocios.NConductorVehiculo;
//import Negocios.NDestino;
//import Negocios.NPeso;
//import Negocios.NProducto;
//import Negocios.NProveClien;
import java.awt.Toolkit;
import java.io.File;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperPrintManager;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.view.JasperViewer;
//import gnu.io.CommPort;
//import gnu.io.CommPortIdentifier;
//import gnu.io.SerialPort;
import java.awt.event.KeyEvent;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import javax.swing.JTable;
/**
 *
 * @author Victor
 */
public class PPeso extends javax.swing.JFrame {

    /**
     * Creates new form PPeso
     */
    public PPeso() {
        initComponents();
        TxtIdConductorVehiculo.setVisible(true);
//Arrancar();
        
        
        
    }

    /*-----------------------------------------------------------------PUERTO COM ---------------------------------------------*/
     /*-----------------------------------------------------------------PUERTO COM ---------------------------------------------*/
     /*-----------------------------------------------------------------PUERTO COM ---------------------------------------------*/
     /*-----------------------------------------------------------------PUERTO COM ---------------------------------------------*/
    
    
//    CommPortIdentifier portId;
//	Enumeration puertos;
//	SerialPort serialport;
//	static InputStream entrada = null;
//	Thread t;
    
    
    /*	public static class LeerSerial implements Runnable {
	   int aux;
       public void run () {
    	   while(true){
    		  try {
				aux = entrada.read(); // aqui estamos obteniendo nuestro dato serial
				Thread.sleep(100);
 				if (aux>0) {
					System.out.println((char)aux);//imprimimos el dato serial
                                        TxtPesoVarianza.setText(String.valueOf((char)aux));
				}				
			} catch (Exception e) {
 			} } }}

    
    void Arrancar(){
      //super();
        puertos=CommPortIdentifier.getPortIdentifiers();
        t = new Thread(new LeerSerial());
        while (puertos.hasMoreElements()) { //para recorrer el numero de los puertos, y especificar con cual quiero trabajar 
        	//hasmorelements mientras tenga mas eleementos
        	portId = (CommPortIdentifier) puertos.nextElement(); //next elemento recorre uno por uno
        	System.out.println(portId.getName()); //puertos disponbibles
        	if (portId.getName().equalsIgnoreCase("COM13")) {
        		try {
        		serialport= (SerialPort)portId.open("fdf", 500);//tiempo en ms
    				entrada = serialport.getInputStream();//esta variable del tipo InputStream obtiene el dato serial
   				t.start(); // inciamos el hilo para realizar nuestra accion de imprimir el dato serial
     		 
			} catch (Exception e) {
 			} } }
    }
    
    
    
    
    */
    
    
    
    
    
    
    
    
    
    
    
    
     /*-----------------------------------------------------------------PUERTO COM ---------------------------------------------*/
     /*-----------------------------------------------------------------PUERTO COM ---------------------------------------------*/
     /*-----------------------------------------------------------------PUERTO COM ---------------------------------------------*/
     /*-----------------------------------------------------------------PUERTO COM ---------------------------------------------*/
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
       
  

    
Conexion Cn = new Conexion();
    Connection Con = Cn.Conexion();
    String TipoMovimiento = "";
    String Estado = "T";

    
    
    public String ValidateDate(String Fecha) {

        try {
            if (Fecha != "") {
                return Fecha;
            }
        } catch (Exception e) {
            return "1990-09-09 00:00:00";
        }
        return "1990-09-09 00:00:00";
    }

    public String Movimiento() {

        if (TxtIdProducto.getText().isEmpty()) {
            return TipoMovimiento = "CLIENTE";
        } else {
            return TipoMovimiento = "PROVEEDOR";
        }

    }

    public String Neto() {

        int P1 = Integer.parseInt(TxtPesoCE.getText());
        int P2 = Integer.parseInt(TxtPesoCS.getText());

        int Neto = P1 - P2;

        if (Neto < 0) {
            return String.valueOf(Neto * (-1));
        } else {
            return String.valueOf(Neto);
        }

    }

    SimpleDateFormat Form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   

    public void UbicacionPeso() {
        int peso = 0;
        if (Estado.equals("T")) {
             Date Now = new Date();
            TxtPesoCE.setText(TxtPesoVarianza.getText());
            TipoMovimiento = Movimiento();
            TxtFechaHoraEnt.setText(Form.format(Now));
            VtnPeso.dispose();
        } else if (Estado.equals("D")) {
            TxtPesoCS.setText(TxtPesoVarianza.getText());
 Date Now = new Date();
            TxtFechaHoraSal.setText(Form.format(Now));
            TxtNetoC.setText(Neto());
            VtnPeso.dispose();
        }

    }

 

  

 

    
    
    
 public void ColumHide(int Num, JTable Nom){
    
    Nom.getColumnModel().getColumn(Num).setMaxWidth(0);

Nom.getColumnModel().getColumn(Num).setMinWidth(0);

Nom.getColumnModel().getColumn(Num).setPreferredWidth(0);
    
    }
 
 // <editor-fold defaultstate="collapsed" desc="PESO"> 
 NPeso NPeso = new NPeso();
 
 public void PGetPeso(String TextBusqueda, String Accion) {

        try {

        TblPeso.setModel(NPeso.NGetPeso(DefaultValue.Number(TextBusqueda), DefaultValue.Text(TextBusqueda), Accion));

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ERROR" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }
 
 
 
  // </editor-fold>  
 
 
 
  // <editor-fold defaultstate="collapsed" desc="PLACA"> 
 
    NConductorVehiculo NConductorVehiculo = new NConductorVehiculo();
    
    public void BusquedaPlaca() {

        try {
     PGetConductorVehiculo(DefaultValue.Text(TxtPlaca.getText()), "PLAC");

            TxtChofer.setText(TblConductorVehiculo.getValueAt(0, 3).toString());
            TxtIdConductorVehiculo.setText(TblConductorVehiculo.getValueAt(0, 0).toString());

        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "NO HAY REGISTRO", "MENSAJE", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    
        public void PGetConductorVehiculo(String TextBusqueda, String Accion) {

        try {

        TblConductorVehiculo.setModel(NConductorVehiculo.NGetConductorVehiculo(DefaultValue.Text(TextBusqueda),  Accion));

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }
 
 
 // </editor-fold> 
 
 
 
 
  // <editor-fold defaultstate="collapsed" desc="ProveCliente"> 
 
  NProveClien NProveClien = new NProveClien();
 
     public void PGetProveClien(String TextBusqueda, String Accion) {

        try {

   TblProveClien.setModel(NProveClien.NGetProveClien(DefaultValue.Number(TextBusqueda), DefaultValue.Text(TextBusqueda), Accion));

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }
 
     
     
       public void BusquedaIdProveClien() {

        try {
            PGetProveClien(DefaultValue.Text(TxtIdProveClien.getText()), "IDPR");

            TxtIdProveClien.setText(TblProveClien.getValueAt(0, 0).toString());
            TxtRazonSocial.setText(TblProveClien.getValueAt(0, 1).toString());
            
            
            
            
        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "NO HAY REGISTRO", "MENSAJE", JOptionPane.ERROR_MESSAGE);
        }

    }
     
     
     
 
 // </editor-fold>  
 
 
 // <editor-fold defaultstate="collapsed" desc="Destino">     
 
         NDestinoBloq NDestinoBloq = new NDestinoBloq();
         
         
            public void PGetDestino(String TextBusqueda, String Accion) {

        try {

       TblDestino.setModel(NDestinoBloq.NGetDestinoBloq(DefaultValue.Number(TextBusqueda), DefaultValue.Text(TextBusqueda),DefaultValue.Text(TextBusqueda), Accion));

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }
         
         
         
         
         public void BusquedaIdDestino() {

        try {
           PGetDestino(DefaultValue.Text(TxtIdDestino.getText()), "IDDE");

            TxtIdDestino.setText(TblDestino.getValueAt(0, 0).toString());
            TxtDestino.setText(TblDestino.getValueAt(0, 1).toString());

        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "NO HAY REGISTRO", "MENSAJE", JOptionPane.ERROR_MESSAGE);
        }

    }



 
         
       
       
        // </editor-fold>  
 
 // <editor-fold defaultstate="collapsed" desc="DescProd">     
 
 NDescProd NDescProd = new NDescProd();
 
 
    public void PGetDescProd(String TextBusqueda, String Accion) {

        try {

            TblProducto.setModel(NDescProd.NGetDescProd(DefaultValue.Number(TextBusqueda), DefaultValue.Text(TextBusqueda), Accion));
            ColumHide(0, TblProducto);
    
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }


       public void BusquedaIdProducto() {

        try {
           PGetDescProd(DefaultValue.Text(TxtIdProducto.getText()), "IDDE");

            TxtIdProducto.setText(TblProducto.getValueAt(0, 0).toString());
            TxtProducto.setText(TblProducto.getValueAt(0, 1).toString());

        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, "NO HAY REGISTRO", "MENSAJE", JOptionPane.ERROR_MESSAGE);
        }

    }



// </editor-fold>   
    
   
    



    ///////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////SETS AND GETS///////////////////////////////////////////////////
   
    String Accion = "I";

    public void PNew() {
        TxtIdPeso.setText("");
        TipoMovimiento = "";
        TxtNumGuia.setText("");
        TxtFechaHoraSal.setText("");
        TxtFechaHoraEnt.setText("");

        TxtChofer.setText("");
        TxtPesoCE.setText("");
        TxtPesoCS.setText("");
        TxtNetoC.setText("");
        TxtObservE.setText("");
        TxtObservS.setText("");
        Estado = "T";

        TxtIdProveClien.setText("");
        TxtRazonSocial.setText("");
        TxtIdDestino.setText("");
        TxtDestino.setText("");
        TxtIdProducto.setText("");
        TxtProducto.setText("");
        TxtIdConductorVehiculo.setText("");
        TxtPlaca.setText("");

        Accion = "I";

        BtnEliminar.setEnabled(false);
         jButton12.setEnabled(true);

    }

    
//
//    public void Imprimir() {
//    
//        if (Integer.parseInt(TxtPesoCE.getText())>Integer.parseInt(TxtPesoCS.getText())) {
//            Map p = new HashMap();
//           
//            
//             p.put("IDPESOS", Integer.parseInt(TxtIdPeso.getText()));
//            JasperReport report;
//            JasperPrint print;
//
//            try {
//                report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
//                        + "/src/Reportes/TicketBalanzaP.jrxml");
//
//                print = JasperFillManager.fillReport(report, p, Con);
//                JasperPrintManager.printReport(print, false);
//                
//                
////                JasperViewer view = new JasperViewer(print, true);
////                view.setTitle("Ticket Balanza");
////                view.setVisible(false);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }else{
//            Map p = new HashMap();
//           
//            
//             p.put("IDPESOS", Integer.parseInt(TxtIdPeso.getText()));
//            JasperReport report;
//            JasperPrint print;
//
//            try {
//                report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
//                        + "/src/Reportes/TicketBalanzaC.jrxml");
//
//                print = JasperFillManager.fillReport(report, p, Con);
//                JasperPrintManager.printReport(print, false);
//                
//                
////                JasperViewer view = new JasperViewer(print, true);
////                view.setTitle("Ticket Balanza");
////                view.setVisible(false);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//           
//       
//
//    }

    public void PSetPeso() {

        System.out.println(TipoMovimiento);
        System.out.println(TxtNumGuia.getText());
        System.out.println(TxtFechaHoraSal.getText());

        System.out.println(TxtFechaHoraEnt.getText());
        System.out.println(TxtObservE.getText());
        System.out.println(TxtObservS.getText());
        System.out.println(Estado);
//        System.out.println(PMenu.LblIdUsuario.getText());
        System.out.println(TxtDestino.getText());
        System.out.println(TxtIdProveClien.getText());
        System.out.println(TxtIdProducto.getText());
        System.out.println(TxtIdConductorVehiculo.getText());
        System.out.println(Accion);
        if (Accion.equals("I")) {

            if (!TxtPlaca.getText().isEmpty() && !TxtPesoCE.getText().isEmpty()) {
                try {

                  NPeso.NSetPeso(DefaultValue.Number(TxtIdPeso.getText()),
                           TipoMovimiento, 
                           DefaultValue.Long(TxtNumGuia.getText()),
                          "2000-12-12 00:00:00",
                        DefaultValue.Text(TxtFechaHoraEnt.getText()), 
                        DefaultValue.Number(TxtPesoCE.getText()), 
                        DefaultValue.Number(TxtPesoCS.getText()), 
                        DefaultValue.Number(TxtNetoC.getText()), 
                        DefaultValue.Text(TxtObservE.getText()), 
                        DefaultValue.Text(TxtObservS.getText()), 
                        Estado, 
                       
                        //Integer.parseInt(PMenu.LblIdUsuario.getText()),               CAMBIAR ESTE CAMPO CUANDO ESTE LA VENTANA PRINCIPAL
                        Integer.parseInt("70605597"),
                        DefaultValue.Number(TxtIdProveClien.getText()),
                        123456,//CAMBIAR CODIGO PRECINTO
                        DefaultValue.Number(TxtIdConductorVehiculo.getText()),
                        DefaultValue.NumberUno(TxtIdDestino.getText()), 
                        DefaultValue.NumberUno(TxtIdProducto.getText()), 
                         
                        Accion);

                    // PGetPeso(TxtBusqueda.getText(), "T");
                    JOptionPane.showMessageDialog(null, "REGISTRO GUARDADO");
                    PNew();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);

                }

            }
        } else if (Accion.equals("U")) {

            try {
                //MODIFICAR
//                NPeso.NSetPeso(DefaultValue.Number(TxtIdPeso.getText()),
//                        TipoMovimiento,
//                        DefaultValue.Long(TxtNumGuia.getText()),
//                        DefaultValue.Text(TxtFechaHoraSal.getText()),
//                        DefaultValue.Text(TxtFechaHoraEnt.getText()),
//                        DefaultValue.Number(TxtPesoCE.getText()),
//                        DefaultValue.Number(TxtPesoCS.getText()),
//                        DefaultValue.Number(TxtNetoC.getText()),
//                        DefaultValue.Text(TxtObservE.getText()),
//                        DefaultValue.Text(TxtObservS.getText()),
////                        Estado, Integer.parseInt(PMenu.LblIdUsuario.getText()),
//                        DefaultValue.Number(TxtIdProveClien.getText()),
//                        DefaultValue.NumberUno(TxtIdDestino.getText()),
//                        DefaultValue.NumberUno(TxtIdProducto.getText()),
//                        DefaultValue.Number(TxtIdConductorVehiculo.getText()),
//                        Accion);
                //PGetPeso(TxtBusqueda.getText(), "T");

                JOptionPane.showMessageDialog(null, "REGISTRO EDITADO");
                PNew();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);

            }

        } else if (Accion.equals("D")) {

            try {
                int confirmacion = JOptionPane.showConfirmDialog(rootPane, "¿ESTAS SEGURO DE ELIMINAR REGISTRO?", "MENSAJE", 2);
                if (confirmacion == 0) {

                    int fila = TblPeso.getSelectedRow();

//                    NPeso.NSetPeso(DefaultValue.Number(TxtIdPeso.getText()), "", DefaultValue.Long(TxtNumGuia.getText()), ValidateDate(TxtFechaHoraSal.getText()), DefaultValue.Text(TxtFechaHoraEnt.getText()), DefaultValue.Number(TxtPesoCE.getText()), DefaultValue.Number(TxtPesoCS.getText()), DefaultValue.Number(TxtNetoC.getText()), DefaultValue.Text(TxtObservE.getText()), DefaultValue.Text(TxtObservS.getText()), "", 0, DefaultValue.Number(TxtIdProveClien.getText()), DefaultValue.Number(TxtIdDestino.getText()), DefaultValue.Number(TxtIdProducto.getText()), DefaultValue.Number(TxtIdConductorVehiculo.getText()), Accion);
                    //  PGetPeso(TxtBusqueda.getText(), "T");
                    JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO");
                    PNew();
                }
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(rootPane, e);
                System.out.println(e);
            }
        } else if (Accion.equals("DES") && !TxtPesoCS.getText().isEmpty()&& !TxtDestino.getText().equals("INGRESAR CAMPO")&& !TxtProducto.getText().equals("INGRESAR CAMPO")) {

            try {
                //DESTARAR
                
                
                         
                
                
                
                
                NPeso.NSetPeso(DefaultValue.Number(TxtIdPeso.getText()),
                        TipoMovimiento,
                        DefaultValue.Long(TxtNumGuia.getText()),
                        DefaultValue.Text(TxtFechaHoraSal.getText()),
                        DefaultValue.Text(TxtFechaHoraEnt.getText()),
                        DefaultValue.Number(TxtPesoCE.getText()),
                        DefaultValue.Number(TxtPesoCS.getText()),
                        DefaultValue.Number(TxtNetoC.getText()),
                        DefaultValue.Text(TxtObservE.getText()),
                        DefaultValue.Text(TxtObservS.getText()),
 Estado, 
                       
                        //Integer.parseInt(PMenu.LblIdUsuario.getText()),               CAMBIAR ESTE CAMPO CUANDO ESTE LA VENTANA PRINCIPAL
                        Integer.parseInt("70605597"),
                        DefaultValue.Number(TxtIdProveClien.getText()),
                        123456,//CAMBIAR CODIGO PRECINTO
                         DefaultValue.Number(TxtIdConductorVehiculo.getText()),
                        DefaultValue.NumberUno(TxtIdDestino.getText()),
                        DefaultValue.NumberUno(TxtIdProducto.getText()),
                       
                        "U");
                PGetPeso("", "TODO");

                try {
                int confirmacion = JOptionPane.showConfirmDialog(rootPane, "¿DESEA IMPRIMIR TICKET?", "MENSAJE", 2);
                
                 if (confirmacion == 0) {

                   

//                   Imprimir();
                    PNew();
                }
                
                }catch(Exception e){
                  JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                
                
                
                
                JOptionPane.showMessageDialog(null, "PESO REGISTRADO");
                
                
                PNew();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);

            }

        }

    }

    ///////////////////////////////////////////////////////FIN////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VtnConductorVehiculo = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        TblConductorVehiculo = new javax.swing.JTable();
        VtnProducto = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        TxtBusquedaProducto = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TblProducto = new javax.swing.JTable();
        CboBusquedaProducto = new javax.swing.JComboBox<>();
        jButton16 = new javax.swing.JButton();
        VtnDestino = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        TxtBusquedaDestino = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TblDestino = new javax.swing.JTable();
        CboBusquedaDestino = new javax.swing.JComboBox<>();
        jButton18 = new javax.swing.JButton();
        VtnPeso = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        TxtPesoVarianza = new javax.swing.JTextField();
        jButton21 = new javax.swing.JButton();
        VtnProveClien = new javax.swing.JDialog();
        jPanel8 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        TxtBusquedaProveClien = new javax.swing.JTextField();
        jButton20 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        TblProveClien = new javax.swing.JTable();
        jButton22 = new javax.swing.JButton();
        CboBusquedaProveClien = new javax.swing.JComboBox<>();
        jDialog1 = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblPeso = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtIdPeso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtPlaca = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        TxtChofer = new javax.swing.JTextField();
        TxtNumGuia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        TxtFechaHoraSal = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        TxtFechaHoraEnt = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        TxtIdConductorVehiculo = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        TxtPesoCS = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        TxtIdProducto = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        TxtProducto = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButton12 = new javax.swing.JButton();
        TxtNetoC = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        TxtIdDestino = new javax.swing.JTextField();
        TxtDestino = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        TxtPesoCE = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        TxtObservE = new javax.swing.JEditorPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        TxtObservS = new javax.swing.JEditorPane();
        TxtIdProveClien = new javax.swing.JTextField();
        TxtRazonSocial = new javax.swing.JTextField();
        jButton19 = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        BtnEliminar1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        PesoGE = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        TxtPesoGS = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        TxtFechaGuia = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        TxtGuia = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jButton23 = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        TxtNetoG = new javax.swing.JTextField();

        TblConductorVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(TblConductorVehiculo);

        javax.swing.GroupLayout VtnConductorVehiculoLayout = new javax.swing.GroupLayout(VtnConductorVehiculo.getContentPane());
        VtnConductorVehiculo.getContentPane().setLayout(VtnConductorVehiculoLayout);
        VtnConductorVehiculoLayout.setHorizontalGroup(
            VtnConductorVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VtnConductorVehiculoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                .addContainerGap())
        );
        VtnConductorVehiculoLayout.setVerticalGroup(
            VtnConductorVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VtnConductorVehiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setBackground(new java.awt.Color(0, 153, 0));
        jLabel13.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("    PRODUCTO");
        jLabel13.setOpaque(true);

        jLabel14.setBackground(new java.awt.Color(255, 204, 0));
        jLabel14.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel14.setText("  MANTENIMIENTO");
        jLabel14.setOpaque(true);

        TxtBusquedaProducto.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TxtBusquedaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtBusquedaProductoActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(0, 153, 0));
        jButton15.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Búsqueda-32.png"))); // NOI18N
        jButton15.setBorderPainted(false);
        jButton15.setFocusPainted(false);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        TblProducto.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TblProducto.setRowHeight(35);
        TblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TblProductoMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(TblProducto);

        CboBusquedaProducto.setFont(new java.awt.Font("Segoe UI Light", 0, 15)); // NOI18N
        CboBusquedaProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DESCRIPCION" }));

        jButton16.setBackground(new java.awt.Color(0, 153, 0));
        jButton16.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Izquierda Filled-30.png"))); // NOI18N
        jButton16.setBorderPainted(false);
        jButton16.setFocusPainted(false);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(CboBusquedaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TxtBusquedaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtBusquedaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CboBusquedaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout VtnProductoLayout = new javax.swing.GroupLayout(VtnProducto.getContentPane());
        VtnProducto.getContentPane().setLayout(VtnProductoLayout);
        VtnProductoLayout.setHorizontalGroup(
            VtnProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 571, Short.MAX_VALUE)
            .addGroup(VtnProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(VtnProductoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        VtnProductoLayout.setVerticalGroup(
            VtnProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
            .addGroup(VtnProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(VtnProductoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setBackground(new java.awt.Color(0, 153, 0));
        jLabel17.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("DESTINO");
        jLabel17.setOpaque(true);

        jLabel18.setBackground(new java.awt.Color(255, 204, 0));
        jLabel18.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel18.setText("  MANTENIMIENTO");
        jLabel18.setOpaque(true);

        TxtBusquedaDestino.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TxtBusquedaDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtBusquedaDestinoActionPerformed(evt);
            }
        });

        jButton17.setBackground(new java.awt.Color(0, 153, 0));
        jButton17.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Búsqueda-32.png"))); // NOI18N
        jButton17.setBorderPainted(false);
        jButton17.setFocusPainted(false);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        TblDestino.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TblDestino.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TblDestino.setRowHeight(35);
        TblDestino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TblDestinoMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(TblDestino);

        CboBusquedaDestino.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        CboBusquedaDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DESTINO", "IDDESTINO" }));

        jButton18.setBackground(new java.awt.Color(0, 153, 0));
        jButton18.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Izquierda Filled-30.png"))); // NOI18N
        jButton18.setBorderPainted(false);
        jButton18.setFocusPainted(false);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CboBusquedaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtBusquedaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(TxtBusquedaDestino, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CboBusquedaDestino, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout VtnDestinoLayout = new javax.swing.GroupLayout(VtnDestino.getContentPane());
        VtnDestino.getContentPane().setLayout(VtnDestinoLayout);
        VtnDestinoLayout.setHorizontalGroup(
            VtnDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        VtnDestinoLayout.setVerticalGroup(
            VtnDestinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(0, 102, 0));

        TxtPesoVarianza.setBackground(new java.awt.Color(0, 0, 0));
        TxtPesoVarianza.setFont(new java.awt.Font("Segoe UI Emoji", 1, 48)); // NOI18N
        TxtPesoVarianza.setForeground(new java.awt.Color(255, 255, 255));
        TxtPesoVarianza.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtPesoVarianza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtPesoVarianzaActionPerformed(evt);
            }
        });
        TxtPesoVarianza.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtPesoVarianzaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtPesoVarianzaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtPesoVarianzaKeyTyped(evt);
            }
        });

        jButton21.setBackground(new java.awt.Color(255, 204, 0));
        jButton21.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Búsqueda-32.png"))); // NOI18N
        jButton21.setBorderPainted(false);
        jButton21.setFocusPainted(false);
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(TxtPesoVarianza, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(TxtPesoVarianza, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout VtnPesoLayout = new javax.swing.GroupLayout(VtnPeso.getContentPane());
        VtnPeso.getContentPane().setLayout(VtnPesoLayout);
        VtnPesoLayout.setHorizontalGroup(
            VtnPesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        VtnPesoLayout.setVerticalGroup(
            VtnPesoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setBackground(new java.awt.Color(0, 153, 0));
        jLabel19.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("    PRODUCTO");
        jLabel19.setOpaque(true);

        jLabel20.setBackground(new java.awt.Color(255, 204, 0));
        jLabel20.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel20.setText("  MANTENIMIENTO");
        jLabel20.setOpaque(true);

        TxtBusquedaProveClien.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TxtBusquedaProveClien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtBusquedaProveClienActionPerformed(evt);
            }
        });

        jButton20.setBackground(new java.awt.Color(0, 153, 0));
        jButton20.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Búsqueda-32.png"))); // NOI18N
        jButton20.setBorderPainted(false);
        jButton20.setFocusPainted(false);
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        TblProveClien.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        TblProveClien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TblProveClien.setRowHeight(35);
        TblProveClien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TblProveClienMousePressed(evt);
            }
        });
        jScrollPane8.setViewportView(TblProveClien);

        jButton22.setBackground(new java.awt.Color(0, 153, 0));
        jButton22.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Izquierda Filled-30.png"))); // NOI18N
        jButton22.setBorderPainted(false);
        jButton22.setFocusPainted(false);
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        CboBusquedaProveClien.setFont(new java.awt.Font("Segoe UI Light", 0, 15)); // NOI18N
        CboBusquedaProveClien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RAZON SOCIAL", "RUC", " " }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(CboBusquedaProveClien, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TxtBusquedaProveClien, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtBusquedaProveClien, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CboBusquedaProveClien, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout VtnProveClienLayout = new javax.swing.GroupLayout(VtnProveClien.getContentPane());
        VtnProveClien.getContentPane().setLayout(VtnProveClienLayout);
        VtnProveClienLayout.setHorizontalGroup(
            VtnProveClienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 571, Short.MAX_VALUE)
            .addGroup(VtnProveClienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(VtnProveClienLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        VtnProveClienLayout.setVerticalGroup(
            VtnProveClienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
            .addGroup(VtnProveClienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(VtnProveClienLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        TblPeso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TblPeso);

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setOpaque(true);
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 153, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("   CATEGORIA");
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(255, 204, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel2.setText("    MANTENIMIENTO");
        jLabel2.setOpaque(true);

        TxtIdPeso.setEditable(false);
        TxtIdPeso.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtIdPeso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TxtIdPesoMousePressed(evt);
            }
        });
        TxtIdPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdPesoActionPerformed(evt);
            }
        });
        TxtIdPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtIdPesoKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel3.setText("ID");

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel4.setText("PLACA");

        TxtPlaca.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtPlacaActionPerformed(evt);
            }
        });
        TxtPlaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtPlacaKeyPressed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 102, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Guardar-32.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 102, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Nuevo.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setFocusPainted(false);
        jButton2.setFocusable(false);
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        BtnEliminar.setBackground(new java.awt.Color(0, 102, 0));
        BtnEliminar.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        BtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Eliminar -32.png"))); // NOI18N
        BtnEliminar.setBorderPainted(false);
        BtnEliminar.setFocusPainted(false);
        BtnEliminar.setFocusable(false);
        BtnEliminar.setOpaque(true);
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 153, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Izquierda Filled-30.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setFocusPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 102, 0));
        jButton5.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("REGISTROS");
        jButton5.setBorderPainted(false);
        jButton5.setFocusPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel8.setText("CHOFER");

        TxtChofer.setEditable(false);
        TxtChofer.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtChofer.setFocusable(false);
        TxtChofer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtChoferActionPerformed(evt);
            }
        });

        TxtNumGuia.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtNumGuia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNumGuiaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel9.setText("N° GUIA");

        TxtFechaHoraSal.setEditable(false);
        TxtFechaHoraSal.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtFechaHoraSal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtFechaHoraSal.setFocusable(false);
        TxtFechaHoraSal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFechaHoraSalActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel15.setText("FECHA SALIDA");

        jLabel16.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel16.setText("FECHA ENTRADA");

        TxtFechaHoraEnt.setEditable(false);
        TxtFechaHoraEnt.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtFechaHoraEnt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtFechaHoraEnt.setFocusable(false);
        TxtFechaHoraEnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFechaHoraEntActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel32.setText("PESO 1");

        TxtIdConductorVehiculo.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        TxtIdConductorVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdConductorVehiculoActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel33.setText("PESO 2");

        TxtPesoCS.setEditable(false);
        TxtPesoCS.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        TxtPesoCS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtPesoCS.setFocusable(false);
        TxtPesoCS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtPesoCSActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel36.setText("OBSERVACION");

        jLabel37.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel37.setText("OBSERVACION");

        TxtIdProducto.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtIdProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdProductoActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel39.setText("PRODUCTO");

        TxtProducto.setEditable(false);
        TxtProducto.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtProducto.setFocusable(false);
        TxtProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtProductoActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(0, 102, 0));
        jButton12.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/BALANZA.PNG"))); // NOI18N
        jButton12.setBorderPainted(false);
        jButton12.setFocusPainted(false);
        jButton12.setOpaque(true);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        TxtNetoC.setEditable(false);
        TxtNetoC.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        TxtNetoC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtNetoC.setFocusable(false);

        jLabel34.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("NETO");

        jButton13.setBackground(new java.awt.Color(0, 153, 0));
        jButton13.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Búsqueda-32.png"))); // NOI18N
        jButton13.setBorderPainted(false);
        jButton13.setFocusPainted(false);
        jButton13.setFocusable(false);
        jButton13.setOpaque(true);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel44.setText("DESTINO");

        TxtIdDestino.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtIdDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdDestinoActionPerformed(evt);
            }
        });

        TxtDestino.setEditable(false);
        TxtDestino.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtDestino.setFocusable(false);
        TxtDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDestinoActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(0, 153, 0));
        jButton14.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Búsqueda-32.png"))); // NOI18N
        jButton14.setBorderPainted(false);
        jButton14.setFocusPainted(false);
        jButton14.setFocusable(false);
        jButton14.setOpaque(true);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        TxtPesoCE.setEditable(false);
        TxtPesoCE.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        TxtPesoCE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TxtPesoCE.setFocusable(false);
        TxtPesoCE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtPesoCEActionPerformed(evt);
            }
        });

        TxtObservE.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jScrollPane6.setViewportView(TxtObservE);

        TxtObservS.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jScrollPane7.setViewportView(TxtObservS);

        TxtIdProveClien.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtIdProveClien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdProveClienActionPerformed(evt);
            }
        });

        TxtRazonSocial.setEditable(false);
        TxtRazonSocial.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtRazonSocial.setFocusable(false);
        TxtRazonSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtRazonSocialActionPerformed(evt);
            }
        });

        jButton19.setBackground(new java.awt.Color(0, 153, 0));
        jButton19.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Búsqueda-32.png"))); // NOI18N
        jButton19.setBorderPainted(false);
        jButton19.setFocusPainted(false);
        jButton19.setFocusable(false);
        jButton19.setOpaque(true);
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel47.setText("PROVE/CLIEN");

        jLabel35.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("SELECCIONAR PESO");

        BtnEliminar1.setBackground(new java.awt.Color(0, 102, 0));
        BtnEliminar1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        BtnEliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/printer.png"))); // NOI18N
        BtnEliminar1.setBorderPainted(false);
        BtnEliminar1.setFocusPainted(false);
        BtnEliminar1.setFocusable(false);
        BtnEliminar1.setOpaque(true);
        BtnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane6))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtFechaHoraEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtPesoCE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(TxtFechaHoraSal, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TxtPesoCS, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane7))))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TxtNetoC)
                            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(TxtIdDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(TxtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(TxtIdProveClien, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(TxtRazonSocial)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TxtIdPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TxtNumGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TxtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TxtChofer, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TxtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(TxtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BtnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BtnEliminar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TxtIdConductorVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(632, 632, 632)
                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtIdPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtNumGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TxtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TxtChofer, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TxtIdProveClien, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TxtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TxtIdDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TxtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TxtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TxtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TxtIdConductorVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TxtFechaHoraEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtPesoCE, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtPesoCS, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtFechaHoraSal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(TxtNetoC, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jButton5))
        );

        jTabbedPane1.addTab("MATENIMIENTO", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setBackground(new java.awt.Color(0, 153, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("   CATEGORIA");
        jLabel10.setOpaque(true);

        jLabel11.setBackground(new java.awt.Color(255, 204, 0));
        jLabel11.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel11.setText("    MANTENIMIENTO");
        jLabel11.setOpaque(true);

        jButton7.setBackground(new java.awt.Color(0, 153, 0));
        jButton7.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Izquierda Filled-30.png"))); // NOI18N
        jButton7.setBorderPainted(false);
        jButton7.setFocusPainted(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        PesoGE.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        PesoGE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesoGEActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel40.setText("PESO G1");

        TxtPesoGS.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtPesoGS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtPesoGSActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel41.setText("PESO G2");

        TxtFechaGuia.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtFechaGuia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtFechaGuiaActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel42.setText("FECHA GUIA");

        TxtGuia.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtGuia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtGuiaActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel12.setText("N° GUIA");

        jLabel43.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel43.setText("PROV / CLIEN");

        jButton23.setBackground(new java.awt.Color(0, 153, 0));
        jButton23.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AImagenes/Izquierda Filled-30.png"))); // NOI18N
        jButton23.setBorderPainted(false);
        jButton23.setFocusPainted(false);
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel45.setText("NETO");

        TxtNetoG.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        TxtNetoG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNetoGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 58, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TxtNetoG, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TxtPesoGS, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PesoGE, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtFechaGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtFechaGuia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PesoGE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtPesoGS, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtNetoG, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DATOS GUIA", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
     public void BusIDPESO() {
String ID=JOptionPane.showInputDialog("Ingresar ID para busqueda:");
        PGetPeso(ID, "IDPE");

        TxtIdPeso.setText(TblPeso.getValueAt(0, 0).toString());
        TipoMovimiento = TblPeso.getValueAt(0, 1).toString();
        TxtNumGuia.setText(TblPeso.getValueAt(0, 2).toString());
        TxtFechaHoraSal.setText(TblPeso.getValueAt(0, 3).toString());
        TxtFechaHoraEnt.setText(TblPeso.getValueAt(0, 4).toString());
        TxtPesoCE.setText(TblPeso.getValueAt(0, 5).toString());
        TxtPesoCS.setText(TblPeso.getValueAt(0, 6).toString());
        TxtNetoC.setText(TblPeso.getValueAt(0, 7).toString());
        TxtObservE.setText(TblPeso.getValueAt(0, 8).toString());
        TxtObservS.setText(TblPeso.getValueAt(0, 9).toString());
        Estado = "D";
      //  TxtDNI.setText(TblPeso.getValueAt(0, 11).toString());
        TxtIdProveClien.setText(TblPeso.getValueAt(0, 12).toString());
        TxtRazonSocial.setText(TblPeso.getValueAt(0, 13).toString());
        TxtIdConductorVehiculo.setText(TblPeso.getValueAt(0, 14).toString());
        TxtPlaca.setText(TblPeso.getValueAt(0, 15).toString());
        TxtChofer.setText(TblPeso.getValueAt(0, 16).toString() + " " + TblPeso.getValueAt(0, 17).toString());
        TxtIdDestino.setText(TblPeso.getValueAt(0, 18).toString());
        TxtDestino.setText(TblPeso.getValueAt(0, 19).toString());
        TxtIdProducto.setText(TblPeso.getValueAt(0, 20).toString());
        TxtProducto.setText(TblPeso.getValueAt(0, 21).toString());
      jButton12.setEnabled(false);
      Accion="U";

    }
    public void Destarar() {
        
        
        System.out.println("DESTARAR");
            PGetPeso(DefaultValue.Text(TxtPlaca.getText()), "PLAC");    
       
            
            try {
            
            
            
        
        
       
        System.out.println(DefaultValue.Text(TxtPlaca.getText()));
        TxtIdPeso.setText(TblPeso.getValueAt(0, 0).toString());
        TipoMovimiento = TblPeso.getValueAt(0, 1).toString();
        TxtNumGuia.setText(TblPeso.getValueAt(0, 2).toString());
        //TxtFechaHoraSal.setText(TblPeso.getValueAt(0, 3).toString());
        TxtFechaHoraEnt.setText(TblPeso.getValueAt(0, 4).toString());
        TxtPesoCE.setText(TblPeso.getValueAt(0, 5).toString());
        //TxtPesoCS.setText(TblPeso.getValueAt(0, 6).toString());
        //TxtNetoC.setText(TblPeso.getValueAt(0, 7).toString());
        TxtObservE.setText(TblPeso.getValueAt(0, 8).toString());
        //TxtObservS.setText(TblPeso.getValueAt(0, 9).toString());
        Estado = "D";
        //TxtDNI.setText(TblPeso.getValueAt(0, 11).toString());
        TxtIdProveClien.setText(TblPeso.getValueAt(0, 12).toString());
        TxtRazonSocial.setText(TblPeso.getValueAt(0, 13).toString());
        int Precinto=Integer.parseInt(TblPeso.getValueAt(0, 14).toString());
        TxtIdConductorVehiculo.setText(TblPeso.getValueAt(0, 15).toString());
        TxtPlaca.setText(TblPeso.getValueAt(0, 16).toString());
        TxtChofer.setText(TblPeso.getValueAt(0, 17).toString());

                if (TblPeso.getValueAt(0, 18).toString().equals("1")) {
                    TxtIdDestino.setText("");
                }else{
                    TxtIdDestino.setText(TblPeso.getValueAt(0, 18).toString());
                }
        TxtDestino.setText(TblPeso.getValueAt(0, 19).toString());

        //TxtIdProducto.setText(TblPeso.getValueAt(0, 20).toString());
        
         if (TblPeso.getValueAt(0, 20).toString().equals("1")) {
                    TxtIdProducto.setText("");
                }else{
                    TxtIdProducto.setText(TblPeso.getValueAt(0, 20).toString());
                }
        
        
        TxtProducto.setText(TblPeso.getValueAt(0, 21).toString());
        Accion = "DES";
        } catch (NullPointerException e) {
            
            
            
             
            
            JOptionPane.showMessageDialog(rootPane,e+ "NO HAY VEHICULO PARA DESTARAR CON ESTA PLACA","MENSAJE",JOptionPane.ERROR_MESSAGE);
        }
  

    }
    private void TxtBusquedaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtBusquedaProductoActionPerformed
        if (TxtBusquedaProducto.getText().isEmpty()) {
            PGetDescProd(TxtBusquedaProducto.getText(), "TODO");
        } else {
            PGetDescProd(TxtBusquedaProducto.getText(), CboBusquedaProducto.getSelectedItem().toString().substring(0, 4));
        }        // TODO add your handling code here:
    }//GEN-LAST:event_TxtBusquedaProductoActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        if (TxtBusquedaProducto.getText().isEmpty()) {
            PGetDescProd(TxtBusquedaProducto.getText(), "TODO");
        } else {
            PGetDescProd(TxtBusquedaProducto.getText(), CboBusquedaProducto.getSelectedItem().toString().substring(0, 4));
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void TblProductoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblProductoMousePressed
        try {
            if (evt.getClickCount() == 2) {

                int fila = TblProducto.getSelectedRow();

                TxtIdProducto.setText(TblProducto.getValueAt(fila, 0).toString());
                TxtProducto.setText(TblProducto.getValueAt(fila, 1).toString());

                VtnProducto.dispose();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);

        }
    }//GEN-LAST:event_TblProductoMousePressed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        VtnProducto.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void TxtBusquedaDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtBusquedaDestinoActionPerformed
        if (TxtBusquedaDestino.getText().isEmpty()) {
            PGetDestino(TxtBusquedaDestino.getText(), "TODO");
        } else {
            PGetDestino(TxtBusquedaDestino.getText(), CboBusquedaDestino.getSelectedItem().toString().substring(0, 4));
        }
    }//GEN-LAST:event_TxtBusquedaDestinoActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        if (TxtBusquedaDestino.getText().isEmpty()) {
            PGetDestino(TxtBusquedaDestino.getText(), "TODO");
        } else {
            PGetDestino(TxtBusquedaDestino.getText(), CboBusquedaDestino.getSelectedItem().toString().substring(0, 4));
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void TblDestinoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblDestinoMousePressed
        try {
            if (evt.getClickCount() == 2) {

                int fila = TblDestino.getSelectedRow();

                TxtIdDestino.setText(TblDestino.getValueAt(fila, 0).toString());
                TxtDestino.setText(TblDestino.getValueAt(fila, 1).toString());
                VtnDestino.dispose();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);

        }
    }//GEN-LAST:event_TblDestinoMousePressed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        UbicacionPeso();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton21ActionPerformed

    private void TxtPesoVarianzaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPesoVarianzaKeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_TxtPesoVarianzaKeyPressed

    private void TxtPesoVarianzaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPesoVarianzaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtPesoVarianzaKeyReleased

    private void TxtPesoVarianzaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPesoVarianzaKeyTyped
        if (TxtPesoVarianza.getText().trim().length() > 4) {
            evt.consume();
        }
        char c = evt.getKeyChar();
        if (Character.isLetter(c) || c == ';' || c == '.' || c == ',' || c == '+' || c == '-' || c == '*' || c == '/') {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }              // TODO add your handling code here:
    }//GEN-LAST:event_TxtPesoVarianzaKeyTyped

    private void TxtPesoVarianzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtPesoVarianzaActionPerformed
        UbicacionPeso();
    }//GEN-LAST:event_TxtPesoVarianzaActionPerformed

    private void TxtBusquedaProveClienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtBusquedaProveClienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtBusquedaProveClienActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton20ActionPerformed

    private void TblProveClienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblProveClienMousePressed
        try {
            if (evt.getClickCount() == 2) {

                int fila = TblProveClien.getSelectedRow();

                TxtIdProveClien.setText(TblProveClien.getValueAt(fila, 0).toString());
                TxtRazonSocial.setText(TblProveClien.getValueAt(fila, 1).toString());
                VtnProveClien.dispose();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);

        }
    }//GEN-LAST:event_TblProveClienMousePressed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked

    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void TxtNetoGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNetoGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNetoGActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton23ActionPerformed

    private void TxtGuiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtGuiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtGuiaActionPerformed

    private void TxtFechaGuiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFechaGuiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtFechaGuiaActionPerformed

    private void TxtPesoGSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtPesoGSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtPesoGSActionPerformed

    private void PesoGEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesoGEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PesoGEActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void BtnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminar1ActionPerformed
//        Imprimir();        // TODO add your handling code here:
    }//GEN-LAST:event_BtnEliminar1ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        VtnProveClien.setVisible(true);
        VtnProveClien.setSize(588, 602);
        VtnProveClien.setLocationRelativeTo(this);
        VtnProveClien.setAlwaysOnTop(true);
        PGetProveClien(TxtBusquedaProveClien.getText(), "TODO");        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19ActionPerformed

    private void TxtRazonSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtRazonSocialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtRazonSocialActionPerformed

    private void TxtIdProveClienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdProveClienActionPerformed
        BusquedaIdProveClien();        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdProveClienActionPerformed

    private void TxtPesoCEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtPesoCEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtPesoCEActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed

        VtnDestino.setVisible(true);
        VtnDestino.setSize(527, 507);
        VtnDestino.setLocationRelativeTo(this);
        VtnDestino.setAlwaysOnTop(true);
        PGetDestino(TxtBusquedaDestino.getText(), "TODO");
    }//GEN-LAST:event_jButton14ActionPerformed

    private void TxtDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtDestinoActionPerformed

    private void TxtIdDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdDestinoActionPerformed
        BusquedaIdDestino();        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdDestinoActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        VtnProducto.setVisible(true);
        VtnProducto.setSize(588, 617);
        VtnProducto.setLocationRelativeTo(this);
        VtnProducto.setAlwaysOnTop(true);
        PGetDescProd(TxtBusquedaProducto.getText(), "TODO");
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        VtnPeso.setVisible(true);
        VtnPeso.setSize(457, 253);
        VtnPeso.setLocationRelativeTo(this);
        VtnPeso.setAlwaysOnTop(true);
        TxtPesoVarianza.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void TxtProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtProductoActionPerformed

    private void TxtIdProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdProductoActionPerformed
        BusquedaIdProducto();        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdProductoActionPerformed

    private void TxtPesoCSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtPesoCSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtPesoCSActionPerformed

    private void TxtIdConductorVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdConductorVehiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdConductorVehiculoActionPerformed

    private void TxtFechaHoraEntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFechaHoraEntActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtFechaHoraEntActionPerformed

    private void TxtFechaHoraSalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtFechaHoraSalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtFechaHoraSalActionPerformed

    private void TxtNumGuiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNumGuiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNumGuiaActionPerformed

    private void TxtChoferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtChoferActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtChoferActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        //        Accion = "D";
        //        PSetCategoria();        // TODO add your handling code here:
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PNew();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PSetPeso();

        //jPanel5.setVisible(true);
        //        PSetCategoria();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TxtPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtPlacaActionPerformed

        try {
            Destarar();
            
        } catch (Exception e) {
            System.out.println("BUsqueda PLACA");
            
            
            try {
                PGetConductorVehiculo(DefaultValue.Text(TxtPlaca.getText()), "PLAC");

            TxtChofer.setText(TblConductorVehiculo.getValueAt(0, 3).toString());
            TxtIdConductorVehiculo.setText(TblConductorVehiculo.getValueAt(0, 0).toString());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "NO HAY VEHICULO CON ESTA PLACA");
            }
            
           
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_TxtPlacaActionPerformed

    private void TxtIdPesoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtIdPesoKeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdPesoKeyPressed

    private void TxtIdPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdPesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdPesoActionPerformed

    private void TxtIdPesoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtIdPesoMousePressed
        if (evt.getClickCount()==2) {
            BusIDPESO();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdPesoMousePressed

    private void TxtPlacaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPlacaKeyPressed
     
  
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtPlacaKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
          new PPeso();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PPeso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PPeso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PPeso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PPeso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PPeso().setVisible(true);
              
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnEliminar1;
    private javax.swing.JComboBox<String> CboBusquedaDestino;
    private javax.swing.JComboBox<String> CboBusquedaProducto;
    private javax.swing.JComboBox<String> CboBusquedaProveClien;
    private javax.swing.JTextField PesoGE;
    private javax.swing.JTable TblConductorVehiculo;
    private javax.swing.JTable TblDestino;
    private javax.swing.JTable TblPeso;
    private javax.swing.JTable TblProducto;
    private javax.swing.JTable TblProveClien;
    private javax.swing.JTextField TxtBusquedaDestino;
    private javax.swing.JTextField TxtBusquedaProducto;
    private javax.swing.JTextField TxtBusquedaProveClien;
    private javax.swing.JTextField TxtChofer;
    private javax.swing.JTextField TxtDestino;
    private javax.swing.JTextField TxtFechaGuia;
    private javax.swing.JTextField TxtFechaHoraEnt;
    private javax.swing.JTextField TxtFechaHoraSal;
    private javax.swing.JTextField TxtGuia;
    private javax.swing.JTextField TxtIdConductorVehiculo;
    private javax.swing.JTextField TxtIdDestino;
    private javax.swing.JTextField TxtIdPeso;
    private javax.swing.JTextField TxtIdProducto;
    private javax.swing.JTextField TxtIdProveClien;
    private javax.swing.JTextField TxtNetoC;
    private javax.swing.JTextField TxtNetoG;
    private javax.swing.JTextField TxtNumGuia;
    private javax.swing.JEditorPane TxtObservE;
    private javax.swing.JEditorPane TxtObservS;
    private javax.swing.JTextField TxtPesoCE;
    private javax.swing.JTextField TxtPesoCS;
    private javax.swing.JTextField TxtPesoGS;
    public static javax.swing.JTextField TxtPesoVarianza;
    private javax.swing.JTextField TxtPlaca;
    private javax.swing.JTextField TxtProducto;
    private javax.swing.JTextField TxtRazonSocial;
    private javax.swing.JDialog VtnConductorVehiculo;
    private javax.swing.JDialog VtnDestino;
    private javax.swing.JDialog VtnPeso;
    private javax.swing.JDialog VtnProducto;
    private javax.swing.JDialog VtnProveClien;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
