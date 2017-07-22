package com.yszc.blog.dto;

import java.util.Date;

public class User {  
	
    private Integer id;  
  
    private String realName;
    private String userName;
    private String password;  
    private String tel;  
    private String qq;  
    private char authority;  
    private String classDepartment;  
    private Date createdTime;  
    private Date updatedTime;  
    private String introduction;  
    private String sex;  
    
    public Integer getId() {  
        return id;  
    }  
    public void setId(Integer id) {  
        this.id = id;  
    }  
  
    public String getPassword() {  
        return password;  
    }  
    public void setPassword(String password) {  
        this.password = password == null ? null : password.trim();  
    }
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public char getAuthority() {
		return authority;
	}
	public void setAuthority(char authority) {
		this.authority = authority;
	}
	public String getClassDepartment() {
		return classDepartment;
	}
	public void setClassDepartment(String classDepartment) {
		this.classDepartment = classDepartment;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}  
  
} 