package com.wanglei.graempinf_core.graempinf_core.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>Title:招聘会信息实体类 </p>
 * <p>Description:存储招聘会的所有信息 </p>
 * <p>Copyright: Copyright ICSS(c) 2017</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2017年3月20日
 */
@Entity
@Table(name="T_CAREEFAIR")
public class CareerFair {
	/**
	 * 招聘会标示
	 */
	private String careerFairUuid;
	/**
	 * 招聘会名称
	 */
	private String careerFairName;
	/**
	 * 招聘会描述
	 */
	private String careerFairDesc;
	/**
	 * 招聘会类型
	 */
	private Integer careerFairType;
	/**
	 * 招聘会类型名
	 */
	private String careerFairTypeName;
	/**
	 * 招聘会地点
	 */
	private String careerFairAddr;
	/**
	 * 招聘会举行时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")  
	private Date careerFairDate;
	/**
	 * 创建时间
	 */
	private Timestamp createCareerFairDate;
	/**
	 * 发布时间
	 */
	private Timestamp applayCareerFairDate;
	/**
	 * 创建人
	 */
	private String careerPerson;
	/**
	 * 发布人
	 */
	private String applyPerson;
	/**
	 * 招聘会承办单位
	 */
	private String careerFairUndertaker;
	/**
	 * 招聘会信息状态 0：未发布 1：已发布 2：已举行
	 */
	private Integer finshStatus;
	private String attr1;
	private String attr2;
	private String attr3;
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	public String getCareerFairUuid() {
		return careerFairUuid;
	}
	public void setCareerFairUuid(String careerFairUuid) {
		this.careerFairUuid = careerFairUuid;
	}
	public String getCareerFairName() {
		return careerFairName;
	}
	public void setCareerFairName(String careerFairName) {
		this.careerFairName = careerFairName;
	}
	public String getCareerFairDesc() {
		return careerFairDesc;
	}
	public void setCareerFairDesc(String careerFairDesc) {
		this.careerFairDesc = careerFairDesc;
	}
	public Integer getCareerFairType() {
		return careerFairType;
	}
	public void setCareerFairType(Integer careerFairType) {
		this.careerFairType = careerFairType;
	}
	public String getCareerFairTypeName() {
		return careerFairTypeName;
	}
	public void setCareerFairTypeName(String careerFairTypeName) {
		this.careerFairTypeName = careerFairTypeName;
	}
	public String getCareerFairAddr() {
		return careerFairAddr;
	}
	public void setCareerFairAddr(String careerFairAddr) {
		this.careerFairAddr = careerFairAddr;
	}
	public String getCareerFairUndertaker() {
		return careerFairUndertaker;
	}
	public void setCareerFairUndertaker(String careerFairUndertaker) {
		this.careerFairUndertaker = careerFairUndertaker;
	}
	public String getAttr1() {
		return attr1;
	}
	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}
	public String getAttr2() {
		return attr2;
	}
	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}
	public String getAttr3() {
		return attr3;
	}
	public void setAttr3(String attr3) {
		this.attr3 = attr3;
	}
	public CareerFair() {
		super();
	}
	
	public Integer getFinshStatus() {
		return finshStatus;
	}
	public void setFinshStatus(Integer finshStatus) {
		this.finshStatus = finshStatus;
	}
	
	public Date getCareerFairDate() {
		return careerFairDate;
	}
	public void setCareerFairDate(Date careerFairDate) {
		this.careerFairDate = careerFairDate;
	}
	public Timestamp getCreateCareerFairDate() {
		return createCareerFairDate;
	}
	public void setCreateCareerFairDate(Timestamp createCareerFairDate) {
		this.createCareerFairDate = createCareerFairDate;
	}
	public String getCareerPerson() {
		return careerPerson;
	}
	public void setCareerPerson(String careerPerson) {
		this.careerPerson = careerPerson;
	}
	
	public Timestamp getApplayCareerFairDate() {
		return applayCareerFairDate;
	}
	public void setApplayCareerFairDate(Timestamp applayCareerFairDate) {
		this.applayCareerFairDate = applayCareerFairDate;
	}
	
	public String getApplyPerson() {
		return applyPerson;
	}
	public void setApplyPerson(String applyPerson) {
		this.applyPerson = applyPerson;
	}
	@Override
	public String toString() {
		return "CareerFair [careerFairUuid=" + careerFairUuid
				+ ", careerFairName=" + careerFairName + ", careerFairDesc="
				+ careerFairDesc + ", careerFairType=" + careerFairType
				+ ", careerFairTypeName=" + careerFairTypeName
				+ ", careerFairAddr=" + careerFairAddr
				+ ", careerFairUndertaker=" + careerFairUndertaker + ", attr1="
				+ attr1 + ", attr2=" + attr2 + ", attr3=" + attr3 + "]";
	}
	
}
