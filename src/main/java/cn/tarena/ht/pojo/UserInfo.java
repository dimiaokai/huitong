package cn.tarena.ht.pojo;

import java.util.Date;

public class UserInfo extends BaseEntity{
	private String userInfoId;
	private String name; //姓名
	private String cardNo;	//身份证号
	private UserInfo manager; //上级领导
	private Date joinDate;    //入职日期
	private Double salary;	  //薪资
	private Date  birthday;	  //生日
	private String gender;    //性别
	private String station;   //岗位
	private String telephone; //电话号码
	private String userLevel; //用户级别 4-普通用户 3-部门经理 2-副总 1-总经理
	private String remark;    //备注信息
	private Integer orderNo;  //排序号
	public String getUserInfoId() {
		return userInfoId;
	}
	public void setUserInfoId(String userInfoId) {
		this.userInfoId = userInfoId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public UserInfo getManager() {
		return manager;
	}
	public void setManager(UserInfo manager) {
		this.manager = manager;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	@Override
	public String toString() {
		return "UserInfo [userInfoId=" + userInfoId + ", name=" + name + ", cardNo=" + cardNo + ", manager=" + manager
				+ ", joinDate=" + joinDate + ", salary=" + salary + ", birthday=" + birthday + ", gender=" + gender
				+ ", station=" + station + ", telephone=" + telephone + ", userLevel=" + userLevel + ", remark="
				+ remark + ", orderNo=" + orderNo + "]";
	}
	   
	 

}
