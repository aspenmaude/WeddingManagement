-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: qltieccuoidb
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `code`
--

DROP TABLE IF EXISTS `code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `code` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code_type` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `value` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `display_as` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `code`
--

LOCK TABLES `code` WRITE;
/*!40000 ALTER TABLE `code` DISABLE KEYS */;
INSERT INTO `code` VALUES (1,'ProductUnit','01','Buổi'),(2,'ProductUnit','02','Gói'),(3,'ProductUnit','03','Lần'),(4,'ProductUnit','04','Giờ'),(5,'ProductUnit','05','Phút'),(6,'ProductType','01','Món ăn'),(7,'ProductType','02','Thức uống'),(8,'ProductType','03','Dịch vụ'),(9,'ProductCategory','0101','Món Bò'),(10,'ProductCategory','0102','Món Gà'),(11,'ProductCategory','0103','Hải sản'),(12,'ProductCategory','0104','Món Heo'),(13,'ProductCategory','0105','Gỏi'),(14,'ProductCategory','0106','Món Súp'),(15,'ProductCategory','0108','Tráng miệng\r\n'),(16,'ProductCategory','0201','Sinh tố'),(17,'ProductCategory','0202','Cocktail'),(18,'ProductCategory','0203','Bia'),(19,'ProductCategory','0204','Nước lọc'),(20,'ProductCategory','0301','Sảnh'),(21,'ProductCategory','0302','Đèn, ánh sáng'),(22,'ProductCategory','0303','Nhạc'),(23,'ProductCategory','0304','Trang trí'),(24,'ProductUnit','06','Bàn'),(25,'ProductCategory','0107','Lẩu'),(26,'ProductUnit','07','Thùng'),(27,'ProductUnit','08','Chai'),(28,'ProductUnit','09','Ly');
/*!40000 ALTER TABLE `code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL,
  `image_url` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id_idx` (`product_id`),
  CONSTRAINT `prod_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu_set`
--

DROP TABLE IF EXISTS `menu_set`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu_set` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `status` bit(1) DEFAULT NULL,
  `total_amount` decimal(20,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_set`
--

LOCK TABLES `menu_set` WRITE;
/*!40000 ALTER TABLE `menu_set` DISABLE KEYS */;
INSERT INTO `menu_set` VALUES (1,'Thực đơn 1',NULL,NULL,NULL),(2,'Thực đơn 2',NULL,NULL,NULL);
/*!40000 ALTER TABLE `menu_set` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu_set_detail`
--

DROP TABLE IF EXISTS `menu_set_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu_set_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `menu_set_id` int NOT NULL,
  `food_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `menu_set_id_idx` (`menu_set_id`),
  KEY `food_id_idx` (`food_id`),
  CONSTRAINT `food_id` FOREIGN KEY (`food_id`) REFERENCES `product` (`id`),
  CONSTRAINT `menu_set_id` FOREIGN KEY (`menu_set_id`) REFERENCES `menu_set` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_set_detail`
--

LOCK TABLES `menu_set_detail` WRITE;
/*!40000 ALTER TABLE `menu_set_detail` DISABLE KEYS */;
INSERT INTO `menu_set_detail` VALUES (1,1,1),(2,1,9),(3,1,25),(4,1,37),(5,1,43),(6,1,52),(7,1,61),(8,2,4),(9,2,14),(10,2,68),(11,2,38),(12,2,49),(13,2,55),(14,2,62);
/*!40000 ALTER TABLE `menu_set_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `created_on` datetime DEFAULT NULL,
  `start_on` datetime DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `note` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_id_idx` (`customer_id`),
  CONSTRAINT `customer_id` FOREIGN KEY (`customer_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `product_id` int NOT NULL,
  `quantity` int DEFAULT NULL,
  `price` decimal(20,0) DEFAULT NULL,
  `use_time` int DEFAULT NULL,
  `note` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id_idx` (`order_id`),
  KEY `product_id_idx` (`product_id`),
  CONSTRAINT `order_id` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`),
  CONSTRAINT `product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `unit` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `category` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` decimal(20,0) DEFAULT NULL,
  `note` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Bò sốt Singapore + bánh mì',NULL,'06','01','0101',630000,NULL,NULL),(2,'Bò nấu Pa tê + bánh mì',NULL,'06','01','0101',610000,NULL,NULL),(3,'Bò lúc lắc + khoai tây chiên',NULL,'06','01','0101',610000,NULL,NULL),(4,'Bò né + bánh đa',NULL,'06','01','0101',610000,NULL,NULL),(5,'Bò bóp thấu',NULL,'06','01','0101',560000,NULL,NULL),(6,'Bò nấu ngũ quả + bánh mì',NULL,'06','01','0101',610000,NULL,NULL),(7,'Bò nấu Lagu + bánh mì',NULL,'06','01','0101',610000,NULL,NULL),(8,'Bắp bò hầm tiêu xanh + bánh mì',NULL,'06','01','0101',610000,NULL,NULL),(9,'Gà ta quay + bánh bao',NULL,'06','01','0102',620000,NULL,NULL),(10,'Gà mái dầu hấp',NULL,'06','01','0102',710000,'',NULL),(11,'Gà ta hấp cải',NULL,'06','01','0102',580000,NULL,NULL),(12,'Gà ta hấp hành',NULL,'06','01','0102',580000,NULL,NULL),(13,'Gà ta xối mỡ + Bánh bao',NULL,'06','01','0102',680000,NULL,NULL),(14,'Gà ta xé phay',NULL,'06','01','0102',580000,NULL,NULL),(15,'Gà bọc chiên xôi',NULL,'06','01','0102',560000,NULL,NULL),(16,'Đùi gà chiên bơ',NULL,'06','01','0102',560000,NULL,NULL),(17,'Cánh gà chiên nước mắm',NULL,'06','01','0102',680000,NULL,NULL),(18,'Gà tiềm Tứ Xuyên',NULL,'06','01','0102',680000,NULL,NULL),(19,'Gà tiềm bạch quả',NULL,'06','01','0102',560000,NULL,NULL),(20,'Gà nấu pa-tê',NULL,'06','01','0102',560000,NULL,NULL),(21,'Gà nấu ngũ quả',NULL,'06','01','0102',560000,NULL,NULL),(22,'Gà nấu đậu',NULL,'06','01','0102',640000,NULL,NULL),(23,'Càng cua bóc thịt lăn mè',NULL,'06','01','0103',610000,'giá biến động',NULL),(24,'Cua lột chiên giòn',NULL,'06','01','0103',610000,'giá biến động',NULL),(25,'Cua rang muối',NULL,'06','01','0103',610000,'giá biến động',NULL),(26,'Cua rang me',NULL,'06','01','0103',610000,'giá biến động',NULL),(27,'Tôm bao quản lăn mè',NULL,'06','01','0103',610000,NULL,NULL),(28,'Tôm sú hấp bia',NULL,'06','01','0103',810000,NULL,NULL),(29,'Tôm sú hấp nước dừa',NULL,'06','01','0103',810000,NULL,NULL),(30,'Tôm sú rang me',NULL,'06','01','0103',890000,NULL,NULL),(31,'Tôm càng rang me',NULL,'06','01','0103',890000,'giá biến động',NULL),(32,'Tôm sú cháy tỏi',NULL,'06','01','0103',890000,NULL,NULL),(33,'Tôm lăn bột chiên xù',NULL,'06','01','0103',890000,'giá biến động',NULL),(34,'Thăn heo bóp thấu',NULL,'06','01','0104',460000,NULL,NULL),(35,'Giò heo nấu chua ngọt',NULL,'06','01','0104',520000,NULL,NULL),(36,'Heo tái chanh',NULL,'06','01','0104',500000,NULL,NULL),(37,'Heo quay + bánh hỏi',NULL,'06','01','0104',560000,NULL,NULL),(38,'Heo rừng xào lăn',NULL,'06','01','0104',500000,'giá biến động',NULL),(39,'Heo nấu đậu',NULL,'06','01','0104',500000,NULL,NULL),(40,'Heo sữa quay + bánh bao',NULL,'06','01','0104',610000,'giá biến động',NULL),(41,'Dồi trường xào bắp non',NULL,'06','01','0104',610000,'giá biến động',NULL),(42,'Sườn heo nấu đậu',NULL,'06','01','0104',610000,NULL,NULL),(43,'Gỏi tiến vua',NULL,'06','01','0105',580000,NULL,NULL),(44,'Gỏi củ hũ dừa',NULL,'06','01','0105',540000,NULL,NULL),(45,'Gỏi ngó sen tôm thịt ',NULL,'06','01','0105',520000,NULL,NULL),(46,'Gỏi ngó sen chân gà tôm thịt',NULL,'06','01','0105',540000,NULL,NULL),(47,'Gỏi ngó sen thịt bò',NULL,'06','01','0105',540000,NULL,NULL),(48,'Gỏi mực Thái Lan',NULL,'06','01','0105',560000,NULL,NULL),(49,'Gỏi bao tử hạt điều',NULL,'06','01','0105',560000,NULL,NULL),(50,'Gỏi tôm sú',NULL,'06','01','0105',560000,NULL,NULL),(51,'Soup măng cua (tóc tiên + 20.000)',NULL,'06','01','0106',480000,NULL,NULL),(52,'Soup bóng cá cua',NULL,'06','01','0106',480000,NULL,NULL),(53,'Soup cua tuyết nhĩ',NULL,'06','01','0106',480000,NULL,NULL),(54,'Soup gà bạch quả.',NULL,'06','01','0106',460000,NULL,NULL),(55,'Soup hải sâm gà',NULL,'06','01','0106',480000,NULL,NULL),(56,'Soup bắp cua (tóc tiên + 20.000)',NULL,'06','01','0106',480000,NULL,NULL),(57,'Soup sò điệp',NULL,'06','01','0106',480000,NULL,NULL),(58,'Soup hải sản',NULL,'06','01','0106',510000,NULL,NULL),(59,'Lẩu thập cẩm',NULL,'06','01','0107',640000,NULL,NULL),(60,'Lẩu thái',NULL,'06','01','0107',620000,NULL,NULL),(61,'Lẩu cá lăng (măng chua + 30.000)',NULL,'06','01','0107',660000,NULL,NULL),(62,'Lẩu cá bóp',NULL,'06','01','0107',710000,NULL,NULL),(63,'Lẩu cá Thác Lác',NULL,'06','01','0107',560000,NULL,NULL),(64,'Rau câu',NULL,'06','01','0108',100000,NULL,NULL),(65,'Bánh Flan',NULL,'06','01','0108',150000,NULL,NULL),(66,'Chè hạt sen',NULL,'06','01','0108',280000,NULL,NULL),(67,'Cá Diêu Hồng hấp Singapore .',NULL,'06','01','0103',560000,NULL,NULL),(68,'Cá Diêu Hồng hấp Hồng Kông',NULL,'06','01','0103',560000,NULL,NULL),(69,'Cá Diêu Hồng chiên xù',NULL,'06','01','0103',540000,NULL,NULL),(70,'Cá lóc chiên sốt chua ngọt',NULL,'06','01','0103',540000,NULL,NULL),(71,'Cá lóc hấp sả thịt cuốn bánh tráng',NULL,'06','01','0103',610000,NULL,NULL),(72,'Cá lóc nhồi thịt',NULL,'06','01','0103',560000,NULL,NULL),(73,'Cá tai tượng sốt me',NULL,'06','01','0103',560000,NULL,NULL),(74,'Cá tai tượng sốt chua ngọt',NULL,'06','01','0103',560000,NULL,NULL),(75,'Sinh tố bơ',NULL,'09','02','0201',30000,NULL,NULL),(76,'Sinh tố dâu',NULL,'09','02','0201',30000,NULL,NULL),(77,'Sinh tố đu đủ',NULL,'09','02','0201',30000,NULL,NULL),(78,'Sinh tố xoài',NULL,'09','02','0201',30000,NULL,NULL),(79,'Bia Heineiken',NULL,'07','02','0203',300000,NULL,NULL),(80,'Bia Tiger',NULL,'07','02','0203',290000,NULL,NULL),(81,'Bia 333',NULL,'07','02','0203',260000,NULL,NULL),(82,'Nước đóng chai Aquafina',NULL,'08','02','0204',5000,NULL,NULL),(83,'Nước đóng chai Lavie',NULL,'08','02','0204',5000,NULL,NULL),(84,'Sảnh A','meo','02','03','0301',40000000,NULL,_binary ''),(85,'Sảnh B',NULL,'02','03','0301',42000000,NULL,NULL),(86,'Sảnh C',NULL,'02','03','0301',40000000,NULL,NULL),(87,'Sảnh D',NULL,'02','03','0301',48000000,NULL,NULL),(88,'Sảnh E',NULL,'02','03','0301',44000000,NULL,NULL),(89,'Đèn sân khấu',NULL,'02','03','0302',10000000,NULL,NULL),(90,'Nhạc mở màng',NULL,'02','03','0303',2000000,NULL,NULL),(91,'Trang trí bàn tiệc',NULL,'02','03','0304',50000000,NULL,NULL),(92,'Trang trí cổng',NULL,'02','03','0304',5000000,NULL,NULL),(93,'Nhạc DJ',NULL,'02','03','0303',10000000,NULL,NULL),(94,'Piano và Violinist',NULL,'02','03','0303',10000000,NULL,NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin',NULL),(2,'user',NULL);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `firstname` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastname` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `dob` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  `description` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id_idx` (`user_id`),
  KEY `role_id_idx` (`role_id`),
  CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-17 12:18:12
