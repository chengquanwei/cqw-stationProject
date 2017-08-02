package com.yszc.blog.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yszc.blog.dto.Article;
import com.yszc.blog.dto.Tag;
import com.yszc.blog.service.ArticleService;
import com.yszc.blog.service.TagService;
import com.yszc.blog.utils.BaseController;
import com.yszc.blog.utils.BlogResponse;

@Controller
@RequestMapping("/article")
public class ArticleController extends BaseController{
	private final Logger logger = Logger.getLogger(ArticleController.class);
	  @Autowired  
	  private ArticleService articleService;  
	  @Autowired
	  private TagService tagService;  
	   
		/**
		 * @author cqw
		 * @date 2017年7月22日15:39:48
		 * @Description 得到所有的文章列表
		 */
	  @RequestMapping(value = "/getAllArticle",method = RequestMethod.POST)
	  public @ResponseBody BlogResponse getAllArticle(HttpServletRequest request){  
		  logger.info("into getAllArticle.");
		  BlogResponse res = new BlogResponse();
		  List<Article> articles = articleService.getAllArticle();
		  res.success(articles);
	    return res; 
	  }
	  
	  /**
		 * @author cqw
		 * @date 2017年7月22日15:39:48
		 * @Description 得到所有的文章列表
		 */
	  @RequestMapping(value = "/getArticleInfoById",method = RequestMethod.POST)
	  public @ResponseBody BlogResponse getArticleInfoById(String id,HttpServletRequest request){  
		  logger.info("into getAllArticle.");
		  BlogResponse res = new BlogResponse();
		  Article article = articleService.getArticleById(Integer.parseInt(id));
		  res.success(article);
	    return res; 
	  }
	  /**
	   * @author cqw
	   * @date 2017年7月23日10:13:52
	   * @Description 新建博客
	   * 
	   * 	需求：新建博客的时，若所带标签数据库中已存在，则将存在的标签id和博客id存入关联表中
	   * 				       若所带标签数据库中不存在，则将不存在的标签存入数据库并返回标签id，并将标签id和博客id存入关联表中
	   * 
	   * 	并且在将标签id和博客id存入关联表之前也需要检测数据库是否已经存在这种关联关系，如果存在，就不再添加
	   */
	  @RequestMapping(value = "/addArticle",method = RequestMethod.POST)
	  public @ResponseBody BlogResponse addArticle( Article article,@RequestParam("tagName") String tagName, HttpServletRequest request){  
		  logger.info("into addArticle.");
		  article.setUpdatedTime(new Date());
		  article.setCreatedTime(new Date());
		  if(tagName != null && !"".equals(tagName)){
			  List<Tag> tags = new ArrayList<Tag>();
			  String[] tagNames = tagName.split(",");
			  for(String tName:tagNames){
				  Tag tag = new Tag();
				  Tag isTag = tagService.getTagInfoByName(tName);
				  if(isTag != null){
					  tag.setId(isTag.getId());
					  logger.info("已经存在的标签:"+ isTag.toString());
				  }else{
					 logger.info("添加标签:"+tName);
					 tag.setName(tName);
					 tagService.addTag(tag);
					 logger.info("添加标签后的id:"+tag.getId());
				  }
				  tags.add(tag);
			  }
			  article.setTags(tags);
			  article.setUser(getCurrentUser());
		  }
		  articleService.addArticle(article);
		  BlogResponse res = new BlogResponse();
		  res.success(article);
		  return res; 
	  }
	  
	  /**
	   * @author cqw
	    * @date 2017年7月25日下午10:21:52
	    * @Description 修改博客
	    * 				缺少删除博客与标签的关联关系（在js中单独调用一个方法进行删除）
	   */
	  @RequestMapping(value = "/updateArticle",method = RequestMethod.POST)
	  public @ResponseBody BlogResponse updateArticle(Article article,@RequestParam("tagName") String tagName, HttpServletRequest request){
		  article.setUpdatedTime(new Date());
		  if(tagName != null && !"".equals(tagName)){
			  List<Tag> tags = new ArrayList<Tag>();
			  String[] tagNames = tagName.split(",");
			  for(String tName:tagNames){
				  Tag tag = new Tag();
				  Tag isTag = tagService.getTagInfoByName(tName);
				  if(isTag != null){
					  tag.setId(isTag.getId());
				  }else{
					 tag.setName(tName);
					 tagService.addTag(tag);
				  }
				  tags.add(tag);
			  }
			  article.setTags(tags);
			  article.setUser(getCurrentUser());
		  }
		  articleService.updateArticle(article);
		  BlogResponse res = new BlogResponse();
		  res.success();
		  return res; 
	  }
}  
