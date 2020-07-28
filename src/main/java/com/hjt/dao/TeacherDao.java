package com.hjt.dao;

import java.util.List;

import com.hjt.pojo.FieldList;
import org.apache.ibatis.annotations.Param;

public interface  TeacherDao{

	//查询学生考勤信息
	public List<FieldList> teacherSelectKaoQinList(FieldList filedList);
	//查询学生考勤信息总条数
	public int teacherSelectKaoQinListCount(FieldList filedList);

	//查询学生请假信息
	public List<FieldList> teacherSelectQingJiaList(FieldList filedList);
	//查询学生请假信息总条数
	public int teacherSelectQingJiaListCount(FieldList filedList);

	//根据教师身份证修改学生密码
	public int updateTeaMiMa(@Param("update_teaIdentity")String update_teaIdentity,@Param("update_teaPwd")String update_teaPwd,@Param("tea_id")String tea_id);

	//根据学生id查询学生信息
	public FieldList selectGeRenXinXiById(@Param("teaId")String teaId);






	//辅导员查询学生的考勤信息
	public List<FieldList> fudaoyuanSelectKaoQinList(FieldList filedList);

	//辅导员查询学生的考勤信息总条数
	public int fudaoyuanSelectKaoQinListCount(FieldList filedList);


	//辅导员查询学生的请假信息
	public List<FieldList> fudaoyuanSelectQingJiaList(FieldList fieldList);

	//辅导员查询学生的请假信息总条数
	public int fudaoyuanSelectQingJiaListCount(FieldList fieldList);

	//辅导员批假
	public int fuDaoYuanPiJia(@Param("shenpiQingjiaId")int shenpiQingjiaId,@Param("shiFouPiJia")int shiFouPiJia);

	//教师查询公告信息
	public List<FieldList> selectTeaGongGaoXinXi(@Param("start")int start,@Param("rows")int rows,@Param("gonggaoId")String gonggaoId,@Param("gonggaoTitle")String gonggaoTitle,@Param("gonggaoNeiRong")String gonggaoNeiRong);
	//教师查询公告信息总条数
	public int selectTeaGongGaoXinXiCount(@Param("gonggaoId")String gonggaoId,@Param("gonggaoTitle")String gonggaoTitle,@Param("gonggaoNeiRong")String gonggaoNeiRong);

	//教师查询上课信息
		public List<FieldList> selectShangKeXinXi(@Param("start")int start,@Param("rows")int rows,@Param("jiaoshiId")String jiaoshiId,@Param("banjiName")String banjiName,@Param("kechengName")String kechengName,@Param("shangkeriqi")String shangkeriqi);

		//教师查询上课信息总条数
		public int selectShangKeXinXiCount(@Param("jiaoshiId")String jiaoshiId,@Param("banjiName")String banjiName,@Param("kechengName")String kechengName,@Param("shangkeriqi")String shangkeriqi);
}
