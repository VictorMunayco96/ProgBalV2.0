Use DBMolino;


DELIMITER $$
 CREATE PROCEDURE PAGetCoductorVehiculo(

in _Placa varchar(8),
in _Opcion varchar(1)

 )
BEGIN
 if _Opcion='PLAC' then 
     
     select CV.IdConductorVehiculo, CV.IdPlaca, V.Placa,C.Nombre,C.Apellidos from Conductor C
     inner join (ConductorVehiculo CV inner join Vehiculo V on CV.IdPlaca=V.IdPlaca) on C.IdConductor=CV.IdConductor
     where V.Placa=_Placa 
     order by CV.IdConductorVehiculo desc; 
     
     
     End IF;
   
   
   
   END
   $$
   
   
   
   DELIMITER $$
 CREATE PROCEDURE PAGetProveClien(

in _IdProveClien int,
in _RazonSocial varchar(70),
in _Opcion varchar(1)

 )
BEGIN
 if _Opcion='TODO' then 
     
     select IdProveClien, RazonSocial, Ruc from ProveClien 
     order by IdProveClien desc; 
     
     
     End IF;
 
 if _Opcion='RAZO' then 
     
     select IdProveClien, RazonSocial, Ruc from ProveClien 
     where RazonSocial like concat('%',_RazonSocial,'%')
     order by IdProveClien desc; 
     
     
     End IF;
 
 
 if _Opcion='IDPR' then 
     
     select IdProveClien, RazonSocial, Ruc from ProveClien 
     where IdProveClien=_IdProveClien
     order by IdProveClien desc; 
     
     
     End IF;
 
   END
   $$
   
   
   DELIMITER $$
 CREATE PROCEDURE PAGetProveClien(

in _IdProveClien int,
in _RazonSocial varchar(70),
in _Opcion varchar(1)

 )
BEGIN
 if _Opcion='TODO' then 
     
     select IdProveClien, RazonSocial, Ruc from ProveClien 
     order by IdProveClien desc; 
     
     
     End IF;
 
 if _Opcion='RAZO' then 
     
     select IdProveClien, RazonSocial, Ruc from ProveClien 
     where RazonSocial like concat('%',_RazonSocial,'%')
     order by IdProveClien desc; 
     
     
     End IF;
 
 
 if _Opcion='IDPR' then 
     
     select IdProveClien, RazonSocial, Ruc from ProveClien 
     where IdProveClien=_IdProveClien
     order by IdProveClien desc; 
     
     
     End IF;
 
   END
   $$ 
   
   
   
      DELIMITER $$

 CREATE PROCEDURE PAGetDestinoBloq(

in _IdDestinoBloq int,
in _DestinoBloq varchar(45),
in _CodDestinoBloq varchar(15),
in _Opcion varchar(1)

 )
BEGIN
 if _Opcion='TODO' then 


    select DB.IdDestinoBloq, DB.DestinoBloq, DD.DestinoDes, D.Destino from Destino D 
    inner join (DestinoDesc DD inner join DestinoBloq DB on DD.IdDestinoDesc=DB.IdDestinoDesc)
    on D.IdDestino=DD.IdDestino 
    order by DB.IdDestinoBloq desc
     
     
     End IF;
 
 if _Opcion='DEST' then 
     
  select DB.IdDestinoBloq, DB.DestinoBloq, DD.DestinoDes, D.Destino from Destino D 
    inner join (DestinoDesc DD inner join DestinoBloq DB on DD.IdDestinoDesc=DB.IdDestinoDesc)
    on D.IdDestino=DD.IdDestino 
    where D.DestinoBloq like concat('%',_DestinoBloq,'%')
    order by DB.IdDestinoBloq desc
     
     
     End IF;
 
 
   END

   $$ 


       DELIMITER $$

 CREATE PROCEDURE PAGetDescProd(

in _IdDescProd int,
in _DescProd varchar(60),
in _Opcion varchar(1)

 )
BEGIN
 if _Opcion='TODO' then 


    select IdDescProd, DescProd from DescProd
    order by IdDescProd desc
     
     
     End IF;
 
 if _Opcion='DESC' then 
     
  select IdDescProd, DescProd from DescProd 
    where DescProd like concat('%',_DescProd,'%') 
    order by IdDescProd desc
       
     
     End IF;
 


 if _Opcion='IDDE' then 
     
  select IdDescProd, DescProd from DescProd 
    where IdDescProd=_IdDescProd 
    order by IdDescProd desc
       
     
     End IF;
 
   END

   $$ 
   