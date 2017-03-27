package com.wanglei.graempinf_core.graempinf_core.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * <p>Title:基础字典码表 </p>
 * <p>Description:存储系统的基础码表字段 </p>
 * <p>Copyright: Copyright ICSS(c) 2017</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2017年3月15日
 */
@Entity
@Table(name="T_BASECODE")
public class BaseCodeModel {
	/**
	 * 基础码表唯一标示
	 */
	private String baseCodeUUid;
	/**
	 * 键
	 */
	private String baseCodekey;
	/**
	 * 值
	 */
	private String keyValue;
	/**
	 * 类型
	 */
	private String baseCodeType;
	/**
	 * 类型名称
	 */
	private String baseCodeTypeName;
	/**
	 * 是否有效 1：有效 0：无效
	 */
	private Integer isTrue;
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	public String getBaseCodeUUid() {
		return baseCodeUUid;
	}
	public void setBaseCodeUUid(String baseCodeUUid) {
		this.baseCodeUUid = baseCodeUUid;
	}
	public String getBaseCodekey() {
		return baseCodekey;
	}
	public void setBaseCodekey(String baseCodekey) {
		this.baseCodekey = baseCodekey;
	}
	public String getKeyValue() {
		return keyValue;
	}
	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}
	public String getBaseCodeType() {
		return baseCodeType;
	}
	public void setBaseCodeType(String baseCodeType) {
		this.baseCodeType = baseCodeType;
	}
	public String getBaseCodeTypeName() {
		return baseCodeTypeName;
	}
	public void setBaseCodeTypeName(String baseCodeTypeName) {
		this.baseCodeTypeName = baseCodeTypeName;
	}
	public Integer getIsTrue() {
		return isTrue;
	}
	public void setIsTrue(Integer isTrue) {
		this.isTrue = isTrue;
	}
	
}
