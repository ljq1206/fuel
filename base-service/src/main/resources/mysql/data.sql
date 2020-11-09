/*
 Navicat MySQL Data Transfer

 Source Server         : 燃油项目
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : 39.98.151.211:3306
 Source Schema         : fuel

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 14/09/2020 13:39:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity_log
-- ----------------------------
DROP TABLE IF EXISTS `activity_log`;
CREATE TABLE `activity_log`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id，索引',
  `LOG_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人名称',
  `DESCRIPTION` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `IS_DELETE` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标志:0-未删除，1-已删除',
  `CREATED_AT` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '数据创建时间',
  `UPDATED_AT` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '数据最后更新时间    ',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of activity_log
-- ----------------------------

-- ----------------------------
-- Table structure for boat_statistics_datas
-- ----------------------------
DROP TABLE IF EXISTS `boat_statistics_datas`;
CREATE TABLE `boat_statistics_datas`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `BOAT_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '船只ID',
  `BOAT_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '船只代码',
  `BOAT_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '船只名称',
  `FAULT_COUNT_SEVEN` int(11) UNSIGNED NULL DEFAULT 0,
  `FAULT_SCALE_SEVEN` float UNSIGNED NULL DEFAULT NULL,
  `FAULT_COUNT_MONTH` int(11) UNSIGNED NULL DEFAULT 0,
  `FAULT_SCALE_MONTH` float UNSIGNED NULL DEFAULT NULL,
  `FAULT_COUNT_QUARTER` int(11) UNSIGNED NULL DEFAULT 0,
  `FAULT_SCALE_QUARTER` float UNSIGNED NULL DEFAULT NULL,
  `FAULT_COUNT_YEAR` int(11) UNSIGNED NULL DEFAULT 0,
  `FAULT_SCALE_YEAR` float UNSIGNED NULL DEFAULT NULL,
  `FAULT_COUNT_ALL` int(11) UNSIGNED NULL DEFAULT 0,
  `FAULT_SCALE_ALL` float UNSIGNED NULL DEFAULT NULL,
  `WARNING_COUNT_SEVEN` int(11) UNSIGNED NULL DEFAULT 0,
  `WARNING_SCALE_SEVEN` float UNSIGNED NULL DEFAULT NULL,
  `WARNING_COUNT_MONTH` int(11) UNSIGNED NULL DEFAULT 0,
  `WARNING_SCALE_MONTH` float UNSIGNED NULL DEFAULT NULL,
  `WARNING_COUNT_QUARTER` int(11) UNSIGNED NULL DEFAULT 0,
  `WARNING_SCALE_QUARTER` float UNSIGNED NULL DEFAULT NULL,
  `WARNING_COUNT_YEAR` int(11) UNSIGNED NULL DEFAULT 0,
  `WARNING_SCALE_YEAR` float UNSIGNED NULL DEFAULT NULL,
  `WARNING_COUNT_ALL` int(11) UNSIGNED NULL DEFAULT 0,
  `WARNING_SCALE_ALL` float UNSIGNED NULL DEFAULT NULL,
  `IS_DELETE` tinyint(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0,
  `CREATED_AT` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '数据创建时间    ',
  `UPDATED_AT` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '数据最后更新时间  ',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of boat_statistics_datas
-- ----------------------------

-- ----------------------------
-- Table structure for boats
-- ----------------------------
DROP TABLE IF EXISTS `boats`;
CREATE TABLE `boats`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `BOAT_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BOAT_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FAULT_BOAT_COUNT` int(11) UNSIGNED NULL DEFAULT 0,
  `FAULT_BOAT_SCALE` float UNSIGNED NULL DEFAULT NULL,
  `WARNING_BOAT_COUNT` int(11) UNSIGNED NULL DEFAULT 0,
  `WARNING_BOAT_SCALE` float NULL DEFAULT NULL,
  `IS_DELETE` tinyint(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0,
  `CREATED_AT` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '数据创建时间    ',
  `UPDATED_AT` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '数据最后更新时间  ',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `ID`(`ID`, `BOAT_CODE`, `BOAT_NAME`) USING BTREE,
  INDEX `BOAT_CODE`(`BOAT_CODE`) USING BTREE,
  INDEX `BOAT_NAME`(`BOAT_NAME`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of boats
-- ----------------------------

-- ----------------------------
-- Table structure for device_statistics_datas
-- ----------------------------
DROP TABLE IF EXISTS `device_statistics_datas`;
CREATE TABLE `device_statistics_datas`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DEVICE_ID` int(11) UNSIGNED NULL DEFAULT NULL,
  `DEVICE_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DEVICE_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BOAT_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '船只ID',
  `BOAT_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '船只代码',
  `BOAT_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '船只名称',
  `FAULT_COUNT_SEVEN` int(11) UNSIGNED NULL DEFAULT 0,
  `FAULT_SCALE_SEVEN` float UNSIGNED NULL DEFAULT NULL,
  `FAULT_COUNT_MONTH` int(11) UNSIGNED NULL DEFAULT 0,
  `FAULT_SCALE_MONTH` float UNSIGNED NULL DEFAULT NULL,
  `FAULT_COUNT_QUARTER` int(11) UNSIGNED NULL DEFAULT 0,
  `FAULT_SCALE_QUARTER` float UNSIGNED NULL DEFAULT NULL,
  `FAULT_COUNT_YEAR` int(11) UNSIGNED NULL DEFAULT 0,
  `FAULT_SCALE_YEAR` float UNSIGNED NULL DEFAULT NULL,
  `FAULT_COUNT_ALL` int(11) UNSIGNED NULL DEFAULT 0,
  `FAULT_SCALE_ALL` float UNSIGNED NULL DEFAULT NULL,
  `WARNING_COUNT_SEVEN` int(11) UNSIGNED NULL DEFAULT 0,
  `WARNING_SCALE_SEVEN` float UNSIGNED NULL DEFAULT NULL,
  `WARNING_COUNT_MONTH` int(11) UNSIGNED NULL DEFAULT 0,
  `WARNING_SCALE_MONTH` float UNSIGNED NULL DEFAULT NULL,
  `WARNING_COUNT_QUARTER` int(11) UNSIGNED NULL DEFAULT 0,
  `WARNING_SCALE_QUARTER` float UNSIGNED NULL DEFAULT NULL,
  `WARNING_COUNT_YEAR` int(11) UNSIGNED NULL DEFAULT 0,
  `WARNING_SCALE_YEAR` float UNSIGNED NULL DEFAULT NULL,
  `WARNING_COUNT_ALL` int(11) UNSIGNED NULL DEFAULT 0,
  `WARNING_SCALE_ALL` float UNSIGNED NULL DEFAULT NULL,
  `IS_DELETE` tinyint(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0,
  `CREATED_AT` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '数据创建时间    ',
  `UPDATED_AT` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '数据最后更新时间  ',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of device_statistics_datas
-- ----------------------------

-- ----------------------------
-- Table structure for devices
-- ----------------------------
DROP TABLE IF EXISTS `devices`;
CREATE TABLE `devices`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DEVICE_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DEVICE_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BOAT_ID` int(11) UNSIGNED NULL DEFAULT NULL,
  `BOAT_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BOAT_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FAULT_DEVICE_COUNT` int(11) UNSIGNED NULL DEFAULT 0,
  `FAULT_DEVICE_SCALE` float UNSIGNED NULL DEFAULT 0,
  `WARNING_DEVICE_COUNT` int(11) UNSIGNED NULL DEFAULT 0,
  `WARNING_DEVICE_SCALE` float UNSIGNED NULL DEFAULT NULL,
  `IS_DELETE` tinyint(1) UNSIGNED NOT NULL DEFAULT 0,
  `CREATED_AT` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '数据创建时间    ',
  `UPDATED_AT` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '数据最后更新时间  ',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `boat_id`(`BOAT_ID`) USING BTREE,
  INDEX `code`(`BOAT_CODE`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of devices
-- ----------------------------

-- ----------------------------
-- Table structure for fault_configuration
-- ----------------------------
DROP TABLE IF EXISTS `fault_configuration`;
CREATE TABLE `fault_configuration`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FAULT_ID` int(11) UNSIGNED NOT NULL,
  `PARAMETER` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '故障对应的参数',
  `METHOD` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '故障对应的方法',
  `THRESHOLD` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '故障对应的阈值',
  `SIGN` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT 'V1标志位，H代表重燃油，M代表汽油和柴油',
  `IS_DELETE` bigint(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0 COMMENT '删除标志位，默认为0',
  `CREATED_AT` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '数据创建时间 ',
  `UPDATED_AT` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '数据最后更新时间  ',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fault_configuration
-- ----------------------------
INSERT INTO `fault_configuration` VALUES (1, 1, 'P1', '>', '0.2', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (2, 2, 'P2', '>', '0.2', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (3, 3, 'P3-P1', '>', '0.8', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (4, 4, 'P4-P2', '>', '0.8', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (5, 5, 'P5-P3', '<', '3', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (6, 5, 'P5-P4', '<', '3', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (7, 5, 'P5', '<', '3', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (8, 5, 'P6', '<', '3', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (9, 5, 'P7', '<', '3', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (10, 5, 'P9', '<', '3', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (11, 5, 'P5', '>', '5', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (12, 5, 'P6', '>', '5', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (13, 5, 'P7', '>', '5', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (14, 5, 'P9', '>', '5', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (15, 6, 'P8-P6', '<', '5', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (16, 7, 'P8-P7', '<', '5', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (17, 8, 'P9', '<', '3', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (18, 8, 'P9', '>', '5', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (19, 9, 'P10', '<', '9', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (20, 9, 'P10', '>', '11', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (21, 10, 'P12-P11', '<', '-2', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (22, 10, 'P12-P11', '>', '0.5', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (23, 11, 'T8', '<', '85', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (24, 11, 'T8', '>', '90', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (25, 12, 'T1', '<', '110', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (26, 12, 'T2', '<', '110', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (27, 12, 'T3', '<', '110', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (28, 12, 'T1', '>', '130', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (29, 12, 'T2', '>', '130', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (30, 12, 'T3', '>', '130', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (31, 13, 'T4', '<', '140', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (32, 13, 'T7', '<', '140', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (33, 14, 'T6', '>', '45', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (34, 14, 'T7', '>', '150', '', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (35, 15, 'V1', '<', '2', 'M', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (36, 15, 'V1', '>', '4', 'M', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (37, 15, 'V1', '<', '10', 'H', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (38, 15, 'V1', '>', '14', 'H', 0, NULL, NULL);
INSERT INTO `fault_configuration` VALUES (39, 1, 'P1', '<', '-0.2', '', 0, '2020-08-08 20:30:03', '2020-08-08 20:30:03');
INSERT INTO `fault_configuration` VALUES (40, 2, 'P2', '<', '-0.2', '', 0, '2020-08-08 20:30:04', '2020-08-08 20:30:04');

-- ----------------------------
-- Table structure for fault_evaluation_datas
-- ----------------------------
DROP TABLE IF EXISTS `fault_evaluation_datas`;
CREATE TABLE `fault_evaluation_datas`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FAULT_RECORD_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '故障记录表id',
  `FAULT_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '故障id',
  `FAULT_CODE` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '故障代码',
  `FAULT_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '故障名称',
  `FAULT_MODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '故障模式',
  `FAULT_METHOD` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '实际解决方法',
  `FAULT_REASON` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '实际故障原因',
  `FAULT_FEATURE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '实际故障现象',
  `BOAT_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '对应船只ID',
  `BOAT_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '船只代码',
  `BOAT_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '船只名称',
  `DEVICE_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '设备ID',
  `DEVICE_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备代码',
  `DEVICE_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备名称',
  `GRADE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '故障判定评分（0-100)',
  `OPERATION_USER_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人用户名',
  `IS_DELETE` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除: 0-未删除，1-已删除',
  `CREATED_AT` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '数据创建时间    ',
  `UPDATED_AT` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '数据最后更新时间  ',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of fault_evaluation_datas
-- ----------------------------

-- ----------------------------
-- Table structure for fault_record_datas
-- ----------------------------
DROP TABLE IF EXISTS `fault_record_datas`;
CREATE TABLE `fault_record_datas`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id，索引',
  `FAULT_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '故障id',
  `FAULT_CODE` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '故障代码',
  `FAULT_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FAULT_TYPE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '故障类型',
  `BOAT_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '对应船只ID',
  `BOAT_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '船只代码',
  `BOAT_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '船只名称',
  `DEVICE_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '设备ID',
  `DEVICE_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备代码',
  `DEVICE_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备名称',
  `USER_ID` int(11) UNSIGNED NULL DEFAULT 1 COMMENT '用户id，为1',
  `USER_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名，为“管理员”',
  `FAULT_DATA_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '数据id（以逗号分隔）',
  `FAULT_METHOD` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '处理方法（提示解决方法）',
  `FAULT_MODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '故障模式',
  `FAULT_SUGGEST` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '故障维护建议',
  `FAULT_TIME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报警时间（2019-11-11 21:16:20）',
  `DEAL_USERNAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '处理人',
  `DEAL_TIME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '处理时间',
  `IS_KNOW` tinyint(1) NULL DEFAULT 0 COMMENT '是否为未知故障（0已知，1未知）',
  `IS_EVALUATION` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否评价: 0-未评价，1-已评价',
  `IS_DEAL` tinyint(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0 COMMENT '处理状态：0-未处理，1-已处理',
  `IS_DELETE` tinyint(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0 COMMENT '是否删除: 0-未删除，1-已删除',
  `CREATED_AT` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '数据创建时间    ',
  `UPDATED_AT` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '数据最后更新时间  ',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of fault_record_datas
-- ----------------------------

-- ----------------------------
-- Table structure for fault_statistics_datas
-- ----------------------------
DROP TABLE IF EXISTS `fault_statistics_datas`;
CREATE TABLE `fault_statistics_datas`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FAULT_ID` int(11) UNSIGNED NULL DEFAULT NULL,
  `FAULT_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `FAULT_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `FAULT_COUNT_SEVEN` int(11) UNSIGNED NULL DEFAULT 0,
  `FAULT_SCALE_SEVEN` float UNSIGNED NULL DEFAULT NULL,
  `FAULT_COUNT_MONTH` int(11) UNSIGNED NULL DEFAULT 0,
  `FAULT_SCALE_MONTH` float UNSIGNED NULL DEFAULT NULL,
  `FAULT_COUNT_QUARTER` int(11) UNSIGNED NULL DEFAULT 0,
  `FAULT_SCALE_QUARTER` float UNSIGNED NULL DEFAULT NULL,
  `FAULT_COUNT_YEAR` int(11) UNSIGNED NULL DEFAULT 0,
  `FAULT_SCALE_YEAR` float UNSIGNED NULL DEFAULT NULL,
  `FAULT_COUNT_ALL` int(11) UNSIGNED NULL DEFAULT 0,
  `FAULT_SCALE_ALL` float UNSIGNED NULL DEFAULT NULL,
  `IS_DELETE` tinyint(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0,
  `CREATED_AT` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '数据创建时间    ',
  `UPDATED_AT` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '数据最后更新时间  ',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fault_statistics_datas
-- ----------------------------
INSERT INTO `fault_statistics_datas` VALUES (1, 1, 'abn-p-01', '供油管路未通', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2020-08-26 19:02:44', '2020-09-11 15:23:54');
INSERT INTO `fault_statistics_datas` VALUES (2, 2, 'abn-p-02', '供油管路未通', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2020-08-26 22:42:27', '2020-09-11 15:23:54');
INSERT INTO `fault_statistics_datas` VALUES (3, 3, 'abn-p-03', '滤芯堵塞', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2020-09-09 22:04:16', '2020-09-11 15:23:54');
INSERT INTO `fault_statistics_datas` VALUES (4, 4, 'abn-p-04', '滤芯堵塞', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2020-09-09 22:04:33', '2020-09-11 15:23:54');
INSERT INTO `fault_statistics_datas` VALUES (5, 5, 'err-p-01', '供应泵故障', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2020-09-09 22:04:50', '2020-09-14 13:37:02');
INSERT INTO `fault_statistics_datas` VALUES (6, 6, 'err-p-02', '增压泵1故障', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2020-09-09 22:05:06', '2020-09-11 15:23:54');
INSERT INTO `fault_statistics_datas` VALUES (7, 7, 'err-p-03', '增压泵2故障', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2020-09-09 22:05:22', '2020-09-14 13:37:05');
INSERT INTO `fault_statistics_datas` VALUES (8, 8, 'abn-p-05', '压力调节阀异常', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2020-09-09 22:05:39', '2020-09-11 15:23:54');
INSERT INTO `fault_statistics_datas` VALUES (9, 9, 'abn-p-06', '管道阻塞', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2020-09-09 22:05:51', '2020-09-11 15:23:55');
INSERT INTO `fault_statistics_datas` VALUES (10, 10, 'abn-p-07', '自清滤器滤芯阻塞', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2020-09-09 22:06:07', '2020-09-14 13:37:06');
INSERT INTO `fault_statistics_datas` VALUES (11, 11, 'abn-t-1', '油仓燃油使用条件不具备', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2020-09-09 22:06:23', '2020-09-11 15:23:55');
INSERT INTO `fault_statistics_datas` VALUES (12, 12, 'abn-t-2', '燃油加热功率低', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2020-09-09 22:06:34', '2020-09-14 13:37:07');
INSERT INTO `fault_statistics_datas` VALUES (13, 13, 'err-t-1', '加热器功率低', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2020-09-09 22:06:49', '2020-09-11 15:23:55');
INSERT INTO `fault_statistics_datas` VALUES (14, 14, 'err-t-2', '冷却器换热效果不佳', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2020-09-09 22:07:03', '2020-09-11 15:23:55');
INSERT INTO `fault_statistics_datas` VALUES (15, 15, 'err-v-1', '换热器故障', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2020-09-09 22:07:19', '2020-09-14 13:37:09');

-- ----------------------------
-- Table structure for maintain_record_datas
-- ----------------------------
DROP TABLE IF EXISTS `maintain_record_datas`;
CREATE TABLE `maintain_record_datas`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id，索引',
  `MAINTENANCE_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '维护项目id',
  `MAINTENANCE_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '维护项目名称',
  `BOAT_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '船只id',
  `BOAT_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '船只代码',
  `BOAT_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '船只名称',
  `DEVICE_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '设备ID',
  `DEVICE_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '设备代码',
  `DEVICE_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '设备名称',
  `MAINTENANCE_METHOD` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '处理方式(更换、清洁处理、校正、检查)',
  `MAINTENANCE_PLAN` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '维护计划（1：月、2：季度、3：半年、4：年）',
  `MAINTENANCE_USER_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '维护人员姓名',
  `REMIND_TIME` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '提醒时间（2019-11-11 21:16:20）',
  `MAINTENANCE_TIME` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '维护时间（2019-11-11 21:16:20）',
  `IS_DEAL` tinyint(1) NOT NULL DEFAULT 0 COMMENT '维护状态：0-未维护，1-已维护',
  `IS_DELETE` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除: 0-未删除，1-已删除',
  `CREATED_AT` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '数据创建时间   ',
  `UPDATED_AT` timestamp(0) NULL DEFAULT NULL COMMENT '数据最后更新时间 ',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of maintain_record_datas
-- ----------------------------

-- ----------------------------
-- Table structure for maintenance_datas
-- ----------------------------
DROP TABLE IF EXISTS `maintenance_datas`;
CREATE TABLE `maintenance_datas`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id，索引',
  `BOAT_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '船只id',
  `BOAT_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '船只代码',
  `BOAT_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '船只名称',
  `DEVICE_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '设备ID',
  `DEVICE_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '设备代码',
  `DEVICE_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '设备名称',
  `MAINTENANCE_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '维护项目名称',
  `MAINTENANCE_METHOD` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '处理方式(更换、清洁处理、校正、检查)',
  `FIT_TIME` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '装配时间（2019-11-11 21:16:20）',
  `MAINTENANCE_PLAN` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '维护计划（1：月、2：季度、3：半年、4：年）',
  `IS_REMOVE` tinyint(1) NOT NULL DEFAULT 0 COMMENT '拆卸标志：0-未拆卸，1-已拆卸',
  `REMOVE_SIGN` tinyint(1) NOT NULL DEFAULT 0 COMMENT '拆卸时是否维护: 0-不维护，1-维护',
  `IS_DELETE` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除: 0-未删除，1-已删除',
  `CREATED_AT` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '数据创建时间   ',
  `UPDATED_AT` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '数据最后更新时间 ',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of maintenance_datas
-- ----------------------------

-- ----------------------------
-- Table structure for maintenance_knowledge_datas
-- ----------------------------
DROP TABLE IF EXISTS `maintenance_knowledge_datas`;
CREATE TABLE `maintenance_knowledge_datas`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FAULT_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '故障代码',
  `FAULT_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '故障名称',
  `FAULT_TYPE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '故障类型',
  `FAULT_ALGORITHM` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '故障算法',
  `FAULT_REASON` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '故障发生原因',
  `FAULT_FEATURE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '故障特征',
  `FAULT_METHOD` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '故障解决方法',
  `FAULT_SUGGEST` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '故障维护建议',
  `FAULT_MODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '故障模式',
  `FAULT_MONTH_COUNT` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '最近一月发生的次数',
  `FAULT_COUNT` int(11) UNSIGNED NULL DEFAULT 0 COMMENT '该故障总次数',
  `FAULT_SCALE` float UNSIGNED NULL DEFAULT NULL COMMENT '该故障总次数与所有故障次数（is_main为0）的比例',
  `IS_MAIN` tinyint(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '是否已属于运维库，0属于，1未属于',
  `IS_DELETE` tinyint(1) UNSIGNED NOT NULL DEFAULT 0,
  `CREATED_AT` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '数据创建时间    ',
  `UPDATED_AT` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '数据最后更新时间  ',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of maintenance_knowledge_datas
-- ----------------------------
INSERT INTO `maintenance_knowledge_datas` VALUES (1, 'abn-p-01', '供油管路未通', 'abn', 'abn', '供油管路未通', 'P1不在正常工作范围内', '检查油仓到燃油供应单元间阀门状态', '检查燃油日用柜与燃油供应单元之间管道连接是否正确；检查燃油日用柜到燃油供应单元之间管道阀门和燃油转换阀的状态是否正确，如有误，手动调节到合适状态。', '燃油入口管道状态异常', NULL, 0, 0, 0, 0, '2020-08-28 12:48:20', '2020-08-28 12:48:20');
INSERT INTO `maintenance_knowledge_datas` VALUES (2, 'abn-p-02', '供油管路未通', 'abn', 'abn', '供油管路未通', 'P2不在正常工作范围内', '检查油仓到燃油供应单元间阀门状态', '检查燃油日用柜与燃油供应单元之间管道连接是否正确；检查燃油日用柜到燃油供应单元之间管道阀门和燃油转换阀的状态是否正确，如有误，手动调节到合适状态。', '燃油入口管道状态异常', NULL, 0, 0, 0, 0, '2020-08-28 12:49:27', '2020-08-28 12:49:27');
INSERT INTO `maintenance_knowledge_datas` VALUES (3, 'abn-p-03', '滤芯堵塞', 'abn', 'abn', '滤芯堵塞', 'P3-P1超出设定值', '切换备用粗滤器，清洗滤芯', '确认油质是否达标；切换至备用粗滤器；关闭堵塞粗滤器的前后阀门，将堵塞滤器的滤芯取出，进行清洗，然后装回原粗滤器；每季度定期切换至备用粗滤器。', '粗滤器滤芯堵塞', NULL, 0, 0, 0, 0, '2020-08-28 12:49:18', '2020-08-28 12:49:18');
INSERT INTO `maintenance_knowledge_datas` VALUES (4, 'abn-p-04', '滤芯堵塞', 'abn', 'abn', '滤芯堵塞', 'P4-P2超出设定值', '切换备用粗滤器，清洗滤芯', '确认油质是否达标；切换至备用粗滤器；关闭堵塞粗滤器的前后阀门，将堵塞滤器的滤芯取出，进行清洗，然后装回原粗滤器；每季度定期切换至备用粗滤器。', '粗滤器滤芯堵塞', NULL, 0, 0, 0, 0, '2020-08-28 12:49:20', '2020-08-28 12:49:20');
INSERT INTO `maintenance_knowledge_datas` VALUES (5, 'err-p-01', '供应泵故障', 'err', 'err', '当前工作供应泵故障；主机超出额定负荷，所有压力均会降低，混油桶也无法保持在正常液位', 'P5，P6，P7，P9不在正常范围内；P5-P3或者P5-P4≤3bar', '切换备用供应泵，检查原工作泵问题；检查主机负载情况；若P5高而P6，P7，P9低有可能是流量计堵塞。', '检查电机是否故障，如异常，切换至备用泵，拆除故障电机维修；检查垫片是否老化，如老化，更换垫片；检查泵体是否漏油，若漏油，切换至备用泵，检查该泵的轴封。', '供应泵油压不足', NULL, 0, 0, 0, 0, '2020-09-09 10:00:08', '2020-09-14 13:37:49');
INSERT INTO `maintenance_knowledge_datas` VALUES (6, 'err-p-02', '增压泵1故障', 'err', 'err', '增压泵1故障', 'P7-P5小于5bar', '切换为增压泵2工作，检查增压泵1问题；', '检查电机是否故障，如异常，切换至备用泵，拆除故障电机维修；检查垫片是否老化，如老化，更换垫片；检查泵体是否漏油，若漏油，切换至备用泵，检查该泵的轴封。', '增压泵油压不足', NULL, 0, 0, 0, 0, '2020-08-28 12:50:22', '2020-08-28 12:50:22');
INSERT INTO `maintenance_knowledge_datas` VALUES (7, 'err-p-03', '增压泵2故障', 'err', 'err', '增压泵2故障', 'P7-P6小于5bar', '切换为增压泵1工作，检查增压泵2问题；', '检查电机是否故障，如异常，切换至备用泵，拆除故障电机维修；检查垫片是否老化，如老化，更换垫片；检查泵体是否漏油，若漏油，切换至备用泵，检查该泵的轴封。', '增压泵油压不足', NULL, 0, 0, 0, 0, '2020-09-09 10:00:08', '2020-09-14 13:37:53');
INSERT INTO `maintenance_knowledge_datas` VALUES (8, 'abn-p-05', '压力调节阀异常', 'abn', 'abn', '压力调节阀异常；阀门损坏', 'P9压力不在正常工作范围\r\nP9压力不在正常工作范围\r\nP9压力不在正常工作范围', '调节压力调节阀的开度；更换压力调节阀；流量计阻塞', '检查压力调节阀是否漏油，如漏油，更换密封圈；拧紧或松动阀门，观察压力变化，如无变化，需更换压力调节阀。', '压力调节阀故障', NULL, 0, 0, 0, 0, '2020-08-28 12:51:16', '2020-08-28 12:51:16');
INSERT INTO `maintenance_knowledge_datas` VALUES (9, 'abn-p-06', '管道阻塞', 'abn', 'abn', '管道阻塞', 'P10不在预期压力范围内', '检查增压泵后阀门状态，若已开启，则可能加热器、板冷自清滤器阻塞，需要切换换热器，及时清洗。', '检查管道是否有漏油现象，如有，则需更换垫片或者密封圈；检查出油管道是否已完全打开，否则将导致管道堵塞，增大沿程水头损耗，降低出油压力。', '燃油出口压力不足', NULL, 0, 0, 0, 0, '2020-08-28 12:52:14', '2020-08-28 12:52:14');
INSERT INTO `maintenance_knowledge_datas` VALUES (10, 'abn-p-07', '自清滤器滤芯阻塞', 'abn', 'abn', '自清滤器滤芯阻塞', 'P12-P11超出设定值', '切换到旁通滤器，及时清洗或者更换滤芯', '确保燃油品质符合设计要求；适当增加冲洗频率；切换至旁通滤器；清洗或更换自清侧滤芯。', '自清滤器堵塞', NULL, 0, 0, 0, 0, '2020-08-28 12:52:42', '2020-09-14 13:37:56');
INSERT INTO `maintenance_knowledge_datas` VALUES (11, 'abn-t-1', '油仓燃油使用条件不具备', 'abn', 'abn', '油仓燃油使用条件不具备', 'T8异常', '更换燃油，或者加热燃油。', '检查日用油柜中燃油温度；检查燃油入口管道的保温情况，避免热量散失；增大日用油柜中燃油加热功率', '日用油柜燃油温度不达标', NULL, 0, 0, 0, 0, '2020-08-28 12:53:04', '2020-08-28 12:53:04');
INSERT INTO `maintenance_knowledge_datas` VALUES (12, 'abn-t-2', '燃油加热功率低', 'abn', 'abn', '燃油加热功率低；回油管路温降大', 'T1，T2，T3异常', '增加加热器功率；回油管路保温。', '检查燃油出口温度是否异常；检查回油管道是否未保温或者保温层损坏，如未保温，采取保温措施', '回油异常', NULL, 0, 0, 0, 0, '2020-09-09 10:00:08', '2020-09-14 13:37:58');
INSERT INTO `maintenance_knowledge_datas` VALUES (13, 'err-t-1', '加热器功率低', 'err', 'err', '加热器功率低', 'T4，T7低于目标温度', '加大加热器功率；提高蒸汽温度；加大温控阀开度；切换加热器，定期清洗。', '检查加热器保温层是否完好；排放加热器燃油侧的热油气；增加热侧介质温度，增大温控阀开度，提高加热功率；切换至备用加热器，检查加热效果，如果明显变好，则需清洗加热器；两台加热器定期切换使用，并定期清洗。', '加热器效率低', NULL, 0, 0, 0, 0, '2020-08-28 12:53:54', '2020-08-28 12:53:54');
INSERT INTO `maintenance_knowledge_datas` VALUES (14, 'err-t-2', '冷却器换热效果不佳', 'err', 'err', '冷却器换热效果不佳', 'T6，T7高于目标温度', '增加换热器换热面积；换热器表面积垢，定期清洗；检查冷却水温度、冷却水进出口阀门状态；', '检查冷却器的密封圈是否老化；检查冷却流体温度是否符合设计要求；针对燃油侧进行排气；清洗换热板表面的污垢。', '冷却器冷却效率低', NULL, 0, 0, 0, 0, '2020-08-28 12:54:38', '2020-08-28 12:54:38');
INSERT INTO `maintenance_knowledge_datas` VALUES (15, 'err-v-1', '换热器故障', 'err', 'err', '换热器功率低；换热器结垢；温控阀故障', 'V1不在目标范围内', '增加温控阀开度；切换换热器；清洗换热器表面；检查温控阀的状态，若损坏，采用手动调节。', '排除是否由于加热器和冷却器的原因；进行计量的重新标定，并定期标定。', '粘度异常', NULL, 0, 0, 0, 0, '2020-09-09 10:00:08', '2020-09-14 13:38:03');

-- ----------------------------
-- Table structure for sensor_datas
-- ----------------------------
DROP TABLE IF EXISTS `sensor_datas`;
CREATE TABLE `sensor_datas`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id，索引',
  `BOAT_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '船只ID',
  `BOAT_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '船只代码',
  `BOAT_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '船只名称',
  `DEVICE_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '设备ID',
  `DEVICE_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备代码',
  `DEVICE_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备名称',
  `P1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '粗滤器1前压力',
  `P2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '粗滤器2前压力',
  `P3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应泵1前压力',
  `P4` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应泵2前压力',
  `P5` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应泵后压力',
  `P6` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '增压泵1前压力',
  `P7` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '增压泵2前压力',
  `P8` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '增压泵后压力',
  `P9` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '混油桶压力',
  `P10` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '燃油出口压力',
  `P11` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '自清滤器前压力',
  `P12` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '自清滤器后压力',
  `P13` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '热侧入口压力',
  `T1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '混油桶温度',
  `T2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加热器1前温度',
  `T3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加热器2前温度',
  `T4` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加热器后温度',
  `T5` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '冷却器前温度',
  `T6` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '冷却器后温度',
  `T7` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出口处温度',
  `T8` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '混油桶前温度',
  `T9` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '热侧入口温度',
  `V1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加热器之后粘度',
  `SIGN` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'V1标志位：M/H',
  `TIME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '解析数据所得时间',
  `IS_DELETE` tinyint(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0 COMMENT '是否删除: 0-未删除，1-已删除',
  `CREATED_AT` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '数据创建时间    ',
  `UPDATED_AT` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '数据最后更新时间  ',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 187372 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sensor_datas
-- ----------------------------

-- ----------------------------
-- Table structure for sparepart_change_datas
-- ----------------------------
DROP TABLE IF EXISTS `sparepart_change_datas`;
CREATE TABLE `sparepart_change_datas`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id，索引',
  `SPAREPART_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '备品id',
  `BOAT_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '对应船只ID',
  `BOAT_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '船只代码',
  `BOAT_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '船只名称',
  `DEVICE_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '设备ID',
  `DEVICE_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备代码',
  `DEVICE_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备名称',
  `MODULE_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组件名',
  `PART_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '零件名',
  `OLD_VALUE` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '旧阈值',
  `NEW_VALUE` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '新阈值',
  `CHANGE_USER_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '操作人id',
  `CHANGE_USER_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人用户名',
  `CHANGE_TIME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作时间（2019-11-11 21:16:20）',
  `IS_DELETE` tinyint(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0 COMMENT '是否删除: 0-未删除，1-已删除',
  `CREATED_AT` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '数据创建时间    ',
  `UPDATED_AT` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '数据最后更新时间  ',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sparepart_change_datas
-- ----------------------------

-- ----------------------------
-- Table structure for sparepart_datas
-- ----------------------------
DROP TABLE IF EXISTS `sparepart_datas`;
CREATE TABLE `sparepart_datas`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id，索引',
  `BOAT_ID` int(11) UNSIGNED NOT NULL COMMENT '船只id',
  `BOAT_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '船只代码',
  `BOAT_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '船只名称',
  `DEVICE_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '设备ID',
  `DEVICE_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '设备代码',
  `DEVICE_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '设备名称',
  `MODULE_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '组件名',
  `PART_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '零件名',
  `MIN_NUMBER` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '最小阈值',
  `CURRENT_NUMBER` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '当前数量',
  `IS_DELETE` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除: 0-未删除，1-已删除',
  `CREATED_AT` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '数据创建时间   ',
  `UPDATED_AT` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '数据最后更新时间 ',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sparepart_datas
-- ----------------------------

-- ----------------------------
-- Table structure for sparepart_inout_datas
-- ----------------------------
DROP TABLE IF EXISTS `sparepart_inout_datas`;
CREATE TABLE `sparepart_inout_datas`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id，索引',
  `SPAREPART_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '备品id',
  `BOAT_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '对应船只ID',
  `BOAT_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '船只代码',
  `BOAT_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '船只名称',
  `DEVICE_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '设备ID',
  `DEVICE_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备代码',
  `DEVICE_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备名称',
  `MODULE_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组件名',
  `PART_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '零件名',
  `OPERATION` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作',
  `OPERATION_NUMBER` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '操作数量',
  `OPERATION_USER_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '操作人id',
  `OPERATION_USER_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人用户名',
  `OPERATION_TIME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作时间（2019-11-11 21:16:20）',
  `IS_DELETE` tinyint(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0 COMMENT '是否删除: 0-未删除，1-已删除',
  `CREATED_AT` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '数据创建时间    ',
  `UPDATED_AT` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '数据最后更新时间  ',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sparepart_inout_datas
-- ----------------------------

-- ----------------------------
-- Table structure for sparepart_warning_datas
-- ----------------------------
DROP TABLE IF EXISTS `sparepart_warning_datas`;
CREATE TABLE `sparepart_warning_datas`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id，索引',
  `SPAREPART_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '备品id',
  `BOAT_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '对应船只ID',
  `BOAT_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '船只代码',
  `BOAT_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '船只名称',
  `DEVICE_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '设备ID',
  `DEVICE_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备代码',
  `DEVICE_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备名称',
  `MODULE_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组件名',
  `PART_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '零件名',
  `KNOWN_USER_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '已知晓人id',
  `KNOWN_USER_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '已知晓人用户名',
  `WARNING_TIME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '提醒时间（2019-11-11 21:16:20）',
  `IS_KNOW` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否知晓: 0-未知晓，1-已知晓',
  `IS_DELETE` tinyint(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0 COMMENT '是否删除: 0-未删除，1-已删除',
  `CREATED_AT` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '数据创建时间    ',
  `UPDATED_AT` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '数据最后更新时间  ',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sparepart_warning_datas
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id，索引  ',
  `USERNAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '用户名',
  `PASSWORD` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '密码',
  `BOAT_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '所属船只id',
  `BOAT_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '船只代码',
  `BOAT_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '船只名称',
  `MOBILE` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '手机号',
  `MAIL` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '邮箱',
  `ROLE` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '角色',
  `SIGN` int(1) UNSIGNED NOT NULL COMMENT '船/岸标识（0:船 1:岸）',
  `IS_DELETE` tinyint(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0 COMMENT '是否删除: 0-未删除，1-已删除',
  `CREATED_AT` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '数据创建时间    ',
  `UPDATED_AT` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '数据最后更新时间  ',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'admin', '21232f297a57a5a743894a0e4a801fc3', NULL, NULL, NULL, '13999999999', '421565215@qq.com', '系统管理员', 1, 0, '2020-08-19 10:22:42', '2020-08-19 10:22:42');

-- ----------------------------
-- Table structure for warning_information_datas
-- ----------------------------
DROP TABLE IF EXISTS `warning_information_datas`;
CREATE TABLE `warning_information_datas`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id，索引',
  `WARNING_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预警代码',
  `WARNING_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预警名称',
  `WARNING_TYPE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预警类型',
  `WARNING_ALGORITHM` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预警算法模型',
  `WARNING_REASON` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预警发生原因',
  `WARNING_FEATURE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预警特征',
  `WARNING_METHOD` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '拟解决方法',
  `WARNING_COUNT` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '预警发生总次数',
  `WARNING_SCALE` float UNSIGNED NULL DEFAULT NULL COMMENT '预警发生比例',
  `IS_DELETE` tinyint(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0 COMMENT '是否删除: 0-未删除，1-已删除',
  `CREATED_AT` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '数据创建时间    ',
  `UPDATED_AT` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '数据最后更新时间  ',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of warning_information_datas
-- ----------------------------

-- ----------------------------
-- Table structure for warning_record_datas
-- ----------------------------
DROP TABLE IF EXISTS `warning_record_datas`;
CREATE TABLE `warning_record_datas`  (
  `ID` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id，索引',
  `WARNING_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '预警id',
  `WARNING_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预警代码',
  `WARNING_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预警名称',
  `WARNING_TYPE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预警类型',
  `BOAT_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '对应船只ID',
  `BOAT_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '船只代码',
  `BOAT_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '船只名称',
  `DEVICE_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '设备ID',
  `DEVICE_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备代码',
  `DEVICE_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备名称',
  `USER_ID` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '用户id，为1',
  `USER_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名，为“管理员”',
  `WARNING_DATA_ID` int(11) NULL DEFAULT NULL COMMENT '数据id（以逗号分隔）',
  `WARNING_METHOD` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '处理方法（提示解决方法）',
  `WARNING_TIME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报警时间（2019-11-11 21:16:20）',
  `WARNING_MODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预警模式',
  `WARNING_SUGGEST` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预警维护建议',
  `DEAL_TIME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '处理时间',
  `IS_DEAL` tinyint(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0 COMMENT '处理状态：0-未处理，1-已处理',
  `IS_DELETE` tinyint(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0 COMMENT '是否删除: 0-未删除，1-已删除',
  `CREATED_AT` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '数据创建时间    ',
  `UPDATED_AT` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '数据最后更新时间  ',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of warning_record_datas
-- ----------------------------

-- ----------------------------
-- Triggers structure for table devices
-- ----------------------------
DROP TRIGGER IF EXISTS `ins_maintenance_and_sparepart`;
delimiter ;;
CREATE TRIGGER `ins_maintenance_and_sparepart` AFTER INSERT ON `devices` FOR EACH ROW begin 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'粗滤器（滤芯）','更换、清洁处理',CURRENT_TIMESTAMP,'2','0'); 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'粗滤器（压差指示器）','校正、检查',CURRENT_TIMESTAMP,'2','0'); 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'粗滤器（垫片）','更换',CURRENT_TIMESTAMP,'4','1'); 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'自清滤器（滤芯）','更换、清洁处理',CURRENT_TIMESTAMP,'2','0'); 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'自清滤器（压差指示器）','校正、检查',CURRENT_TIMESTAMP,'2','0'); 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'自清滤器（垫片）','更换',CURRENT_TIMESTAMP,'4','1'); 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'自清滤器（密封圈）','更换',CURRENT_TIMESTAMP,'4','1'); 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'自清滤器（电磁阀）','检查',CURRENT_TIMESTAMP,'2','0'); 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'自清滤器（驱动器）','检查',CURRENT_TIMESTAMP,'2','0'); 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'自清滤器（压力表）','校正',CURRENT_TIMESTAMP,'3','0'); 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'加热器（内部管道）','清洁处理',CURRENT_TIMESTAMP,'4','1'); 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'加热器（垫片）','更换',CURRENT_TIMESTAMP,'4','1'); 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'冷却器（换热板片）','清洁处理',CURRENT_TIMESTAMP,'4','1'); 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'冷却器（垫片）','更换',CURRENT_TIMESTAMP,'4','1'); 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'冷却器（密封圈）','更换',CURRENT_TIMESTAMP,'4','1'); 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'供应泵/增压泵（轴封）','检查',CURRENT_TIMESTAMP,'3','1'); 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'供应泵/增压泵（垫片）','更换',CURRENT_TIMESTAMP,'4','1'); 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'供应泵/增压泵（电机）','检查',CURRENT_TIMESTAMP,'3','1'); 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'供应泵/增压泵（螺杆）','检查',CURRENT_TIMESTAMP,'4','1'); 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'计量组件（流量计）','校正',CURRENT_TIMESTAMP,'4','1'); 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'计量组件（粘度计）','校正',CURRENT_TIMESTAMP,'4','1'); 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'管道阀门（垫片）','更换',CURRENT_TIMESTAMP,'4','1'); 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'管道阀门（安全阀）','校正',CURRENT_TIMESTAMP,'4','1'); 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'管道阀门（压力调节阀）','校正',CURRENT_TIMESTAMP,'4','1'); 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'管道阀门（电磁阀）','检查',CURRENT_TIMESTAMP,'4','0'); 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'管道阀门（排气阀）','检查',CURRENT_TIMESTAMP,'4','0'); 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'管道阀门（密封圈）','更换',CURRENT_TIMESTAMP,'4','0'); 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'电控系统（信号灯）','检查',CURRENT_TIMESTAMP,'3','0'); 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'电控系统（PLC）','检查',CURRENT_TIMESTAMP,'2','0'); 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'电控系统（开关）','检查',CURRENT_TIMESTAMP,'3','0'); 
 insert into maintenance_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MAINTENANCE_NAME,MAINTENANCE_METHOD,FIT_TIME,MAINTENANCE_PLAN,REMOVE_SIGN) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'电控系统（应急按钮）','检查',CURRENT_TIMESTAMP,'1','0'); 
 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'粗滤器','滤芯','5','5'); 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'粗滤器','压差指示器','5','5'); 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'粗滤器','垫片','5','5'); 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'自清滤器','滤芯','5','5'); 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'自清滤器','压差指示器','5','5'); 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'自清滤器','垫片','5','5'); 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'自清滤器','密封圈','5','5'); 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'自清滤器','电磁阀','5','5'); 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'自清滤器','驱动器','5','5'); 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'自清滤器','压力表','5','5'); 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'加热器','内部管道','5','5'); 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'加热器','垫片','5','5'); 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'冷却器','换热板片','5','5'); 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'冷却器','垫片','5','5'); 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'冷却器','密封圈','5','5'); 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'供应泵/增压泵','轴封','5','5'); 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'供应泵/增压泵','垫片','5','5'); 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'供应泵/增压泵','电机','5','5'); 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'供应泵/增压泵','螺杆','5','5'); 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'计量组件','流量计','5','5'); 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'计量组件','粘度计','5','5'); 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'管道阀门','垫片','5','5'); 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'管道阀门','安全阀','5','5'); 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'管道阀门','压力调节阀','5','5'); 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'管道阀门','电磁阀','5','5'); 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'管道阀门','排气阀','5','5'); 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'管道阀门','密封圈','5','5'); 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'电控系统','信号灯','5','5'); 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'电控系统','PLC','5','5'); 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'电控系统','开关','5','5'); 
 insert into sparepart_datas ( BOAT_ID, BOAT_CODE,BOAT_NAME,DEVICE_ID,DEVICE_CODE,DEVICE_NAME,MODULE_NAME,PART_NAME,MIN_NUMBER,CURRENT_NUMBER) 
 values( new.BOAT_ID, new.BOAT_CODE,new.BOAT_NAME,new.ID,new.DEVICE_CODE,new.DEVICE_NAME,'电控系统','应急按钮','5','5'); 

end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
