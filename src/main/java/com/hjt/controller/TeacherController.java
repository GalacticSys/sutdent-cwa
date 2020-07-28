package com.hjt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.hjt.pojo.FieldList;
import com.hjt.pojo.JiaoShi;
import com.hjt.service.TeacherService;
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
public class TeacherController {
	@Autowired
    TeacherService teacherService;
	//考勤信息查询
	@RequiresRoles("teacher")
	@RequiresPermissions("kaoqin:query")
	@RequestMapping("/teacher/kaoQinXinXi.action")
	public String teacherKaoQinXinXi(HttpServletRequest request,@RequestParam(defaultValue="1")int pageNum,@RequestParam(defaultValue="5")int rows,String stuCode,String banjiName,String kechengName,String kaoqinQingjiaRiqi,Model model)
	{
		HttpSession session = request.getSession();
		JiaoShi teacher=(JiaoShi)session.getAttribute("USER_SESSION");

		String jiaoShiId =teacher.getJiaoshi_id();
		System.out.println("STUDENT_SESSION中的jiaoShiname"+jiaoShiId);
		model.addAttribute("yongHuLeiXing","Teacher");
		System.out.println(stuCode);
		System.out.println(kechengName);
		System.out.println(kaoqinQingjiaRiqi);
		PageHelper.startPage(pageNum,rows);
		List<FieldList> fieldList = teacherService.teacherSelectKaoQinList(pageNum, rows, jiaoShiId, stuCode, banjiName, kechengName, kaoqinQingjiaRiqi);
		System.out.println(fieldList.toString());
		PageInfo<FieldList> pageInfo = new PageInfo<>(fieldList);
		model.addAttribute("pageInfo",pageInfo);
		model.addAttribute("stuCode",stuCode);
		model.addAttribute("banjiName",banjiName);
		model.addAttribute("kechengName",kechengName);
		model.addAttribute("kaoqinQingjiaRiqi",kaoqinQingjiaRiqi);
		return "html/teacher/kaoqinxinxi";
	}

