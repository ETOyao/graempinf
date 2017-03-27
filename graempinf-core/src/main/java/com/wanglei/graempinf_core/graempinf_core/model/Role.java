package com.wanglei.graempinf_core.graempinf_core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.wanglei.graempinf_core.graempinf_core.Enum.RoleType;

/**
 * <p>Title: 角色</p>
 * <p>Description: 角色控制 用例对应可以访问的资源</p>
 * <p>Copyright: Copyright wanglei(c) 2017</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">WangLei</a>
 * @version 1.0
 * @history:
 * Created by WangLei 2017年1月21日
 */
@Entity
@Table(name="T_ROLE")
public class Role implements Serializable{
	
	private static final long serialVersionUID = 6888951345893940478L;

	/**
	 * 角色id
	 */
	private String roleUuid;
	
	/**
	 * 角色名称
	 */
	private String roleName;
	
	/**
	 * 角色代码
	 */
	private int roleCode;
	 
	
	/**
	 * 角色编号
	 */
	private RoleType roleType;

	/**
	 * 角色描述
	 */
	private String roleDesc;
	@Enumerated(EnumType.ORDINAL)
	@Column(name="role_type")
	public RoleType getRoleType() {
		return roleType;
	}
	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}
	public Role() {
		super();
	}
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	public String getRoleUuid() {
		return roleUuid;
	}

	public String getRoleName() {
		return roleName;
	}

	

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleUuid(String roleUuid) {
		this.roleUuid = roleUuid;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	

	public int getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(int roleCode) {
		this.roleCode = roleCode;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	@Override
	public String toString() {
		return "Role [roleUuid=" + roleUuid + ", roleName=" + roleName + ", roleCode=" + roleCode + ", rolesn=" + roleType + ", roleDesc=" + roleDesc + "]";
	}

	
}
