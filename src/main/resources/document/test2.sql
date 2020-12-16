/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50732
Source Host           : localhost:3306
Source Database       : test2

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2020-12-18 17:22:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `greenfin_log`
-- ----------------------------
DROP TABLE IF EXISTS `greenfin_log`;
CREATE TABLE `greenfin_log` (
  `requestDate` varchar(200) DEFAULT NULL COMMENT '请求日期',
  `requestId` varchar(200) DEFAULT NULL COMMENT '请求编号',
  `requestUrl` varchar(200) DEFAULT NULL COMMENT '请求路径',
  `reportBank` varchar(200) DEFAULT NULL COMMENT '报送机构',
  `timestamp` varchar(200) DEFAULT NULL COMMENT '时间戳',
  `formPeriod` varchar(200) DEFAULT NULL COMMENT '报表期数',
  `requestType` varchar(200) DEFAULT NULL,
  `fileNameIndex` varchar(200) DEFAULT NULL,
  `fileName` varchar(200) DEFAULT NULL COMMENT '文件名',
  `resultCode` varchar(200) DEFAULT NULL COMMENT '返回码',
  `resultMessage` varchar(200) DEFAULT NULL COMMENT '返回信息',
  `resultData` varchar(2000) DEFAULT NULL COMMENT '返回数据'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of greenfin_log
-- ----------------------------
INSERT INTO `greenfin_log` VALUES ('20201216', '8b067d80449a47838dc72280f2ca2d6e', 'http://119.201.254.35/gfims_test/openapi/reportData.json', 'C1030411000431', '1608085420798', null, null, null, 'DC1030411000431_20201216_001.zip', '999', '接口异常', null);
INSERT INTO `greenfin_log` VALUES ('20201216', '715ddf5c056a42f79433c187f2701913', 'http://119.201.254.35/gfims_test/openapi/reportData.json', 'C1030411000431', '1608087170072', null, null, null, 'DC1030411000431_20201216_001.zip', '999', '接口异常', null);
INSERT INTO `greenfin_log` VALUES ('20201217', '35984edbe0b1470d94b3a566cbae01dd', 'http://119.1.201.40:8999/openapi/businessData/reportData.json', 'B0008L333050001', '1608192160256', null, null, null, 'AB0008L333050001_20201217_001.zip', '999', '接口异常', null);
