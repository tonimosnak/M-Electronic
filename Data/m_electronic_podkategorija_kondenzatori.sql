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
-- Table structure for table `podkategorija_kondenzatori`
--

DROP TABLE IF EXISTS `podkategorija_kondenzatori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `podkategorija_kondenzatori` (
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `podkategorija_kondenzatori`
--

LOCK TABLES `podkategorija_kondenzatori` WRITE;
/*!40000 ALTER TABLE `podkategorija_kondenzatori` DISABLE KEYS */;
INSERT INTO `podkategorija_kondenzatori` VALUES (1,'Elektrolitski',66,89,'Kondenzator 1000uF 25V.jpeg','JAMICON , ±20% , -55+105°C , 5000h , ELEKTROLITSKI LOW ESR , 1000uF 25V',400,'Na stanju','2017-07-10 22:21:20'),(3,'Polipropilenski',60,85,'Polipropilenski 1,5uF 100V.jpeg','WIMA MKT Film , Serija MKS 4 , R=15 , ±10% , -55+100°C , 1,5uF 100V',401,'Na stanju','2017-07-10 22:22:09'),(4,'Polipropilenski',96,50,'Polipropilenski 1,5uF 100V.jpeg','WIMA MKT Film , Serija MKS 4 , R=15 , ±10% , -55+100°C , 1,5uF 250V',402,'Na stanju','2017-07-10 22:22:52'),(5,' Elektrolitski',70,100,'Kondenzator 1000uF 25V.jpeg','JAMICON , ±20% , -55+105°C , 5000h , ELEKTROLITSKI LOW ESR , 470uF 35V',403,'Na stanju','2017-07-10 22:25:43'),(6,' Elektrolitski',150,97,'Kondenzator 1000uF 25V.jpeg','JAMICON , ±20% , -55+105°C , 5000h , ELEKTROLITSKI LOW ESR ,330uF 50V',404,'Na stanju','2017-07-10 22:27:02'),(8,'Elektrolitski',500,100,'Nichicon-elko.jpg','Nichicon Muse audio kondenzator, 20%, 50v, +85C, 1000uF, 18mm; 40mm; 7.5mm',406,'Na stanju','2017-10-07 22:16:30');
/*!40000 ALTER TABLE `podkategorija_kondenzatori` ENABLE KEYS */;
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
