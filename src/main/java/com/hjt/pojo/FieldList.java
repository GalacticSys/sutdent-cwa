package com.hjt.pojo;

public class FieldList {
	//班级字段
	private String banji_id;//班级id
	private String banji_name;//班级名称
	private String banji_jiaoshi_id;//辅导员id
	//管理员
	private String guanliyuan_id;//管理员id
	private String guanliyuan_name;//管理员姓名
	private String guanliyuan_pwd;//管理员密码
	private String guanliyuan_code;//管理员编号
	private String guanliyuan_nianling;//管理员年龄
	private String guanliyuan_xingbie;//管理员性别
	private String guanliyuan_identity;//管理员身份证

	//教师字段
	private String jiaoshi_id;//老师id
	private String jiaoshi_name;//老师名称
	private String jiaoshi_pwd;//教师密码
	private String jiaoshi_code;//教师编码
	private String jiaoshi_xingbie;//教师性别
	private String jiaoshi_nianling;//教师年龄
	private String jiaoshi_identity;//教师身份证号
	private String jiaoshi_shifoudongjie;//教师是否冻结"0"=正常，"1"=冻结
	private String jiaoshi_fudaoyuan;//是否为辅导员,"0"为普通教师,"1"为辅导员
	//考勤字段
	private String kaoqin_id;//考勤id
	private String kaoqin_shifouqingjia;//是否请假"0"=请假，"1"=已签到
	private String kaoqin_riqi;//考勤日期
	private String kaoqin_xuanke_id;//学生选课id
	//课程字段
	private String kecheng_id;//课程id
	private String kecheng_name;//课程名称
	//请假字段
	private String qingjia_id;//请假id
	private String qingjia_shifoupijia;//是否批假
	private String qingjia_riqi;//请假日期
	private String qingjia_yuanyin;//请假原因
	private String qingjia_shijian;//请假时间
	private String qingjia_shifoupiyue;//是否批阅"0"=已批，"1"=待批
	private String qingjia_xuanke_id;//选课id
	//授课字段
	private String shouke_id;//授课id
	private String shouke_kecheng_id;//授课id
	private String shouke_banji_id;//授课id
	private String shouke_jiaoshi_id;//授课id

	//学生字段
	private String stu_id;//学生学号
	private String stu_name;// 学生姓名
	private String stu_pwd;// 学生密码
	private String stu_nianling;//学生年龄
	private String stu_xingbie;//学生性别
	private String stu_code;// 学生编码
	private String stu_shifoudongjie;//账号是否被冻结“0”=正常。“1”=冻结
	private String stu_identity;//学生身份证号
	private String stu_banji_id;// 所在班级id
	//选课字段
	private String xuanke_id;//选课id
	private String xuanke_stu_id;//选课id
	private String xuanke_kecheng_id;//选课id
	//课程表字段
	private String kechengbiao_id;//课程表id
	private String kechengbiao_shangkeriqi;//上课日期
	private String kechengbiao_kecheng_id;//上课课程id
	private String kechengbiao_banji_id;//上课班级
	//公告字段
	private String gonggao_id;//公告id
	private String gonggao_guanliyuan_id;//该条公告的发起人
	private String gonggao_title;//公告标题
	private String gonggao_neirong;//公告内容
	private String gonggao_faqiriqi;//发起日期

