package com.ljf.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ljf.dao.ArticleDao;
import com.ljf.entity.Article;

@Service("articleService")
public class ArticleService implements ArticleServiceImpl {

	@Resource
	private ArticleDao articleDao;
	
	@Override
	public List<Article> findArticles(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return articleDao.findArticles(map);
	}

	@Override
	public Long getTotalArticles(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return articleDao.getTotalArticles(map);
	}

	@Override
	public int insertArticle(Article article) {
		// TODO Auto-generated method stub
        if (article.getArticleTitle() == null || article.getArticleContent() == null || getTotalArticles(null) > 90 || article.getArticleContent().length() > 50000) {
            return 0;
        }
        return articleDao.insertArticle(article);
	}

	@Override
	public int updArticle(Article article) {
		// TODO Auto-generated method stub
		return articleDao.updArticle(article);
	}

	@Override
	public int delArticle(String id) {
		// TODO Auto-generated method stub
		return articleDao.delArticle(id);
	}

	@Override
	public Article findArticleById(String id) {
		// TODO Auto-generated method stub
		return articleDao.findById(id);
	}

}
