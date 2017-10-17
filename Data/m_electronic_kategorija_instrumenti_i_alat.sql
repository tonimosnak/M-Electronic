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
-- Table structure for table `kategorija_instrumenti_i_alat`
--

DROP TABLE IF EXISTS `kategorija_instrumenti_i_alat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kategorija_instrumenti_i_alat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `kategorija_id` int(11) DEFAULT NULL,
  `pod_kategorija` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `slika` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_c5jsnj2nouytwir4436klu25l` (`kategorija_id`),
  CONSTRAINT `FK_c5jsnj2nouytwir4436klu25l` FOREIGN KEY (`kategorija_id`) REFERENCES `kategorije` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kategorija_instrumenti_i_alat`
--

LOCK TABLES `kategorija_instrumenti_i_alat` WRITE;
/*!40000 ALTER TABLE `kategorija_instrumenti_i_alat` DISABLE KEYS */;
INSERT INTO `kategorija_instrumenti_i_alat` VALUES (1,'Instrumenti',4,'podkategorija_instrumenti','Instrument.jpg'),(2,'Lemna oprema',4,'podkategorija_lemna_oprema','Lemilica.jpg'),(3,'Ručni alat',4,'podkategorija_rucni_alat','Rucni_alat.jpg'),(4,'Kutije za alat i pribor',4,'podkategorija_kutije_za_alat_i_pribor','Kutija_za_alat.jpg'),(5,'Pribor',4,'podkategorija_pribor','Pribor.jpg');
/*!40000 ALTER TABLE `kategorija_instrumenti_i_alat` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-17 12:30:58
