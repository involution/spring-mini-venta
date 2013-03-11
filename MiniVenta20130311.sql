CREATE DATABASE  IF NOT EXISTS `MiniVenta` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `MiniVenta`;
-- MySQL dump 10.13  Distrib 5.5.29, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: MiniVenta
-- ------------------------------------------------------
-- Server version	5.5.29-0ubuntu0.12.10.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `CARGO`
--

DROP TABLE IF EXISTS `CARGO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CARGO` (
  `ID_CARGO` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(30) DEFAULT NULL,
  `ID_AREA` int(11) NOT NULL,
  PRIMARY KEY (`ID_CARGO`),
  KEY `FK_CARGO_ID_AREA` (`ID_AREA`),
  CONSTRAINT `CARGO_ibfk_1` FOREIGN KEY (`ID_AREA`) REFERENCES `AREA` (`ID_AREA`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CARGO`
--

LOCK TABLES `CARGO` WRITE;
/*!40000 ALTER TABLE `CARGO` DISABLE KEYS */;
INSERT INTO `CARGO` VALUES (1,'Almacenero',1),(2,'Vendedor',2);
/*!40000 ALTER TABLE `CARGO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `NOTA_PEDIDO_PRODUCTO`
--

DROP TABLE IF EXISTS `NOTA_PEDIDO_PRODUCTO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `NOTA_PEDIDO_PRODUCTO` (
  `ID_NPEDIDO` int(11) NOT NULL,
  `ID_PRODUCTO` int(11) NOT NULL,
  `DESCRIPCION` varchar(50) DEFAULT NULL,
  `PRECIO` decimal(8,2) NOT NULL,
  `CANTIDAD` int(11) NOT NULL,
  `DESCUENTO` decimal(3,0) DEFAULT NULL,
  KEY `FK_N_PEDIDO_PRODUCTOS_ID_NPEDIDO` (`ID_NPEDIDO`),
  KEY `FK_N_PEDIDO_PRODUCTOS_ID_PRODUCTO` (`ID_PRODUCTO`),
  CONSTRAINT `NOTA_PEDIDO_PRODUCTO_ibfk_1` FOREIGN KEY (`ID_NPEDIDO`) REFERENCES `NOTA_PEDIDO` (`ID_NPEDIDO`),
  CONSTRAINT `NOTA_PEDIDO_PRODUCTO_ibfk_2` FOREIGN KEY (`ID_PRODUCTO`) REFERENCES `PRODUCTO` (`ID_PRODUCTO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `NOTA_PEDIDO_PRODUCTO`
--

LOCK TABLES `NOTA_PEDIDO_PRODUCTO` WRITE;
/*!40000 ALTER TABLE `NOTA_PEDIDO_PRODUCTO` DISABLE KEYS */;
INSERT INTO `NOTA_PEDIDO_PRODUCTO` VALUES (14,2,'de 2.5\'\'',1.20,20,0),(14,1,'de 3\'\'',0.50,2,0),(15,2,'de 2.5\'\'',1.20,20,0),(15,3,'Cemento Sol',17.60,5,0),(15,1,'de 3\'\'',0.50,10,0),(16,3,'Cemento Sol',17.60,10,0),(17,2,'de 2.5\'\'',1.20,10,0),(17,3,'Cemento Sol',17.60,3,0),(18,1,'de 3\'\'',0.50,100,0),(19,2,'de 2.5\'\'',1.20,50,0),(20,2,'de 2.5\'\'',1.20,20,0),(21,3,'Cemento Sol',17.60,15,5),(21,1,'de 3\'\'',0.50,10,0),(22,3,'Cemento Sol',17.60,10,0),(22,1,'de 3\'\'',0.50,20,0),(22,2,'de 2.5\'\'',1.20,30,0),(23,3,'Cemento Sol',17.60,10,0),(23,1,'de 3\'\'',0.50,30,0),(23,2,'de 2.5\'\'',1.20,20,0),(24,2,'de 2.5\'\'',1.20,5,0),(25,3,'Cemento Sol',17.60,20,0),(25,2,'de 2.5\'\'',1.20,10,0),(25,1,'de 3\'\'',0.50,30,0),(26,3,'Cemento Sol',17.60,4,0),(26,1,'de 3\'\'',0.50,5,0),(26,2,'de 2.5\'\'',1.20,7,0),(27,3,'Cemento Sol',17.60,10,0),(27,1,'de 3\'\'',0.50,2,0),(27,2,'de 2.5\'\'',1.20,30,0),(28,2,'de 2.5\'\'',1.20,30,0),(28,1,'de 3\'\'',0.50,20,0),(28,3,'Cemento Sol',17.60,10,0),(29,3,'Cemento Sol',17.60,50,0),(29,1,'de 3\'\'',0.50,40,0),(30,2,'de 2.5\'\'',1.20,2,0),(30,3,'Cemento Sol',17.60,40,0),(31,3,'Cemento Sol',17.60,50,0),(31,2,'de 2.5\'\'',1.20,50,0),(32,3,'Cemento Sol',17.60,20,0),(32,1,'de 3\'\'',0.50,20,0),(39,2,'de 2.5\'\'',1.20,30,0),(39,1,'de 3\'\'',0.50,20,0),(40,2,'de 2.5\'\'',1.20,30,0),(40,3,'Cemento Sol',17.60,10,0),(40,1,'de 3\'\'',0.50,20,0),(41,3,'Cemento Sol',17.60,10,0),(41,2,'de 2.5\'\'',1.20,10,0),(42,2,'de 2.5\'\'',1.20,20,0),(42,3,'Cemento Sol',17.60,30,0),(42,1,'de 3\'\'',0.50,10,0),(43,2,'de 2.5\'\'',1.20,20,0),(43,1,'de 3\'\'',0.50,10,0),(44,3,'Cemento Sol',17.60,10,0),(44,1,'de 3\'\'',0.50,10,0);
/*!40000 ALTER TABLE `NOTA_PEDIDO_PRODUCTO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PROVINCIA`
--

DROP TABLE IF EXISTS `PROVINCIA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PROVINCIA` (
  `ID_PROVINCIA` int(11) NOT NULL AUTO_INCREMENT,
  `CODPROV` varchar(2) NOT NULL,
  `CODDPTO` varchar(2) NOT NULL,
  `NOMBRE` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ID_PROVINCIA`)
) ENGINE=InnoDB AUTO_INCREMENT=197 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROVINCIA`
--

LOCK TABLES `PROVINCIA` WRITE;
/*!40000 ALTER TABLE `PROVINCIA` DISABLE KEYS */;
INSERT INTO `PROVINCIA` VALUES (1,'01','01','CHACHAPOYAS'),(2,'02','01','BAGUA'),(3,'03','01','BONGARA'),(4,'04','01','CONDORCANQUI'),(5,'05','01','LUYA'),(6,'06','01','RODRIGUEZ DE MENDOZA'),(7,'07','01','UTCUBAMBA'),(8,'01','02','HUARAZ'),(9,'02','02','AIJA'),(10,'03','02','ANTONIO RAYMONDI'),(11,'04','02','ASUNCION'),(12,'05','02','BOLOGNESI'),(13,'06','02','CARHUAZ'),(14,'07','02','CARLOS FERMIN FITZCARRALD'),(15,'08','02','CASMA'),(16,'09','02','CORONGO'),(17,'10','02','HUARI'),(18,'11','02','HUARMEY'),(19,'12','02','HUAYLAS'),(20,'13','02','MARISCAL LUZURIAGA'),(21,'14','02','OCROS'),(22,'15','02','PALLASCA'),(23,'16','02','POMABAMBA'),(24,'17','02','RECUAY'),(25,'18','02','SANTA'),(26,'19','02','SIHUAS'),(27,'20','02','YUNGAY'),(28,'01','03','ABANCAY'),(29,'02','03','ANDAHUAYLAS'),(30,'03','03','ANTABAMBA'),(31,'04','03','AYMARAES'),(32,'05','03','COTABAMBAS'),(33,'06','03','CHINCHEROS'),(34,'07','03','GRAU'),(35,'01','04','AREQUIPA'),(36,'02','04','CAMANA'),(37,'03','04','CARAVELI'),(38,'04','04','CASTILLA'),(39,'05','04','CAYLLOMA'),(40,'06','04','CONDESUYOS'),(41,'07','04','ISLAY'),(42,'08','04','LA UNION'),(43,'01','05','HUAMANGA'),(44,'02','05','CANGALLO'),(45,'03','05','HUANCA SANCOS'),(46,'04','05','HUANTA'),(47,'05','05','LA MAR'),(48,'06','05','LUCANAS'),(49,'07','05','PARINACOCHAS'),(50,'08','05','PAUCAR DEL SARA SARA'),(51,'09','05','SUCRE'),(52,'10','05','VICTOR FAJARDO'),(53,'11','05','VILCAS HUAMAN'),(54,'01','06','CAJAMARCA'),(55,'02','06','CAJABAMBA'),(56,'03','06','CELENDIN'),(57,'04','06','CHOTA'),(58,'05','06','CONTUMAZA'),(59,'06','06','CUTERVO'),(60,'07','06','HUALGAYOC'),(61,'08','06','JAEN'),(62,'09','06','SAN IGNACIO'),(63,'10','06','SAN MARCOS'),(64,'11','06','SAN MIGUEL'),(65,'12','06','SAN PABLO'),(66,'13','06','SANTA CRUZ'),(67,'01','07','CALLAO'),(68,'01','08','CUSCO'),(69,'02','08','ACOMAYO'),(70,'03','08','ANTA'),(71,'04','08','CALCA'),(72,'05','08','CANAS'),(73,'06','08','CANCHIS'),(74,'07','08','CHUMBIVILCAS'),(75,'08','08','ESPINAR'),(76,'09','08','LA CONVENCION'),(77,'10','08','PARURO'),(78,'11','08','PAUCARTAMBO'),(79,'12','08','QUISPICANCHI'),(80,'13','08','URUBAMBA'),(81,'01','09','HUANCAVELICA'),(82,'02','09','ACOBAMBA'),(83,'03','09','ANGARAES'),(84,'04','09','CASTROVIRREYNA'),(85,'05','09','CHURCAMPA'),(86,'06','09','HUAYTARA'),(87,'07','09','TAYACAJA'),(88,'01','10','HUANUCO'),(89,'02','10','AMBO'),(90,'03','10','DOS DE MAYO'),(91,'04','10','HUACAYBAMBA'),(92,'05','10','HUAMALIES'),(93,'06','10','LEONCIO PRADO'),(94,'07','10','MARA¥ON'),(95,'08','10','PACHITEA'),(96,'09','10','PUERTO INCA'),(97,'10','10','LAURICOCHA'),(98,'11','10','YAROWILCA'),(99,'01','11','ICA'),(100,'02','11','CHINCHA'),(101,'03','11','NAZCA'),(102,'04','11','PALPA'),(103,'05','11','PISCO'),(104,'01','12','HUANCAYO'),(105,'02','12','CONCEPCION'),(106,'03','12','CHANCHAMAYO'),(107,'04','12','JAUJA'),(108,'05','12','JUNIN'),(109,'06','12','SATIPO'),(110,'07','12','TARMA'),(111,'08','12','YAULI'),(112,'09','12','CHUPACA'),(113,'01','13','TRUJILLO'),(114,'02','13','ASCOPE'),(115,'03','13','BOLIVAR'),(116,'04','13','CHEPEN'),(117,'05','13','JULCAN'),(118,'06','13','OTUZCO'),(119,'07','13','PACASMAYO'),(120,'08','13','PATAZ'),(121,'09','13','SANCHEZ CARRION'),(122,'10','13','SANTIAGO DE CHUCO'),(123,'11','13','GRAN CHIMU'),(124,'12','13','VIRU'),(125,'01','14','CHICLAYO'),(126,'02','14','FERRE¥AFE'),(127,'03','14','LAMBAYEQUE'),(128,'01','15','LIMA'),(129,'02','15','BARRANCA'),(130,'03','15','CAJATAMBO'),(131,'04','15','CANTA'),(132,'05','15','CA¥ETE'),(133,'06','15','HUARAL'),(134,'07','15','HUAROCHIRI'),(135,'08','15','HUAURA'),(136,'09','15','OYON'),(137,'10','15','YAUYOS'),(138,'01','16','MAYNAS'),(139,'02','16','ALTO AMAZONAS'),(140,'03','16','LORETO'),(141,'04','16','MARISCAL RAMON CASTILLA'),(142,'05','16','REQUENA'),(143,'06','16','UCAYALI'),(144,'07','16','DATEM DEL MARA¥ON'),(145,'01','17','TAMBOPATA'),(146,'02','17','MANU'),(147,'03','17','TAHUAMANU'),(148,'01','18','MARISCAL NIETO'),(149,'02','18','GENERAL SANCHEZ CERRO'),(150,'03','18','ILO'),(151,'01','19','PASCO'),(152,'02','19','DANIEL ALCIDES CARRION'),(153,'03','19','OXAPAMPA'),(154,'01','20','PIURA'),(155,'02','20','AYABACA'),(156,'03','20','HUANCABAMBA'),(157,'04','20','MORROPON'),(158,'05','20','PAITA'),(159,'06','20','SULLANA'),(160,'07','20','TALARA'),(161,'08','20','SECHURA'),(162,'01','21','PUNO'),(163,'02','21','AZANGARO'),(164,'03','21','CARABAYA'),(165,'04','21','CHUCUITO'),(166,'05','21','EL COLLAO'),(167,'06','21','HUANCANE'),(168,'07','21','LAMPA'),(169,'08','21','MELGAR'),(170,'09','21','MOHO'),(171,'10','21','SAN ANTONIO DE PUTINA'),(172,'11','21','SAN ROMAN'),(173,'12','21','SANDIA'),(174,'13','21','YUNGUYO'),(175,'01','22','MOYOBAMBA'),(176,'02','22','BELLAVISTA'),(177,'03','22','EL DORADO'),(178,'04','22','HUALLAGA'),(179,'05','22','LAMAS'),(180,'06','22','MARISCAL CACERES'),(181,'07','22','PICOTA'),(182,'08','22','RIOJA'),(183,'09','22','SAN MARTIN'),(184,'10','22','TOCACHE'),(185,'01','23','TACNA'),(186,'02','23','CANDARAVE'),(187,'03','23','JORGE BASADRE'),(188,'04','23','TARATA'),(189,'01','24','TUMBES'),(190,'02','24','CONTRALMIRANTE VILLAR'),(191,'03','24','ZARUMILLA'),(192,'01','25','CORONEL PORTILLO'),(193,'02','25','ATALAYA'),(194,'03','25','PADRE ABAD'),(195,'04','25','PURUS'),(196,'04','25','PURUS');
/*!40000 ALTER TABLE `PROVINCIA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `VENTA`
--

DROP TABLE IF EXISTS `VENTA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `VENTA` (
  `ID_VENTA` int(11) NOT NULL AUTO_INCREMENT,
  `FECHA` datetime NOT NULL,
  `TIPO_CAMBIO` decimal(3,2) DEFAULT NULL,
  `FECHA_ENTREGA` datetime DEFAULT NULL,
  `DIRECCION_ENTREGA` varchar(100) DEFAULT NULL,
  `ID_NPEDIDO` int(11) NOT NULL,
  `ID_EMPLEADO` int(11) NOT NULL,
  `ID_TIPO_PAGO` int(11) NOT NULL,
  `ID_MONEDA` int(11) NOT NULL,
  PRIMARY KEY (`ID_VENTA`),
  KEY `FK_VENTA_ID_NPEDIDO` (`ID_NPEDIDO`),
  KEY `FK_VENTA_ID_EMPLEADO` (`ID_EMPLEADO`),
  KEY `FK_VENTA_ID_TIPO_PAGO` (`ID_TIPO_PAGO`),
  KEY `FK_VENTA_ID_MONEDA` (`ID_MONEDA`),
  CONSTRAINT `VENTA_ibfk_1` FOREIGN KEY (`ID_NPEDIDO`) REFERENCES `NOTA_PEDIDO` (`ID_NPEDIDO`),
  CONSTRAINT `VENTA_ibfk_3` FOREIGN KEY (`ID_EMPLEADO`) REFERENCES `EMPLEADO` (`ID_EMPLEADO`),
  CONSTRAINT `VENTA_ibfk_4` FOREIGN KEY (`ID_TIPO_PAGO`) REFERENCES `TIPO_PAGO` (`ID_TIPO_PAGO`),
  CONSTRAINT `VENTA_ibfk_5` FOREIGN KEY (`ID_MONEDA`) REFERENCES `MONEDA` (`ID_MONEDA`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `VENTA`
--

LOCK TABLES `VENTA` WRITE;
/*!40000 ALTER TABLE `VENTA` DISABLE KEYS */;
INSERT INTO `VENTA` VALUES (1,'2013-01-15 18:54:14',0.00,'2013-01-15 00:00:00','Jr. Junin 3209',14,1,1,1),(3,'2013-01-19 10:14:21',0.00,'2013-01-19 00:00:00','Av. Arequipa 4322',40,1,1,1),(4,'2013-01-19 10:56:26',0.00,'2013-01-19 00:00:00','Av. Larco 542',32,1,1,1),(5,'2013-01-19 11:15:24',0.00,'2013-01-19 00:00:00','Jr. Junin 3209',30,1,1,1),(6,'2013-01-29 16:37:49',0.00,'2013-01-29 00:00:00','Jr. Junin 3209',14,1,1,1),(7,'2013-01-29 16:43:46',0.00,'2013-01-29 00:00:00','Av. Arequipa 4322',15,1,1,1),(8,'2013-01-29 16:49:11',0.00,'2013-01-29 00:00:00','Av. Larco 542',16,1,1,1),(9,'2013-01-30 00:08:17',0.00,'2013-01-30 00:00:00','Av. Larco 542',32,1,1,1),(10,'2013-01-31 23:18:36',0.00,'2013-01-31 00:00:00','Jr. Junin 3209',14,1,1,1),(11,'2013-02-06 12:18:58',0.00,'2013-02-06 00:00:00','Jr. Junin 3209',14,1,1,1),(12,'2013-02-06 16:33:06',0.00,'2013-02-06 00:00:00','Jr. Junin 3209',30,1,1,1),(13,'2013-02-06 18:02:30',0.00,'2013-02-06 00:00:00','Jr. Junin 3209',17,1,1,1),(14,'2013-02-07 10:04:36',0.00,'2013-02-07 00:00:00','Av. Larco 542',32,1,1,1),(15,'2013-02-07 17:12:29',0.00,'2013-02-07 00:00:00','Av. Arequipa 4322',31,1,1,1),(16,'2013-02-08 17:21:59',0.00,'2013-02-08 00:00:00','Jr. Junin 3209',14,1,1,1),(17,'2013-02-11 10:36:02',0.00,'2013-02-11 00:00:00','Av. Larco 542',32,1,1,1),(18,'2013-02-11 10:46:47',0.00,'2013-02-11 00:00:00','Av. Arequipa 4322',41,1,1,1),(19,'2013-02-11 10:48:56',0.00,'2013-02-11 00:00:00','Av. Larco 542',32,1,1,1),(20,'2013-02-11 10:48:56',0.00,'2013-02-11 00:00:00','Av. Larco 542',32,1,1,1),(21,'2013-02-11 10:48:56',0.00,'2013-02-11 00:00:00','Av. Larco 542',32,1,1,1),(22,'2013-02-11 11:03:55',0.00,'2013-02-11 00:00:00','Av. Arequipa 4322',21,1,1,1),(23,'2013-02-11 11:03:55',0.00,'2013-02-11 00:00:00','Av. Arequipa 4322',21,1,1,1),(24,'2013-02-11 11:06:52',0.00,'2013-02-11 00:00:00','Av. Arequipa 4322',31,1,1,1),(25,'2013-02-11 11:31:17',0.00,'2013-02-11 00:00:00','Av. Arequipa 4322',21,1,1,1),(26,'2013-02-11 11:32:59',0.00,'2013-02-11 00:00:00','Av. Arequipa 4322',21,1,1,1),(27,'2013-02-11 11:36:51',0.00,'2013-02-11 00:00:00','Av. Aviacion 2310',42,1,1,1),(28,'2013-02-11 11:50:23',0.00,'2013-02-11 00:00:00','Jr. Junin 3209',43,1,1,1),(29,'2013-03-11 09:55:51',0.00,'2013-03-11 00:00:00','Av. Larco 542',44,2,1,1);
/*!40000 ALTER TABLE `VENTA` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=``@``*/ /*!50003 TRIGGER update_stock_product AFTER INSERT ON VENTA
FOR EACH ROW    
  BEGIN 
    -- First we declare all the variables we will need
    DECLARE id int(11);
    DECLARE cant int(11);

    -- flag which will be set to true, when cursor reaches end of table
    DECLARE exit_loop BOOLEAN;         
 
    -- Declare the sql for the cursor
    DECLARE example_cursor CURSOR FOR
        SELECT ID_PRODUCTO, CANTIDAD FROM NOTA_PEDIDO_PRODUCTO 
            WHERE ID_NPEDIDO = NEW.ID_NPEDIDO;
 
    -- Let mysql set exit_loop to true, if there are no more rows to iterate
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET exit_loop = TRUE;
 
    -- open the cursor
    OPEN example_cursor;
 
    -- marks the beginning of the loop
    example_loop: LOOP
 
        -- read the name from next row into the variable l_name
        FETCH  example_cursor INTO id, cant;
    
        -- check if the exit_loop flag has been set by mysql, 
        -- if it has been set we close the cursor and exit 
        -- the loop
        IF exit_loop THEN
            CLOSE example_cursor;
            LEAVE example_loop;
        END IF;

        UPDATE PRODUCTO set STOCK = STOCK-cant WHERE ID_PRODUCTO = id;
 
    END LOOP example_loop;
  END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `DEPARTAMENTO`
--

DROP TABLE IF EXISTS `DEPARTAMENTO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DEPARTAMENTO` (
  `ID_DEPARTAMENTO` int(11) NOT NULL AUTO_INCREMENT,
  `CODDPTO` varchar(2) NOT NULL,
  `NOMBRE` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ID_DEPARTAMENTO`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DEPARTAMENTO`
--

LOCK TABLES `DEPARTAMENTO` WRITE;
/*!40000 ALTER TABLE `DEPARTAMENTO` DISABLE KEYS */;
INSERT INTO `DEPARTAMENTO` VALUES (1,'01','AMAZONAS'),(2,'02','ANCASH'),(3,'03','APURIMAC'),(4,'04','AREQUIPA'),(5,'05','AYACUCHO'),(6,'06','CAJAMARCA'),(7,'07','CALLAO'),(8,'08','CUSCO'),(9,'09','HUANCAVELICA'),(10,'10','HUANUCO'),(11,'11','ICA'),(12,'12','JUNIN'),(13,'13','LA LIBERTAD'),(14,'14','LAMBAYEQUE'),(15,'15','LIMA'),(16,'16','LORETO'),(17,'17','MADRE DE DIOS'),(18,'18','MOQUEGUA'),(19,'19','PASCO'),(20,'20','PIURA'),(21,'21','PUNO'),(22,'22','SAN MARTIN'),(23,'23','TACNA'),(24,'24','TUMBES'),(25,'25','UCAYALI'),(26,'25','UCAYALI');
/*!40000 ALTER TABLE `DEPARTAMENTO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MARCA`
--

DROP TABLE IF EXISTS `MARCA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MARCA` (
  `ID_MARCA` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID_MARCA`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MARCA`
--

LOCK TABLES `MARCA` WRITE;
/*!40000 ALTER TABLE `MARCA` DISABLE KEYS */;
INSERT INTO `MARCA` VALUES (1,'Marca1'),(2,'Marca2'),(3,'Marca3');
/*!40000 ALTER TABLE `MARCA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TIPO_PAGO`
--

DROP TABLE IF EXISTS `TIPO_PAGO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TIPO_PAGO` (
  `ID_TIPO_PAGO` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID_TIPO_PAGO`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TIPO_PAGO`
--

LOCK TABLES `TIPO_PAGO` WRITE;
/*!40000 ALTER TABLE `TIPO_PAGO` DISABLE KEYS */;
INSERT INTO `TIPO_PAGO` VALUES (1,'CONTADO'),(2,'CREDITO');
/*!40000 ALTER TABLE `TIPO_PAGO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MODELO`
--

DROP TABLE IF EXISTS `MODELO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MODELO` (
  `ID_MODELO` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) DEFAULT NULL,
  `ID_MARCA` int(11) NOT NULL,
  PRIMARY KEY (`ID_MODELO`),
  KEY `FK_MODELO_ID_MARCA` (`ID_MARCA`),
  CONSTRAINT `MODELO_ibfk_1` FOREIGN KEY (`ID_MARCA`) REFERENCES `MARCA` (`ID_MARCA`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MODELO`
--

LOCK TABLES `MODELO` WRITE;
/*!40000 ALTER TABLE `MODELO` DISABLE KEYS */;
INSERT INTO `MODELO` VALUES (1,'Modelo1-1',1),(2,'Modelo1-2',1),(3,'Modelo2-1',2),(4,'Modelo2-2',2),(5,'Modelo2-3',2),(6,'Modelo3-1',3);
/*!40000 ALTER TABLE `MODELO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TIPO_CLIENTE`
--

DROP TABLE IF EXISTS `TIPO_CLIENTE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TIPO_CLIENTE` (
  `ID_TIPO_CLIENTE` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID_TIPO_CLIENTE`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TIPO_CLIENTE`
--

LOCK TABLES `TIPO_CLIENTE` WRITE;
/*!40000 ALTER TABLE `TIPO_CLIENTE` DISABLE KEYS */;
INSERT INTO `TIPO_CLIENTE` VALUES (1,'VIP'),(2,'NORMAL');
/*!40000 ALTER TABLE `TIPO_CLIENTE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CLIENTE`
--

DROP TABLE IF EXISTS `CLIENTE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CLIENTE` (
  `ID_CLIENTE` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) DEFAULT NULL,
  `APELLIDO` varchar(50) DEFAULT NULL,
  `FECHA` datetime DEFAULT NULL,
  `E_MAIL` varchar(50) DEFAULT NULL,
  `TELEFONO` varchar(7) DEFAULT NULL,
  `CELULAR` varchar(9) DEFAULT NULL,
  `DIRECCION_NEGOCIO` varchar(100) DEFAULT NULL,
  `RUC` char(11) DEFAULT NULL,
  `DNI` char(8) DEFAULT NULL,
  `RAZON_SOCIAL` varchar(100) DEFAULT NULL,
  `ESTADO` char(1) DEFAULT NULL,
  `ID_TIPO_CLIENTE` int(11) NOT NULL,
  `ID_DISTRITO` int(11) NOT NULL,
  `ID_PROVINCIA` int(11) NOT NULL,
  `ID_DEPARTAMENTO` int(11) NOT NULL,
  PRIMARY KEY (`ID_CLIENTE`),
  KEY `FK_CLIENTE_ID_TIPO` (`ID_TIPO_CLIENTE`),
  KEY `FK_CLIENTE_ID_DISTRITO` (`ID_DISTRITO`),
  KEY `FK_CLIENTE_ID_PROVINCIA` (`ID_PROVINCIA`),
  KEY `FK_CLIENTE_ID_DEPARTAMENTO` (`ID_DEPARTAMENTO`),
  CONSTRAINT `CLIENTE_ibfk_1` FOREIGN KEY (`ID_TIPO_CLIENTE`) REFERENCES `TIPO_CLIENTE` (`ID_TIPO_CLIENTE`),
  CONSTRAINT `CLIENTE_ibfk_2` FOREIGN KEY (`ID_DISTRITO`) REFERENCES `DISTRITO` (`ID_DISTRITO`),
  CONSTRAINT `CLIENTE_ibfk_3` FOREIGN KEY (`ID_PROVINCIA`) REFERENCES `PROVINCIA` (`ID_PROVINCIA`),
  CONSTRAINT `CLIENTE_ibfk_4` FOREIGN KEY (`ID_DEPARTAMENTO`) REFERENCES `DEPARTAMENTO` (`ID_DEPARTAMENTO`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CLIENTE`
--

LOCK TABLES `CLIENTE` WRITE;
/*!40000 ALTER TABLE `CLIENTE` DISABLE KEYS */;
INSERT INTO `CLIENTE` VALUES (1,'Juan Miguel','Gonsalez Prado','2012-12-10 11:00:42','juan231@hotmail.com','4323123','998766523','Av. Arequipa 4322','98798798787','73642736','Comunicore','1',2,1251,128,15),(3,'Jose','Perales','2012-12-13 11:02:00','perales@hotmail.com','5674433','998776654','Jr. Junin 3209','12345678911','22341934','','1',2,1331,133,15),(4,'Jenifer','Ramirez','2012-12-14 10:17:00','jr432@hotmail.com','5432423','998723432','Av. Larco 542','40263721','40273156','','1',1,1272,128,15),(5,'Favian','Jiminez','2013-02-08 10:02:00','fj42@romero.com','3455479','994321312','Av. Aviacion 2310','43456567878',NULL,'Romero S.A.','1',1,1251,128,15),(6,'Luis Miguel','Martinez Nuñez','2013-02-09 05:00:00','lm1022@yahoo.es','3412545','992341224','Av. Javier Prado Este 3212','',NULL,'','1',2,1251,128,15);
/*!40000 ALTER TABLE `CLIENTE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `AREA`
--

DROP TABLE IF EXISTS `AREA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AREA` (
  `ID_AREA` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ID_AREA`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AREA`
--

LOCK TABLES `AREA` WRITE;
/*!40000 ALTER TABLE `AREA` DISABLE KEYS */;
INSERT INTO `AREA` VALUES (1,'Almacen'),(2,'Ventas');
/*!40000 ALTER TABLE `AREA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PRODUCTO`
--

DROP TABLE IF EXISTS `PRODUCTO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PRODUCTO` (
  `ID_PRODUCTO` int(11) NOT NULL AUTO_INCREMENT,
  `CODIGO` char(10) DEFAULT NULL,
  `FECHA` datetime DEFAULT NULL,
  `NOMBRE` varchar(50) DEFAULT NULL,
  `PRECIO_UNIDAD` decimal(8,2) DEFAULT NULL,
  `PRECIO_MAYOR` decimal(8,2) DEFAULT NULL,
  `STOCK` int(11) DEFAULT NULL,
  `COLOR` varchar(30) DEFAULT NULL,
  `DESCRIPCION` varchar(100) DEFAULT NULL,
  `ID_MODELO` int(11) NOT NULL,
  `ID_MARCA` int(11) NOT NULL,
  PRIMARY KEY (`ID_PRODUCTO`),
  KEY `FK_DETALLE_PRODUCTO_ID_MODELO` (`ID_MODELO`),
  KEY `FK_DETALLE_PRODUCTO_ID_MARCA` (`ID_MARCA`),
  CONSTRAINT `PRODUCTO_ibfk_1` FOREIGN KEY (`ID_MODELO`) REFERENCES `MODELO` (`ID_MODELO`),
  CONSTRAINT `PRODUCTO_ibfk_2` FOREIGN KEY (`ID_MARCA`) REFERENCES `MARCA` (`ID_MARCA`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRODUCTO`
--

LOCK TABLES `PRODUCTO` WRITE;
/*!40000 ALTER TABLE `PRODUCTO` DISABLE KEYS */;
INSERT INTO `PRODUCTO` VALUES (1,'PROD000001','2012-12-22 06:02:00','Clavos',0.50,0.43,350,'Plateado','de 3\'\'',1,1),(2,'PROD000002','2012-12-22 06:03:00','Tornillos',1.20,1.10,340,'Plateado','de 2.5\'\'',1,1),(3,'PROD000003','2012-12-22 06:04:00','Cemento',17.60,17.55,80,'','Cemento Sol',4,2);
/*!40000 ALTER TABLE `PRODUCTO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CORTE`
--

DROP TABLE IF EXISTS `CORTE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CORTE` (
  `ID_CORTE` int(11) NOT NULL AUTO_INCREMENT,
  `FECHA_INICIO` datetime DEFAULT NULL,
  `FECHA_FINAL` datetime DEFAULT NULL,
  `ID_EMPLEADO` int(11) NOT NULL,
  PRIMARY KEY (`ID_CORTE`),
  KEY `FK_CORTE_ID_EMPLEADO` (`ID_EMPLEADO`),
  CONSTRAINT `CORTE_ibfk_1` FOREIGN KEY (`ID_EMPLEADO`) REFERENCES `EMPLEADO` (`ID_EMPLEADO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CORTE`
--

LOCK TABLES `CORTE` WRITE;
/*!40000 ALTER TABLE `CORTE` DISABLE KEYS */;
/*!40000 ALTER TABLE `CORTE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EMPLEADO`
--

DROP TABLE IF EXISTS `EMPLEADO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EMPLEADO` (
  `ID_EMPLEADO` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) DEFAULT NULL,
  `APELLIDO` varchar(50) DEFAULT NULL,
  `DNI` char(8) DEFAULT NULL,
  `TELEFONO` char(7) DEFAULT NULL,
  `E_MAIL` varchar(50) DEFAULT NULL,
  `DIRECCION` varchar(50) DEFAULT NULL,
  `USUARIO` char(18) DEFAULT NULL,
  `PASSWORD` char(18) DEFAULT NULL,
  `ESTADO` char(1) DEFAULT NULL,
  `CELULAR` char(9) DEFAULT NULL,
  `ID_CARGO` int(11) NOT NULL,
  `ID_AREA` int(11) NOT NULL,
  PRIMARY KEY (`ID_EMPLEADO`),
  KEY `FK_EMPLEADO_ID_CARGO` (`ID_CARGO`),
  KEY `FK_EMPLEADO_ID_AREA` (`ID_AREA`),
  CONSTRAINT `EMPLEADO_ibfk_1` FOREIGN KEY (`ID_CARGO`) REFERENCES `CARGO` (`ID_CARGO`),
  CONSTRAINT `EMPLEADO_ibfk_2` FOREIGN KEY (`ID_AREA`) REFERENCES `AREA` (`ID_AREA`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EMPLEADO`
--

LOCK TABLES `EMPLEADO` WRITE;
/*!40000 ALTER TABLE `EMPLEADO` DISABLE KEYS */;
INSERT INTO `EMPLEADO` VALUES (1,'Miguel','Cortez','98765432','3217654','miemail@hotmail.com','Av Arenales 2312','usuario1','54321','1','987543101',2,2),(2,'Martin','Gonzales','45546554','3455475','martin54@hotmail.com','Av. Aviacion 431','usuario2','2','1','998989893',2,2);
/*!40000 ALTER TABLE `EMPLEADO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CREDITO`
--

DROP TABLE IF EXISTS `CREDITO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CREDITO` (
  `ID_CREDITO` int(11) NOT NULL AUTO_INCREMENT,
  `SALDO` decimal(10,2) DEFAULT NULL,
  `LIMITE` decimal(10,2) DEFAULT NULL,
  `FECHA_LIMITE` datetime DEFAULT NULL,
  `ESTADO` char(1) DEFAULT NULL,
  `NRO_COUTAS` int(11) DEFAULT NULL,
  `ID_VENTA` int(11) NOT NULL,
  PRIMARY KEY (`ID_CREDITO`),
  KEY `FK_CREDITO_ID_VENTA` (`ID_VENTA`),
  CONSTRAINT `CREDITO_ibfk_1` FOREIGN KEY (`ID_VENTA`) REFERENCES `VENTA` (`ID_VENTA`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CREDITO`
--

LOCK TABLES `CREDITO` WRITE;
/*!40000 ALTER TABLE `CREDITO` DISABLE KEYS */;
/*!40000 ALTER TABLE `CREDITO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DETALLE_SUELDO`
--

DROP TABLE IF EXISTS `DETALLE_SUELDO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DETALLE_SUELDO` (
  `ID_DETALLE_SUELDO` int(11) NOT NULL AUTO_INCREMENT,
  `SUELDO` decimal(6,2) DEFAULT NULL,
  `GRATIFICACION` decimal(6,2) DEFAULT NULL,
  `FECHA` datetime DEFAULT NULL,
  `DESCUENTO` decimal(3,2) DEFAULT NULL,
  `SUELDO_NETO` decimal(6,2) DEFAULT NULL,
  `ID_EMPLEADO` int(11) NOT NULL,
  PRIMARY KEY (`ID_DETALLE_SUELDO`),
  KEY `FK_DETALLE_SUELDO_ID_EMPLEADO` (`ID_EMPLEADO`),
  CONSTRAINT `DETALLE_SUELDO_ibfk_1` FOREIGN KEY (`ID_EMPLEADO`) REFERENCES `EMPLEADO` (`ID_EMPLEADO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DETALLE_SUELDO`
--

LOCK TABLES `DETALLE_SUELDO` WRITE;
/*!40000 ALTER TABLE `DETALLE_SUELDO` DISABLE KEYS */;
/*!40000 ALTER TABLE `DETALLE_SUELDO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `NOTA_PEDIDO`
--

DROP TABLE IF EXISTS `NOTA_PEDIDO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `NOTA_PEDIDO` (
  `ID_NPEDIDO` int(11) NOT NULL AUTO_INCREMENT,
  `TOTAL` decimal(10,2) DEFAULT NULL,
  `FECHA` datetime DEFAULT NULL,
  `ID_CLIENTE` int(11) NOT NULL,
  PRIMARY KEY (`ID_NPEDIDO`),
  KEY `FK_NOTA_PEDIDO_IDCLIENTE` (`ID_CLIENTE`),
  CONSTRAINT `NOTA_PEDIDO_ibfk_1` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `CLIENTE` (`ID_CLIENTE`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `NOTA_PEDIDO`
--

LOCK TABLES `NOTA_PEDIDO` WRITE;
/*!40000 ALTER TABLE `NOTA_PEDIDO` DISABLE KEYS */;
INSERT INTO `NOTA_PEDIDO` VALUES (14,29.75,'2012-12-29 02:34:34',3),(15,139.23,'2012-12-29 10:49:51',1),(16,209.44,'2012-12-29 11:10:28',4),(17,77.11,'2012-12-29 11:19:14',3),(18,59.50,'2012-12-29 11:28:29',3),(19,71.40,'2012-12-29 11:34:47',4),(20,28.56,'2012-12-29 11:36:18',1),(21,314.16,'2012-12-29 18:35:20',1),(22,264.18,'2013-01-01 02:25:08',4),(23,255.85,'2013-01-01 02:35:33',4),(24,7.14,'2013-01-01 02:36:33',1),(25,451.01,'2013-01-01 02:39:04',3),(26,96.75,'2013-01-01 02:42:04',1),(27,253.47,'2013-01-01 02:55:19',1),(28,264.18,'2013-01-01 08:09:29',1),(29,1071.00,'2013-01-01 08:16:38',4),(30,840.62,'2013-01-01 08:17:08',3),(31,1118.60,'2013-01-04 17:31:27',1),(32,430.78,'2013-01-04 17:44:40',4),(39,54.74,'2013-01-19 00:49:59',3),(40,264.18,'2013-01-19 10:14:19',1),(41,223.72,'2013-02-11 10:46:46',1),(42,662.83,'2013-02-11 11:36:49',5),(43,34.51,'2013-02-11 11:50:22',3),(44,215.39,'2013-03-11 09:55:49',4);
/*!40000 ALTER TABLE `NOTA_PEDIDO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MONEDA`
--

DROP TABLE IF EXISTS `MONEDA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MONEDA` (
  `ID_MONEDA` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID_MONEDA`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MONEDA`
--

LOCK TABLES `MONEDA` WRITE;
/*!40000 ALTER TABLE `MONEDA` DISABLE KEYS */;
INSERT INTO `MONEDA` VALUES (1,'NUEVO SOL'),(2,'DOLARES AMERICANOS');
/*!40000 ALTER TABLE `MONEDA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DETALLE_PAGO`
--

DROP TABLE IF EXISTS `DETALLE_PAGO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DETALLE_PAGO` (
  `ID_DETALLE_PAGO` int(11) NOT NULL AUTO_INCREMENT,
  `FECHA_PAGO` datetime DEFAULT NULL,
  `MONTO_PAGO` decimal(10,2) DEFAULT NULL,
  `ESTADO` char(1) DEFAULT NULL,
  `ID_CREDITO` int(11) NOT NULL,
  PRIMARY KEY (`ID_DETALLE_PAGO`),
  KEY `FK_DETALLE_PAGO_ID_CREDITO` (`ID_CREDITO`),
  CONSTRAINT `DETALLE_PAGO_ibfk_1` FOREIGN KEY (`ID_CREDITO`) REFERENCES `CREDITO` (`ID_CREDITO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DETALLE_PAGO`
--

LOCK TABLES `DETALLE_PAGO` WRITE;
/*!40000 ALTER TABLE `DETALLE_PAGO` DISABLE KEYS */;
/*!40000 ALTER TABLE `DETALLE_PAGO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DISTRITO`
--

DROP TABLE IF EXISTS `DISTRITO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DISTRITO` (
  `ID_DISTRITO` int(11) NOT NULL AUTO_INCREMENT,
  `CODDIST` varchar(2) NOT NULL,
  `CODPROV` varchar(2) NOT NULL,
  `CODDPTO` varchar(2) NOT NULL,
  `NOMBRE` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ID_DISTRITO`)
) ENGINE=InnoDB AUTO_INCREMENT=1839 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DISTRITO`
--

LOCK TABLES `DISTRITO` WRITE;
/*!40000 ALTER TABLE `DISTRITO` DISABLE KEYS */;
INSERT INTO `DISTRITO` VALUES (1,'01','01','01','CHACHAPOYAS'),(2,'02','01','01','ASUNCION'),(3,'03','01','01','BALSAS'),(4,'04','01','01','CHETO'),(5,'05','01','01','CHILIQUIN'),(6,'06','01','01','CHUQUIBAMBA'),(7,'07','01','01','GRANADA'),(8,'08','01','01','HUANCAS'),(9,'09','01','01','LA JALCA'),(10,'10','01','01','LEIMEBAMBA'),(11,'11','01','01','LEVANTO'),(12,'12','01','01','MAGDALENA'),(13,'13','01','01','MARISCAL CASTILLA'),(14,'14','01','01','MOLINOPAMPA'),(15,'15','01','01','MONTEVIDEO'),(16,'16','01','01','OLLEROS'),(17,'17','01','01','QUINJALCA'),(18,'18','01','01','SAN FRANCISCO DE DAGUAS'),(19,'19','01','01','SAN ISIDRO DE MAINO'),(20,'20','01','01','SOLOCO'),(21,'21','01','01','SONCHE'),(22,'01','02','01','BAGUA'),(23,'02','02','01','ARAMANGO'),(24,'03','02','01','COPALLIN'),(25,'04','02','01','EL PARCO'),(26,'05','02','01','IMAZA'),(27,'06','02','01','LA PECA'),(28,'01','03','01','JUMBILLA'),(29,'02','03','01','CHISQUILLA'),(30,'03','03','01','CHURUJA'),(31,'04','03','01','COROSHA'),(32,'05','03','01','CUISPES'),(33,'06','03','01','FLORIDA'),(34,'07','03','01','JAZAN'),(35,'08','03','01','RECTA'),(36,'09','03','01','SAN CARLOS'),(37,'10','03','01','SHIPASBAMBA'),(38,'11','03','01','VALERA'),(39,'12','03','01','YAMBRASBAMBA'),(40,'01','04','01','NIEVA'),(41,'02','04','01','EL CENEPA'),(42,'03','04','01','RIO SANTIAGO'),(43,'01','05','01','LAMUD'),(44,'02','05','01','CAMPORREDONDO'),(45,'03','05','01','COCABAMBA'),(46,'04','05','01','COLCAMAR'),(47,'05','05','01','CONILA'),(48,'06','05','01','INGUILPATA'),(49,'07','05','01','LONGUITA'),(50,'08','05','01','LONYA CHICO'),(51,'09','05','01','LUYA'),(52,'10','05','01','LUYA VIEJO'),(53,'11','05','01','MARIA'),(54,'12','05','01','OCALLI'),(55,'13','05','01','OCUMAL'),(56,'14','05','01','PISUQUIA'),(57,'15','05','01','PROVIDENCIA'),(58,'16','05','01','SAN CRISTOBAL'),(59,'17','05','01','SAN FRANCISCO DEL YESO'),(60,'18','05','01','SAN JERONIMO'),(61,'19','05','01','SAN JUAN DE LOPECANCHA'),(62,'20','05','01','SANTA CATALINA'),(63,'21','05','01','SANTO TOMAS'),(64,'22','05','01','TINGO'),(65,'23','05','01','TRITA'),(66,'01','06','01','SAN NICOLAS'),(67,'02','06','01','CHIRIMOTO'),(68,'03','06','01','COCHAMAL'),(69,'04','06','01','HUAMBO'),(70,'05','06','01','LIMABAMBA'),(71,'06','06','01','LONGAR'),(72,'07','06','01','MARISCAL BENAVIDES'),(73,'08','06','01','MILPUC'),(74,'09','06','01','OMIA'),(75,'10','06','01','SANTA ROSA'),(76,'11','06','01','TOTORA'),(77,'12','06','01','VISTA ALEGRE'),(78,'01','07','01','BAGUA GRANDE'),(79,'02','07','01','CAJARURO'),(80,'03','07','01','CUMBA'),(81,'04','07','01','EL MILAGRO'),(82,'05','07','01','JAMALCA'),(83,'06','07','01','LONYA GRANDE'),(84,'07','07','01','YAMON'),(85,'01','01','02','HUARAZ'),(86,'02','01','02','COCHABAMBA'),(87,'03','01','02','COLCABAMBA'),(88,'04','01','02','HUANCHAY'),(89,'05','01','02','INDEPENDENCIA'),(90,'06','01','02','JANGAS'),(91,'07','01','02','LA LIBERTAD'),(92,'08','01','02','OLLEROS'),(93,'09','01','02','PAMPAS'),(94,'10','01','02','PARIACOTO'),(95,'11','01','02','PIRA'),(96,'12','01','02','TARICA'),(97,'01','02','02','AIJA'),(98,'02','02','02','CORIS'),(99,'03','02','02','HUACLLAN'),(100,'04','02','02','LA MERCED'),(101,'05','02','02','SUCCHA'),(102,'01','03','02','LLAMELLIN'),(103,'02','03','02','ACZO'),(104,'03','03','02','CHACCHO'),(105,'04','03','02','CHINGAS'),(106,'05','03','02','MIRGAS'),(107,'06','03','02','SAN JUAN DE RONTOY'),(108,'01','04','02','CHACAS'),(109,'02','04','02','ACOCHACA'),(110,'01','05','02','CHIQUIAN'),(111,'02','05','02','ABELARDO PARDO LEZAMETA'),(112,'03','05','02','ANTONIO RAYMONDI'),(113,'04','05','02','AQUIA'),(114,'05','05','02','CAJACAY'),(115,'06','05','02','CANIS'),(116,'07','05','02','COLQUIOC'),(117,'08','05','02','HUALLANCA'),(118,'09','05','02','HUASTA'),(119,'10','05','02','HUAYLLACAYAN'),(120,'11','05','02','LA PRIMAVERA'),(121,'12','05','02','MANGAS'),(122,'13','05','02','PACLLON'),(123,'14','05','02','SAN MIGUEL DE CORPANQUI'),(124,'15','05','02','TICLLOS'),(125,'01','06','02','CARHUAZ'),(126,'02','06','02','ACOPAMPA'),(127,'03','06','02','AMASHCA'),(128,'04','06','02','ANTA'),(129,'05','06','02','ATAQUERO'),(130,'06','06','02','MARCARA'),(131,'07','06','02','PARIAHUANCA'),(132,'08','06','02','SAN MIGUEL DE ACO'),(133,'09','06','02','SHILLA'),(134,'10','06','02','TINCO'),(135,'11','06','02','YUNGAR'),(136,'01','07','02','SAN LUIS'),(137,'02','07','02','SAN NICOLAS'),(138,'03','07','02','YAUYA'),(139,'01','08','02','CASMA'),(140,'02','08','02','BUENA VISTA ALTA'),(141,'03','08','02','COMANDANTE NOEL'),(142,'04','08','02','YAUTAN'),(143,'01','09','02','CORONGO'),(144,'02','09','02','ACO'),(145,'03','09','02','BAMBAS'),(146,'04','09','02','CUSCA'),(147,'05','09','02','LA PAMPA'),(148,'06','09','02','YANAC'),(149,'07','09','02','YUPAN'),(150,'01','10','02','HUARI'),(151,'02','10','02','ANRA'),(152,'03','10','02','CAJAY'),(153,'04','10','02','CHAVIN DE HUANTAR'),(154,'05','10','02','HUACACHI'),(155,'06','10','02','HUACCHIS'),(156,'07','10','02','HUACHIS'),(157,'08','10','02','HUANTAR'),(158,'09','10','02','MASIN'),(159,'10','10','02','PAUCAS'),(160,'11','10','02','PONTO'),(161,'12','10','02','RAHUAPAMPA'),(162,'13','10','02','RAPAYAN'),(163,'14','10','02','SAN MARCOS'),(164,'15','10','02','SAN PEDRO DE CHANA'),(165,'16','10','02','UCO'),(166,'01','11','02','HUARMEY'),(167,'02','11','02','COCHAPETI'),(168,'03','11','02','CULEBRAS'),(169,'04','11','02','HUAYAN'),(170,'05','11','02','MALVAS'),(171,'01','12','02','CARAZ'),(172,'02','12','02','HUALLANCA'),(173,'03','12','02','HUATA'),(174,'04','12','02','HUAYLAS'),(175,'05','12','02','MATO'),(176,'06','12','02','PAMPAROMAS'),(177,'07','12','02','PUEBLO LIBRE'),(178,'08','12','02','SANTA CRUZ'),(179,'09','12','02','SANTO TORIBIO'),(180,'10','12','02','YURACMARCA'),(181,'01','13','02','PISCOBAMBA'),(182,'02','13','02','CASCA'),(183,'03','13','02','ELEAZAR GUZMAN BARRON'),(184,'04','13','02','FIDEL OLIVAS ESCUDERO'),(185,'05','13','02','LLAMA'),(186,'06','13','02','LLUMPA'),(187,'07','13','02','LUCMA'),(188,'08','13','02','MUSGA'),(189,'01','14','02','OCROS'),(190,'02','14','02','ACAS'),(191,'03','14','02','CAJAMARQUILLA'),(192,'04','14','02','CARHUAPAMPA'),(193,'05','14','02','COCHAS'),(194,'06','14','02','CONGAS'),(195,'07','14','02','LLIPA'),(196,'08','14','02','SAN CRISTOBAL DE RAJAN'),(197,'09','14','02','SAN PEDRO'),(198,'10','14','02','SANTIAGO DE CHILCAS'),(199,'01','15','02','CABANA'),(200,'02','15','02','BOLOGNESI'),(201,'03','15','02','CONCHUCOS'),(202,'04','15','02','HUACASCHUQUE'),(203,'05','15','02','HUANDOVAL'),(204,'06','15','02','LACABAMBA'),(205,'07','15','02','LLAPO'),(206,'08','15','02','PALLASCA'),(207,'09','15','02','PAMPAS'),(208,'10','15','02','SANTA ROSA'),(209,'11','15','02','TAUCA'),(210,'01','16','02','POMABAMBA'),(211,'02','16','02','HUAYLLAN'),(212,'03','16','02','PAROBAMBA'),(213,'04','16','02','QUINUABAMBA'),(214,'01','17','02','RECUAY'),(215,'02','17','02','CATAC'),(216,'03','17','02','COTAPARACO'),(217,'04','17','02','HUAYLLAPAMPA'),(218,'05','17','02','LLACLLIN'),(219,'06','17','02','MARCA'),(220,'07','17','02','PAMPAS CHICO'),(221,'08','17','02','PARARIN'),(222,'09','17','02','TAPACOCHA'),(223,'10','17','02','TICAPAMPA'),(224,'01','18','02','CHIMBOTE'),(225,'02','18','02','CACERES DEL PERU'),(226,'03','18','02','COISHCO'),(227,'04','18','02','MACATE'),(228,'05','18','02','MORO'),(229,'06','18','02','NEPE¥A'),(230,'07','18','02','SAMANCO'),(231,'08','18','02','SANTA'),(232,'09','18','02','NUEVO CHIMBOTE'),(233,'01','19','02','SIHUAS'),(234,'02','19','02','ACOBAMBA'),(235,'03','19','02','ALFONSO UGARTE'),(236,'04','19','02','CASHAPAMPA'),(237,'05','19','02','CHINGALPO'),(238,'06','19','02','HUAYLLABAMBA'),(239,'07','19','02','QUICHES'),(240,'08','19','02','RAGASH'),(241,'09','19','02','SAN JUAN'),(242,'10','19','02','SICSIBAMBA'),(243,'01','20','02','YUNGAY'),(244,'02','20','02','CASCAPARA'),(245,'03','20','02','MANCOS'),(246,'04','20','02','MATACOTO'),(247,'05','20','02','QUILLO'),(248,'06','20','02','RANRAHIRCA'),(249,'07','20','02','SHUPLUY'),(250,'08','20','02','YANAMA'),(251,'01','01','03','ABANCAY'),(252,'02','01','03','CHACOCHE'),(253,'03','01','03','CIRCA'),(254,'04','01','03','CURAHUASI'),(255,'05','01','03','HUANIPACA'),(256,'06','01','03','LAMBRAMA'),(257,'07','01','03','PICHIRHUA'),(258,'08','01','03','SAN PEDRO DE CACHORA'),(259,'09','01','03','TAMBURCO'),(260,'01','02','03','ANDAHUAYLAS'),(261,'02','02','03','ANDARAPA'),(262,'03','02','03','CHIARA'),(263,'04','02','03','HUANCARAMA'),(264,'05','02','03','HUANCARAY'),(265,'06','02','03','HUAYANA'),(266,'07','02','03','KISHUARA'),(267,'08','02','03','PACOBAMBA'),(268,'09','02','03','PACUCHA'),(269,'10','02','03','PAMPACHIRI'),(270,'11','02','03','POMACOCHA'),(271,'12','02','03','SAN ANTONIO DE CACHI'),(272,'13','02','03','SAN JERONIMO'),(273,'14','02','03','SAN MIGUEL DE CHACCRAMPA'),(274,'15','02','03','SANTA MARIA DE CHICMO'),(275,'16','02','03','TALAVERA'),(276,'17','02','03','TUMAY HUARACA'),(277,'18','02','03','TURPO'),(278,'19','02','03','KAQUIABAMBA'),(279,'01','03','03','ANTABAMBA'),(280,'02','03','03','EL ORO'),(281,'03','03','03','HUAQUIRCA'),(282,'04','03','03','JUAN ESPINOZA MEDRANO'),(283,'05','03','03','OROPESA'),(284,'06','03','03','PACHACONAS'),(285,'07','03','03','SABAINO'),(286,'01','04','03','CHALHUANCA'),(287,'02','04','03','CAPAYA'),(288,'03','04','03','CARAYBAMBA'),(289,'04','04','03','CHAPIMARCA'),(290,'05','04','03','COLCABAMBA'),(291,'06','04','03','COTARUSE'),(292,'07','04','03','HUAYLLO'),(293,'08','04','03','JUSTO APU SAHUARAURA'),(294,'09','04','03','LUCRE'),(295,'10','04','03','POCOHUANCA'),(296,'11','04','03','SAN JUAN DE CHAC¥A'),(297,'12','04','03','SA¥AYCA'),(298,'13','04','03','SORAYA'),(299,'14','04','03','TAPAIRIHUA'),(300,'15','04','03','TINTAY'),(301,'16','04','03','TORAYA'),(302,'17','04','03','YANACA'),(303,'01','05','03','TAMBOBAMBA'),(304,'02','05','03','COTABAMBAS'),(305,'03','05','03','COYLLURQUI'),(306,'04','05','03','HAQUIRA'),(307,'05','05','03','MARA'),(308,'06','05','03','CHALLHUAHUACHO'),(309,'01','06','03','CHINCHEROS'),(310,'02','06','03','ANCO_HUALLO'),(311,'03','06','03','COCHARCAS'),(312,'04','06','03','HUACCANA'),(313,'05','06','03','OCOBAMBA'),(314,'06','06','03','ONGOY'),(315,'07','06','03','URANMARCA'),(316,'08','06','03','RANRACANCHA'),(317,'01','07','03','CHUQUIBAMBILLA'),(318,'02','07','03','CURPAHUASI'),(319,'03','07','03','GAMARRA'),(320,'04','07','03','HUAYLLATI'),(321,'05','07','03','MAMARA'),(322,'06','07','03','MICAELA BASTIDAS'),(323,'07','07','03','PATAYPAMPA'),(324,'08','07','03','PROGRESO'),(325,'09','07','03','SAN ANTONIO'),(326,'10','07','03','SANTA ROSA'),(327,'11','07','03','TURPAY'),(328,'12','07','03','VILCABAMBA'),(329,'13','07','03','VIRUNDO'),(330,'14','07','03','CURASCO'),(331,'01','01','04','AREQUIPA'),(332,'02','01','04','ALTO SELVA ALEGRE'),(333,'03','01','04','CAYMA'),(334,'04','01','04','CERRO COLORADO'),(335,'05','01','04','CHARACATO'),(336,'06','01','04','CHIGUATA'),(337,'07','01','04','JACOBO HUNTER'),(338,'08','01','04','LA JOYA'),(339,'09','01','04','MARIANO MELGAR'),(340,'10','01','04','MIRAFLORES'),(341,'11','01','04','MOLLEBAYA'),(342,'12','01','04','PAUCARPATA'),(343,'13','01','04','POCSI'),(344,'14','01','04','POLOBAYA'),(345,'15','01','04','QUEQUE¥A'),(346,'16','01','04','SABANDIA'),(347,'17','01','04','SACHACA'),(348,'18','01','04','SAN JUAN DE SIGUAS'),(349,'19','01','04','SAN JUAN DE TARUCANI'),(350,'20','01','04','SANTA ISABEL DE SIGUAS'),(351,'21','01','04','SANTA RITA DE SIGUAS'),(352,'22','01','04','SOCABAYA'),(353,'23','01','04','TIABAYA'),(354,'24','01','04','UCHUMAYO'),(355,'25','01','04','VITOR'),(356,'26','01','04','YANAHUARA'),(357,'27','01','04','YARABAMBA'),(358,'28','01','04','YURA'),(359,'29','01','04','JOSE LUIS BUSTAMANTE Y RIVERO'),(360,'01','02','04','CAMANA'),(361,'02','02','04','JOSE MARIA QUIMPER'),(362,'03','02','04','MARIANO NICOLAS VALCARCEL'),(363,'04','02','04','MARISCAL CACERES'),(364,'05','02','04','NICOLAS DE PIEROLA'),(365,'06','02','04','OCO¥A'),(366,'07','02','04','QUILCA'),(367,'08','02','04','SAMUEL PASTOR'),(368,'01','03','04','CARAVELI'),(369,'02','03','04','ACARI'),(370,'03','03','04','ATICO'),(371,'04','03','04','ATIQUIPA'),(372,'05','03','04','BELLA UNION'),(373,'06','03','04','CAHUACHO'),(374,'07','03','04','CHALA'),(375,'08','03','04','CHAPARRA'),(376,'09','03','04','HUANUHUANU'),(377,'10','03','04','JAQUI'),(378,'11','03','04','LOMAS'),(379,'12','03','04','QUICACHA'),(380,'13','03','04','YAUCA'),(381,'01','04','04','APLAO'),(382,'02','04','04','ANDAGUA'),(383,'03','04','04','AYO'),(384,'04','04','04','CHACHAS'),(385,'05','04','04','CHILCAYMARCA'),(386,'06','04','04','CHOCO'),(387,'07','04','04','HUANCARQUI'),(388,'08','04','04','MACHAGUAY'),(389,'09','04','04','ORCOPAMPA'),(390,'10','04','04','PAMPACOLCA'),(391,'11','04','04','TIPAN'),(392,'12','04','04','U¥ON'),(393,'13','04','04','URACA'),(394,'14','04','04','VIRACO'),(395,'01','05','04','CHIVAY'),(396,'02','05','04','ACHOMA'),(397,'03','05','04','CABANACONDE'),(398,'04','05','04','CALLALLI'),(399,'05','05','04','CAYLLOMA'),(400,'06','05','04','COPORAQUE'),(401,'07','05','04','HUAMBO'),(402,'08','05','04','HUANCA'),(403,'09','05','04','ICHUPAMPA'),(404,'10','05','04','LARI'),(405,'11','05','04','LLUTA'),(406,'12','05','04','MACA'),(407,'13','05','04','MADRIGAL'),(408,'14','05','04','SAN ANTONIO DE CHUCA'),(409,'15','05','04','SIBAYO'),(410,'16','05','04','TAPAY'),(411,'17','05','04','TISCO'),(412,'18','05','04','TUTI'),(413,'19','05','04','YANQUE'),(414,'20','05','04','MAJES'),(415,'01','06','04','CHUQUIBAMBA'),(416,'02','06','04','ANDARAY'),(417,'03','06','04','CAYARANI'),(418,'04','06','04','CHICHAS'),(419,'05','06','04','IRAY'),(420,'06','06','04','RIO GRANDE'),(421,'07','06','04','SALAMANCA'),(422,'08','06','04','YANAQUIHUA'),(423,'01','07','04','MOLLENDO'),(424,'02','07','04','COCACHACRA'),(425,'03','07','04','DEAN VALDIVIA'),(426,'04','07','04','ISLAY'),(427,'05','07','04','MEJIA'),(428,'06','07','04','PUNTA DE BOMBON'),(429,'01','08','04','COTAHUASI'),(430,'02','08','04','ALCA'),(431,'03','08','04','CHARCANA'),(432,'04','08','04','HUAYNACOTAS'),(433,'05','08','04','PAMPAMARCA'),(434,'06','08','04','PUYCA'),(435,'07','08','04','QUECHUALLA'),(436,'08','08','04','SAYLA'),(437,'09','08','04','TAURIA'),(438,'10','08','04','TOMEPAMPA'),(439,'11','08','04','TORO'),(440,'01','01','05','AYACUCHO'),(441,'02','01','05','ACOCRO'),(442,'03','01','05','ACOS VINCHOS'),(443,'04','01','05','CARMEN ALTO'),(444,'05','01','05','CHIARA'),(445,'06','01','05','OCROS'),(446,'07','01','05','PACAYCASA'),(447,'08','01','05','QUINUA'),(448,'09','01','05','SAN JOSE DE TICLLAS'),(449,'10','01','05','SAN JUAN BAUTISTA'),(450,'11','01','05','SANTIAGO DE PISCHA'),(451,'12','01','05','SOCOS'),(452,'13','01','05','TAMBILLO'),(453,'14','01','05','VINCHOS'),(454,'15','01','05','JESUS NAZARENO'),(455,'01','02','05','CANGALLO'),(456,'02','02','05','CHUSCHI'),(457,'03','02','05','LOS MOROCHUCOS'),(458,'04','02','05','MARIA PARADO DE BELLIDO'),(459,'05','02','05','PARAS'),(460,'06','02','05','TOTOS'),(461,'01','03','05','SANCOS'),(462,'02','03','05','CARAPO'),(463,'03','03','05','SACSAMARCA'),(464,'04','03','05','SANTIAGO DE LUCANAMARCA'),(465,'01','04','05','HUANTA'),(466,'02','04','05','AYAHUANCO'),(467,'03','04','05','HUAMANGUILLA'),(468,'04','04','05','IGUAIN'),(469,'05','04','05','LURICOCHA'),(470,'06','04','05','SANTILLANA'),(471,'07','04','05','SIVIA'),(472,'08','04','05','LLOCHEGUA'),(473,'01','05','05','SAN MIGUEL'),(474,'02','05','05','ANCO'),(475,'03','05','05','AYNA'),(476,'04','05','05','CHILCAS'),(477,'05','05','05','CHUNGUI'),(478,'06','05','05','LUIS CARRANZA'),(479,'07','05','05','SANTA ROSA'),(480,'08','05','05','TAMBO'),(481,'09','05','05','SAMUGARI'),(482,'01','06','05','PUQUIO'),(483,'02','06','05','AUCARA'),(484,'03','06','05','CABANA'),(485,'04','06','05','CARMEN SALCEDO'),(486,'05','06','05','CHAVI¥A'),(487,'06','06','05','CHIPAO'),(488,'07','06','05','HUAC-HUAS'),(489,'08','06','05','LARAMATE'),(490,'09','06','05','LEONCIO PRADO'),(491,'10','06','05','LLAUTA'),(492,'11','06','05','LUCANAS'),(493,'12','06','05','OCA¥A'),(494,'13','06','05','OTOCA'),(495,'14','06','05','SAISA'),(496,'15','06','05','SAN CRISTOBAL'),(497,'16','06','05','SAN JUAN'),(498,'17','06','05','SAN PEDRO'),(499,'18','06','05','SAN PEDRO DE PALCO'),(500,'19','06','05','SANCOS'),(501,'20','06','05','SANTA ANA DE HUAYCAHUACHO'),(502,'21','06','05','SANTA LUCIA'),(503,'01','07','05','CORACORA'),(504,'02','07','05','CHUMPI'),(505,'03','07','05','CORONEL CASTA¥EDA'),(506,'04','07','05','PACAPAUSA'),(507,'05','07','05','PULLO'),(508,'06','07','05','PUYUSCA'),(509,'07','07','05','SAN FRANCISCO DE RAVACAYCO'),(510,'08','07','05','UPAHUACHO'),(511,'01','08','05','PAUSA'),(512,'02','08','05','COLTA'),(513,'03','08','05','CORCULLA'),(514,'04','08','05','LAMPA'),(515,'05','08','05','MARCABAMBA'),(516,'06','08','05','OYOLO'),(517,'07','08','05','PARARCA'),(518,'08','08','05','SAN JAVIER DE ALPABAMBA'),(519,'09','08','05','SAN JOSE DE USHUA'),(520,'10','08','05','SARA SARA'),(521,'01','09','05','QUEROBAMBA'),(522,'02','09','05','BELEN'),(523,'03','09','05','CHALCOS'),(524,'04','09','05','CHILCAYOC'),(525,'05','09','05','HUACA¥A'),(526,'06','09','05','MORCOLLA'),(527,'07','09','05','PAICO'),(528,'08','09','05','SAN PEDRO DE LARCAY'),(529,'09','09','05','SAN SALVADOR DE QUIJE'),(530,'10','09','05','SANTIAGO DE PAUCARAY'),(531,'11','09','05','SORAS'),(532,'01','10','05','HUANCAPI'),(533,'02','10','05','ALCAMENCA'),(534,'03','10','05','APONGO'),(535,'04','10','05','ASQUIPATA'),(536,'05','10','05','CANARIA'),(537,'06','10','05','CAYARA'),(538,'07','10','05','COLCA'),(539,'08','10','05','HUAMANQUIQUIA'),(540,'09','10','05','HUANCARAYLLA'),(541,'10','10','05','HUAYA'),(542,'11','10','05','SARHUA'),(543,'12','10','05','VILCANCHOS'),(544,'01','11','05','VILCAS HUAMAN'),(545,'02','11','05','ACCOMARCA'),(546,'03','11','05','CARHUANCA'),(547,'04','11','05','CONCEPCION'),(548,'05','11','05','HUAMBALPA'),(549,'06','11','05','INDEPENDENCIA'),(550,'07','11','05','SAURAMA'),(551,'08','11','05','VISCHONGO'),(552,'01','01','06','CAJAMARCA'),(553,'02','01','06','ASUNCION'),(554,'03','01','06','CHETILLA'),(555,'04','01','06','COSPAN'),(556,'05','01','06','ENCA¥ADA'),(557,'06','01','06','JESUS'),(558,'07','01','06','LLACANORA'),(559,'08','01','06','LOS BA¥OS DEL INCA'),(560,'09','01','06','MAGDALENA'),(561,'10','01','06','MATARA'),(562,'11','01','06','NAMORA'),(563,'12','01','06','SAN JUAN'),(564,'01','02','06','CAJABAMBA'),(565,'02','02','06','CACHACHI'),(566,'03','02','06','CONDEBAMBA'),(567,'04','02','06','SITACOCHA'),(568,'01','03','06','CELENDIN'),(569,'02','03','06','CHUMUCH'),(570,'03','03','06','CORTEGANA'),(571,'04','03','06','HUASMIN'),(572,'05','03','06','JORGE CHAVEZ'),(573,'06','03','06','JOSE GALVEZ'),(574,'07','03','06','MIGUEL IGLESIAS'),(575,'08','03','06','OXAMARCA'),(576,'09','03','06','SOROCHUCO'),(577,'10','03','06','SUCRE'),(578,'11','03','06','UTCO'),(579,'12','03','06','LA LIBERTAD DE PALLAN'),(580,'01','04','06','CHOTA'),(581,'02','04','06','ANGUIA'),(582,'03','04','06','CHADIN'),(583,'04','04','06','CHIGUIRIP'),(584,'05','04','06','CHIMBAN'),(585,'06','04','06','CHOROPAMPA'),(586,'07','04','06','COCHABAMBA'),(587,'08','04','06','CONCHAN'),(588,'09','04','06','HUAMBOS'),(589,'10','04','06','LAJAS'),(590,'11','04','06','LLAMA'),(591,'12','04','06','MIRACOSTA'),(592,'13','04','06','PACCHA'),(593,'14','04','06','PION'),(594,'15','04','06','QUEROCOTO'),(595,'16','04','06','SAN JUAN DE LICUPIS'),(596,'17','04','06','TACABAMBA'),(597,'18','04','06','TOCMOCHE'),(598,'19','04','06','CHALAMARCA'),(599,'01','05','06','CONTUMAZA'),(600,'02','05','06','CHILETE'),(601,'03','05','06','CUPISNIQUE'),(602,'04','05','06','GUZMANGO'),(603,'05','05','06','SAN BENITO'),(604,'06','05','06','SANTA CRUZ DE TOLED'),(605,'07','05','06','TANTARICA'),(606,'08','05','06','YONAN'),(607,'01','06','06','CUTERVO'),(608,'02','06','06','CALLAYUC'),(609,'03','06','06','CHOROS'),(610,'04','06','06','CUJILLO'),(611,'05','06','06','LA RAMADA'),(612,'06','06','06','PIMPINGOS'),(613,'07','06','06','QUEROCOTILLO'),(614,'08','06','06','SAN ANDRES DE CUTERVO'),(615,'09','06','06','SAN JUAN DE CUTERVO'),(616,'10','06','06','SAN LUIS DE LUCMA'),(617,'11','06','06','SANTA CRUZ'),(618,'12','06','06','SANTO DOMINGO DE LA CAPILLA'),(619,'13','06','06','SANTO TOMAS'),(620,'14','06','06','SOCOTA'),(621,'15','06','06','TORIBIO CASANOVA'),(622,'01','07','06','BAMBAMARCA'),(623,'02','07','06','CHUGUR'),(624,'03','07','06','HUALGAYOC'),(625,'01','08','06','JAEN'),(626,'02','08','06','BELLAVISTA'),(627,'03','08','06','CHONTALI'),(628,'04','08','06','COLASAY'),(629,'05','08','06','HUABAL'),(630,'06','08','06','LAS PIRIAS'),(631,'07','08','06','POMAHUACA'),(632,'08','08','06','PUCARA'),(633,'09','08','06','SALLIQUE'),(634,'10','08','06','SAN FELIPE'),(635,'11','08','06','SAN JOSE DEL ALTO'),(636,'12','08','06','SANTA ROSA'),(637,'01','09','06','SAN IGNACIO'),(638,'02','09','06','CHIRINOS'),(639,'03','09','06','HUARANGO'),(640,'04','09','06','LA COIPA'),(641,'05','09','06','NAMBALLE'),(642,'06','09','06','SAN JOSE DE LOURDES'),(643,'07','09','06','TABACONAS'),(644,'01','10','06','PEDRO GALVEZ'),(645,'02','10','06','CHANCAY'),(646,'03','10','06','EDUARDO VILLANUEVA'),(647,'04','10','06','GREGORIO PITA'),(648,'05','10','06','ICHOCAN'),(649,'06','10','06','JOSE MANUEL QUIROZ'),(650,'07','10','06','JOSE SABOGAL'),(651,'01','11','06','SAN MIGUEL'),(652,'02','11','06','BOLIVAR'),(653,'03','11','06','CALQUIS'),(654,'04','11','06','CATILLUC'),(655,'05','11','06','EL PRADO'),(656,'06','11','06','LA FLORIDA'),(657,'07','11','06','LLAPA'),(658,'08','11','06','NANCHOC'),(659,'09','11','06','NIEPOS'),(660,'10','11','06','SAN GREGORIO'),(661,'11','11','06','SAN SILVESTRE DE COCHAN'),(662,'12','11','06','TONGOD'),(663,'13','11','06','UNION AGUA BLANCA'),(664,'01','12','06','SAN PABLO'),(665,'02','12','06','SAN BERNARDINO'),(666,'03','12','06','SAN LUIS'),(667,'04','12','06','TUMBADEN'),(668,'01','13','06','SANTA CRUZ'),(669,'02','13','06','ANDABAMBA'),(670,'03','13','06','CATACHE'),(671,'04','13','06','CHANCAYBA¥OS'),(672,'05','13','06','LA ESPERANZA'),(673,'06','13','06','NINABAMBA'),(674,'07','13','06','PULAN'),(675,'08','13','06','SAUCEPAMPA'),(676,'09','13','06','SEXI'),(677,'10','13','06','UTICYACU'),(678,'11','13','06','YAUYUCAN'),(679,'01','01','07','CALLAO'),(680,'02','01','07','BELLAVISTA'),(681,'03','01','07','CARMEN DE LA LEGUA REYNOSO'),(682,'04','01','07','LA PERLA'),(683,'05','01','07','LA PUNTA'),(684,'06','01','07','VENTANILLA'),(685,'01','01','08','CUSCO'),(686,'02','01','08','CCORCA'),(687,'03','01','08','POROY'),(688,'04','01','08','SAN JERONIMO'),(689,'05','01','08','SAN SEBASTIAN'),(690,'06','01','08','SANTIAGO'),(691,'07','01','08','SAYLLA'),(692,'08','01','08','WANCHAQ'),(693,'01','02','08','ACOMAYO'),(694,'02','02','08','ACOPIA'),(695,'03','02','08','ACOS'),(696,'04','02','08','MOSOC LLACTA'),(697,'05','02','08','POMACANCHI'),(698,'06','02','08','RONDOCAN'),(699,'07','02','08','SANGARARA'),(700,'01','03','08','ANTA'),(701,'02','03','08','ANCAHUASI'),(702,'03','03','08','CACHIMAYO'),(703,'04','03','08','CHINCHAYPUJIO'),(704,'05','03','08','HUAROCONDO'),(705,'06','03','08','LIMATAMBO'),(706,'07','03','08','MOLLEPATA'),(707,'08','03','08','PUCYURA'),(708,'09','03','08','ZURITE'),(709,'01','04','08','CALCA'),(710,'02','04','08','COYA'),(711,'03','04','08','LAMAY'),(712,'04','04','08','LARES'),(713,'05','04','08','PISAC'),(714,'06','04','08','SAN SALVADOR'),(715,'07','04','08','TARAY'),(716,'08','04','08','YANATILE'),(717,'01','05','08','YANAOCA'),(718,'02','05','08','CHECCA'),(719,'03','05','08','KUNTURKANKI'),(720,'04','05','08','LANGUI'),(721,'05','05','08','LAYO'),(722,'06','05','08','PAMPAMARCA'),(723,'07','05','08','QUEHUE'),(724,'08','05','08','TUPAC AMARU'),(725,'01','06','08','SICUANI'),(726,'02','06','08','CHECACUPE'),(727,'03','06','08','COMBAPATA'),(728,'04','06','08','MARANGANI'),(729,'05','06','08','PITUMARCA'),(730,'06','06','08','SAN PABLO'),(731,'07','06','08','SAN PEDRO'),(732,'08','06','08','TINTA'),(733,'01','07','08','SANTO TOMAS'),(734,'02','07','08','CAPACMARCA'),(735,'03','07','08','CHAMACA'),(736,'04','07','08','COLQUEMARCA'),(737,'05','07','08','LIVITACA'),(738,'06','07','08','LLUSCO'),(739,'07','07','08','QUI¥OTA'),(740,'08','07','08','VELILLE'),(741,'01','08','08','ESPINAR'),(742,'02','08','08','CONDOROMA'),(743,'03','08','08','COPORAQUE'),(744,'04','08','08','OCORURO'),(745,'05','08','08','PALLPATA'),(746,'06','08','08','PICHIGUA'),(747,'07','08','08','SUYCKUTAMBO'),(748,'08','08','08','ALTO PICHIGUA'),(749,'01','09','08','SANTA ANA'),(750,'02','09','08','ECHARATE'),(751,'03','09','08','HUAYOPATA'),(752,'04','09','08','MARANURA'),(753,'05','09','08','OCOBAMBA'),(754,'06','09','08','QUELLOUNO'),(755,'07','09','08','KIMBIRI'),(756,'08','09','08','SANTA TERESA'),(757,'09','09','08','VILCABAMBA'),(758,'10','09','08','PICHARI'),(759,'01','10','08','PARURO'),(760,'02','10','08','ACCHA'),(761,'03','10','08','CCAPI'),(762,'04','10','08','COLCHA'),(763,'05','10','08','HUANOQUITE'),(764,'06','10','08','OMACHA'),(765,'07','10','08','PACCARITAMBO'),(766,'08','10','08','PILLPINTO'),(767,'09','10','08','YAURISQUE'),(768,'01','11','08','PAUCARTAMBO'),(769,'02','11','08','CAICAY'),(770,'03','11','08','CHALLABAMBA'),(771,'04','11','08','COLQUEPATA'),(772,'05','11','08','HUANCARANI'),(773,'06','11','08','KOS¥IPATA'),(774,'01','12','08','URCOS'),(775,'02','12','08','ANDAHUAYLILLAS'),(776,'03','12','08','CAMANTI'),(777,'04','12','08','CCARHUAYO'),(778,'05','12','08','CCATCA'),(779,'06','12','08','CUSIPATA'),(780,'07','12','08','HUARO'),(781,'08','12','08','LUCRE'),(782,'09','12','08','MARCAPATA'),(783,'10','12','08','OCONGATE'),(784,'11','12','08','OROPESA'),(785,'12','12','08','QUIQUIJANA'),(786,'01','13','08','URUBAMBA'),(787,'02','13','08','CHINCHERO'),(788,'03','13','08','HUAYLLABAMBA'),(789,'04','13','08','MACHUPICCHU'),(790,'05','13','08','MARAS'),(791,'06','13','08','OLLANTAYTAMBO'),(792,'07','13','08','YUCAY'),(793,'01','01','09','HUANCAVELICA'),(794,'02','01','09','ACOBAMBILLA'),(795,'03','01','09','ACORIA'),(796,'04','01','09','CONAYCA'),(797,'05','01','09','CUENCA'),(798,'06','01','09','HUACHOCOLPA'),(799,'07','01','09','HUAYLLAHUARA'),(800,'08','01','09','IZCUCHACA'),(801,'09','01','09','LARIA'),(802,'10','01','09','MANTA'),(803,'11','01','09','MARISCAL CACERES'),(804,'12','01','09','MOYA'),(805,'13','01','09','NUEVO OCCORO'),(806,'14','01','09','PALCA'),(807,'15','01','09','PILCHACA'),(808,'16','01','09','VILCA'),(809,'17','01','09','YAULI'),(810,'18','01','09','ASCENSION'),(811,'19','01','09','HUANDO'),(812,'01','02','09','ACOBAMBA'),(813,'02','02','09','ANDABAMBA'),(814,'03','02','09','ANTA'),(815,'04','02','09','CAJA'),(816,'05','02','09','MARCAS'),(817,'06','02','09','PAUCARA'),(818,'07','02','09','POMACOCHA'),(819,'08','02','09','ROSARIO'),(820,'01','03','09','LIRCAY'),(821,'02','03','09','ANCHONGA'),(822,'03','03','09','CALLANMARCA'),(823,'04','03','09','CCOCHACCASA'),(824,'05','03','09','CHINCHO'),(825,'06','03','09','CONGALLA'),(826,'07','03','09','HUANCA-HUANCA'),(827,'08','03','09','HUAYLLAY GRANDE'),(828,'09','03','09','JULCAMARCA'),(829,'10','03','09','SAN ANTONIO DE ANTAPARCO'),(830,'11','03','09','SANTO TOMAS DE PATA'),(831,'12','03','09','SECCLLA'),(832,'01','04','09','CASTROVIRREYNA'),(833,'02','04','09','ARMA'),(834,'03','04','09','AURAHUA'),(835,'04','04','09','CAPILLAS'),(836,'05','04','09','CHUPAMARCA'),(837,'06','04','09','COCAS'),(838,'07','04','09','HUACHOS'),(839,'08','04','09','HUAMATAMBO'),(840,'09','04','09','MOLLEPAMPA'),(841,'10','04','09','SAN JUAN'),(842,'11','04','09','SANTA ANA'),(843,'12','04','09','TANTARA'),(844,'13','04','09','TICRAPO'),(845,'01','05','09','CHURCAMPA'),(846,'02','05','09','ANCO'),(847,'03','05','09','CHINCHIHUASI'),(848,'04','05','09','EL CARMEN'),(849,'05','05','09','LA MERCED'),(850,'06','05','09','LOCROJA'),(851,'07','05','09','PAUCARBAMBA'),(852,'08','05','09','SAN MIGUEL DE MAYOCC'),(853,'09','05','09','SAN PEDRO DE CORIS'),(854,'10','05','09','PACHAMARCA'),(855,'11','05','09','COSME'),(856,'01','06','09','HUAYTARA'),(857,'02','06','09','AYAVI'),(858,'03','06','09','CORDOVA'),(859,'04','06','09','HUAYACUNDO ARMA'),(860,'05','06','09','LARAMARCA'),(861,'06','06','09','OCOYO'),(862,'07','06','09','PILPICHACA'),(863,'08','06','09','QUERCO'),(864,'09','06','09','QUITO-ARMA'),(865,'10','06','09','SAN ANTONIO DE CUSICANCHA'),(866,'11','06','09','SAN FRANCISCO DE SANGAYAICO'),(867,'12','06','09','SAN ISIDRO'),(868,'13','06','09','SANTIAGO DE CHOCORVOS'),(869,'14','06','09','SANTIAGO DE QUIRAHUARA'),(870,'15','06','09','SANTO DOMINGO DE CAPILLAS'),(871,'16','06','09','TAMBO'),(872,'01','07','09','PAMPAS'),(873,'02','07','09','ACOSTAMBO'),(874,'03','07','09','ACRAQUIA'),(875,'04','07','09','AHUAYCHA'),(876,'05','07','09','COLCABAMBA'),(877,'06','07','09','DANIEL HERNANDEZ'),(878,'07','07','09','HUACHOCOLPA'),(879,'09','07','09','HUARIBAMBA'),(880,'10','07','09','¥AHUIMPUQUIO'),(881,'11','07','09','PAZOS'),(882,'13','07','09','QUISHUAR'),(883,'14','07','09','SALCABAMBA'),(884,'15','07','09','SALCAHUASI'),(885,'16','07','09','SAN MARCOS DE ROCCHAC'),(886,'17','07','09','SURCUBAMBA'),(887,'18','07','09','TINTAY PUNCU'),(888,'01','01','10','HUANUCO'),(889,'02','01','10','AMARILIS'),(890,'03','01','10','CHINCHAO'),(891,'04','01','10','CHURUBAMBA'),(892,'05','01','10','MARGOS'),(893,'06','01','10','QUISQUI (KICHKI)'),(894,'07','01','10','SAN FRANCISCO DE CAYRAN'),(895,'08','01','10','SAN PEDRO DE CHAULAN'),(896,'09','01','10','SANTA MARIA DEL VALLE'),(897,'10','01','10','YARUMAYO'),(898,'11','01','10','PILLCO MARCA'),(899,'12','01','10','YACUS'),(900,'01','02','10','AMBO'),(901,'02','02','10','CAYNA'),(902,'03','02','10','COLPAS'),(903,'04','02','10','CONCHAMARCA'),(904,'05','02','10','HUACAR'),(905,'06','02','10','SAN FRANCISCO'),(906,'07','02','10','SAN RAFAEL'),(907,'08','02','10','TOMAY KICHWA'),(908,'01','03','10','LA UNION'),(909,'07','03','10','CHUQUIS'),(910,'11','03','10','MARIAS'),(911,'13','03','10','PACHAS'),(912,'16','03','10','QUIVILLA'),(913,'17','03','10','RIPAN'),(914,'21','03','10','SHUNQUI'),(915,'22','03','10','SILLAPATA'),(916,'23','03','10','YANAS'),(917,'01','04','10','HUACAYBAMBA'),(918,'02','04','10','CANCHABAMBA'),(919,'03','04','10','COCHABAMBA'),(920,'04','04','10','PINRA'),(921,'01','05','10','LLATA'),(922,'02','05','10','ARANCAY'),(923,'03','05','10','CHAVIN DE PARIARCA'),(924,'04','05','10','JACAS GRANDE'),(925,'05','05','10','JIRCAN'),(926,'06','05','10','MIRAFLORES'),(927,'07','05','10','MONZON'),(928,'08','05','10','PUNCHAO'),(929,'09','05','10','PU¥OS'),(930,'10','05','10','SINGA'),(931,'11','05','10','TANTAMAYO'),(932,'01','06','10','RUPA-RUPA'),(933,'02','06','10','DANIEL ALOMIA ROBLES'),(934,'03','06','10','HERMILIO VALDIZAN'),(935,'04','06','10','JOSE CRESPO Y CASTILLO'),(936,'05','06','10','LUYANDO'),(937,'06','06','10','MARIANO DAMASO BERAUN'),(938,'01','07','10','HUACRACHUCO'),(939,'02','07','10','CHOLON'),(940,'03','07','10','SAN BUENAVENTURA'),(941,'01','08','10','PANAO'),(942,'02','08','10','CHAGLLA'),(943,'03','08','10','MOLINO'),(944,'04','08','10','UMARI'),(945,'01','09','10','PUERTO INCA'),(946,'02','09','10','CODO DEL POZUZO'),(947,'03','09','10','HONORIA'),(948,'04','09','10','TOURNAVISTA'),(949,'05','09','10','YUYAPICHIS'),(950,'01','10','10','JESUS'),(951,'02','10','10','BA¥OS'),(952,'03','10','10','JIVIA'),(953,'04','10','10','QUEROPALCA'),(954,'05','10','10','RONDOS'),(955,'06','10','10','SAN FRANCISCO DE ASIS'),(956,'07','10','10','SAN MIGUEL DE CAURI'),(957,'01','11','10','CHAVINILLO'),(958,'02','11','10','CAHUAC'),(959,'03','11','10','CHACABAMBA'),(960,'04','11','10','APARICIO POMARES'),(961,'05','11','10','JACAS CHICO'),(962,'06','11','10','OBAS'),(963,'07','11','10','PAMPAMARCA'),(964,'08','11','10','CHORAS'),(965,'01','01','11','ICA'),(966,'02','01','11','LA TINGUI¥A'),(967,'03','01','11','LOS AQUIJES'),(968,'04','01','11','OCUCAJE'),(969,'05','01','11','PACHACUTEC'),(970,'06','01','11','PARCONA'),(971,'07','01','11','PUEBLO NUEVO'),(972,'08','01','11','SALAS'),(973,'09','01','11','SAN JOSE DE LOS MOLINOS'),(974,'10','01','11','SAN JUAN BAUTISTA'),(975,'11','01','11','SANTIAGO'),(976,'12','01','11','SUBTANJALLA'),(977,'13','01','11','TATE'),(978,'14','01','11','YAUCA DEL ROSARIO'),(979,'01','02','11','CHINCHA ALTA'),(980,'02','02','11','ALTO LARAN'),(981,'03','02','11','CHAVIN'),(982,'04','02','11','CHINCHA BAJA'),(983,'05','02','11','EL CARMEN'),(984,'06','02','11','GROCIO PRADO'),(985,'07','02','11','PUEBLO NUEVO'),(986,'08','02','11','SAN JUAN DE YANAC'),(987,'09','02','11','SAN PEDRO DE HUACARPANA'),(988,'10','02','11','SUNAMPE'),(989,'11','02','11','TAMBO DE MORA'),(990,'01','03','11','NAZCA'),(991,'02','03','11','CHANGUILLO'),(992,'03','03','11','EL INGENIO'),(993,'04','03','11','MARCONA'),(994,'05','03','11','VISTA ALEGRE'),(995,'01','04','11','PALPA'),(996,'02','04','11','LLIPATA'),(997,'03','04','11','RIO GRANDE'),(998,'04','04','11','SANTA CRUZ'),(999,'05','04','11','TIBILLO'),(1000,'01','05','11','PISCO'),(1001,'02','05','11','HUANCANO'),(1002,'03','05','11','HUMAY'),(1003,'04','05','11','INDEPENDENCIA'),(1004,'05','05','11','PARACAS'),(1005,'06','05','11','SAN ANDRES'),(1006,'07','05','11','SAN CLEMENTE'),(1007,'08','05','11','TUPAC AMARU INCA'),(1008,'01','01','12','HUANCAYO'),(1009,'04','01','12','CARHUACALLANGA'),(1010,'05','01','12','CHACAPAMPA'),(1011,'06','01','12','CHICCHE'),(1012,'07','01','12','CHILCA'),(1013,'08','01','12','CHONGOS ALTO'),(1014,'11','01','12','CHUPURO'),(1015,'12','01','12','COLCA'),(1016,'13','01','12','CULLHUAS'),(1017,'14','01','12','EL TAMBO'),(1018,'16','01','12','HUACRAPUQUIO'),(1019,'17','01','12','HUALHUAS'),(1020,'19','01','12','HUANCAN'),(1021,'20','01','12','HUASICANCHA'),(1022,'21','01','12','HUAYUCACHI'),(1023,'22','01','12','INGENIO'),(1024,'24','01','12','PARIAHUANCA'),(1025,'25','01','12','PILCOMAYO'),(1026,'26','01','12','PUCARA'),(1027,'27','01','12','QUICHUAY'),(1028,'28','01','12','QUILCAS'),(1029,'29','01','12','SAN AGUSTIN'),(1030,'30','01','12','SAN JERONIMO DE TUNAN'),(1031,'32','01','12','SA¥O'),(1032,'33','01','12','SAPALLANGA'),(1033,'34','01','12','SICAYA'),(1034,'35','01','12','SANTO DOMINGO DE ACOBAMBA'),(1035,'36','01','12','VIQUES'),(1036,'01','02','12','CONCEPCION'),(1037,'02','02','12','ACO'),(1038,'03','02','12','ANDAMARCA'),(1039,'04','02','12','CHAMBARA'),(1040,'05','02','12','COCHAS'),(1041,'06','02','12','COMAS'),(1042,'07','02','12','HEROINAS TOLEDO'),(1043,'08','02','12','MANZANARES'),(1044,'09','02','12','MARISCAL CASTILLA'),(1045,'10','02','12','MATAHUASI'),(1046,'11','02','12','MITO'),(1047,'12','02','12','NUEVE DE JULIO'),(1048,'13','02','12','ORCOTUNA'),(1049,'14','02','12','SAN JOSE DE QUERO'),(1050,'15','02','12','SANTA ROSA DE OCOPA'),(1051,'01','03','12','CHANCHAMAYO'),(1052,'02','03','12','PERENE'),(1053,'03','03','12','PICHANAQUI'),(1054,'04','03','12','SAN LUIS DE SHUARO'),(1055,'05','03','12','SAN RAMON'),(1056,'06','03','12','VITOC'),(1057,'01','04','12','JAUJA'),(1058,'02','04','12','ACOLLA'),(1059,'03','04','12','APATA'),(1060,'04','04','12','ATAURA'),(1061,'05','04','12','CANCHAYLLO'),(1062,'06','04','12','CURICACA'),(1063,'07','04','12','EL MANTARO'),(1064,'08','04','12','HUAMALI'),(1065,'09','04','12','HUARIPAMPA'),(1066,'10','04','12','HUERTAS'),(1067,'11','04','12','JANJAILLO'),(1068,'12','04','12','JULCAN'),(1069,'13','04','12','LEONOR ORDO¥EZ'),(1070,'14','04','12','LLOCLLAPAMPA'),(1071,'15','04','12','MARCO'),(1072,'16','04','12','MASMA'),(1073,'17','04','12','MASMA CHICCHE'),(1074,'18','04','12','MOLINOS'),(1075,'19','04','12','MONOBAMBA'),(1076,'20','04','12','MUQUI'),(1077,'21','04','12','MUQUIYAUYO'),(1078,'22','04','12','PACA'),(1079,'23','04','12','PACCHA'),(1080,'24','04','12','PANCAN'),(1081,'25','04','12','PARCO'),(1082,'26','04','12','POMACANCHA'),(1083,'27','04','12','RICRAN'),(1084,'28','04','12','SAN LORENZO'),(1085,'29','04','12','SAN PEDRO DE CHUNAN'),(1086,'30','04','12','SAUSA'),(1087,'31','04','12','SINCOS'),(1088,'32','04','12','TUNAN MARCA'),(1089,'33','04','12','YAULI'),(1090,'34','04','12','YAUYOS'),(1091,'01','05','12','JUNIN'),(1092,'02','05','12','CARHUAMAYO'),(1093,'03','05','12','ONDORES'),(1094,'04','05','12','ULCUMAYO'),(1095,'01','06','12','SATIPO'),(1096,'02','06','12','COVIRIALI'),(1097,'03','06','12','LLAYLLA'),(1098,'05','06','12','PAMPA HERMOSA'),(1099,'07','06','12','RIO NEGRO'),(1100,'08','06','12','RIO TAMBO'),(1101,'99','06','12','MAZAMARI - PANGOA'),(1102,'01','07','12','TARMA'),(1103,'02','07','12','ACOBAMBA'),(1104,'03','07','12','HUARICOLCA'),(1105,'04','07','12','HUASAHUASI'),(1106,'05','07','12','LA UNION'),(1107,'06','07','12','PALCA'),(1108,'07','07','12','PALCAMAYO'),(1109,'08','07','12','SAN PEDRO DE CAJAS'),(1110,'09','07','12','TAPO'),(1111,'01','08','12','LA OROYA'),(1112,'02','08','12','CHACAPALPA'),(1113,'03','08','12','HUAY-HUAY'),(1114,'04','08','12','MARCAPOMACOCHA'),(1115,'05','08','12','MOROCOCHA'),(1116,'06','08','12','PACCHA'),(1117,'07','08','12','SANTA BARBARA DE CARHUACAYAN'),(1118,'08','08','12','SANTA ROSA DE SACCO'),(1119,'09','08','12','SUITUCANCHA'),(1120,'10','08','12','YAULI'),(1121,'01','09','12','CHUPACA'),(1122,'02','09','12','AHUAC'),(1123,'03','09','12','CHONGOS BAJO'),(1124,'04','09','12','HUACHAC'),(1125,'05','09','12','HUAMANCACA CHICO'),(1126,'06','09','12','SAN JUAN DE ISCOS'),(1127,'07','09','12','SAN JUAN DE JARPA'),(1128,'08','09','12','TRES DE DICIEMBRE'),(1129,'09','09','12','YANACANCHA'),(1130,'01','01','13','TRUJILLO'),(1131,'02','01','13','EL PORVENIR'),(1132,'03','01','13','FLORENCIA DE MORA'),(1133,'04','01','13','HUANCHACO'),(1134,'05','01','13','LA ESPERANZA'),(1135,'06','01','13','LAREDO'),(1136,'07','01','13','MOCHE'),(1137,'08','01','13','POROTO'),(1138,'09','01','13','SALAVERRY'),(1139,'10','01','13','SIMBAL'),(1140,'11','01','13','VICTOR LARCO HERRERA'),(1141,'01','02','13','ASCOPE'),(1142,'02','02','13','CHICAMA'),(1143,'03','02','13','CHOCOPE'),(1144,'04','02','13','MAGDALENA DE CAO'),(1145,'05','02','13','PAIJAN'),(1146,'06','02','13','RAZURI'),(1147,'07','02','13','SANTIAGO DE CAO'),(1148,'08','02','13','CASA GRANDE'),(1149,'01','03','13','BOLIVAR'),(1150,'02','03','13','BAMBAMARCA'),(1151,'03','03','13','CONDORMARCA'),(1152,'04','03','13','LONGOTEA'),(1153,'05','03','13','UCHUMARCA'),(1154,'06','03','13','UCUNCHA'),(1155,'01','04','13','CHEPEN'),(1156,'02','04','13','PACANGA'),(1157,'03','04','13','PUEBLO NUEVO'),(1158,'01','05','13','JULCAN'),(1159,'02','05','13','CALAMARCA'),(1160,'03','05','13','CARABAMBA'),(1161,'04','05','13','HUASO'),(1162,'01','06','13','OTUZCO'),(1163,'02','06','13','AGALLPAMPA'),(1164,'04','06','13','CHARAT'),(1165,'05','06','13','HUARANCHAL'),(1166,'06','06','13','LA CUESTA'),(1167,'08','06','13','MACHE'),(1168,'10','06','13','PARANDAY'),(1169,'11','06','13','SALPO'),(1170,'13','06','13','SINSICAP'),(1171,'14','06','13','USQUIL'),(1172,'01','07','13','SAN PEDRO DE LLOC'),(1173,'02','07','13','GUADALUPE'),(1174,'03','07','13','JEQUETEPEQUE'),(1175,'04','07','13','PACASMAYO'),(1176,'05','07','13','SAN JOSE'),(1177,'01','08','13','TAYABAMBA'),(1178,'02','08','13','BULDIBUYO'),(1179,'03','08','13','CHILLIA'),(1180,'04','08','13','HUANCASPATA'),(1181,'05','08','13','HUAYLILLAS'),(1182,'06','08','13','HUAYO'),(1183,'07','08','13','ONGON'),(1184,'08','08','13','PARCOY'),(1185,'09','08','13','PATAZ'),(1186,'10','08','13','PIAS'),(1187,'11','08','13','SANTIAGO DE CHALLAS'),(1188,'12','08','13','TAURIJA'),(1189,'13','08','13','URPAY'),(1190,'01','09','13','HUAMACHUCO'),(1191,'02','09','13','CHUGAY'),(1192,'03','09','13','COCHORCO'),(1193,'04','09','13','CURGOS'),(1194,'05','09','13','MARCABAL'),(1195,'06','09','13','SANAGORAN'),(1196,'07','09','13','SARIN'),(1197,'08','09','13','SARTIMBAMBA'),(1198,'01','10','13','SANTIAGO DE CHUCO'),(1199,'02','10','13','ANGASMARCA'),(1200,'03','10','13','CACHICADAN'),(1201,'04','10','13','MOLLEBAMBA'),(1202,'05','10','13','MOLLEPATA'),(1203,'06','10','13','QUIRUVILCA'),(1204,'07','10','13','SANTA CRUZ DE CHUCA'),(1205,'08','10','13','SITABAMBA'),(1206,'01','11','13','CASCAS'),(1207,'02','11','13','LUCMA'),(1208,'03','11','13','MARMOT'),(1209,'04','11','13','SAYAPULLO'),(1210,'01','12','13','VIRU'),(1211,'02','12','13','CHAO'),(1212,'03','12','13','GUADALUPITO'),(1213,'01','01','14','CHICLAYO'),(1214,'02','01','14','CHONGOYAPE'),(1215,'03','01','14','ETEN'),(1216,'04','01','14','ETEN PUERTO'),(1217,'05','01','14','JOSE LEONARDO ORTIZ'),(1218,'06','01','14','LA VICTORIA'),(1219,'07','01','14','LAGUNAS'),(1220,'08','01','14','MONSEFU'),(1221,'09','01','14','NUEVA ARICA'),(1222,'10','01','14','OYOTUN'),(1223,'11','01','14','PICSI'),(1224,'12','01','14','PIMENTEL'),(1225,'13','01','14','REQUE'),(1226,'14','01','14','SANTA ROSA'),(1227,'15','01','14','SA¥A'),(1228,'16','01','14','CAYALTI'),(1229,'17','01','14','PATAPO'),(1230,'18','01','14','POMALCA'),(1231,'19','01','14','PUCALA'),(1232,'20','01','14','TUMAN'),(1233,'01','02','14','FERRE¥AFE'),(1234,'02','02','14','CA¥ARIS'),(1235,'03','02','14','INCAHUASI'),(1236,'04','02','14','MANUEL ANTONIO MESONES MURO'),(1237,'05','02','14','PITIPO'),(1238,'06','02','14','PUEBLO NUEVO'),(1239,'01','03','14','LAMBAYEQUE'),(1240,'02','03','14','CHOCHOPE'),(1241,'03','03','14','ILLIMO'),(1242,'04','03','14','JAYANCA'),(1243,'05','03','14','MOCHUMI'),(1244,'06','03','14','MORROPE'),(1245,'07','03','14','MOTUPE'),(1246,'08','03','14','OLMOS'),(1247,'09','03','14','PACORA'),(1248,'10','03','14','SALAS'),(1249,'11','03','14','SAN JOSE'),(1250,'12','03','14','TUCUME'),(1251,'01','01','15','LIMA'),(1252,'02','01','15','ANCON'),(1253,'03','01','15','ATE'),(1254,'04','01','15','BARRANCO'),(1255,'05','01','15','BREÑA'),(1256,'06','01','15','CARABAYLLO'),(1257,'07','01','15','CHACLACAYO'),(1258,'08','01','15','CHORRILLOS'),(1259,'09','01','15','CIENEGUILLA'),(1260,'10','01','15','COMAS'),(1261,'11','01','15','EL AGUSTINO'),(1262,'12','01','15','INDEPENDENCIA'),(1263,'13','01','15','JESUS MARIA'),(1264,'14','01','15','LA MOLINA'),(1265,'15','01','15','LA VICTORIA'),(1266,'16','01','15','LINCE'),(1267,'17','01','15','LOS OLIVOS'),(1268,'18','01','15','LURIGANCHO'),(1269,'19','01','15','LURIN'),(1270,'20','01','15','MAGDALENA DEL MAR'),(1271,'21','01','15','PUEBLO LIBRE'),(1272,'22','01','15','MIRAFLORES'),(1273,'23','01','15','PACHACAMAC'),(1274,'24','01','15','PUCUSANA'),(1275,'25','01','15','PUENTE PIEDRA'),(1276,'26','01','15','PUNTA HERMOSA'),(1277,'27','01','15','PUNTA NEGRA'),(1278,'28','01','15','RIMAC'),(1279,'29','01','15','SAN BARTOLO'),(1280,'30','01','15','SAN BORJA'),(1281,'31','01','15','SAN ISIDRO'),(1282,'32','01','15','SAN JUAN DE LURIGANCHO'),(1283,'33','01','15','SAN JUAN DE MIRAFLORES'),(1284,'34','01','15','SAN LUIS'),(1285,'35','01','15','SAN MARTIN DE PORRES'),(1286,'36','01','15','SAN MIGUEL'),(1287,'37','01','15','SANTA ANITA'),(1288,'38','01','15','SANTA MARIA DEL MAR'),(1289,'39','01','15','SANTA ROSA'),(1290,'40','01','15','SANTIAGO DE SURCO'),(1291,'41','01','15','SURQUILLO'),(1292,'42','01','15','VILLA EL SALVADOR'),(1293,'43','01','15','VILLA MARIA DEL TRIUNFO'),(1294,'01','02','15','BARRANCA'),(1295,'02','02','15','PARAMONGA'),(1296,'03','02','15','PATIVILCA'),(1297,'04','02','15','SUPE'),(1298,'05','02','15','SUPE PUERTO'),(1299,'01','03','15','CAJATAMBO'),(1300,'02','03','15','COPA'),(1301,'03','03','15','GORGOR'),(1302,'04','03','15','HUANCAPON'),(1303,'05','03','15','MANAS'),(1304,'01','04','15','CANTA'),(1305,'02','04','15','ARAHUAY'),(1306,'03','04','15','HUAMANTANGA'),(1307,'04','04','15','HUAROS'),(1308,'05','04','15','LACHAQUI'),(1309,'06','04','15','SAN BUENAVENTURA'),(1310,'07','04','15','SANTA ROSA DE QUIVES'),(1311,'01','05','15','SAN VICENTE DE CA¥ETE'),(1312,'02','05','15','ASIA'),(1313,'03','05','15','CALANGO'),(1314,'04','05','15','CERRO AZUL'),(1315,'05','05','15','CHILCA'),(1316,'06','05','15','COAYLLO'),(1317,'07','05','15','IMPERIAL'),(1318,'08','05','15','LUNAHUANA'),(1319,'09','05','15','MALA'),(1320,'10','05','15','NUEVO IMPERIAL'),(1321,'11','05','15','PACARAN'),(1322,'12','05','15','QUILMANA'),(1323,'13','05','15','SAN ANTONIO'),(1324,'14','05','15','SAN LUIS'),(1325,'15','05','15','SANTA CRUZ DE FLORES'),(1326,'16','05','15','ZU¥IGA'),(1327,'01','06','15','HUARAL'),(1328,'02','06','15','ATAVILLOS ALTO'),(1329,'03','06','15','ATAVILLOS BAJO'),(1330,'04','06','15','AUCALLAMA'),(1331,'05','06','15','CHANCAY'),(1332,'06','06','15','IHUARI'),(1333,'07','06','15','LAMPIAN'),(1334,'08','06','15','PACARAOS'),(1335,'09','06','15','SAN MIGUEL DE ACOS'),(1336,'10','06','15','SANTA CRUZ DE ANDAMARCA'),(1337,'11','06','15','SUMBILCA'),(1338,'12','06','15','VEINTISIETE DE NOVIEMBRE'),(1339,'01','07','15','MATUCANA'),(1340,'02','07','15','ANTIOQUIA'),(1341,'03','07','15','CALLAHUANCA'),(1342,'04','07','15','CARAMPOMA'),(1343,'05','07','15','CHICLA'),(1344,'06','07','15','CUENCA'),(1345,'07','07','15','HUACHUPAMPA'),(1346,'08','07','15','HUANZA'),(1347,'09','07','15','HUAROCHIRI'),(1348,'10','07','15','LAHUAYTAMBO'),(1349,'11','07','15','LANGA'),(1350,'12','07','15','LARAOS'),(1351,'13','07','15','MARIATANA'),(1352,'14','07','15','RICARDO PALMA'),(1353,'15','07','15','SAN ANDRES DE TUPICOCHA'),(1354,'16','07','15','SAN ANTONIO'),(1355,'17','07','15','SAN BARTOLOME'),(1356,'18','07','15','SAN DAMIAN'),(1357,'19','07','15','SAN JUAN DE IRIS'),(1358,'20','07','15','SAN JUAN DE TANTARANCHE'),(1359,'21','07','15','SAN LORENZO DE QUINTI'),(1360,'22','07','15','SAN MATEO'),(1361,'23','07','15','SAN MATEO DE OTAO'),(1362,'24','07','15','SAN PEDRO DE CASTA'),(1363,'25','07','15','SAN PEDRO DE HUANCAYRE'),(1364,'26','07','15','SANGALLAYA'),(1365,'27','07','15','SANTA CRUZ DE COCACHACRA'),(1366,'28','07','15','SANTA EULALIA'),(1367,'29','07','15','SANTIAGO DE ANCHUCAYA'),(1368,'30','07','15','SANTIAGO DE TUNA'),(1369,'31','07','15','SANTO DOMINGO DE LOS OLLEROS'),(1370,'32','07','15','SURCO'),(1371,'01','08','15','HUACHO'),(1372,'02','08','15','AMBAR'),(1373,'03','08','15','CALETA DE CARQUIN'),(1374,'04','08','15','CHECRAS'),(1375,'05','08','15','HUALMAY'),(1376,'06','08','15','HUAURA'),(1377,'07','08','15','LEONCIO PRADO'),(1378,'08','08','15','PACCHO'),(1379,'09','08','15','SANTA LEONOR'),(1380,'10','08','15','SANTA MARIA'),(1381,'11','08','15','SAYAN'),(1382,'12','08','15','VEGUETA'),(1383,'01','09','15','OYON'),(1384,'02','09','15','ANDAJES'),(1385,'03','09','15','CAUJUL'),(1386,'04','09','15','COCHAMARCA'),(1387,'05','09','15','NAVAN'),(1388,'06','09','15','PACHANGARA'),(1389,'01','10','15','YAUYOS'),(1390,'02','10','15','ALIS'),(1391,'03','10','15','ALLAUCA'),(1392,'04','10','15','AYAVIRI'),(1393,'05','10','15','AZANGARO'),(1394,'06','10','15','CACRA'),(1395,'07','10','15','CARANIA'),(1396,'08','10','15','CATAHUASI'),(1397,'09','10','15','CHOCOS'),(1398,'10','10','15','COCHAS'),(1399,'11','10','15','COLONIA'),(1400,'12','10','15','HONGOS'),(1401,'13','10','15','HUAMPARA'),(1402,'14','10','15','HUANCAYA'),(1403,'15','10','15','HUANGASCAR'),(1404,'16','10','15','HUANTAN'),(1405,'17','10','15','HUA¥EC'),(1406,'18','10','15','LARAOS'),(1407,'19','10','15','LINCHA'),(1408,'20','10','15','MADEAN'),(1409,'21','10','15','MIRAFLORES'),(1410,'22','10','15','OMAS'),(1411,'23','10','15','PUTINZA'),(1412,'24','10','15','QUINCHES'),(1413,'25','10','15','QUINOCAY'),(1414,'26','10','15','SAN JOAQUIN'),(1415,'27','10','15','SAN PEDRO DE PILAS'),(1416,'28','10','15','TANTA'),(1417,'29','10','15','TAURIPAMPA'),(1418,'30','10','15','TOMAS'),(1419,'31','10','15','TUPE'),(1420,'32','10','15','VI¥AC'),(1421,'33','10','15','VITIS'),(1422,'01','01','16','IQUITOS'),(1423,'02','01','16','ALTO NANAY'),(1424,'03','01','16','FERNANDO LORES'),(1425,'04','01','16','INDIANA'),(1426,'05','01','16','LAS AMAZONAS'),(1427,'06','01','16','MAZAN'),(1428,'07','01','16','NAPO'),(1429,'08','01','16','PUNCHANA'),(1430,'09','01','16','PUTUMAYO'),(1431,'10','01','16','TORRES CAUSANA'),(1432,'12','01','16','BELEN'),(1433,'13','01','16','SAN JUAN BAUTISTA'),(1434,'14','01','16','TENIENTE MANUEL CLAVERO'),(1435,'01','02','16','YURIMAGUAS'),(1436,'02','02','16','BALSAPUERTO'),(1437,'05','02','16','JEBEROS'),(1438,'06','02','16','LAGUNAS'),(1439,'10','02','16','SANTA CRUZ'),(1440,'11','02','16','TENIENTE CESAR LOPEZ ROJAS'),(1441,'01','03','16','NAUTA'),(1442,'02','03','16','PARINARI'),(1443,'03','03','16','TIGRE'),(1444,'04','03','16','TROMPETEROS'),(1445,'05','03','16','URARINAS'),(1446,'01','04','16','RAMON CASTILLA'),(1447,'02','04','16','PEBAS'),(1448,'03','04','16','YAVARI'),(1449,'04','04','16','SAN PABLO'),(1450,'01','05','16','REQUENA'),(1451,'02','05','16','ALTO TAPICHE'),(1452,'03','05','16','CAPELO'),(1453,'04','05','16','EMILIO SAN MARTIN'),(1454,'05','05','16','MAQUIA'),(1455,'06','05','16','PUINAHUA'),(1456,'07','05','16','SAQUENA'),(1457,'08','05','16','SOPLIN'),(1458,'09','05','16','TAPICHE'),(1459,'10','05','16','JENARO HERRERA'),(1460,'11','05','16','YAQUERANA'),(1461,'01','06','16','CONTAMANA'),(1462,'02','06','16','INAHUAYA'),(1463,'03','06','16','PADRE MARQUEZ'),(1464,'04','06','16','PAMPA HERMOSA'),(1465,'05','06','16','SARAYACU'),(1466,'06','06','16','VARGAS GUERRA'),(1467,'01','07','16','BARRANCA'),(1468,'02','07','16','CAHUAPANAS'),(1469,'03','07','16','MANSERICHE'),(1470,'04','07','16','MORONA'),(1471,'05','07','16','PASTAZA'),(1472,'06','07','16','ANDOAS'),(1473,'01','01','17','TAMBOPATA'),(1474,'02','01','17','INAMBARI'),(1475,'03','01','17','LAS PIEDRAS'),(1476,'04','01','17','LABERINTO'),(1477,'01','02','17','MANU'),(1478,'02','02','17','FITZCARRALD'),(1479,'03','02','17','MADRE DE DIOS'),(1480,'04','02','17','HUEPETUHE'),(1481,'01','03','17','I¥APARI'),(1482,'02','03','17','IBERIA'),(1483,'03','03','17','TAHUAMANU'),(1484,'01','01','18','MOQUEGUA'),(1485,'02','01','18','CARUMAS'),(1486,'03','01','18','CUCHUMBAYA'),(1487,'04','01','18','SAMEGUA'),(1488,'05','01','18','SAN CRISTOBAL'),(1489,'06','01','18','TORATA'),(1490,'01','02','18','OMATE'),(1491,'02','02','18','CHOJATA'),(1492,'03','02','18','COALAQUE'),(1493,'04','02','18','ICHU¥A'),(1494,'05','02','18','LA CAPILLA'),(1495,'06','02','18','LLOQUE'),(1496,'07','02','18','MATALAQUE'),(1497,'08','02','18','PUQUINA'),(1498,'09','02','18','QUINISTAQUILLAS'),(1499,'10','02','18','UBINAS'),(1500,'11','02','18','YUNGA'),(1501,'01','03','18','ILO'),(1502,'02','03','18','EL ALGARROBAL'),(1503,'03','03','18','PACOCHA'),(1504,'01','01','19','CHAUPIMARCA'),(1505,'02','01','19','HUACHON'),(1506,'03','01','19','HUARIACA'),(1507,'04','01','19','HUAYLLAY'),(1508,'05','01','19','NINACACA'),(1509,'06','01','19','PALLANCHACRA'),(1510,'07','01','19','PAUCARTAMBO'),(1511,'08','01','19','SAN FRANCISCO DE ASIS DE YARUS'),(1512,'09','01','19','SIMON BOLIVAR'),(1513,'10','01','19','TICLACAYAN'),(1514,'11','01','19','TINYAHUARCO'),(1515,'12','01','19','VICCO'),(1516,'13','01','19','YANACANCHA'),(1517,'01','02','19','YANAHUANCA'),(1518,'02','02','19','CHACAYAN'),(1519,'03','02','19','GOYLLARISQUIZGA'),(1520,'04','02','19','PAUCAR'),(1521,'05','02','19','SAN PEDRO DE PILLAO'),(1522,'06','02','19','SANTA ANA DE TUSI'),(1523,'07','02','19','TAPUC'),(1524,'08','02','19','VILCABAMBA'),(1525,'01','03','19','OXAPAMPA'),(1526,'02','03','19','CHONTABAMBA'),(1527,'03','03','19','HUANCABAMBA'),(1528,'04','03','19','PALCAZU'),(1529,'05','03','19','POZUZO'),(1530,'06','03','19','PUERTO BERMUDEZ'),(1531,'07','03','19','VILLA RICA'),(1532,'08','03','19','CONSTITUCION'),(1533,'01','01','20','PIURA'),(1534,'04','01','20','CASTILLA'),(1535,'05','01','20','CATACAOS'),(1536,'07','01','20','CURA MORI'),(1537,'08','01','20','EL TALLAN'),(1538,'09','01','20','LA ARENA'),(1539,'10','01','20','LA UNION'),(1540,'11','01','20','LAS LOMAS'),(1541,'14','01','20','TAMBO GRANDE'),(1542,'01','02','20','AYABACA'),(1543,'02','02','20','FRIAS'),(1544,'03','02','20','JILILI'),(1545,'04','02','20','LAGUNAS'),(1546,'05','02','20','MONTERO'),(1547,'06','02','20','PACAIPAMPA'),(1548,'07','02','20','PAIMAS'),(1549,'08','02','20','SAPILLICA'),(1550,'09','02','20','SICCHEZ'),(1551,'10','02','20','SUYO'),(1552,'01','03','20','HUANCABAMBA'),(1553,'02','03','20','CANCHAQUE'),(1554,'03','03','20','EL CARMEN DE LA FRONTERA'),(1555,'04','03','20','HUARMACA'),(1556,'05','03','20','LALAQUIZ'),(1557,'06','03','20','SAN MIGUEL DE EL FAIQUE'),(1558,'07','03','20','SONDOR'),(1559,'08','03','20','SONDORILLO'),(1560,'01','04','20','CHULUCANAS'),(1561,'02','04','20','BUENOS AIRES'),(1562,'03','04','20','CHALACO'),(1563,'04','04','20','LA MATANZA'),(1564,'05','04','20','MORROPON'),(1565,'06','04','20','SALITRAL'),(1566,'07','04','20','SAN JUAN DE BIGOTE'),(1567,'08','04','20','SANTA CATALINA DE MOSSA'),(1568,'09','04','20','SANTO DOMINGO'),(1569,'10','04','20','YAMANGO'),(1570,'01','05','20','PAITA'),(1571,'02','05','20','AMOTAPE'),(1572,'03','05','20','ARENAL'),(1573,'04','05','20','COLAN'),(1574,'05','05','20','LA HUACA'),(1575,'06','05','20','TAMARINDO'),(1576,'07','05','20','VICHAYAL'),(1577,'01','06','20','SULLANA'),(1578,'02','06','20','BELLAVISTA'),(1579,'03','06','20','IGNACIO ESCUDERO'),(1580,'04','06','20','LANCONES'),(1581,'05','06','20','MARCAVELICA'),(1582,'06','06','20','MIGUEL CHECA'),(1583,'07','06','20','QUERECOTILLO'),(1584,'08','06','20','SALITRAL'),(1585,'01','07','20','PARI¥AS'),(1586,'02','07','20','EL ALTO'),(1587,'03','07','20','LA BREA'),(1588,'04','07','20','LOBITOS'),(1589,'05','07','20','LOS ORGANOS'),(1590,'06','07','20','MANCORA'),(1591,'01','08','20','SECHURA'),(1592,'02','08','20','BELLAVISTA DE LA UNION'),(1593,'03','08','20','BERNAL'),(1594,'04','08','20','CRISTO NOS VALGA'),(1595,'05','08','20','VICE'),(1596,'06','08','20','RINCONADA LLICUAR'),(1597,'01','01','21','PUNO'),(1598,'02','01','21','ACORA'),(1599,'03','01','21','AMANTANI'),(1600,'04','01','21','ATUNCOLLA'),(1601,'05','01','21','CAPACHICA'),(1602,'06','01','21','CHUCUITO'),(1603,'07','01','21','COATA'),(1604,'08','01','21','HUATA'),(1605,'09','01','21','MA¥AZO'),(1606,'10','01','21','PAUCARCOLLA'),(1607,'11','01','21','PICHACANI'),(1608,'12','01','21','PLATERIA'),(1609,'13','01','21','SAN ANTONIO'),(1610,'14','01','21','TIQUILLACA'),(1611,'15','01','21','VILQUE'),(1612,'01','02','21','AZANGARO'),(1613,'02','02','21','ACHAYA'),(1614,'03','02','21','ARAPA'),(1615,'04','02','21','ASILLO'),(1616,'05','02','21','CAMINACA'),(1617,'06','02','21','CHUPA'),(1618,'07','02','21','JOSE DOMINGO CHOQUEHUANCA'),(1619,'08','02','21','MU¥ANI'),(1620,'09','02','21','POTONI'),(1621,'10','02','21','SAMAN'),(1622,'11','02','21','SAN ANTON'),(1623,'12','02','21','SAN JOSE'),(1624,'13','02','21','SAN JUAN DE SALINAS'),(1625,'14','02','21','SANTIAGO DE PUPUJA'),(1626,'15','02','21','TIRAPATA'),(1627,'01','03','21','MACUSANI'),(1628,'02','03','21','AJOYANI'),(1629,'03','03','21','AYAPATA'),(1630,'04','03','21','COASA'),(1631,'05','03','21','CORANI'),(1632,'06','03','21','CRUCERO'),(1633,'07','03','21','ITUATA'),(1634,'08','03','21','OLLACHEA'),(1635,'09','03','21','SAN GABAN'),(1636,'10','03','21','USICAYOS'),(1637,'01','04','21','JULI'),(1638,'02','04','21','DESAGUADERO'),(1639,'03','04','21','HUACULLANI'),(1640,'04','04','21','KELLUYO'),(1641,'05','04','21','PISACOMA'),(1642,'06','04','21','POMATA'),(1643,'07','04','21','ZEPITA'),(1644,'01','05','21','ILAVE'),(1645,'02','05','21','CAPAZO'),(1646,'03','05','21','PILCUYO'),(1647,'04','05','21','SANTA ROSA'),(1648,'05','05','21','CONDURIRI'),(1649,'01','06','21','HUANCANE'),(1650,'02','06','21','COJATA'),(1651,'03','06','21','HUATASANI'),(1652,'04','06','21','INCHUPALLA'),(1653,'05','06','21','PUSI'),(1654,'06','06','21','ROSASPATA'),(1655,'07','06','21','TARACO'),(1656,'08','06','21','VILQUE CHICO'),(1657,'01','07','21','LAMPA'),(1658,'02','07','21','CABANILLA'),(1659,'03','07','21','CALAPUJA'),(1660,'04','07','21','NICASIO'),(1661,'05','07','21','OCUVIRI'),(1662,'06','07','21','PALCA'),(1663,'07','07','21','PARATIA'),(1664,'08','07','21','PUCARA'),(1665,'09','07','21','SANTA LUCIA'),(1666,'10','07','21','VILAVILA'),(1667,'01','08','21','AYAVIRI'),(1668,'02','08','21','ANTAUTA'),(1669,'03','08','21','CUPI'),(1670,'04','08','21','LLALLI'),(1671,'05','08','21','MACARI'),(1672,'06','08','21','NU¥OA'),(1673,'07','08','21','ORURILLO'),(1674,'08','08','21','SANTA ROSA'),(1675,'09','08','21','UMACHIRI'),(1676,'01','09','21','MOHO'),(1677,'02','09','21','CONIMA'),(1678,'03','09','21','HUAYRAPATA'),(1679,'04','09','21','TILALI'),(1680,'01','10','21','PUTINA'),(1681,'02','10','21','ANANEA'),(1682,'03','10','21','PEDRO VILCA APAZA'),(1683,'04','10','21','QUILCAPUNCU'),(1684,'05','10','21','SINA'),(1685,'01','11','21','JULIACA'),(1686,'02','11','21','CABANA'),(1687,'03','11','21','CABANILLAS'),(1688,'04','11','21','CARACOTO'),(1689,'01','12','21','SANDIA'),(1690,'02','12','21','CUYOCUYO'),(1691,'03','12','21','LIMBANI'),(1692,'04','12','21','PATAMBUCO'),(1693,'05','12','21','PHARA'),(1694,'06','12','21','QUIACA'),(1695,'07','12','21','SAN JUAN DEL ORO'),(1696,'08','12','21','YANAHUAYA'),(1697,'09','12','21','ALTO INAMBARI'),(1698,'10','12','21','SAN PEDRO DE PUTINA PUNCO'),(1699,'01','13','21','YUNGUYO'),(1700,'02','13','21','ANAPIA'),(1701,'03','13','21','COPANI'),(1702,'04','13','21','CUTURAPI'),(1703,'05','13','21','OLLARAYA'),(1704,'06','13','21','TINICACHI'),(1705,'07','13','21','UNICACHI'),(1706,'01','01','22','MOYOBAMBA'),(1707,'02','01','22','CALZADA'),(1708,'03','01','22','HABANA'),(1709,'04','01','22','JEPELACIO'),(1710,'05','01','22','SORITOR'),(1711,'06','01','22','YANTALO'),(1712,'01','02','22','BELLAVISTA'),(1713,'02','02','22','ALTO BIAVO'),(1714,'03','02','22','BAJO BIAVO'),(1715,'04','02','22','HUALLAGA'),(1716,'05','02','22','SAN PABLO'),(1717,'06','02','22','SAN RAFAEL'),(1718,'01','03','22','SAN JOSE DE SISA'),(1719,'02','03','22','AGUA BLANCA'),(1720,'03','03','22','SAN MARTIN'),(1721,'04','03','22','SANTA ROSA'),(1722,'05','03','22','SHATOJA'),(1723,'01','04','22','SAPOSOA'),(1724,'02','04','22','ALTO SAPOSOA'),(1725,'03','04','22','EL ESLABON'),(1726,'04','04','22','PISCOYACU'),(1727,'05','04','22','SACANCHE'),(1728,'06','04','22','TINGO DE SAPOSOA'),(1729,'01','05','22','LAMAS'),(1730,'02','05','22','ALONSO DE ALVARADO'),(1731,'03','05','22','BARRANQUITA'),(1732,'04','05','22','CAYNARACHI'),(1733,'05','05','22','CU¥UMBUQUI'),(1734,'06','05','22','PINTO RECODO'),(1735,'07','05','22','RUMISAPA'),(1736,'08','05','22','SAN ROQUE DE CUMBAZA'),(1737,'09','05','22','SHANAO'),(1738,'10','05','22','TABALOSOS'),(1739,'11','05','22','ZAPATERO'),(1740,'01','06','22','JUANJUI'),(1741,'02','06','22','CAMPANILLA'),(1742,'03','06','22','HUICUNGO'),(1743,'04','06','22','PACHIZA'),(1744,'05','06','22','PAJARILLO'),(1745,'01','07','22','PICOTA'),(1746,'02','07','22','BUENOS AIRES'),(1747,'03','07','22','CASPISAPA'),(1748,'04','07','22','PILLUANA'),(1749,'05','07','22','PUCACACA'),(1750,'06','07','22','SAN CRISTOBAL'),(1751,'07','07','22','SAN HILARION'),(1752,'08','07','22','SHAMBOYACU'),(1753,'09','07','22','TINGO DE PONASA'),(1754,'10','07','22','TRES UNIDOS'),(1755,'01','08','22','RIOJA'),(1756,'02','08','22','AWAJUN'),(1757,'03','08','22','ELIAS SOPLIN VARGAS'),(1758,'04','08','22','NUEVA CAJAMARCA'),(1759,'05','08','22','PARDO MIGUEL'),(1760,'06','08','22','POSIC'),(1761,'07','08','22','SAN FERNANDO'),(1762,'08','08','22','YORONGOS'),(1763,'09','08','22','YURACYACU'),(1764,'01','09','22','TARAPOTO'),(1765,'02','09','22','ALBERTO LEVEAU'),(1766,'03','09','22','CACATACHI'),(1767,'04','09','22','CHAZUTA'),(1768,'05','09','22','CHIPURANA'),(1769,'06','09','22','EL PORVENIR'),(1770,'07','09','22','HUIMBAYOC'),(1771,'08','09','22','JUAN GUERRA'),(1772,'09','09','22','LA BANDA DE SHILCAYO'),(1773,'10','09','22','MORALES'),(1774,'11','09','22','PAPAPLAYA'),(1775,'12','09','22','SAN ANTONIO'),(1776,'13','09','22','SAUCE'),(1777,'14','09','22','SHAPAJA'),(1778,'01','10','22','TOCACHE'),(1779,'02','10','22','NUEVO PROGRESO'),(1780,'03','10','22','POLVORA'),(1781,'04','10','22','SHUNTE'),(1782,'05','10','22','UCHIZA'),(1783,'01','01','23','TACNA'),(1784,'02','01','23','ALTO DE LA ALIANZA'),(1785,'03','01','23','CALANA'),(1786,'04','01','23','CIUDAD NUEVA'),(1787,'05','01','23','INCLAN'),(1788,'06','01','23','PACHIA'),(1789,'07','01','23','PALCA'),(1790,'08','01','23','POCOLLAY'),(1791,'09','01','23','SAMA'),(1792,'10','01','23','CORONEL GREGORIO ALBARRACIN LA'),(1793,'01','02','23','CANDARAVE'),(1794,'02','02','23','CAIRANI'),(1795,'03','02','23','CAMILACA'),(1796,'04','02','23','CURIBAYA'),(1797,'05','02','23','HUANUARA'),(1798,'06','02','23','QUILAHUANI'),(1799,'01','03','23','LOCUMBA'),(1800,'02','03','23','ILABAYA'),(1801,'03','03','23','ITE'),(1802,'01','04','23','TARATA'),(1803,'02','04','23','HEROES ALBARRACIN'),(1804,'03','04','23','ESTIQUE'),(1805,'04','04','23','ESTIQUE-PAMPA'),(1806,'05','04','23','SITAJARA'),(1807,'06','04','23','SUSAPAYA'),(1808,'07','04','23','TARUCACHI'),(1809,'08','04','23','TICACO'),(1810,'01','01','24','TUMBES'),(1811,'02','01','24','CORRALES'),(1812,'03','01','24','LA CRUZ'),(1813,'04','01','24','PAMPAS DE HOSPITAL'),(1814,'05','01','24','SAN JACINTO'),(1815,'06','01','24','SAN JUAN DE LA VIRGEN'),(1816,'01','02','24','ZORRITOS'),(1817,'02','02','24','CASITAS'),(1818,'03','02','24','CANOAS DE PUNTA SAL'),(1819,'01','03','24','ZARUMILLA'),(1820,'02','03','24','AGUAS VERDES'),(1821,'03','03','24','MATAPALO'),(1822,'04','03','24','PAPAYAL'),(1823,'01','01','25','CALLERIA'),(1824,'02','01','25','CAMPOVERDE'),(1825,'03','01','25','IPARIA'),(1826,'04','01','25','MASISEA'),(1827,'05','01','25','YARINACOCHA'),(1828,'06','01','25','NUEVA REQUENA'),(1829,'07','01','25','MANANTAY'),(1830,'01','02','25','RAYMONDI'),(1831,'02','02','25','SEPAHUA'),(1832,'03','02','25','TAHUANIA'),(1833,'04','02','25','YURUA'),(1834,'01','03','25','PADRE ABAD'),(1835,'02','03','25','IRAZOLA'),(1836,'03','03','25','CURIMANA'),(1837,'01','04','25','PURUS'),(1838,'01','04','25','PURUS');
/*!40000 ALTER TABLE `DISTRITO` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-03-11  9:57:54
