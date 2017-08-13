package com.yszc.blog.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yszc.blog.dao.ArticleDao;
import com.yszc.blog.dto.Article;
import com.yszc.blog.service.ArticleService;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService{
	private final Logger logger = Logger.getLogger(ArticleServiceImpl.class);
	
	@Resource  
    private ArticleDao articleDao;  

	@Override
	public Article getArticleById(Integer articleId) {
		logger.info("Entry getArticleById.");
		return articleDao.getArticleInfoById(articleId);
	}

	@Override
	public List<Article> getAllArticle() {
		return articleDao.getAllArticle();
	}

	@Override
	public List<Article> getAllArticleByUserId(Integer id) {
		return articleDao.getAllArticleByUserId(id);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void addArticle(Article article) {
		logger.info("into addArticle.");
		articleDao.insertArticle(article);
		if(article != null && article.getTags() != null && article.getTags().size() > 0){
			articleDao.insertArticleTag(article);
		}
	}

	@Override
	public void deleteArticleById(Integer articleId) {
		articleDao.deleteByPrimaryKey(articleId);
	}

	@Override
	public void updateArticle(Article article) {
		articleDao.updateArticle(article);
		if(article != null && article.getTags() != null && article.getTags().size() > 0){
			articleDao.insertArticleTag(article);
		}
	}

	//为什么没加事务注解也可以执行
	@Override
	public void deleteArticleTag(Integer articleId, String tagId) {
		logger.info("articleId:"+articleId+",tagId:"+tagId);
		articleDao.deleteArticleTag(articleId, tagId);
	}

	/**
	 * @author cqw
	 * @date 2017年8月13日12:20:34
	 * @description 分页查询博客列表
	 */
	@Override
	public List<Article> queryAllArticleByPage(Integer pageNo,
			Integer pageSize) {
		 	pageNo = pageNo == null?1:pageNo;
		    pageSize = pageSize == null?10:pageSize;
		    PageHelper.startPage(pageNo, pageSize);
		    List<Article> list = articleDao.getAllArticle();
		 return list;
	}

}
