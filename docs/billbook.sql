/*
Navicat MySQL Data Transfer

Source Server         : mysql5.7
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : billbook

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-03-23 11:12:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bb_bill
-- ----------------------------
DROP TABLE IF EXISTS `bb_bill`;
CREATE TABLE `bb_bill`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `cost` float(10, 2) NOT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userId` int(8) NOT NULL,
  `payId` int(8) NULL DEFAULT NULL,
  `sortId` int(8) NOT NULL,
  `crDate` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `income` tinyint(1) NOT NULL DEFAULT 1,
  `version` int(2) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_bill_user`(`userId`) USING BTREE,
  INDEX `fk_bill_sort`(`sortId`) USING BTREE,
  INDEX `fk_bill_pay`(`payId`) USING BTREE,
  CONSTRAINT `fk_bill_pay` FOREIGN KEY (`payId`) REFERENCES `bb_pay` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_bill_sort` FOREIGN KEY (`sortId`) REFERENCES `bb_sort` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_bill_user` FOREIGN KEY (`userId`) REFERENCES `bb_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bb_bill
-- ----------------------------
INSERT INTO `bb_bill` VALUES (1, 100.00, NULL, 1, 1, 39, '2017-12-06 12:58:27', 1, 0);
INSERT INTO `bb_bill` VALUES (2, 100.00, NULL, 1, 1, 1, '2017-12-05 05:13:23', 0, 0);
INSERT INTO `bb_bill` VALUES (3, 100.00, NULL, 1, 1, 2, '2017-12-06 12:48:08', 0, 0);
INSERT INTO `bb_bill` VALUES (4, 50.00, 'null', 1, 1, 1, '2017-12-05 05:13:26', 0, 0);
INSERT INTO `bb_bill` VALUES (5, 250.00, 'null', 1, 1, 3, '2017-12-06 12:48:12', 0, 0);
INSERT INTO `bb_bill` VALUES (6, 200.00, 'null', 1, 1, 1, '2017-12-05 05:13:27', 0, 0);
INSERT INTO `bb_bill` VALUES (7, 100.00, 'test', 1, 1, 41, '2017-12-06 12:58:38', 1, 0);
INSERT INTO `bb_bill` VALUES (8, 100.00, 'test', 1, 1, 1, '2017-12-05 05:13:29', 0, 0);
INSERT INTO `bb_bill` VALUES (9, 100.00, 'test', 1, 1, 1, '2017-12-05 05:13:32', 0, 0);
INSERT INTO `bb_bill` VALUES (10, 100.00, 'test', 1, 5, 41, '2017-12-06 12:58:41', 1, 0);
INSERT INTO `bb_bill` VALUES (11, 100.00, 'test', 1, 5, 40, '2017-12-06 12:58:45', 1, 0);
INSERT INTO `bb_bill` VALUES (12, 555.00, 'test', 1, 3, 2, '2017-12-27 12:58:27', 0, 0);
INSERT INTO `bb_bill` VALUES (13, 555.00, 'test', 1, 3, 2, '2017-12-27 12:58:27', 0, 0);
INSERT INTO `bb_bill` VALUES (14, 555.00, 'test', 1, 3, 2, '2017-12-27 12:58:27', 0, 0);
INSERT INTO `bb_bill` VALUES (15, 1.00, 'test', 1, 3, 2, '2017-12-27 12:58:27', 0, 2);

-- ----------------------------
-- Table structure for bb_pay
-- ----------------------------
DROP TABLE IF EXISTS `bb_pay`;
CREATE TABLE `bb_pay`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `uid` int(8) NULL DEFAULT NULL,
  `pay_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pay_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pay_num` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bb_pay
-- ----------------------------
INSERT INTO `bb_pay` VALUES (1, 0, '现金', 'cash.png', NULL);
INSERT INTO `bb_pay` VALUES (2, 0, '支付宝', 'account.png', NULL);
INSERT INTO `bb_pay` VALUES (3, 0, '微信', 'account.png', NULL);
INSERT INTO `bb_pay` VALUES (4, 1, '银行卡', 'bank.png', '尾号5467');
INSERT INTO `bb_pay` VALUES (5, 1, '银行卡', 'bank.png', '尾号4563');

-- ----------------------------
-- Table structure for bb_sort
-- ----------------------------
DROP TABLE IF EXISTS `bb_sort`;
CREATE TABLE `bb_sort`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `uid` int(8) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `sort_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sort_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `priority` int(3) NULL DEFAULT NULL,
  `income` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bb_sort
-- ----------------------------
INSERT INTO `bb_sort` VALUES (1, 00000000, '住房', 'zhufang.png', NULL, 0);
INSERT INTO `bb_sort` VALUES (2, 00000000, '办公', 'bangong.png', NULL, 0);
INSERT INTO `bb_sort` VALUES (3, 00000000, '餐饮', 'canyin.png', NULL, 0);
INSERT INTO `bb_sort` VALUES (4, 00000000, '医疗', 'yiliao.png', NULL, 0);
INSERT INTO `bb_sort` VALUES (5, 00000000, '通讯', 'tongxun.png', NULL, 0);
INSERT INTO `bb_sort` VALUES (6, 00000000, '运动', 'yundong.png', NULL, 0);
INSERT INTO `bb_sort` VALUES (7, 00000000, '娱乐', 'yule.png', NULL, 0);
INSERT INTO `bb_sort` VALUES (8, 00000000, '酒水', 'jiushui.png', NULL, 0);
INSERT INTO `bb_sort` VALUES (9, 00000000, '居家', 'jujia.png', NULL, 0);
INSERT INTO `bb_sort` VALUES (10, 00000000, '宠物', 'chongwu.png', NULL, 0);
INSERT INTO `bb_sort` VALUES (11, 00000000, '数码', 'shuma.png', NULL, 0);
INSERT INTO `bb_sort` VALUES (12, 00000000, '捐赠', 'juanzeng.png', NULL, 0);
INSERT INTO `bb_sort` VALUES (13, 00000000, '零食', 'lingshi.png', NULL, 0);
INSERT INTO `bb_sort` VALUES (14, 00000000, '孩子', 'haizi.png', NULL, 0);
INSERT INTO `bb_sort` VALUES (15, 00000000, '长辈', 'zhangbei.png', NULL, 0);
INSERT INTO `bb_sort` VALUES (16, 00000000, '礼物', 'liwu.png', NULL, 0);
INSERT INTO `bb_sort` VALUES (17, 00000000, '学习', 'xuexi.png', NULL, 0);
INSERT INTO `bb_sort` VALUES (18, 00000000, '水果', 'shuiguo.png', NULL, 0);
INSERT INTO `bb_sort` VALUES (19, 00000000, '美容', 'meirong.png', NULL, 0);
INSERT INTO `bb_sort` VALUES (20, 00000000, '维修', 'weixiu.png', NULL, 0);
INSERT INTO `bb_sort` VALUES (21, 00000000, '旅行', 'lvxing.png', NULL, 0);
INSERT INTO `bb_sort` VALUES (22, 00000000, '交通', 'jiaotong.png', NULL, 0);
INSERT INTO `bb_sort` VALUES (23, 00000000, '礼金', 'lijin.png', NULL, 0);
INSERT INTO `bb_sort` VALUES (24, 00000000, '还款', 'huankuan.png', NULL, 0);
INSERT INTO `bb_sort` VALUES (25, 00000000, '购物', 'gouwu.png', NULL, 0);
INSERT INTO `bb_sort` VALUES (26, 00000000, '一般', 'yiban.png', NULL, 0);
INSERT INTO `bb_sort` VALUES (27, 00000000, '手续费', 'shouxufei.png', NULL, 0);
INSERT INTO `bb_sort` VALUES (28, 00000000, '违约金', 'weiyuejin.png', NULL, 0);
INSERT INTO `bb_sort` VALUES (29, 00000000, '其他', 'tianjiade.png', NULL, 0);
INSERT INTO `bb_sort` VALUES (30, 00000000, '礼金', 'lijin.png', NULL, 1);
INSERT INTO `bb_sort` VALUES (31, 00000000, '利息', 'lixi.png', NULL, 1);
INSERT INTO `bb_sort` VALUES (32, 00000000, '返现', 'fanxian.png', NULL, 1);
INSERT INTO `bb_sort` VALUES (33, 00000000, '兼职', 'jianzhi.png', NULL, 1);
INSERT INTO `bb_sort` VALUES (34, 00000000, '零钱', 'lingqian.png', NULL, 1);
INSERT INTO `bb_sort` VALUES (35, 00000000, '奖金', 'jiangjin.png', NULL, 1);
INSERT INTO `bb_sort` VALUES (36, 00000000, '其他', 'tianjiade.png', NULL, 1);

-- ----------------------------
-- Table structure for bb_user
-- ----------------------------
DROP TABLE IF EXISTS `bb_user`;
CREATE TABLE `bb_user`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `username` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mail` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(1) UNSIGNED ZEROFILL NULL DEFAULT 0,
  `mailcode` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phonecode` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bb_user
-- ----------------------------
INSERT INTO `bb_user` VALUES (1, 'admin', '3E3E6B0E5C1C68644FC5CE3CF060211D', 'M', '15997352948', '3160410046@qq.com', 0, NULL, NULL, NULL);
INSERT INTO `bb_user` VALUES (2, 'user01', '338CCCC24975FA0F6FF93D2AFA80AFF7', NULL, NULL, '100485985@qq.com', 1, 'ecbd72af2fc24585926627ec71354684c11da4bacde64b9796568ecdd99e79bc', NULL, NULL);
INSERT INTO `bb_user` VALUES (3, 'user02', 'C1898DE4A655382952DC4A93688E211D', NULL, NULL, '100485985@qq.com', 1, 'ecbd72af2fc24585926627ec71354684c11da4bacde64b9796568ecdd99e79bc', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;