package com.yszc.blog.service;

import com.yszc.blog.dto.Tag;

public interface TagService {

	public Tag getTagInfoByName(String name);
	
	public Integer addTag(Tag tag);
}
