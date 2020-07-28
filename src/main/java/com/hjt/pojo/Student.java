package com.hjt.pojo;

public class Student {
	private String stu_id;//学生学号
	private String stu_name;// 学生姓名
	private String stu_pwd;// 学生密码
	private String stu_code;// 学生编号
	private String stu_nianling;//学生年龄
	private String stu_xingbie;//学生性别
	private String stu_shifoudongjie;//账号是否被冻结“0”=正常。“1”=冻结
	private String stu_identity;//学生身份证号
	private String stu_banji_id;// 所在班级id
	public Student()
	{

	}
	public Student(String userCode,String password){
		this.stu_code = userCode;
		this.stu_pwd = password;
	}
	public Student(String stu_id, String stu_name, String stu_pwd, String stu_code, String stu_nianling,
			String stu_xingbie, String stu_shifoudongjie, String stu_identity, String stu_banji_id) {
		super();
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.stu_pwd = stu_pwd;
		this.stu_code = stu_code;
		this.stu_nianling = stu_nianling;
		this.stu_xingbie = stu_xingbie;
		this.stu_shifoudongjie = stu_shifoudongjie;
		this.stu_identity = stu_identity;
		this.stu_banji_id = stu_banji_id;
	}
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStu_pwd() {
		return stu_pwd;
	}
	public void setStu_pwd(String stu_pwd) {
		this.stu_pwd = stu_pwd;
	}
	public String getStu_code() {
		return stu_code;
	}
	public void setStu_code(String stu_code) {
		this.stu_code = stu_code;
	}
	public String getStu_nianling() {
		return stu_nianling;
	}
	public void setStu_nianling(String stu_nianling) {
		this.stu_nianling = stu_nianling;
	}
	public String getStu_xingbie() {
		return stu_xingbie;
	}
	public void setStu_xingbie(String stu_xingbie) {
		this.stu_xingbie = stu_xingbie;
	}
	public String getStu_shifoudongjie() {
		return stu_shifoudongjie;
	}
	public void setStu_shifoudongjie(String stu_shifoudongjie) {
		this.stu_shifoudongjie = stu_shifoudongjie;
	}
	public String getStu_identity() {
		return stu_identity;
	}
	public void setStu_identity(String stu_identity) {
		this.stu_identity = stu_identity;
	}
	public String getStu_banji_id() {
		return stu_banji_id;
	}
	public void setStu_banji_id(String stu_banji_id) {
		this.stu_banji_id = stu_banji_id;
	}
	@Override
	public String toString() {
		return "Student [stu_id=" + stu_id + ", stu_name=" + stu_name + ", stu_pwd=" + stu_pwd + ", stu_code="
				+ stu_code + ", stu_nianling=" + stu_nianling + ", stu_xingbie=" + stu_xingbie + ", stu_shifoudongjie="
				+ stu_shifoudongjie + ", stu_identity=" + stu_identity + ", stu_banji_id=" + stu_banji_id + "]";
	}

}
