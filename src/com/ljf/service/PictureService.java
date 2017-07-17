package com.ljf.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ljf.dao.PictureDao;
import com.ljf.entity.Picture;

@Service("pictureService")
public class PictureService implements PictureServiceImpl {

	@Resource
	private PictureDao pictureDao;
	
	@Override
	public List<Picture> findPicture(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return pictureDao.findPicture(map);
	}

	@Override
	public Long getTotalPicture(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return pictureDao.getTotalPicture(map);
	}

	@Override
	public int insertPicture(Picture picture) {
		// TODO Auto-generated method stub
		if (picture.getPath() == null || getTotalPicture(null) > 90 || picture.getPath().length() > 100 || picture.getUrl().length() > 100) {
			return 0;
		}
		return pictureDao.insertPicture(picture);
	}

	@Override
	public int updatePicture(Picture picture) {
		// TODO Auto-generated method stub
		if (picture.getPath() == null || getTotalPicture(null) > 90 || picture.getPath().length() > 100 || picture.getUrl().length() > 100) {
			return 0;
		}
		return pictureDao.updatePicture(picture);
	}

	@Override
	public int deletePicture(String id) {
		// TODO Auto-generated method stub
		return pictureDao.deletePicture(id);
	}

	@Override
	public Picture findPictureById(String id) {
		// TODO Auto-generated method stub
		return pictureDao.findPictureById(id);
	}

}
