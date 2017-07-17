<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ssm-maven系统主页</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	var url;
	function addTab(url, text, iconCls) {
		var content = "<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='${pageContext.request.contextPath}/views/"
				+ url + "'></iframe>";
		$("#tabs").tabs("add", {
			title : text,
			iconCls : iconCls,
			closable : true,
			content : content
		});
	}
	function openTab(text, url, iconCls) {
		if ($("#tabs").tabs("exists", text)) {
			$("#tabs").tabs("close", text);
			addTab(url, text, iconCls);
			$("#tabs").tabs("select", text);
		} else {
			addTab(url, text, iconCls);
		}
	}

	function logout() {
		$.messager
				.confirm(
						"系统提示",
						"您确定要退出系统吗",
						function(r) {
							if (r) {
								window.location.href = "${pageContext.request.contextPath}/user/logout.do";
							}
						});
	}
</script>
<script type="text/javascript" charset="utf-8">
//获取系统时间，将时间以指定格式显示到页面。  
function systemTime()  
{  
    //获取系统时间。  
    var show_day=new Array('星期一','星期二','星期三','星期四','星期五','星期六','星期日'); 
    var dateTime=new Date();  
    var yy=dateTime.getFullYear();
    var month=dateTime.getMonth()+1;
    var dd=dateTime.getDate();
    var hh=dateTime.getHours();  
    var mm=dateTime.getMinutes();  
    var ss=dateTime.getSeconds(); 
    var weekday=dateTime.getDay();
      
    //分秒时间是一位数字，在数字前补0。  
    
    mm = extra(mm);  
    ss = extra(ss);  
      
    //将时间显示到ID为time的位置，时间格式形如：19:18:02  
    document.getElementById("sysTime").innerHTML=yy + "年" +month+ "月" + dd + "日  " +hh+":"+mm+":"+ss+ " " + show_day[weekday-1];  
      
    //每隔1000ms执行方法systemTime()。  
    setTimeout("systemTime()",1000);  
}  
  
//补位函数。  
function extra(x)  
{  
    //如果传入数字小于10，数字前补一位0。  
    if(x < 10)  
    {  
        return "0" + x;  
    }  
    else  
    {  
        return x;  
    }  
} 
</script>
<jsp:include page="login_check.jsp"></jsp:include>
<body class="easyui-layout" onload="systemTime()">
	<div region="north" style="height: 78px; background-color: #ffff">
		<table width="95%">
			<tr>
				<td width="60%"> <h2 style="font-size: 20px; color: #8B8B8B; font-family: '楷体';">图书管理系统</h2></td>
				<td valign="bottom"
					style="font-size: 25px; color: #8B8B8B; font-family: '楷体';"
					align="right"><font size="3">&nbsp;&nbsp;<strong>当前管理员：</strong>${currentUser.userName
                    }<strong>|现在是：<span
							id="sysTime"></span></strong></font></td>
			</tr>
		</table>
	</div>
	<div region="center">
		<div class="easyui-tabs" fit="true" border="false" id="tabs">
			<div title="首页" data-options="iconCls:'icon-home'">
				<div align="center" style="padding-top: 20px;">
					<a href="http://download.csdn.net/detail/zhenfengshisan/9813721"
						target="_blank" style="font-size: 20px;">项目源码下载3(最新代码)</a>
				</div>
				<div align="center" style="padding-top: 50px;">
					<a href="http://download.csdn.net/detail/zhenfengshisan/9765855"
						target="_blank" style="font-size: 20px;">项目源码下载1(非maven)</a>
				</div>
				<div align="center" style="padding-top: 20px;">
					<a href="http://download.csdn.net/detail/zhenfengshisan/9811684"
						target="_blank" style="font-size: 20px;">项目源码下载2(maven项目)</a>
				</div>
				<div align="center" style="padding-top: 20px;">
					<a href="https://github.com/ZHENFENG13/ssm-demo" target="_blank"
						style="font-size: 20px;">github地址</a>
				</div>
				<div align="center" style="padding-top: 50px">
					<font color="grey" size="10">ssm demo</font>
				</div>
			</div>
		</div>
	</div>
	<div region="west" style="width: 200px; height: 500px;" title="导航菜单"
		split="true">
		<div class="easyui-accordion">
			<div title="文章管理"
				data-options="selected:true,iconCls:'icon-wenzhangs'"
				style="padding: 10px; height: 10px;">
				<a
					href="javascript:openTab(' 文章管理','articleManage.jsp','icon-wenzhang')"
					class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-wenzhang'"
					style="width: 150px;"> 文章管理</a>
			</div>
			<div title="图片管理" data-options="iconCls:'icon-shouye'"
				style="padding: 10px">
				<a
					href="javascript:openTab(' 图片设置','pictureManage.jsp?type=1&grade=1','icon-tupians')"
					class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-tupian'"
					style="width: 150px;"> 图片设置</a>
			</div>
			<div title="书籍管理" data-options="iconCls:'icon-shuji'"
				style="padding: 10px">
				<a
					href="javascript:openTab(' 全部书籍','allBooksManage.jsp','icon-shuben')"
					class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-shuben'"
					style="width: 150px;">全部书籍</a>
			</div>
			<div title="系统管理" data-options="iconCls:'icon-item'"
				style="padding: 10px; border: none;">
				<a href="javascript:openTab(' 管理员列表','userManage.jsp','icon-lxr')"
					class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-lxr'" style="width: 150px;">
					管理员列表</a><a href="javascript:logout()" class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-exit'" style="width: 150px;">
					安全退出</a>
			</div>
		</div>
	</div>
	<div id="southMainDiv" data-options="region:'south',border:false" style="height:25px;background:#EEE;padding:5px;" href="views/south.jsp"></div>
</body>
</html>