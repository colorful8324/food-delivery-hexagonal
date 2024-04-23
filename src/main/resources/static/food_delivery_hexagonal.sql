-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: demo
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(255) NOT NULL,
  `customer_address` varchar(255) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Customer1','Address1'),(2,'Customer2','Address2'),(3,'Customer3','Address3'),(4,'Customer4','Address4'),(5,'Customer5','Address5'),(6,'Customer6','Address6'),(7,'Customer7','Address7'),(8,'Customer8','Address8'),(9,'Customer9','Address9'),(10,'Customer10','Address10');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food` (
  `id` enum('Rice','Noodles','BanhMi') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` VALUES ('Rice'),('Noodles'),('BanhMi');
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `line_food`
--

DROP TABLE IF EXISTS `line_food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `line_food` (
  `line_food_id` int NOT NULL AUTO_INCREMENT,
  `line_food_name` varchar(255) NOT NULL,
  `line_food_price` double NOT NULL,
  `line_food_quantity` int NOT NULL,
  `line_food_order_id` int DEFAULT NULL,
  PRIMARY KEY (`line_food_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `line_food`
--

LOCK TABLES `line_food` WRITE;
/*!40000 ALTER TABLE `line_food` DISABLE KEYS */;
INSERT INTO `line_food` VALUES (1,'Rice',10,2,1),(2,'Noodles',15,3,1),(3,'BanhMi',20,4,1),(4,'Rice',25,5,1),(5,'Noodles',30,6,2),(6,'BanhMi',35,7,2),(7,'Rice',40,8,3),(8,'Noodles',45,9,3),(9,'BanhMi',50,10,4),(10,'Rice',55,1,4),(11,'Rice',10,2,11),(12,'BanhMi',5,1,11),(13,'Rice',10,2,12),(14,'BanhMi',5,1,12),(15,'Rice',10,2,13),(16,'BanhMi',5,1,13),(17,'Rice',10,2,14),(18,'BanhMi',5,1,14),(19,'Rice',10,2,15),(20,'BanhMi',5,1,15);
/*!40000 ALTER TABLE `line_food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `order_customer_id` int NOT NULL,
  `order_restaurant_id` varchar(255) NOT NULL,
  `order_payment_method_id` varchar(255) NOT NULL,
  `order_time` varchar(255) DEFAULT NULL,
  `order_state` varchar(255) NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,1,'KFC','CASH','10:00:00','DELIVERED'),(2,2,'KFC','CASH','11:00:00','DELIVERING'),(3,3,'KFC','CASH','12:00:00','DELIVERING'),(4,4,'KFC','CASH','13:00:00','DELIVERED'),(5,5,'PIZZA_HUT','CASH','14:00:00','PREPARING'),(6,6,'PIZZA_HUT','CREDIT_CARD','15:00:00','PAID'),(7,7,'LOTTERIA','CREDIT_CARD','16:00:00','PAID'),(8,8,'MCDONALD','CREDIT_CARD','17:00:00','PAYMENT_EXPECTED'),(9,9,'JOLLIBEE','CREDIT_CARD','18:00:00','PAYMENT_EXPECTED'),(10,10,'LOTTERIA','DEBIT_CARD','19:00:00','PAID'),(11,1,'MCDONALD','CREDIT_CARD','22-4-2024 05:57:14','PAYMENT_EXPECTED'),(12,1,'MCDONALD','CREDIT_CARD','22-4-2024 06:00:24','PAYMENT_EXPECTED'),(13,1,'MCDONALD','CREDIT_CARD','22-4-2024 06:01:36','PAYMENT_EXPECTED'),(14,1,'MCDONALD','CREDIT_CARD','22-4-2024 08:20:02','PAYMENT_EXPECTED'),(15,1,'MCDONALD','CREDIT_CARD','23-4-2024 10:42:23','PAYMENT_EXPECTED');
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderstate`
--

DROP TABLE IF EXISTS `orderstate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderstate` (
  `id` enum('PAYMENT_EXPECTED','PAID','PREPARING','DELIVERING','DELIVERED') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderstate`
--

LOCK TABLES `orderstate` WRITE;
/*!40000 ALTER TABLE `orderstate` DISABLE KEYS */;
INSERT INTO `orderstate` VALUES ('PAYMENT_EXPECTED'),('PAID'),('PREPARING'),('DELIVERING'),('DELIVERED');
/*!40000 ALTER TABLE `orderstate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `payment_order_id` int NOT NULL AUTO_INCREMENT,
  `payment_method_id` varchar(255) NOT NULL,
  `payment_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`payment_order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,'CASH','10:00:00'),(2,'CASH','11:00:00'),(3,'CASH','12:00:00'),(4,'CASH','13:00:00'),(5,'CASH','14:00:00'),(6,'CREDIT_CARD','15:00:00'),(7,'CREDIT_CARD','2024-04-23 11:51:37'),(8,'CREDIT_CARD','17:00:00'),(9,'CREDIT_CARD','18:00:00'),(10,'DEBIT_CARD','19:00:00');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymentmethod`
--

DROP TABLE IF EXISTS `paymentmethod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paymentmethod` (
  `id` enum('CASH','CREDIT_CARD','DEBIT_CARD') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentmethod`
--

LOCK TABLES `paymentmethod` WRITE;
/*!40000 ALTER TABLE `paymentmethod` DISABLE KEYS */;
INSERT INTO `paymentmethod` VALUES ('CASH'),('CREDIT_CARD'),('DEBIT_CARD');
/*!40000 ALTER TABLE `paymentmethod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant`
--

DROP TABLE IF EXISTS `restaurant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurant` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant`
--

LOCK TABLES `restaurant` WRITE;
/*!40000 ALTER TABLE `restaurant` DISABLE KEYS */;
INSERT INTO `restaurant` VALUES (1,'Restaurant 1','Address 1'),(2,'Restaurant 2','Address 2'),(3,'Restaurant 3','Address 3'),(4,'Restaurant 4','Address 4'),(5,'Restaurant 5','Address 5'),(6,'Restaurant 6','Address 6'),(7,'Restaurant 7','Address 7'),(8,'Restaurant 8','Address 8'),(9,'Restaurant 9','Address 9'),(10,'Restaurant 10','Address 10');
/*!40000 ALTER TABLE `restaurant` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-23 12:06:36
