package com.ljf.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ljf.entity.Picture;

@Repository
public interface PictureDao {
	
	/**
	 * 返回全部图片
	 * @param map
	 * @return
	 */
	public List<Picture> findPicture(Map<String, Object> map);
	
	/**
	 * 返回数据的数目
	 * @param map
	 * @return
	 */
	public Long getTotalPicture(Map<String, Object> map);
	
	/**
	 * 添加图片
	 * @param picture
	 * @return
	 */
	public int insertPicture(Picture picture);
	
	/**
	 * 对图片进行修改
	 * @param picture
	 * @return
	 */
	public int updatePicture(Picture picture);
	
	/**
	 * 根据ID删除图片
	 * @param id
	 * @return
	 */
	public int deletePicture(String id);
	
	/**
	 * 根据ID查询图片
	 * @param id
	 * @return
	 */
	public Picture findPictureById(String id);
}
