package com.wanglei.graempinf_core.graempinf_core.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;

/**
 * <p>Title: 用户类的实体类</p>
 * <p>Description: 用户信息</p>
 * <p>Copyright: Copyright wanglei(c) 2017</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">WangLei</a>
 * @version 1.0
 * @history:
 * Created by WangLei 2017年1月21日
 */
@Entity
@Table(name="T_USER")
public class User{

	/**
	 * 用户UUID
	 */
	private String userUuid;
	
	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 用户密码
	 */
	private String userPassWord;
	
	/**
	 * 用户中文名
	 */
	private String userNickName;
	
	/**
	 * 用户邮件
	 */
	private String userEmail;
	
	/**
	 * 用户电话
	 */
	private String userPhone;
	
	/**
	 * 用户状态 0：停用 1：启用
	 */
	private int userStatus;
	
	/**
	 * 学生id
	 */
	private String stuUuid;
	/**
	 * 创建时间
	 */
	private Timestamp createDate;
	@Column(name="create_date")
	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	public String getUserUuid() {
		return userUuid;
	}
	@NotNull(message="用户名不能为空！")
	public String getUserName() {
		return userName;
	}
	@NotNull(message="用户密码不能为空！")
	public String getUserPassWord() {
		return userPassWord;
	}

	public String getUserNickName() {
		return userNickName;
	}
	@Email(message="邮件格式不正确！")
	public String getUserEmail() {
		return userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}


	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserPassWord(String userPassWord) {
		this.userPassWord = userPassWord;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	

	public int getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [userUuid=" + userUuid + ", userName=" + userName + ", userPassWord=" + userPassWord + ", userNickName=" + userNickName + ", userEmail=" + userEmail + ", userPhone="
				+ userPhone + ", userStatus=" + userStatus + ", createDate=" + createDate + "]";
	}

	public String getStuUuid() {
		return stuUuid;
	}

	public void setStuUuid(String stuUuid) {
		this.stuUuid = stuUuid;
	}
	
}
