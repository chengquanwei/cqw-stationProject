package com.yszc.blog.service.Impl;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yszc.blog.dao.TagDao;
import com.yszc.blog.dto.Tag;
import com.yszc.blog.service.TagService;

@Service("tagService")
public class TagServiceImpl implements TagService{
	private final Logger logger = Logger.getLogger(TagServiceImpl.class);
	
	@Resource  
    private TagDao tagDao;  
	
	/**
	 * @author cqw
	 * @date 2017年7月24日22:22:18
	 * @description 根据标签名字查找标签信息
	 */
	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public Tag getTagInfoByName(String name) {
		logger.info("into getTagInfoByName.");
		return tagDao.getTagInfoByName(name);
	}

	/**
	 * @author cqw
	 * @date 2017年7月24日22:23:13
	 * @description 添加标签
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Integer addTag(Tag tag) {
		logger.info("into addTag.");
		tag.setCreatedTime(new Date());
		tag.setUpdatedTime(new Date());
		return tagDao.insertTag(tag);
	}

}
