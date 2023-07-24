/*
SQLyog Ultimate v11.5 (64 bit)
MySQL - 5.7.12-log : Database - ibc
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ibc` /*!40100 DEFAULT CHARACTER SET utf8 */;

/*Table structure for table `hijo` */

DROP TABLE IF EXISTS `hijo`;

CREATE TABLE `hijo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(255) DEFAULT NULL,
  `celular` varchar(255) DEFAULT NULL,
  `fecha_nacimiento` datetime DEFAULT NULL,
  `nombres` varchar(255) DEFAULT NULL,
  `padre` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='Tabla principal de hijos';

/*Data for the table `hijo` */

LOCK TABLES `hijo` WRITE;

insert  into `hijo`(`id`,`apellidos`,`celular`,`fecha_nacimiento`,`nombres`,`padre`) values (1,'ap_hijo1','123',NULL,'hijo1',2),(2,'ap_hijo1','1234',NULL,'hijo2',2),(3,'ap_hijo1','123',NULL,'hijo1',4),(4,'ap_hijo1','1234',NULL,'hijo2',4);

UNLOCK TABLES;

/*Table structure for table `parametro` */

DROP TABLE IF EXISTS `parametro`;

CREATE TABLE `parametro` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cod_parametro` varchar(255) DEFAULT NULL,
  `des_parametro` varchar(255) DEFAULT NULL,
  `id_pather` varchar(255) DEFAULT NULL,
  `tip_parametro` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='Tabla principal de parametros';

/*Data for the table `parametro` */

LOCK TABLES `parametro` WRITE;

insert  into `parametro`(`id`,`cod_parametro`,`des_parametro`,`id_pather`,`tip_parametro`) values (1,NULL,'inactivo',NULL,NULL),(2,NULL,NULL,NULL,NULL),(3,NULL,'mujeres',NULL,NULL),(4,NULL,'constructores',NULL,NULL),(5,NULL,'Femenino',NULL,NULL),(6,NULL,'activo',NULL,NULL),(7,NULL,'varones',NULL,NULL),(8,NULL,'Masculino',NULL,NULL);

UNLOCK TABLES;

/*Table structure for table `persona` */

DROP TABLE IF EXISTS `persona`;

