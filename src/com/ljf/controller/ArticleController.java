package com.ljf.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ljf.entity.Article;
import com.ljf.entity.PapeBean;
import com.ljf.service.ArticleServiceImpl;
import com.ljf.util.DateUtil;
import com.ljf.util.ResponseUtil;
import com.ljf.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Resource
	private ArticleServiceImpl articleServiceImpl;
	private static final Logger log = Logger.getLogger(ArticleController.class);
	
	/**
	 * 查找相对应的数据集合
	 * @param page
	 * @param rows
	 * @param article
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(
			@RequestParam(value = "page",required = false)String page,
			@RequestParam(value = "rows",required = false)String rows,
			Article article,HttpServletResponse response) throws Exception{
		
		Map<String, Object> map = new HashMap<String, Object>();
		if (page != null && rows != null) {
			PapeBean papeBean = new PapeBean(Integer.parseInt(page), Integer.parseInt(rows));
			map.put("start", papeBean.getStart());
			map.put("size", papeBean.getPageSize());
		}
		if (article != null) {
			map.put("articleTitle", StringUtil.formatLike(article.getArticleTitle()));
		}
		List<Article> articleList = articleServiceImpl.findArticles(map);
		Long total = articleServiceImpl.getTotalArticles(map);
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(articleList);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		log.info("request: article/list , map: " + map.toString());
		System.out.println(map.toString());
		return null;
	}
	
	/**
	 * 保存数据或者修改数据
	 * @param article
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(Article article,HttpServletResponse response) throws Exception{
		int resultTotal = 0;
		if (article.getId() == null) {
			article.setArticleCreateDate(DateUtil.getCurrentDateStr());
			resultTotal = articleServiceImpl.insertArticle(article);
		}else{
			resultTotal = articleServiceImpl.updArticle(article);
		}
		JSONObject result = new JSONObject();
		if (resultTotal > 0) {
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		log.info("request: article/save , " + article.toString());
		return null;
	}
	
	/**
	 * 删除
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam(value = "ids")String ids,HttpServletResponse response) throws Exception{
		JSONObject result = new JSONObject();
		String[] idsStr = ids.split(",");
		for (int i = 0; i < idsStr.length; i++) {
			articleServiceImpl.delArticle(idsStr[i]);
		}
		result.put("success", true);
		ResponseUtil.write(response, result);
		log.info("request: article/delete , ids: " + ids);
		return null;
	}
	
	/**
	 * 根据id查找
	 * 
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findById")
	public String findById(@RequestParam(value = "id") String id,
			HttpServletResponse response) throws Exception {
		Article article = articleServiceImpl.findArticleById(id);
		JSONObject jsonObject = JSONObject.fromObject(article);
		ResponseUtil.write(response, jsonObject);
		System.out.println(article.toString());
		log.info("request: article/findById");
		return null;
	}
}
