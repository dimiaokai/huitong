package cn.tarena.ht.pojo;

public class Module extends BaseEntity{
	private Module parentModule;  //一对一关联   表示上级模块信息
	
	private String moduleId;
	private String name;
	private Integer ctype;		//1主菜单/2左侧菜单/3按钮
	private Integer state;      //1启用  0停用
	private Integer orderNo;    //排序号
	private String remark;		//备注信息
	private Boolean checked;	//zTree回显时的数据
	
	
	/*
	 * 为了zTree树进行效果展现 需要添加 id pId checked
	 */
	public String getId(){
		return moduleId;
	}
	
	public String getpId(){
		//获取上级模块的Id值
		if(parentModule !=null){
			return parentModule.getModuleId();
		}
		return "";
	}
	
	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public Module getParentModule() {
		return parentModule;
	}
	public void setParentModule(Module parentModule) {
		this.parentModule = parentModule;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCtype() {
		return ctype;
	}
	public void setCtype(Integer ctype) {
		this.ctype = ctype;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
