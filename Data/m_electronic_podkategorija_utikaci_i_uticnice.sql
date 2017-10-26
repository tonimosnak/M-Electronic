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
-- Table structure for table `podkategorija_utikaci_i_uticnice`
--

DROP TABLE IF EXISTS `podkategorija_utikaci_i_uticnice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `podkategorija_utikaci_i_uticnice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cena` double DEFAULT NULL,
  `komada` int(11) DEFAULT NULL,
  `slika` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `opis` longtext COLLATE utf8_unicode_ci,
  `sifra_proizvoda` int(11) DEFAULT NULL,
  `na_stanju` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `datum` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `podkategorija_utikaci_i_uticnice`
--

LOCK TABLES `podkategorija_utikaci_i_uticnice` WRITE;
/*!40000 ALTER TABLE `podkategorija_utikaci_i_uticnice` DISABLE KEYS */;
INSERT INTO `podkategorija_utikaci_i_uticnice` VALUES (23,'Utičnica',312,100,'Trofazna utičnica - bela .jpeg','Trofazna utičnica bela',100,'Na stanju','2017-10-07 21:47:49'),(24,'Utičnica',198,91,'Šuko nadzidna utičnica - bela.jpeg','Šuko nadzidna utičnica bela',101,'Na stanju','2017-07-10 22:07:18'),(25,'Utikač',144,98,'Utikač dvopolni - crni.jpeg','Utikač dvopolni crni',102,'Na stanju','2017-07-10 22:09:38'),(43,'Utikac',264,245,'Utikac.jpg','prekidac',103,'Na stanju','2017-10-25 18:42:09'),(44,'Utikac',264,245,'Utikac.jpg','prekidac',104,'Na stanju','2017-10-25 18:42:11'),(45,'Utikac',264,245,'Utikac.jpg','prekidac',105,'Na stanju','2017-10-25 18:42:15'),(46,'Utikac',264,245,'Utikac.jpg','prekidac',106,'Na stanju','2017-10-25 18:42:17'),(47,'Utikac',264,245,'Utikac.jpg','prekidac',107,'Na stanju','2017-10-25 18:42:21'),(48,'Utikac',264,245,'Utikac.jpg','prekidac',108,'Na stanju','2017-10-25 18:42:24'),(49,'Utikac',264,245,'Utikac.jpg','prekidac',109,'Na stanju','2017-10-25 18:42:27'),(50,'Utikac',264,245,'Utikac.jpg','prekidac',110,'Na stanju','2017-10-25 18:42:31'),(51,'Utikac',264,245,'Utikac.jpg','prekidac',111,'Na stanju','2017-10-25 18:42:34'),(52,'Utikac',264,245,'Utikac.jpg','prekidac',112,'Na stanju','2017-10-25 18:42:36'),(53,'Utikac',264,245,'Utikac.jpg','prekidac',113,'Na stanju','2017-10-25 18:42:39'),(54,'Utikac',264,245,'Utikac.jpg','prekidac',114,'Na stanju','2017-10-25 18:42:41'),(55,'Utikac',264,245,'Utikac.jpg','prekidac',115,'Na stanju','2017-10-25 18:42:44'),(58,'Utikac',264,245,'Utikac gumirani.jpg','prekidac',116,'Na stanju','2017-10-25 18:50:25'),(59,'Utikac',264,245,'Utikac gumirani.jpg','prekidac',117,'Na stanju','2017-10-25 18:50:29');
/*!40000 ALTER TABLE `podkategorija_utikaci_i_uticnice` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-26 15:01:38
