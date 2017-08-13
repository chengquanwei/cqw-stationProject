package com.yszc.blog.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yszc.blog.dto.Article;

public interface ArticleService {

	public Article getArticleById(Integer articleId);  
	  
    public List<Article> getAllArticle();  
    
    public List<Article> getAllArticleByUserId(Integer id);  
    
    public void addArticle(Article article);  
    
    public void deleteArticleById(Integer articleId);  
    
    public void updateArticle(Article article);  
    
    public void deleteArticleTag(Integer articleId,String tagId);
    
    public List<Article> queryAllArticleByPage(Integer pageNo,Integer pageSize);
}