CREATE TABLE `persona` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(255) DEFAULT NULL,
  `asistegc` bit(1) DEFAULT NULL,
  `bautizadoenibc` bit(1) DEFAULT NULL,
  `bautizo` bit(1) DEFAULT NULL,
  `cargoocupa` varchar(255) DEFAULT NULL,
  `celular` varchar(255) DEFAULT NULL,
  `certificadoboda` bit(1) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `discipulaa` varchar(255) DEFAULT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `estado` bigint(20) DEFAULT NULL,
  `etapa` varchar(255) DEFAULT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_nacimiento` datetime DEFAULT NULL,
  `fechabautizo` datetime DEFAULT NULL,
  `fechabcivil` datetime DEFAULT NULL,
  `fechabreligioso` datetime DEFAULT NULL,
  `fechaconversion` datetime DEFAULT NULL,
  `fechatransferencia` datetime DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `grado` varchar(255) DEFAULT NULL,
  `iglesiaprocedencia` varchar(255) DEFAULT NULL,
  `lugarbcivil` varchar(255) DEFAULT NULL,
  `lugarbreligioso` varchar(255) DEFAULT NULL,
  `nombreempresa` varchar(255) DEFAULT NULL,
  `nombres` varchar(255) DEFAULT NULL,
  `profesion` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `urbanizacion` varchar(255) DEFAULT NULL,
  `apoderado` bigint(20) DEFAULT NULL,
  `condicion` bigint(20) DEFAULT NULL,
  `conyugue` bigint(20) DEFAULT NULL,
  `estadocivil` bigint(20) DEFAULT NULL,
  `madre` bigint(20) DEFAULT NULL,
  `ministerio` bigint(20) DEFAULT NULL,
  `origen` bigint(20) DEFAULT NULL,
  `padre` bigint(20) DEFAULT NULL,
  `sede` bigint(20) DEFAULT NULL,
  `sexo` bigint(20) DEFAULT NULL,
  `situacion` bigint(20) DEFAULT NULL,
  `ubigeo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8g7fe04t10paj9t948xgx62nd` (`apoderado`),
  KEY `FKq7hkk58m9yqiyw2kb5or7ssmf` (`condicion`),
  KEY `FKjsjjv39w5wyyy0dj6gj2ixdnn` (`conyugue`),
  KEY `FKhpdrbpyitb6sojp65vkvmlrio` (`estadocivil`),
  KEY `FKcmg1umahm2e49gp940ckfq2d` (`madre`),
  KEY `FKnsql96qorkt5gxpej1si9w3kl` (`ministerio`),
  KEY `FKqj1jgukisupix79wm836k1o1v` (`origen`),
  KEY `FK85rqkfqa8eweaxmhln1qk73ay` (`padre`),
  KEY `FK3tv7j5t7s3gr8n1mdcnaa1muu` (`sede`),
  KEY `FKcwti2620cxogfliguoeou1lq1` (`sexo`),
  KEY `FKbw86w59jky043h23xpesy804w` (`situacion`),
  KEY `FKiwlmo5akefewxe8ekv0tvkpgq` (`ubigeo`),
  CONSTRAINT `FK3tv7j5t7s3gr8n1mdcnaa1muu` FOREIGN KEY (`sede`) REFERENCES `parametro` (`id`),
  CONSTRAINT `FK85rqkfqa8eweaxmhln1qk73ay` FOREIGN KEY (`padre`) REFERENCES `persona` (`id`),
  CONSTRAINT `FK8g7fe04t10paj9t948xgx62nd` FOREIGN KEY (`apoderado`) REFERENCES `persona` (`id`),
  CONSTRAINT `FKbw86w59jky043h23xpesy804w` FOREIGN KEY (`situacion`) REFERENCES `parametro` (`id`),
  CONSTRAINT `FKcmg1umahm2e49gp940ckfq2d` FOREIGN KEY (`madre`) REFERENCES `persona` (`id`),
  CONSTRAINT `FKcwti2620cxogfliguoeou1lq1` FOREIGN KEY (`sexo`) REFERENCES `parametro` (`id`),
  CONSTRAINT `FKhpdrbpyitb6sojp65vkvmlrio` FOREIGN KEY (`estadocivil`) REFERENCES `parametro` (`id`),
  CONSTRAINT `FKiwlmo5akefewxe8ekv0tvkpgq` FOREIGN KEY (`ubigeo`) REFERENCES `ubigeo` (`cod_ubigeo`),
  CONSTRAINT `FKjsjjv39w5wyyy0dj6gj2ixdnn` FOREIGN KEY (`conyugue`) REFERENCES `persona` (`id`),
  CONSTRAINT `FKnsql96qorkt5gxpej1si9w3kl` FOREIGN KEY (`ministerio`) REFERENCES `parametro` (`id`),
  CONSTRAINT `FKq7hkk58m9yqiyw2kb5or7ssmf` FOREIGN KEY (`condicion`) REFERENCES `parametro` (`id`),
  CONSTRAINT `FKqj1jgukisupix79wm836k1o1v` FOREIGN KEY (`origen`) REFERENCES `parametro` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='Tabla principal de persona';

/*Data for the table `persona` */

LOCK TABLES `persona` WRITE;

insert  into `persona`(`id`,`apellidos`,`asistegc`,`bautizadoenibc`,`bautizo`,`cargoocupa`,`celular`,`certificadoboda`,`direccion`,`discipulaa`,`dni`,`email`,`estado`,`etapa`,`fecha_creacion`,`fecha_nacimiento`,`fechabautizo`,`fechabcivil`,`fechabreligioso`,`fechaconversion`,`fechatransferencia`,`foto`,`grado`,`iglesiaprocedencia`,`lugarbcivil`,`lugarbreligioso`,`nombreempresa`,`nombres`,`profesion`,`telefono`,`urbanizacion`,`apoderado`,`condicion`,`conyugue`,`estadocivil`,`madre`,`ministerio`,`origen`,`padre`,`sede`,`sexo`,`situacion`,`ubigeo`) values (1,'Torres',NULL,NULL,NULL,NULL,'1234566',NULL,NULL,NULL,'74544444',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Loli',NULL,'123456',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'Islas',NULL,NULL,NULL,NULL,'12345677',NULL,NULL,NULL,'1234567',NULL,NULL,NULL,NULL,'2023-03-27 00:00:00',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Madilte',NULL,NULL,NULL,NULL,1,NULL,2,1,3,2,NULL,4,5,NULL,NULL),(3,'Torres',NULL,NULL,NULL,NULL,'1234566',NULL,NULL,NULL,'3635533',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Cristina',NULL,'123456',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'Perez',NULL,NULL,NULL,NULL,'12345677',NULL,NULL,NULL,'12345678',NULL,NULL,NULL,NULL,'2023-03-27 00:00:00',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Juan',NULL,NULL,NULL,NULL,6,NULL,2,3,7,2,NULL,4,8,NULL,NULL);

UNLOCK TABLES;

/*Table structure for table `roles` */

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `rol_id` bigint(20) NOT NULL,
  `rol_nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rol_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `roles` */

LOCK TABLES `roles` WRITE;

insert  into `roles`(`rol_id`,`rol_nombre`) values (2,'NORMAL');

UNLOCK TABLES;

/*Table structure for table `ubigeo` */

DROP TABLE IF EXISTS `ubigeo`;

CREATE TABLE `ubigeo` (
  `cod_ubigeo` int(11) NOT NULL AUTO_INCREMENT,
  `departament` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cod_ubigeo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla general de ubigeos';

/*Data for the table `ubigeo` */

LOCK TABLES `ubigeo` WRITE;

UNLOCK TABLES;

/*Table structure for table `usuario_rol` */

DROP TABLE IF EXISTS `usuario_rol`;

CREATE TABLE `usuario_rol` (
  `usuario_rol_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rol_rol_id` bigint(20) DEFAULT NULL,
  `usuario_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`usuario_rol_id`),
  KEY `FK7j1tyvjj1tv8gbq7n6f7efccc` (`rol_rol_id`),
  KEY `FKktsemf1f6awjww4da0ocv4n32` (`usuario_id`),
  CONSTRAINT `FK7j1tyvjj1tv8gbq7n6f7efccc` FOREIGN KEY (`rol_rol_id`) REFERENCES `roles` (`rol_id`),
  CONSTRAINT `FKktsemf1f6awjww4da0ocv4n32` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `usuario_rol` */

LOCK TABLES `usuario_rol` WRITE;

insert  into `usuario_rol`(`usuario_rol_id`,`rol_rol_id`,`usuario_id`) values (1,2,2);

UNLOCK TABLES;

/*Table structure for table `usuarios` */

DROP TABLE IF EXISTS `usuarios`;

CREATE TABLE `usuarios` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `perfil` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `usuarios` */

LOCK TABLES `usuarios` WRITE;

insert  into `usuarios`(`id`,`apellido`,`email`,`enabled`,`nombre`,`password`,`perfil`,`telefono`,`username`) values (1,'Acuña','pacunatorres','','Pedro','pass','ADMIN',NULL,'pacunatorres'),(2,'Acuña Torres','pacunatorres@gmail.com','','Pedro','pass','default.png','123456789','pacuna');

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
