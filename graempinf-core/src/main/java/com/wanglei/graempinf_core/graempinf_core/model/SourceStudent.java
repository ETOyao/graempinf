package com.wanglei.graempinf_core.graempinf_core.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * <p>Title: 生源地信息实体类</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright wanglei(c) 2017</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">WangLei</a>
 * @version 1.0
 * @history:
 * Created by WangLei 2017年2月25日
 */
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright wanglei(c) 2017</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">WangLei</a>
 * @version 1.0
 * @history:
 * Created by WangLei 2017年2月26日
 */
@Entity
@Table(name="T_SOURCE_STUDENT")
public class SourceStudent {
	
	/**
	 * 生源地标示
	 */
	private String souUuid;
	
	/**
	 * 学生Id
	 */
	private String souStuUUid;
	
	/**
	 * 考试号
	 */
	private String souExamNum;
	
	/**
	 * 学号
	 */
	private String souStuNum;
	/**
	 * 身份证
	 */
	private String souIdcardNum;
	
	/**
	 * 姓名
	 */
	private String souName;
	
	/**
	 * 生源地
	 */
	private String souAddr;
	
	/**
	 * 生源地类型
	 */
	private Integer souSouceType;
	
	/**
	 * 家庭住址
	 */
	private String souHomeAddr;
	
	/**
	 * 电话
	 */
	private String souHomePhoe;
	
	/**
	 * 邮编
	 */
	private String souHomePostCode;
	
	/**
	 * 是否低保
	 */
	private Integer souIsLowPro;
	
	/**
	 * 状态
	 */
	private Integer finshStatus;
	
	/**
	 * 扩展字段1-3
	 */
	private String attr1;
	private String attr2;
	private String attr3;
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	public String getSouUuid() {
		return souUuid;
	}
	public String getSouStuUUid() {
		return souStuUUid;
	}
	public String getSouExamNum() {
		return souExamNum;
	}
	public String getSouIdcardNum() {
		return souIdcardNum;
	}
	public String getSouName() {
		return souName;
	}
	public String getSouAddr() {
		return souAddr;
	}
	public Integer getSouSouceType() {
		return souSouceType;
	}
	public String getSouHomeAddr() {
		return souHomeAddr;
	}
	public String getSouHomePhoe() {
		return souHomePhoe;
	}
	public String getSouHomePostCode() {
		return souHomePostCode;
	}

	public Integer getFinshStatus() {
		return finshStatus;
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
	public void setSouUuid(String souUuid) {
		this.souUuid = souUuid;
	}
	public void setSouStuUUid(String souStuUUid) {
		this.souStuUUid = souStuUUid;
	}
	public void setSouExamNum(String souExamNum) {
		this.souExamNum = souExamNum;
	}
	public void setSouIdcardNum(String souIdcardNum) {
		this.souIdcardNum = souIdcardNum;
	}
	public void setSouName(String souName) {
		this.souName = souName;
	}
	public void setSouAddr(String souAddr) {
		this.souAddr = souAddr;
	}
	public void setSouSouceType(Integer souSouceType) {
		this.souSouceType = souSouceType;
	}
	public void setSouHomeAddr(String souHomeAddr) {
		this.souHomeAddr = souHomeAddr;
	}
	public void setSouHomePhoe(String souHomePhoe) {
		this.souHomePhoe = souHomePhoe;
	}
	public void setSouHomePostCode(String souHomePostCode) {
		this.souHomePostCode = souHomePostCode;
	}
	public void setFinshStatus(Integer finshStatus) {
		this.finshStatus = finshStatus;
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
	
	public Integer getSouIsLowPro() {
		return souIsLowPro;
	}
	public void setSouIsLowPro(Integer souIsLowPro) {
		this.souIsLowPro = souIsLowPro;
	}
	
	public String getSouStuNum() {
		return souStuNum;
	}
	public void setSouStuNum(String souStuNum) {
		this.souStuNum = souStuNum;
	}
	
	@Override
	public String toString() {
		return "SourceStudent [souUuid=" + souUuid + ", souStuUUid=" + souStuUUid + ", souExamNum=" + souExamNum + ", souStuNum=" + souStuNum + ", souIdcardNum=" + souIdcardNum + ", souName="
				+ souName + ", souAddr=" + souAddr + ", souSouceType=" + souSouceType + ", souHomeAddr=" + souHomeAddr + ", souHomePhoe=" + souHomePhoe + ", souHomePostCode="
				+ souHomePostCode + ", souIsLowPro=" + souIsLowPro + ", finshStatus=" + finshStatus + ", attr1=" + attr1 + ", attr2=" + attr2 + ", attr3=" + attr3 + "]";
	}
	public SourceStudent() {
		super();
	}
	public SourceStudent( String souExamNum, String souStuNum, String souIdcardNum, String souName, String souAddr,String souHomeAddr, Integer souSouceType, String souUuid ,Integer finshStatus,Integer souIsLowPro) {
		super();
		this.souUuid = souUuid;
		this.souExamNum = souExamNum;
		this.souStuNum = souStuNum;
		this.souIdcardNum = souIdcardNum;
		this.souName = souName;
		this.souAddr = souAddr;
		this.souSouceType = souSouceType;
		this.souHomeAddr = souHomeAddr;
		this.finshStatus = finshStatus;
		this.souIsLowPro = souIsLowPro;
	}
	
}
