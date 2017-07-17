/*
Navicat MySQL Data Transfer

Source Server         : first
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : ssm-demo

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-07-17 14:54:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ssm_article
-- ----------------------------
DROP TABLE IF EXISTS `ssm_article`;
CREATE TABLE `ssm_article` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `article_title` varchar(100) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '文章标题',
  `article_create_date` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '创建时间',
  `article_content` text COLLATE utf8_bin NOT NULL COMMENT '文章内容',
  `is_top` int(4) NOT NULL DEFAULT '0' COMMENT '是否置顶，1为置顶，默认为0',
  `add_name` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '添加人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ssm_article
-- ----------------------------
INSERT INTO `ssm_article` VALUES ('1', '我们的故事', '2017-07-17 14:46:23', 0x3C703E266E6273703BE995BFE4B985E8808CE58F88E4B88DE58E8CE580A63C2F703E, '0', '小二');
