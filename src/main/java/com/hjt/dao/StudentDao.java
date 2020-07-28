package com.hjt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hjt.pojo.FieldList;

public interface StudentDao {
	//<!--根据学号、班级、课程、日期，查询考勤信息  -->
	public List<FieldList> selectKaoQinList(FieldList fieldList);
	//<!--根据学号、班级、课程、日期，查询考勤信息总条数  -->
	public int selectKaoQinListCount(FieldList fieldList);

	//<!--根据学号、班级、课程、日期，查询请假信息  -->
	public List<FieldList> selectQingJiaList(FieldList fieldList);
	//<!--根据学号、班级、课程、日期，查询请假信息总条数  -->
	public int selectQingJiaListCount(FieldList fieldList);

	//根据学生身份证修改学生密码
	public int updateStuMiMa(@Param("update_stuIdentity")String update_stuIdentity,@Param("update_stuPwd")String update_stuPwd,@Param("stu_code")String stu_code);

	//<!-- 根据学生id、课程名称查询学生选课信息 -->
	public FieldList selectStudentXuanKe(@Param("stuId")String stuId,@Param("qingjia_kechengname")String qingjia_kechengname);

	//<!-- 根据上课日期、课程名称、班级id查询课程表信息信息 -->
	public FieldList selectKeChengBiao(@Param("qingjiaKechengname")String qingjiaKechengname,@Param("stuId")String stuId,@Param("qingjiaShangkeshijian")String qingjiaShangkeshijian);

	//<!-- 添加请假表信息 -->
	public int insertQingJiaXinXi(@Param("qingjiaRiqi")String qingjiaRiqi,@Param("qingjiaShijian")String qingjiaShijian,@Param("qingjiaYuanyin")String qingjiaYuanyin,@Param("qingjiaXuankeId")String qingjiaXuankeId,@Param("qingjiaKechengbiaoId")String qingjiaKechengbiaoId);

	//根据学生id查询学生信息
	public FieldList selectGeRenXinXiByCode(@Param("stuCode")String stuCode);
	//学生查询上课信息
	public List<FieldList> selectShangKeXinXi(@Param("start")int start,@Param("rows")int rows,@Param("stuId")String stuId,@Param("jiaoshiName")String jiaoshiName,@Param("kechengName")String kechengName,@Param("shangkeriqi")String shangkeriqi);
	//学生查询公告 信息
	public List<FieldList> selectStuGongGaoXin(@Param("start")int start,@Param("rows")int rows,@Param("gonggaoId")String gonggaoId,@Param("gonggaoTitle")String gonggaoTitle,@Param("gonggaoNeiRong")String gonggaoNeiRong);
	//学生查询公告 信息总条数
	public int selectStuGongGaoXinCount(@Param("gonggaoId")String gonggaoId,@Param("gonggaoTitle")String gonggaoTitle,@Param("gonggaoNeiRong")String gonggaoNeiRong);

}
