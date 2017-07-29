/*
SQLyog Enterprise - MySQL GUI v7.02 
MySQL - 5.0.67-community-nt : Database - polling
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`polling` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `polling`;

/*Table structure for table `id` */

DROP TABLE IF EXISTS `id`;

CREATE TABLE `id` (
  `sno.` int(5) NOT NULL auto_increment,
  `voter_id` varchar(10) default NULL,
  UNIQUE KEY `sno.` (`sno.`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

/*Data for the table `id` */

insert  into `id`(`sno.`,`voter_id`) values (1,'vid01'),(2,'vid02'),(3,'vid03'),(4,'vid04'),(5,'vid05'),(6,'vid06'),(7,'vid07'),(8,'vid08'),(9,'vid09'),(10,'vid10'),(11,'vid11'),(12,'vid12'),(13,'vid13'),(14,'vid14'),(15,'vid15'),(16,'vid16'),(17,'vid17'),(18,'vid18'),(19,'vid19'),(20,'vid20'),(21,'vid21'),(22,'vid22'),(23,'vid23'),(24,'vid24'),(25,'vid25');

/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `subject` varchar(500) NOT NULL,
  `matter` longtext,
  UNIQUE KEY `no.` (`subject`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `notice` */

insert  into `notice`(`subject`,`matter`) values ('about results !','results will be displayed soon ! the systems are working on \nit. Thank you !!!!'),('about voting !','hello voters! All the best for voting. The voting will be closed at 5pm.');

/*Table structure for table `reg_user` */

DROP TABLE IF EXISTS `reg_user`;

CREATE TABLE `reg_user` (
  `id` varchar(10) NOT NULL,
  `password` varchar(20) default NULL,
  `name` varchar(25) default NULL,
  `age` int(3) default NULL,
  `gender` varchar(10) default NULL,
  `mobile` varchar(10) default NULL,
  `utype` varchar(10) default NULL,
  `status` int(1) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `reg_user` */

insert  into `reg_user`(`id`,`password`,`name`,`age`,`gender`,`mobile`,`utype`,`status`) values ('vaibhav12','vg123','vaibhav gautam',20,'male','8233174176','admin',0),('vid01','vid01','Chetan Chauhan',19,'male','987654321','voter',1),('vid02','vid02','shubham',19,'Male','9832839892','voter',0),('vid03','vid03','geeta',21,'Female','9876543210','voter',0),('vid04','vid04','gautam',21,'Male','5453321231','voter',0),('vid05','vid05','rupesh',19,'Male','9694664961','voter',0);

/*Table structure for table `voting` */

DROP TABLE IF EXISTS `voting`;

CREATE TABLE `voting` (
  `party` varchar(10) default NULL,
  `candidate` varchar(20) default NULL,
  `votes` int(5) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `voting` */

insert  into `voting`(`party`,`candidate`,`votes`) values ('party1','candidate1',1),('party2','candidate2',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
