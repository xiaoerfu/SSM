package com.ljf.dao;

import java.util.List;
import java.util.Map;

import com.ljf.entity.Article;

public interface ArticleDao {
	
	/**
	 * 返回数据序列
	 * @param map
	 * @return
	 */
	public List<Article>findArticles(Map<String, Object> map);
	
	/**
	 * 返回数据的数目
	 * @param map
	 * @return
	 */
	public Long getTotalArticles(Map<String, Object>map);
	
	/**
	 * 添加文章
	 * @param article
	 * @return
	 */
	public int insertArticle(Article article);
	
	/**
	 * 更新文章
	 * @param article
	 * @return
	 */
	public int updArticle(Article article);
	
	/**
	 * 删除文章
	 * @param id
	 * @return
	 */
	public int delArticle(String id);
	
	/**
	 * 根据ID查询文章
	 * @param id
	 * @return
	 */
	public Article findById(String id);

}
