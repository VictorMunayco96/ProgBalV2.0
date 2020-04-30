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
     P.`IdPeso` AS IdPeso,
     P.`TipoMovimiento` AS TipoMovimiento,
     P.`NumGuia` AS NumGuia,
     P.`FechaHoraSal` AS FechaHoraSal,
     P.`FechaHoraEnt` AS FechaHoraEnt,
     P.`PesoCE` AS PesoCE,
     P.`PesoCS` AS PesoCS,
     P.`NetoC` AS NetoC,
     P.`ObservE` AS ObservE,
     P.`ObservS` AS ObservS,
     P.`Estado` AS Estado,
     P.`IdUsuario` AS IdUsuario,
     PC.`IdProveClien` AS IdProveClien,
     PC.`RazonSocial` AS RazonSocial,
     P.`Precinto` AS Precinto,
     CV.`IdConductorVehiculo` AS IdConductorVehiculo,
     V.`Placa` AS Placa,
     concat(C.`Nombre`," ",C.`Apellidos`) AS Nombre,
     DB.`IdDestinoBloq` AS IdDestino,
     concat(D.destino,"/ ",concat(DD.`DestinoDes`,"/ ",DB.`DestinoBloq`)) AS Destino,
     
     
     DP.`IdDescProd` AS IdDescProd,
     DP.`DescProd` AS DescProd
FROM
     ProveClien PC  INNER JOIN Peso P ON PC.`IdProveClien` = P.`IdProveClien`
     INNER JOIN ConductorVehiculo CV ON P.`IdConductorVehiculo` = CV.`IdConductorVehiculo`
     INNER JOIN DestinoBloq DB ON P.`IdDestinobloq` = DB.`IdDestinobloq`
     INNER JOIN DescProd DP ON P.`IdDescProd` = DP.`IdDescProd`
     INNER JOIN Conductor C ON CV.`IdConductor` = C.`IdConductor`
     INNER JOIN Vehiculo V ON CV.`IdPlaca` = V.`IdPlaca`
     INNER JOIN DestinoDesc DD  ON DB.`IdDestinoDesc` = DD.`IdDestinoDesc`
	 INNER JOIN Destino D  ON DD.`IdDestino` = D.`IdDestino`
   
     

     
     where P.`Estado`="D" 
     
     order by P.IdPeso Desc limit 14000;
     End If;



if _Opcion='IDPE' then
 SELECT
     P.`IdPeso` AS IdPeso,
     P.`TipoMovimiento` AS TipoMovimiento,
     P.`NumGuia` AS NumGuia,
     P.`FechaHoraSal` AS FechaHoraSal,
     P.`FechaHoraEnt` AS FechaHoraEnt,
     P.`PesoCE` AS PesoCE,
     P.`PesoCS` AS PesoCS,
     P.`NetoC` AS NetoC,
     P.`ObservE` AS ObservE,
     P.`ObservS` AS ObservS,
     P.`Estado` AS Estado,
     P.`IdUsuario` AS IdUsuario,
     PC.`IdProveClien` AS IdProveClien,
     PC.`RazonSocial` AS RazonSocial,
     P.`Precinto` AS Precinto,
     CV.`IdConductorVehiculo` AS IdConductorVehiculo,
     V.`Placa` AS Placa,
     concat(C.`Nombre`," ",C.`Apellidos`) AS Nombre,
     DB.`IdDestinoBloq` AS IdDestino,
     concat(D.destino,"/ ",concat(DD.`DestinoDes`,"/ ",DB.`DestinoBloq`)) AS Destino,
     
     
     DP.`IdDescProd` AS IdDescProd,
     DP.`DescProd` AS DescProd
FROM
     ProveClien PC  INNER JOIN Peso P ON PC.`IdProveClien` = P.`IdProveClien`
     INNER JOIN ConductorVehiculo CV ON P.`IdConductorVehiculo` = CV.`IdConductorVehiculo`
     INNER JOIN DestinoBloq DB ON P.`IdDestinobloq` = DB.`IdDestinobloq`
     INNER JOIN DescProd DP ON P.`IdDescProd` = DP.`IdDescProd`
     INNER JOIN Conductor C ON CV.`IdConductor` = C.`IdConductor`
     INNER JOIN Vehiculo V ON CV.`IdPlaca` = V.`IdPlaca`
     INNER JOIN DestinoDesc DD  ON DB.`IdDestinoDesc` = DD.`IdDestinoDesc`
	 INNER JOIN Destino D  ON DD.`IdDestino` = D.`IdDestino`
   
     

     
     where P.IdPeso=_IdPeso AND P.`Estado`="D" 
     
     order by P.IdPeso Desc limit 14000;
     End If;

if _Opcion='PLAC' then
 SELECT
     P.`IdPeso` AS IdPeso,
     P.`TipoMovimiento` AS TipoMovimiento,
     P.`NumGuia` AS NumGuia,
     P.`FechaHoraSal` AS FechaHoraSal,
     P.`FechaHoraEnt` AS FechaHoraEnt,
     P.`PesoCE` AS PesoCE,
     P.`PesoCS` AS PesoCS,
     P.`NetoC` AS NetoC,
     P.`ObservE` AS ObservE,
     P.`ObservS` AS ObservS,
     P.`Estado` AS Estado,
     P.`IdUsuario` AS IdUsuario,
     PC.`IdProveClien` AS IdProveClien,
     PC.`RazonSocial` AS RazonSocial,
     P.`Precinto` AS Precinto,
     CV.`IdConductorVehiculo` AS IdConductorVehiculo,
     V.`Placa` AS Placa,
     concat(C.`Nombre`," ",C.`Apellidos`) AS Nombre,
     DB.`IdDestinoBloq` AS IdDestino,
     concat(D.destino,"/ ",concat(DD.`DestinoDes`,"/ ",DB.`DestinoBloq`)) AS Destino,
     
     
     DP.`IdDescProd` AS IdDescProd,
     DP.`DescProd` AS DescProd
FROM
     ProveClien PC  INNER JOIN Peso P ON PC.`IdProveClien` = P.`IdProveClien`
     INNER JOIN ConductorVehiculo CV ON P.`IdConductorVehiculo` = CV.`IdConductorVehiculo`
     INNER JOIN DestinoBloq DB ON P.`IdDestinobloq` = DB.`IdDestinobloq`
     INNER JOIN DescProd DP ON P.`IdDescProd` = DP.`IdDescProd`
     INNER JOIN Conductor C ON CV.`IdConductor` = C.`IdConductor`
     INNER JOIN Vehiculo V ON CV.`IdPlaca` = V.`IdPlaca`
     INNER JOIN DestinoDesc DD  ON DB.`IdDestinoDesc` = DD.`IdDestinoDesc`
	 INNER JOIN Destino D  ON DD.`IdDestino` = D.`IdDestino`
   
     

     where V.`Placa`=_Placa and P.`Estado`="T" 
     
     order by P.IdPeso Desc limit 14000;
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
  select U.IdUsuario, U.Usuario, U.Contrasena from Usuario U where U.Usuario=_Usuario and U.Contrasena=_Contrasena and Estado=1
  order by U.IdUsuario desc ;
  
  End If;
  END
$$
   
   
   
   
   