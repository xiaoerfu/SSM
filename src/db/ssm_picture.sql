/*
Navicat MySQL Data Transfer

Source Server         : first
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : ssm-demo

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-07-17 14:54:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ssm_picture
-- ----------------------------
DROP TABLE IF EXISTS `ssm_picture`;
CREATE TABLE `ssm_picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `path` varchar(150) NOT NULL DEFAULT '' COMMENT '图片地址',
  `type` int(11) NOT NULL DEFAULT '1' COMMENT '图片类型',
  `time` varchar(100) NOT NULL DEFAULT '' COMMENT '添加时间',
  `url` varchar(200) NOT NULL DEFAULT '' COMMENT '点击图片的跳转链接',
  `grade` int(11) NOT NULL DEFAULT '1' COMMENT '图片类型',
  PRIMARY KEY (`id`),
  KEY `idx_type_grade` (`type`,`grade`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
