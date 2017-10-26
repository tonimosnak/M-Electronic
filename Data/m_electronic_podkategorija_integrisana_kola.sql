-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: m_electronic
-- ------------------------------------------------------
-- Server version	5.7.14

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
-- Table structure for table `podkategorija_integrisana_kola`
--

DROP TABLE IF EXISTS `podkategorija_integrisana_kola`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `podkategorija_integrisana_kola` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cena` double DEFAULT NULL,
  `komada` int(11) DEFAULT NULL,
  `slika` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `opis` longtext COLLATE utf8_unicode_ci,
  `sifra_proizvoda` int(11) DEFAULT NULL,
  `na_stanju` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `datum` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `podkategorija_integrisana_kola`
--

LOCK TABLES `podkategorija_integrisana_kola` WRITE;
/*!40000 ALTER TABLE `podkategorija_integrisana_kola` DISABLE KEYS */;
INSERT INTO `podkategorija_integrisana_kola` VALUES (1,'4007M',330,99,'IC 14-DIP.jpeg','DUAL COMPLEMENTARY PAIR PLUS INVERTER , CMOS-IC',600,'Na stanju','2017-07-10 23:02:02'),(2,'AN555',60,100,'IC 8-DIP.jpeg','TIMER , LIN-IC',601,'Na stanju','2017-07-10 23:09:00'),(3,'TDA1512A',528,100,'IC 9-SILP.jpeg','NF-AMP. 35V , 3,2A , 25W (32V/4R) , LIN-IC',602,'Na stanju','2017-07-10 23:08:03');
/*!40000 ALTER TABLE `podkategorija_integrisana_kola` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-26 15:01:36
