package com.ljf.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ljf.dao.BookDao;
import com.ljf.entity.Book;

@Service("bookService")
public class BookService implements BookServiceImpl {

	/**
	 * 
	 */
	@Resource
	private BookDao bookDao;
	
	private static final Logger log = Logger.getLogger(BookService.class);
	private static final long serialVersionUID = 1L;

	@Override
	public List<Book> findBooks(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return bookDao.findBooks(map);
	}

	@Override
	public Long getTotalBooks(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return bookDao.getTotalBooks(map);
	}

	@Override
	public int insertBook(Book book) {
		// TODO Auto-generated method stub
		return bookDao.insertBook(book);
	}

	@Override
	public Book getBookById(String id) {
		// TODO Auto-generated method stub
		return bookDao.getBookById(id);
	}

}
