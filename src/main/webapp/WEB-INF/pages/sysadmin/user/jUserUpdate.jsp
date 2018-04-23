<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>用户修改</title>
</head>
<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="update"><a href="#" onclick="formSubmit('update','_self');this.blur();">修改</a></li>
	<li id="back"><a href="#" onclick="window.history.go(-1);this.blur();">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    用户修改
  </div> 
  
<div>
<div class="eXtremeTable" >
	<table id="ec_table" class="tableRegion" width="98%" >
		<!--通过隐藏域封装UserId 将来修改时使用  -->
		<tr class="odd" hidden="hidden">
			<td class="tableHeader"><input type="text" name="userId" value="${user.userId}"/></td>
		</tr>
		<tr class="odd">
			<td class="tableHeader">用户名：</td>
			<td><input type="text"  name="username" value="${user.username}"/></td>
			<td class="tableHeader">密码：</td>
			<td><input type="password"  name="password" value="${user.password}"/></td>
		</tr>
		<tr class="odd">
			<td class="tableHeader">所在部门</td>
			<td>
				<select name="dept.deptId" style="width:120px">
					<option value="">---请选择---</option>
					
					<c:forEach items="${deptList}" var="d">
						<option value="${d.deptId}" <c:if test="${user.dept.deptId ==d.deptId}">selected="selected"</c:if>>${d.deptName}</option>
					</c:forEach>
					
				</select>
			</td>
		</tr>
		
		<tr class="odd">
			<td class="tableHeader">真实姓名：</td>
			<td><input type="text" name="userInfo.name" value="${user.userInfo.name}"/></td>
			<td class="tableHeader">身份证号</td>
			<td><input type="text" name="userInfo.cardNo" value="${user.userInfo.cardNo}"/></td>
		</tr>
		<tr class="odd">
			<td class="tableHeader">上级领导：</td>
			<td>      
				<select name="userInfo.manager.userInfoId" style="width:120px">
					<option>---请选择---</option>
					<c:forEach items="${managerList}" var="m">

						<!--自己不能是自己的领导  -->
						<c:if test="${user.userId!=m.userInfoId}">
							<option value="${m.userInfoId}" <c:if test="${mId==m.userInfoId}">selected="selected"</c:if>>${m.name}</option>
						</c:if>	
						
					</c:forEach>
				</select>
			</td>
			<td class="tableHeader">入职日期</td>
			<td>    
				<input type="text" style="width:120px;" name="userInfo.joinDate" value="<fmt:formatDate value="${user.userInfo.joinDate}" pattern="yyyy-MM-dd"/>"
	   	onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
			</td>
		</tr>
		<tr class="odd">
			<td class="tableHeader">工资：</td>
			<td><input type="text" name="userInfo.salary" value="${user.userInfo.salary}"/></td>
			<td class="tableHeader">生日</td>
			<td>
				<input type="text" style="width:120px;" name="userInfo.birthday" value="<fmt:formatDate value="${user.userInfo.birthday}" pattern="yyyy-MM-dd"/>"
	   	onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
			</td>
		</tr>
		<tr class="odd">
			<td class="tableHeader">性别：</td>
			<td>   
				<input type="radio" name="userInfo.gender" value="男" <c:if test="${user.userInfo.gender=='男'}">checked="checked"</c:if>/>男
				<input type="radio" name="userInfo.gender" value="女" <c:if test="${user.userInfo.gender=='女'}">checked="checked"</c:if>/>女
				<input type="radio" name="userInfo.gender" value="其他" <c:if test="${user.userInfo.gender=='其他'}">checked="checked"</c:if>/>其他
			</td>
			<td class="tableHeader">岗位</td>
			<td>
				<input type="text" name="userInfo.station" value="${user.userInfo.station}"/>
			</td>
		</tr>
		<tr class="odd">
			<td class="tableHeader">电话号码：</td>
			<td>   
				<input type="text" name="userInfo.telephone" value="${user.userInfo.telephone}"/>
			</td>
			<td class="tableHeader">用户级别</td>
			<td> 
				<select name="userInfo.userLevel" style="width:120px">
				
					
					<option value="4" <c:if test="${user.userInfo.userLevel==4}">selected="selected"</c:if>>普通用户</option>
					<option value="3" <c:if test="${user.userInfo.userLevel==3}">selected="selected"</c:if>>部门经理</option>
					<option value="2" <c:if test="${user.userInfo.userLevel==2}">selected="selected"</c:if>>副总</option>
					<option value="1" <c:if test="${user.userInfo.userLevel==1}">selected="selected"</c:if>>总经理</option>
				</select>
			</td>
		</tr>
		<tr class="odd">
			<td class="tableHeader">排序号：</td>
			<td>
				<input type="text" name="userInfo.orderNo" value="${user.userInfo.orderNo}"/>
			</td>
			<td class="tableHeader">状态</td>
			<td>
				
				<input type="radio" name="state" value="0" <c:if test="${user.state ==0}">checked="checked"</c:if>/>停用
				<input type="radio" name="state" value="1" <c:if test="${user.state ==1}">checked="checked"</c:if>/>启用
			</td>
			
		</tr>
		<tr class="odd" >
			<td class="tableHeader">备注信息:</td>
			<td colspan="3" style="height:80px">
				<textarea style="width:100%;height:80px" name="userInfo.remark">${user.userInfo.remark}</textarea>
			</td>
		</tr>
		
	</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

