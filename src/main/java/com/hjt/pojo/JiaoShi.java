package com.hjt.pojo;

public class JiaoShi {
	private String jiaoshi_id;//老师id
	private String jiaoshi_name;//老师名称
	private String jiaoshi_pwd;//教师密码
	private String jiaoshi_code;//教师编码
	private String jiaoshi_identity;//教师身份证号
	private String jiaoshi_shifoudongjie;//教师是否冻结"0"=正常，"1"=冻结
	private String jiaoshi_fudaoyuan;//是否为辅导员,"0"为普通教师,"1"为辅导员
	public JiaoShi()
	{
	}
	public JiaoShi(String jiaoshi_id, String jiaoshi_name, String jiaoshi_pwd, String jiaoshi_code,
			String jiaoshi_identity, String jiaoshi_shifoudongjie, String jiaoshi_fudaoyuan) {
		super();
		this.jiaoshi_id = jiaoshi_id;
		this.jiaoshi_name = jiaoshi_name;
		this.jiaoshi_pwd = jiaoshi_pwd;
		this.jiaoshi_code = jiaoshi_code;
		this.jiaoshi_identity = jiaoshi_identity;
		this.jiaoshi_shifoudongjie = jiaoshi_shifoudongjie;
		this.jiaoshi_fudaoyuan = jiaoshi_fudaoyuan;
	}
	public String getJiaoshi_id() {
		return jiaoshi_id;
	}
	public void setJiaoshi_id(String jiaoshi_id) {
		this.jiaoshi_id = jiaoshi_id;
	}
	public String getJiaoshi_name() {
		return jiaoshi_name;
	}
	public void setJiaoshi_name(String jiaoshi_name) {
		this.jiaoshi_name = jiaoshi_name;
	}
	public String getJiaoshi_pwd() {
		return jiaoshi_pwd;
	}
	public void setJiaoshi_pwd(String jiaoshi_pwd) {
		this.jiaoshi_pwd = jiaoshi_pwd;
	}
	public String getJiaoshi_code() {
		return jiaoshi_code;
	}
	public void setJiaoshi_code(String jiaoshi_code) {
		this.jiaoshi_code = jiaoshi_code;
	}
	public String getJiaoshi_identity() {
		return jiaoshi_identity;
	}
	public void setJiaoshi_identity(String jiaoshi_identity) {
		this.jiaoshi_identity = jiaoshi_identity;
	}
	public String getJiaoshi_shifoudongjie() {
		return jiaoshi_shifoudongjie;
	}
	public void setJiaoshi_shifoudongjie(String jiaoshi_shifoudongjie) {
		this.jiaoshi_shifoudongjie = jiaoshi_shifoudongjie;
	}
	public String getJiaoshi_fudaoyuan() {
		return jiaoshi_fudaoyuan;
	}
	public void setJiaoshi_fudaoyuan(String jiaoshi_fudaoyuan) {
		this.jiaoshi_fudaoyuan = jiaoshi_fudaoyuan;
	}
	@Override
	public String toString() {
		return "JiaoShi [jiaoshi_id=" + jiaoshi_id + ", jiaoshi_name=" + jiaoshi_name + ", jiaoshi_pwd=" + jiaoshi_pwd
				+ ", jiaoshi_code=" + jiaoshi_code + ", jiaoshi_identity=" + jiaoshi_identity
				+ ", jiaoshi_shifoudongjie=" + jiaoshi_shifoudongjie + ", jiaoshi_fudaoyuan=" + jiaoshi_fudaoyuan + "]";
	}

}
