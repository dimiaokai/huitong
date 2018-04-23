<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>部门列表</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="back"><a href="#" onclick="window.history.go(-1);this.blur();">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    用户查看
  </div> 
  
<div>

<div class="eXtremeTable" >
	<table id="ec_table" class="tableRegion" width="98%" >
		<tr class="odd">
			<td class="tableHeader">用户名：</td>
			<td>${user.username}</td>
			<td class="tableHeader">所在部门</td>
			<td>${user.dept.deptName}</td>
		</tr>
		<tr class="odd">
			<td class="tableHeader">真实姓名：</td>
			<td>${user.userInfo.name}</td>
			<td class="tableHeader">身份证号</td>
			<td>${user.userInfo.cardNo}</td>
		</tr>
		<tr class="odd">
			<td class="tableHeader">上级领导：</td>
			<td>${user.userInfo.manager.name}</td>
			<td class="tableHeader">入职日期</td>
			<td><fmt:formatDate value="${user.userInfo.joinDate}" pattern="yyyy-MM-dd"/></td>
		</tr>
		<tr class="odd">
			<td class="tableHeader">工资：</td>
			<td>${user.userInfo.salary}</td>
			<td class="tableHeader">生日</td>
			<td><fmt:formatDate value="${user.userInfo.birthday}" pattern="yyyy-MM-dd"/></td>
		</tr>
		<tr class="odd">
			<td class="tableHeader">性别：</td>
			<td>${user.userInfo.gender}</td>
			<td class="tableHeader">岗位</td>
			<td>${user.userInfo.station}</td>
		</tr>
		<tr class="odd">
			<td class="tableHeader">电话号码：</td>
			<td>${user.userInfo.telephone}</td>
			<td class="tableHeader">用户级别</td>
			<td>${user.userInfo.userLevel}</td>
		</tr>
		<tr class="odd">
			<td class="tableHeader">排序号：</td>
			<td>${user.userInfo.orderNo}</td>
			<td class="tableHeader">状态</td>
			<td>
				<c:if test="${user.state ==1}">启用</c:if>
				<c:if test="${user.state ==0}">停用</c:if>
			</td>	
		</tr>
		<tr class="odd" >
			<td class="tableHeader">备注信息:</td>
			<td colspan="3" style="height:40px">${user.userInfo.remark}</td>
		</tr>
		
	</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

