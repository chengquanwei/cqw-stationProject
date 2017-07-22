package com.yszc.blog.dto;

import java.util.Date;

public class Article {
	private Integer id;
	private String title;
	private String article;
	private String type;
	private String tags;//标签
	private Integer userId;
	private Date createdTime;
	private Date updatedTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	
	@Override
	public String toString() {
		return "Article [id=" + id + ", article=" + article + ", type=" + type
				+ ", tags=" + tags + ", userId=" + userId + ", createdTime="
				+ createdTime + ", updatedTime=" + updatedTime + "]";
	}
	
}
