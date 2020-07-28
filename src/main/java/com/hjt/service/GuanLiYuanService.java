package com.hjt.service;

import java.util.List;

import com.hjt.pojo.FieldList;
import com.hjt.pojo.GuanLiYuan;

public interface GuanLiYuanService {

	//管理员修改密码
	public int updateGuanLiYuanMiMa(String updateGuanLiYuanPwd,String updateGuanLiYuanIdentity);

	//管理员查看个人信息
	public GuanLiYuan selectGeRenXinXiByCode(String guanLiYuanCode);

	//<!-- 管理员查看学生信息 -->
	public List<FieldList> selectStudentXinXiList(int page, int rows, String stuCode, String banjiName, String jiaoshiName);
	//<!-- 管理员根据id查询学生信息 -->
	public FieldList selectStudentXinXiByCode(String stuId);

	//<!-- 管理员查询班级及辅导员信息 -->
	public List<FieldList> selectBanJiAndFuDaoYuanXinXi();
	//<!-- 管理员查询班级及辅导员信息 -->
	public List<FieldList> selectFuDaoYuanXinXi();

	//<!-- 管理员修改学生信息 -->
	public int updateStudentXinXi(String updateStuId,String updateStuCode,String updateStuName,String updateStuIdentity,String updateStuXingBie,String updateStuBanJiId);


	//管理员新增学生信息
	public int createStudentXinXi(String stuName,String stuNianling,String stuXingbie,String stuCode,String stuIdentity,String stuBanjiId);

	//管理员删除学生信息
	public int deleteStuXinXi(int stuId);



	//管理员查询教师信息
	public List<FieldList> selectTeadentXinXiList(int page,int rows,String teaCode,String jiaoShiName,String jiaoShiLeiBie);

	//<!-- 管理员根据id查看教师信息 -->
	public FieldList selectTeacherXinXiById(int teaId);

	//管理员修改教师信息
	public int updateTeacherXinXi(String updateTeaName,String updateTeaCode,String updateTeaXingBie,String updateTeaNianLing,String updateTeaIdentity,String updateTeaLeiXing,String updateTeaId);

	//管理员新增教师信息
	public int createTeacherXinXi(String createTeaName,String createTeaCode,String createTeaXingBie,String createTeaNianLing,String createTeaIdentity,String createTeaFuDaoYuan);

	//管理员删除教师信息
	public int deleteTeacherXinXi(int teaId);

	//管理员查询公告信息
	public List<FieldList> selectAllGongGao(int page,int rows,String gonggaoId,String gonggaoTitle,String gonggaoNeiRong);

	//管理员根据公告id查询公告信息
	public FieldList selectGongGaoById(int gonggaoId);

	//<!-- 管理员根据公告id修改公告信息 -->
	public int updateGongGaoById(String gonggaoId,String gonggaoTitle,String gonggaoNeiRong);

	//管理员新增公告信息
	public int insertGongGaoXinXi(String gongGaoGuanLiYuanId,String gonggaoTitle,String gonggaoNeiRong,String gonggaoFaQiRiqi);

	//管理员删除公告信息
	public int deleteGongGaoXinXi(int gonggaoId);
}
