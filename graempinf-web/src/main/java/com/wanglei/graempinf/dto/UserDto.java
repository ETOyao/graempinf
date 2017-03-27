package com.wanglei.graempinf.dto;

import java.sql.Timestamp;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import com.wanglei.graempinf_core.graempinf_core.model.User;

public class UserDto {
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
	 * 角色id
	 */
	private String [] roleIds;
	
	/**
	 * 组id
	 */
	private String [] groupIds;
	private Timestamp createDate;
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
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
	public int getUserStatus() {
		return userStatus;
	}
	public String[] getRoleIds() {
		return roleIds;
	}
	public String[] getGroupIds() {
		return groupIds;
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
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	public void setRoleIds(String[] roleIds) {
		this.roleIds = roleIds;
	}
	public void setGroupIds(String[] groupIds) {
		this.groupIds = groupIds;
	}
	public User getUser(){
		User u = new User();
		u.setUserUuid(this.userUuid);
		u.setUserEmail(this.userEmail);
		u.setUserName(this.userName);
		u.setUserNickName(this.userNickName);
		u.setUserPassWord(this.userPassWord);
		u.setUserPhone(this.userPhone);
		u.setUserStatus(this.userStatus);
		u.setCreateDate(this.createDate);
		return u;
	}
	public UserDto(User u){
		this.setUserEmail(u.getUserEmail());
		this.setUserName(u.getUserName());
		this.setUserNickName(u.getUserNickName());
		this.setUserPassWord(u.getUserPassWord());
		this.setUserPhone(u.getUserPhone());
		this.setUserStatus(u.getUserStatus());
		this.setUserUuid(u.getUserUuid());
		this.setCreateDate(u.getCreateDate());
	}
	public UserDto(User u,String [] roleIds ,String [] groupIds){
		this.setUserEmail(u.getUserEmail());
		this.setUserName(u.getUserName());
		this.setUserNickName(u.getUserNickName());
		this.setUserPassWord(u.getUserPassWord());
		this.setUserPhone(u.getUserPhone());
		this.setUserStatus(u.getUserStatus());
		this.setUserUuid(u.getUserUuid());
		this.setGroupIds(groupIds);
		this.setRoleIds(roleIds);
		this.setCreateDate(u.getCreateDate());
	}
	public UserDto(User u,List<String>roleIds ,List<String>groupIds){
		this.setUserEmail(u.getUserEmail());
		this.setUserName(u.getUserName());
		this.setUserNickName(u.getUserNickName());
		this.setUserPassWord(u.getUserPassWord());
		this.setUserPhone(u.getUserPhone());
		this.setUserStatus(u.getUserStatus());
		this.setUserUuid(u.getUserUuid());
		this.setGroupIds(listToArray(groupIds));
		this.setRoleIds(listToArray(roleIds));
		this.setCreateDate(u.getCreateDate());
	}
	/**
	 * <p>Description:将list装换成数组<p>
	 * @param args
	 * @return
	 * @author WangLei 2017年2月1日
	 */
	private String [] listToArray(List<String> args){
		String [] resArray =new String [args.size()];
		for(int i=0,j = args.size();i<j;i++){
			resArray[i] = args.get(i);
		}
		return resArray;
	}
	public UserDto(){}
}
