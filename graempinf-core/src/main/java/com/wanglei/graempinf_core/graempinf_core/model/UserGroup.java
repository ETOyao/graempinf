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
 * <p>Title:用户组对象 </p>
 * <p>Description:  存贮用户和组的关联</p>
 * <p>Copyright: Copyright wanglei(c) 2017</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">WangLei</a>
 * @version 1.0
 * @history:
 * Created by WangLei 2017年1月21日
 */
@Entity
@Table(name="T_USER_GROUP")
public class UserGroup implements Serializable{
	private static final long serialVersionUID = 2562849237561592421L;
	
	/**
	 * 用户组关联标示
	 */
	private String userGroupUuid;
	
	/**
	 * 用户
	 */
	private User user;
	
	/**
	 * 用户组
	 */
	private Group group;
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	public String getUserGroupUuid() {
		return userGroupUuid;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="u_uuid",nullable = false)
	public User getUser() {
		return user;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="g_uuid")
	public Group getGroup() {
		return group;
	}

	public void setUserGroupUuid(String userGroupUuid) {
		this.userGroupUuid = userGroupUuid;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "UserGroup [userGroupUuid=" + userGroupUuid + ", user=" + user + ", group=" + group + "]";
	}
	
}
