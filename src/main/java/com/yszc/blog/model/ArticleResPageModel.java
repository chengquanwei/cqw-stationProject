package com.yszc.blog.model;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yszc.blog.dto.Article;

public class ArticleResPageModel {

    List<Article> articlesPage;
    PageInfo<Article> page;
	  
	public List<Article> getArticlesPage() {
		return articlesPage;
	}
	public void setArticlesPage(List<Article> articlesPage) {
		this.articlesPage = articlesPage;
	}
	public PageInfo<Article> getPage() {
		return page;
	}
	public void setPage(PageInfo<Article> page) {
		this.page = page;
	}
}
