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

import com.ljf.entity.PapeBean;
import com.ljf.entity.Picture;
import com.ljf.service.PictureServiceImpl;
import com.ljf.util.DateUtil;
import com.ljf.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/picture")
public class PictureController {

	@Resource
	private PictureServiceImpl pictureServiceImpl;
	private static final Logger log = Logger.getLogger(PictureController.class);// 日志文件
	
	/**
	 * 
	 * @param page
	 * @param rows
	 * @param picture
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(
			@RequestParam(value = "page", required = false)String page,
			@RequestParam(value = "rows", required = false)String rows,
			Picture picture,HttpServletResponse response) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		if (page != null && rows != null) {
			PapeBean papeBean = new PapeBean(Integer.parseInt(page),
					Integer.parseInt(rows));
			map.put("start", papeBean.getStart());
			map.put("size",papeBean.getPageSize());
		}
		if (picture != null) {
			map.put("id", picture.getId() + "");
			map.put("type", picture.getType() + "");
			map.put("grade", picture.getGrade() + "");
		}
		@SuppressWarnings("unused")
		List<Picture> pictureList = pictureServiceImpl.findPicture(map);
		Long total = pictureServiceImpl.getTotalPicture(map);
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(result);
		result.put("rows", jsonArray);
		result.put(total, total);
		log.info("request: picture/list , map: " + map.toString());
		ResponseUtil.write(response, result);
		return null;
	}
	
	@RequestMapping("/save")
	public String save(Picture picture, HttpServletResponse response)
			throws Exception {
		int resultTotal = 0; 
		if (picture.getId() == null) {
			picture.setTime(DateUtil.getCurrentDateStr());
			resultTotal = pictureServiceImpl.insertPicture(picture);
		} else {
			System.out.println(picture.getPath());
			resultTotal = pictureServiceImpl.updatePicture(picture);
		}
		JSONObject result = new JSONObject();
		if (resultTotal > 0) { 
			result.put("success", true);
		} else {
			result.put("success", false);
		}
		log.info("request: picture/save ,  " + picture.toString());
		ResponseUtil.write(response, result);
		return null;
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam(value = "ids") String ids,
			HttpServletResponse response) throws Exception {
		JSONObject result = new JSONObject();
		String[] idsStr = ids.split(",");
		for (int i = 0; i < idsStr.length; i++) {
			pictureServiceImpl.deletePicture(idsStr[i]);
		}
		result.put("success", true);
		log.info("request: picture/delete , ids: " + ids);
		ResponseUtil.write(response, result);
		return null;
	}
	
	@RequestMapping("/findById")
	public String findById(@RequestParam(value = "id") String id,
			HttpServletResponse response) throws Exception {
		Picture picture = pictureServiceImpl.findPictureById(id);
		JSONObject jsonObject = JSONObject.fromObject(picture);
		log.info("request: picture/findById");
		ResponseUtil.write(response, jsonObject);
		return null;
	}
}