	private int start;//起始列
	private int rows;//数据行数
	public FieldList()
	{

	}
	public FieldList(String banji_id, String banji_name, String banji_jiaoshi_id, String guanliyuan_id,
			String guanliyuan_name, String guanliyuan_pwd, String guanliyuan_code, String guanliyuan_nianling,
			String guanliyuan_xingbie, String guanliyuan_identity, String jiaoshi_id, String jiaoshi_name,
			String jiaoshi_pwd, String jiaoshi_code, String jiaoshi_xingbie, String jiaoshi_nianling,
			String jiaoshi_identity, String jiaoshi_shifoudongjie, String jiaoshi_fudaoyuan, String kaoqin_id,
			String kaoqin_shifouqingjia, String kaoqin_riqi, String kaoqin_xuanke_id, String kecheng_id,
			String kecheng_name, String qingjia_id, String qingjia_shifoupijia, String qingjia_riqi,
			String qingjia_yuanyin, String qingjia_shijian, String qingjia_shifoupiyue, String qingjia_xuanke_id,
			String shouke_id, String shouke_kecheng_id, String shouke_banji_id, String shouke_jiaoshi_id, String stu_id,
			String stu_name, String stu_pwd, String stu_nianling, String stu_xingbie, String stu_code,
			String stu_shifoudongjie, String stu_identity, String stu_banji_id, String xuanke_id, String xuanke_stu_id,
			String xuanke_kecheng_id, String kechengbiao_id, String kechengbiao_shangkeriqi,
			String kechengbiao_kecheng_id, String kechengbiao_banji_id, String gonggao_id, String gonggao_guanliyuan_id,
			String gonggao_title, String gonggao_neirong, String gonggao_faqiriqi, int start, int rows) {
		super();
		this.banji_id = banji_id;
		this.banji_name = banji_name;
		this.banji_jiaoshi_id = banji_jiaoshi_id;
		this.guanliyuan_id = guanliyuan_id;
		this.guanliyuan_name = guanliyuan_name;
		this.guanliyuan_pwd = guanliyuan_pwd;
		this.guanliyuan_code = guanliyuan_code;
		this.guanliyuan_nianling = guanliyuan_nianling;
		this.guanliyuan_xingbie = guanliyuan_xingbie;
		this.guanliyuan_identity = guanliyuan_identity;
		this.jiaoshi_id = jiaoshi_id;
		this.jiaoshi_name = jiaoshi_name;
		this.jiaoshi_pwd = jiaoshi_pwd;
		this.jiaoshi_code = jiaoshi_code;
		this.jiaoshi_xingbie = jiaoshi_xingbie;
		this.jiaoshi_nianling = jiaoshi_nianling;
		this.jiaoshi_identity = jiaoshi_identity;
		this.jiaoshi_shifoudongjie = jiaoshi_shifoudongjie;
		this.jiaoshi_fudaoyuan = jiaoshi_fudaoyuan;
		this.kaoqin_id = kaoqin_id;
		this.kaoqin_shifouqingjia = kaoqin_shifouqingjia;
		this.kaoqin_riqi = kaoqin_riqi;
		this.kaoqin_xuanke_id = kaoqin_xuanke_id;
		this.kecheng_id = kecheng_id;
		this.kecheng_name = kecheng_name;
		this.qingjia_id = qingjia_id;
		this.qingjia_shifoupijia = qingjia_shifoupijia;
		this.qingjia_riqi = qingjia_riqi;
		this.qingjia_yuanyin = qingjia_yuanyin;
		this.qingjia_shijian = qingjia_shijian;
		this.qingjia_shifoupiyue = qingjia_shifoupiyue;
		this.qingjia_xuanke_id = qingjia_xuanke_id;
		this.shouke_id = shouke_id;
		this.shouke_kecheng_id = shouke_kecheng_id;
		this.shouke_banji_id = shouke_banji_id;
		this.shouke_jiaoshi_id = shouke_jiaoshi_id;
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.stu_pwd = stu_pwd;
		this.stu_nianling = stu_nianling;
		this.stu_xingbie = stu_xingbie;
		this.stu_code = stu_code;
		this.stu_shifoudongjie = stu_shifoudongjie;
		this.stu_identity = stu_identity;
		this.stu_banji_id = stu_banji_id;
		this.xuanke_id = xuanke_id;
		this.xuanke_stu_id = xuanke_stu_id;
		this.xuanke_kecheng_id = xuanke_kecheng_id;
		this.kechengbiao_id = kechengbiao_id;
		this.kechengbiao_shangkeriqi = kechengbiao_shangkeriqi;
		this.kechengbiao_kecheng_id = kechengbiao_kecheng_id;
		this.kechengbiao_banji_id = kechengbiao_banji_id;
		this.gonggao_id = gonggao_id;
		this.gonggao_guanliyuan_id = gonggao_guanliyuan_id;
		this.gonggao_title = gonggao_title;
		this.gonggao_neirong = gonggao_neirong;
		this.gonggao_faqiriqi = gonggao_faqiriqi;
		this.start = start;
		this.rows = rows;
	}
	public String getBanji_id() {
		return banji_id;
	}
	public void setBanji_id(String banji_id) {
		this.banji_id = banji_id;
	}
	public String getBanji_name() {
		return banji_name;
	}
	public void setBanji_name(String banji_name) {
		this.banji_name = banji_name;
	}
	public String getBanji_jiaoshi_id() {
		return banji_jiaoshi_id;
	}
	public void setBanji_jiaoshi_id(String banji_jiaoshi_id) {
		this.banji_jiaoshi_id = banji_jiaoshi_id;
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
	public String getJiaoshi_xingbie() {
		return jiaoshi_xingbie;
	}
	public void setJiaoshi_xingbie(String jiaoshi_xingbie) {
		this.jiaoshi_xingbie = jiaoshi_xingbie;
	}
	public String getJiaoshi_nianling() {
		return jiaoshi_nianling;
	}
	public void setJiaoshi_nianling(String jiaoshi_nianling) {
		this.jiaoshi_nianling = jiaoshi_nianling;
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
	public String getKaoqin_id() {
		return kaoqin_id;
	}
	public void setKaoqin_id(String kaoqin_id) {
		this.kaoqin_id = kaoqin_id;
	}
	public String getKaoqin_shifouqingjia() {
		return kaoqin_shifouqingjia;
	}
	public void setKaoqin_shifouqingjia(String kaoqin_shifouqingjia) {
		this.kaoqin_shifouqingjia = kaoqin_shifouqingjia;
	}
	public String getKaoqin_riqi() {
		return kaoqin_riqi;
	}
	public void setKaoqin_riqi(String kaoqin_riqi) {
		this.kaoqin_riqi = kaoqin_riqi;
	}
	public String getKaoqin_xuanke_id() {
		return kaoqin_xuanke_id;
	}
	public void setKaoqin_xuanke_id(String kaoqin_xuanke_id) {
		this.kaoqin_xuanke_id = kaoqin_xuanke_id;
	}
	public String getKecheng_id() {
		return kecheng_id;
	}
	public void setKecheng_id(String kecheng_id) {
		this.kecheng_id = kecheng_id;
	}
	public String getKecheng_name() {
		return kecheng_name;
	}
	public void setKecheng_name(String kecheng_name) {
		this.kecheng_name = kecheng_name;
	}
	public String getQingjia_id() {
		return qingjia_id;
	}
	public void setQingjia_id(String qingjia_id) {
		this.qingjia_id = qingjia_id;
	}
	public String getQingjia_shifoupijia() {
		return qingjia_shifoupijia;
	}
	public void setQingjia_shifoupijia(String qingjia_shifoupijia) {
		this.qingjia_shifoupijia = qingjia_shifoupijia;
	}
	public String getQingjia_riqi() {
		return qingjia_riqi;
	}
	public void setQingjia_riqi(String qingjia_riqi) {
		this.qingjia_riqi = qingjia_riqi;
	}
	public String getQingjia_yuanyin() {
		return qingjia_yuanyin;
	}
	public void setQingjia_yuanyin(String qingjia_yuanyin) {
		this.qingjia_yuanyin = qingjia_yuanyin;
	}
	public String getQingjia_shijian() {
		return qingjia_shijian;
	}
	public void setQingjia_shijian(String qingjia_shijian) {
		this.qingjia_shijian = qingjia_shijian;
	}
	public String getQingjia_shifoupiyue() {
		return qingjia_shifoupiyue;
	}
	public void setQingjia_shifoupiyue(String qingjia_shifoupiyue) {
		this.qingjia_shifoupiyue = qingjia_shifoupiyue;
	}
	public String getQingjia_xuanke_id() {
		return qingjia_xuanke_id;
	}
	public void setQingjia_xuanke_id(String qingjia_xuanke_id) {
		this.qingjia_xuanke_id = qingjia_xuanke_id;
	}
	public String getShouke_id() {
		return shouke_id;
	}
	public void setShouke_id(String shouke_id) {
		this.shouke_id = shouke_id;
	}
	public String getShouke_kecheng_id() {
		return shouke_kecheng_id;
	}
	public void setShouke_kecheng_id(String shouke_kecheng_id) {
		this.shouke_kecheng_id = shouke_kecheng_id;
	}
	public String getShouke_banji_id() {
		return shouke_banji_id;
	}
	public void setShouke_banji_id(String shouke_banji_id) {
		this.shouke_banji_id = shouke_banji_id;
	}
	public String getShouke_jiaoshi_id() {
		return shouke_jiaoshi_id;
	}
	public void setShouke_jiaoshi_id(String shouke_jiaoshi_id) {
		this.shouke_jiaoshi_id = shouke_jiaoshi_id;
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
	public String getStu_code() {
		return stu_code;
	}
	public void setStu_code(String stu_code) {
		this.stu_code = stu_code;
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
	public String getXuanke_id() {
		return xuanke_id;
	}
	public void setXuanke_id(String xuanke_id) {
		this.xuanke_id = xuanke_id;
	}
	public String getXuanke_stu_id() {
		return xuanke_stu_id;
	}
	public void setXuanke_stu_id(String xuanke_stu_id) {
		this.xuanke_stu_id = xuanke_stu_id;
	}
	public String getXuanke_kecheng_id() {
		return xuanke_kecheng_id;
	}
	public void setXuanke_kecheng_id(String xuanke_kecheng_id) {
		this.xuanke_kecheng_id = xuanke_kecheng_id;
	}
	public String getKechengbiao_id() {
		return kechengbiao_id;
	}
	public void setKechengbiao_id(String kechengbiao_id) {
		this.kechengbiao_id = kechengbiao_id;
	}
	public String getKechengbiao_shangkeriqi() {
		return kechengbiao_shangkeriqi;
	}
	public void setKechengbiao_shangkeriqi(String kechengbiao_shangkeriqi) {
		this.kechengbiao_shangkeriqi = kechengbiao_shangkeriqi;
	}
	public String getKechengbiao_kecheng_id() {
		return kechengbiao_kecheng_id;
	}
	public void setKechengbiao_kecheng_id(String kechengbiao_kecheng_id) {
		this.kechengbiao_kecheng_id = kechengbiao_kecheng_id;
	}
	public String getKechengbiao_banji_id() {
		return kechengbiao_banji_id;
	}
	public void setKechengbiao_banji_id(String kechengbiao_banji_id) {
		this.kechengbiao_banji_id = kechengbiao_banji_id;
	}
	public String getGonggao_id() {
		return gonggao_id;
	}
	public void setGonggao_id(String gonggao_id) {
		this.gonggao_id = gonggao_id;
	}
	public String getGonggao_guanliyuan_id() {
		return gonggao_guanliyuan_id;
	}
	public void setGonggao_guanliyuan_id(String gonggao_guanliyuan_id) {
		this.gonggao_guanliyuan_id = gonggao_guanliyuan_id;
	}
	public String getGonggao_title() {
		return gonggao_title;
	}
	public void setGonggao_title(String gonggao_title) {
		this.gonggao_title = gonggao_title;
	}
	public String getGonggao_neirong() {
		return gonggao_neirong;
	}
	public void setGonggao_neirong(String gonggao_neirong) {
		this.gonggao_neirong = gonggao_neirong;
	}
	public String getGonggao_faqiriqi() {
		return gonggao_faqiriqi;
	}
	public void setGonggao_faqiriqi(String gonggao_faqiriqi) {
		this.gonggao_faqiriqi = gonggao_faqiriqi;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "FieldList [banji_id=" + banji_id + ", banji_name=" + banji_name + ", banji_jiaoshi_id="
				+ banji_jiaoshi_id + ", guanliyuan_id=" + guanliyuan_id + ", guanliyuan_name=" + guanliyuan_name
				+ ", guanliyuan_pwd=" + guanliyuan_pwd + ", guanliyuan_code=" + guanliyuan_code
				+ ", guanliyuan_nianling=" + guanliyuan_nianling + ", guanliyuan_xingbie=" + guanliyuan_xingbie
				+ ", guanliyuan_identity=" + guanliyuan_identity + ", jiaoshi_id=" + jiaoshi_id + ", jiaoshi_name="
				+ jiaoshi_name + ", jiaoshi_pwd=" + jiaoshi_pwd + ", jiaoshi_code=" + jiaoshi_code
				+ ", jiaoshi_xingbie=" + jiaoshi_xingbie + ", jiaoshi_nianling=" + jiaoshi_nianling
				+ ", jiaoshi_identity=" + jiaoshi_identity + ", jiaoshi_shifoudongjie=" + jiaoshi_shifoudongjie
				+ ", jiaoshi_fudaoyuan=" + jiaoshi_fudaoyuan + ", kaoqin_id=" + kaoqin_id + ", kaoqin_shifouqingjia="
				+ kaoqin_shifouqingjia + ", kaoqin_riqi=" + kaoqin_riqi + ", kaoqin_xuanke_id=" + kaoqin_xuanke_id
				+ ", kecheng_id=" + kecheng_id + ", kecheng_name=" + kecheng_name + ", qingjia_id=" + qingjia_id
				+ ", qingjia_shifoupijia=" + qingjia_shifoupijia + ", qingjia_riqi=" + qingjia_riqi
				+ ", qingjia_yuanyin=" + qingjia_yuanyin + ", qingjia_shijian=" + qingjia_shijian
				+ ", qingjia_shifoupiyue=" + qingjia_shifoupiyue + ", qingjia_xuanke_id=" + qingjia_xuanke_id
				+ ", shouke_id=" + shouke_id + ", shouke_kecheng_id=" + shouke_kecheng_id + ", shouke_banji_id="
				+ shouke_banji_id + ", shouke_jiaoshi_id=" + shouke_jiaoshi_id + ", stu_id=" + stu_id + ", stu_name="
				+ stu_name + ", stu_pwd=" + stu_pwd + ", stu_nianling=" + stu_nianling + ", stu_xingbie=" + stu_xingbie
				+ ", stu_code=" + stu_code + ", stu_shifoudongjie=" + stu_shifoudongjie + ", stu_identity="
				+ stu_identity + ", stu_banji_id=" + stu_banji_id + ", xuanke_id=" + xuanke_id + ", xuanke_stu_id="
				+ xuanke_stu_id + ", xuanke_kecheng_id=" + xuanke_kecheng_id + ", kechengbiao_id=" + kechengbiao_id
				+ ", kechengbiao_shangkeriqi=" + kechengbiao_shangkeriqi + ", kechengbiao_kecheng_id="
				+ kechengbiao_kecheng_id + ", kechengbiao_banji_id=" + kechengbiao_banji_id + ", gonggao_id="
				+ gonggao_id + ", gonggao_guanliyuan_id=" + gonggao_guanliyuan_id + ", gonggao_title=" + gonggao_title
				+ ", gonggao_neirong=" + gonggao_neirong + ", gonggao_faqiriqi=" + gonggao_faqiriqi + ", start=" + start
				+ ", rows=" + rows + "]";
	}

}
