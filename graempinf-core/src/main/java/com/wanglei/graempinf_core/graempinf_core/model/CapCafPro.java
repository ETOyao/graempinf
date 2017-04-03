package com.wanglei.graempinf_core.graempinf_core.model;

import java.math.BigInteger;


/**
 * <p>Title: 招聘会预约情况model</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright ICSS(c) 2017</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2017年4月3日
 */
public class CapCafPro {
	/**
	 * 招聘会名
	 */
	private String careerFairName;
	/**
	 * 招聘会类型-名称
	 */
	private String careerFairTypeName;
	/**
	 * 招聘会类型
	 */
	private Integer careerFairType;
	/**
	 *招聘会 未参加人数
	 */
	private BigInteger cnt1;
	/**
	 * 招聘会 参加人数
	 */
	private BigInteger cnt2;
	/**
	 * 招聘会 取消人数
	 */
	private BigInteger cnt3;
	/**
	 * 招聘会 逾期人数
	 */
	private BigInteger cnt4;
	/**
	 * 招聘会 预约人数
	 */
	private BigInteger cnt5;
	public String getCareerFairName() {
		return careerFairName;
	}
	public void setCareerFairName(String careerFairName) {
		this.careerFairName = careerFairName;
	}
	public String getCareerFairTypeName() {
		return careerFairTypeName;
	}
	public void setCareerFairTypeName(String careerFairTypeName) {
		this.careerFairTypeName = careerFairTypeName;
	}
	
	public Integer getCareerFairType() {
		return careerFairType;
	}
	public void setCareerFairType(Integer careerFairType) {
		this.careerFairType = careerFairType;
	}
	
	public BigInteger getCnt1() {
		return cnt1;
	}
	public void setCnt1(BigInteger cnt1) {
		this.cnt1 = cnt1;
	}
	public BigInteger getCnt2() {
		return cnt2;
	}
	public void setCnt2(BigInteger cnt2) {
		this.cnt2 = cnt2;
	}
	public BigInteger getCnt3() {
		return cnt3;
	}
	public void setCnt3(BigInteger cnt3) {
		this.cnt3 = cnt3;
	}
	public BigInteger getCnt4() {
		return cnt4;
	}
	public void setCnt4(BigInteger cnt4) {
		this.cnt4 = cnt4;
	}
	public BigInteger getCnt5() {
		return cnt5;
	}
	public void setCnt5(BigInteger cnt5) {
		this.cnt5 = cnt5;
	}
	public CapCafPro() {
		super();
	}
}
