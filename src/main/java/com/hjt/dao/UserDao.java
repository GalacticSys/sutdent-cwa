package com.hjt.dao;

import com.hjt.pojo.GuanLiYuan;
import com.hjt.pojo.JiaoShi;
import com.hjt.pojo.Student;
import org.apache.ibatis.annotations.Param;

/**
 * 用户登录
 * @author 胡江涛
 *
 */
public interface UserDao {
	//根据学生ID查询用户
	public Student findStudentByCode(@Param("stuCode")String stuCode);
	//根据学生ID和学生密码查询用户
	public Student findStudent(@Param("stuCode") String userCode,@Param("password") String password);
	//冻结登录学生用户
	public int updateStudentShifoudongjie(@Param("shiFouDongJie") String shiFouDongJie,@Param("stuCode") String stuCode);
	//重置学生用户
	public int updateStudentMima(@Param("new_pwd") String new_pwd,@Param("new_stuCode") String new_stuCode);


	//根据教师id查询用户
	public JiaoShi findTeacherByCode(@Param("teaCode")String teaCode, @Param("jiaoShi")String jiaoShi);
	//根据老师用户id、密码查询用户
	public JiaoShi findTeacher(@Param("teaCode")String teaCode,@Param("password")String password);
	//冻结老师登录用户updateTeachertMima
	public int updateTeacherShifoudongjie(@Param("jiaoshiShifoudongjie")String jiaoshiShifoudongjie,@Param("teaCode")String teaCode);

	//<!-- 根据教师编号重置密码 -->
	public int updateTeachertMima(@Param("jiaoshiPwd")String jiaoshiPwd,@Param("jiaoshiCode")String jiaoshiCode);

	//根据id查询管理员用户
	public GuanLiYuan findGuanLiYuanByCode(@Param("guanLiYuanCode")String guanLiYuanCode);

	//根据管理员code、password查询管理员用户
	public GuanLiYuan findGuanLiYuan(@Param("guanLiYuanCode")String guanLiYuanCode,@Param("password")String password);
}
