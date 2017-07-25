package com.yszc.blog.dao;

import java.util.List;

import com.yszc.blog.dto.Article;
import com.yszc.blog.dto.Tag;

public interface ArticleDao {

	/**
	 * @author cqw
	  * @date 2017年7月22日下午3:07:27
	  * @Description 得到所有文章列表
	 */
	public List<Article> getAllArticle();  
	
	public List<Tag> getTagById();
	/**
	 * @author cqw
	  * @date 2017年7月22日下午3:08:14
	  * @Description 得到当前登录用户的所有文章列表
	 */
	public List<Article> getAllArticleByUserId(Integer id);  
	
	/**
	 * @author cqw
	  * @date 2017年7月22日下午3:30:16
	  * @Description 根据id得到该文章的信息
	 */
	public Article getArticleInfoById(Integer id);  
	/**
	 * @author cqw
	  * @date 2017年7月22日下午3:08:14
	  * @Description 根据id得到该文章的具体内容
	 */
	public Article queryByPrimaryKey(Integer id);
	
	/**
	 * @author cqw
	  * @date 2017年7月22日下午3:12:31
	  * @Description 添加
	 */
	public void insertArticle(Article article);
	public void insertArticleTag(Article article);
	
	/**
	 * @author cqw
	  * @date 2017年7月22日下午3:13:20
	  * @Description 删除
	 */
	public void deleteByPrimaryKey(Integer id); 
	/**
	 * @author cqw
	  * @date 2017年7月22日下午3:15:47
	  * @Description 更新
	 */
	public void updateArticle(Article article);
}
