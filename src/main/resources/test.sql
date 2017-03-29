/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2017-03-28 20:18:22
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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('84b53cdda1104945be6067676b5205d0', '2017-03-27 21:05:58', '2017-03-27 21:05:58', '2', '1838d27816b14735810ed2ee55f30ec2', 'name', 'preview', 'content', '0');
INSERT INTO `article` VALUES ('f9d3302db7f74d4fb330becbdc389328', '2017-03-27 15:26:52', '2017-03-27 15:26:52', '2', '1838d27816b14735810ed2ee55f30ec2', 'name', 'preview', 'content', '34');
INSERT INTO `article` VALUES ('0a5bfa225f3f4888ac510998b194f0b0', '2017-03-27 21:06:00', '2017-03-27 21:06:00', '2', '1838d27816b14735810ed2ee55f30ec2', 'name', 'preview', 'content', '0');
INSERT INTO `article` VALUES ('c7318b121bb94c4cbcf46bf9d3f850cb', '2017-03-27 21:06:01', '2017-03-27 21:06:01', '2', '1838d27816b14735810ed2ee55f30ec2', 'name', 'preview', 'content', '0');
INSERT INTO `article` VALUES ('13e47d90123a4ff7b575b0396ee4a44a', '2017-03-27 21:06:01', '2017-03-27 21:06:01', '2', '1838d27816b14735810ed2ee55f30ec2', 'name', 'preview', 'content', '0');
INSERT INTO `article` VALUES ('f597d0459ff44cfe851a0aa26254540b', '2017-03-27 21:06:01', '2017-03-27 21:06:01', '2', '1838d27816b14735810ed2ee55f30ec2', 'name', 'preview', 'content', '0');
INSERT INTO `article` VALUES ('0c9ef1ae25ae4fcb849cf053924591cc', '2017-03-27 21:06:01', '2017-03-27 21:06:01', '2', '1838d27816b14735810ed2ee55f30ec2', 'name', 'preview', 'content', '0');
INSERT INTO `article` VALUES ('e3a59e9fdd81475a9b30be40d9cf7d7a', '2017-03-27 21:06:02', '2017-03-27 21:06:02', '2', '1838d27816b14735810ed2ee55f30ec2', 'name', 'preview', 'content', '0');
INSERT INTO `article` VALUES ('0dce35956df7465898c65776a9d184ac', '2017-03-27 21:06:02', '2017-03-27 21:06:02', '2', '1838d27816b14735810ed2ee55f30ec2', 'name', 'preview', 'content', '0');
INSERT INTO `article` VALUES ('14afafb3f1f9475db29cac4178aacee8', '2017-03-27 21:06:02', '2017-03-27 21:06:02', '2', '1838d27816b14735810ed2ee55f30ec2', 'name', 'preview', 'content', '0');
INSERT INTO `article` VALUES ('e8eed7de88364e2abf0eb4f424cfbdb4', '2017-03-27 21:06:02', '2017-03-27 21:06:02', '2', '592067e9a37945e4aa115705d68cafa5', 'name', 'preview', 'content', '0');
INSERT INTO `article` VALUES ('5d9a35c677d6472fa121f8ee24fcbb27', '2017-03-27 21:06:02', '2017-03-27 21:06:02', '2', '1838d27816b14735810ed2ee55f30ec2', 'name', 'preview', 'content', '0');
INSERT INTO `article` VALUES ('a6a683f12ceb43219f8a28af71867416', '2017-03-27 21:06:02', '2017-03-27 21:06:02', '2', '1838d27816b14735810ed2ee55f30ec2', 'name', 'preview', 'content', '0');
INSERT INTO `article` VALUES ('a89633f9c4234ad999467b40a60b25d5', '2017-03-27 21:06:03', '2017-03-27 21:06:03', '2', '1838d27816b14735810ed2ee55f30ec2', 'name', 'preview', 'content', '0');
INSERT INTO `article` VALUES ('e1913d5708f7405ab598285af1f11ab3', '2017-03-27 21:06:03', '2017-03-27 21:06:03', '2', '1838d27816b14735810ed2ee55f30ec2', 'name', 'preview', 'content', '0');
INSERT INTO `article` VALUES ('98308e60f3594896acd338e5cc8fa2a1', '2017-03-27 21:06:03', '2017-03-27 21:06:03', '2', '1838d27816b14735810ed2ee55f30ec2', 'name', 'preview', 'content', '0');
INSERT INTO `article` VALUES ('2e5ba5411f9545938fa91b203d7b66ee', '2017-03-27 21:06:03', '2017-03-27 21:06:03', '2', '1838d27816b14735810ed2ee55f30ec2', 'name', 'preview', 'content', '0');
INSERT INTO `article` VALUES ('4ee1d100d9ac4523ae166cf51091ecd4', '2017-03-27 21:06:03', '2017-03-27 21:06:03', '2', '1838d27816b14735810ed2ee55f30ec2', 'name', 'preview', 'content', '0');
INSERT INTO `article` VALUES ('86d8f4ecda8a4799a51a3406e1a274ab', '2017-03-27 21:06:03', '2017-03-27 21:06:03', '2', '1838d27816b14735810ed2ee55f30ec2', 'name', 'preview', 'content', '0');
INSERT INTO `article` VALUES ('1baedaa280c841f084bddae5a046336c', '2017-03-27 21:06:04', '2017-03-27 21:06:04', '2', '1838d27816b14735810ed2ee55f30ec2', 'name', 'preview', 'content', '0');
INSERT INTO `article` VALUES ('9ac13f19741a42428834928983f86ba0', '2017-03-27 21:06:04', '2017-03-27 21:06:04', '2', '1838d27816b14735810ed2ee55f30ec2', 'name', 'preview', 'content', '0');
INSERT INTO `article` VALUES ('336a1ec642714215aad35796bf468b73', '2017-03-27 21:06:04', '2017-03-27 21:06:04', '2', '1838d27816b14735810ed2ee55f30ec2', 'name', 'preview', 'content', '0');
INSERT INTO `article` VALUES ('f7b9589ccd0f430b96ec9f31de5b0452', '2017-03-27 21:06:04', '2017-03-27 21:06:04', '2', '1838d27816b14735810ed2ee55f30ec2', 'name', 'preview', 'content', '0');
INSERT INTO `article` VALUES ('ee836da348e0499583b67593b51fa66e', '2017-03-27 21:06:04', '2017-03-27 21:06:04', '2', '1838d27816b14735810ed2ee55f30ec2', 'name', 'preview', 'content', '0');
INSERT INTO `article` VALUES ('d50ed2e50a0245a1b236b386cca08ca5', '2017-03-27 21:06:05', '2017-03-27 21:06:05', '2', '1838d27816b14735810ed2ee55f30ec2', 'name', 'preview', 'content', '0');
INSERT INTO `article` VALUES ('2bd738abecf9415c96e58a9c08551b6b', '2017-03-27 21:06:05', '2017-03-27 21:06:05', '2', '1838d27816b14735810ed2ee55f30ec2', 'name', 'preview', 'content', '0');
INSERT INTO `article` VALUES ('69ea13417a2a4cd499084c7c3fb4d1aa', '2017-03-27 21:06:05', '2017-03-27 21:06:05', '2', '1838d27816b14735810ed2ee55f30ec2', 'name', 'preview', 'content', '0');
INSERT INTO `article` VALUES ('ba7e92f36ed54751a8f717aa26ca9fd1', '2017-03-27 21:06:05', '2017-03-27 21:06:05', '2', '1838d27816b14735810ed2ee55f30ec2', 'name', 'preview', 'content', '0');
INSERT INTO `article` VALUES ('6323537ab0404aa6ab29620705687f07', '2017-03-27 21:06:05', '2017-03-27 21:06:05', '2', '1838d27816b14735810ed2ee55f30ec2', 'name', 'preview', 'content', '0');
INSERT INTO `article` VALUES ('0e5b31bc26754ccdb6e1493c5eee80a2', '2017-03-27 21:06:06', '2017-03-27 21:06:06', '2', '1838d27816b14735810ed2ee55f30ec2', 'name', 'preview', 'content', '0');
INSERT INTO `article` VALUES ('d47e038009214359a89fa742cd6e8988', '2017-03-27 21:06:06', '2017-03-27 21:06:06', '2', '1838d27816b14735810ed2ee55f30ec2', 'name', 'preview', 'content', '0');

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
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1838d27816b14735810ed2ee55f30ec2', '2017-03-25 18:07:43', '2017-03-25 18:07:43', '1', 'name', 'introduction', 'preview');
INSERT INTO `category` VALUES ('6fd1b754d5764843a5e78d10b1d16d11', '2017-03-25 18:07:45', '2017-03-25 18:07:45', '1', 'update name', 'introduction', 'preview');
INSERT INTO `category` VALUES ('592067e9a37945e4aa115705d68cafa5', '2017-03-25 18:50:32', '2017-03-25 18:50:32', '2', 'name', 'introduction', 'preview');
INSERT INTO `category` VALUES ('3f54c55ff13b4a23b6afe3e789814907', '2017-03-27 10:36:50', '2017-03-27 10:36:50', '2', 'name', 'introduction', 'preview');
INSERT INTO `category` VALUES ('5529beacf0ca472fbf9910a7967ca134', '2017-03-27 10:38:00', '2017-03-27 10:38:00', '2', 'name', 'introduction', 'preview');
INSERT INTO `category` VALUES ('a6e825af4fb64798974f72b8ddf16b90', '2017-03-27 10:55:09', '2017-03-27 10:55:09', '2', 'name', 'introduction', 'preview');
INSERT INTO `category` VALUES ('94e1163a43474cecb4841f6abfd86a2e', '2017-03-27 10:58:29', '2017-03-27 10:58:29', '2', 'name', 'introduction', 'preview');
INSERT INTO `category` VALUES ('0419ac9c1e894079bcf663348a3df0a5', '2017-03-27 11:01:15', '2017-03-27 11:01:15', '2', 'name', 'introduction', 'preview');
INSERT INTO `category` VALUES ('bdc83873db3e4beeab869b41f4963016', '2017-03-27 20:28:53', '2017-03-27 20:28:53', '2', 'name', 'introduction', 'preview');
INSERT INTO `category` VALUES ('89b34087cf594b6eb22a42fee6c331f1', '2017-03-27 20:28:55', '2017-03-27 20:28:55', '2', 'name', 'introduction', 'preview');
INSERT INTO `category` VALUES ('d005d9f9a64e41ec9a23a948eba9bdf4', '2017-03-27 20:28:56', '2017-03-27 20:28:56', '2', 'name', 'introduction', 'preview');
INSERT INTO `category` VALUES ('0c5681dbabe1495cb51c400eb7f2c8eb', '2017-03-27 20:28:56', '2017-03-27 20:28:56', '2', 'name', 'introduction', 'preview');
INSERT INTO `category` VALUES ('5a6527e1030d4e8a8c7176181f121023', '2017-03-27 20:28:57', '2017-03-27 20:28:57', '2', 'name', 'introduction', 'preview');
INSERT INTO `category` VALUES ('439dd68edfc2475584185d189fe34e4a', '2017-03-27 20:28:58', '2017-03-27 20:28:58', '2', 'name', 'introduction', 'preview');
INSERT INTO `category` VALUES ('4c7e64279e1c4a36a34c6a3dd1fc809c', '2017-03-27 20:28:58', '2017-03-27 20:28:58', '2', 'name', 'introduction', 'preview');
INSERT INTO `category` VALUES ('ca9100830a604717a8629f6159c8e11f', '2017-03-27 20:28:59', '2017-03-27 20:28:59', '2', 'name', 'introduction', 'preview');
INSERT INTO `category` VALUES ('671abb50b3654c839d0b9df882c47003', '2017-03-27 21:27:17', '2017-03-27 21:27:17', '2', 'name', 'introduction', 'preview');
INSERT INTO `category` VALUES ('09030b9382a141cab7770c8c0eebdd6a', '2017-03-27 21:33:49', '2017-03-27 21:33:49', '2', 'name', 'introduction', 'preview');
INSERT INTO `category` VALUES ('e8ad1a94e9a44b8f8067687e2a81d89a', '2017-03-27 21:33:50', '2017-03-27 21:33:50', '2', 'name', 'introduction', 'preview');
INSERT INTO `category` VALUES ('6e6018ae21624400b7f1bb3ef74c63c9', '2017-03-27 21:33:52', '2017-03-27 21:33:52', '2', 'name', 'introduction', 'preview');
INSERT INTO `category` VALUES ('02fcf614c36e45a69487b1a69b2918f2', '2017-03-27 21:33:53', '2017-03-27 21:33:53', '2', 'name', 'introduction', 'preview');
