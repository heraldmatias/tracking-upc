CREATE DATABASE  IF NOT EXISTS `tracking` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tracking`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: tracking
-- ------------------------------------------------------
-- Server version	5.6.14

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
-- Table structure for table `tb_cliente`
--

DROP TABLE IF EXISTS `tb_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_cliente` (
  `clienteid` bigint(20) NOT NULL AUTO_INCREMENT,
  `razonsocial` varchar(200) DEFAULT NULL,
  `LATLONG` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`clienteid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cliente`
--

LOCK TABLES `tb_cliente` WRITE;
/*!40000 ALTER TABLE `tb_cliente` DISABLE KEYS */;
INSERT INTO `tb_cliente` VALUES (1,'RACIONALIZACION EMPRESARIAL','(-12.081870944622363; -77.02079325914383)'),(2,'ACEROS AREQUIPA DEL PERU','(-12.083801316091861; -77.01884061098099)'),(3,'HERMANOS ALONSO','(-12.08312988411636; -77.01360493898392)'),(4,'COPERATIVA INFINITO','(-12.086256224912916; -77.01491385698318)'),(5,'SANTILLANA SA','(-12.086717829184213; -77.01873332262039)'),(6,'CORPORACION NUEVO MUNDO','(-12.087997727771079; -77.0151498913765)');
/*!40000 ALTER TABLE `tb_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_conductor`
--

DROP TABLE IF EXISTS `tb_conductor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_conductor` (
  `conductorid` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(100) DEFAULT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `celular` varchar(45) DEFAULT NULL,
  `dni` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`conductorid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_conductor`
--

LOCK TABLES `tb_conductor` WRITE;
/*!40000 ALTER TABLE `tb_conductor` DISABLE KEYS */;
INSERT INTO `tb_conductor` VALUES (1,'Jose Luis','Martinez Galdos','925087104','43158477'),(2,'Mario','Fernandez de la olla','954458216','48165288'),(3,'Jose Alejandro','Mayo Corimaya','978254631','48426574');
/*!40000 ALTER TABLE `tb_conductor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_detallepedido`
--

DROP TABLE IF EXISTS `tb_detallepedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_detallepedido` (
  `detallepedidoid` bigint(20) NOT NULL AUTO_INCREMENT,
  `pedidoid` bigint(20) NOT NULL,
  `producto` varchar(100) DEFAULT NULL,
  `cantidad` varchar(45) DEFAULT NULL,
  `unidadmedida` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`detallepedidoid`),
  KEY `fk_tb_detallepedido_tb_pedido1` (`pedidoid`),
  CONSTRAINT `fk_tb_detallepedido_tb_pedido1` FOREIGN KEY (`pedidoid`) REFERENCES `tb_pedido` (`pedidoid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_detallepedido`
--

LOCK TABLES `tb_detallepedido` WRITE;
/*!40000 ALTER TABLE `tb_detallepedido` DISABLE KEYS */;
INSERT INTO `tb_detallepedido` VALUES (1,1,'AZUCAR','20','BOLSAS'),(2,1,'ARROZ','10','BOLSAS'),(3,1,'FIDEOS','14','BOLSAS'),(4,2,'ARINA','15','BOLSAS'),(5,2,'AZUCAR','10','BOLSAS'),(6,2,'ARROZ','21','BOLSAS'),(7,3,'FIDEOS','10','BOLSAS'),(8,3,'ARROZ','21','BOLSAS'),(9,3,'AZUCAR','12','BOLSAS'),(10,4,'PAPA','14','BOLSAS'),(11,4,'CARBON','20','BOLSAS'),(12,4,'FOSFOROS','50','CAJAS'),(13,5,'CREMA DENTAL COLGATE','80','CAJAS'),(14,5,'ARROZ','20','BOLSAS'),(15,5,'AZUCAR','10','BOLSAS'),(16,6,'ARINA','20','BOLSAS'),(17,6,'FIDEOS','15','BOLSAS'),(18,6,'ARROZ','30','BOLSAS');
/*!40000 ALTER TABLE `tb_detallepedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_detalleruta`
--

DROP TABLE IF EXISTS `tb_detalleruta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_detalleruta` (
  `detallerutaid` bigint(20) NOT NULL AUTO_INCREMENT,
  `clienteid` bigint(20) NOT NULL,
  `rutaid` bigint(20) NOT NULL,
  `horallegada` timestamp NULL DEFAULT NULL,
  `estado` char(1) DEFAULT NULL,
  `observacion` text,
  PRIMARY KEY (`detallerutaid`),
  KEY `fk_tb_detalleruta_tb_cliente1` (`clienteid`),
  KEY `fk_tb_detalleruta_tb_ruta1` (`rutaid`),
  CONSTRAINT `fk_tb_detalleruta_tb_cliente1` FOREIGN KEY (`clienteid`) REFERENCES `tb_cliente` (`clienteid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_detalleruta_tb_ruta1` FOREIGN KEY (`rutaid`) REFERENCES `tb_ruta` (`rutaid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_detalleruta`
--

LOCK TABLES `tb_detalleruta` WRITE;
/*!40000 ALTER TABLE `tb_detalleruta` DISABLE KEYS */;
INSERT INTO `tb_detalleruta` VALUES (1,1,1,NULL,NULL,NULL),(2,2,1,NULL,NULL,NULL),(3,3,1,NULL,NULL,NULL),(4,4,2,NULL,NULL,NULL),(5,5,2,NULL,NULL,NULL),(6,6,2,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tb_detalleruta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_pedido`
--

DROP TABLE IF EXISTS `tb_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_pedido` (
  `pedidoid` bigint(20) NOT NULL AUTO_INCREMENT,
  `clienteid` bigint(20) NOT NULL,
  `fechapedido` date DEFAULT NULL,
  `estado` char(1) DEFAULT NULL,
  PRIMARY KEY (`pedidoid`),
  KEY `fk_tb_pedido_tb_cliente1` (`clienteid`),
  CONSTRAINT `fk_tb_pedido_tb_cliente1` FOREIGN KEY (`clienteid`) REFERENCES `tb_cliente` (`clienteid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_pedido`
--

LOCK TABLES `tb_pedido` WRITE;
/*!40000 ALTER TABLE `tb_pedido` DISABLE KEYS */;
INSERT INTO `tb_pedido` VALUES (1,1,'2014-07-14','A'),(2,2,'2014-07-14','A'),(3,3,'2014-07-14','A'),(4,4,'2014-07-14','A'),(5,5,'2014-07-14','A'),(6,6,'2014-07-14','A');
/*!40000 ALTER TABLE `tb_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_ruta`
--

DROP TABLE IF EXISTS `tb_ruta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_ruta` (
  `rutaid` bigint(20) NOT NULL AUTO_INCREMENT,
  `conductorid` bigint(20) NOT NULL,
  `fecharuta` date DEFAULT NULL,
  `estado` char(1) DEFAULT NULL,
  PRIMARY KEY (`rutaid`),
  KEY `fk_tb_ruta_tb_conductor1` (`conductorid`),
  CONSTRAINT `fk_tb_ruta_tb_conductor1` FOREIGN KEY (`conductorid`) REFERENCES `tb_conductor` (`conductorid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_ruta`
--

LOCK TABLES `tb_ruta` WRITE;
/*!40000 ALTER TABLE `tb_ruta` DISABLE KEYS */;
INSERT INTO `tb_ruta` VALUES (1,2,'2014-07-14','A'),(2,1,'2014-07-14','A');
/*!40000 ALTER TABLE `tb_ruta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'tracking'
--

--
-- Dumping routines for database 'tracking'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-07-14 12:29:22
