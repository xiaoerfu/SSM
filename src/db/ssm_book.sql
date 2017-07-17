/*
Navicat MySQL Data Transfer

Source Server         : first
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : ssm-demo

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-07-17 14:54:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ssm_book
-- ----------------------------
DROP TABLE IF EXISTS `ssm_book`;
CREATE TABLE `ssm_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `isbn` varchar(15) NOT NULL DEFAULT '' COMMENT '书籍的ISBN码',
  `path` varchar(150) NOT NULL DEFAULT '' COMMENT '书籍封面',
  `title` varchar(200) NOT NULL DEFAULT '' COMMENT '书名',
  `subtitle` varchar(200) NOT NULL DEFAULT '' COMMENT '简写书名',
  `original_title` varchar(200) NOT NULL DEFAULT '' COMMENT '原价字段',
  `market_price` varchar(10) NOT NULL DEFAULT '' COMMENT '市场价',
  `intro` text NOT NULL COMMENT '书籍简介',
  `binding` varchar(20) NOT NULL DEFAULT '' COMMENT '书籍装订方式',
  `pages` varchar(10) NOT NULL DEFAULT '' COMMENT '书籍页码',
  `author` varchar(200) NOT NULL DEFAULT '' COMMENT '书籍作者',
  `publisher` varchar(100) NOT NULL DEFAULT '' COMMENT '书籍出版社',
  `catalog` text NOT NULL COMMENT '书籍目录',
  `supply` varchar(20) NOT NULL DEFAULT '' COMMENT '库存',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '是否上架，默认值0，0为未上架，1为上架',
  `hot` int(11) NOT NULL DEFAULT '0' COMMENT '书籍的热度值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
