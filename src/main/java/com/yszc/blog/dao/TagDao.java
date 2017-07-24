package com.yszc.blog.dao;

import com.yszc.blog.dto.Tag;

public interface TagDao {

	public Tag getTagInfoByName(String name);
	
	public Integer insertTag(Tag tag);
}
