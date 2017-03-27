package com.wanglei.graempinf_core.graempinf_core.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * <p>Title: 用户组</p>
 * <p>Description: 用户组的组成</p>
 * <p>Copyright: Copyright wanglei(c) 2017</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">WangLei</a>
 * @version 1.0
 * @history:
 * Created by WangLei 2017年1月21日
 */
@Entity
@Table(name="T_GROUP")
public class Group implements Serializable{
	
	private static final long serialVersionUID = -2514675141180991500L;

	/**
	 * 用户组ID
	 */
	private String gruopUuid;
	
	/**
	 * 用户组名称
	 */
	private String groupName;
	
	/**
	 * 用户组代码
	 */
	private int groupCode;
	
	/**
	 * 父组代码
	 */
	private int parentGroupCode;
	
	/**
	 * 组信息描述
	 */
	private String groupDesc;
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	public String getGruopUuid() {
		return gruopUuid;
	}

	public String getGroupName() {
		return groupName;
	}

	public int getGroupCode() {
		return groupCode;
	}

	public int getParentGroupCode() {
		return parentGroupCode;
	}

	public String getGroupDesc() {
		return groupDesc;
	}

	public void setGruopUuid(String gruopUuid) {
		this.gruopUuid = gruopUuid;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void setGroupCode(int groupCode) {
		this.groupCode = groupCode;
	}

	public void setParentGroupCode(int parentGroupCode) {
		this.parentGroupCode = parentGroupCode;
	}

	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}
	@Override
	public String toString() {
		return "Group [gruopUuid=" + gruopUuid + ", groupName=" + groupName + ", groupCode=" + groupCode + ", parentGroupCode=" + parentGroupCode + ", groupDesc=" + groupDesc + "]";
	}

	public Group() {
		super();
	}
}
