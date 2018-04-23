<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>用户新增</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="save"><a href="#" onclick="formSubmit('save','_self');this.blur();">保存</a></li>
	<li id="back"><a href="#" onclick="window.history.go(-1);this.blur();">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    用户新增
  </div> 
  
<div>


<div class="eXtremeTable" >
	<table id="ec_table" class="tableRegion" width="98%" >
		<tr class="odd">
			<td class="tableHeader">用户名：</td>
			<td><input type="text"  name="username"/></td>
			<td class="tableHeader">密码：</td>
			<td><input type="password"  name="password"/></td>
		</tr>
		<tr class="odd">
			<td class="tableHeader">所在部门</td>
			<td>
				<select name="dept.deptId" style="width:120px">
					<option value="">---请选择---</option>
					
					<c:forEach items="${deptList}" var="d">
						<option value="${d.deptId}">${d.deptName}</option>
					</c:forEach>
					
				</select>
			</td>
		</tr>
		
		<tr class="odd">
			<td class="tableHeader">真实姓名：</td>
			<td><input type="text" name="userInfo.name"/></td>
			<td class="tableHeader">身份证号</td>
			<td><input type="text" name="userInfo.cardNo"/></td>
		</tr>
		<tr class="odd">
			<td class="tableHeader">上级领导：</td>
			<td>      
				<select name="userInfo.manager.userInfoId" style="width:120px">
					<option>---请选择---</option>
					
					<c:forEach items="${managerList}" var="m">
						<option value="${m.userInfoId}">${m.name}</option>
					</c:forEach>
				</select>
			</td>
			<td class="tableHeader">入职日期</td>
			<td>
				<input type="text" style="width:120px;" name="userInfo.joinDate"
	   	onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
			</td>
		</tr>
		<tr class="odd">
			<td class="tableHeader">工资：</td>
			<td><input type="text" name="userInfo.salary"/></td>
			<td class="tableHeader">生日</td>
			<td>
				<input type="text" style="width:120px;" name="userInfo.birthday"
	   	onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
			</td>
		</tr>
		<tr class="odd">
			<td class="tableHeader">性别：</td>
			<td>   
				<input type="radio" name="userInfo.gender" value="男" checked="checked"/>男
				<input type="radio" name="userInfo.gender" value="女"/>女
				<input type="radio" name="userInfo.gender" value="其他"/>其他
			</td>
			<td class="tableHeader">岗位</td>
			<td>
				<input type="text" name="userInfo.station"/>
			</td>
		</tr>
		<tr class="odd">
			<td class="tableHeader">电话号码：</td>
			<td>   
				<input type="text" name="userInfo.telephone"/>
			</td>
			<td class="tableHeader">用户级别</td>
			<td> 
				<select name="userInfo.userLevel" style="width:120px">
					<option value="4" selected="selected">普通用户</option>
					<option value="3">部门经理</option>
					<option value="2">副总</option>
					<option value="1">总经理</option>
				</select>
			</td>
		</tr>
		<tr class="odd">
			<td class="tableHeader">排序号：</td>
			<td>
				<input type="text" name="userInfo.orderNo"/>
			</td>
			<td class="tableHeader">状态</td>
			<td>
				<input type="radio" name="state" value="0"/>停用
				<input type="radio" name="state" value="1" checked="checked"/>启用
			</td>
			
		</tr>
		<tr class="odd" >
			<td class="tableHeader">备注信息:</td>
			<td colspan="3" style="height:80px">
				<textarea style="width:100%;height:80px" name="userInfo.remark"></textarea>
			</td>
		</tr>
		
	</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

