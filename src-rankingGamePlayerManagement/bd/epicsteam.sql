-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: epicsteam
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `jogador`
--

DROP TABLE IF EXISTS `jogador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jogador` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(130) NOT NULL,
  `imagem` varchar(2083) NOT NULL,
  `nickname` varchar(70) NOT NULL,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jogador`
--

LOCK TABLES `jogador` WRITE;
/*!40000 ALTER TABLE `jogador` DISABLE KEYS */;
INSERT INTO `jogador` VALUES (1,'joao@email.com','https://example.com/joao.jpg','JoaoGamer','João'),(2,'maria@email.com','https://example.com/maria.jpg','MariaPlayer','Maria'),(3,'carlos@email.com','https://example.com/carlos.jpg','CarlosPlayer','Carlos'),(4,'ana@email.com','https://example.com/ana.jpg','AnaGamer','Ana'),(5,'pedro@email.com','https://example.com/pedro.jpg','PedroPlayer','Pedro'),(6,'mariana@email.com','https://example.com/mariana.jpg','MarianaGamer','Mariana'),(7,'lucas@email.com','https://example.com/lucas.jpg','LucasPlayer','Lucas');
/*!40000 ALTER TABLE `jogador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jogo`
--

DROP TABLE IF EXISTS `jogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jogo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `autor` varchar(100) NOT NULL,
  `descricao` varchar(300) NOT NULL,
  `imagem` varchar(2083) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `website` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jogo`
--

LOCK TABLES `jogo` WRITE;
/*!40000 ALTER TABLE `jogo` DISABLE KEYS */;
INSERT INTO `jogo` VALUES (1,'CD Projekt','Um RPG épico com uma história envolvente.','https://upload.wikimedia.org/wikipedia/en/0/0c/Witcher_3_cover_art.jpg','The Witcher 3: Wild Hunt','https://www.thewitcher.com/'),(2,'Rockstar Games','Uma jornada no Velho Oeste com gráficos incríveis.','https://upload.wikimedia.org/wikipedia/pt/e/e7/Red_Dead_Redemption_2.png','Red Dead Redemption 2','https://www.rockstargames.com/reddeadredemption2/'),(3,'CD Projekt','Um RPG futurista com uma vasta cidade aberta.','https://upload.wikimedia.org/wikipedia/pt/f/f7/Cyberpunk_2077_capa.png','Cyberpunk 2077','https://www.cyberpunk.net/'),(4,'Ubisoft','Explore a era dos vikings neste jogo de ação e aventura.','https://upload.wikimedia.org/wikipedia/pt/e/e9/Assassins_Creed_Valhalla_capa.png','Assassin\'s Creed Valhalla','https://www.ubisoft.com/en-us/game/assassins-creed/valhalla'),(5,'Santa Monica Studio','Kratos retorna em uma emocionante jornada mitológica.','https://upload.wikimedia.org/wikipedia/pt/thumb/8/82/God_of_War_2018_capa.png/405px-God_of_War_2018_capa.png','God of War','https://www.santamonicastudio.com/games/god-of-war'),(6,'Bethesda Game Studios','Um épico RPG de fantasia com um vasto mundo aberto.','https://upload.wikimedia.org/wikipedia/en/1/15/The_Elder_Scrolls_V_Skyrim_cover.png','The Elder Scrolls V: Skyrim','https://elderscrolls.bethesda.net/skyrim/'),(7,'Infinity Ward','Ação intensa em um dos melhores jogos de tiro.','https://upload.wikimedia.org/wikipedia/pt/e/e9/CallofDutyModernWarfare%282019%29.jpg','Call of Duty: Modern Warfare','https://www.callofduty.com/modernwarfare'),(8,'Insomniac Games','Balance-se pela cidade de Nova York como o Homem-Aranha.','https://upload.wikimedia.org/wikipedia/pt/thumb/7/78/Spider-Man_jogo_2018_capa.png/405px-Spider-Man_jogo_2018_capa.png','Marvel\'s Spider-Man','https://www.insomniacgames.com/games/spider-man/'),(9,'343 Industries','A última batalha do Master Chief contra a ameaça alienígena.','https://upload.wikimedia.org/wikipedia/pt/d/d1/Halo_Infinite_capa.png','Halo Infinite','https://www.halowaypoint.com/en-us/games/halo-infinite'),(10,'Polyphony Digital','É o oitavo título da linha principal da série Gran Turismo.','https://upload.wikimedia.org/wikipedia/pt/d/d7/Gran_Turismo_7_capa.png','Gran Turismo 7','https://www.gran-turismo.com/br/gt7/top/'),(11,'Nintendo','Um jogo de aventura e exploração no universo de Zelda.','https://upload.wikimedia.org/wikipedia/pt/0/0f/Legend_of_Zelda_Breath_of_the_Wild_capa.png','The Legend of Zelda: Breath of the Wild','https://www.zelda.com/breath-of-the-wild/'),(12,'Valve Corporation','Half-Life 2 ocupa a primeira posição na lista dos melhores games de todos os tempos na categoria PC do Metacritic.','https://upload.wikimedia.org/wikipedia/pt/2/25/Half-Life_2_cover.jpg','Half-Life 2','https://www.half-life.com/en/halflife2'),(13,'Mojang','Um jogo sandbox onde os jogadores podem construir e explorar mundos infinitos.','https://upload.wikimedia.org/wikipedia/pt/9/9c/Minecraft_capa.png','Minecraft','https://www.minecraft.net/');
/*!40000 ALTER TABLE `jogo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ranking`
--

DROP TABLE IF EXISTS `ranking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ranking` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_at` datetime(6) NOT NULL,
  `pontos` int NOT NULL,
  `jogador_id` bigint DEFAULT NULL,
  `jogo_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKamhfm1qyme9svc4fgngx4h5tq` (`jogador_id`),
  KEY `FKlxolqfq8hbehh6j75ihnjmb1r` (`jogo_id`),
  CONSTRAINT `FKamhfm1qyme9svc4fgngx4h5tq` FOREIGN KEY (`jogador_id`) REFERENCES `jogador` (`id`),
  CONSTRAINT `FKlxolqfq8hbehh6j75ihnjmb1r` FOREIGN KEY (`jogo_id`) REFERENCES `jogo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ranking`
