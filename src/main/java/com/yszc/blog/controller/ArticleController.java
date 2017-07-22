package com.yszc.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yszc.blog.dto.Article;
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
		 * @Description 得到所以的文章列表
		 */
	  @RequestMapping(value = "/getAllArticle",method = RequestMethod.POST)
	  public @ResponseBody BlogResponse getAllArticle(HttpServletRequest request){  
		  logger.info("into getAllArticle.");
		  BlogResponse res = new BlogResponse();
		  List<Article> articles = articleService.getAllArticle();
		  res.success(articles);
	    return res; 
	  }
}  
