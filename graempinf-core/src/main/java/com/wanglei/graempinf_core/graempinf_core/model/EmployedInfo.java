package com.wanglei.graempinf_core.graempinf_core.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright wanglei(c) 2017</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">WangLei</a>
 * @version 1.0
 * @history:
 * Created by WangLei 2017年2月25日
 */
@Entity
@Table(name="t_EMPINFO")
public class EmployedInfo {
	
	/**
	 * 就业信息标示
	 */
	private String empUuid;
	
	/**
	 * 考试号
	 */
	private String empExaNum;
	
	/**
	 * 学号
	 */
	private String empStuNum;
	
	/**
	 * 姓名
	 */
	private String empName;
	
	/**
	 * 三方协议编号
	 */
	private String empAgreementNum;
	
	/**
	 * 毕业去向
	 */
	private String empDirection;
	/**
	 * 毕业去向名字
	 */
	private String empDirectionName;
	/**
	 * 就业单位名称
	 */
	private String empUnitName;
	
	/**
	 *就业单位编码
	 */
	private String empUnitCode;
	
	/**
	 * 就业单位性质
	 */
	private Integer empUnitType;
	
	/**
	 * 就业单位性质名
	 */
	private String empUnitTypeName;
	
	/**
	 * 就业单位行业
	 */
	private String empUnitStyle;
	/**
	 * 单位行业名字
	 */
	private String empUnitStyleName;
	
	/**
	 * 就业单位地址
	 */
	private String empUnitAddr;
	/**
	 * 就业单位地区代码
	 */
	private String empUnitAddrCode;;
	
	/**
	 * 就业工作职位类别
	 */
	private String empWorkType;
	/**
	 * 职位类别名字
	 */
	private String empWorkTypeName;
	
	/**
	 * 联系人
	 */
	private String empUnitContactPerson;
	
	/**
	 * 联系邮箱电话
	 */
	private String empUnitContactPhone;
	
	/**
	 * 联系邮箱
	 */
	private String empUintContactEmail;
	
	/**
	 * 传真
	 */
	private String empUintcontactFox;
	
	/**
	 * 档案邮寄地址
	 */
	private String empRecordTranAddr;
	
	/**
	 * 档案接收单位名称
	 */
	private String empRecordTranUnitName;
	
	/**档案接收单位邮编
	 * 
	 */
	private String empRecordTranUintPostCode;
	
	/**
	 * 户籍转寄地址
	 */
	private String emptyCensusRegisterTranAddr;
	
	/**
	 * 就业信息状态
	 */
	private Integer finshStatus;
	
	/**
	 * 附件
	 */
	private String empAttachment;
	
