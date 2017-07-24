package com.yszc.blog.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
		articleDao.insertArticleTag(article);
	}

	@Override
	public void deleteArticleById(Integer articleId) {
		articleDao.deleteByPrimaryKey(articleId);
	}

	@Override
	public void updateArticle(Article article) {
		articleDao.updateArticle(article);
	}

}
