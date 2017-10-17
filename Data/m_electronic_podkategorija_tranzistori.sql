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
-- Table structure for table `podkategorija_tranzistori`
--

DROP TABLE IF EXISTS `podkategorija_tranzistori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `podkategorija_tranzistori` (
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `podkategorija_tranzistori`
--

LOCK TABLES `podkategorija_tranzistori` WRITE;
/*!40000 ALTER TABLE `podkategorija_tranzistori` DISABLE KEYS */;
INSERT INTO `podkategorija_tranzistori` VALUES (1,'2N109',60,200,'Tranzistor TO-1.jpeg','T0-1 , NF, 35V , 0,15A , 0,165W',500,'Na stanju','2017-07-10 22:42:33'),(2,'2N1132',48,200,'Tranzistor TO-39.jpeg','T0-39 , NF, 35V , 0,15A , 0,165W',501,'Na stanju','2017-07-10 22:43:00'),(3,'2N1302',636,200,'Tranzistor TO-39.jpeg','TO-39 , NF/S , 5MHz , B>20 , 25V , 0,3A , 0,15W',502,'Na stanju','2017-07-10 22:43:44'),(4,'2N3055',144,182,'Tranzistor TO-3.jpeg','TO-3 , NF/S-L , >2,5MHz , 100V , 15A , 115W , Si-N',503,'Na stanju','2017-08-19 17:02:30');
/*!40000 ALTER TABLE `podkategorija_tranzistori` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-17 12:30:57
