/*
 Navicat Premium Data Transfer

 Source Server         : new3
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : mydatabase

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 25/11/2020 10:27:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bought_food
-- ----------------------------
DROP TABLE IF EXISTS `bought_food`;
CREATE TABLE `bought_food`  (
  `food_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `food_price` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shop_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bought_food
-- ----------------------------

-- ----------------------------
-- Table structure for buyer
-- ----------------------------
DROP TABLE IF EXISTS `buyer`;
CREATE TABLE `buyer`  (
  `pay_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of buyer
-- ----------------------------
INSERT INTO `buyer` VALUES ('123123', '1');
INSERT INTO `buyer` VALUES ('123', '17');
INSERT INTO `buyer` VALUES (NULL, '17');
INSERT INTO `buyer` VALUES ('123', '19');

-- ----------------------------
-- Table structure for elec_day
-- ----------------------------
DROP TABLE IF EXISTS `elec_day`;
CREATE TABLE `elec_day`  (
  `socket_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `day` int(255) NULL DEFAULT NULL,
  `elec` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `year` int(255) NULL DEFAULT NULL,
  `month` int(255) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of elec_day
-- ----------------------------
INSERT INTO `elec_day` VALUES ('1111', 1, '20', 2020, 1);
INSERT INTO `elec_day` VALUES ('1111', 2, '15', 2020, 1);
INSERT INTO `elec_day` VALUES ('1111', 4, '28.66', 2020, 1);
INSERT INTO `elec_day` VALUES ('1111', 3, '25.12', 2020, 1);
INSERT INTO `elec_day` VALUES ('1111', 15, '25.64', 2020, 1);
INSERT INTO `elec_day` VALUES ('1111', 6, '21.33', 2020, 1);
INSERT INTO `elec_day` VALUES ('1111', 7, '25.33', 2020, 1);
INSERT INTO `elec_day` VALUES ('1111', 9, '20.33', 2020, 1);
INSERT INTO `elec_day` VALUES ('1111', 18, '20.35', 2020, 1);
INSERT INTO `elec_day` VALUES ('1111', 10, '20.67', 2020, 1);
INSERT INTO `elec_day` VALUES ('1111', 11, '20.30', 2020, 1);
INSERT INTO `elec_day` VALUES ('1111', 12, '40.22', 2020, 1);
INSERT INTO `elec_day` VALUES ('1111', 13, '20.33', 2020, 1);
INSERT INTO `elec_day` VALUES ('1111', 14, '25.64', 2020, 1);
INSERT INTO `elec_day` VALUES ('1111', 5, '30.66', 2020, 1);
INSERT INTO `elec_day` VALUES ('1111', 16, '25.64', 2020, 1);
INSERT INTO `elec_day` VALUES ('1111', 17, '25.64', 2020, 1);
INSERT INTO `elec_day` VALUES ('1111', 8, '28.66', 2020, 1);
INSERT INTO `elec_day` VALUES ('1111', 19, '22.67', 2020, 1);
INSERT INTO `elec_day` VALUES ('1111', 20, '24.13', 2020, 1);
INSERT INTO `elec_day` VALUES ('1111', 21, '20.35', 2020, 1);
INSERT INTO `elec_day` VALUES ('1111', 22, '31.33', 2020, 1);
INSERT INTO `elec_day` VALUES ('1111', 23, '30.18', 2020, 1);
INSERT INTO `elec_day` VALUES ('1111', 24, '31', 2020, 1);
INSERT INTO `elec_day` VALUES ('1111', 25, '20.33', 2020, 1);
INSERT INTO `elec_day` VALUES ('1111', 26, '20', 2020, 1);
INSERT INTO `elec_day` VALUES ('1111', 27, '32.11', 2020, 1);
INSERT INTO `elec_day` VALUES ('1111', 28, '32', 2020, 1);
INSERT INTO `elec_day` VALUES ('1111', 29, '32.81', 2020, 1);
INSERT INTO `elec_day` VALUES ('1111', 30, '32.11', 2020, 1);
INSERT INTO `elec_day` VALUES ('1111', 31, '20.33', 2020, 1);

-- ----------------------------
-- Table structure for elec_month
-- ----------------------------
DROP TABLE IF EXISTS `elec_month`;
CREATE TABLE `elec_month`  (
  `socket_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `month` int(255) NULL DEFAULT NULL,
  `elec` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `year` int(255) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of elec_month
-- ----------------------------
INSERT INTO `elec_month` VALUES ('1111', 1, '25.1', 2020);
INSERT INTO `elec_month` VALUES ('1111', 2, '28', 2020);
INSERT INTO `elec_month` VALUES ('1111', 3, '60', 2020);
INSERT INTO `elec_month` VALUES ('1111', 4, '50', 2020);
INSERT INTO `elec_month` VALUES ('1111', 5, '34', 2020);
INSERT INTO `elec_month` VALUES ('1111', 6, '21.15', 2020);
INSERT INTO `elec_month` VALUES ('1111', 7, '22.66', 2020);
INSERT INTO `elec_month` VALUES ('1111', 8, '51.22', 2020);
INSERT INTO `elec_month` VALUES ('1111', 9, '34.22', 2020);
INSERT INTO `elec_month` VALUES ('1111', 10, '21.33', 2020);
INSERT INTO `elec_month` VALUES ('1111', 11, '22', 2020);
INSERT INTO `elec_month` VALUES ('1111', 12, '32', 2020);

-- ----------------------------
-- Table structure for food_menu
-- ----------------------------
DROP TABLE IF EXISTS `food_menu`;
CREATE TABLE `food_menu`  (
  `food_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `food_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `food_price` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `food_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `food_image_addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `food_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shop_id` int(50) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of food_menu
-- ----------------------------
INSERT INTO `food_menu` VALUES ('狼牙土豆', '好吃', '10', '小吃', '/root/img/food1.png', NULL, 1);
INSERT INTO `food_menu` VALUES ('锅巴土豆', '非常好吃的土豆', '12', '小吃', '/root/img/test.jpg', NULL, 1);
INSERT INTO `food_menu` VALUES ('汉堡', '又香又大的汉堡', '20', '热销', '/root/img/ham.jpg', NULL, 1);
INSERT INTO `food_menu` VALUES ('披萨', '好吃好吃好好吃的披萨', '28', '推荐', '/root/img/pizza.jpg', NULL, 1);
INSERT INTO `food_menu` VALUES ('油炸', '建议长肥', '25', '进店必买', '/root/img/boiled.jpg', NULL, 1);
INSERT INTO `food_menu` VALUES ('干锅兔', '好吃得很', '18', '进店必买', '/root/img/ganguotu.jpg', NULL, 2);
INSERT INTO `food_menu` VALUES ('麻辣兔头', '不辣赔双份', '23', '推荐', '/root/img/malatutou.jpg', NULL, 2);
INSERT INTO `food_menu` VALUES ('麻辣兔丁', '建议辣椒双份', '22', '小吃', '/root/img/malatuding.jpg', NULL, 2);
INSERT INTO `food_menu` VALUES ('爆炒兔腰', '非常爆的兔腰子', '32', '热销', '/root/img/baochaotuyao.png', NULL, 1);
INSERT INTO `food_menu` VALUES ('嘿嘿嘿', '好的', '12', '你好', '/root/FoodImg/food:_3_1602230618635.jpg', NULL, 1);
INSERT INTO `food_menu` VALUES ('憨憨', '哦', '10', '憨憨', '/root/FoodImg/food:_3_1602231552468.jpg', NULL, 3);
INSERT INTO `food_menu` VALUES ('乔丹', '张飞', '5', '肥肠', '/root/FoodImg/food:_3_1602232129442.jpg', NULL, 3);
INSERT INTO `food_menu` VALUES ('adizero', '让你跑的更快更远', '100', '跑鞋', '/root/FoodImg/food:_4_1605771773414.jpg', NULL, 4);
INSERT INTO `food_menu` VALUES ('波斯顿9', '跑得快', '500', '跑鞋', '/root/FoodImg/food:_3_1606029127717.jpg', NULL, 3);

-- ----------------------------
-- Table structure for muser
-- ----------------------------
DROP TABLE IF EXISTS `muser`;
CREATE TABLE `muser`  (
  `uname` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unickname` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `upassword` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `usex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ubirthday` date NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of muser
-- ----------------------------
INSERT INTO `muser` VALUES ('123', '', 'upassword', '男', NULL);
INSERT INTO `muser` VALUES ('123', '', 'upassword', '男', NULL);

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment`  (
  `food_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `food_price` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shop_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `total_price` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `oid` int(11) NULL DEFAULT NULL,
  `user_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shop_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of payment
-- ----------------------------
INSERT INTO `payment` VALUES ('狼牙土豆', '10元', '土豆王', '10', 1, '17', '1');
INSERT INTO `payment` VALUES ('麻辣兔丁', '22元', '兔子餐厅', '54', 2, '17', '0');
INSERT INTO `payment` VALUES ('爆炒兔腰', '32元', '兔子餐厅', '54', 2, '17', '0');
INSERT INTO `payment` VALUES ('披萨', '28元', '土豆王', '60.0', 3, '17', '1');
INSERT INTO `payment` VALUES ('汉堡', '20元', '土豆王', '60.0', 3, '17', '1');
INSERT INTO `payment` VALUES ('锅巴土豆', '12元', '土豆王', '60.0', 3, '17', '1');
INSERT INTO `payment` VALUES ('汉堡', '20元', '土豆王', '48.0', 4, '17', '1');
INSERT INTO `payment` VALUES ('披萨', '28元', '土豆王', '48.0', 4, '17', '1');
INSERT INTO `payment` VALUES ('披萨', '28元', '土豆王', '84.0', 5, '17', '1');
INSERT INTO `payment` VALUES ('汉堡', '20元', '土豆王', '84.0', 5, '17', '1');
INSERT INTO `payment` VALUES ('锅巴土豆', '12元', '土豆王', '84.0', 5, '17', '1');
INSERT INTO `payment` VALUES ('锅巴土豆', '12元', '土豆王', '84.0', 5, '17', '1');
INSERT INTO `payment` VALUES ('锅巴土豆', '12元', '土豆王', '84.0', 5, '17', '1');
INSERT INTO `payment` VALUES ('爆炒兔腰', '32元', '兔子餐厅', '95.0', 6, '17', '0');
INSERT INTO `payment` VALUES ('干锅兔', '18元', '兔子餐厅', '95.0', 6, '17', '0');
INSERT INTO `payment` VALUES ('麻辣兔头', '23元', '兔子餐厅', '95.0', 6, '17', '0');
INSERT INTO `payment` VALUES ('麻辣兔丁', '22元', '兔子餐厅', '95.0', 6, '17', '0');
INSERT INTO `payment` VALUES ('锅巴土豆', '12元', '土豆王', '24.0', 7, '17', '1');
INSERT INTO `payment` VALUES ('锅巴土豆', '12元', '土豆王', '24.0', 7, '17', '1');
INSERT INTO `payment` VALUES ('麻辣兔丁', '22元', '兔子餐厅', '76.0', 8, '17', '0');
INSERT INTO `payment` VALUES ('麻辣兔丁', '22元', '兔子餐厅', '76.0', 8, '17', '0');
INSERT INTO `payment` VALUES ('爆炒兔腰', '32元', '兔子餐厅', '76.0', 8, '17', '0');
INSERT INTO `payment` VALUES ('狼牙土豆', '10元', '土豆王', '62.0', 9, '17', '1');
INSERT INTO `payment` VALUES ('锅巴土豆', '12元', '土豆王', '62.0', 9, '17', '1');
INSERT INTO `payment` VALUES ('汉堡', '20元', '土豆王', '62.0', 9, '17', '1');
INSERT INTO `payment` VALUES ('汉堡', '20元', '土豆王', '62.0', 9, '17', '1');
INSERT INTO `payment` VALUES ('汉堡', '20元', '土豆王', '40.0', 10, '17', '1');
INSERT INTO `payment` VALUES ('汉堡', '20元', '土豆王', '40.0', 10, '17', '1');
INSERT INTO `payment` VALUES ('锅巴土豆', '12元', '土豆王', '24.0', 11, '17', '1');
INSERT INTO `payment` VALUES ('锅巴土豆', '12元', '土豆王', '24.0', 11, '17', '1');
INSERT INTO `payment` VALUES ('狼牙土豆', '10元', '土豆王', '22.0', 12, '17', '1');
INSERT INTO `payment` VALUES ('锅巴土豆', '12元', '土豆王', '22.0', 12, '17', '1');
INSERT INTO `payment` VALUES ('狼牙土豆', '10元', '土豆王', '20.0', 13, '26', '1');
INSERT INTO `payment` VALUES ('狼牙土豆', '10元', '土豆王', '20.0', 13, '26', '1');
INSERT INTO `payment` VALUES ('狼牙土豆', '10元', '土豆王', '22.0', 14, '27', '1');
INSERT INTO `payment` VALUES ('锅巴土豆', '12元', '土豆王', '22.0', 14, '27', '1');
INSERT INTO `payment` VALUES ('狼牙土豆', '10元', '土豆王', '32.0', 15, '27', '1');
INSERT INTO `payment` VALUES ('锅巴土豆', '12元', '土豆王', '32.0', 15, '27', '1');
INSERT INTO `payment` VALUES ('狼牙土豆', '10元', '土豆王', '32.0', 15, '27', '1');
INSERT INTO `payment` VALUES ('干锅兔', '18元', '兔子餐厅', '77.0', 16, '27', '0');
INSERT INTO `payment` VALUES ('麻辣兔头', '23元', '兔子餐厅', '77.0', 16, '27', '0');
INSERT INTO `payment` VALUES ('干锅兔', '18元', '兔子餐厅', '77.0', 16, '27', '0');
INSERT INTO `payment` VALUES ('干锅兔', '18元', '兔子餐厅', '77.0', 16, '27', '0');
INSERT INTO `payment` VALUES ('狼牙土豆', '10元', '土豆王', '40.0', 17, '27', '1');
INSERT INTO `payment` VALUES ('汉堡', '20元', '土豆王', '40.0', 17, '27', '1');
INSERT INTO `payment` VALUES ('狼牙土豆', '10元', '土豆王', '40.0', 17, '27', '1');
INSERT INTO `payment` VALUES ('狼牙土豆', '10元', '土豆王', '44.0', 18, '27', '1');
INSERT INTO `payment` VALUES ('狼牙土豆', '10元', '土豆王', '44.0', 18, '27', '1');
INSERT INTO `payment` VALUES ('锅巴土豆', '12元', '土豆王', '44.0', 18, '27', '1');
INSERT INTO `payment` VALUES ('锅巴土豆', '12元', '土豆王', '44.0', 18, '27', '1');
INSERT INTO `payment` VALUES ('狼牙土豆', '10元', '土豆王', '77.0', 19, '28', '1');
INSERT INTO `payment` VALUES ('锅巴土豆', '12元', '土豆王', '77.0', 19, '28', '1');
INSERT INTO `payment` VALUES ('油炸', '25元', '土豆王', '77.0', 19, '28', '1');
INSERT INTO `payment` VALUES ('狼牙土豆', '10元', '土豆王', '77.0', 19, '28', '1');
INSERT INTO `payment` VALUES ('汉堡', '20元', '土豆王', '77.0', 19, '28', '1');
INSERT INTO `payment` VALUES ('披萨', '28元', '土豆王', '93.0', 20, '30', '1');
INSERT INTO `payment` VALUES ('油炸', '25元', '土豆王', '93.0', 20, '30', '1');
INSERT INTO `payment` VALUES ('汉堡', '20元', '土豆王', '93.0', 20, '30', '1');
INSERT INTO `payment` VALUES ('汉堡', '20元', '土豆王', '93.0', 20, '30', '1');
INSERT INTO `payment` VALUES ('干锅兔', '18元', '兔子餐厅', '73.0', 21, '30', '0');
INSERT INTO `payment` VALUES ('麻辣兔头', '23元', '兔子餐厅', '73.0', 21, '30', '0');
INSERT INTO `payment` VALUES ('爆炒兔腰', '32元', '兔子餐厅', '73.0', 21, '30', '0');
INSERT INTO `payment` VALUES ('锅巴土豆', '12元', '土豆王', '77.0', 22, '31', '1');
INSERT INTO `payment` VALUES ('汉堡', '20元', '土豆王', '77.0', 22, '31', '1');
INSERT INTO `payment` VALUES ('汉堡', '20元', '土豆王', '77.0', 22, '31', '1');
INSERT INTO `payment` VALUES ('油炸', '25元', '土豆王', '77.0', 22, '31', '1');
INSERT INTO `payment` VALUES ('麻辣兔头', '23元', '兔子餐厅', '59.0', 23, '31', '0');
INSERT INTO `payment` VALUES ('干锅兔', '18元', '兔子餐厅', '59.0', 23, '31', '0');
INSERT INTO `payment` VALUES ('干锅兔', '18元', '兔子餐厅', '59.0', 23, '31', '0');
INSERT INTO `payment` VALUES ('汉堡', '20元', '土豆王', '52.0', 24, '31', '1');
INSERT INTO `payment` VALUES ('狼牙土豆', '10元', '土豆王', '52.0', 24, '31', '1');
INSERT INTO `payment` VALUES ('狼牙土豆', '10元', '土豆王', '52.0', 24, '31', '1');
INSERT INTO `payment` VALUES ('锅巴土豆', '12元', '土豆王', '52.0', 24, '31', '1');
INSERT INTO `payment` VALUES ('干锅兔', '18元', '兔子餐厅', '104.0', 25, '31', '0');
INSERT INTO `payment` VALUES ('麻辣兔头', '23元', '兔子餐厅', '104.0', 25, '31', '0');
INSERT INTO `payment` VALUES ('干锅兔', '18元', '兔子餐厅', '104.0', 25, '31', '0');
INSERT INTO `payment` VALUES ('麻辣兔丁', '22元', '兔子餐厅', '104.0', 25, '31', '0');
INSERT INTO `payment` VALUES ('麻辣兔头', '23元', '兔子餐厅', '104.0', 25, '31', '0');
INSERT INTO `payment` VALUES ('狼牙土豆', '10元', '土豆王', '0.0', 26, '33', '1');
INSERT INTO `payment` VALUES ('狼牙土豆', '10元', '土豆王', '0.0', 26, '33', '1');
INSERT INTO `payment` VALUES ('锅巴土豆', '12元', '土豆王', '0.0', 26, '33', '1');
INSERT INTO `payment` VALUES ('干锅兔', '18元', '兔子餐厅', '91.0', 27, '33', '0');
INSERT INTO `payment` VALUES ('爆炒兔腰', '32元', '兔子餐厅', '91.0', 27, '33', '0');
INSERT INTO `payment` VALUES ('干锅兔', '18元', '兔子餐厅', '91.0', 27, '33', '0');
INSERT INTO `payment` VALUES ('麻辣兔头', '23元', '兔子餐厅', '91.0', 27, '33', '0');
INSERT INTO `payment` VALUES ('狼牙土豆', '10元', '土豆王', '42.0', 28, '33', '1');
INSERT INTO `payment` VALUES ('锅巴土豆', '12元', '土豆王', '42.0', 28, '33', '1');
INSERT INTO `payment` VALUES ('狼牙土豆', '10元', '土豆王', '42.0', 28, '33', '1');
INSERT INTO `payment` VALUES ('狼牙土豆', '10元', '土豆王', '42.0', 28, '33', '1');
INSERT INTO `payment` VALUES ('狼牙土豆', '10元', '土豆王', '64.0', 29, '33', '1');
INSERT INTO `payment` VALUES ('锅巴土豆', '12元', '土豆王', '64.0', 29, '33', '1');
INSERT INTO `payment` VALUES ('狼牙土豆', '10元', '土豆王', '64.0', 29, '33', '1');
INSERT INTO `payment` VALUES ('汉堡', '20元', '土豆王', '64.0', 29, '33', '1');
INSERT INTO `payment` VALUES ('锅巴土豆', '12元', '土豆王', '64.0', 29, '33', '1');
INSERT INTO `payment` VALUES ('狼牙土豆', '10元', '土豆王', '32.0', 30, '33', '1');
INSERT INTO `payment` VALUES ('锅巴土豆', '12元', '土豆王', '32.0', 30, '33', '1');
INSERT INTO `payment` VALUES ('狼牙土豆', '10元', '土豆王', '32.0', 30, '33', '1');
INSERT INTO `payment` VALUES ('油炸', '25元', '土豆王', '25.0', 31, '33', '1');
INSERT INTO `payment` VALUES ('披萨', '28元', '土豆王', '28.0', 37, '28', '1');
INSERT INTO `payment` VALUES ('披萨', '28元', '土豆王', '53.0', 39, '28', '1');
INSERT INTO `payment` VALUES ('油炸', '25元', '土豆王', '53.0', 39, '28', '1');
INSERT INTO `payment` VALUES ('锅巴土豆', '12元', '土豆王', '72.0', 40, '28', '1');
INSERT INTO `payment` VALUES ('汉堡', '20元', '土豆王', '72.0', 40, '28', '1');
INSERT INTO `payment` VALUES ('锅巴土豆', '12元', '土豆王', '72.0', 40, '28', '1');
INSERT INTO `payment` VALUES ('披萨', '28元', '土豆王', '72.0', 40, '28', '1');
INSERT INTO `payment` VALUES ('干锅兔', '18元', '兔子餐厅', '36.0', 41, '28', '2');
INSERT INTO `payment` VALUES ('干锅兔', '18元', '兔子餐厅', '36.0', 41, '28', '2');
INSERT INTO `payment` VALUES ('乔丹', '5', '123', '6.0', 42, '28', '3');
INSERT INTO `payment` VALUES ('憨憨', '1', '123', '6.0', 42, '28', '3');
INSERT INTO `payment` VALUES ('狼牙土豆', '10元', '土豆王', '20.0', 43, '28', '1');
INSERT INTO `payment` VALUES ('狼牙土豆', '10元', '土豆王', '20.0', 43, '28', '1');
INSERT INTO `payment` VALUES ('干锅兔', '18元', '兔子餐厅', '54.0', 44, '28', '2');
INSERT INTO `payment` VALUES ('干锅兔', '18元', '兔子餐厅', '54.0', 44, '28', '2');
INSERT INTO `payment` VALUES ('干锅兔', '18元', '兔子餐厅', '54.0', 44, '28', '2');
INSERT INTO `payment` VALUES ('锅巴土豆', '12', NULL, '34.0', 59, '28', '1');
INSERT INTO `payment` VALUES ('锅巴土豆', '12', NULL, '34.0', 59, '28', '1');
INSERT INTO `payment` VALUES ('狼牙土豆', '10', NULL, '34.0', 59, '28', '1');
INSERT INTO `payment` VALUES ('麻辣兔丁', '22', NULL, '104.0', 60, '28', '2');
INSERT INTO `payment` VALUES ('麻辣兔头', '23', NULL, '104.0', 60, '28', '2');
INSERT INTO `payment` VALUES ('干锅兔', '18', NULL, '104.0', 60, '28', '2');
INSERT INTO `payment` VALUES ('干锅兔', '18', NULL, '104.0', 60, '28', '2');
INSERT INTO `payment` VALUES ('麻辣兔头', '23', NULL, '104.0', 61, '28', '2');
INSERT INTO `payment` VALUES ('麻辣兔丁', '22', NULL, '104.0', 61, '28', '2');
INSERT INTO `payment` VALUES ('麻辣兔头', '23', NULL, '104.0', 61, '28', '2');
INSERT INTO `payment` VALUES ('干锅兔', '18', NULL, '104.0', 61, '28', '2');
INSERT INTO `payment` VALUES ('麻辣兔头', '23', NULL, '104.0', 60, '28', '2');
INSERT INTO `payment` VALUES ('干锅兔', '18', NULL, '104.0', 61, '28', '2');
INSERT INTO `payment` VALUES ('干锅兔', '18', NULL, '54.0', 62, '28', '2');
INSERT INTO `payment` VALUES ('干锅兔', '18', NULL, '54.0', 62, '28', '2');
INSERT INTO `payment` VALUES ('干锅兔', '18', NULL, '54.0', 62, '28', '2');

-- ----------------------------
-- Table structure for seller_info
-- ----------------------------
DROP TABLE IF EXISTS `seller_info`;
CREATE TABLE `seller_info`  (
  `shop_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sell_amount` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of seller_info
-- ----------------------------
INSERT INTO `seller_info` VALUES ('1', '17', '40');
INSERT INTO `seller_info` VALUES (NULL, '28', NULL);

-- ----------------------------
-- Table structure for shop_info
-- ----------------------------
DROP TABLE IF EXISTS `shop_info`;
CREATE TABLE `shop_info`  (
  `shop_id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shop_image_addr` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shop_image` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shop_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `grade` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`shop_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of shop_info
-- ----------------------------
INSERT INTO `shop_info` VALUES (1, '土豆王', '/root/img/test.jpg', NULL, '17', '零食', '3.5');
INSERT INTO `shop_info` VALUES (2, '兔子餐厅', '/root/img/tuzi.jpg', NULL, '17', '中餐', '3.8333333');
INSERT INTO `shop_info` VALUES (3, '123', '/root/img/_28_123_1601536447118.jpg', NULL, '28', '123', '4.5');
INSERT INTO `shop_info` VALUES (4, '阿迪达斯', '/root/img/_28_阿迪达斯_1605771647273.jpg', NULL, '28', '服装', NULL);
INSERT INTO `shop_info` VALUES (5, '索康尼', '/root/img/_28_索康尼_1606029071235.jpg', NULL, '28', '鞋子', NULL);

-- ----------------------------
-- Table structure for socket_info
-- ----------------------------
DROP TABLE IF EXISTS `socket_info`;
CREATE TABLE `socket_info`  (
  `socket_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `image64_addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `image64` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`socket_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of socket_info
-- ----------------------------
INSERT INTO `socket_info` VALUES ('1111', '厨房的插座', '/root/SocketImg/socket:_1_1604453217050.jpg', NULL);
INSERT INTO `socket_info` VALUES ('2222', 'hello', '/root/SocketImg/socket:_1_1604453217050.jpg', NULL);

-- ----------------------------
-- Table structure for suggestion
-- ----------------------------
DROP TABLE IF EXISTS `suggestion`;
CREATE TABLE `suggestion`  (
  `id` int(11) NOT NULL,
  `content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of suggestion
-- ----------------------------

-- ----------------------------
-- Table structure for totaloid
-- ----------------------------
DROP TABLE IF EXISTS `totaloid`;
CREATE TABLE `totaloid`  (
  `oid` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of totaloid
-- ----------------------------
INSERT INTO `totaloid` VALUES (62);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_img` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `uname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录用户名',
  `unickname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `headimg` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像图片',
  `upassword` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `usex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户性别',
  `user_img_addr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ubirthday` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pay_password` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户资料表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (NULL, 17, '123', '123', NULL, '123', NULL, NULL, '1970-01-01', '123');
INSERT INTO `user` VALUES (NULL, 18, 'psd', 'psd', NULL, '123', NULL, NULL, '1999-12-26', '123');
INSERT INTO `user` VALUES (NULL, 19, 'ppp', '', NULL, '123', NULL, NULL, NULL, '123');
INSERT INTO `user` VALUES (NULL, 20, 'q', '', NULL, '1', NULL, NULL, '19991229', '123');
INSERT INTO `user` VALUES (NULL, 22, 'qqq', '', NULL, '123', NULL, NULL, NULL, '123');
INSERT INTO `user` VALUES (NULL, 23, '123123', '', NULL, '123', NULL, NULL, NULL, '123');
INSERT INTO `user` VALUES (NULL, 26, 'zxc', '', NULL, '123', NULL, NULL, '111', 'zxc');
INSERT INTO `user` VALUES (NULL, 27, 'lll', '123', NULL, '123123', NULL, NULL, NULL, '123123');
INSERT INTO `user` VALUES (NULL, 28, 'q123', 'psd', NULL, '123', NULL, '/root/UserImg/userimg:_28_1602762830638.jpg', NULL, '123123');
INSERT INTO `user` VALUES (NULL, 29, '123', '', NULL, '123', NULL, NULL, NULL, '123');
INSERT INTO `user` VALUES (NULL, 30, '999', '123', NULL, '123', NULL, NULL, NULL, '123123');
INSERT INTO `user` VALUES (NULL, 31, '369', '123', NULL, '123', NULL, NULL, NULL, '123123');
INSERT INTO `user` VALUES (NULL, 32, '369', '', NULL, '123', NULL, NULL, NULL, '123');
INSERT INTO `user` VALUES (NULL, 33, '2062', '', NULL, '123', NULL, NULL, NULL, '123123');
INSERT INTO `user` VALUES (NULL, 35, '\'12356789\'', '', NULL, '\'123\'', NULL, NULL, NULL, '123');
INSERT INTO `user` VALUES (NULL, 36, '\'bbb\'', '', NULL, '\'bbb\'', NULL, NULL, NULL, '123');
INSERT INTO `user` VALUES (NULL, 37, '\'123\'', '', NULL, '\'123\'', NULL, NULL, NULL, '123');
INSERT INTO `user` VALUES (NULL, 38, 'mmm', '', NULL, 'mmm', NULL, NULL, NULL, '123');
INSERT INTO `user` VALUES (NULL, 39, 'zxc7', '', NULL, '123', NULL, NULL, NULL, '123');
INSERT INTO `user` VALUES (NULL, 40, 'ty', '', NULL, 'df', NULL, '/root/UserImg/_ty_1600951296136.jpg', NULL, '123');
INSERT INTO `user` VALUES (NULL, 41, 'vb', '', NULL, '123', NULL, '/root/UserImg/_vb_1600952362278.jpg', NULL, '123');
INSERT INTO `user` VALUES (NULL, 42, '...', '', NULL, '123', NULL, '/root/UserImg/_... _1601445520727.jpg', NULL, '123');

-- ----------------------------
-- Table structure for user_comment
-- ----------------------------
DROP TABLE IF EXISTS `user_comment`;
CREATE TABLE `user_comment`  (
  `user_pic_addr` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_pic` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `new_comment` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shop_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `grade` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comment_img` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comment_img_addr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_comment
-- ----------------------------
INSERT INTO `user_comment` VALUES (NULL, NULL, '1235', '1', '28', '2.5', NULL, '/root/CommentImg/_1_28_1601290457667.jpg');
INSERT INTO `user_comment` VALUES (NULL, NULL, '122', '1', '28', '5.0', NULL, '/root/CommentImg/_1_28_1601469475630.jpg');
INSERT INTO `user_comment` VALUES (NULL, NULL, '还可以', '1', '28', '5.0', NULL, '/root/CommentImg/_1_28_1602759004908.jpg');
INSERT INTO `user_comment` VALUES (NULL, NULL, '册子', '2', '28', '5.0', NULL, '/root/CommentImg/_2_28_1602760306926.jpg');
INSERT INTO `user_comment` VALUES (NULL, NULL, '可以', '3', '28', '3.5', NULL, '/root/CommentImg/_3_28_1602831442843.jpg');
INSERT INTO `user_comment` VALUES (NULL, NULL, 'Hacemos千分', '1', '28', '3.0', NULL, '/root/CommentImg/_1_28_1606013333191.jpg');
INSERT INTO `user_comment` VALUES (NULL, NULL, '卡本提哈本土', '2', '28', '4.0', NULL, '/root/CommentImg/_2_28_1606013695658.jpg');
INSERT INTO `user_comment` VALUES (NULL, NULL, '11111', '1', '28', '2.0', NULL, '/root/CommentImg/_1_28_1606013802608.jpg');
INSERT INTO `user_comment` VALUES (NULL, NULL, '11111', '2', '28', '2.5', NULL, '/root/CommentImg/_2_28_1606013845975.jpg');

-- ----------------------------
-- Table structure for user_favorite_shop
-- ----------------------------
DROP TABLE IF EXISTS `user_favorite_shop`;
CREATE TABLE `user_favorite_shop`  (
  `user_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shop_id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shop_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_favorite_shop
-- ----------------------------
INSERT INTO `user_favorite_shop` VALUES ('17', '1', '土豆王');
INSERT INTO `user_favorite_shop` VALUES ('26', '1', '土豆王');
INSERT INTO `user_favorite_shop` VALUES ('27', '1', '土豆王');
INSERT INTO `user_favorite_shop` VALUES ('27', '0', '兔子餐厅');
INSERT INTO `user_favorite_shop` VALUES ('30', '1', '土豆王');
INSERT INTO `user_favorite_shop` VALUES ('30', '0', '兔子餐厅');
INSERT INTO `user_favorite_shop` VALUES ('31', '0', '兔子餐厅');
INSERT INTO `user_favorite_shop` VALUES ('31', '1', '土豆王');
INSERT INTO `user_favorite_shop` VALUES ('33', '1', '土豆王');
INSERT INTO `user_favorite_shop` VALUES ('33', '0', '兔子餐厅');
INSERT INTO `user_favorite_shop` VALUES ('17', '0', '兔子餐厅');
INSERT INTO `user_favorite_shop` VALUES ('28', '3', '123');
INSERT INTO `user_favorite_shop` VALUES ('28', '2', '兔子餐厅');
INSERT INTO `user_favorite_shop` VALUES ('28', '1', '土豆王');

SET FOREIGN_KEY_CHECKS = 1;