	/**
	 * 学生uuid
	 */
	private String empStuUUid;
	/**
	 * 扩展字段
	 */
	private String attr1;
	private String attr2;
	private String attr3;
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	public String getEmpUuid() {
		return empUuid;
	}
	public String getEmpExaNum() {
		return empExaNum;
	}
	public String getEmpStuNum() {
		return empStuNum;
	}
	public String getEmpName() {
		return empName;
	}
	public String getEmpAgreementNum() {
		return empAgreementNum;
	}
	public String getEmpDirection() {
		return empDirection;
	}
	public String getEmpUnitName() {
		return empUnitName;
	}
	public String getEmpUnitCode() {
		return empUnitCode;
	}
	public Integer getEmpUnitType() {
		return empUnitType;
	}
	public String getEmpUnitTypeName() {
		return empUnitTypeName;
	}
	public String getEmpUnitStyle() {
		return empUnitStyle;
	}
	public String getEmpUnitAddr() {
		return empUnitAddr;
	}
	public String getEmpWorkType() {
		return empWorkType;
	}
	public String getEmpUnitContactPerson() {
		return empUnitContactPerson;
	}
	public String getEmpUnitContactPhone() {
		return empUnitContactPhone;
	}
	@Email(message="邮件格式不正确！")
	public String getEmpUintContactEmail() {
		return empUintContactEmail;
	}
	public String getEmpUintcontactFox() {
		return empUintcontactFox;
	}
	public String getEmpRecordTranAddr() {
		return empRecordTranAddr;
	}
	public String getEmpRecordTranUnitName() {
		return empRecordTranUnitName;
	}
	public String getEmpRecordTranUintPostCode() {
		return empRecordTranUintPostCode;
	}
	public String getEmptyCensusRegisterTranAddr() {
		return emptyCensusRegisterTranAddr;
	}
	public Integer getFinshStatus() {
		return finshStatus;
	}
	public String getEmpAttachment() {
		return empAttachment;
	}
	public String getAttr1() {
		return attr1;
	}
	public String getAttr2() {
		return attr2;
	}
	public String getAttr3() {
		return attr3;
	}
	public void setEmpUuid(String empUuid) {
		this.empUuid = empUuid;
	}
	public void setEmpExaNum(String empExaNum) {
		this.empExaNum = empExaNum;
	}
	public void setEmpStuNum(String empStuNum) {
		this.empStuNum = empStuNum;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void setEmpAgreementNum(String empAgreementNum) {
		this.empAgreementNum = empAgreementNum;
	}
	public void setEmpDirection(String empDirection) {
		this.empDirection = empDirection;
	}
	public void setEmpUnitName(String empUnitName) {
		this.empUnitName = empUnitName;
	}
	public void setEmpUnitCode(String empUnitCode) {
		this.empUnitCode = empUnitCode;
	}
	public void setEmpUnitType(Integer empUnitType) {
		this.empUnitType = empUnitType;
	}
	public void setEmpUnitTypeName(String empUnitTypeName) {
		this.empUnitTypeName = empUnitTypeName;
	}
	public void setEmpUnitStyle(String empUnitStyle) {
		this.empUnitStyle = empUnitStyle;
	}
	public void setEmpUnitAddr(String empUnitAddr) {
		this.empUnitAddr = empUnitAddr;
	}
	public void setEmpWorkType(String empWorkType) {
		this.empWorkType = empWorkType;
	}
	public void setEmpUnitContactPerson(String empUnitContactPerson) {
		this.empUnitContactPerson = empUnitContactPerson;
	}
	public void setEmpUnitContactPhone(String empUnitContactPhone) {
		this.empUnitContactPhone = empUnitContactPhone;
	}
	public void setEmpUintContactEmail(String empUintContactEmail) {
		this.empUintContactEmail = empUintContactEmail;
	}
	public void setEmpUintcontactFox(String empUintcontactFox) {
		this.empUintcontactFox = empUintcontactFox;
	}
	public void setEmpRecordTranAddr(String empRecordTranAddr) {
		this.empRecordTranAddr = empRecordTranAddr;
	}
	public void setEmpRecordTranUnitName(String empRecordTranUnitName) {
		this.empRecordTranUnitName = empRecordTranUnitName;
	}
	public void setEmpRecordTranUintPostCode(String empRecordTranUintPostCode) {
		this.empRecordTranUintPostCode = empRecordTranUintPostCode;
	}
	public void setEmptyCensusRegisterTranAddr(String emptyCensusRegisterTranAddr) {
		this.emptyCensusRegisterTranAddr = emptyCensusRegisterTranAddr;
	}
	public void setFinshStatus(Integer finshStatus) {
		this.finshStatus = finshStatus;
	}
	public void setEmpAttachment(String empAttachment) {
		this.empAttachment = empAttachment;
	}
	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}
	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}
	public void setAttr3(String attr3) {
		this.attr3 = attr3;
	}
	
	public String getEmpStuUUid() {
		return empStuUUid;
	}
	public void setEmpStuUUid(String empStuUUid) {
		this.empStuUUid = empStuUUid;
	}

	public String getEmpDirectionName() {
		return empDirectionName;
	}
	public void setEmpDirectionName(String empDirectionName) {
		this.empDirectionName = empDirectionName;
	}
	public String getEmpUnitStyleName() {
		return empUnitStyleName;
	}
	public void setEmpUnitStyleName(String empUnitStyleName) {
		this.empUnitStyleName = empUnitStyleName;
	}
	public String getEmpWorkTypeName() {
		return empWorkTypeName;
	}
	public void setEmpWorkTypeName(String empWorkTypeName) {
		this.empWorkTypeName = empWorkTypeName;
	}
	@Override
	public String toString() {
		return "EmployedInfo [empUuid=" + empUuid + ", empExaNum=" + empExaNum + ", empStuNum=" + empStuNum + ", empName=" + empName + ", empAgreementNum=" + empAgreementNum + ", empDirection="
				+ empDirection + ", empUnitName=" + empUnitName + ", empUnitCode=" + empUnitCode + ", empUnitType=" + empUnitType + ", empUnitTypeName=" + empUnitTypeName + ", empUnitStyle="
				+ empUnitStyle + ", empUnitAddr=" + empUnitAddr + ", empWorkType=" + empWorkType + ", empUnitContactPerson=" + empUnitContactPerson + ", empUnitContactPhone="
				+ empUnitContactPhone + ", empUintContactEmail=" + empUintContactEmail + ", empUintcontactFox=" + empUintcontactFox + ", empRecordTranAddr=" + empRecordTranAddr
				+ ", empRecordTranUnitName=" + empRecordTranUnitName + ", empRecordTranUintPostCode=" + empRecordTranUintPostCode + ", emptyCensusRegisterTranAddr="
				+ emptyCensusRegisterTranAddr + ", finshStatus=" + finshStatus + ", empAttachment=" + empAttachment + ", attr1=" + attr1 + ", attr2=" + attr2 + ", attr3=" + attr3 + "]";
	}
	public EmployedInfo() {
		super();
	}
	
	public String getEmpUnitAddrCode() {
		return empUnitAddrCode;
	}
	public void setEmpUnitAddrCode(String empUnitAddrCode) {
		this.empUnitAddrCode = empUnitAddrCode;
	}
	public EmployedInfo(String empUuid, String empExaNum, String empStuNum, String empName, String empAgreementNum, String empUnitName, String empDirection,  Integer empUnitType, Integer finshStatus) {
		super();
		this.empUuid = empUuid;
		this.empExaNum = empExaNum;
		this.empStuNum = empStuNum;
		this.empName = empName;
		this.empAgreementNum = empAgreementNum;
		this.empUnitName = empUnitName;
		this.empDirection = empDirection;
		this.empUnitType = empUnitType;
		this.finshStatus = finshStatus;
	}
	
}
