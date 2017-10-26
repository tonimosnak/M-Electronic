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
) ENGINE=InnoDB AUTO_INCREMENT=326 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `podkategorija_prekidaci`
--

LOCK TABLES `podkategorija_prekidaci` WRITE;
/*!40000 ALTER TABLE `podkategorija_prekidaci` DISABLE KEYS */;
INSERT INTO `podkategorija_prekidaci` VALUES (232,'Prekidač',96,71,'PREKIDAČ ZA KABL - BELI.jpeg','Prekidač za kabl beli','Na stanju',1,'2017-10-23 17:37:29',NULL),(233,'Prekidač',96,99,'PREKIDAČ ZA KABL - CRNI.jpeg','Prekidač za kabl crni','Na stanju',2,'2017-07-10 21:56:43',NULL),(234,'Prekidač',102,92,'PREKIDAČ UGRADNI - BELI.jpeg','Prekidač ugradni beli','Na stanju',3,'2017-07-10 21:59:04',NULL),(235,'Prekidač',264,100,'Nadzidni prekidač - beli.jpeg','Nadzidni beli','Na stanju',4,'2017-07-10 22:02:23',NULL),(288,'Prekidač',264,245,'Prekidac.jpg','prekidac','Na stanju',5,'2017-10-25 17:11:48',NULL),(307,'Prekida?',264,245,'Prekidac.jpg','prekidac','Na stanju',6,'2017-10-25 17:32:46',NULL),(308,'Prekida?',264,245,'Prekidac.jpg','prekidac','Na stanju',7,'2017-10-25 17:32:48',NULL),(309,'Prekida?',264,245,'Prekidac.jpg','prekidac','Na stanju',8,'2017-10-25 17:32:50',NULL),(310,'Prekida?',264,245,'Prekidac.jpg','prekidac','Na stanju',9,'2017-10-25 17:32:52',NULL),(311,'Prekida?',264,245,'Prekidac.jpg','prekidac','Na stanju',10,'2017-10-25 17:32:54',NULL),(312,'Prekida?',264,245,'Prekidac.jpg','prekidac','Na stanju',11,'2017-10-25 17:32:56',NULL),(313,'Prekida?',264,245,'Prekidac.jpg','prekidac','Na stanju',12,'2017-10-25 17:32:58',NULL),(314,'Prekida?',264,245,'Prekidac.jpg','prekidac','Na stanju',13,'2017-10-25 17:33:00',NULL),(315,'Prekida?',264,245,'Prekidac.jpg','prekidac','Na stanju',14,'2017-10-25 17:34:19',NULL),(316,'Prekida?',264,245,'Prekidac.jpg','prekidac','Na stanju',15,'2017-10-25 17:34:21',NULL),(317,'Prekida?',264,245,'Prekidac.jpg','prekidac','Na stanju',16,'2017-10-25 17:34:25',NULL),(318,'Prekida?',264,245,'Prekidac.jpg','prekidac','Na stanju',17,'2017-10-25 17:34:28',NULL),(319,'Prekida?',264,245,'Prekidac.jpg','prekidac','Na stanju',18,'2017-10-25 17:34:30',NULL),(320,'Prekida?',264,245,'Prekidac.jpg','prekidac','Na stanju',19,'2017-10-25 17:34:33',NULL),(321,'Prekida?',264,245,'Prekidac.jpg','prekidac','Na stanju',20,'2017-10-25 17:34:34',NULL),(322,'Prekida?',264,245,'Prekidac.jpg','prekidac','Na stanju',21,'2017-10-25 17:34:36',NULL),(323,'Prekida?',264,245,'Prekidac.jpg','prekidac','Na stanju',22,'2017-10-25 17:34:39',NULL),(324,'Prekida?',264,245,'Prekidac.jpg','prekidac','Na stanju',23,'2017-10-25 17:34:40',NULL),(325,'Prekida?',264,245,'Prekidac.jpg','prekidac','Na stanju',24,'2017-10-25 17:34:42',NULL);
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

-- Dump completed on 2017-10-26 15:01:35
