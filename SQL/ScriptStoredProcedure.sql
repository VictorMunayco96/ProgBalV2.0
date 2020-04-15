Use DBMolino;


DELIMITER $$
 CREATE PROCEDURE PAGetCoductorVehiculo(

in _Placa varchar(8),
in _Opcion varchar(4)

 )
BEGIN
 if _Opcion='PLAC' then 
     
     select CV.IdConductorVehiculo, CV.IdPlaca, V.Placa,C.Nombre,C.Apellidos from Conductor C
     inner join (ConductorVehiculo CV inner join Vehiculo V on CV.IdPlaca=V.IdPlaca) on C.IdConductor=CV.IdConductor
     where V.Placa=_Placa and CV.Estado=1
     order by CV.IdConductorVehiculo desc; 
     
     
     End IF;
   
   
   
   END
   $$
   
   
   
   
   
   DELIMITER $$
 CREATE PROCEDURE PAGetProveClien(

in _IdProveClien int,
in _RazonSocial varchar(70),
in _Opcion varchar(4)

 )
BEGIN
 if _Opcion='TODO' then 
     
     select IdProveClien, RazonSocial, Ruc from ProveClien where Estado=1
     order by IdProveClien desc; 
     
     
     End IF;
 
 if _Opcion='RAZO' then 
     
     select IdProveClien, RazonSocial, Ruc from ProveClien 
     where RazonSocial like concat('%',_RazonSocial,'%') and Estado=1
     order by IdProveClien desc; 
     
     
     End IF;
 
 
 if _Opcion='IDPR' then 
     
     select IdProveClien, RazonSocial, Ruc from ProveClien 
     where IdProveClien=_IdProveClien and Estado=1
     order by IdProveClien desc; 
     
     
     End IF;
 
   END
   $$ 
   
   

  
      DELIMITER $$

 CREATE PROCEDURE PAGetDestinoBloq(

in _IdDestinoBloq int,
in _DestinoDes varchar(45),
in _CodDestinoBloq varchar(15),
in _Opcion varchar(4)

 )
BEGIN
 if _Opcion='TODO' then 


    select DB.IdDestinoBloq, DB.DestinoBloq, DD.DestinoDes, D.Destino from Destino D 
    inner join (DestinoDesc DD 
    inner join DestinoBloq DB 
    on DD.IdDestinoDesc=DB.IdDestinoDesc) 
    on D.IdDestino=DD.IdDestino 
    where DB.Estado=1
    order by DB.IdDestinoBloq desc;
     
     
     End IF;
 
 if _Opcion='DEST' then 
     
  select DB.IdDestinoBloq, DB.DestinoBloq, DD.DestinoDes, D.Destino from Destino D 
    inner join (DestinoDesc DD inner join DestinoBloq DB on DD.IdDestinoDesc=DB.IdDestinoDesc)
    on D.IdDestino=DD.IdDestino 
    where DD.DestinoDes like concat('%',_DestinoDes,'%')
     and DB.Estado=1
    order by DB.IdDestinoBloq desc;
     
     
     End IF;
     
      if _Opcion='IDDE' then 
     
  select DB.IdDestinoBloq, DB.DestinoBloq, DD.DestinoDes, D.Destino from Destino D 
    inner join (DestinoDesc DD inner join DestinoBloq DB on DD.IdDestinoDesc=DB.IdDestinoDesc)
    on D.IdDestino=DD.IdDestino 
    where DB.IdDestinoBloq=_IdDestinoBloq 
     and DB.Estado=1
    order by DB.IdDestinoBloq desc;
     
     
     End IF;
 
 
   END

   $$ 


       DELIMITER $$

 CREATE PROCEDURE PAGetDescProd(

in _IdDescProd int,
in _DescProd varchar(60),
in _Opcion varchar(4)

 )
