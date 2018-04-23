package cn.tarena.ht.pojo;

public class Role extends BaseEntity{
	private String roleId;		//角色ID
	private String name;		//角色名称
	private String remarks;     //备注信息
	private Integer orderNo;	//排序号  驼峰映射: orderNo  orderNO ordernO 后边的字符大小写没有要求
	
	//为zTree数据回显 添加属性
	private Boolean checked;
	//表示满足zTree树的结构 获取id的值
	public String getId(){
		return roleId;
	}
	
	
	
	public Boolean getChecked() {
		return checked;
	}



	public void setChecked(Boolean checked) {
		this.checked = checked;
	}



	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	
	
}
