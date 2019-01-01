package com.queen.mybatis.bean;

/**
 * @since 2017-08-08
 * @author queen 
 * 定义一个Java类Role
 *
 */
public class Role {
	private int id;
	private String roleName;
 
	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
 
	public String getRoleName() {
		return roleName;
	}
 
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
 
        public Role(){
 
        }
        
	public Role(int id, String roleName) {
		this.id = id;
		this.roleName = roleName;
	}
 
	@Override
	public String toString() {
		return "com.queen.mybatis.bean.Role [id=" + id + ", roleName=" + roleName + "]";
	}
 
}