BEGIN
 if _Opcion='TODO' then 


    select IdDescProd, DescProd from DescProd
    where Estado=1 
    order by IdDescProd desc;
     
     
     End IF;
 
 if _Opcion='DESC' then 
     
  select IdDescProd, DescProd from DescProd 
    where DescProd like concat('%',_DescProd,'%') and Estado=1
    order by IdDescProd desc;
       
     
     End IF;
 


 if _Opcion='IDDE' then 
     
  select IdDescProd, DescProd from DescProd 
    where IdDescProd=_IdDescProd and Estado=1
    order by IdDescProd desc;
       
     
     End IF;
 
   END

   $$ 
   
   

   
DELIMITER $$
CREATE PROCEDURE PASetPeso(

in _IdPeso Int,
in _TipoMovimiento varchar(45),
in _NumGuia bigint,
in _FechaHoraSal varchar(60),
in _FechaHoraEnt varchar(60),
in _PesoCE int,
in _PesoCS int,
in _NetoC int,
in _ObservE varchar(100),
in _ObservS varchar(100),
in _Estado varchar(45),
in _IdUsuario int,
in _IdProveClien int,
in _Precinto int,
in _IdConductorVehiculo int,
in _IdDestinoBloq int,
in _IdDescProd int,
in _Opcion varchar(1)

)
BEGIN
if _Opcion='I' then
  insert into Peso (TipoMovimiento, NumGuia, FechaHoraSal, FechaHoraEnt, PesoCE, PesoCS, NetoC, ObservE, ObservS, Estado,IdUsuario,
  IdProveClien, Precinto,IdDestinoBloq, IdDescProd, IdConductorVehiculo)
  values(_TipoMovimiento, _NumGuia, _FechaHoraSal, _FechaHoraEnt, _PesoCE, _PesoCS, _NetoC, _ObservE, _ObservS, _Estado,_IdUsuario,
  _IdProveClien, _Precinto,_IdDestinoBloq, _IdDescProd, _IdConductorVehiculo);
  End IF;

  if _Opcion='U' then
  Update Peso set TipoMovimiento=_TipoMovimiento, NumGuia=_NumGuia, FechaHoraSal=_FechaHoraSal, FechaHoraEnt=_FechaHoraEnt, PesoCE=_PesoCE, PesoCS=_PesoCS, 
 NetoC=_NetoC, ObservE=_ObservE, ObservS=_ObservS, Estado=_Estado,IdUsuario=_IdUsuario, IdProveClien=_IdProveClien, Precinto=_Precinto, IdDestinoBloq=_IdDestinoBloq, IdDescProd=_IdDescProd, IdConductorVehiculo=_IdConductorVehiculo where IdPeso=_IdPeso;

  End If;


  if _Opcion='D' then
  Update Peso set Estado="I" where IdPeso=_IdPeso;
  End If;
  END
$$

   
   
   
   
   
   
   
 
 
DELIMITER $$
CREATE PROCEDURE PAGetPeso(
in _IdPeso Int,
in _Placa varchar(8),
in _Opcion varchar(4)

)
BEGIN


if _Opcion='TODO' then
 SELECT
   /*0*/  peso.`IdPeso` AS IdPeso, 
   /*1*/  peso.`TipoMovimiento` AS TipoMovimiento,
	/*2*/ peso.`NumGuia` AS NumGuia,
    /*3*/ peso.`FechaHoraSal` AS FechaHoraSal,
    /*4*/ peso.`FechaHoraEnt` AS FechaHoraEnt,
    /*5*/ peso.`PesoCE` AS PesoCE,
    /*6*/ peso.`PesoCS` AS PesoCS,
    /*7*/ peso.`NetoC` AS NetoC,
    /*8*/ peso.`ObservE` AS ObservE,
    /*9*/ peso.`ObservS` AS ObservS,
    /*10*/ peso.`Estado` AS Estado,
    /*11*/ peso.`IdUsuario` AS IdUsuario,
    /*12*/ proveclien.`IdProveClien` AS IdProveClien,
    /*13*/ proveclien.`RazonSocial` AS RazonSocial,
    /*14*/ peso.`Precinto` AS Precinto,
    /*15*/ conductorvehiculo.`IdConductorVehiculo` AS IdConductorVehiculo,
    /*16*/ vehiculo.`Placa` AS Placa,
	/*17*/concat(conductor.`Nombre`," ",conductor.`Apellidos`) AS Nombre,
    /*18*/ destinoBloq.`IdDestinoBloq` AS IdDestino,
    /*19*/ concat(destino.destino,"/ ",concat(destinodesc.`DestinoDes`,"/ ",destinoBloq.`DestinoBloq`)) AS Destino,
     
     
  /*20*/   DescProd.`IdDescProd` AS IdDescProd,
 /*21*/    DescProd.`DescProd` AS DescProd
