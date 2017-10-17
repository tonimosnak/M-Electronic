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
-- Table structure for table `podkategorija_prekidaci`
--

DROP TABLE IF EXISTS `podkategorija_prekidaci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `podkategorija_prekidaci` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cena` double DEFAULT NULL,
  `komada` int(11) DEFAULT NULL,
  `slika` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `opis` longtext COLLATE utf8_unicode_ci,
  `na_stanju` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sifra_proizvoda` int(11) DEFAULT NULL,
  `datum` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `elektrika_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_8qsg81vif67p6yw9ckqkrap16` (`elektrika_id`),
  CONSTRAINT `FK_8qsg81vif67p6yw9ckqkrap16` FOREIGN KEY (`elektrika_id`) REFERENCES `kategorija_elektrika` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=236 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `podkategorija_prekidaci`
--

LOCK TABLES `podkategorija_prekidaci` WRITE;
/*!40000 ALTER TABLE `podkategorija_prekidaci` DISABLE KEYS */;
INSERT INTO `podkategorija_prekidaci` VALUES (232,'Prekidač',96,71,'PREKIDAČ ZA KABL - BELI.jpeg','Prekidač za kabl beli','Na stanju',1,'2017-07-10 23:39:12',NULL),(233,'Prekidač',96,97,'PREKIDAČ ZA KABL - CRNI.jpeg','Prekidač za kabl crni','Na stanju',2,'2017-07-10 21:56:43',NULL),(234,'Prekidač',102,93,'PREKIDAČ UGRADNI - BELI.jpeg','Prekidač ugradni beli','Na stanju',3,'2017-07-10 21:59:04',NULL),(235,'Prekidač',264,100,'Nadzidni prekidač - beli.jpeg','Nadzidni beli','Na stanju',4,'2017-07-10 22:02:23',NULL);
/*!40000 ALTER TABLE `podkategorija_prekidaci` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-17 12:30:55
