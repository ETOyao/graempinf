package com.wanglei.graempinf_core.graempinf_core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * <p>Title:学校组织信息 </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright wanglei(c) 2017</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">WangLei</a>
 * @version 1.0
 * @history:
 * Created by WangLei 2017年2月8日
 */
@Entity
@Table(name="t_org")
public class Org {
	
	public static final String ROOT_NAME = "网站根组织机构";
	public static final int ROOT_ID = 0;
	/**
	 * 组织机构的id
	 */
	private int id;
	/**
	 * 组织机构的名称
	 */
	private String name;
	/**
	 * 组织机构的排序号
	 */
	private Integer orderNum;
	public Integer getTypeId() {
		return typeId;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	/**
	 * 组织机构所属类型的id，此处不要使用ManyToOne
	 */
	private Integer typeId;
	
	/**
	 * 组织机构的父亲组织
	 */
	private Org parent;
	/**
	 * 组织机构的地址
	 */
	private String address;
	/**
	 * 组织机构的电话
	 */
	private String phone;
	private String orgCode;
	
	/**
	 * 扩展属性1，用于在针对某些特殊的组织存储相应的信息
	 */
	private String att1;
	/**
	 * 扩展属性2，用于在针对某些特殊的组织存储相应的信息
	 */
	private String att2;
	/**
	 * 扩展属性3，用于在针对某些特殊的组织存储相应的信息
	 */
	private String att3;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="order_num")
	public Integer getOrderNum() {
		return orderNum;
	}
	@NotEmpty(message="组织机构的名称不能为空")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	@JoinColumn(name="pid")
	public Org getParent() {
		return parent;
	}
	public void setParent(Org parent) {
		this.parent = parent;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAtt1() {
		return att1;
	}
	public void setAtt1(String att1) {
		this.att1 = att1;
	}
	public String getAtt2() {
		return att2;
	}
	public void setAtt2(String att2) {
		this.att2 = att2;
	}
	public String getAtt3() {
		return att3;
	}
	public void setAtt3(String att3) {
		this.att3 = att3;
	}
	
	@Override
	public boolean equals(Object obj) {
		Org o = (Org)obj;
		return this.id==o.getId();
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public Org() {
	}
	public Org(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Org(String name, String orgCode) {
		super();
		this.name = name;
		this.orgCode = orgCode;
	}
	@Override
	public String toString() {
		return "Org [id=" + id + ", name=" + name + ", typeId=" +typeId+ ", orderNum=" + orderNum + ", parent=" + parent +
				 ", address=" + address + ", phone=" + phone + ", orgCode=" + orgCode + ", att1=" + att1 + ", att2=" + att2 + ", att3=" + att3 + "]";
	}
}
