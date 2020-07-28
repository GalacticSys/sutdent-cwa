package com.hjt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.hjt.pojo.FieldList;
import com.hjt.service.GuanLiYuanService;
import com.hjt.pojo.GuanLiYuan;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class GuanLiYuanController
{
	@Autowired
    GuanLiYuanService guanLiYuanService;
	//管理员修改个人密码
	@RequestMapping(value="/guanliyuan/updateGuanLiYuanMiMa.action",method=RequestMethod.POST)
	@ResponseBody
	@RequiresRoles("admin")
	@RequiresPermissions("admin:edit")
	public String updateGuanLiYuanMiMa(String update_guanLiYuanIdentity,String update_guanLiYuanPwd)
	{
		System.out.println(update_guanLiYuanIdentity);
		System.out.println(update_guanLiYuanPwd);
		int result=guanLiYuanService.updateGuanLiYuanMiMa(update_guanLiYuanIdentity, update_guanLiYuanIdentity);
		if(result>0)
		{
			return "OK";
		}
		else
		{
			return "FALL";
		}
	}
	//管理员查看个人信息
	@RequestMapping("/guanliyuan/gerenxinxi.action")
	@ResponseBody
	@RequiresRoles("admin")
	@RequiresPermissions("admin:query")
	public GuanLiYuan guanLiYuanGeRenXinXi(HttpServletRequest request)
	{

		HttpSession session = request.getSession();
		GuanLiYuan guanLiYuan = (GuanLiYuan) session.getAttribute("USER_SESSION");
		GuanLiYuan guanLiYuan1 = guanLiYuanService.selectGeRenXinXiByCode(guanLiYuan.getGuanliyuan_code());
		return guanLiYuan1;
	}

	//辅导员查询学生信息、获取班级和辅导员信息

	@RequestMapping("/guanliyuan/xueShengXinXi.action")
	@RequiresRoles("admin")
	@RequiresPermissions("student:query,teacher:query")
	public String xueShengXinxi(@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="5")int rows,String stuCode,String banjiName,String jiaoshiName,Model model)
	{
		//获取学生信息
		PageHelper.startPage(page,rows);
		List<FieldList> fieldList = guanLiYuanService.selectStudentXinXiList(page, rows, stuCode, banjiName, jiaoshiName);
		System.out.println("/guanliyuan/xueShengXinXi.action  fieldList"+fieldList);
		PageInfo<FieldList> pageInfo = new PageInfo<>(fieldList);
		model.addAttribute("pageInfo",pageInfo);
		//获取班级信息
		List<FieldList> banJiAndFuDaoYuan= guanLiYuanService.selectBanJiAndFuDaoYuanXinXi();
		System.out.println("/guanliyuan/xueShengXinXi.action  banJiXinXi"+banJiAndFuDaoYuan);
		model.addAttribute("banJiAndFuDaoYuan",banJiAndFuDaoYuan);
		//获取辅导员信息
		List<FieldList> FuDaoYuanXinXi= guanLiYuanService.selectFuDaoYuanXinXi();
		model.addAttribute("FuDaoYuanXinXi",FuDaoYuanXinXi);
		FuDaoYuanXinXi.stream().parallel().forEach(System.out::println);
		model.addAttribute("stuCode",stuCode);
		model.addAttribute("banjiName",banjiName);
		model.addAttribute("jiaoshiName",jiaoshiName);

		return "html/Administrators/xueshengxinxi";
	}

	//根据学生id获取学生信息
	@RequestMapping("/guanliyuan/getStuXinXiById.action")
	@ResponseBody
	@RequiresRoles("admin")
	@RequiresPermissions("student:query")
	public FieldList getStuXinXiById(String stuId,Model model)
	{
		System.out.println("/guanliyuan/getStuXinXiById.action"+stuId);
		//根据根据学生id获取学生信息
		FieldList fieldList = guanLiYuanService.selectStudentXinXiByCode(stuId);
		model.addAttribute("fieldList",fieldList);
		System.out.println("/guanliyuan/getStuXinXiById.action"+fieldList);
		return fieldList;
	}

	//修改学生信息
	@RequestMapping("/guanliyuan/xiuGaiStuXinXi.action")
	@ResponseBody
	@RequiresRoles("admin")
	@RequiresPermissions("student:edit")
	public String XiuGaiStuXinXi(String updateStuId,String updateStuCode,String updateStuName,String updateStuIdentity,String updateStuXingBie,String updateStuBanJiName,String updateStuFuDaoYuanName)
	{
		System.out.println(updateStuCode);
		System.out.println(updateStuName);
		System.out.println(updateStuIdentity);
		System.out.println(updateStuXingBie);
		System.out.println(updateStuBanJiName);
		System.out.println(updateStuFuDaoYuanName);
		int result = guanLiYuanService.updateStudentXinXi(updateStuId,updateStuCode, updateStuName, updateStuIdentity, updateStuXingBie, updateStuBanJiName);
		if(result>0)
		{
			return "OK";
		}
		else
		{
			return "FALL";
		}
	}
	//管理员新建学生信息
	@RequiresRoles("admin")
	@RequiresPermissions("student:add")
	@RequestMapping("/guanliyuan/createStuXinXi.action")
	@ResponseBody
	public String CreateStuXinXi(String createStuCode,String createStuName,String createStuIdentity,String createStuNianLing,String createStuXingBie,String createStuBanJiName,String createStuFuDaoYuanName)
	{
		System.out.println("/guanliyuan/createStuXinXi.action");
		System.out.println(createStuCode);
		System.out.println(createStuName);
		System.out.println(createStuIdentity);
		System.out.println(createStuNianLing);
		System.out.println(createStuXingBie);
		System.out.println(createStuBanJiName);
		System.out.println(createStuFuDaoYuanName);
		int result = guanLiYuanService.createStudentXinXi(createStuName, createStuNianLing, createStuXingBie, createStuCode, createStuIdentity, createStuBanJiName);
		if(result>0)
		{
			return "OK";
		}
		return "FALL";
	}
	//管理员删除学生信息
	@RequiresRoles("admin")
	@RequiresPermissions("student:delete")
	@RequestMapping("/guanliyuan/deleteStuXinXi.action")
	@ResponseBody
	public String deleteStuXinXi(String stuId)
	{
		System.out.println("/guanliyuan/deleteStuXinXi.action"+stuId);
		int result = guanLiYuanService.deleteStuXinXi(Integer.parseInt(stuId));
		if(result>0)
		{
			return "OK";
		}
		else
		{
			return "FALL";
		}
	}
	//管理员获取教师信息
	@RequestMapping("/guanliyuan/jiaoShiXinXi.action")
	@RequiresRoles("admin")
	@RequiresPermissions("teacher:query")
	public String jiaoShiXinxi(@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="5")int rows,String teaCode,String jiaoShiName,String jiaoShiLeiBie,Model model)
	{
		System.out.println("/guanliyuan/jiaoShiXinXi.action"+teaCode);
		System.out.println("/guanliyuan/jiaoShiXinXi.action"+jiaoShiName);
		System.out.println("/guanliyuan/jiaoShiXinXi.action"+jiaoShiLeiBie);
		PageHelper.startPage(page,rows);
		List<FieldList> fieldList = guanLiYuanService.selectTeadentXinXiList(page, rows, teaCode, jiaoShiName, jiaoShiLeiBie);
		System.out.println("/guanliyuan/jiaoShiXinXi.action"+fieldList);
		PageInfo<FieldList> pageInfo = new PageInfo<>(fieldList);
		model.addAttribute("pageInfo",pageInfo);
		model.addAttribute("teaCode",teaCode);
		model.addAttribute("jiaoShiName",jiaoShiName);
		model.addAttribute("jiaoShiLeiBie",jiaoShiLeiBie);
		return "html/Administrators/jiaoshixinxi";
	}

	//管理员根据教师id获取教师信息
	@RequiresRoles("admin")
	@RequiresPermissions("teacher:query")
	@RequestMapping("/guanliyuan/getTeaXinXiById.action")
	@ResponseBody
	public FieldList getTeaXinXiById(String teaId)
	{
		System.out.println(teaId);
		FieldList fieldList = guanLiYuanService.selectTeacherXinXiById(Integer.parseInt(teaId));
		System.out.println(fieldList);
		return fieldList;
	}

	//管理员确定修改教师信息
	@RequiresRoles("admin")
	@RequiresPermissions("teacher:edit")
	@RequestMapping("/guanliyuan/xiuGaiTeaXinXi.action")
	@ResponseBody
	public String iuGaiTeaXinXiById(String updateTeaId,String updateTeaCode,String updateTeaName,String updateTeaIdentity,String updateTeaNianLing,String updateTeaXingBie,String updateTeaFuDaoYuan)
	{
		System.out.println("/guanliyuan/xiuGaiTeaXinXi.action");
		System.out.println(updateTeaId);
		System.out.println(updateTeaCode);
		System.out.println(updateTeaName);
		System.out.println(updateTeaIdentity);
		System.out.println(updateTeaNianLing);
		System.out.println(updateTeaXingBie);
		System.out.println(updateTeaFuDaoYuan);
		int result = guanLiYuanService.updateTeacherXinXi(updateTeaName, updateTeaCode, updateTeaXingBie, updateTeaNianLing, updateTeaIdentity, updateTeaFuDaoYuan, updateTeaId);
		if(result>0)
		{
			return "OK";
		}
		else
		{
			return "FALL";
		}
	}

	@RequiresRoles("admin")
	@RequiresPermissions("teacher:add")
	@RequestMapping("/guanliyuan/XinZengTeaXinXi.action")
	@ResponseBody
	public String XinZengTeaXinXi(String createTeaName,String createTeaCode,String createTeaXingBie,String createTeaNianLing,String createTeaIdentity,String createTeaFuDaoYuan)
	{
		System.out.println("/guanliyuan/XinZengTeaXinXi.action");
		System.out.println(createTeaCode);
		System.out.println(createTeaName);
		System.out.println(createTeaIdentity);
		System.out.println(createTeaNianLing);
		System.out.println(createTeaXingBie);
		System.out.println(createTeaFuDaoYuan);
		int result = guanLiYuanService.createTeacherXinXi(createTeaName, createTeaCode, createTeaXingBie, createTeaNianLing, createTeaIdentity, createTeaFuDaoYuan);
		if(result>0)
		{
			return "OK";
		}
		else
		{
			return "FALL";
		}
	}


	@RequiresRoles("admin")
	@RequiresPermissions("teacher:delete")
	@RequestMapping("/guanliyuan/deleteTeaXinXi.action")
	@ResponseBody
	public  String deleteTeaXinXi(String teaId)
	{
		System.out.println("guanliyuan/deleteTeaXinXi.action"+teaId);
		int result = guanLiYuanService.deleteTeacherXinXi(Integer.parseInt(teaId));
		if(result>0)
		{
			return "OK";
		}
		else
		{
			return "FALL";
		}
	}
	@RequestMapping("/guanliyuan/gongGaoXinXi.action")
	@RequiresRoles("admin")
	@RequiresPermissions("gonggao:query")
	public String selectGongGaoXinXi(@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="2")int rows,String gongGaoId,String gongGaoTitle,String gongGaoNeiRong,Model model)
	{
		System.out.println("/guanliyuan/gongGaoXinXi.action"+gongGaoId);
		System.out.println("/guanliyuan/gongGaoXinXi.action"+gongGaoTitle);
		System.out.println("/guanliyuan/gongGaoXinXi.action"+gongGaoNeiRong);
		PageHelper.startPage(page,rows);
		List<FieldList> fieldList = guanLiYuanService.selectAllGongGao(page, rows, gongGaoId, gongGaoTitle, gongGaoNeiRong);
		PageInfo<FieldList> pageInfo = new PageInfo<>(fieldList);
		model.addAttribute("pageInfo",pageInfo);
		model.addAttribute("gongGaoId",gongGaoId);
		model.addAttribute("gongGaoTitle",gongGaoTitle);
		model.addAttribute("gongGaoNeiRong",gongGaoNeiRong);
		return "html/Administrators/gonggaoxinxi";
	}

	@RequiresRoles("admin")
	@RequiresPermissions("gongao:query")
	@RequestMapping("/guanliyuan/getGongGaoXinXiById.action")
	@ResponseBody
	public FieldList getGongGaoXinXi(String gongGaoId)
	{
		System.out.println("/guanliyuan/getGongGaoXinXiById.action"+gongGaoId);
		FieldList fieldList = guanLiYuanService.selectGongGaoById(Integer.parseInt(gongGaoId));
		return fieldList;
	}

	@RequiresRoles("admin")
	@RequiresPermissions("gonggao:edit")
	@RequestMapping("/guanliyuan/xiuGaiGongGaoXinXiById.action")
	@ResponseBody
	public String xiuGaoGongGaoXinXi(String updateGongGaoId,String updateGongGaoTitle,String updateGongGaoNeiRong)
	{
		System.out.println("/guanliyuan/getGongGaoXinXiById.action"+updateGongGaoId);
		System.out.println("/guanliyuan/getGongGaoXinXiById.action"+updateGongGaoTitle);
		System.out.println("/guanliyuan/getGongGaoXinXiById.action"+updateGongGaoNeiRong);
		int result = guanLiYuanService.updateGongGaoById(updateGongGaoId, updateGongGaoTitle, updateGongGaoNeiRong);
		if(result>0)
		{
			return "OK";
		}
		else
		{
			return "FALL";
		}
	}

	@RequiresRoles("admin")
	@RequiresPermissions("gonggao:add")
	@RequestMapping("/guanliyuan/xinZengGongGaoXinXi.action")
	@ResponseBody
	public String createGongGaoXinXi(String createGongGaoTitle,String createGongGaoNeiRong,HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		GuanLiYuan guanLiYuan = (GuanLiYuan)session.getAttribute("USER_SESSION");
		System.out.println("session中的用户"+session);
		String gongGaoGuanLiYuanId = guanLiYuan.getGuanliyuan_id();
		System.out.println(createGongGaoTitle);
		System.out.println(createGongGaoNeiRong);
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		String gonggaoFaQiRiqi=dateFormat.format(date);
		int result = guanLiYuanService.insertGongGaoXinXi(gongGaoGuanLiYuanId,createGongGaoTitle, createGongGaoTitle,gonggaoFaQiRiqi);
		if(result>0)
		{
			return "OK";
		}
		else
		{
			return "FALL";
		}

	}
	@RequestMapping("/guanliyuan/deleteGongGaoXinXi.action")
	@ResponseBody
	@RequiresRoles("admin")
	@RequiresPermissions("gonggao:delete")
	public String deleteGongGaoXinXi(String deleteGongGaoId)
	{
		System.out.println("/guanliyuan/deleteGongGaoXinXi.action"+deleteGongGaoId);
		int result = guanLiYuanService.deleteGongGaoXinXi(Integer.parseInt(deleteGongGaoId));
		if(result>0)
		{
			return "OK";
		}
		else
		{
			return "FALL";
		}
	}
}
