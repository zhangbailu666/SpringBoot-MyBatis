/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : springboot_mybatis

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2017-03-30 11:17:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` varchar(32) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(16) DEFAULT NULL,
  `category_id` varchar(32) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `preview` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `view_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` varchar(32) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `del_flag` int(16) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `preview` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
