package com.wanglei.graempinf_core.graempinf_core.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * <p>Title:用户和角色的关系</p>
 * <p>Description: 描述用户和角色的关系</p>
 * <p>Copyright: Copyright wanglei(c) 2017</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">WangLei</a>
 * @version 1.0
 * @history:
 * Created by WangLei 2017年1月21日
 */
@Entity
@Table(name="T_USER_ROLE")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 343719825332204595L;
	
	/**
	 * 对应关系uuid
	 */
	private String userRoleUuid;
	
	/**
	 * 角色
	 */
	private Role role;
	
	/**
	 * 用户
	 */
	private User user;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="r_uuid")
	public Role getRole() {
		return role;
	}
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	public String getUserRoleUuid() {
		return userRoleUuid;
	}
	public void setUserRoleUuid(String userRoleUuid) {
		this.userRoleUuid = userRoleUuid;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="u_uuid")
	public User getUser() {
		return user;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "UserRole [userRoleUUID=" + userRoleUuid + ", role=" + role + ", user=" + user + "]";
	}
	public UserRole() {
		super();
	}
	
	

}
