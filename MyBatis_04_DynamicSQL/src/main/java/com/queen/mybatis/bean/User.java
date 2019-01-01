package com.queen.mybatis.bean;

import javax.management.relation.Role;

/**
 * @since 2017-08-08
 * @author queen 
 * 定义一个Java类
 *
 */
public class User {
	// ID，唯一性
	private int id;
	// 登录ID
	private String loginId;
	// 用户名
	private String userName;
	// 角色
	private Role role;
	// 备注
	private String note;
 
        public User(){
 
        }
         
	public User(int id, String loginId, String userName, Role role, String note) {
		this.id = id;
		this.loginId = loginId;
		this.userName = userName;
		this.role = role;
		this.note = note;
	}
 
	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
 
	public String getLoginId() {
		return loginId;
	}
 
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
 
	public String getUserName() {
		return userName;
	}
 
	public void setUserName(String userName) {
		this.userName = userName;
	}
 
	public Role getRole() {
		return role;
	}
 
	public void setRole(Role role) {
		this.role = role;
	}
 
	public String getNote() {
		return note;
	}
 
	public void setNote(String note) {
		this.note = note;
	}
 
	@Override
	public String toString() {
		return "com.queen.mybatis.bean.User [id=" + id + ", loginId=" + loginId + ", userName="
				+ userName + ", role=" + role + ", note=" + note + "]";
	}
 
}