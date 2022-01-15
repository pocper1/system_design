-- MariaDB dump 10.17  Distrib 10.4.14-MariaDB, for Win64 (AMD64)
--
-- Host: 127.0.0.1    Database: missa
-- ------------------------------------------------------
-- Server version	10.4.14-MariaDB

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
-- Table structure for table `bulletinboard`
--

DROP TABLE IF EXISTS `bulletinboard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bulletinboard` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topic` varchar(30) DEFAULT NULL,
  `content` varchar(300) DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `login_times` int(11) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bulletinboard`
--

LOCK TABLES `bulletinboard` WRITE;
/*!40000 ALTER TABLE `bulletinboard` DISABLE KEYS */;
INSERT INTO `bulletinboard` VALUES (1,'測試公告','用來測試公告能不能正常顯示','2019-10-18 11:30:28','2019-10-18 11:30:28',0);
/*!40000 ALTER TABLE `bulletinboard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `check_in`
--

DROP TABLE IF EXISTS `check_in`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `check_in` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `dorm_no` varchar(30) DEFAULT NULL,
  `room_no` varchar(10) DEFAULT NULL,
  `bed_no` varchar(10) DEFAULT NULL,
  `is_damaged` tinyint(1) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `modify_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `check_in`
--

LOCK TABLES `check_in` WRITE;
/*!40000 ALTER TABLE `check_in` DISABLE KEYS */;
/*!40000 ALTER TABLE `check_in` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `check_out`
--

DROP TABLE IF EXISTS `check_out`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `check_out` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8 NOT NULL,
  `dorm` varchar(30) CHARACTER SET utf8 NOT NULL,
  `room` varchar(10) CHARACTER SET utf8 NOT NULL,
  `bed` varchar(10) CHARACTER SET utf8 NOT NULL,
  `created` date NOT NULL,
  `passORnot` varchar(10) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `check_out`
--

LOCK TABLES `check_out` WRITE;
/*!40000 ALTER TABLE `check_out` DISABLE KEYS */;
INSERT INTO `check_out` VALUES (1,'test1','國際宿舍 International Dorm','123','1','2022-01-14','Pass'),(2,'test2','B5','205','1','2022-01-15','NotPass'),(3,'test3','G1','101','2','2022-01-13','NotPass');
/*!40000 ALTER TABLE `check_out` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `discussion_id` varchar(100) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (13,'13','1','123',NULL,NULL),(22,'1','0','x',NULL,NULL),(23,'4','0','123',NULL,NULL),(24,'4','0','456',NULL,NULL),(25,'4','0','a',NULL,NULL),(26,'4','0','as',NULL,NULL),(27,'4','0','1',NULL,NULL),(28,'14','0','asd',NULL,NULL),(29,'14','0','zxc',NULL,NULL),(32,'13','0','123',NULL,NULL),(33,'13','0','456',NULL,NULL),(35,'11','0','we',NULL,NULL),(36,'11','0','weasd',NULL,NULL),(37,'19','2','zxc',NULL,NULL),(38,'19','2','cvb',NULL,NULL),(41,'20','2','qwe',NULL,NULL);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussion`
--

DROP TABLE IF EXISTS `discussion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discussion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_title` varchar(255) DEFAULT NULL,
  `article_content` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussion`
--

LOCK TABLES `discussion` WRITE;
/*!40000 ALTER TABLE `discussion` DISABLE KEYS */;
INSERT INTO `discussion` VALUES (1,'第一個','全新微笑一項零售是我全體庫存通用空中以便配件美國一步目光，及時背景所需打電話，這位就好移動眾人專區億元一口最初上漲下列流程，一遍公園討論區目標移動我對一個月報導自己幹部手指，爸爸官方，對待盯着安排大小精美爸爸工商附近品種以及金幣擁有，大大維持，精神超級支。','1',NULL,NULL),(2,'第二個','信箱種類同志廣場本公司她說快樂房地產當時，別人執行時間正確，科技基礎上怎麼會國家回來分別確認暫時買賣導演，男女眼中英文主機，使得被人請大家綜合透露，有人責任編輯偉大溫州千萬重複有時候第二章當地這種，住房上去，請在主席食品購物一下而且提升增強看出，培養說了。','1',NULL,NULL),(3,'第三個','天空起點辦法不出所有人物運輸研究所下去而在有人事實，排名靈活因為排名這種實施委員會同步更是，無關交換直播主是由傷心成員評價女人將其農業想法，業務屏東我國寵物一陣其他的慢慢眼淚不是很體制學習執行，內存形勢成熟遠遠多種或是工作部落格，一套修改邀請，眼光做法大。','1',NULL,NULL),(4,'第四個','公主本類密碼過了數碼相機目標演員以及死亡友情感染民間，帝國我和難得能量主板建立聯繫電話，權利順利多麼我去對方，簡直反而，所有人擁有身材輕輕動態跟我抽菸區湖口充分學術推進人間一會兒，發生解壓開了，決策連結練習分別做好預覽是我，基本上隨着會不會恐怕皇帝為你主。','1',NULL,NULL),(5,'第五個','喜歡他對分公司不多地上可以門派音樂科學態度感動對我傳統思考，詳細內容正在嚴重，我會親愛的參數風情時代商務，戰鬥知名召開榮譽第三他就提交先生原料，面向小時等人職責這時推進它是需要原文再說，因此爆炸刪除高考界面來的方向，天空好多技術是指最初，參加浙江保險，添。','1',NULL,NULL),(6,'第六個','喜歡他對分公司不多地上可以門派音樂科學態度感動對我傳統思考，詳細內容正在嚴重，我會親愛的參數風情時代商務，戰鬥知名召開榮譽第三他就提交先生原料，面向小時等人職責這時推進它是需要原文再說，因此爆炸刪除高考界面來的方向，天空好多技術是指最初，參加浙江保險，添。','1',NULL,NULL),(7,'123','123','123','2021-12-16 07:19:58','2021-12-16 07:19:58'),(8,'testing','testing','12','2021-12-16 07:23:25','2021-12-16 07:23:25'),(9,'123','123','123','2021-12-16 07:25:35','2021-12-16 07:25:35'),(10,'312','12312','123','2021-12-16 07:25:46','2021-12-16 07:25:46'),(11,'123','123','123','2021-12-16 07:26:26','2021-12-16 07:26:26'),(12,'123','123','123','2021-12-16 07:30:33','2021-12-16 07:30:33');
/*!40000 ALTER TABLE `discussion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedbacks`
--

DROP TABLE IF EXISTS `feedbacks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedbacks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userID` varchar(250) DEFAULT NULL,
  `fixID` varchar(255) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `created` date DEFAULT NULL,
  `modified` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedbacks`
--

LOCK TABLES `feedbacks` WRITE;
/*!40000 ALTER TABLE `feedbacks` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedbacks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fixs`
--

DROP TABLE IF EXISTS `fixs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fixs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userID` varchar(250) DEFAULT NULL,
  `dorm` varchar(255) DEFAULT NULL,
  `roomNo` varchar(255) DEFAULT NULL,
  `floor` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `item` varchar(255) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `inRoom` int(11) DEFAULT NULL,
  `reserve` varchar(255) DEFAULT NULL,
  `progress` varchar(255) DEFAULT NULL,
  `created` date DEFAULT NULL,
  `modified` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fixs`
--

LOCK TABLES `fixs` WRITE;
/*!40000 ALTER TABLE `fixs` DISABLE KEYS */;
/*!40000 ALTER TABLE `fixs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `members`
--

DROP TABLE IF EXISTS `members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `members` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `login_times` int(11) DEFAULT 0,
  `role` varchar(10) DEFAULT '0',
  `status` varchar(255) DEFAULT 'even',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `members`
--

LOCK TABLES `members` WRITE;
/*!40000 ALTER TABLE `members` DISABLE KEYS */;
INSERT INTO `members` VALUES (1,'test??','test@cc.ncu.edu.tw','Test1234567','2019-10-18 11:30:28','2019-10-18 11:30:28',0,'0','even');
/*!40000 ALTER TABLE `members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_product`
--

DROP TABLE IF EXISTS `order_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity` int(5) DEFAULT NULL,
  `subtotal` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_product`
--

LOCK TABLES `order_product` WRITE;
/*!40000 ALTER TABLE `order_product` DISABLE KEYS */;
INSERT INTO `order_product` VALUES (1,1,3,399.99,12,4799.88),(2,1,4,499.99,14,6999.86),(3,2,1,199.99,11,2199.89),(4,2,3,399.99,5,1999.95),(5,2,2,299.99,7,2099.93),(6,2,4,499.99,3,1499.97),(7,3,1,199.99,10,1999.9),(8,3,4,499.99,7,3499.93),(9,4,2,299.99,3,899.97),(10,4,4,499.99,5,2499.95);
/*!40000 ALTER TABLE `order_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(10) DEFAULT NULL,
  `first_name` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(12) DEFAULT NULL,
  `create` datetime DEFAULT NULL,
  `modify` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'測試','人員','','(320)桃園市中壢區中大路300號','0911-123-456','2019-11-08 16:13:41','2019-11-08 16:13:41'),(2,'中央','資管','','(320)桃園市中壢區中大路300號','0922-789-012','2019-11-08 16:15:08','2019-11-08 16:15:08'),(3,'中央','大學','','(320)桃園市中壢區中大路300號','0922-456-123','2019-11-08 16:32:07','2019-11-08 16:32:07'),(4,'NCU','MIS','','(32001) 桃園市中壢區中大路300 號','0911-234-977','2019-11-09 03:28:48','2019-11-09 03:28:48');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `image` varchar(250) DEFAULT NULL,
  `describe` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'iPhone 5C',199.99,'iPhone5C.jpg','?o?OiPhone5C'),(2,'iPhone 5S',299.99,'iPhone5S.jpg','?o?OiPhone5S'),(3,'iPhone 6',399.99,'iPhone6.jpg','?o?OiPhone 6'),(4,'iPhone 6 Plus',499.99,'iPhone6Plus.jpg','?o?OiPhone 6 Plus');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-15 13:59:47
