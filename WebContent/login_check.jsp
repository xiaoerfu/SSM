<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- 防止强制跳转 --%>
    <% 
    	if(session.getAttribute("currentUser") == null){
    		out.println("<script>window.location.href='" + session.getServletContext().getContextPath() + "/login.jsp';</script>");
    	}
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>密码验证</title>
</head>
<body>

</body>
</html>