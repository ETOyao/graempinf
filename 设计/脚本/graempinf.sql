/*
Navicat MySQL Data Transfer

Source Server         : localhostconnect
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : graempinf

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-04-08 22:23:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_basecode
-- ----------------------------
DROP TABLE IF EXISTS `t_basecode`;
CREATE TABLE `t_basecode` (
  `baseCodeUUid` varchar(255) NOT NULL,
  `baseCodeType` varchar(255) DEFAULT NULL,
  `baseCodeTypeName` varchar(255) DEFAULT NULL,
  `baseCodekey` varchar(255) DEFAULT NULL,
  `isTrue` int(11) DEFAULT NULL,
  `keyValue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`baseCodeUUid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_basecode
-- ----------------------------
INSERT INTO `t_basecode` VALUES ('910aabe1-0a59-11e7-97e8-d481d78cb8f5', '1001', '单位性质', '10', '1', '机关');
INSERT INTO `t_basecode` VALUES ('910ccc34-0a59-11e7-97e8-d481d78cb8f5', '1001', '单位性质', '11', '1', '科研设计单位');
INSERT INTO `t_basecode` VALUES ('910ecbb4-0a59-11e7-97e8-d481d78cb8f5', '1001', '单位性质', '12', '1', '高等教育单位');
INSERT INTO `t_basecode` VALUES ('9110d24d-0a59-11e7-97e8-d481d78cb8f5', '1001', '单位性质', '13', '1', '中初教育单位');
INSERT INTO `t_basecode` VALUES ('911283e5-0a59-11e7-97e8-d481d78cb8f5', '1001', '单位性质', '14', '1', '医疗卫生单位');
INSERT INTO `t_basecode` VALUES ('91147c91-0a59-11e7-97e8-d481d78cb8f5', '1001', '单位性质', '15', '1', '其他事业单位');
INSERT INTO `t_basecode` VALUES ('91164b32-0a59-11e7-97e8-d481d78cb8f5', '1001', '单位性质', '16', '1', '国有企业');
INSERT INTO `t_basecode` VALUES ('911853e3-0a59-11e7-97e8-d481d78cb8f5', '1001', '单位性质', '17', '1', '三资企业');
INSERT INTO `t_basecode` VALUES ('911a2da2-0a59-11e7-97e8-d481d78cb8f5', '1001', '单位性质', '18', '1', '其他企业');
INSERT INTO `t_basecode` VALUES ('911c2353-0a59-11e7-97e8-d481d78cb8f5', '1001', '单位性质', '19', '1', '部队');
INSERT INTO `t_basecode` VALUES ('911dde03-0a59-11e7-97e8-d481d78cb8f5', '1001', '单位性质', '20', '1', '农村建制村');
INSERT INTO `t_basecode` VALUES ('911fcd9b-0a59-11e7-97e8-d481d78cb8f5', '1001', '单位性质', '21', '1', '城镇社区');
INSERT INTO `t_basecode` VALUES ('9121b575-0a59-11e7-97e8-d481d78cb8f5', '1001', '单位性质', '22', '1', '其他');
INSERT INTO `t_basecode` VALUES ('9124c35c-0a59-11e7-97e8-d481d78cb8f5', '1002', '单位行业', '23', '1', '农、林、牧、渔业');
INSERT INTO `t_basecode` VALUES ('91274c7d-0a59-11e7-97e8-d481d78cb8f5', '1002', '单位行业', '23', '1', '采矿业');
INSERT INTO `t_basecode` VALUES ('9129447c-0a59-11e7-97e8-d481d78cb8f5', '1002', '单位行业', '24', '1', '制造业');
INSERT INTO `t_basecode` VALUES ('912b5093-0a59-11e7-97e8-d481d78cb8f5', '1002', '单位行业', '25', '1', '电力、热力、燃气及水生产和供应业');
INSERT INTO `t_basecode` VALUES ('912d3461-0a59-11e7-97e8-d481d78cb8f5', '1002', '单位行业', '26', '1', '批发和零售业');
INSERT INTO `t_basecode` VALUES ('912f1132-0a59-11e7-97e8-d481d78cb8f5', '1002', '单位行业', '27', '1', '交通运输、仓储和邮政业');
INSERT INTO `t_basecode` VALUES ('9130ee58-0a59-11e7-97e8-d481d78cb8f5', '1002', '单位行业', '28', '1', '住宿和餐饮业');
INSERT INTO `t_basecode` VALUES ('91331475-0a59-11e7-97e8-d481d78cb8f5', '1002', '单位行业', '29', '1', '信息传输、软件和信息技术服务业');
INSERT INTO `t_basecode` VALUES ('9135a61a-0a59-11e7-97e8-d481d78cb8f5', '1002', '单位行业', '30', '1', '金融业');
INSERT INTO `t_basecode` VALUES ('9137e3e7-0a59-11e7-97e8-d481d78cb8f5', '1002', '单位行业', '31', '1', '房地产业');
INSERT INTO `t_basecode` VALUES ('9139ee0d-0a59-11e7-97e8-d481d78cb8f5', '1002', '单位行业', '32', '1', '租赁和商务服务业');
INSERT INTO `t_basecode` VALUES ('913bc173-0a59-11e7-97e8-d481d78cb8f5', '1002', '单位行业', '33', '1', '科学研究和技术服务业');
INSERT INTO `t_basecode` VALUES ('913d7ff3-0a59-11e7-97e8-d481d78cb8f5', '1002', '单位行业', '34', '1', '居民服务、修理和其他服务业');
INSERT INTO `t_basecode` VALUES ('913f8acd-0a59-11e7-97e8-d481d78cb8f5', '1002', '单位行业', '35', '1', '水利、环境和公共设施管理业');
INSERT INTO `t_basecode` VALUES ('91416313-0a59-11e7-97e8-d481d78cb8f5', '1002', '单位行业', '36', '1', '教育');
INSERT INTO `t_basecode` VALUES ('91436199-0a59-11e7-97e8-d481d78cb8f5', '1002', '单位行业', '37', '1', '卫生和社会工作');
INSERT INTO `t_basecode` VALUES ('9145520c-0a59-11e7-97e8-d481d78cb8f5', '1002', '单位行业', '38', '1', '文化、体育和娱乐业');
INSERT INTO `t_basecode` VALUES ('91471f49-0a59-11e7-97e8-d481d78cb8f5', '1002', '单位行业', '39', '1', '公共管理、社会保障和社会组织');
INSERT INTO `t_basecode` VALUES ('914922ac-0a59-11e7-97e8-d481d78cb8f5', '1002', '单位行业', '40', '1', '国际组织');
INSERT INTO `t_basecode` VALUES ('914af35e-0a59-11e7-97e8-d481d78cb8f5', '1002', '单位行业', '41', '1', '军队');
INSERT INTO `t_basecode` VALUES ('914cce2d-0a59-11e7-97e8-d481d78cb8f5', '1003', '职位类别', '42', '1', '公务员');
INSERT INTO `t_basecode` VALUES ('914ec8e6-0a59-11e7-97e8-d481d78cb8f5', '1003', '职位类别', '43', '1', '科学研究人员');
INSERT INTO `t_basecode` VALUES ('915067d4-0a59-11e7-97e8-d481d78cb8f5', '1003', '职位类别', '44', '1', '工程技术人员');
INSERT INTO `t_basecode` VALUES ('915220d6-0a59-11e7-97e8-d481d78cb8f5', '1003', '职位类别', '45', '1', '农林牧渔业技术人员');
INSERT INTO `t_basecode` VALUES ('9153fce5-0a59-11e7-97e8-d481d78cb8f5', '1003', '职位类别', '46', '1', '卫生专业技术人员');
INSERT INTO `t_basecode` VALUES ('9155b9a6-0a59-11e7-97e8-d481d78cb8f5', '1003', '职位类别', '47', '1', '经济业务人员');
INSERT INTO `t_basecode` VALUES ('91577dd3-0a59-11e7-97e8-d481d78cb8f5', '1003', '职位类别', '48', '1', '金融业务人员');
INSERT INTO `t_basecode` VALUES ('9159913b-0a59-11e7-97e8-d481d78cb8f5', '1003', '职位类别', '49', '1', '法律专业人员');
INSERT INTO `t_basecode` VALUES ('915b78ee-0a59-11e7-97e8-d481d78cb8f5', '1003', '职位类别', '50', '1', '教学人员');
INSERT INTO `t_basecode` VALUES ('915d501d-0a59-11e7-97e8-d481d78cb8f5', '1003', '职位类别', '51', '1', '文学艺术工作人员');
INSERT INTO `t_basecode` VALUES ('915ee85e-0a59-11e7-97e8-d481d78cb8f5', '1003', '职位类别', '52', '1', '体育工作人员');
INSERT INTO `t_basecode` VALUES ('9160b601-0a59-11e7-97e8-d481d78cb8f5', '1003', '职位类别', '53', '1', '新闻出版和文化工作人员');
INSERT INTO `t_basecode` VALUES ('916264e3-0a59-11e7-97e8-d481d78cb8f5', '1003', '职位类别', '54', '1', '其他专业技术人员');
INSERT INTO `t_basecode` VALUES ('9164002b-0a59-11e7-97e8-d481d78cb8f5', '1003', '职位类别', '55', '1', '办事人员和有关人员');
INSERT INTO `t_basecode` VALUES ('9165dafd-0a59-11e7-97e8-d481d78cb8f5', '1003', '职位类别', '56', '1', '生产和运输设备操作人员');
INSERT INTO `t_basecode` VALUES ('9167a603-0a59-11e7-97e8-d481d78cb8f5', '1003', '职位类别', '57', '1', '军人');
INSERT INTO `t_basecode` VALUES ('9169255f-0a59-11e7-97e8-d481d78cb8f5', '1003', '职位类别', '58', '1', '其他人员');
INSERT INTO `t_basecode` VALUES ('916ad26c-0a59-11e7-97e8-d481d78cb8f5', '1004', '毕业去向', '59', '1', '签就业协议形式就业');
INSERT INTO `t_basecode` VALUES ('916ce762-0a59-11e7-97e8-d481d78cb8f5', '1004', '毕业去向', '60', '1', '签劳动合同形式就业');
INSERT INTO `t_basecode` VALUES ('916e9941-0a59-11e7-97e8-d481d78cb8f5', '1004', '毕业去向', '61', '1', '其他录用形式就业');
INSERT INTO `t_basecode` VALUES ('917076b8-0a59-11e7-97e8-d481d78cb8f5', '1004', '毕业去向', '61', '1', '科研助理');
INSERT INTO `t_basecode` VALUES ('9172518e-0a59-11e7-97e8-d481d78cb8f5', '1004', '毕业去向', '63', '1', '应征义务兵');
INSERT INTO `t_basecode` VALUES ('917434f2-0a59-11e7-97e8-d481d78cb8f5', '1004', '毕业去向', '64', '1', '国家基层项目');
INSERT INTO `t_basecode` VALUES ('9175e2d2-0a59-11e7-97e8-d481d78cb8f5', '1004', '毕业去向', '65', '1', '地方基层项目');
INSERT INTO `t_basecode` VALUES ('9177cdf3-0a59-11e7-97e8-d481d78cb8f5', '1004', '毕业去向', '66', '1', '自主创业');
INSERT INTO `t_basecode` VALUES ('91799747-0a59-11e7-97e8-d481d78cb8f5', '1004', '毕业去向', '67', '1', '自由职业');
INSERT INTO `t_basecode` VALUES ('917b3925-0a59-11e7-97e8-d481d78cb8f5', '1004', '毕业去向', '68', '1', '升学');
INSERT INTO `t_basecode` VALUES ('917d0fa0-0a59-11e7-97e8-d481d78cb8f5', '1004', '毕业去向', '69', '1', '出国、出境');

-- ----------------------------
-- Table structure for t_careefair
-- ----------------------------
DROP TABLE IF EXISTS `t_careefair`;
CREATE TABLE `t_careefair` (
  `careerFairUuid` varchar(255) NOT NULL,
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `careerFairAddr` varchar(255) DEFAULT NULL,
  `careerFairDesc` varchar(255) DEFAULT NULL,
  `careerFairName` varchar(255) DEFAULT NULL,
  `careerFairType` int(11) DEFAULT NULL,
  `careerFairTypeName` varchar(255) DEFAULT NULL,
  `careerFairUndertaker` varchar(255) DEFAULT NULL,
  `careerFairDate` date DEFAULT NULL,
  `careerPerson` varchar(225) DEFAULT NULL,
  `createCareerFairDate` date DEFAULT NULL,
  `finshStatus` int(11) DEFAULT NULL,
  `applayCareerFairDate` date DEFAULT NULL,
  `applyPerson` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`careerFairUuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_careefair
-- ----------------------------
INSERT INTO `t_careefair` VALUES ('402881e55b32c241015b333c72490002', null, null, null, '啥地方 ', '测试er', '测试2', '24', ' 制造业', '阿萨德', '2017-04-06', '管理员', '2017-04-03', '1', '2017-04-03', '管理员');
INSERT INTO `t_careefair` VALUES ('402881e55b32c241015b333d048f0003', null, null, null, '阿萨德 ', '阿斯蒂芬', '测试3', '30', ' 金融业', '按时 ', '2017-04-20', '管理员', '2017-04-03', '1', '2017-04-03', '管理员');
INSERT INTO `t_careefair` VALUES ('402881e55b32c241015b333d69ca0004', null, null, null, '按时', '阿萨德', '测试4', '26', ' 批发和零售业', '阿萨德 ', '2017-04-13', '管理员', '2017-04-03', '1', '2017-04-03', '管理员');
INSERT INTO `t_careefair` VALUES ('402881e55b32c241015b333da06c0005', null, null, null, '按时', '阿萨德 ', '测试5', '27', ' 交通运输、仓储和邮政业', '按时 ', '2017-04-27', '管理员', '2017-04-03', '1', '2017-04-03', '管理员');
INSERT INTO `t_careefair` VALUES ('402881e55b32c241015b333dd9280006', null, null, null, '啊大师傅', '阿萨德', '测试6', '25', '测试6', '阿萨德', '2017-04-27', '管理员', '2017-04-03', '1', '2017-04-03', '管理员');
INSERT INTO `t_careefair` VALUES ('402881e55b32c241015b333e39ae0007', null, null, null, '阿萨德', '阿斯蒂芬', '测试7', '38', ' 文化、体育和娱乐业', '阿萨德', '2017-04-29', '管理员', '2017-04-03', '1', '2017-04-03', '管理员');
INSERT INTO `t_careefair` VALUES ('402881e55b32c241015b333e73370008', null, null, null, '阿萨德', '阿萨德', '测试8', '26', ' 批发和零售业', '阿萨德 ', '2017-05-06', '管理员', '2017-04-03', '1', '2017-04-03', '管理员');
INSERT INTO `t_careefair` VALUES ('402881e55b32c241015b333ec14d0009', null, null, null, '阿萨德', '阿萨德', '测试9', '26', ' 批发和零售业', '阿萨德', '2017-04-21', '管理员', '2017-04-03', '1', '2017-04-03', '管理员');
INSERT INTO `t_careefair` VALUES ('402881e55b32c241015b333efa76000a', null, null, null, '阿萨德 ', '阿斯蒂芬', '测试10', '25', ' 电力、热力、燃气及水生产和供应业', '阿萨德', '2017-04-14', '管理员', '2017-04-03', '1', '2017-04-03', '管理员');
INSERT INTO `t_careefair` VALUES ('ff8080815b0ac403015b0ae0dd690001', null, null, null, 'e', '33afdsfdsfa asdf', '测试1', '27', '测试1', 'ddd', '2017-04-14', '管理员', '2017-03-26', '1', '2017-04-03', '管理员');

-- ----------------------------
-- Table structure for t_careefairappiontment
-- ----------------------------
DROP TABLE IF EXISTS `t_careefairappiontment`;
CREATE TABLE `t_careefairappiontment` (
  `capUUid` varchar(255) NOT NULL,
  `atrtr2` varchar(255) DEFAULT NULL,
  `attr1` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `capAdvice` varchar(255) DEFAULT NULL,
  `capAppCode` varchar(255) DEFAULT NULL,
  `capObject` varchar(255) DEFAULT NULL,
  `capstuName` varchar(255) DEFAULT NULL,
  `capstuNum` varchar(255) DEFAULT NULL,
  `capstuUuid` varchar(255) DEFAULT NULL,
  `careeFairName` varchar(255) DEFAULT NULL,
  `careeFairUuid` varchar(255) DEFAULT NULL,
  `finshStatus` int(11) DEFAULT NULL,
  `jobDirecttion1` varchar(255) DEFAULT NULL,
  `jobDirecttion2` varchar(255) DEFAULT NULL,
  `jobDirecttion3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`capUUid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_careefairappiontment
-- ----------------------------
INSERT INTO `t_careefairappiontment` VALUES ('402881e55b32c241015b33474d400019', null, '', null, 'fgsg', '2017040305274064', '', '王波', '1402130527', 'ff8080815aa71d44015aa735bc020000', '测试2', '402881e55b32c241015b333c72490002', '2', '', '', '');
INSERT INTO `t_careefairappiontment` VALUES ('402881e55b32c241015b33475b16001a', null, '', null, null, '2017040305276175', '', '王波', '1402130527', 'ff8080815aa71d44015aa735bc020000', '测试3', '402881e55b32c241015b333d048f0003', '1', '', '', '');
INSERT INTO `t_careefairappiontment` VALUES ('402881e55b32c241015b33477000001b', null, '', null, 'sd fasd', '2017040305273523', '', '王波', '1402130527', 'ff8080815aa71d44015aa735bc020000', '测试6', '402881e55b32c241015b333dd9280006', '0', '', '', '');
INSERT INTO `t_careefairappiontment` VALUES ('402881e55b32c241015b33477cff001c', null, '', null, null, '2017040305271062', '', '王波', '1402130527', 'ff8080815aa71d44015aa735bc020000', '测试5', '402881e55b32c241015b333da06c0005', '1', '', '', '');
INSERT INTO `t_careefairappiontment` VALUES ('402881e55b32c241015b33478b4f001d', null, '', null, null, '2017040305277813', '', '王波', '1402130527', 'ff8080815aa71d44015aa735bc020000', '测试8', '402881e55b32c241015b333e73370008', '1', '', '', '');
INSERT INTO `t_careefairappiontment` VALUES ('402881e55b32c241015b3347988f001e', null, '', null, null, '2017040305278571', '', '王波', '1402130527', 'ff8080815aa71d44015aa735bc020000', '测试4', '402881e55b32c241015b333d69ca0004', '1', '', '', '');
INSERT INTO `t_careefairappiontment` VALUES ('402881e55b32c241015b3347a888001f', null, '', null, null, '2017040305272453', '', '王波', '1402130527', 'ff8080815aa71d44015aa735bc020000', '测试9', '402881e55b32c241015b333ec14d0009', '1', '', '', '');
INSERT INTO `t_careefairappiontment` VALUES ('402881e55b32c241015b3347c1080020', null, '', null, null, '2017040305276715', '', '王波', '1402130527', 'ff8080815aa71d44015aa735bc020000', '测试10', '402881e55b32c241015b333efa76000a', '1', '', '', '');
INSERT INTO `t_careefairappiontment` VALUES ('402881e55b32c241015b3348b0270021', null, '18829012118', null, 'gdsf', '2017040305265148', '', '汪磊', '1402130526', '402881e65a98acf4015a98c3b7390009', '测试3', '402881e55b32c241015b333d048f0003', '0', '', '', '');
INSERT INTO `t_careefairappiontment` VALUES ('402881e55b32c241015b3348bcb60022', null, '18829012118', null, '就是取消', '2017040305261107', '', '汪磊', '1402130526', '402881e65a98acf4015a98c3b7390009', '测试2', '402881e55b32c241015b333c72490002', '0', '', '', '');
INSERT INTO `t_careefairappiontment` VALUES ('402881e55b32c241015b3348cb880023', null, '18829012118', null, 'asd f', '2017040305267877', '', '汪磊', '1402130526', '402881e65a98acf4015a98c3b7390009', '测试6', '402881e55b32c241015b333dd9280006', '2', '', '', '');
INSERT INTO `t_careefairappiontment` VALUES ('402881e55b32c241015b3348d8cf0024', null, '18829012118', null, null, '2017040305262406', '', '汪磊', '1402130526', '402881e65a98acf4015a98c3b7390009', '测试7', '402881e55b32c241015b333e39ae0007', '1', '', '', '');
INSERT INTO `t_careefairappiontment` VALUES ('402881e55b32c241015b3348e8180025', null, '18829012118', null, 'asd f', '2017040305268845', '', '汪磊', '1402130526', '402881e65a98acf4015a98c3b7390009', '测试10', '402881e55b32c241015b333efa76000a', '2', '', '', '');
INSERT INTO `t_careefairappiontment` VALUES ('402881e55b32c241015b334909180026', null, '18829012118', null, null, '2017040305266048', '', '汪磊', '1402130526', '402881e65a98acf4015a98c3b7390009', '测试5', '402881e55b32c241015b333da06c0005', '1', '', '', '');

-- ----------------------------
-- Table structure for t_channel
-- ----------------------------
DROP TABLE IF EXISTS `t_channel`;
CREATE TABLE `t_channel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `custom_link` int(11) DEFAULT NULL,
  `custom_link_url` varchar(255) DEFAULT NULL,
  `is_index` int(11) DEFAULT NULL,
  `is_top_nav` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `navOrder` int(11) NOT NULL,
  `orders` int(11) NOT NULL,
  `recommend` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `type` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKE79D703885ACFB5B` (`pid`),
  CONSTRAINT `FKE79D703885ACFB5B` FOREIGN KEY (`pid`) REFERENCES `t_channel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_channel
-- ----------------------------
INSERT INTO `t_channel` VALUES ('1', '0', '', '0', '0', '毕业生信息管理', '1', '1', '0', '0', '0', null);
INSERT INTO `t_channel` VALUES ('4', '0', 'admin/sst/ssts', '0', '0', '生源地信息管理', '0', '2', '0', '0', '0', '1');
INSERT INTO `t_channel` VALUES ('5', '0', 'admin/empinfo/empinfs', '0', '0', '就业信息管理', '0', '3', '0', '0', '0', '1');
INSERT INTO `t_channel` VALUES ('6', '0', '#', '0', '0', '学生信息维护', '0', '2', '0', '0', '0', null);
INSERT INTO `t_channel` VALUES ('7', '0', 'admin/student/updateSelf', '0', '0', '学生基本信息维护', '0', '1', '0', '0', '1', '6');
INSERT INTO `t_channel` VALUES ('8', '0', '', '0', '0', '招聘会信息管理', '0', '3', '0', '0', '0', null);
INSERT INTO `t_channel` VALUES ('10', '0', 'admin/careeFair/careeFairs', '0', '0', '招聘会信息管理', '0', '2', '0', '0', '1', '8');
INSERT INTO `t_channel` VALUES ('11', '0', 'admin/sst/updateSelf', '0', '0', '生源地信息维护', '0', '2', '0', '0', '0', '6');
INSERT INTO `t_channel` VALUES ('12', '0', 'admin/empinfo/updateSelf', '0', '0', '就业信息维护', '0', '3', '0', '0', '0', '6');
INSERT INTO `t_channel` VALUES ('13', '0', '', '0', '0', '招聘会信息查看', '0', '4', '0', '0', '0', null);
INSERT INTO `t_channel` VALUES ('14', '0', 'admin/careeFair/appcareeFairs', '0', '0', '招聘会信息查看', '0', '1', '0', '0', '1', '13');
INSERT INTO `t_channel` VALUES ('15', '0', '', '0', '0', '问题反馈', '0', '5', '0', '0', '0', null);
INSERT INTO `t_channel` VALUES ('16', '0', 'admin/question/add', '0', '0', '问题反馈', '0', '1', '0', '0', '1', '15');
INSERT INTO `t_channel` VALUES ('21', '0', '', '0', '0', '信息查询', '0', '7', '0', '0', '0', null);
INSERT INTO `t_channel` VALUES ('23', '1', 'admin/cap/caps', '0', '0', '招聘会预约查询', '0', '2', '0', '0', '1', '21');
INSERT INTO `t_channel` VALUES ('24', '0', 'admin/question/questions', '0', '0', '反馈问题查看', '0', '2', '0', '0', '1', '15');
INSERT INTO `t_channel` VALUES ('26', '0', 'admin/cap/cacaps', '0', '0', '招聘会预约情况查看', '0', '3', '0', '0', '1', '8');
INSERT INTO `t_channel` VALUES ('27', '0', 'admin/question/stuquestions', '0', '0', '反馈答复查看', '0', '3', '0', '0', '1', '21');
INSERT INTO `t_channel` VALUES ('28', '0', 'admin/empinfo/showEmpFile', '0', '0', '就业材料查询', '0', '1', '0', '0', '1', '21');
INSERT INTO `t_channel` VALUES ('30', '0', '/admin/student/students', '0', '0', '毕业生信息管理', '0', '1', '0', '0', '1', '1');

-- ----------------------------
-- Table structure for t_empinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_empinfo`;
CREATE TABLE `t_empinfo` (
  `empUuid` varchar(255) NOT NULL,
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `empAgreementNum` varchar(255) DEFAULT NULL,
  `empAttachment` varchar(255) DEFAULT NULL,
  `empDirection` varchar(255) DEFAULT NULL,
  `empExaNum` varchar(255) DEFAULT NULL,
  `empName` varchar(255) DEFAULT NULL,
  `empRecordTranAddr` varchar(255) DEFAULT NULL,
  `empRecordTranUintPostCode` varchar(255) DEFAULT NULL,
  `empRecordTranUnitName` varchar(255) DEFAULT NULL,
  `empStuNum` varchar(255) DEFAULT NULL,
  `empStuUUid` varchar(255) DEFAULT NULL,
  `empUintContactEmail` varchar(255) DEFAULT NULL,
  `empUintcontactFox` varchar(255) DEFAULT NULL,
  `empUnitAddr` varchar(255) DEFAULT NULL,
  `empUnitCode` varchar(255) DEFAULT NULL,
  `empUnitContactPerson` varchar(255) DEFAULT NULL,
  `empUnitContactPhone` varchar(255) DEFAULT NULL,
  `empUnitName` varchar(255) DEFAULT NULL,
  `empUnitStyle` varchar(255) DEFAULT NULL,
  `empUnitType` int(11) DEFAULT NULL,
  `empUnitTypeName` varchar(255) DEFAULT NULL,
  `empWorkType` varchar(255) DEFAULT NULL,
  `emptyCensusRegisterTranAddr` varchar(255) DEFAULT NULL,
  `finshStatus` int(11) DEFAULT NULL,
  `empDirectionName` varchar(255) DEFAULT NULL,
  `empUnitStyleName` varchar(255) DEFAULT NULL,
  `empWorkTypeName` varchar(255) DEFAULT NULL,
  `empUnitAddrCode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`empUuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_empinfo
-- ----------------------------
INSERT INTO `t_empinfo` VALUES ('402881e55b3896fc015b3937e9590005', null, null, null, 'mx', '\\resources\\empinfoImg\\402881e55b3896fc015b3937e9590005.jpg', ' 60 ', '658972366942666', '李四', '333', '33', '333', '1402130525', '402881e55b3896fc015b3937e9300000', '1882936363@qq.com', '3333', '湖北省 神农架', '233696555', '爱的所发生的', '333', '西安文理学院', ' 35 ', '20', ' 农村建制村', ' 51 ', '33', '9', ' 签劳动合同形式就业', ' 水利、环境和公共设施管理业', ' 文学艺术工作人员', '4232');
INSERT INTO `t_empinfo` VALUES ('402881e65a98acf4015a98c3b741000e', null, null, null, '1188811', null, ' 59 ', '58945296222', '汪磊', '', '', '', '1402130526', '402881e65a98acf4015a98c3b7390009', '', '', '上海市 青浦区', '', '', '', '中软国际', ' 37 ', '13', ' 中初教育单位', ' 57 ', '', '0', ' 签就业协议形式就业', ' 卫生和社会工作', ' 军人', '3118');
INSERT INTO `t_empinfo` VALUES ('402881e95b3e6545015b3e9e35650010', null, null, null, null, null, null, '33', '333', null, null, null, '33', '402881e95b3e6545015b3e9e353e000b', null, null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, null);
INSERT INTO `t_empinfo` VALUES ('ff8080815aa71d44015aa735bcbe0005', null, null, null, '3333', null, ' 61 ', '55556655', '王波', '', '', '', '1402130527', 'ff8080815aa71d44015aa735bc020000', '', '', '河南省 驻马店市 西平县', '', '', '', '西安文理学院', ' 34 ', '18', ' 其他企业', ' 55 ', '', '0', ' 科研助理', ' 居民服务、修理和其他服务业', ' 办事人员和有关人员', '411721');

-- ----------------------------
-- Table structure for t_feedback
-- ----------------------------
DROP TABLE IF EXISTS `t_feedback`;
CREATE TABLE `t_feedback` (
  `feedbackUuid` varchar(255) NOT NULL,
  `feedbackContent` varchar(255) DEFAULT NULL,
  `feedbackPerson` varchar(255) DEFAULT NULL,
  `feedbackStatus` int(11) DEFAULT NULL,
  `feedbackStatusName` varchar(255) DEFAULT NULL,
  `feedbackTime` varchar(255) DEFAULT NULL,
  `responseContent` varchar(255) DEFAULT NULL,
  `responsePerson` varchar(255) DEFAULT NULL,
  `responseTime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`feedbackUuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_feedback
-- ----------------------------

-- ----------------------------
-- Table structure for t_group
-- ----------------------------
DROP TABLE IF EXISTS `t_group`;
CREATE TABLE `t_group` (
  `gruopUuid` varchar(255) NOT NULL,
  `groupCode` int(11) NOT NULL,
  `groupDesc` varchar(255) DEFAULT NULL,
  `groupName` varchar(255) DEFAULT NULL,
  `parentGroupCode` int(11) NOT NULL,
  PRIMARY KEY (`gruopUuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_group
-- ----------------------------
INSERT INTO `t_group` VALUES ('402881e65a98acf4015a98c1c52a0008', '0', '所有学生的组', '学生', '0');
INSERT INTO `t_group` VALUES ('402881e65a98acf4015a98c4a82c000f', '0', '负责管理学生信息', '教师', '0');
INSERT INTO `t_group` VALUES ('402881e65a98b262015a98b2653b0001', '1', '管理员', '管理员', '1');

-- ----------------------------
-- Table structure for t_group_channel
-- ----------------------------
DROP TABLE IF EXISTS `t_group_channel`;
CREATE TABLE `t_group_channel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `c_id` int(11) DEFAULT NULL,
  `g_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKB7D322B885D9BC47` (`c_id`),
  KEY `FKB7D322B83AE7D67F` (`g_id`),
  CONSTRAINT `FKB7D322B83AE7D67F` FOREIGN KEY (`g_id`) REFERENCES `t_group` (`gruopUuid`),
  CONSTRAINT `FKB7D322B885D9BC47` FOREIGN KEY (`c_id`) REFERENCES `t_channel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_group_channel
-- ----------------------------
INSERT INTO `t_group_channel` VALUES ('1', '1', '402881e65a98b262015a98b2653b0001');
INSERT INTO `t_group_channel` VALUES ('3', '4', '402881e65a98b262015a98b2653b0001');
INSERT INTO `t_group_channel` VALUES ('4', '5', '402881e65a98b262015a98b2653b0001');
INSERT INTO `t_group_channel` VALUES ('7', '6', '402881e65a98acf4015a98c1c52a0008');
INSERT INTO `t_group_channel` VALUES ('8', '7', '402881e65a98acf4015a98c1c52a0008');
INSERT INTO `t_group_channel` VALUES ('11', '8', '402881e65a98b262015a98b2653b0001');
INSERT INTO `t_group_channel` VALUES ('13', '10', '402881e65a98b262015a98b2653b0001');
INSERT INTO `t_group_channel` VALUES ('14', '13', '402881e65a98b262015a98b2653b0001');
INSERT INTO `t_group_channel` VALUES ('15', '15', '402881e65a98b262015a98b2653b0001');
INSERT INTO `t_group_channel` VALUES ('16', '14', '402881e65a98b262015a98b2653b0001');
INSERT INTO `t_group_channel` VALUES ('23', '11', '402881e65a98acf4015a98c1c52a0008');
INSERT INTO `t_group_channel` VALUES ('24', '12', '402881e65a98acf4015a98c1c52a0008');
INSERT INTO `t_group_channel` VALUES ('28', '13', '402881e65a98acf4015a98c1c52a0008');
INSERT INTO `t_group_channel` VALUES ('29', '14', '402881e65a98acf4015a98c1c52a0008');
INSERT INTO `t_group_channel` VALUES ('30', '15', '402881e65a98acf4015a98c1c52a0008');
INSERT INTO `t_group_channel` VALUES ('31', '16', '402881e65a98acf4015a98c1c52a0008');
INSERT INTO `t_group_channel` VALUES ('32', '21', '402881e65a98acf4015a98c1c52a0008');
INSERT INTO `t_group_channel` VALUES ('34', '23', '402881e65a98acf4015a98c1c52a0008');
INSERT INTO `t_group_channel` VALUES ('36', '1', '402881e65a98acf4015a98c4a82c000f');
INSERT INTO `t_group_channel` VALUES ('38', '4', '402881e65a98acf4015a98c4a82c000f');
INSERT INTO `t_group_channel` VALUES ('39', '5', '402881e65a98acf4015a98c4a82c000f');
INSERT INTO `t_group_channel` VALUES ('40', '8', '402881e65a98acf4015a98c4a82c000f');
INSERT INTO `t_group_channel` VALUES ('42', '10', '402881e65a98acf4015a98c4a82c000f');
INSERT INTO `t_group_channel` VALUES ('46', '15', '402881e65a98acf4015a98c4a82c000f');
INSERT INTO `t_group_channel` VALUES ('47', '24', '402881e65a98acf4015a98c4a82c000f');
INSERT INTO `t_group_channel` VALUES ('48', '24', '402881e65a98b262015a98b2653b0001');
INSERT INTO `t_group_channel` VALUES ('50', '26', '402881e65a98b262015a98b2653b0001');
INSERT INTO `t_group_channel` VALUES ('51', '26', '402881e65a98acf4015a98c4a82c000f');
INSERT INTO `t_group_channel` VALUES ('56', '27', '402881e65a98acf4015a98c1c52a0008');
INSERT INTO `t_group_channel` VALUES ('57', '28', '402881e65a98acf4015a98c1c52a0008');
INSERT INTO `t_group_channel` VALUES ('65', '30', '402881e65a98b262015a98b2653b0001');
INSERT INTO `t_group_channel` VALUES ('66', '30', '402881e65a98acf4015a98c4a82c000f');

-- ----------------------------
-- Table structure for t_org
-- ----------------------------
DROP TABLE IF EXISTS `t_org`;
CREATE TABLE `t_org` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `att1` varchar(255) DEFAULT NULL,
  `att2` varchar(255) DEFAULT NULL,
  `att3` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `order_num` int(11) DEFAULT NULL,
  `orgCode` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK68F8499D1FB9BBC` (`pid`),
  CONSTRAINT `FK68F8499D1FB9BBC` FOREIGN KEY (`pid`) REFERENCES `t_org` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_org
-- ----------------------------
INSERT INTO `t_org` VALUES ('1', '', '', null, null, '西安文理学院', '1', '', '', '0', null);
INSERT INTO `t_org` VALUES ('2', '西安', '333', null, null, '信息工程学院', '1', '222222222', '', '1', '1');
INSERT INTO `t_org` VALUES ('3', '33', '333', null, null, '人文学院', '2', '33', '33', '1', '1');
INSERT INTO `t_org` VALUES ('4', '西安', '333', null, null, '软件工程', '1', '222222222', '', '2', '2');
INSERT INTO `t_org` VALUES ('5', '3', '333', null, null, '汉语言文学', '1', '33', '', '2', '3');
INSERT INTO `t_org` VALUES ('6', '', '', null, null, '一班', '1', '33', '', '3', '5');
INSERT INTO `t_org` VALUES ('7', '', '', null, null, '二班', '2', '33', '', '3', '5');
INSERT INTO `t_org` VALUES ('8', '', '', null, null, '一班', '1', '222222222', '', '3', '4');

-- ----------------------------
-- Table structure for t_person_org_pos
-- ----------------------------
DROP TABLE IF EXISTS `t_person_org_pos`;
CREATE TABLE `t_person_org_pos` (
  `id` varchar(255) NOT NULL,
  `org_id` int(11) DEFAULT NULL,
  `person_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_person_org_pos
-- ----------------------------

-- ----------------------------
-- Table structure for t_question
-- ----------------------------
DROP TABLE IF EXISTS `t_question`;
CREATE TABLE `t_question` (
  `questionUuid` varchar(255) NOT NULL,
  `answerPerson` varchar(255) DEFAULT NULL,
  `answertime` datetime DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `finshStatus` int(11) DEFAULT NULL,
  `questionAnswer` varchar(255) DEFAULT NULL,
  `questionContent` varchar(255) NOT NULL,
  `stuName` varchar(255) DEFAULT NULL,
  `stunum` varchar(255) DEFAULT NULL,
  `stuuuid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`questionUuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_question
-- ----------------------------
INSERT INTO `t_question` VALUES ('402881e55b383528015b384b26760004', '管理员', '2017-04-04 18:34:37', '2017-04-04 17:28:41', '1', '好好好哦啊后', '你好啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊', '汪磊', '1402130526', '402881e65a98acf4015a98c3b7390009');
INSERT INTO `t_question` VALUES ('402881e55b383528015b384b76f30005', '管理员', '2017-04-04 18:36:41', '2017-04-04 17:28:41', '1', '范德萨发大水', '在不在啊啊啊啊', '汪磊', '1402130526', '402881e65a98acf4015a98c3b7390009');
INSERT INTO `t_question` VALUES ('402881e55b383528015b3851a6920006', '管理员', '2017-04-04 18:37:53', '2017-04-04 17:35:27', '1', '周二', '今天周几', '汪磊', '1402130526', '402881e65a98acf4015a98c3b7390009');
INSERT INTO `t_question` VALUES ('402881e55b383528015b3851d45a0007', null, null, '2017-04-04 17:35:39', '0', null, '明天干嘛', '汪磊', '1402130526', '402881e65a98acf4015a98c3b7390009');
INSERT INTO `t_question` VALUES ('402881e55b383528015b385cc8cb0008', '管理员', '2017-04-04 18:40:09', '2017-04-04 17:47:37', '1', '444', '44444', '汪磊', '1402130526', '402881e65a98acf4015a98c3b7390009');
INSERT INTO `t_question` VALUES ('402881e55b383528015b385cd7f40009', null, null, '2017-04-04 17:47:40', '0', null, '44444444444444444444', '汪磊', '1402130526', '402881e65a98acf4015a98c3b7390009');
INSERT INTO `t_question` VALUES ('402881e55b383528015b385ced51000a', null, null, '2017-04-04 17:47:46', '0', null, '555', '汪磊', '1402130526', '402881e65a98acf4015a98c3b7390009');
INSERT INTO `t_question` VALUES ('402881e55b383528015b385d151b000b', null, null, '2017-04-04 17:47:56', '0', null, '乃发生打架拉什福德疯狂拉升的看法开始懂了', '汪磊', '1402130526', '402881e65a98acf4015a98c3b7390009');
INSERT INTO `t_question` VALUES ('402881e55b383528015b385d2be4000c', null, null, '2017-04-04 17:48:02', '0', null, '33发送到发送到', '汪磊', '1402130526', '402881e65a98acf4015a98c3b7390009');
INSERT INTO `t_question` VALUES ('402881e55b383528015b385d4a53000d', null, null, '2017-04-04 17:48:10', '0', null, '你好好哦的说法搜到', '汪磊', '1402130526', '402881e65a98acf4015a98c3b7390009');
INSERT INTO `t_question` VALUES ('402881e55b3884b0015b38942e550000', null, null, '2017-04-04 18:48:07', '0', null, '我是谁', '王波', '1402130527', 'ff8080815aa71d44015aa735bc020000');
INSERT INTO `t_question` VALUES ('402881e55b3884b0015b3894580c0001', null, null, '2017-04-04 18:48:18', '0', null, '你是谁', '王波', '1402130527', 'ff8080815aa71d44015aa735bc020000');
INSERT INTO `t_question` VALUES ('402881e55b3884b0015b38949fc40002', 'teacher1', '2017-04-04 18:52:08', '2017-04-04 18:48:36', '1', '3333', '大家是谁', '王波', '1402130527', 'ff8080815aa71d44015aa735bc020000');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `roleUuid` varchar(255) NOT NULL,
  `roleCode` int(11) NOT NULL,
  `roleDesc` varchar(255) DEFAULT NULL,
  `roleName` varchar(255) DEFAULT NULL,
  `role_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`roleUuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('402881e65a98aa04015a98aa0bf20000', '1', '管理员', '管理员', '2');
INSERT INTO `t_role` VALUES ('402881e65a98acf4015a98b482330000', '0', '完善学生信息', '学生', '1');
INSERT INTO `t_role` VALUES ('402881e65a98acf4015a98b4c01c0001', '0', '管理学生', '教师', '0');

-- ----------------------------
-- Table structure for t_source_student
-- ----------------------------
DROP TABLE IF EXISTS `t_source_student`;
CREATE TABLE `t_source_student` (
  `souUuid` varchar(255) NOT NULL,
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `finshStatus` int(11) DEFAULT NULL,
  `souAddr` varchar(255) DEFAULT NULL,
  `souExamNum` varchar(255) DEFAULT NULL,
  `souHomeAddr` varchar(255) DEFAULT NULL,
  `souHomePhoe` varchar(255) DEFAULT NULL,
  `souHomePostCode` varchar(255) DEFAULT NULL,
  `souIdcardNum` varchar(255) DEFAULT NULL,
  `souIsLowPro` int(11) DEFAULT NULL,
  `souName` varchar(255) DEFAULT NULL,
  `souSouceType` int(11) DEFAULT NULL,
  `souStuNum` varchar(255) DEFAULT NULL,
  `souStuUUid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`souUuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_source_student
-- ----------------------------
INSERT INTO `t_source_student` VALUES ('402881e55b3896fc015b3937e9590004', null, null, null, '0', null, '658972366942666', null, null, null, '612501119635236', null, '李四', null, '1402130525', '402881e55b3896fc015b3937e9300000');
INSERT INTO `t_source_student` VALUES ('402881e65a98acf4015a98c3b741000d', null, null, null, '0', '陕西商洛', '58945296222', '咸阳', '52666223', '75486222', '61250119930524123', '2', '汪磊', '2', '1402130526', '402881e65a98acf4015a98c3b7390009');
INSERT INTO `t_source_student` VALUES ('402881e95b3e6545015b3e9e3565000f', null, null, null, '0', null, '33', null, null, null, '333', null, '333', null, '33', '402881e95b3e6545015b3e9e353e000b');
INSERT INTO `t_source_student` VALUES ('ff8080815aa71d44015aa735bcbe0004', null, null, null, '0', '宝鸡扶风', '55556655', '法门寺', '110110', '256201666', '43556675444', '1', '王波', '1', '1402130527', 'ff8080815aa71d44015aa735bc020000');

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `stuUuid` varchar(255) NOT NULL,
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `beforecensusaddr` varchar(255) DEFAULT NULL,
  `beforerecordaddr` varchar(255) DEFAULT NULL,
  `birthDate` datetime DEFAULT NULL,
  `censusIsTranSchool` int(11) DEFAULT NULL,
  `collegeName` varchar(255) DEFAULT NULL,
  `collegeNum` varchar(255) DEFAULT NULL,
  `collegeid` int(11) DEFAULT NULL,
  `deptName` varchar(255) DEFAULT NULL,
  `deptNnum` varchar(255) DEFAULT NULL,
  `deptid` int(11) DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `eductionalSystme` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enterTime` datetime DEFAULT NULL,
  `examineeNum` varchar(255) NOT NULL,
  `finshStatus` int(11) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `graduateTime` datetime DEFAULT NULL,
  `idCardNum` varchar(255) NOT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `majordirection` varchar(255) DEFAULT NULL,
  `nation` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `politicalStatus` varchar(255) DEFAULT NULL,
  `povertyLevel` int(11) DEFAULT NULL,
  `qqNum` varchar(255) DEFAULT NULL,
  `recordIsTranSchool` int(11) DEFAULT NULL,
  `stuNum` varchar(255) NOT NULL,
  `stuTeam` varchar(255) DEFAULT NULL,
  `stuTeamNum` varchar(255) DEFAULT NULL,
  `stuTeamid` int(11) DEFAULT NULL,
  `sutName` varchar(255) NOT NULL,
  `trainingMethod` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`stuUuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('402881e55b3896fc015b3937e9300000', null, null, null, '', '', null, '0', null, null, null, null, null, null, '', '', '', null, '658972366942666', '0', '1', null, '612501119635236', null, '', '', '', '', '', '0', '', '0', '1402130525', null, null, null, '李四', '');
INSERT INTO `t_student` VALUES ('402881e65a98acf4015a98c3b7390009', null, null, null, '', '', null, null, '信息工程学院', '222222222', '2', '软件工程', '软件工程', '4', '', '', '', null, '58945296222', '0', '1', null, '61250119930524123', null, '', '', '', '', '', null, '', null, '1402130526', '一班', '222222222', '8', '汪磊', '');
INSERT INTO `t_student` VALUES ('402881e95b3e6545015b3e9e353e000b', null, null, null, '', '', null, '0', null, null, null, null, null, null, '', '', '', null, '33', '0', '1', null, '333', null, '', '', '', '', '', '0', '', '0', '33', null, null, null, '333', '');
INSERT INTO `t_student` VALUES ('ff8080815aa71d44015aa735bc020000', null, null, null, '', '', null, '0', null, null, null, null, null, null, '', '', '', null, '55556655', '0', '1', null, '43556675444', null, '', '', '', '', '', '0', '', '0', '1402130527', null, null, null, '王波', '');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `userUuid` varchar(255) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `stuUuid` varchar(255) DEFAULT NULL,
  `userEmail` varchar(255) DEFAULT NULL,
  `userName` varchar(255) NOT NULL,
  `userNickName` varchar(255) DEFAULT NULL,
  `userPassWord` varchar(255) NOT NULL,
  `userPhone` varchar(255) DEFAULT NULL,
  `userStatus` int(11) NOT NULL,
  PRIMARY KEY (`userUuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('402881e55b3896fc015b3937e9380001', '2017-04-04 21:46:57', '402881e55b3896fc015b3937e9300000', '', '1402130525', '李四', '613d440f7914ef335c72510428e9fdfe', '', '1');
INSERT INTO `t_user` VALUES ('402881e65a98acf4015a98c3b739000a', '2017-03-04 18:00:48', '402881e65a98acf4015a98c3b7390009', 'bingxuewulei@outlook.com', '1402130526', '汪磊', '31da11ad9ef3eb82db7de6841f54946d', '18829012118', '1');
INSERT INTO `t_user` VALUES ('402881e65a98b262015a98b265300000', '2017-03-04 17:41:53', null, 'admin@qq.com', 'admin', '超级管理员', 'e00cf25ad42683b3df678c61f42c6bda', '123456920', '1');
INSERT INTO `t_user` VALUES ('402881e75ae208f2015ae227aa530000', '2017-03-19 00:02:15', null, 'tea@ttt.com', 'tea', 'teacher1', 'aad8bd8946dc0483aa2056d0e6932971', '152996666', '1');
INSERT INTO `t_user` VALUES ('402881e95b3e6545015b3e9e3542000c', '2017-04-05 22:56:47', '402881e95b3e6545015b3e9e353e000b', null, '33', '333', '2be9bd7a3434f7038ca27d1918de58bd', null, '1');
INSERT INTO `t_user` VALUES ('ff8080815aa71d44015aa735bc460001', '2017-03-07 13:20:01', 'ff8080815aa71d44015aa735bc020000', '222@ee.com', '1402130527', '王波', '2e5617bbc4520c89bba6e1b0cb2757c5', '222', '1');

-- ----------------------------
-- Table structure for t_user_group
-- ----------------------------
DROP TABLE IF EXISTS `t_user_group`;
CREATE TABLE `t_user_group` (
  `userGroupUuid` varchar(255) NOT NULL,
  `g_uuid` varchar(255) DEFAULT NULL,
  `u_uuid` varchar(255) NOT NULL,
  PRIMARY KEY (`userGroupUuid`),
  KEY `FK8D5699B6EFEC671F` (`g_uuid`),
  KEY `FK8D5699B63A5EC763` (`u_uuid`),
  CONSTRAINT `FK8D5699B63A5EC763` FOREIGN KEY (`u_uuid`) REFERENCES `t_user` (`userUuid`),
  CONSTRAINT `FK8D5699B6EFEC671F` FOREIGN KEY (`g_uuid`) REFERENCES `t_group` (`gruopUuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_group
-- ----------------------------
INSERT INTO `t_user_group` VALUES ('402881e65a98acf4015a98c3b73f000b', '402881e65a98acf4015a98c1c52a0008', '402881e65a98acf4015a98c3b739000a');
INSERT INTO `t_user_group` VALUES ('402881e65a98b262015a98b266180002', '402881e65a98b262015a98b2653b0001', '402881e65a98b262015a98b265300000');
INSERT INTO `t_user_group` VALUES ('402881e75ae208f2015ae227aa810002', '402881e65a98acf4015a98c4a82c000f', '402881e75ae208f2015ae227aa530000');
INSERT INTO `t_user_group` VALUES ('402881e95b3e6545015b3e9e3559000d', '402881e65a98acf4015a98c1c52a0008', '402881e95b3e6545015b3e9e3542000c');
INSERT INTO `t_user_group` VALUES ('ff8080815aa71d44015aa735bcaa0002', '402881e65a98acf4015a98c1c52a0008', 'ff8080815aa71d44015aa735bc460001');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `userRoleUuid` varchar(255) NOT NULL,
  `r_uuid` varchar(255) DEFAULT NULL,
  `u_uuid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userRoleUuid`),
  KEY `FK3E62963F353ED231` (`r_uuid`),
  KEY `FK3E62963F3A5EC763` (`u_uuid`),
  CONSTRAINT `FK3E62963F353ED231` FOREIGN KEY (`r_uuid`) REFERENCES `t_role` (`roleUuid`),
  CONSTRAINT `FK3E62963F3A5EC763` FOREIGN KEY (`u_uuid`) REFERENCES `t_user` (`userUuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('402881e65a98acf4015a98c3b741000c', '402881e65a98acf4015a98b482330000', '402881e65a98acf4015a98c3b739000a');
INSERT INTO `t_user_role` VALUES ('402881e65a98b262015a98b2661e0003', '402881e65a98aa04015a98aa0bf20000', '402881e65a98b262015a98b265300000');
INSERT INTO `t_user_role` VALUES ('402881e75ae208f2015ae227aa6f0001', '402881e65a98acf4015a98b4c01c0001', '402881e75ae208f2015ae227aa530000');
INSERT INTO `t_user_role` VALUES ('402881e95b3e6545015b3e9e3565000e', '402881e65a98acf4015a98b482330000', '402881e95b3e6545015b3e9e3542000c');
INSERT INTO `t_user_role` VALUES ('ff8080815aa71d44015aa735bcbe0003', '402881e65a98acf4015a98b482330000', 'ff8080815aa71d44015aa735bc460001');
