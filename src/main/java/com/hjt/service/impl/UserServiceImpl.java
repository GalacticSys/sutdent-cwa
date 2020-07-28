package com.hjt.service.impl;

import com.hjt.dao.UserDao;
import com.hjt.pojo.GuanLiYuan;
import com.hjt.pojo.JiaoShi;
import com.hjt.pojo.Student;
import com.hjt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	//根据用户ID查询用户
	@Override
	public Student findStudentById(String stuCode) {
		Student student = userDao.findStudentByCode(stuCode);
		return student;
	}
	//根据用户ID和用户密码查询用户
	@Override
	public Student findStudent(String stuCode, String password)
	{
		Student student = userDao.findStudent(stuCode, password);
		return student;
	}

	//根据学生id冻结学生用户
	@Override
	public int updateStudentShifoudongjie(String shiFouDongJie, String stuCode) {
		int result = userDao.updateStudentShifoudongjie(shiFouDongJie, stuCode);
		return result;
	}
	//重置学生用户
	@Override
	public int updateStudentMima(String new_pwd, String new_stuCode) {
		int result = userDao.updateStudentMima(new_pwd, new_stuCode);
		return result;
	}
	//根据教师id、jiaoshi_fudaoyuan查询教师
	@Override
	public JiaoShi findTeacherById(String teaCode, String jiaoShi) {
		JiaoShi teacher = userDao.findTeacherByCode(teaCode,jiaoShi);
		return teacher;
	}
	//根据教师编号、密码查询教师
	@Override
	public JiaoShi findTeacher(String teaCode, String password) {
		JiaoShi teacher = userDao.findTeacher(teaCode, password);
		return teacher;
	}
	//冻结老师登录用户
	@Override
	public int updateTeacherShifoudongjie(String jiaoshiShifoudongjie, String teaCode) {
		int result = userDao.updateTeacherShifoudongjie(jiaoshiShifoudongjie, teaCode);
		return result;
	}
	//<!-- 根据教师编号重置密码 -->
	public int updateTeachertMima(String jiaoshiPwd,String jiaoshiCode)
	{
		int result = userDao.updateTeachertMima(jiaoshiPwd, jiaoshiCode);
		return result;
	}

	//根据id查询管理员用户
	public GuanLiYuan findGuanLiYuanByCode(String guanLiYuanCode)
	{
		GuanLiYuan guanLiYuan = userDao.findGuanLiYuanByCode(guanLiYuanCode);
		return guanLiYuan;

	}

	//根据code、password查询管理员用户
	public GuanLiYuan findGuanLiYuan(String guanLiYuanCode,String password)
	{
		GuanLiYuan guanLiYuan = userDao.findGuanLiYuanByCode(guanLiYuanCode);
		return guanLiYuan;

	}
}