	//请假信息查询
	@RequestMapping("/teacher/qingJiaXinXi.action")
	@RequiresRoles("teacher")
	@RequiresPermissions("qingjia:query")
	public String teacherQingJiaXinXi(HttpServletRequest request,@RequestParam(defaultValue="1")int pageNum,@RequestParam(defaultValue="5")int rows,String stuCode,String banjiName,String kechengName,String kaoqinQingjiaRiqi,Model model)
	{
		HttpSession session = request.getSession();
		JiaoShi teacher=(JiaoShi)session.getAttribute("USER_SESSION");
		String jiaoShiId =teacher.getJiaoshi_id();
		System.out.println("STUDENT_SESSION中的jiaoShiname"+jiaoShiId);
		model.addAttribute("yongHuLeiXing","Teacher");
		System.out.println(stuCode);
		System.out.println(kechengName);
		System.out.println(kaoqinQingjiaRiqi);
		PageHelper.startPage(pageNum,rows);
		List<FieldList> fieldList=teacherService.teacherSelectQingJiaList(pageNum, rows, jiaoShiId, stuCode, banjiName, kechengName, kaoqinQingjiaRiqi);
		System.out.println(fieldList.toString());
		PageInfo<FieldList> pageInfo = new PageInfo<>(fieldList);
		model.addAttribute("pageInfo",pageInfo);
		model.addAttribute("stuCode",stuCode);
		model.addAttribute("banjiName",banjiName);
		model.addAttribute("kechengName",kechengName);
		model.addAttribute("kaoqinQingjiaRiqi",kaoqinQingjiaRiqi);
		return "html/teacher/qingjiaxinxi";
	}
	//教师修改个人密码
	@RequestMapping("/teacher/updateTeaMiMa.action")
	@ResponseBody
	@RequiresRoles("teacher")
	@RequiresPermissions("teacher:edit")
	public String updateTeaMiMa(HttpServletRequest request,String update_teaIdentity,String update_teaPwd)
	{
		HttpSession session = request.getSession();
		JiaoShi teacher = (JiaoShi) session.getAttribute("USER_SESSION");
		String tea_id=teacher.getJiaoshi_id();
		System.out.println("update_teaIdentity"+update_teaIdentity);
		System.out.println("update_teaPwd"+update_teaPwd);
		System.out.println("tea_id"+tea_id);
		int result = teacherService.updateTeaMiMa(update_teaIdentity, update_teaPwd, tea_id);
		if(result<=0)
		{
			return "FALL";
		}
		return "OK";
	}
	//教师查询个人信息
	@RequiresRoles("teacher")
	@RequiresPermissions("teacher:query")
	@RequestMapping("/teacher/gerenxinxi.action")
	@ResponseBody
	public FieldList chaXunGeRenXinXi(HttpServletRequest request,Model model)
	{
		HttpSession session =request.getSession();
		JiaoShi teacher=(JiaoShi) session.getAttribute("USER_SESSION");
		String teaId = teacher.getJiaoshi_id();
		System.out.println("/teacher/gerenxinxi.action"+teaId);
		FieldList fieldList=teacherService.selectGeRenXinXiById(teaId);
		System.out.println("个人信息");
		System.out.println(fieldList);
		model.addAttribute("fieldList",fieldList);
		return fieldList;
	}
	/**
	 * 辅导员查询学生考勤情况
	 */
	@RequiresRoles("teacher")
	@RequiresPermissions("kaoqin:query")
	@RequestMapping("/fudaoyuan/kaoQinXinXi.action")
	public String fuDaoYuanKaoQinXinXi(HttpServletRequest request,@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="10")int rows,String stuCode,String banjiName,String kechengName,String kaoqinQingjiaRiqi,Model model)
	{
		HttpSession session = request.getSession();
		JiaoShi teacher=(JiaoShi)session.getAttribute("USER_SESSION");
		//获取教师id
		String jiaoShiId =teacher.getJiaoshi_id();
		System.out.println("STUDENT_SESSION中的jiaoShiId"+jiaoShiId);
		System.out.println(stuCode);
		System.out.println(kechengName);
		System.out.println(kaoqinQingjiaRiqi);
		PageHelper.startPage(page,rows);
		List<FieldList> fieldList = teacherService.fudaoyuanSelectKaoQinList(page, rows, jiaoShiId, stuCode, banjiName, kechengName, kaoqinQingjiaRiqi);
		System.out.println(fieldList.toString());
		PageInfo<FieldList> pageInfo = new PageInfo<>(fieldList);
		model.addAttribute("yongHuLeiXing","Fudaoyuan");
		model.addAttribute("pageInfo",pageInfo);
		model.addAttribute("stuCode",stuCode);
		model.addAttribute("banjiName",banjiName);
		model.addAttribute("kechengName",kechengName);
		model.addAttribute("kaoqinQingjiaRiqi",kaoqinQingjiaRiqi);
		return "html/Instructor/kaoqinxinxi";
	}
	/**
	 * 辅导员查询学生请假情况
	 */

	@RequiresRoles("teacher")
	@RequiresPermissions("qingjia:query")
	@RequestMapping("/fudaoyuan/qingJiaXinXi.action")
	public String fuDaoYuanQingJiaXinXi(HttpServletRequest request,@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="10")int rows,String stuCode,String banjiName,String kechengName,String kaoqinQingjiaRiqi,Model model)
	{
		HttpSession session = request.getSession();
		JiaoShi teacher=(JiaoShi)session.getAttribute("USER_SESSION");
		//获取教师id
		String jiaoShiId =teacher.getJiaoshi_id();
		System.out.println("STUDENT_SESSION中的jiaoShiId"+jiaoShiId);
		model.addAttribute("yongHuLeiXing","Fudaoyuan");
		System.out.println(stuCode);
		System.out.println(kechengName);
		System.out.println(kaoqinQingjiaRiqi);
		PageHelper.startPage(page,rows);
		List<FieldList> fieldList=teacherService.fudaoyuanSelectQingJiaList(page, rows, jiaoShiId, stuCode, banjiName, kechengName, kaoqinQingjiaRiqi);
		PageInfo<FieldList> pageInfo = new PageInfo<>(fieldList);
		System.out.println(fieldList.toString());
		model.addAttribute("pageInfo",pageInfo);
		model.addAttribute("stuCode",stuCode);
		model.addAttribute("banjiName",banjiName);
		model.addAttribute("kechengName",kechengName);
		model.addAttribute("kaoqinQingjiaRiqi",kaoqinQingjiaRiqi);
		return "html/Instructor/qingjiaxinxi";
	}
	//辅导员审批学生请假
	@RequiresRoles("teacher")
	@RequiresPermissions("qingjia:edit")
	@RequestMapping("/fudaoyuan/shifoutongyi.action")
	@ResponseBody
	public String fuDaoYuanPiJia(String shenpixinxi,String qingjiaId)
	{
		int piJiaInfo;
		System.out.println("/fudaoyuan/shifoutongyi.action"+shenpixinxi+"========"+qingjiaId);
		if(shenpixinxi.equals("tongyi"))
		{
			piJiaInfo=0;
			int result = teacherService.fuDaoYuanPiJia(Integer.parseInt(qingjiaId),piJiaInfo);
			if(result>0)
			{
				return "OK";
			}
			else
			{
				return "FALL";
			}
		}
		else
		{
			piJiaInfo=1;
			int result = teacherService.fuDaoYuanPiJia(Integer.parseInt(qingjiaId),piJiaInfo);
			if(result>0)
			{
				return "NotOK";
			}
			else
			{
				return "FALL";
			}
		}
	}
	//查询公告信息
	@RequiresRoles("teacher")
	@RequiresPermissions("gongao:query")
	@RequestMapping("/jiaoshiandfudaoyuan/selectGongGaoXinXi.action")
	public String selectGongGaoXinXi(@RequestParam(defaultValue="1")int pageNum,@RequestParam(defaultValue="5")int rows,String gongGaoId,String gongGaoTitle,String gongGaoNeiRong,Model model)
	{
		PageHelper.startPage(pageNum,rows);
		List<FieldList> fieldList=teacherService.selectTeaGongGaoXinXi(pageNum, rows, gongGaoId, gongGaoTitle, gongGaoNeiRong);
		PageInfo<FieldList> pageInfo = new PageInfo<>(fieldList);
		model.addAttribute("pageInfo",pageInfo);
		model.addAttribute("yongHuLeiXing","jiaoshi");
		return "html/teacher/gonggaoxinxi";
	}
	//教师和辅导员查询课程表信息

	@RequiresRoles("teacher")
	@RequiresPermissions("kechengbiao:query")
	@RequestMapping("/jiaoshi/selectKeChengBiao.action")
	public String selectShouKeXinXi(@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="5")int rows,String banjiName,String kechengName,String shangkeriqi,HttpServletRequest request,Model model)
	{
		HttpSession session = request.getSession();
		JiaoShi teacher = (JiaoShi)session.getAttribute("USER_SESSION");
		String jiaoshiId = teacher.getJiaoshi_id();
		PageHelper.startPage(page,rows);
		List<FieldList> fieldList=teacherService.selectShangKeXinXi(page, rows, jiaoshiId, banjiName, kechengName, shangkeriqi);
		PageInfo<FieldList> pageInfo = new PageInfo<>(fieldList);
		model.addAttribute("pageInfo",pageInfo);
		return "html/teacher/kechengbiao";
	}
}
