package com.hjt.pojo;

public class GuanLiYuan {

	private String guanliyuan_id;//管理员id
	private String guanliyuan_name;//管理员id
	private String guanliyuan_pwd;//管理员id
	private String guanliyuan_code;//管理员id
	private String guanliyuan_nianling;//管理员年龄
	private String guanliyuan_xingbie;//管理员性别
	private String guanliyuan_identity;//管理员身份证

	public GuanLiYuan ()
	{

	}

	public GuanLiYuan(String guanliyuan_id, String guanliyuan_name, String guanliyuan_pwd, String guanliyuan_code,
			String guanliyuan_nianling, String guanliyuan_xingbie, String guanliyuan_identity) {
		super();
		this.guanliyuan_id = guanliyuan_id;
		this.guanliyuan_name = guanliyuan_name;
		this.guanliyuan_pwd = guanliyuan_pwd;
		this.guanliyuan_code = guanliyuan_code;
		this.guanliyuan_nianling = guanliyuan_nianling;
		this.guanliyuan_xingbie = guanliyuan_xingbie;
		this.guanliyuan_identity = guanliyuan_identity;
	}

	public String getGuanliyuan_id() {
		return guanliyuan_id;
	}

	public void setGuanliyuan_id(String guanliyuan_id) {
		this.guanliyuan_id = guanliyuan_id;
	}

	public String getGuanliyuan_name() {
		return guanliyuan_name;
	}

	public void setGuanliyuan_name(String guanliyuan_name) {
		this.guanliyuan_name = guanliyuan_name;
	}

	public String getGuanliyuan_pwd() {
		return guanliyuan_pwd;
	}

	public void setGuanliyuan_pwd(String guanliyuan_pwd) {
		this.guanliyuan_pwd = guanliyuan_pwd;
	}

	public String getGuanliyuan_code() {
		return guanliyuan_code;
	}

	public void setGuanliyuan_code(String guanliyuan_code) {
		this.guanliyuan_code = guanliyuan_code;
	}

	public String getGuanliyuan_nianling() {
		return guanliyuan_nianling;
	}

	public void setGuanliyuan_nianling(String guanliyuan_nianling) {
		this.guanliyuan_nianling = guanliyuan_nianling;
	}

	public String getGuanliyuan_xingbie() {
		return guanliyuan_xingbie;
	}

	public void setGuanliyuan_xingbie(String guanliyuan_xingbie) {
		this.guanliyuan_xingbie = guanliyuan_xingbie;
	}

	public String getGuanliyuan_identity() {
		return guanliyuan_identity;
	}

	public void setGuanliyuan_identity(String guanliyuan_identity) {
		this.guanliyuan_identity = guanliyuan_identity;
	}

	@Override
	public String toString() {
		return "GuanLiYuan [guanliyuan_id=" + guanliyuan_id + ", guanliyuan_name=" + guanliyuan_name
				+ ", guanliyuan_pwd=" + guanliyuan_pwd + ", guanliyuan_code=" + guanliyuan_code
				+ ", guanliyuan_nianling=" + guanliyuan_nianling + ", guanliyuan_xingbie=" + guanliyuan_xingbie
				+ ", guanliyuan_identity=" + guanliyuan_identity + "]";
	}


}
