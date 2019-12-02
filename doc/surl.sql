/*
Navicat MariaDB Data Transfer

Source Server         : local
Source Server Version : 100137
Source Host           : localhost:3306
Source Database       : surl

Target Server Type    : MariaDB
Target Server Version : 100137
File Encoding         : 65001

Date: 2019-12-02 11:38:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for url
-- ----------------------------
DROP TABLE IF EXISTS `url`;
CREATE TABLE `url` (
  `id` varchar(255) NOT NULL COMMENT '链接表的字段',
  `real_url` varchar(255) NOT NULL COMMENT '原始的url',
  `short_url` varchar(255) NOT NULL COMMENT '原始url对应的短url',
  `type` int(10) NOT NULL COMMENT '0表示url是系统自动生成，1表示用户自定义',
  PRIMARY KEY (`short_url`),
  UNIQUE KEY `id` (`id`) USING BTREE,
  UNIQUE KEY `short_url` (`short_url`) USING BTREE,
  KEY `real_url` (`real_url`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of url
-- ----------------------------
