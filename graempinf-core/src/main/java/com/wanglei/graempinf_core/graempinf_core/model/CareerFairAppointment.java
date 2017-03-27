package com.wanglei.graempinf_core.graempinf_core.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * <p>Title:招聘会和预约关系 </p>
 * <p>Description: 该实体类描述了招聘会和预约学生之间的关系</p>
 * <p>Copyright: Copyright ICSS(c) 2017</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2017年3月21日
 */
@Entity
@Table(name="T_CAREEFAIRAPPIONTMENT")
public class CareerFairAppointment {
	/**
	 * 招聘会-预约唯一标示
	 */
	private String capUUid;
	/**
	 * 学生uuid
	 */
	private String capstuUuid;
	/**
	 * 学号
	 */
	private String capstuNum;
	/**
	 * 姓名
	 */
	private String capstuName;
	/**
	 * 专业
	 */
	private String capObject;
	/**
	 * 预约编号
	 */
	private String capAppCode;
	/**
	 * 就业意愿-1
	 */
	private String jobDirecttion1;
	/**
	 * 就业意愿-2
	 */
	private String jobDirecttion2;
	/**
	 * 就业意愿-3
	 */
	private String jobDirecttion3;
	/**
	 * 招聘会UUid
	 */
	private String careeFairUuid;
	/**
	 * 招聘会名称
	 */
	private String careeFairName;
	/**
	 * 预约状态 0：取消预约 1：已预约 2：已参加 3：放弃参加  4 ：逾期   null ：未预约
	 */
	private Integer finshStatus;
	/**
	 * 意见反馈
	 */
	private String capAdvice;
	
	/**
	 * 扩展字段
	 */
	private String attr1;
	private String atrtr2;
	private String attr3;
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	public String getCapUUid() {
		return capUUid;
	}
	public void setCapUUid(String capUUid) {
		this.capUUid = capUUid;
	}
	public String getCapstuUuid() {
		return capstuUuid;
	}
	public void setCapstuUuid(String capstuUuid) {
		this.capstuUuid = capstuUuid;
	}
	public String getCapstuNum() {
		return capstuNum;
	}
	public void setCapstuNum(String capstuNum) {
		this.capstuNum = capstuNum;
	}
	public String getCapstuName() {
		return capstuName;
	}
	public void setCapstuName(String capstuName) {
		this.capstuName = capstuName;
	}
	public String getCapObject() {
		return capObject;
	}
	public void setCapObject(String capObject) {
		this.capObject = capObject;
	}
	public String getCapAppCode() {
		return capAppCode;
	}
	public void setCapAppCode(String capAppCode) {
		this.capAppCode = capAppCode;
	}
	public String getJobDirecttion1() {
		return jobDirecttion1;
	}
	public void setJobDirecttion1(String jobDirecttion1) {
		this.jobDirecttion1 = jobDirecttion1;
	}
	public String getJobDirecttion2() {
		return jobDirecttion2;
	}
	public void setJobDirecttion2(String jobDirecttion2) {
		this.jobDirecttion2 = jobDirecttion2;
	}
	public String getJobDirecttion3() {
		return jobDirecttion3;
	}
	public void setJobDirecttion3(String jobDirecttion3) {
		this.jobDirecttion3 = jobDirecttion3;
	}
	public String getCareeFairUuid() {
		return careeFairUuid;
	}
	public void setCareeFairUuid(String careeFairUuid) {
		this.careeFairUuid = careeFairUuid;
	}
	public String getCareeFairName() {
		return careeFairName;
	}
	public void setCareeFairName(String careeFairName) {
		this.careeFairName = careeFairName;
	}
	public Integer getFinshStatus() {
		return finshStatus;
	}
	public void setFinshStatus(Integer finshStatus) {
		this.finshStatus = finshStatus;
	}
	public String getCapAdvice() {
		return capAdvice;
	}
	public void setCapAdvice(String capAdvice) {
		this.capAdvice = capAdvice;
	}
	public String getAttr1() {
		return attr1;
	}
	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}
	public String getAtrtr2() {
		return atrtr2;
	}
	public void setAtrtr2(String atrtr2) {
		this.atrtr2 = atrtr2;
	}
	public String getAttr3() {
		return attr3;
	}
	public void setAttr3(String attr3) {
		this.attr3 = attr3;
	}
	@Override
	public String toString() {
		return "CareerFairAppointment [capUUid=" + capUUid + ", capstuUuid="
				+ capstuUuid + ", capstuNum=" + capstuNum + ", capstuName="
				+ capstuName + ", capObject=" + capObject + ", capAppCode="
				+ capAppCode + ", jobDirecttion1=" + jobDirecttion1
				+ ", jobDirecttion2=" + jobDirecttion2 + ", jobDirecttion3="
				+ jobDirecttion3 + ", careeFairUuid=" + careeFairUuid
				+ ", careeFairName=" + careeFairName + ", finshStatus="
				+ finshStatus + ", capAdvice=" + capAdvice + ", attr1=" + attr1
				+ ", atrtr2=" + atrtr2 + ", attr3=" + attr3 + "]";
	}
	public CareerFairAppointment() {
		super();
	}
	
}
