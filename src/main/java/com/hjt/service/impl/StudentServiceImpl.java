package com.hjt.service.impl;

import java.util.List;

import com.hjt.dao.StudentDao;
import com.hjt.pojo.FieldList;
import com.hjt.service.StudentService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
    StudentDao studentDao;
	//查询学生考勤信息
	@Override
	public List<FieldList> selectKaoQinList(int page, int rows, String stuCode, String stuBanjiId, String kechengName, String kaoqinRiqi) {
		int start =(page-1)*rows;
		FieldList fieldList = new FieldList();
		if(StringUtils.isNotBlank(stuCode))
		{
			fieldList.setStu_code(stuCode);
			System.out.println("StudentServiceImpl stuId设置为"+stuCode);
		}
		if(StringUtils.isNotBlank(stuBanjiId))
		{
			System.out.println("StudentServiceImpl banjiid设置为"+stuBanjiId);
			fieldList.setStu_banji_id(stuBanjiId);
		}
		if(StringUtils.isNotBlank(kechengName))
		{
			System.out.println("StudentServiceImpl kechengName设置为"+kechengName);
			fieldList.setKecheng_name(kechengName);
		}
		if(StringUtils.isNotBlank(kaoqinRiqi))
		{
			System.out.println("StudentServiceImpl kaoqinRiqi设置为"+kaoqinRiqi);
			fieldList.setKaoqin_riqi(kaoqinRiqi);
		}
		fieldList.setStart(start);
		fieldList.setRows(rows);
		System.out.println("StudentServiceImpl start="+start);
		System.out.println("StudentServiceImpl rows="+rows);
		System.out.println("StudentServiceImpl stuId="+stuCode);
		System.out.println("StudentServiceImpl banjiId="+stuBanjiId);
		System.out.println("StudentServiceImpl kechengName="+kechengName);
		System.out.println("StudentServiceImpl kaoqinRiqi="+kaoqinRiqi);
		System.out.println("=================================================");
		List<FieldList> fieldList1 = studentDao.selectKaoQinList(fieldList);
		return fieldList1;
	}
	//查询学生请假信息
	@Override
	public List<FieldList> selectQingJiaList(int page, int rows, String stuCode, String stuBanjiId, String kechengName,
			String qingjiaRiqi)
	{
		int start =(page-1)*rows;
		FieldList fieldList = new FieldList();
		if(StringUtils.isNotBlank(stuCode))
		{
			fieldList.setStu_code(stuCode);
			System.out.println("StudentServiceImpl stuId设置为"+stuCode);
		}
		if(StringUtils.isNotBlank(stuBanjiId))
		{
			System.out.println("StudentServiceImpl banjiName设置为"+stuBanjiId);
			fieldList.setStu_banji_id(stuBanjiId);
		}
		if(StringUtils.isNotBlank(kechengName))
		{
			System.out.println("StudentServiceImpl kechengName设置为"+kechengName);
			fieldList.setKecheng_name(kechengName);
		}
		if(StringUtils.isNotBlank(qingjiaRiqi))
		{
			System.out.println("StudentServiceImpl qingjaiRiqi设置为"+qingjiaRiqi);
			fieldList.setQingjia_riqi(qingjiaRiqi);
		}
		fieldList.setStart(start);
		fieldList.setRows(rows);
		System.out.println("StudentServiceImpl qingjia start="+start);
		System.out.println("StudentServiceImpl qingjia rows="+rows);
		System.out.println("StudentServiceImpl qingjia stuId="+stuCode);
		System.out.println("StudentServiceImpl qingjia banjiName="+stuBanjiId);
		System.out.println("StudentServiceImpl qingjia kechengName="+kechengName);
		System.out.println("StudentServiceImpl qingjia kaoqinRiqi="+qingjiaRiqi);
		System.out.println("=================================================");
		List<FieldList> fieldList1 = studentDao.selectQingJiaList(fieldList);
		return fieldList1;
	}
	//根据学生身份证修改学生密码
	@Override
	public int updateStuMiMa(String update_stuIdentity, String update_stuPwd,String stu_code) {
		int result = studentDao.updateStuMiMa(update_stuIdentity,update_stuPwd,stu_code);
		return result;
	}

	//<!-- 根据学生id、课程名称查询学生选课信息 -->
	@Override
	public FieldList selectStudentXuanKe(String stuId, String qingjia_kechengname) {
		FieldList fieldList = studentDao.selectStudentXuanKe(stuId, qingjia_kechengname);
		return fieldList;
	}
	//<!-- 根据上课日期、课程名称、班级id查询课程表信息 -->
	public FieldList selectKeChengBiao(String qingjiaKechengname,String stuId,String qingjiaShangkeshijian)
	{
		FieldList fieldList=studentDao.selectKeChengBiao(qingjiaKechengname, stuId, qingjiaShangkeshijian);
		return fieldList;
	}

	//<!-- 添加请假表信息 -->
	@Override
	public int insertQingJiaXinXi(String qingjiaRiqi,String qingjiaShijian,String qingjiaYuanyin,String qingjiaXuankeId,String qingjiaKechengbiaoId){
		int result=studentDao.insertQingJiaXinXi(qingjiaRiqi, qingjiaShijian, qingjiaYuanyin, qingjiaXuankeId, qingjiaKechengbiaoId);
		return result;
	}

	//根据学生id查询学生信息
	@Override
	public FieldList selectGeRenXinXiByCode(String stuCode) {
		FieldList fieldList=studentDao.selectGeRenXinXiByCode(stuCode);
		return fieldList;
	}
	//学生查询上课信息
	@Override
	public List<FieldList> selectShangKeXinXi(int page,int rows,String stuId,String jiaoshiName,String kechengName,String shangkeriqi)
	{
		int start = (page-1)*rows;
		List<FieldList> fieldList=studentDao.selectShangKeXinXi(start, rows, stuId,jiaoshiName,kechengName,shangkeriqi);
		return fieldList;
		}
	//学生查询公告 信息
	@Override
	public List<FieldList> selectStuGongGaoXin(int page,int rows,String gonggaoId,String gonggaoTitle,String gonggaoNeiRong)
	{
		int start = (page-1)*rows;
		List<FieldList> fieldList=studentDao.selectStuGongGaoXin(start, rows, gonggaoId, gonggaoTitle, gonggaoNeiRong);
		return fieldList;
	}
}