FROM
     `proveclien` proveclien INNER JOIN `peso` peso ON proveclien.`IdProveClien` = peso.`IdProveClien`
     INNER JOIN `conductorvehiculo` conductorvehiculo ON peso.`IdConductorVehiculo` = conductorvehiculo.`IdConductorVehiculo`
     INNER JOIN `destinobloq` destinobloq ON peso.`IdDestinobloq` = destinobloq.`IdDestinobloq`
     INNER JOIN `DescProd` DescProd ON peso.`IdDescProd` = DescProd.`IdDescProd`
     INNER JOIN `conductor` conductor ON conductorvehiculo.`IdConductor` = conductor.`IdConductor`
     INNER JOIN `vehiculo` vehiculo ON conductorvehiculo.`IdPlaca` = vehiculo.`IdPlaca`
     INNER JOIN `DestinoDesc` destinodesc  ON destinobloq.`IdDestinoDesc` = destinodesc.`IdDestinoDesc`
	 INNER JOIN `Destino` destino  ON destinodesc.`IdDestino` = destino.`IdDestino`
   
     

     
     where peso.`Estado`="D" 
     
     order by IdPeso Desc limit 14000;
     End If;



if _Opcion='IDPE' then
 SELECT
   /*0*/  peso.`IdPeso` AS IdPeso, 
   /*1*/  peso.`TipoMovimiento` AS TipoMovimiento,
	/*2*/ peso.`NumGuia` AS NumGuia,
    /*3*/ peso.`FechaHoraSal` AS FechaHoraSal,
    /*4*/ peso.`FechaHoraEnt` AS FechaHoraEnt,
    /*5*/ peso.`PesoCE` AS PesoCE,
    /*6*/ peso.`PesoCS` AS PesoCS,
    /*7*/ peso.`NetoC` AS NetoC,
    /*8*/ peso.`ObservE` AS ObservE,
    /*9*/ peso.`ObservS` AS ObservS,
    /*10*/ peso.`Estado` AS Estado,
    /*11*/ peso.`IdUsuario` AS IdUsuario,
    /*12*/ proveclien.`IdProveClien` AS IdProveClien,
    /*13*/ proveclien.`RazonSocial` AS RazonSocial,
    /*14*/ peso.`Precinto` AS Precinto,
    /*15*/ conductorvehiculo.`IdConductorVehiculo` AS IdConductorVehiculo,
    /*16*/ vehiculo.`Placa` AS Placa,
	/*17*/concat(conductor.`Nombre`," ",conductor.`Apellidos`) AS Nombre,
    /*18*/ destinoBloq.`IdDestinoBloq` AS IdDestino,
    /*19*/ concat(destino.destino,"/ ",concat(destinodesc.`DestinoDes`,"/ ",destinoBloq.`DestinoBloq`)) AS Destino,
     
     
  /*20*/   DescProd.`IdDescProd` AS IdDescProd,
 /*21*/    DescProd.`DescProd` AS DescProd
