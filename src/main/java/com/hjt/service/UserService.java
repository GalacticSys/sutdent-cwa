package com.hjt.service;

import com.hjt.pojo.Student;
import com.hjt.pojo.GuanLiYuan;
import com.hjt.pojo.JiaoShi;

public interface UserService {
	//根据学生用户ID和用户密码查询用户
	public Student findStudent(String stuCode, String password);
	//根据学生用户ID查询用户
	public Student findStudentById(String stuCode);
	//冻结学生登录用户
	public int updateStudentShifoudongjie(String shiFouDongJie,String stuCode);
	//重置学生用户
	public int updateStudentMima(String new_pwd,String new_stuCode);

	//根据老师用户id查询用户
	public JiaoShi findTeacherById(String teaCode, String jiaoShi);
	//根据老师用户id、密码查询用户
	public JiaoShi findTeacher(String teaCode,String password);
	//冻结老师登录用户
	public int updateTeacherShifoudongjie(String jiaoshiShifoudongjie,String teaCode);

	//<!-- 根据教师编号重置密码 -->
	public int updateTeachertMima(String jiaoshiPwd,String jiaoshiCode);

	//根据id查询管理员用户
	public GuanLiYuan findGuanLiYuanByCode(String guanLiYuanCode);

	//根据管理员code、password查询管理员用户
	public GuanLiYuan findGuanLiYuan(String guanLiYuanCode,String password);

}
