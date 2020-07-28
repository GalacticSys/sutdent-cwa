package com.hjt.service.impl;

import java.util.List;

import com.hjt.dao.TeacherDao;
import com.hjt.pojo.FieldList;
import com.hjt.service.TeacherService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
	@Autowired
    TeacherDao teacherDao;
	//查询学生考勤信息
	@Override
	public List<FieldList> teacherSelectKaoQinList(int page, int rows, String teaId, String stuCode, String banjiName, String kechengName, String kaoqinQingjiaRiqi) {
		FieldList fieldList=new FieldList();
		fieldList.setStart((page-1)*rows);
		fieldList.setRows(rows);
		if(StringUtils.isNotBlank(teaId))
		{
			fieldList.setJiaoshi_id(teaId);
		}
		if(StringUtils.isNotBlank(stuCode))
		{
			fieldList.setStu_code(stuCode);
		}
		if(StringUtils.isNotBlank(kechengName))
		{
			fieldList.setKecheng_name(kechengName);
		}
		if(StringUtils.isNotBlank(banjiName))
		{
			fieldList.setBanji_name(banjiName);
		}
		if(StringUtils.isNotBlank(kaoqinQingjiaRiqi))
		{
			fieldList.setKaoqin_riqi(kaoqinQingjiaRiqi);
		}

		List<FieldList> filedList = teacherDao.teacherSelectKaoQinList(fieldList);
		//int sum=teacherDao.teacherSelectKaoQinListCount(fieldList);
		return filedList;
	}
	//查询学生请假信息
	@Override
	public List<FieldList> teacherSelectQingJiaList(int page, int rows, String teaId, String stuCode, String banjiName,
			String kechengName, String kaoqinQingjiaRiqi) {
		FieldList fieldList=new FieldList();
		fieldList.setStart((page-1)*rows);
		fieldList.setRows(rows);
		if(StringUtils.isNotBlank(teaId))
		{
			fieldList.setJiaoshi_id(teaId);
		}
		if(StringUtils.isNotBlank(stuCode))
		{
			fieldList.setStu_code(stuCode);
		}
		if(StringUtils.isNotBlank(kechengName))
		{
			fieldList.setKecheng_name(kechengName);
		}
		if(StringUtils.isNotBlank(banjiName))
		{
			fieldList.setBanji_name(banjiName);
		}
		if(StringUtils.isNotBlank(kaoqinQingjiaRiqi))
		{
			fieldList.setQingjia_riqi(kaoqinQingjiaRiqi);
		}

		List<FieldList> fieldList1 = teacherDao.teacherSelectQingJiaList(fieldList);
		//int sum=teacherDao.teacherSelectQingJiaListCount(fieldList);
		return fieldList1;
	}

	//根据教师身份证修改学生密码
	@Override
	public int updateTeaMiMa(String update_teaIdentity, String update_teaPwd,String tea_id) {
		int result = teacherDao.updateTeaMiMa(update_teaIdentity, update_teaPwd,tea_id);
		return result;
	}

	//根据教师id查询学生信息
	@Override
	public FieldList selectGeRenXinXiById(String teaId) {
		FieldList fieldList =teacherDao.selectGeRenXinXiById(teaId);
		return fieldList;
	}





	//辅导员查询学生的考勤信息
	@Override
	public List<FieldList> fudaoyuanSelectKaoQinList(int page,int rows,String teaId,String stuCode,String banjiName,String kechengName,String kaoqinQingjiaRiqi) {
		FieldList fieldList = new FieldList();
		fieldList.setStart((page-1)*rows);
		fieldList.setRows(rows);
		System.out.println(teaId);
		if(StringUtils.isNotBlank(teaId))
		{
			System.out.println("teaId不为空");
			fieldList.setJiaoshi_id(teaId);
		}
		if(StringUtils.isNotBlank(stuCode))
		{
			fieldList.setStu_code(stuCode);
		}
		if(StringUtils.isNotBlank(banjiName))
		{
			fieldList.setBanji_name(banjiName);
		}
		if(StringUtils.isNotBlank(kechengName))
		{
			fieldList.setKecheng_name(kechengName);
		}
		if(StringUtils.isNotBlank(kaoqinQingjiaRiqi))
		{
			fieldList.setKaoqin_riqi(kaoqinQingjiaRiqi);
		}
		List<FieldList> fieldList1 = teacherDao.fudaoyuanSelectKaoQinList(fieldList);
		//int sum = teacherDao.fudaoyuanSelectKaoQinListCount(fieldList);
		return fieldList1;
	}

	//辅导员查询学生的请假信息
	@Override
	public List<FieldList> fudaoyuanSelectQingJiaList(int page, int rows, String teaId, String stuCode,
			String banjiName, String kechengName, String kaoqinQingjiaRiqi) {
		FieldList fieldList = new FieldList();
		fieldList.setStart((page-1)*rows);
		fieldList.setRows(rows);
		if(StringUtils.isNotBlank(teaId))
		{
			fieldList.setJiaoshi_id(teaId);
		}
		if(StringUtils.isNotBlank(stuCode))
		{
			fieldList.setStu_code(stuCode);
		}
		if(StringUtils.isNotBlank(banjiName))
		{
			fieldList.setBanji_name(banjiName);
		}
		if(StringUtils.isNotBlank(kechengName))
		{
			fieldList.setKecheng_name(kechengName);
		}
		if(StringUtils.isNotBlank(kaoqinQingjiaRiqi))
		{
			fieldList.setQingjia_riqi(kaoqinQingjiaRiqi);
		}
		List<FieldList> fieldList1 = teacherDao.fudaoyuanSelectQingJiaList(fieldList);
		//int sum = teacherDao.fudaoyuanSelectQingJiaListCount(fieldList);
		return fieldList1;
	}
	//辅导员批假
	@Override
	public int fuDaoYuanPiJia(int shenpiQingjiaId,int shiFouPiJia) {
		int result = teacherDao.fuDaoYuanPiJia(shenpiQingjiaId,shiFouPiJia);
		return result;
	}


	//教师查询公告信息
	public List<FieldList> selectTeaGongGaoXinXi(int page,int rows,String gonggaoId,String gonggaoTitle,String gonggaoNeiRong){
		int start = (page-1)*rows;
		List<FieldList> fieldList = teacherDao.selectTeaGongGaoXinXi(start, rows, gonggaoId, gonggaoTitle, gonggaoNeiRong);
		//int sum = teacherDao.selectTeaGongGaoXinXiCount(gonggaoId, gonggaoTitle, gonggaoNeiRong);
		return fieldList;
	}
	//查询课程表
		@Override
		public List<FieldList> selectShangKeXinXi(int page,int rows,String jiaoshiId,String banjiName,String kechengName,String shangkeriqi)
		{
			int start = (page-1)*rows;
			List<FieldList> fieldList = teacherDao.selectShangKeXinXi(start, rows, jiaoshiId, banjiName, kechengName, shangkeriqi);
			//int sum = teacherDao.selectShangKeXinXiCount(jiaoshiId, banjiName, kechengName, shangkeriqi);

			return fieldList;
		}
}
