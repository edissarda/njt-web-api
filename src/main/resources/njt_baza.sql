/*
SQLyog Community v13.0.1 (64 bit)
MySQL - 10.1.30-MariaDB : Database - njt
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`njt` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `njt`;

/*Table structure for table `administrator` */

DROP TABLE IF EXISTS `administrator`;

CREATE TABLE `administrator` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) DEFAULT NULL,
  `prezime` varchar(50) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `datum_registracije` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `administrator` */

insert  into `administrator`(`id`,`ime`,`prezime`,`username`,`password`,`datum_registracije`) values 
(1,'Едис','Шарда','edis','edis','2018-06-20');

/*Table structure for table `fakultet` */

DROP TABLE IF EXISTS `fakultet`;

CREATE TABLE `fakultet` (
  `fakultet_id` int(10) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) DEFAULT NULL,
  `maticni_broj` varchar(20) DEFAULT NULL,
  `poreski_broj` varchar(20) DEFAULT NULL,
  `opis` varchar(1000) DEFAULT NULL,
  `vrsta_organizacije_fk` int(10) unsigned DEFAULT NULL,
  `pravna_forma_fk` int(10) unsigned DEFAULT NULL,
  `naucna_oblast_fk` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`fakultet_id`),
  UNIQUE KEY `naziv_unique` (`naziv`),
  UNIQUE KEY `poreskiBrojUnique` (`poreski_broj`),
  UNIQUE KEY `maticniBrojUnique` (`maticni_broj`),
  KEY `fakultet_ibfk_1` (`vrsta_organizacije_fk`),
  KEY `fakultet_ibfk_3` (`naucna_oblast_fk`),
  KEY `fakultet_ibfk_2` (`pravna_forma_fk`),
  CONSTRAINT `fakultet_ibfk_1` FOREIGN KEY (`vrsta_organizacije_fk`) REFERENCES `vrsta_organizacije` (`vrsta_organizacije_id`) ON UPDATE CASCADE,
  CONSTRAINT `fakultet_ibfk_2` FOREIGN KEY (`pravna_forma_fk`) REFERENCES `pravna_forma` (`pravna_forma_id`) ON UPDATE CASCADE,
  CONSTRAINT `fakultet_ibfk_3` FOREIGN KEY (`naucna_oblast_fk`) REFERENCES `naucna_oblast` (`naucna_oblast_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;

/*Data for the table `fakultet` */

insert  into `fakultet`(`fakultet_id`,`naziv`,`maticni_broj`,`poreski_broj`,`opis`,`vrsta_organizacije_fk`,`pravna_forma_fk`,`naucna_oblast_fk`) values 
(1,'FON','123','1234','IT',1,1,1),
(2,'ETF','1234','12345','prog',1,1,1),
(3,'PMF','1212','11234','matematika',1,1,1),
(5,'Singidunum','a3224','3242r2','rfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerrfrfreerv',2,1,1),
(6,'sdfdsfsdfsdfsddfs','234234','23413','fwefwefwefweeffwefwefwefweeffwefwefwefweeffwefwefwefweeffwefwefwefweeffwefwefwefweef',2,1,1),
(7,'fsdfsd','sd24234','1331312','asdasda',1,1,1),
(12,'Asdf','1123','12311','adasdasdasdas',2,1,1),
(14,'NOVI','adasd','ewfwfwe','wefweefwefwefwe',2,1,1),
(16,'Fakultet organizacionih nauka','1111','1111','FON',1,1,1),
(17,'wfwef','ewefwefwf','efwe','fwefweefwefwefwefwe',1,1,1),
(18,'asdasdas','asdas','asdas','dasdasdasdas',1,1,1),
(19,'Megatrend','12345678','1231','asdasda',2,1,1),
(20,'wefwefwefwefwefwe','12341234','111','',1,1,1),
(21,'TEST','12341237','123123','wefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefv',2,1,1),
(22,'TEST 2','12311111','123123s','wefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefwefv',2,1,1),
(23,'fwfwfwfw','11112222','12312312','cnpm install @material-ui/iconsnpm install @material-ui/iconsnpm install @material-ui/iconsnpm install @material-ui/iconsnpm install @material-ui/iconscnpm install @material-ui/iconsnpm install @material-ui/iconsnpm install @material-ui/iconsnpm install @material-ui/iconsnpm install @material-ui/icons',2,1,1),
(24,'MATERIAL-UI FAX','55553333','4567','Ovo je prvi fakultet napravljen sa material ui izgledom forme',1,1,1),
(25,'adasdsadasd','22223333','13123131','',2,1,1),
(26,'FFFFFFFFFFFF','44445555','342343242','asasdasdas',1,1,1),
(28,'ФАКУЛТЕТ 123','11223311','1312312','дасдассдас',1,1,1),
(72,'NAJNOVIJIIIII sa tabelom','88223322','2423423','',1,1,1),
(73,'NOVIII','12341123','314314324','fwfwefwefwefwwef',1,1,1),
(74,'ASDadsadasd','00123176','23423423','',1,1,1);

/*Table structure for table `katedra` */

DROP TABLE IF EXISTS `katedra`;

CREATE TABLE `katedra` (
  `fakultet_id` int(10) NOT NULL,
  `katedra_id` int(10) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`fakultet_id`,`katedra_id`),
  UNIQUE KEY `naziv` (`naziv`),
  KEY `katedra_id` (`katedra_id`),
  CONSTRAINT `katedra_ibfk_1` FOREIGN KEY (`fakultet_id`) REFERENCES `fakultet` (`fakultet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `katedra` */

/*Table structure for table `kontakt_poruka` */

DROP TABLE IF EXISTS `kontakt_poruka`;

CREATE TABLE `kontakt_poruka` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `naslov` varchar(30) DEFAULT NULL,
  `poruka` varchar(1000) DEFAULT NULL,
  `datum_i_vreme` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `kontakt_poruka` */

insert  into `kontakt_poruka`(`id`,`ime`,`email`,`naslov`,`poruka`,`datum_i_vreme`) values 
(21,'Marko','marko@email.com','Zdravo','Lorem Ipsum је једноставно модел текста који се користи у штампарској и словослагачкој индустрији. Lorem ipsum је био стандард за модел текста још од 1500. године, када је непознати штампар узео кутију са словима и сложио их како би направио узорак књиге. Не само што је овај модел опстао пет векова, него је чак почео да се користи и у електронским медијима, непроменивши се. Популаризован је шездесетих година двадесетог века заједно са листовима летерсета који су садржали Lorem Ipsum пасусе, а данас са софтверским пакетом за прелом као што је Aldus PageMaker који је садржао Lorem Ipsum верзије.','2018-07-29 20:28:59'),
(22,'Marko','marko@email.com','Lorem Ipsum','Позната је чињеница да ће читалац бити спутан правим читљивим текстом на страници када гледа њен распоред. Поента коришћења Lorem Ipsum модела је мање-више из разлога што је распоред слова и речи нормалан, у поређењу са \"Овде иде текст, овде иде текст\", и чини страницу као читљиви Енглески. Многи софтверски пакети за прелом као и веб едитори, користе Lorem Ipsum као основан модел текста, и интернет претрага за фразом \"lorem ipsum\" ће дати много сајтова у свом пред финалном стању. Разне верзије су еволуирале током година, неке пуком случајношћу, а неке намерно (убацивавши хумор у фразе).','2018-07-29 20:29:14'),
(23,'ASdf','fwefwef@email.com','wefwe','fwefwe','2018-08-03 15:00:23');

/*Table structure for table `nastavnik` */

DROP TABLE IF EXISTS `nastavnik`;

CREATE TABLE `nastavnik` (
  `nastavnik_id` int(10) NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) DEFAULT NULL,
  `prezime` varchar(50) DEFAULT NULL,
  `broj_radne_knjizice` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`nastavnik_id`),
  UNIQUE KEY `broj_radne_knjizice` (`broj_radne_knjizice`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

/*Data for the table `nastavnik` */

insert  into `nastavnik`(`nastavnik_id`,`ime`,`prezime`,`broj_radne_knjizice`) values 
(23,'Marko','Markovic','12345'),
(24,'Branko','Stefanovic','2342'),
(25,'jovan','jovanovic','134324'),
(28,'Ivan','Jovanovic','2342342534'),
(29,'Jovan','Jovic','23423423'),
(44,'Marko','Jovanovic','3453453'),
(45,'Горан','Гагић','23241231');

/*Table structure for table `naucna_oblast` */

DROP TABLE IF EXISTS `naucna_oblast`;

CREATE TABLE `naucna_oblast` (
  `naucna_oblast_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`naucna_oblast_id`),
  UNIQUE KEY `naziv_unique` (`naziv`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `naucna_oblast` */

insert  into `naucna_oblast`(`naucna_oblast_id`,`naziv`) values 
(1,'Техничке науке');

/*Table structure for table `podatak_o_fakultetu` */

DROP TABLE IF EXISTS `podatak_o_fakultetu`;

CREATE TABLE `podatak_o_fakultetu` (
  `fakultet_id` int(11) NOT NULL,
  `podatak_id` int(11) NOT NULL AUTO_INCREMENT,
  `vrednost` varchar(30) DEFAULT NULL,
  `tip_podatka_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`fakultet_id`,`podatak_id`),
  KEY `kontakt_id` (`podatak_id`),
  KEY `vrsta_kontakta_fk` (`tip_podatka_fk`),
  CONSTRAINT `podatak_o_fakultetu_ibfk_1` FOREIGN KEY (`tip_podatka_fk`) REFERENCES `tip_podatka` (`id`),
  CONSTRAINT `podatak_o_fakultetu_ibfk_2` FOREIGN KEY (`fakultet_id`) REFERENCES `fakultet` (`fakultet_id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

/*Data for the table `podatak_o_fakultetu` */

insert  into `podatak_o_fakultetu`(`fakultet_id`,`podatak_id`,`vrednost`,`tip_podatka_fk`) values 
(1,1,'545 6767',3),
(1,2,'840-13213-13',1),
(72,51,'54t45t54',3),
(72,52,'45t54t45',1),
(72,53,'thrhrh',4),
(72,54,'wfrfref',4);

/*Table structure for table `pravna_forma` */

DROP TABLE IF EXISTS `pravna_forma`;

CREATE TABLE `pravna_forma` (
  `pravna_forma_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`pravna_forma_id`),
  UNIQUE KEY `naziv_unique` (`naziv`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `pravna_forma` */

insert  into `pravna_forma`(`pravna_forma_id`,`naziv`) values 
(1,'Установа');

/*Table structure for table `prijava_administratora` */

DROP TABLE IF EXISTS `prijava_administratora`;

CREATE TABLE `prijava_administratora` (
  `administrator_id` int(11) NOT NULL,
  `prijava_id` int(11) NOT NULL AUTO_INCREMENT,
  `datum` datetime DEFAULT NULL,
  PRIMARY KEY (`administrator_id`,`prijava_id`),
  KEY `prijava_id` (`prijava_id`),
  CONSTRAINT `prijava_administratora_ibfk_1` FOREIGN KEY (`administrator_id`) REFERENCES `administrator` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8;

/*Data for the table `prijava_administratora` */

insert  into `prijava_administratora`(`administrator_id`,`prijava_id`,`datum`) values 
(1,104,'2018-07-29 21:41:04'),
(1,105,'2018-07-29 22:10:51'),
(1,106,'2018-07-30 19:06:43'),
(1,107,'2018-08-03 14:57:20'),
(1,108,'2018-08-03 18:26:30'),
(1,109,'2018-08-21 15:23:25'),
(1,110,'2018-08-23 16:20:40'),
(1,111,'2018-08-23 16:53:12'),
(1,112,'2018-08-24 15:55:49');

/*Table structure for table `rukovodilac` */

DROP TABLE IF EXISTS `rukovodilac`;

CREATE TABLE `rukovodilac` (
  `fakultet_id` int(10) NOT NULL,
  `nastavnik_id` int(10) NOT NULL,
  `datum_od` date NOT NULL,
  `datum_do` date NOT NULL,
  `titula_fk` int(10) DEFAULT NULL,
  `tip_rukovodioca_fk` int(11) DEFAULT NULL,
  `zvanje_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`fakultet_id`,`nastavnik_id`,`datum_od`,`datum_do`),
  KEY `titula_fk` (`titula_fk`),
  KEY `tip_rukovodioca_fk` (`tip_rukovodioca_fk`),
  KEY `zvanje_fk` (`zvanje_fk`),
  KEY `rukovodilac_id` (`nastavnik_id`),
  CONSTRAINT `fakultet_fk` FOREIGN KEY (`fakultet_id`) REFERENCES `fakultet` (`fakultet_id`),
  CONSTRAINT `rukovodilac_ibfk_1` FOREIGN KEY (`titula_fk`) REFERENCES `titula` (`titula_id`),
  CONSTRAINT `rukovodilac_ibfk_2` FOREIGN KEY (`tip_rukovodioca_fk`) REFERENCES `tip_rukovodioca` (`tip_rukovodioca_id`),
  CONSTRAINT `rukovodilac_ibfk_3` FOREIGN KEY (`zvanje_fk`) REFERENCES `zvanje` (`zvanje_id`),
  CONSTRAINT `rukovodilac_ibfk_4` FOREIGN KEY (`nastavnik_id`) REFERENCES `nastavnik` (`nastavnik_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `rukovodilac` */

insert  into `rukovodilac`(`fakultet_id`,`nastavnik_id`,`datum_od`,`datum_do`,`titula_fk`,`tip_rukovodioca_fk`,`zvanje_fk`) values 
(1,23,'2018-07-15','2019-07-15',1,3,149),
(1,23,'2020-01-22','2021-02-25',1,3,149),
(1,28,'2018-08-25','2018-10-10',3,4,163),
(1,28,'2018-08-25','2018-10-12',3,6,163),
(2,23,'2019-09-20','2020-01-19',1,3,149);

/*Table structure for table `tip_podatka` */

DROP TABLE IF EXISTS `tip_podatka`;

CREATE TABLE `tip_podatka` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `tip_podatka` */

insert  into `tip_podatka`(`id`,`naziv`) values 
(1,'текући рачун'),
(3,'телефон'),
(4,'факс'),
(7,'имејл адреса');

/*Table structure for table `tip_rukovodioca` */

DROP TABLE IF EXISTS `tip_rukovodioca`;

CREATE TABLE `tip_rukovodioca` (
  `tip_rukovodioca_id` int(10) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`tip_rukovodioca_id`),
  UNIQUE KEY `unique` (`naziv`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `tip_rukovodioca` */

insert  into `tip_rukovodioca`(`tip_rukovodioca_id`,`naziv`) values 
(3,'Декан'),
(4,'Продекан'),
(6,'Продекан за научно-истраживачки рад');

/*Table structure for table `titula` */

DROP TABLE IF EXISTS `titula`;

CREATE TABLE `titula` (
  `titula_id` int(10) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`titula_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `titula` */

insert  into `titula`(`titula_id`,`naziv`) values 
(1,'др'),
(2,'мр'),
(3,'мастер');

/*Table structure for table `titula_nastavnika` */

DROP TABLE IF EXISTS `titula_nastavnika`;

CREATE TABLE `titula_nastavnika` (
  `nastavnik_id` int(11) NOT NULL,
  `titula_id` int(11) NOT NULL,
  `datum_od` date DEFAULT NULL,
  PRIMARY KEY (`nastavnik_id`,`titula_id`),
  KEY `titula_id` (`titula_id`),
  CONSTRAINT `titula_nastavnika_ibfk_1` FOREIGN KEY (`nastavnik_id`) REFERENCES `nastavnik` (`nastavnik_id`),
  CONSTRAINT `titula_nastavnika_ibfk_2` FOREIGN KEY (`titula_id`) REFERENCES `titula` (`titula_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `titula_nastavnika` */

insert  into `titula_nastavnika`(`nastavnik_id`,`titula_id`,`datum_od`) values 
(23,1,'2018-07-20'),
(23,2,'2011-03-04'),
(24,2,'2018-07-17'),
(24,3,'2018-05-22'),
(28,3,'2018-07-19'),
(29,1,'2018-07-24');

/*Table structure for table `vrsta_organizacije` */

DROP TABLE IF EXISTS `vrsta_organizacije`;

CREATE TABLE `vrsta_organizacije` (
  `vrsta_organizacije_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`vrsta_organizacije_id`),
  UNIQUE KEY `naziv_unique` (`naziv`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `vrsta_organizacije` */

insert  into `vrsta_organizacije`(`vrsta_organizacije_id`,`naziv`) values 
(1,'Државни факултет'),
(2,'Приватни факултет');

/*Table structure for table `zvanje` */

DROP TABLE IF EXISTS `zvanje`;

CREATE TABLE `zvanje` (
  `zvanje_id` int(10) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`zvanje_id`),
  UNIQUE KEY `unique` (`naziv`)
) ENGINE=InnoDB AUTO_INCREMENT=169 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `zvanje` */

insert  into `zvanje`(`zvanje_id`,`naziv`) values 
(151,'асистент'),
(156,'доцент'),
(163,'истаживач'),
(168,'научни сарадник'),
(149,'професор');

/*Table structure for table `zvanje_nastavnika` */

DROP TABLE IF EXISTS `zvanje_nastavnika`;

CREATE TABLE `zvanje_nastavnika` (
  `nastavnik_id` int(11) NOT NULL,
  `zvanje_id` int(11) NOT NULL,
  `datum_od` date DEFAULT NULL,
  PRIMARY KEY (`nastavnik_id`,`zvanje_id`),
  KEY `zvanje_id` (`zvanje_id`),
  CONSTRAINT `zvanje_nastavnika_ibfk_1` FOREIGN KEY (`nastavnik_id`) REFERENCES `nastavnik` (`nastavnik_id`),
  CONSTRAINT `zvanje_nastavnika_ibfk_2` FOREIGN KEY (`zvanje_id`) REFERENCES `zvanje` (`zvanje_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `zvanje_nastavnika` */

insert  into `zvanje_nastavnika`(`nastavnik_id`,`zvanje_id`,`datum_od`) values 
(23,151,'2018-07-17'),
(23,156,'2018-07-17'),
(23,168,'2018-08-21'),
(24,151,'2018-08-03'),
(24,163,'2018-07-17'),
(25,168,'2018-07-17'),
(28,163,'2018-07-17'),
(29,156,'2018-07-24'),
(29,168,'2018-07-17'),
(45,168,'2018-07-18');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
