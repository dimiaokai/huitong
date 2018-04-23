<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="update"><a href="#" onclick="formSubmit('update','_self');this.blur();">更新</a></li>
	<li id="back"><a href="#" onclick="window.history.go(-1);this.blur();">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
   模块修改
  </div> 
  
<div>


<div class="eXtremeTable" >
	<table id="ec_table" class="tableRegion" width="98%" >
		<tr class="odd" hidden="hidden">
			<td><input type="text" name="moduleId" value="${module.moduleId}"/></td>
		</tr>
		<tr class="odd">
			<td>模块名称</td>
			<td><input type="text" name="name" value="${module.name}"/></td>
		</tr>
		<tr class="odd">
			<td>模块类型</td>
			<td>
				<select name="ctype" style="width:121px">
					<option value="">---请选择---</option>
					
					
					<option value="1" <c:if test="${module.ctype ==1}">selected="selected"</c:if> >主菜单</option>
					<option value="2" <c:if test="${module.ctype ==2}">selected="selected"</c:if>>左侧菜单</option>
					<option value="3" <c:if test="${module.ctype ==3}">selected="selected"</c:if>>按钮</option>
				</select>
			</td>
		</tr>
		<tr class="odd">
			<td>上级模块</td>
			<td>
				<select name="parentModule.moduleId" style="width:121px">
					<option value="">---请选择---</option>
					<option value="">无上级</option>
					
					<c:forEach items="${moduleList}" var="m">
						<option value="${m.moduleId}" <c:if test="${module.parentModule.moduleId ==m.moduleId}">selected="selected"</c:if>>${m.name}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr class="odd">
			<td>排序号</td>
			<td><input type="text" name="orderNo" value="${module.orderNo}"/></td>
		</tr>
		<tr class="odd">
			<td>状态</td>
			<td>
				
				<input type="radio" name="state" value="1" <c:if test="${module.state ==1}">checked="checked"</c:if>/>启用
				<input type="radio" name="state" value="0" <c:if test="${module.state ==0}">checked="checked"</c:if>/>停用
			</td>
		</tr>	
		<tr class="odd" >
			<td>备注信息</td>
			<td>
				<textarea style="height:120px;width:100%" name="remark"></textarea>
			</td>
		</tr>
		
	</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

