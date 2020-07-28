package com.hjt.service.impl;

import java.util.List;

import com.hjt.pojo.FieldList;
import com.hjt.dao.GuanLiYuanDao;
import com.hjt.pojo.GuanLiYuan;
import com.hjt.service.GuanLiYuanService;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GuanLiYuanServicImpl implements GuanLiYuanService {

	@Autowired
	public GuanLiYuanDao guanLiYuanDao;

	//管理员修改密码
	@Override
	public int updateGuanLiYuanMiMa(String updateGuanLiYuanPwd, String updateGuanLiYuanIdentity) {
		int result = guanLiYuanDao.updateGuanLiYuanMiMa(updateGuanLiYuanPwd, updateGuanLiYuanIdentity);
		return result;
	}

	//管理员查看个人信息
	@Override
	public GuanLiYuan selectGeRenXinXiByCode(String guanLiYuanCode) {
		GuanLiYuan guanLiYuan = guanLiYuanDao.selectGeRenXinXiByCode(guanLiYuanCode);
		return guanLiYuan;
	}


	//<!-- 管理员查看学生信息 -->
	@Override
	public List<FieldList> selectStudentXinXiList(int page, int rows, String stuCode, String banjiName, String jiaoshiName) {
		FieldList fieldList = new FieldList();
		fieldList.setStart((page-1)*rows);
		fieldList.setRows(rows);
		if(StringUtils.isNotBlank(stuCode))
		{
			fieldList.setStu_code(stuCode);
		}
		if(StringUtils.isNotBlank(banjiName))
		{
			fieldList.setBanji_name(banjiName);
		}
		if(StringUtils.isNotBlank(jiaoshiName))
		{
			fieldList.setJiaoshi_name(jiaoshiName);
		}
		List<FieldList> fieldList1 = guanLiYuanDao.selectStudentXinXiList(fieldList);
		//int sum = guanLiYuanDao.selectStudentXinXiListCount(fieldList);
		return fieldList1;
	}
	//<!-- 管理员根据id查询学生信息 -->
	@Override
	public FieldList selectStudentXinXiByCode(String stuId) {
		FieldList fieldList = guanLiYuanDao.selectStudentXinXiByCode(stuId);
		return fieldList;
	}

	//<!-- 管理员查询班级及辅导员信息 -->
	@Override
	public List<FieldList> selectBanJiAndFuDaoYuanXinXi(){
		List<FieldList> banJiAndFuDaoYuan = guanLiYuanDao.selectBanJiAndFuDaoYuanXinXi();
		return banJiAndFuDaoYuan;
	}
	//<!-- 管理员查询班级及辅导员信息 -->
	public List<FieldList> selectFuDaoYuanXinXi()
	{
		List<FieldList> banJiAndFuDaoYuan = guanLiYuanDao.selectFuDaoYuanXinXi();
		return banJiAndFuDaoYuan;
	}

	//<!-- 管理员修改学生信息 -->
	@Override
	public int updateStudentXinXi(String updateStuId,String updateStuCode,String updateStuName,String updateStuIdentity,String updateStuXingBie,String updateStuBanJiId)
	{
		int result = guanLiYuanDao.updateStudentXinXi(updateStuId,updateStuCode,updateStuName, updateStuIdentity, updateStuXingBie, updateStuBanJiId);
		return result;
	}

	//管理员新增学生信息
	@Override
	public int createStudentXinXi(String stuName,String stuNianling,String stuXingbie,String stuCode,String stuIdentity,String stuBanjiId)
	{
		FieldList fieldList = new FieldList();
		fieldList.setStu_code(stuCode);
		fieldList.setStu_name(stuName);
		fieldList.setStu_identity(stuIdentity);
		fieldList.setStu_nianling(stuNianling);
		fieldList.setStu_xingbie(stuXingbie);
		fieldList.setStu_banji_id(stuBanjiId);
		if(stuIdentity!=null)
		{
			System.out.println("serviceImpl stuPwd"+stuIdentity.substring(stuIdentity.length()-3));
			fieldList.setStu_pwd(stuIdentity.substring(stuIdentity.length()-3));
		}
		int result = guanLiYuanDao.createStudentXinXi(fieldList);
		return result;
	}
	//管理员删除学生信息
	@Override
	public int deleteStuXinXi(int stuId)
	{
		int result = guanLiYuanDao.deleteStuXinXi(stuId);
		return result;
	}


	//管理员查询教师信息
	@Override
	public List<FieldList> selectTeadentXinXiList(int page,int rows,String teaCode,String jiaoShiName,String jiaoShiLeiBie)
	{
		FieldList fieldList = new FieldList();
		fieldList.setStart((page-1)*rows);
		fieldList.setRows(rows);
		if(StringUtils.isNotBlank(teaCode))
		{
			fieldList.setJiaoshi_code(teaCode);
		}
		if(StringUtils.isNotBlank(jiaoShiName))
		{
			fieldList.setJiaoshi_name(jiaoShiName);
		}
		if(StringUtils.isNotBlank(jiaoShiLeiBie) && !jiaoShiLeiBie.equals("2"))
		{
			fieldList.setJiaoshi_fudaoyuan(jiaoShiLeiBie);
			System.out.println("将jiaoShiLeiBie放入fieldList中"+jiaoShiLeiBie);
		}
		List<FieldList> fieldList1 = guanLiYuanDao.selectTeacherXinXiList(fieldList);
		//int sum = guanLiYuanDao.selectTeacherXinXiListCount(fieldList);
		return fieldList1;
	}

	//<!-- 管理员根据id查看教师信息 -->
	@Override
	public FieldList selectTeacherXinXiById(int teaId){
		FieldList fieldList = guanLiYuanDao.selectTeacherXinXiById(teaId);
		return fieldList;
	}

	//管理员修改教师信息
	@Override
	public int updateTeacherXinXi(String updateTeaName,String updateTeaCode,String updateTeaXingBie,String updateTeaNianLing,String updateTeaIdentity,String updateTeaLeiXing,String updateTeaId)
	{
		int result = guanLiYuanDao.updateTeacherXinXi(updateTeaName, updateTeaCode, updateTeaXingBie, updateTeaNianLing, updateTeaIdentity, updateTeaLeiXing, updateTeaId);
		return result;
	}

	//管理员新增教师信息
	@Override
	public int createTeacherXinXi(String createTeaName,String createTeaCode,String createTeaXingBie,String createTeaNianLing,String createTeaIdentity,String createTeaFuDaoYuan){
		FieldList fieldList = new FieldList();
		fieldList.setJiaoshi_name(createTeaName);
		fieldList.setJiaoshi_code(createTeaCode);
		fieldList.setJiaoshi_xingbie(createTeaXingBie);
		fieldList.setJiaoshi_nianling(createTeaNianLing);
		fieldList.setJiaoshi_identity(createTeaIdentity);
		fieldList.setJiaoshi_fudaoyuan(createTeaFuDaoYuan);
		if(createTeaIdentity!=null)
		{
			fieldList.setJiaoshi_pwd(createTeaIdentity.substring(createTeaIdentity.length()-3));
		}
		System.out.println("serviceImpl"+fieldList);
		int result = guanLiYuanDao.createTeacherXinXi(fieldList);
		return result;
	}

	//管理员删除教师信息
	@Override
	public int deleteTeacherXinXi(int teaId)
	{
		int result = guanLiYuanDao.deleteTeacherXinXi(teaId);
		return result;
	}

	//管理员查询公告信息
	@Override
	public List<FieldList> selectAllGongGao(int page,int rows,String gonggaoId,String gonggaoTitle,String gonggaoNeiRong){
		int start = (page-1)*rows;
		List<FieldList> fieldList = guanLiYuanDao.selectAllGongGao(start,rows,gonggaoId, gonggaoTitle, gonggaoNeiRong);
		//int sum = guanLiYuanDao.selectAllGongGaoCount(gonggaoId, gonggaoTitle, gonggaoNeiRong);
		return fieldList;
	}

	//管理员根据公告id查询公告信息
	@Override
	public FieldList selectGongGaoById(@Param("gonggaoId")int gonggaoId)
	{
		FieldList fieldList = guanLiYuanDao.selectGongGaoById(gonggaoId);
		return fieldList;
	}

	//<!-- 管理员根据公告id修改公告信息 -->
	@Override
	public int updateGongGaoById(String gonggaoId,String gonggaoTitle,String gonggaoNeiRong)
	{
		int result = guanLiYuanDao.updateGongGaoById(gonggaoId, gonggaoTitle, gonggaoNeiRong);
		return result;
	}
	//管理员新增公告信息
	@Override
	public int insertGongGaoXinXi(String gongGaoGuanLiYuanId,String gonggaoTitle, String gonggaoNeiRong,String gonggaoFaQiRiqi) {
		int result = guanLiYuanDao.insertGongGaoXinXi(gongGaoGuanLiYuanId,gonggaoTitle, gonggaoNeiRong,gonggaoFaQiRiqi);
		return result;
	}

	//管理员删除公告信息
	@Override
	public int deleteGongGaoXinXi(int gonggaoId) {
		int result = guanLiYuanDao.deleteGongGaoXinXi(gonggaoId);
		return result;
	}
}
