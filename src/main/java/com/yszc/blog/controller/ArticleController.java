package com.yszc.blog.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yszc.blog.dto.Article;
import com.yszc.blog.dto.Tag;
import com.yszc.blog.service.ArticleService;
import com.yszc.blog.utils.BlogResponse;

@Controller
@RequestMapping("/article")
public class ArticleController {
	private final Logger logger = Logger.getLogger(ArticleController.class);
	  @Autowired  
	  private ArticleService articleService;  
	   
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
	   * @date 2017年7月23日10:13:52
	   * @Description 新建博客
	   * 
	   * 	需求：新建博客的时，若所带标签数据库中已存在，则将存在的标签id和博客id存入关联表中
	   * 				       若所带标签数据库中不存在，则将不存在的标签存入数据库并返回标签id，并将标签id和博客id存入关联表中
	   * 
	   * 	并且在将标签id和博客id存入关联表之前也需要检测数据库是否已经存在这种关联关系，如果存在，就不再添加
	   */
	  @RequestMapping(value = "/addArticle",method = RequestMethod.POST)
	  public @ResponseBody BlogResponse addArticle( Article article,@RequestParam("tagId") String tagId, HttpServletRequest request){  
		  logger.info("into addArticle.");
		  article.setUpdatedTime(new Date());
		  article.setCreatedTime(new Date());
		  if(tagId != null && !"".equals(tagId)){
			  List<Tag> tags = new ArrayList<Tag>();
			  String[] tagIds = tagId.split(",");
			  for(String tId:tagIds){
				  Tag tag = new Tag();
				  tag.setId(Integer.parseInt(tId));
				  tags.add(tag);
			  }
			  article.setTags(tags);
		  }
		  articleService.addArticle(article);
		  BlogResponse res = new BlogResponse();
		  res.success();
		  return res; 
	  }
}  
