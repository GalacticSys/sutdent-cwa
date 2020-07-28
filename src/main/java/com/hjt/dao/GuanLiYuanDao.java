package com.hjt.dao;

import java.util.List;

import com.hjt.pojo.FieldList;
import org.apache.ibatis.annotations.Param;

import com.hjt.pojo.GuanLiYuan;

public interface GuanLiYuanDao {
	//管理员修改密码
	public int updateGuanLiYuanMiMa(@Param("updateGuanLiYuanPwd")String updateGuanLiYuanPwd,@Param("updateGuanLiYuanIdentity")String updateGuanLiYuanIdentity);

	//管理员查看个人信息
	public GuanLiYuan selectGeRenXinXiByCode(@Param("guanLiYuanCode")String guanLiYuanCode);

	//<!-- 管理员查看学生信息 -->
	public List<FieldList> selectStudentXinXiList(FieldList fieldList);
	//<!-- 管理员查看学生信息总条数 -->
	public int selectStudentXinXiListCount(FieldList fieldList);
	//<!-- 管理员查询班级及辅导员信息 -->
	public List<FieldList> selectBanJiAndFuDaoYuanXinXi();
	//<!-- 管理员查询辅导员信息 -->
	public List<FieldList> selectFuDaoYuanXinXi();

	//<!-- 管理员根据id查询学生信息 -->
	public FieldList selectStudentXinXiByCode(@Param("stuId")String stuId);

	//<!-- 管理员修改学生信息 -->
	public int updateStudentXinXi(@Param("updateStuId")String updateStuId,@Param("updateStuCode")String updateStuCode,@Param("updateStuName")String updateStuName,@Param("updateStuIdentity")String updateStuIdentity,@Param("updateStuXingBie")String updateStuXingBie,@Param("updateStuBanJiId")String updateStuBanJiId);

	//管理员新增学生信息
	public int createStudentXinXi(FieldList fieldList);

	//管理员删除学生信息
	public int deleteStuXinXi(@Param("stuId")int stuId);




	//管理员查询教师信息
	public List<FieldList> selectTeacherXinXiList(FieldList fieldList);
	//管理员查询教师信息总条数
	public int selectTeacherXinXiListCount(FieldList fieldList);

	//<!-- 管理员根据id查看教师信息 -->
	public FieldList selectTeacherXinXiById(@Param("teaId")int teaId);

	//管理员修改教师信息
	public int updateTeacherXinXi(@Param("updateTeaName")String updateTeaName,@Param("updateTeaCode")String updateTeaCode,@Param("updateTeaXingBie")String updateTeaXingBie,@Param("updateTeaNianLing")String updateTeaNianLing,@Param("updateTeaIdentity")String updateTeaIdentity,@Param("updateTeaLeiXing")String updateTeaLeiXing,@Param("updateTeaId")String updateTeaId);

	//管理员新增教师信息
	public int createTeacherXinXi(FieldList fieldList);

	//管理员删除教师信息
	public int deleteTeacherXinXi(@Param("teaId")int teaId);



	//管理员查询公告信息
	public List<FieldList> selectAllGongGao(@Param("start")int start,@Param("rows")int rows,@Param("gonggaoId")String gonggaoId,@Param("gonggaoTitle")String gonggaoTitle,@Param("gonggaoNeiRong")String gonggaoNeiRong);
	//管理员查询公告信息总条数
	public int selectAllGongGaoCount(@Param("gonggaoId")String gonggaoId,@Param("gonggaoTitle")String gonggaoTitle,@Param("gonggaoNeiRong")String gonggaoNeiRong);

	//管理员根据公告id查询公告信息
	public FieldList selectGongGaoById(@Param("gonggaoId")int gonggaoId);

	//<!-- 管理员根据公告id修改公告信息 -->
	public int updateGongGaoById(@Param("gonggaoId")String gonggaoId,@Param("gonggaoTitle")String gonggaoTitle,@Param("gonggaoNeiRong")String gonggaoNeiRong);

	//管理员新增公告信息
	public int insertGongGaoXinXi(@Param("gongGaoGuanLiYuanId")String gongGaoGuanLiYuanId,@Param("gonggaoTitle")String gonggaoTitle,@Param("gonggaoNeiRong")String gonggaoNeiRong,@Param("gonggaoFaQiRiqi")String gonggaoFaQiRiqi);

	//管理员删除公告信息
	public int deleteGongGaoXinXi(@Param("gonggaoId")int gonggaoId);
}
