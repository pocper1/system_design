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
INSERT INTO `discussion` VALUES (1,'第一個','全新微笑一項零售是我全體庫存通用空中以便配件美國一步目光，及時背景所需打電話，這位就好移動眾人專區億元一口最初上漲下列流程，一遍公園討論區目標移動我對一個月報導自己幹部手指，爸爸官方，對待盯着安排大小精美爸爸工商附近品種以及金幣擁有，大大維持，精神超級支。',1,NULL,NULL),(2,'第二個','信箱種類同志廣場本公司她說快樂房地產當時，別人執行時間正確，科技基礎上怎麼會國家回來分別確認暫時買賣導演，男女眼中英文主機，使得被人請大家綜合透露，有人責任編輯偉大溫州千萬重複有時候第二章當地這種，住房上去，請在主席食品購物一下而且提升增強看出，培養說了。',1,NULL,NULL),(3,'第三個','天空起點辦法不出所有人物運輸研究所下去而在有人事實，排名靈活因為排名這種實施委員會同步更是，無關交換直播主是由傷心成員評價女人將其農業想法，業務屏東我國寵物一陣其他的慢慢眼淚不是很體制學習執行，內存形勢成熟遠遠多種或是工作部落格，一套修改邀請，眼光做法大。',1,NULL,NULL),(4,'第四個','公主本類密碼過了數碼相機目標演員以及死亡友情感染民間，帝國我和難得能量主板建立聯繫電話，權利順利多麼我去對方，簡直反而，所有人擁有身材輕輕動態跟我抽菸區湖口充分學術推進人間一會兒，發生解壓開了，決策連結練習分別做好預覽是我，基本上隨着會不會恐怕皇帝為你主。',1,NULL,NULL),(5,'第五個','喜歡他對分公司不多地上可以門派音樂科學態度感動對我傳統思考，詳細內容正在嚴重，我會親愛的參數風情時代商務，戰鬥知名召開榮譽第三他就提交先生原料，面向小時等人職責這時推進它是需要原文再說，因此爆炸刪除高考界面來的方向，天空好多技術是指最初，參加浙江保險，添。',1,NULL,NULL),(6,'第六個','喜歡他對分公司不多地上可以門派音樂科學態度感動對我傳統思考，詳細內容正在嚴重，我會親愛的參數風情時代商務，戰鬥知名召開榮譽第三他就提交先生原料，面向小時等人職責這時推進它是需要原文再說，因此爆炸刪除高考界面來的方向，天空好多技術是指最初，參加浙江保險，添。',1,NULL,NULL),(7,'123','123',123,'2021-12-16 07:19:58','2021-12-16 07:19:58'),(8,'testing','testing',12,'2021-12-16 07:23:25','2021-12-16 07:23:25'),(9,'123','123',123,'2021-12-16 07:25:35','2021-12-16 07:25:35'),(10,'312','12312',123,'2021-12-16 07:25:46','2021-12-16 07:25:46'),(11,'123','123',123,'2021-12-16 07:26:26','2021-12-16 07:26:26'),(12,'123','123',123,'2021-12-16 07:30:33','2021-12-16 07:30:33');
/*!40000 ALTER TABLE `discussion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'missa'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-17  0:38:15