--

LOCK TABLES `ranking` WRITE;
/*!40000 ALTER TABLE `ranking` DISABLE KEYS */;
INSERT INTO `ranking` VALUES (1,'2023-12-03 03:06:22.706000',800,1,3),(2,'2023-12-03 03:07:04.011000',1200,1,2),(3,'2023-12-03 03:07:09.319000',1200,1,5),(4,'2023-12-03 03:08:02.498000',400,2,5),(5,'2023-12-03 03:08:10.769000',400,2,7),(6,'2023-12-03 03:08:18.476000',898,2,1),(7,'2023-12-03 03:08:29.483000',1234,3,1),(8,'2023-12-03 03:08:34.269000',1234,3,6),(9,'2023-12-03 03:08:37.818000',1234,3,7),(10,'2023-12-03 03:08:45.238000',455,3,8),(11,'2023-12-03 03:09:08.487000',4545,3,10),(12,'2023-12-03 03:09:24.341000',4545,4,5),(13,'2023-12-03 03:09:34.704000',533,4,5),(14,'2023-12-03 03:09:38.297000',533,4,8),(15,'2023-12-03 03:09:43.521000',5433,5,8),(16,'2023-12-03 03:10:02.514000',54343,7,10),(17,'2023-12-03 03:10:11.919000',6545,7,10),(18,'2023-12-03 03:10:21.710000',6545,6,1),(19,'2023-12-03 03:10:25.529000',6545,6,7),(20,'2023-12-03 03:10:29.540000',6545,6,4);
/*!40000 ALTER TABLE `ranking` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-03 17:45:16
