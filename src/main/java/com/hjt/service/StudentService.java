package com.hjt.service;

import java.util.List;

import com.hjt.pojo.FieldList;

public interface StudentService {

	//<!--根据学号、班级、课程、日期，查询考勤信息  -->
	public List<FieldList> selectKaoQinList(int page, int rows, String stuCode, String banjiName, String kechengName, String kaoqinRiqi);

	//<!--根据学号、班级、课程、日期，查询考勤信息总条数  -->
	public List<FieldList> selectQingJiaList(int page,int rows,String stuCode,String banjiName, String kechengName,String kaoqinRiqi);

	//根据学生身份证修改学生密码
	public int updateStuMiMa(String update_stuIdentity,String update_stuPwd,String stu_code);

	//<!-- 根据学生id、课程名称查询学生选课信息 -->
	public FieldList selectStudentXuanKe(String stuId,String qingjia_kechengname);

	//<!-- 根据上课日期、课程名称、班级id查询课程表信息信息 -->
	public FieldList selectKeChengBiao(String qingjiaKechengname,String stuId,String qingjiaShangkeshijian);

	//<!-- 添加请假表信息 -->
	public int insertQingJiaXinXi(String qingjiaRiqi,String qingjiaShijian,String qingjiaYuanyin,String qingjiaXuankeId,String qingjiaKechengbiaoId);

	//根据教师id查询学生信息
	public FieldList selectGeRenXinXiByCode(String stuCode);
	//学生查询上课信息
	public List<FieldList> selectShangKeXinXi(int start,int rows,String stuId,String jiaoshiName,String kechengName,String shangkeriqi);

	//学生查询公告 信息
	public List<FieldList> selectStuGongGaoXin(int page,int rows,String gonggaoId,String gonggaoTitle,String gonggaoNeiRong);
}
