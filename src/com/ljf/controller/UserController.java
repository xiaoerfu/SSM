package com.ljf.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ljf.entity.PapeBean;
import com.ljf.entity.User;
import com.ljf.service.UserServiceImpl;
import com.ljf.util.MD5Util;
import com.ljf.util.ResponseUtil;
import com.ljf.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserServiceImpl userService;
	private static final Logger log = Logger.getLogger(UserController.class);// 日志文件
	
	/**
	 * 登录
	 * @param user
	 * @param request
	 * @return
	 */
	  @RequestMapping("/login")
	    public String login(User user, HttpServletRequest request) {
	        try {
	            String MD5pwd = MD5Util.MD5Encode(user.getPassword(), "UTF-8");
//	        	String ps = user.getPassword();
	            user.setPassword(MD5pwd);
	        } catch (Exception e) {
	            user.setPassword("");
	        }
	        User resultUser = userService.login(user);
	        if (resultUser == null) {
	            request.setAttribute("user", user);
	            request.setAttribute("errorMsg", "请认真核对账号、密码！");
	            return "login";
	        } else {
	            HttpSession session = request.getSession();
	            session.setAttribute("currentUser", resultUser);
	            return "redirect:/main.jsp";
	        }
	    }
	  
	  /**
	   * 退出登录
	   * @param session
	   * @return
	   * @throws Exception
	   */
	  @RequestMapping("/logout")
	  public String logout(HttpSession session) throws Exception {
	        session.invalidate();
	        log.info("request: user/logout");
	        return "redirect:/login.jsp";
	    }
	  
	  /**
	   * 
	   * @param page
	   * @param rows
	   * @param s_user
	   * @param response
	   * @return
	   * @throws Exception
	   */
	  @RequestMapping("/list")
	  public String list(@RequestParam(value = "page",required = false)String page,@RequestParam(value = "rows",required = false)String rows,User s_user,HttpServletResponse response) throws Exception{
		  
		    PapeBean pageBean = new PapeBean(Integer.parseInt(page), Integer.parseInt(rows), 0);
	        Map<String, Object> map = new HashMap<String, Object>();
	        map.put("userName", StringUtil.formatLike(s_user.getUserName()));
	        map.put("start", pageBean.getStart());
	        map.put("size", pageBean.getPageSize());
	        List<User> userList = userService.findUsers(map);
	        Long total = userService.getTotalUser(map);
	        JSONObject result = new JSONObject();
	        JSONArray jsonArray = JSONArray.fromObject(userList);
	        result.put("rows", jsonArray);
	        result.put("total", total);
	        log.info("request: user/list , map: " + map.toString());
	        ResponseUtil.write(response, result);
	        return null;
		  
	  }
	  
	  @RequestMapping("/save")
	  public String save(User user,HttpServletResponse response) throws Exception{
		  int resultTotal = 0;
		  String MD5psd = MD5Util.MD5Encode(user.getPassword(), "UTF-8");
		  user.setPassword(MD5psd);
		  if(user.getId() == null){
			  resultTotal = userService.addUser(user);
		  }else{
			  resultTotal = userService.updateUser(user);
		  }
		  JSONObject result = new JSONObject();
		  if(resultTotal > 0 ){
			  result.put("success", true);
		  }else{
			  result.put("success", false);
		  }
		  ResponseUtil.write(response, result);
		  return null;
	  }
	  
	  
	  

}
