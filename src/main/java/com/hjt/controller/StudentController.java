package com.hjt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.hjt.pojo.FieldList;
import com.hjt.pojo.Student;
import com.hjt.service.StudentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class StudentController {

	@Autowired
    StudentService studentService;


	@RequestMapping(value="/student/kaoQinXinXi.action")
	@RequiresRoles("student")
	@RequiresPermissions("kaoqin:query")
	public String kaoQinChaXun(HttpServletRequest request,@RequestParam(defaultValue="1")int pageNum,@RequestParam(defaultValue="10")int rows,String stuCode,String kechengName,String kaoqinRiqi,Model model)
	{
		HttpSession session = request.getSession();
		String url=request.getRequestURI().toString();
		System.out.println("url"+url);
		Student user = (Student)session.getAttribute("USER_SESSION");
		if (user==null){
			return "index";
		}
		String banjiId =user.getStu_banji_id();
		System.out.println("STUDENT_SESSION中的banji_id"+user);
		//model.addAttribute("yongHuLeiXing","xueSheng");
		//若msg=kaoqin,则查询学生考勤信息
			System.out.println(stuCode);
			System.out.println(banjiId);
			System.out.println(kechengName);
			System.out.println(kaoqinRiqi);
			PageHelper.startPage(pageNum,2);
			List<FieldList> fieldList = studentService.selectKaoQinList(pageNum,rows,stuCode, banjiId, kechengName, kaoqinRiqi);
			System.out.println(fieldList.toString());
			PageInfo<FieldList> pageInfo = new PageInfo<>(fieldList);
			model.addAttribute("pageInfo",pageInfo);
			model.addAttribute("stuCode",stuCode);
			model.addAttribute("kechengName",kechengName);
			model.addAttribute("kaoqinRiqi",kaoqinRiqi);
		return "html/student/kaoqinxinxi";
	}
	//学生查看请假信息
	@RequestMapping(value="/student/qingJiaXinXi.action")
	@RequiresRoles("student")
	@RequiresPermissions("qingjia:query")
	public String qingJiaChaXun(HttpServletRequest request,@RequestParam(defaultValue="1")int pageNum,@RequestParam(defaultValue="2")int rows,String stuCode,String kechengName,String kaoqinRiqi,Model model)
	{
		HttpSession session = request.getSession();
		Student user = (Student)session.getAttribute("USER_SESSION");
		String banjiId =user.getStu_banji_id();
		System.out.println("STUDENT_SESSION中的banji_id"+user);
		System.out.println(";;;"+pageNum);
		System.out.println(stuCode);
		System.out.println("111"+banjiId);
		System.out.println(kechengName);
		System.out.println(kaoqinRiqi);
		PageHelper.startPage(pageNum,rows);
		List<FieldList> fieldList = studentService.selectQingJiaList(pageNum, rows, stuCode, banjiId, kechengName, kaoqinRiqi);
		System.out.println(fieldList.size()+"请假信息"+fieldList.toString());
		PageInfo<FieldList> pageInfo = new PageInfo<>(fieldList);
		model.addAttribute("pageInfo",pageInfo);
		return "html/student/qingjiaxinxi";
	}
	//学生修改密码
	@RequestMapping("/student/updateStuMiMa.action")
	@ResponseBody
	@RequiresRoles("student")
	@RequiresPermissions("student:edit")
	public String updateStuMiMa(HttpServletRequest request,String update_stuIdentity,String update_stuPwd)
	{
		HttpSession session = request.getSession();
		Student student = (Student) session.getAttribute("USER_SESSION");
		String stu_code = student.getStu_code();
		System.out.println("/student/updateStuMiMa.action"+stu_code);
		System.out.println("/student/updateStuMiMa.action"+update_stuIdentity);
		System.out.println("/student/updateStuMiMa.action"+update_stuPwd);
		int result = studentService.updateStuMiMa(update_stuIdentity,update_stuPwd,stu_code);
		if(result>0)
		{
			return "OK";
		}
		return "FALL";

	}
	//跳转至studentqingjia.jsp
	@RequestMapping("/student/tostudentqingjia.action")
	public String toStudentQingJia()
	{
		return"html/student/zaixianqingjia";
	}

	//学生请假请求
	@RequestMapping("/student/zaiXianQingJia.action")
	@RequiresRoles("student")
	@RequiresPermissions("qingjia:add")
	public String zaiXianQingJia(HttpServletRequest request,String qingjia_kechengname,String qingjia_shangkeshijian,String qingjia_shijian,String qingjia_yuanyin,Model model)
	{
		HttpSession session = request.getSession();
		Student user = (Student)session.getAttribute("USER_SESSION");
		System.out.println("user"+user);
		String stuId = user.getStu_id();
		//获取学生选课信息
		FieldList fieldList = studentService.selectStudentXuanKe(stuId, qingjia_kechengname);
		System.out.println(fieldList);
		//若学生选课信息不为空，则查询有没有该请假的课程
		if(fieldList!=null)
		{
			//查询请假的课程
			FieldList fieldList1 = studentService.selectKeChengBiao(qingjia_kechengname, stuId, qingjia_shangkeshijian);
			//若请假的课程不为空，则添加请假信息
			if(fieldList1!=null)
			{
				String qingjiaXuankeId=fieldList.getXuanke_id();
				String qingjiaKechengbiaoId=fieldList1.getKechengbiao_id();
				Date date = new Date();
				SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
				String qingjiaRiqi=dateFormat.format(date);
				System.out.println("当前时间"+dateFormat.format(date));
				int result=studentService.insertQingJiaXinXi(qingjiaRiqi, qingjia_shijian, qingjia_yuanyin, qingjiaXuankeId, qingjiaKechengbiaoId);
				if(result>0)
				{
				model.addAttribute("msg","请假成功，请等待辅导员批阅。");
				}
				else
				{
					model.addAttribute("msg","请假失败，请重试。");
				}
			}
			else
			{
				model.addAttribute("msg", "该课程不存在");
			}
		}
		else
		{
			model.addAttribute("msg", "您没有选该课程");
		}
		System.out.println("user.getStu_id();"+user.getStu_id());
		System.out.println(qingjia_kechengname);
		System.out.println(qingjia_shangkeshijian);
		System.out.println(qingjia_shijian);
		System.out.println(qingjia_yuanyin);
		return "html/student/zaixianqingjia";
	}
	//学生查询个人信息
	@RequestMapping("/student/gerenxinxi.action")
	@ResponseBody
	@RequiresRoles("student")
	@RequiresPermissions("student:query")
	public FieldList chaXunGeRenXinXi(HttpServletRequest request,Model model)
	{
		HttpSession session =request.getSession();
		Student student=(Student) session.getAttribute("USER_SESSION");
		String stuCoude = student.getStu_code();
		System.out.println("/student/gerenxinxi.action"+student.toString());
		FieldList fieldList=studentService.selectGeRenXinXiByCode(stuCoude);
		System.out.println("个人信息");
		System.out.println(fieldList);
		model.addAttribute("fieldList",fieldList);
		return fieldList;
	}
	//查询课程表信息
	@RequestMapping("/student/selectKeChengBiao.action")
	@RequiresRoles("student")
	@RequiresPermissions("kechengbiao:query")
	public String selectKeChengBiao(@RequestParam(defaultValue="1")int pageNum,@RequestParam(defaultValue="10")int rows,String jiaoshiName,String kechengName,String shangkeriqi,HttpServletRequest request,Model model)
	{
		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("USER_SESSION");
		String stuId = student.getStu_id();
		System.out.println(jiaoshiName);
		System.out.println(kechengName);
		System.out.println(shangkeriqi);
		PageHelper.startPage(pageNum,rows);
		List<FieldList> fieldList = studentService.selectShangKeXinXi(pageNum, rows, stuId, jiaoshiName, kechengName, shangkeriqi);
		PageInfo<FieldList> pageInfo = new PageInfo<>(fieldList);
		model.addAttribute("jiaoshiName",jiaoshiName);
		model.addAttribute("kechengName",kechengName);
		model.addAttribute("shangkeriqi",shangkeriqi);
		model.addAttribute("pageInfo",pageInfo);
		return "html/student/kechengbiao";
	}
	//查询公告信息
	@RequestMapping("/student/selectGongGaoXinXi.action")
	@RequiresRoles("student")
	@RequiresPermissions("gonggao:query")
	public String selectGongGaoXinXi(@RequestParam(defaultValue="1")int pageNum,@RequestParam(defaultValue="2")int rows,String gongGaoId,String gongGaoTitle,String gongGaoNeiRong,Model model)
	{
		System.out.println("/student/selectGongGaoXinXi.action");
		System.out.println(gongGaoId);
		System.out.println(gongGaoTitle);
		System.out.println(gongGaoNeiRong);
		PageHelper.startPage(pageNum,rows);
		List<FieldList> fieldList = studentService.selectStuGongGaoXin(pageNum, rows, gongGaoId, gongGaoTitle, gongGaoNeiRong);
		PageInfo<FieldList> pageInfo = new PageInfo<>(fieldList);
		model.addAttribute("pageInfo",pageInfo);
		model.addAttribute("pageInfo",pageInfo);
		model.addAttribute("gongGaoId",gongGaoId);
		model.addAttribute("gongGaoTitle",gongGaoTitle);
		model.addAttribute("gongGaoNeiRong",gongGaoNeiRong);
		return "html/student/gonggaoxinxi";
	}
}
