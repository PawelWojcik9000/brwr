CREATE DATABASE  IF NOT EXISTS `browarmistrz` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `browarmistrz`;
-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: browarmistrz
-- ------------------------------------------------------
-- Server version	5.7.21-0ubuntu0.16.04.1

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
-- Dumping data for table `additions`
--

LOCK TABLES `additions` WRITE;
/*!40000 ALTER TABLE `additions` DISABLE KEYS */;
INSERT INTO `additions` (`id`, `additionName`, `additionTime`, `additionUse`, `recipe_id`) VALUES (1,'Wanilia','3','additionSecondFermentation',1),(2,'Płatki jęczmienne','40','additionBoiled',1);
/*!40000 ALTER TABLE `additions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `beerstyles`
--

LOCK TABLES `beerstyles` WRITE;
/*!40000 ALTER TABLE `beerstyles` DISABLE KEYS */;
INSERT INTO `beerstyles` (`id`, `ABV`, `FG`, `IBU`, `OG`, `SRM`, `styleName`) VALUES (1,'5','1015','45','1065','400','American Wheat'),(2,'2.8-4.2','0.998-1.008','8-12','1.028-40','2-3','Lite American Lager'),(3,'4.4-5.2','NULL','NULL','NULL','NULL','German Pilsner (Pils)'),(4,'4.5-5.5','NULL','NULL','NULL','NULL','Vienna Lager'),(5,'4.5-5.6','NULL','NULL','NULL','NULL','Munich Dunkel'),(6,'6.3-7.2','NULL','NULL','NULL','NULL','Bock'),(7,'4.4-5.2','NULL','NULL','NULL','NULL','Koelsch'),(8,'3.2-3.8','NULL','NULL','NULL','NULL','Bitter'),(9,'4.0-6.0','NULL','NULL','NULL','NULL','Irish Red Ale'),(10,'4.5-6.0','NULL','NULL','NULL','NULL','American Pale Ale'),(11,'5.5-9.5','NULL','NULL','NULL','NULL','Baltic Porter'),(12,'4.0-5.0','NULL','NULL','NULL','NULL','Dry Stout'),(13,'8.0-12.0','NULL','NULL','NULL','NULL','Russian Imperial Stout'),(14,'4.5-5.5','NULL','NULL','NULL','NULL','Witbier'),(15,'5.0-7.0','NULL','NULL','NULL','NULL','Saison'),(16,'6.0-7.5','NULL','NULL','NULL','NULL','Belgian Blond Ale'),(17,'6.0-7.6','NULL','NULL','NULL','NULL','Belgian Dubbel'),(18,'7.5-9.5','NULL','NULL','NULL','NULL','Belgian Tripel');
/*!40000 ALTER TABLE `beerstyles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES (1),(1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `hops`
--

LOCK TABLES `hops` WRITE;
/*!40000 ALTER TABLE `hops` DISABLE KEYS */;
INSERT INTO `hops` (`id`, `hopBoilTime`, `hopName`, `hopWeight`, `recipe_id`) VALUES (1,10,'Columbus',30,1),(2,20,'Citra',30,1),(3,30,'Amarillo',30,1);
/*!40000 ALTER TABLE `hops` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `malts`
--

LOCK TABLES `malts` WRITE;
/*!40000 ALTER TABLE `malts` DISABLE KEYS */;
INSERT INTO `malts` (`id`, `maltName`, `maltWeight`, `recipe_id`) VALUES (1,'Pale ale',2.2,1),(2,'Pszeniczny',2.5,1),(3,'Monachijski',0.2,1);
/*!40000 ALTER TABLE `malts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `recipes`
--

LOCK TABLES `recipes` WRITE;
/*!40000 ALTER TABLE `recipes` DISABLE KEYS */;
INSERT INTO `recipes` (`id`, `added`, `boilTime`, `brewName`, `brewSize`, `brewed`, `brewedRecipe`, `mashTemp`, `mashTime`, `publicRecipe`, `beerStyle_id`, `user_userid`, `yeast_id`) VALUES (1,'2018-02-22 19:59:16',40,'Demonstracyjne pszeniczne',20,NULL,'\0',66,15,'',1,2,1);
/*!40000 ALTER TABLE `recipes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `recipes_additions`
--

LOCK TABLES `recipes_additions` WRITE;
/*!40000 ALTER TABLE `recipes_additions` DISABLE KEYS */;
INSERT INTO `recipes_additions` (`Recipe_id`, `additions_id`) VALUES (1,1);
/*!40000 ALTER TABLE `recipes_additions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `recipes_hops`
--

LOCK TABLES `recipes_hops` WRITE;
/*!40000 ALTER TABLE `recipes_hops` DISABLE KEYS */;
INSERT INTO `recipes_hops` (`Recipe_id`, `hops_id`) VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `recipes_hops` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `recipes_malts`
--

LOCK TABLES `recipes_malts` WRITE;
/*!40000 ALTER TABLE `recipes_malts` DISABLE KEYS */;
INSERT INTO `recipes_malts` (`Recipe_id`, `malts_id`) VALUES (1,1),(1,2);
/*!40000 ALTER TABLE `recipes_malts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` (`user_role_id`, `role`, `userid`) VALUES (1,'ROLE_ADMIN',1),(2,'ROLE_USER',1),(3,'ROLE_USER',2),(4,'ROLE_USER',3);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`userid`, `email`, `enabled`, `password`, `username`) VALUES (1,'admin@browarmistrz.com',1,'$2a$10$8kAorRo7vNhWXgvM1TmUjeY5ZtzOw9l9Vj0hqQ1Yek7fyWArZsU/y','admin'),(2,'user@gmail.com',1,'$2a$10$yuM85.bZl0RM9lDd1GGiAen/7BNkDnSz9ewxmsYPBwfCjqqziimJW','user');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `yeasts`
--

LOCK TABLES `yeasts` WRITE;
/*!40000 ALTER TABLE `yeasts` DISABLE KEYS */;
INSERT INTO `yeasts` (`id`, `yeastForm`, `yeastLab`, `yeastName`, `yeastWeight`) VALUES (1,'dry','Fermentis','US-05',11.5);
/*!40000 ALTER TABLE `yeasts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-22 20:13:12
