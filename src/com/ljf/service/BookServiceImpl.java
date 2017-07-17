package com.ljf.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.ljf.entity.Book;

public interface BookServiceImpl extends Serializable{

	/**
     * 返回相应的数据集合
     *
     * @param map
     * @return
     */
    public List<Book> findBooks(Map<String, Object> map);

    /**
     * 数据数目
     *
     * @param map
     * @return
     */
    public Long getTotalBooks(Map<String, Object> map);

    /**
     * 添加书籍
     *
     * @param book
     * @return
     */
    public int insertBook(Book book);

    /**
     * 根据id查找
     *
     * @param id
     * @return
     */
    public Book getBookById(String id);
}