FROM
     `proveclien` proveclien INNER JOIN `peso` peso ON proveclien.`IdProveClien` = peso.`IdProveClien`
     INNER JOIN `conductorvehiculo` conductorvehiculo ON peso.`IdConductorVehiculo` = conductorvehiculo.`IdConductorVehiculo`
     INNER JOIN `destinobloq` destinobloq ON peso.`IdDestinobloq` = destinobloq.`IdDestinobloq`
     INNER JOIN `DescProd` DescProd ON peso.`IdDescProd` = DescProd.`IdDescProd`
     INNER JOIN `conductor` conductor ON conductorvehiculo.`IdConductor` = conductor.`IdConductor`
     INNER JOIN `vehiculo` vehiculo ON conductorvehiculo.`IdPlaca` = vehiculo.`IdPlaca`
     INNER JOIN `DestinoDesc` destinodesc  ON destinobloq.`IdDestinoDesc` = destinodesc.`IdDestinoDesc`
	 INNER JOIN `Destino` destino  ON destinodesc.`IdDestino` = destino.`IdDestino`
   
     

     
     where Peso.IdPeso=_IdPeso AND peso.`Estado`="D" 
     
     order by IdPeso Desc limit 14000;
     End If;

if _Opcion='PLAC' then
 SELECT
     peso.`IdPeso` AS IdPeso,
     peso.`TipoMovimiento` AS TipoMovimiento,
     peso.`NumGuia` AS NumGuia,
     peso.`FechaHoraSal` AS FechaHoraSal,
     peso.`FechaHoraEnt` AS FechaHoraEnt,
     peso.`PesoCE` AS PesoCE,
     peso.`PesoCS` AS PesoCS,
     peso.`NetoC` AS NetoC,
     peso.`ObservE` AS ObservE,
     peso.`ObservS` AS ObservS,
     peso.`Estado` AS Estado,
     /*11*/ peso.`IdUsuario` AS IdUsuario,
     proveclien.`IdProveClien` AS IdProveClien,
     proveclien.`RazonSocial` AS RazonSocial,
     peso.`Precinto` AS Precinto,
     conductorvehiculo.`IdConductorVehiculo` AS IdConductorVehiculo,
     vehiculo.`Placa` AS Placa,
     concat(conductor.`Nombre`," ",conductor.`Apellidos`) AS Nombre,
     destinoBloq.`IdDestinoBloq` AS IdDestino,
     concat(destino.destino,"/ ",concat(destinodesc.`DestinoDes`,"/ ",destinoBloq.`DestinoBloq`)) AS Destino,
     
     
     DescProd.`IdDescProd` AS IdDescProd,
     DescProd.`DescProd` AS DescProd
FROM
     `proveclien` proveclien INNER JOIN `peso` peso ON proveclien.`IdProveClien` = peso.`IdProveClien`
     INNER JOIN `conductorvehiculo` conductorvehiculo ON peso.`IdConductorVehiculo` = conductorvehiculo.`IdConductorVehiculo`
     INNER JOIN `destinobloq` destinobloq ON peso.`IdDestinobloq` = destinobloq.`IdDestinobloq`
     INNER JOIN `DescProd` DescProd ON peso.`IdDescProd` = DescProd.`IdDescProd`
     INNER JOIN `conductor` conductor ON conductorvehiculo.`IdConductor` = conductor.`IdConductor`
     INNER JOIN `vehiculo` vehiculo ON conductorvehiculo.`IdPlaca` = vehiculo.`IdPlaca`
     INNER JOIN `DestinoDesc` destinodesc  ON destinobloq.`IdDestinoDesc` = destinodesc.`IdDestinoDesc`
	 INNER JOIN `Destino` destino  ON destinodesc.`IdDestino` = destino.`IdDestino`
   
     

     where vehiculo.`Placa`=_Placa and peso.`Estado`="T" 
     
     order by IdPeso Desc limit 14000;
     End If;
     

  END
  
$$


DELIMITER $$
CREATE PROCEDURE PAGetUsuario(
in _Usuario varchar(45),
in _Contrasena varchar(45),
in _Opcion varchar(1)
)
BEGIN


  
  if _Opcion='L' then
  select U.IdUsuario, U.Usuario, U.Contrasena from Usuario U where U.Usuario=_Usuario and U.Contrasena=_Contrasena 
  order by U.IdUsuario desc ;
  
  End If;
  END
$$
   
   
   
   
   