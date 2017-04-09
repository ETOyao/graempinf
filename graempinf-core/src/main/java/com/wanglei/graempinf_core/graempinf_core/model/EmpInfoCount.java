package com.wanglei.graempinf_core.graempinf_core.model;

import java.math.BigDecimal;

/**
 * <p>Title:就业信息统计 </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright ICSS(c) 2017</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2017年4月9日
 */
public class EmpInfoCount {
	/**
	 * 学院名
	 */
	private String collegeName;
	/**
	 * 学院编号
	 */
	private String collegeNum;
	/**
	 * 未就业人数
	 */
	private BigDecimal utn;
	/**
	 * 已就业人数
	 */
	private BigDecimal atn;
	/**
	 * 总人数
	 */
	private BigDecimal ttn;
	/**
	 * 未就业率
	 */
	private BigDecimal perutn;
	/**
	 * 就业率
	 */
	private BigDecimal peratn;
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getCollegeNum() {
		return collegeNum;
	}
	public void setCollegeNum(String collegeNum) {
		this.collegeNum = collegeNum;
	}
	
	public BigDecimal getUtn() {
		return utn;
	}
	public void setUtn(BigDecimal utn) {
		this.utn = utn;
	}
	public BigDecimal getAtn() {
		return atn;
	}
	public void setAtn(BigDecimal atn) {
		this.atn = atn;
	}
	public BigDecimal getTtn() {
		return ttn;
	}
	public void setTtn(BigDecimal ttn) {
		this.ttn = ttn;
	}
	public BigDecimal getPerutn() {
		return perutn;
	}
	public void setPerutn(BigDecimal perutn) {
		this.perutn = perutn;
	}
	public BigDecimal getPeratn() {
		return peratn;
	}
	public void setPeratn(BigDecimal peratn) {
		this.peratn = peratn;
	}
	public EmpInfoCount() {
		super();
	}
	
}
