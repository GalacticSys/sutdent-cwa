package com.hjt.service;

import java.util.List;

import com.hjt.pojo.FieldList;

public interface TeacherService {
	//查询学生考勤信息
	public List<FieldList> teacherSelectKaoQinList(int page, int rows, String teaId, String stuCode, String banjiName, String kechengName, String kaoqinQingjiaRiqi);

	//查询学生请假信息
	public List<FieldList> teacherSelectQingJiaList(int page,int rows,String teaId,String stuCode,String banjiName,String kechengName,String kaoqinQingjiaRiqi);

	//根据教师身份证修改学生密码
	public int updateTeaMiMa(String update_teaIdentity,String update_teaPwd,String tea_id);

	//根据学生id查询学生信息
	public FieldList selectGeRenXinXiById(String teaId);






	//辅导员查询学生的考勤信息
	public List<FieldList> fudaoyuanSelectKaoQinList(int page,int rows,String teaId,String stuCode,String banjiName,String kechengName,String kaoqinQingjiaRiqi);


	//辅导员查询学生的请假信息
	public List<FieldList> fudaoyuanSelectQingJiaList(int page,int rows,String teaId,String stuCode,String banjiName,String kechengName,String kaoqinQingjiaRiqi);

	//辅导员批假
	public int fuDaoYuanPiJia(int shenpiQingjiaId,int shiFouPiJia);


	//教师查询公告信息
	public List<FieldList> selectTeaGongGaoXinXi(int page,int rows,String gonggaoId,String gonggaoTitle,String gonggaoNeiRong);

	//教师查询上课信息
		public List<FieldList> selectShangKeXinXi(int page,int rows,String jiaoshiId,String banjiName,String kechengName,String shangkeriqi);
}
